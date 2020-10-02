$(function() {
    if (tokenHeader_value === null || tokenHeader_value === "") return;
    $('#menu-list li:last').after(`<li class="nav-item"><a onclick="return logout()" class="nav-link">Log Out</a></li>`);
});

function logout() {
    callGetAjax("/logout");
    localStorage.setItem("token", "");
    localStorage.setItem("username", "");
    window.location.href = "/home";
}