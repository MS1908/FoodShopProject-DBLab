$(document).ready(function () {
    $('#login-form').submit(function (event) {
        event.preventDefault();
        onSubmit();
    });

    $('#btn-forget').on("click", function () {
        forget();
    });
});

//action when click or enter
function onSubmit() {

    var username = $("#uname").val();
    var password = $("#psw").val();


    if (username.length === 0 || password.length === 0) {
        alert("email or password is empty!");
        event.preventDefault();
        return;
    }

    const loginForm = {
        username: username,
        password: password
    };
    console.log(loginForm);

    callPostAjax("api/v1/public/app-user/login", loginForm)
        .then(rs => {
            if (rs.result === "not found") {
                $('#fail-noti').html(rs.data);
            } else {
                // succeed handle : save token, alert success msg -> redirect login
                rs = rs.data;
                localStorage.setItem("token", rs.token);
                localStorage.setItem("username", loginForm.username);
                document.cookie = `token=${rs.token}`;
                window.sessionStorage.setItem("token", rs.token);
                alert('Login successfully');
                if (rs.role === "ROLE_ADMIN") {
                    window.location.href = "/admin";
                }
                else {
                    var redirect = sessionStorage.getItem("previousPage") === null ? "/home" : sessionStorage.getItem("previousPage");
                    sessionStorage.setItem("previousPage", "/home");
                    window.location.href = redirect;
                }
            }
        })
        .catch((err => {
            console.log(err)
        }));
}

function forget() {
    // let username = $('#forget-uname');
    //
    // let email = $('#forget-email');
    //
    if (username.length > 0 && email.length > 0) {
        callPostAjax(`api/v1/public/forget-password?username=${username}&email=${email}`).then(rs => {
            alert("Check email to receive new password!");
        }).catch(err => {
            console.log(err);
            alert("Failed to send email!");
        })
    } else {
        alert("Please enter all required information.");
    }
    let username = $('#forget-uname');
    let email = $('#forget-email');



}