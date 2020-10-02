<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/ajax/checkout.js"></script>


<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home</a></span> <span>Checkout</span></p>
                <h1 class="mb-0 bread">Checkout</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xl-10 ftco-animate">
                <form action="#" class="billing-form">
                    <h3 class="mb-4 billing-heading">Billing Details</h3>
                    <div class="row align-items-end">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="full-name">Full Name</label>
                                <input id="full-name" type="text" class="form-control" placeholder="">
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="ship-address">Shipping Address</label>
                                <input id="ship-address" type="text" class="form-control" placeholder="">
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="phone">Phone</label>
                                <input id="phone" type="text" class="form-control" placeholder="">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="email-address">Email Address</label>
                                <input id="email-address" type="text" class="form-control" placeholder="">
                            </div>
                        </div>
                        <div class="w-100"></div>
                    </div>
                </form><!-- END -->
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-xl-5 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Coupon Code</h3>
                    <p>Enter your coupon code if you have one</p>
                    <form action="#" class="info">
                        <div class="form-group">
                            <label for="coupon">Coupon code</label>
                            <input id="coupon" type="text" class="form-control text-left px-3" placeholder="">
                            <label id="valid-coupon-noti" style="color: #ff0000"></label>
                        </div>
                    </form>
                </div>
                <p><a href="#" onclick="return validateCoupon()" class="btn btn-primary py-3 px-4">Apply Coupon</a></p>
            </div>
            <div class="col-xl-5 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Cart Totals</h3>
                    <p class="d-flex">
                        <span>Subtotal</span>
                        <span id="cart-subtotal">0.00</span>
                    </p>
                    <p class="d-flex">
                        <span>Delivery</span>
                        <span id="cart-delivery-fee">50000.000</span>
                    </p>
                    <p class="d-flex">
                        <span>Discount</span>
                        <span id="cart-discount">0.00</span>
                    </p>
                    <hr>
                    <p class="d-flex total-price">
                        <span>Total</span>
                        <span id="cart-total">0.00</span>
                    </p>
                </div>
                <p><a href="#" onclick="return submitOrder()" class="btn btn-primary py-3 px-4">Place this order</a></p>
            </div>
        </div>
    </div>
</section>



