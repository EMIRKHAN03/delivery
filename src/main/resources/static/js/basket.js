// Get references to HTML elements
const addButton = document.querySelectorAll('.btn')[0];
const subtractButton = document.querySelectorAll('.btn')[1];
const countElement = document.querySelector('.count');

let count = parseInt(countElement.textContent);

// Event listeners for the add and subtract buttons
addButton.addEventListener('click', () => {
    count += 1;
    countElement.textContent = count;
});

subtractButton.addEventListener('click', () => {
    if (count > 0) {
        count -= 1;
        countElement.textContent = count;
    }
});

// Additional code for handling remove, save for later, and checkout functionality
// ...

