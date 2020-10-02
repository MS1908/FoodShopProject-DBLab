<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript" src="/resources/js/event-handle/admin-menu.js"></script>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="/home">YUMMY SLEEPING</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul id="menu-list" class="navbar-nav ml-auto">
                <li class="nav-item"><a href="/admin" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="/admin/category" class="nav-link">Category</a></li>
                <li class="nav-item"><a href="/admin/products" class="nav-link">Product</a></li>
                <li class="nav-item"><a href="/admin/orders" class="nav-link">Order</a></li>
                <li class="nav-item active dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sales</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item" href="/admin/sales/stats">Sales Statistics</a>
                        <a class="dropdown-item" href="/admin/sales/best-seller">Best Sellers</a>
                    </div>
                </li>
                <li class="nav-item"><a href="/admin/promotions" class="nav-link">Promotion</a></li>
            </ul>
        </div>
    </div>
</nav>