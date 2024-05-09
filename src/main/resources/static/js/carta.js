const mainDiv = document.getElementById('mainDiv');
const hiddenDiv = document.getElementById('hiddenDiv');
let isHidden = true;

mainDiv.addEventListener('click', function() {
    if (isHidden) {
        hiddenDiv.style.display = 'block';
        isHidden = false;
    } else {
        hiddenDiv.style.display = 'none';
        isHidden = true;
    }
});
