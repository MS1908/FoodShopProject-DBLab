<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="resources/js/ajax/register.js"></script>

<div class="hero-wrap hero-bread" style="background-image: url('resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <h1 class="mb-0 bread">Register</h1>
            </div>
        </div>
    </div>
</div>

<section class = "ftco-section">
    <form id="register-form">
        <div class = "container">
            <div class="form-group">
                <label for="fullname">Fullname *</label>
                <input type="text" class="form-control" id="fullname" required>
            </div>
            <div class="form-group">
                <label for="uname">Username *</label>
                <input type="text" class="form-control" id="uname" required>
            </div>
            <div class="form-group">
                <label for="address">Address *</label>
                <input type="text" class="form-control" id="address" required>
            </div>
            <div class="form-group">
                <label for="email">Email *</label>
                <input type="text" class="form-control" id="email" required>
            </div>
            <div class="form-group">
                <label for="psw">Password *</label>
                <input type="password" class="form-control" id="psw" required>
            </div>
            <div class="form-group">
                <label for="cfpsw">Confirmed Password *</label>
                <input type="password" class="form-control" id="cfpsw" required>
            </div>
            <div class="form-group">
                <label id="fail-noti" style="color: #ff0000"></label>
            </div>
            <div class="form-group">
                <label for="phone">Phone *</label>
                <input type="text" class="form-control" id="phone" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Register" class="btn py-3 px-4 btn-primary">
            </div>
        </div>
    </form>
</section>

