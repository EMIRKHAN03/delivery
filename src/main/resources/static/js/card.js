function toggleDiv() {
    var option = document.getElementById("optionSelect").value;
    var div = document.getElementById("myDiv");

    if (option === "Card") {
        div.style.display = "block";
    } else if (option === "Cash") {
        div.style.display = "none";
    }
}