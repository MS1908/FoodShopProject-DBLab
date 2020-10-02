
$(document).ready(function() {
    console.log("Header check login");
    if (tokenHeader_value === null || tokenHeader_value === "") return;
    $('#authen-indicators').html(`<span class="text">Welcome, ${localStorage.getItem("username")}</span>`);
});