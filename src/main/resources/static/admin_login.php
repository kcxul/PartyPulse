<?php
// Include database connection
include('db_connection.php');

// Get the data from the frontend (POST request)
$data = json_decode(file_get_contents("php://input"));

// Check if the required fields are present
if (isset($data->username) && isset($data->password)) {
    $username = $data->username;
    $password = $data->password;

    // SQL query to select the user with the provided username
    $sql = "SELECT * FROM users WHERE username = ?";

    // Prepare the SQL statement
    if ($stmt = $conn->prepare($sql)) {
        // Bind the username parameter to the prepared statement
        $stmt->bind_param("s", $username);

        // Execute the statement
        $stmt->execute();

        // Get the result
        $result = $stmt->get_result();

        // Check if a user with this username exists
        if ($result->num_rows > 0) {
            // Fetch the user data
            $user = $result->fetch_assoc();

            // Verify the password (assuming it's hashed in the database)
            if (password_verify($password, $user['password'])) {
                // Successful login
                $response = [
                    'status' => 'success',
                    'message' => 'Login successful'
                ];
            } else {
                // Invalid password
                $response = [
                    'status' => 'error',
                    'message' => 'Invalid username or password'
                ];
            }
        } else {
            // No user found with the given username
            $response = [
                'status' => 'error',
                'message' => 'Invalid username or password'
            ];
        }

        // Close the statement
        $stmt->close();
    } else {
        // Database query failed
        $response = [
            'status' => 'error',
            'message' => 'Error: Could not execute the query'
        ];
    }

    // Close the database connection
    $conn->close();

} else {
    // Missing data
    $response = [
        'status' => 'error',
        'message' => 'Error: Username and password are required'
    ];
}

// Return the response as JSON
echo json_encode($response);
?>
