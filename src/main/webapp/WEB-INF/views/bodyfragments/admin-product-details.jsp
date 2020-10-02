<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/ajax/admin-product-details.js"></script>


<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home</a></span> <span>Product</span></p>
                <h1 class="mb-0 bread">Product detail</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div id="product-detail-information" class="row">
            <div class="col-lg-6 mb-5 ftco-animate align-items-center">
                <a id="product-image-url" href="/resources/img/back-end/Sample.jpg" class="image-popup"><img
                        id="product-image" src="/resources/img/back-end/Sample.jpg" class="img-fluid" alt=""></a>
            </div>
            <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                <form id="product-form">
                    <div class="col-lg mt-5 cart-wrap ftco-animate">
                        <div class="form-group">
                            <p id="prod-id" hidden></p>
                        </div>
                        <div class="form-group">
                            <label for="prod-name">Product name *</label>
                            <input type="text" class="form-control" id="prod-name" required>
                        </div>
                        <div class="form-group">
                            <label for="prod-cat">Product category *</label>
                            <select class="form-control" id="prod-cat" required>
                                <option>Opt 1</option>
                                <option>Opt 2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="prod-price">Product price *</label>
                            <input type="text" class="form-control" id="prod-price" required>
                        </div>
                        <div class="form-group">
                            <label for="prod-img-file">Product image</label>
                            <div class="row">
                                <div class="col-2 mr-3">
                                    <a onclick="return resetImgInput()" class="btn py-3 px-4 btn-black">Reset</a>
                                </div>
                                <div class="col-8 align-self-center">
                                    <input id="prod-img-file" class="form-control-file" type="file" accept="image/*"
                                           onChange="return loadImage(this)">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label> Product Availability</label>
                            <div>
                                <label class="form-check-label" for="radio1" style="margin-right: 50px!important;">
                                    <input type="radio" class="form-control" id="radio1" name="optradio"
                                           value="available" checked>Available
                                </label>
                                <label class="form-check-label" for="radio2">
                                    <input type="radio" class="form-control" id="radio2" name="optradio"
                                           value="deleted">Deleted
                                </label>
                            </div>
                        </div>
                        <div class="form-group align-items-center justify-content-center">
                            <a href="#" onclick="return saveProduct()" class="btn py-3 px-4 btn-success">Save
                                product</a>
                            <a href="#" onclick="return deleteProduct()" class="btn py-3 px-4 btn-danger">Delete
                                product</a>
                            <a href="#" onclick="return cancel()" class="btn py-3 px-4 btn-warning">Cancel</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>