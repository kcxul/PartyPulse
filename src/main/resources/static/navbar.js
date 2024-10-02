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
