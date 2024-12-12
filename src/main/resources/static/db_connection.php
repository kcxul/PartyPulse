<?php
$servername = "localhost";  // or your database server address
$username = "your_username";  // your MySQL username
$password = "your_password";  // your MySQL password
$dbname = "your_database";  // your database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
