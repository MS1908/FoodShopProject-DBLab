<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/event-handle/product.js"></script>
<script type="text/javascript" src="/resources/js/ajax/cart.js"></script>


<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home</a></span> <span>Cart</span></p>
                <h1 class="mb-0 bread">My Cart</h1>
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
                            <th>&nbsp;</th>
                            <th>Product List</th>
                            <th>&nbsp;</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                        </thead>
                        <tbody id="cart-item-list">
                        <%--<tr id="cart-item-prod-id-0" class="text-center">--%>
                            <%--<td class="product-remove"><a onclick="return removeFromProdCartList(0)"><span class="ion-ios-close"></span></a></td>--%>
                            <%--<td class="image-prod"><div class="img" style="background-image:url(/resources/img/front-end/"></div></td>--%>
                            <%--<td class="product-name"><h3>Bell Pepper</h3></td>--%>
                            <%--<td class="price">13723</td>--%>

                            <%--<td class="quantity">--%>
                                <%--<div class="input-group mb-3">--%>
                                    <%--<span class="input-group-btn mr-2">--%>
                            <%--<button onclick="return decrease(0)" type="button" class="quantity-left-minus btn" data-type="minus" data-field=""><i class="ion-ios-remove"></i></button>--%>
                        <%--</span>--%>
                                    <%--<input id="qty-prod-id-0" onchange="return validateQtyInput('#qty-prod-id-0')" type="text" name="quantity" class="quantity form-control input-number" value="1" min="1" max="100">--%>
                                    <%--<span class="input-group-btn ml-2">--%>
                            <%--<button onclick="return increase(0)" type="button" class="quantity-right-plus btn" data-type="plus" data-field=""><i class="ion-ios-add"></i></button>--%>
                        <%--</span>--%>
                                    <%--</div>--%>
                            <%--</td>--%>

                            <%--<td id="cart-item-total-${item.idProd}" class="total">${curTotal}</td>--%>
                            <%--</tr><!-- END TR-->--%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row justify-content-end">
            <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                <div class="cart-total mb-3">
                    <h3>Cart Totals</h3>
                    <p class="d-flex">
                        <span>Subtotal</span>
                        <span id="cart-subtotal">0</span>
                    </p>
                    <p class="d-flex">
                        <span>Delivery</span>
                        <span id="cart-delivery-fee">50000</span>
                    </p>
                    <hr>
                    <p class="d-flex total-price">
                        <span>Total</span>
                        <span id="cart-total">0</span>
                    </p>
                </div>
                <p><a href="#" onclick="return checkout()" class="btn btn-primary py-3 px-4">Proceed to Checkout</a></p>
            </div>
        </div>
    </div>
</section>