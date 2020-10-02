<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/event-handle/order.js"></script>
<script type="text/javascript" src="/resources/js/ajax/customer-orders.js"></script>

<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Order</span></p>
                <h1 class="mb-0 bread">Order page</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>Date</th>
                            <th>Address</th>
                            <th>Total cost</th>
                            <th>Payment</th>
                            <th>Status</th>
                            <th>Coupon</th>
                            <th> </th>
                        </tr>
                        </thead>
                        <tbody id="cus-order-list">
                       <%-- The order list of the customer will be displayed here --%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>