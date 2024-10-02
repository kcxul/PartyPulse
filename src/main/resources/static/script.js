console.log("Script loaded from script.js");

// Navbar hide on scroll down, show on scroll up
document.addEventListener("DOMContentLoaded", function () {
  let lastScrollTop = 0;
  const navbar = document.getElementById("navbar");

  navbar.style.transition = "top 0.3s ease-in-out";

  window.addEventListener("scroll", function () {
    let scrollTop = document.documentElement.scrollTop;
    if (scrollTop > lastScrollTop) {
      // Scrolling down
      navbar.style.top = "-50px"; // Navbar height
    } else {
      // Scrolling up
      navbar.style.top = "0";
    }
    lastScrollTop = scrollTop;
  });
});

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
        }, 2000);
      }
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}
