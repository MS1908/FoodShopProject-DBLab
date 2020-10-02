<%--
  Created by IntelliJ IDEA.
  User: hieuv
  Date: 07-Dec-19
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../library/library_css.jsp" %>
    <!-- Font-icon css-->

    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>login</title>
    <!-- ajax login -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js">

    </script>
    <script src="resources/js/common.js"></script>
    <script src="resources/js/ajax/login.js"></script>

</head>
<body>

<section class="material-half-bg">
    <div class="cover"></div>
</section>
<section class="login-content">
    <%--    <div class="logo">--%>
    <%--        <img src="resources/img/bksoftwareLogo.png"--%>
    <%--             alt="" class="img-fluid">--%>
    <%--    </div>--%>
        <div class="login-box">
            <div class="login-form">
                <div class="app-sidebar__user"
                     style="justify-content: center;margin: 0;padding: 0; color: #ffc700;font-size: 24px;font-weight: 600;">
                    Đăng nhập
                </div>
                <div class="form-group">
                    <label class="control-label">Tên đăng nhập</label>
                    <input class="form-control" type="text" placeholder="Tên đăng nhập" autofocus id="username">
                </div>
                <div class="form-group">
                    <label class="control-label">Mật khẩu</label>
                    <input class="form-control" type="password" placeholder="Mật khẩu" id="password">
                </div>
                <div class="form-group">
                    <div class="utility">
                        <p class="semibold-text mb-2"><a href="#" data-toggle="flip">Quên mật khẩu ?</a></p>
                    </div>
                </div>
                <div class="form-group btn-container">
                    <button class="btn btn-primary btn-block btn-login"><i class="fa fa-sign-in fa-lg fa-fw"></i>ĐĂNG
                        NHẬP
                    </button>
            </div>
        </div>
        <div class="forget-form">
            <h3 class="login-head"><i class="fa fa-lg fa-fw fa-lock"></i>Quên mật khẩu ?</h3>

            <div class="form-group">
                <label  class="control-label">Username</label>
                <input id="forget-username" class="form-control" type="text" placeholder="Username">
            </div>

            <div class="form-group">
                <label class="control-label">Email</label>
                <input id="forget-email" class="form-control" type="text" placeholder="Email">
            </div>
            <div class="form-group btn-container">
                <button id="btn-forget" class="btn btn-primary btn-block btn-login"><i class="fa fa-unlock fa-lg fa-fw"></i>GỬI
                </button>
            </div>
            <div class="form-group mt-3">
                <p class="semibold-text mb-0"><a href="#" data-toggle="flip"><i class="fa fa-angle-left fa-fw"></i> Quay lại</a></p>
            </div>
        </div>
    </div>
</section>
<!-- Essential javascripts for application to work-->
<%@include file="../../library/libraby_js.jsp" %>
<script type="text/javascript">
    // Login Page Flipbox control
    $('.login-content [data-toggle="flip"]').click(function () {
        $('.login-box').toggleClass('flipped');
        return false;
    });
</script>

</body>
</html>

