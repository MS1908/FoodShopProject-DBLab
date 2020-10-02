<%--
  Created by IntelliJ IDEA.
  User: hieuv
  Date: 13-Feb-20
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../library/taglib.jsp" %>
<html lang="vi">
<head>
    <!-- Font-icon css-->
    <title>To chuc</title>
    <%@include file="../../library/library_css.jsp" %>
    <link rel="icon" href="">

    <meta name="description"
          content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description"
          content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="resources/css/owl.theme.default.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab&display=swap" rel="stylesheet">
    <script src="resources/js/template/owl.carousel.min.js"></script>
    <script src="resources/js/ajax/begin.js"></script>
    <script src="resources/js/common.js"></script>

</head>
<body style="text-align: center">
<div style=" margin-top: 5%">
    <div class="row" style="justify-content: center; padding: unset; margin: unset">
        <h1 class="font-weight-bold" style="font-size: 40px;font-family: 'Roboto Slab', serif;">Chọn tổ chức của
            bạn</h1>
    </div>
    <div style="margin-top: 5%">
        <div id="list-company" class="col-lg-12" style="display: flex; justify-content: space-between">
            <div class="col-lg-3" style="display: inline-block">
                <button class="btn my-btn" data-toggle="modal"
                        data-target="#new-modal">
                    <img src="resources/img/addIcon.png" width="100px" height="100x">
                    <br>
                    <span class="font-weight-normal" style="font-size: 15px">Thêm mới</span>
                </button>
            </div>
            <div class="col-lg-3" style="display: inline-block">
                <button class="btn my-btn" data-toggle="modal"
                        data-target="#new-modal">
                    <img src="resources/img/addIcon.png" width="100px" height="100x">
                    <br>
                    <span class="font-weight-normal" style="font-size: 15px">Thêm mới</span>
                </button>
            </div>
        </div>
    </div>

    <div id="no-group" style="margin-top: 3%">
        <div class="row" style="justify-content: center; padding: unset; margin: unset">
            <h1 class="font-weight-bold" style="font-size: 30px;font-family: 'Roboto Slab', serif;">Nhập mã tổ chức để
                tham gia</h1>
        </div>
        <div class="row" style="justify-content: center; padding: unset;margin-top: 3%">
            <input id="organization-code" class="form-control col-lg-3" style="font-size: 20px; height: 40px"
                   placeholder="#">
            <button id="join" class="btn btn-primary" style="font-size: 16px">Tham gia</button>
        </div>
    </div>
    <!-- Modal -->
    <div id="new-modal" class="modal fade" data-backdrop="static" role="dialog"
         style="color: black; text-align: left; margin-top: 5%">
        <div class="modal-dialog modal-lg">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row" style="justify-content: center">
                                        <div class="col-lg-11">
                                            <div class="form-group row">
                                                <label id="label-full-name" for="fullName"
                                                       class="col-lg-2 col-form-label">Tên
                                                    tổ
                                                    chức<span
                                                            style="color: red"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input id="fullName" name="fullName" placeholder="Tên tổ chức"
                                                           class="form-control here" required="required" type="text">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label id="label-address" for="address" class="col-lg-2 col-form-label">Địa
                                                    chỉ<span style="color: red"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input id="address" name="address" placeholder="Địa chỉ"
                                                           class="form-control here" required="required" type="text">
                                                </div>
                                            </div>
                                            <div class="row" style="justify-content: space-between">
                                                <div class="form-group col-lg-6">
                                                    <label id="label-phone" for="phone" class=" col-form-label">Số điện
                                                        thoại<span style="color: red"></span></label>
                                                    <div class="">
                                                        <input id="phone" name="phone" placeholder="Số điện thoại"
                                                               class="form-control here" required="required"
                                                               type="number">
                                                    </div>
                                                </div>
                                                <div class="form-group col-lg-6">
                                                    <label id="label-website" for="website" class=" col-form-label">Trang
                                                        web<span
                                                                style="color: red"></span></label>
                                                    <div class="">
                                                        <input id="website" name="website" placeholder="Trang web"
                                                               class="form-control here" required="required"
                                                               type="text">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row" style="justify-content: space-between">
                                                <div class="form-group col-lg-6">
                                                    <div class="row" style="justify-content: space-between">
                                                        <label id="label-logo" for="logo"
                                                               class="col-lg-3 col-form-label">Logo<span
                                                                style="color: red"></span></label>
                                                        <div class="col-lg-9">
                                                            <img id="logo" alt="Logo" class="col-lg-8"
                                                                 src=""
                                                                 style="">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group col-lg-6">
                                                    <label id="label-upload" for="choose-file" class=" col-form-label">Tải
                                                        lên ảnh
                                                        logo</label>
                                                    <div class="">
                                                        <form method="post" enctype="multipart/form-data"
                                                              id="btn-upload">
                                                            <input id="choose-file" name="file" type="file">
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="group-status" class="form-group row">
                                                <div class="col-lg-6"></div>
                                                <label id="label-status" class="col-lg-2 col-form-label">Trạng thái<span
                                                        style="color: red"> *</span></label>
                                                <div class="col-lg-3">
                                                    <div class="row" style="justify-content: space-between">
                                                        <label style="padding: 8px 0" class="radio-inline"><input
                                                                id="enable"
                                                                type="radio" name="optradio">&nbsp;Kích hoạt</label>
                                                        <label style="padding: 8px 0" class="radio-inline"><input
                                                                id="disable"
                                                                type="radio" name="optradio" checked>&nbsp;Khóa</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style=" padding-bottom: 4%; justify-content: center">
                    <div class="col-lg-3" style=" display: flex; justify-content: center">
                        <button id="submit" type="button" class="btn btn-success">&nbsp;Lưu lại</button>
                        <button id="close-add" style="margin-left: 5%" type="button" class="btn btn-secondary"
                                data-dismiss="modal">Quay
                            lại
                        </button>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div id="delete-modal" class="modal fade" data-backdrop="static" role="dialog"
         style="color: black; text-align: left; margin-top: 5%">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header" style="padding: 10px 10px">
                    <div class="row col-lg-12" style="justify-content: center">
                        <h4 class="modal-title font-weight-normal"><i class="fas fa-trash-alt"></i>&nbsp;Xóa tổ chức
                        </h4>
                    </div>
                </div>
                <div class="modal-body">
                    <span class="font-weight-normal">Bạn có chắc chắn muốn xóa không?</span>
                </div>
                <div class="modal-footer" style="padding: 10px 10px">
                    <div class="row" style=" justify-content: center">
                        <div class="col-lg-3" style=" display: flex; justify-content: center">
                            <button id="submit-delete" type="button" class="btn btn-danger">&nbsp;Xác nhận</button>
                            <button id="close-delete" style="margin-left: 5%" type="button" class="btn btn-secondary"
                                    data-dismiss="modal">
                                &nbsp;Hủy bỏ
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!----------------------Script------------------------------------ -->
<%@include file="../../library/libraby_js.jsp" %>
</body>
</html>

<style>
    body, html {
        background-color: #141414;
        color: #fff;
        line-height: 1.2;
    }

    .my-btn {
        color: #fff;
    }

    .my-btn:hover {
        background-color: #ffc700;
        color: #222c36;
        transition: 0.6s;
        transform: scale(1.2);
    }

</style>