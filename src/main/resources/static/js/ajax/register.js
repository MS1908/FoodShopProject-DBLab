$(document).ready(function () {
    $('#register-form').submit(function (event) {
        event.preventDefault();
        onSubmit();
    });
});

function onSubmit() {
    var fullname = $('#fullname').val();
    var username = $('#uname').val();
    var address = $('#address').val();
    var email = $('#email').val();
    var password = $('#psw').val();
    var cfpassword = $('#cfpsw').val();
    var phone = $('#phone').val();

    $('#fail-noti').html('');
    // check validity of params
    if (username.trim().length === 0 || password.trim().length === 0) {
        // invalid input handle : alert to user, show message
        alert('Missing username or password');
        return;
    } else if (password !== cfpassword) {
        alert('Your password seems a bit inconsistent');
        return;
    } else if (!validateEmail(email)) {
        alert("This email might not exist on God's green earth");
        return;
    }

    const registerForm = {
        fullname: fullname,
        username: username,
        password: password,
        address: address,
        email: email,
        phone: phone
    }
    console.log(registerForm);

    callPostAjax("api/v1/public/app-user/register", registerForm)
        .then(rs => {
            if (rs.result === "Register failed") {
                $('#fail-noti').html(rs.data);
            } else {
                // succeed handle : save token, alert success msg -> redirect login
                alert('Register successfully');
                window.location.href = "/login";
            }
        })
        .catch((err => {
            console.log(err)
        }));
}

function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}