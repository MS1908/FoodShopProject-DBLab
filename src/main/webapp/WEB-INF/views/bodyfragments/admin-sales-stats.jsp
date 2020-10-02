<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/resources/js/ajax/admin-sales-stats.js"></script>


<div class="hero-wrap hero-bread" style="background-image: url('/resources/img/front-end/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home</a></span> <span>Stats</span></p>
                <h1 class="mb-0 bread">Sale statistics</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <label for="begin-date">From Date</label>
                <input type="date" id="begin-date" name="begin-date">
            </div>
            <div class="col-md-4">
                <label for="end-date">To Date</label>
                <input type="date" id="end-date" name="end-date">
            </div>
            <div class="col-md-2 form-group">
                <a href="#" onclick="return searchSales()" class="btn py-3 px-4 btn-primary">Search</a>
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
                            <th>Quantity</th>
                        </tr>
                        </thead>
                        <tbody id="admin-sales-list">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
