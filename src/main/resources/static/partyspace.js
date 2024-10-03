document.addEventListener("DOMContentLoaded", function () {
  const messageInput = document.getElementById("message-input");
  const sendButton = document.getElementById("send-button");
  const chatboxMessages = document.getElementById("chatbox-messages");

  sendButton.addEventListener("click", function () {
    const messageText = messageInput.value.trim();
    if (messageText !== "") {
      const messageElement = document.createElement("p");
      messageElement.innerHTML = `<strong>You:</strong> ${messageText}`;
      chatboxMessages.appendChild(messageElement);
      messageInput.value = "";
      chatboxMessages.scrollTop = chatboxMessages.scrollHeight;
    }
  });

  messageInput.addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
      sendButton.click();
    }
  });
});

document.addEventListener("DOMContentLoaded", function () {
  const nameInput = document.getElementById("partyspace-name");
  const nameCharCount = document.getElementById("name-char-count");
  const descriptionInput = document.getElementById("partyspace-description");
  const descriptionCharCount = document.getElementById("description-char-count");
  const iconInput = document.getElementById("partyspace-icon");
  const iconDimensionWarning = document.getElementById("icon-dimension-warning");

  const NAME_MAX_LENGTH = 32;
  const DESCRIPTION_MAX_LENGTH = 2048;

  nameInput.addEventListener("input", function () {
    if (nameInput.value.length > NAME_MAX_LENGTH) {
      nameInput.value = nameInput.value.slice(0, NAME_MAX_LENGTH);
    }
    nameCharCount.textContent = `${nameInput.value.length}/${NAME_MAX_LENGTH}`;
  });

  descriptionInput.addEventListener("input", function () {
    if (descriptionInput.value.length > DESCRIPTION_MAX_LENGTH) {
      descriptionInput.value = descriptionInput.value.slice(0, DESCRIPTION_MAX_LENGTH);
    }
    descriptionCharCount.textContent = `${descriptionInput.value.length}/${DESCRIPTION_MAX_LENGTH}`;
  });

  iconInput.addEventListener("change", function () {
    const file = iconInput.files[0];
    if (file) {
      const img = new Image();
      img.onload = function () {
        if (img.width > 512 || img.height > 512) {
          iconDimensionWarning.style.display = "block";
          iconInput.value = ""; // Clear the input
        } else {
          iconDimensionWarning.style.display = "none";
        }
      };
      img.src = URL.createObjectURL(file);
    }
  });
});
