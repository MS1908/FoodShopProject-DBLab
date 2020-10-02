<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="resources/js/ajax/product-single.js"></script>
<script type="text/javascript" src="resources/js/event-handle/product.js"></script>

<div class="hero-wrap hero-bread" style="background-image: url('resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span class="mr-2"><a
                        href="index.html">Product</a></span> <span>Product Single</span></p>
                <h1 class="mb-0 bread">Product Single</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div id="product-detail-information" class="row">
            <div class="col-lg-6 mb-5 ftco-animate">
                <a id="product-image-url" href="resources/img/back-end/product-1.jpg" class="image-popup"><img
                        id="product-image" src="resources/img/back-end/product-1.jpg" class="img-fluid" alt=""></a>
            </div>
            <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                <h3 id="product-name">$\{item.prodName\}</h3>
                <div class="rating d-flex">
                    <%--<p class="text-left mr-4">--%>
                    <%--<a href="#" class="mr-2">5.0</a>--%>
                    <%--<a href="#"><span class="ion-ios-star-outline"></span></a>--%>
                    <%--<a href="#"><span class="ion-ios-star-outline"></span></a>--%>
                    <%--<a href="#"><span class="ion-ios-star-outline"></span></a>--%>
                    <%--<a href="#"><span class="ion-ios-star-outline"></span></a>--%>
                    <%--<a href="#"><span class="ion-ios-star-outline"></span></a>--%>
                    <%--</p>--%>
                    <%--<p class="text-left mr-4">--%>
                    <%--<a href="#" class="mr-2" style="color: #000;">100 <span style="color: #bbb;">Rating</span></a>--%>
                    <%--</p>--%>
                    <%--<p class="text-left">--%>
                    <%--<a href="#" class="mr-2" style="color: #000;">100 <span style="color: #bbb;">Sold</span></a>--%>
                    </p>
                </div>
                <p class="price"><span id="product-price">$\{item.price\}</span></p>
                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a
                    paradisematic country, in which roasted parts of sentences fly into your mouth. Text should turn
                    around and return to its own, safe country. But nothing the copy said could convince her and so it
                    didn’t take long until.
                </p>
                <div class="row mt-4">
                    <%--<div class="col-md-6">--%>
                    <%--<div class="form-group d-flex">--%>
                    <%--<div class="select-wrap">--%>
                    <%--<div class="icon"><span class="ion-ios-arrow-down"></span></div>--%>
                    <%--<select name="" id="" class="form-control">--%>
                    <%--<option value="">Small</option>--%>
                    <%--<option value="">Medium</option>--%>
                    <%--<option value="">Large</option>--%>
                    <%--<option value="">Extra Large</option>--%>
                    <%--</select>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <div class="w-100"></div>
                    <div class="input-group col-md-6 d-flex mb-3">
	             	<span class="input-group-btn mr-2">
	                	<button onclick="return decrease()" type="button" class="quantity-left-minus btn" data-type="minus" data-field="">
	                   <i class="ion-ios-remove"></i>
	                	</button>
	            		</span>
                        <input onchange="return validateQtyInput()" type="text" id="quantity" name="quantity" class="form-control input-number" value="1"
                               min="1" max="100">
                        <span class="input-group-btn ml-2">
	                	<button onclick="return increase()" type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
	                     <i class="ion-ios-add"></i>
	                 </button>
	             	</span>
                    </div>
                    <div class="w-100"></div>
                    <%--<div class="col-md-12">--%>
                    <%--<p style="color: #000;">600 kg available</p>--%>
                    <%--</div>--%>
                </div>
                <p><a class="btn btn-black py-3 px-5" onclick="return addThisProductToCart()">Add to Cart</a></p>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div id="related-products-information" class="row justify-content-center mb-3 pb-3">
            <div class="col-md-12 heading-section text-center ftco-animate">
                <span class="subheading">Products</span>
                <h2 class="mb-4">Related Products</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
            </div>
        </div>
    </div>
    <div class="container">
        <div id="related-product-list" class="row">

        </div>
    </div>
</section>