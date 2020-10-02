<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/ajax/admin-products.js"></script>
<script type="text/javascript" src="/resources/js/event-handle/category.js"></script>

<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/admin">Home</a></span> <span>Products</span></p>
                <h1 class="mb-0 bread">Product List</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10 mb-5 text-center">
                <ul id="prod-cat-list" class="product-category">
                    <li><a href="#" class="active">All</a></li>
                    <li><a href="#">Vegetables</a></li>
                    <li><a href="#">Fruits</a></li>
                    <li><a href="#">Juice</a></li>
                    <li><a href="#">Dried</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th></th>
                            <th>Product name</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th> <a href="/admin/products/new" class="btn py-3 px-4 btn-warning">Add new product</a></th>
                        </tr>
                        </thead>
                        <tbody id="admin-prod-list">
                        <tr class="text-center">

                            <td class="image-prod">
                                <div class="img" style="background-image:url(/resources/img/front-end/product-1.jpg);"></div>
                            </td>

                            <td>Bell Pepper</td>

                            <td class="total">$4.60</td>

                            <td>Veggies</td>

                            <td>
                                <div class="form-group">
                                    <a href="/admin/products/details?id=1" class="btn py-3 px-4 btn-primary">Update</a>
                                </div>
                            </td>
                        </tr><!-- END TR-->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>