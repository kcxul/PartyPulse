// Signup
function handleSignup() {
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;
  const email = document.getElementById("email").value;
  const data = { username, password, email };

  console.log("Username:", username);
  console.log("Password:", password);
  console.log("Email:", email);

  // Simulate checking if username or email already exists
  const existingUsers = [
    { username: "user1", email: "user1@example.com" },
    { username: "admin", email: "admin@example.com" },
  ];

  const usernameExists = existingUsers.some((user) => user.username === username);
  const emailExists = existingUsers.some((user) => user.email === email);

  // Logs for debugging
  console.log("Username exists:", usernameExists);
  console.log("Email exists:", emailExists);

  if (usernameExists || emailExists) {
    const alertBox = document.createElement("div");
    alertBox.className = "custom-alert";
    alertBox.textContent = usernameExists ? "Username already exists" : "Email already exists";
    document.body.appendChild(alertBox);
    setTimeout(() => {
      alertBox.remove();
    }, 3000);
  } else {
    // Simulate successful signup
    const alertBox = document.createElement("div");
    alertBox.className = "custom-alert-success";
    alertBox.textContent = "Signup successful!";
    document.body.appendChild(alertBox);
    setTimeout(() => {
      alertBox.remove();
    }, 3000);
  }
}

// Ensure the function is called on form submission
document.getElementById("signup-form").addEventListener("submit", function (event) {
  event.preventDefault();
  handleSignup();
});
