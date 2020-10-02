<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/ajax/admin-category.js"></script>


<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home</a></span> <span>Category</span></p>
                <h1 class="mb-0 bread">Category</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row justify-content-end">
            <div class="col-lg-5 ftco-animate">
                <form id="admin-order-form">
                    <h4>Category</h4>
                    <div class="form-group">
                        <label for="cat-name">Name *</label>
                        <input type="text" class="form-control" id="cat-name" required>
                    </div>
                    <div class="form-group">
                        <label for="cat-priority">Priority *</label>
                        <input onchange="return validatePriorInput()" type="text" class="form-control" id="cat-priority" required>
                    </div>
                    <div class="form-group">
                        <a href="#" onclick="return addCategory()" class="btn py-3 px-4 btn-primary">Add category</a>
                    </div>
                </form>
            </div>
            <div class="col-lg-7 ftco-animate">
                <table class="table" style="min-width: 500px !important;">
                    <thead class="thead-primary">
                    <tr class="text-center">
                        <th>Categories</th>
                        <th>Priority</th>
                    </tr>
                    </thead>
                    <tbody id="admin-cat-list">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>