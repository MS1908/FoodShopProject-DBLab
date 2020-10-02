<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/event-handle/order.js"></script>
<script type="text/javascript" src="/resources/js/ajax/customer-order-details.js"></script>


<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home</a></span> <span>Order</span></p>
                <h1 class="mb-0 bread">Order details</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row justify-content-end">
            <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Customer information</h3>
                    <p class="d-flex">
                        <span>Full name</span>
                        <span id="full-name">Long Bin Sleepy</span>
                    </p>
                    <p class="d-flex">
                        <span>Address</span>
                        <span id="ship-address">Tổng công chăn ga gối đệm, Mai Động, Hà Nội</span>
                    </p>
                    <p class="d-flex">
                        <span>Phone</span>
                        <span id="phone-number">+1234567890</span>
                    </p>
                    <p class="d-flex">
                        <span>Email</span>
                        <span id="email-address">longvip11@gmail.com</span>
                    </p>
                </div>
            </div>
            <div class="col-lg-5 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Order details</h3>
                    <p class="d-flex">
                        <span>Date</span>
                        <span id="order-date">21/06/2020 00:31</span>
                    </p>

                    <p class="d-flex">
                        <span>Total cost</span>
                        <span id="order-total-cost" class="total">1000000 VND</span>
                    </p>
                    <p class="d-flex">
                        <span>Payment</span>
                        <span id="order-pay" style="color: red">Un-paid</span>
                    </p>
                    <p class="d-flex">
                        <span>Status</span>
                        <span id="order-process" style="color: red"> On shipping</span>
                    </p>
                    <p class="d-flex">
                        <span>Coupon</span>
                        <span id="order-coupon" style="color: blue"> kadjkAjD8GwqejcU</span>
                    </p>
                </div>
            </div>
            <div id="cus-ord-func" class="col-lg-3 mt-5 cart-wrap ftco-animate">
                <div class="form-group">
                    <a href="#" onclick="return cancelOrder()" class="btn py-3 px-4 btn-warning">Cancel this request</a>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th></th>
                            <th>Item</th>
                            <th>Quantity</th>
                        </tr>
                        </thead>
                        <tbody id="cus-ord-prod-list">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>