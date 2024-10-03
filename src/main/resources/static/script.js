console.log("Script loaded from script.js");

// Login
function handleLogin(event) {
  event.preventDefault();
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;
  const data = { username, password };

  // Test values
  if (username === "user1" && password === "password") {
    data.status = "success";
    data.role = "user";
  } else if (username === "admin" && password === "password") {
    data.status = "success";
    data.role = "admin";
  } else {
    data.status = "failure";
  }

  // Simulate server response
  new Promise((resolve) => resolve(data))
    .then((data) => {
      if (data.status === "success") {
        if (data.role === "admin") {
          window.location.href = "/adminboard.html";
        } else {
          window.location.href = "/partyspace.html";
        }
      } else {
        const alertBox = document.createElement("div");
        alertBox.className = "custom-alert";
        alertBox.textContent = "Invalid username or password";
        document.body.appendChild(alertBox);
        setTimeout(() => {
          alertBox.remove();
        }, 3000);
      }
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}