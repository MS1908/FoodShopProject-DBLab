<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/ajax/admin-promotion.js"></script>


<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home</a></span> <span>Promo</span></p>
                <h1 class="mb-0 bread">Promotions</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row justify-content-end">
            <div class="col-lg-5 ftco-animate">
                <form id="admin-order-form">
                    <h4>Coupon</h4>
                    <div class="form-group">
                        <label for="coupon-code">Coupon code *</label>
                        <input type="text" class="form-control" id="coupon-code" required>
                    </div>
                    <div class="form-group">
                        <label for="coupon-discount">Discount *</label>
                        <input type="text" class="form-control" id="coupon-discount" required>
                    </div>
                    <div class="form-group">
                        <label for="coupon-date">Expired Date *</label>
                        <input class="form-control" type="date" id="coupon-date" required>
                    </div>
                    <div class="form-group">
                        <a href="#" onclick="return createCoupon()" class="btn py-3 px-4 btn-primary">Create</a>
                    </div>
                </form>
                <div class="col-md-10 mb-5 text-center ftco-animate">
                    <table class="table" style="min-width: 400px !important;">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>Username</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="admin-promo-applied-user-list">


                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-lg-7 ftco-animate">
                <table class="table" style="min-width: 500px !important;">
                    <thead class="thead-primary">
                    <tr class="text-center">
                        <th>Username</th>
                        <th>Total spent</th>
                        <th>Add customer</th>
                    </tr>
                    </thead>
                    <tbody id="admin-promo-user-list">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>