<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/ajax/login.js"></script>

<div class="hero-wrap hero-bread" style="background-image: url('resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <h1 class="mb-0 bread">Login</h1>
            </div>
        </div>
    </div>
</div>

<section class = "ftco-section">
    <form id="login-form">
        <div class = "container">
            <div class="form-group">
                <label for="uname">Username *</label>
                <input type="text" class="form-control" id="uname" required>
            </div>
            <div class="form-group">
                <label for="psw">Password *</label>
                <input type="password" class="form-control" id="psw" required>
            </div>
            <div class="form-group">
                <label id="fail-noti" style="color: #ff0000"></label>
            </div>
            <div class="form-group">
                <input type="submit" value="Login" class="btn py-3 px-4 btn-primary">
            </div>
            <div class="form-group">
                <a id = "btn_forget" class = "btn py-3 px-4 btn-warning" onclick = "window.location='/forget-password'">Forgot password</a>
            </div>
        </div>
    </form>
</section>
