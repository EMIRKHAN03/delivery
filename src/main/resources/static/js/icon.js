// function changeIcon() {
//     var icon = document.getElementById('icon');
//     icon.style.backgroundImage = "url(https://cdn-icons-png.flaticon.com/512/5218/5218542.png)";
// }
function toggleDiv() {
    var div = document.getElementById("myDiv");
    var button = document.getElementById("icon");
    var icon = document.getElementById("ico");


    if (div.style.display === "none") {
        div.style.display = "block";
        button.style.backgroundImage = "url(https://cdn-icons-png.flaticon.com/512/54/54972.png)";
        button.classList.add("second-icon");
    } else {
        div.style.display = "none";
        button.style.backgroundImage  = "url(https://cdn-icons-png.flaticon.com/512/5218/5218542.png)";
        button.classList.remove("second-icon");
    }
    if (icon.classList.contains("first-icon")) {
        icon.classList.remove("first-icon");
        icon.classList.add("second-icon");
    } else {
        icon.classList.remove("second-icon");
        icon.classList.add("first-icon");
    }
}
