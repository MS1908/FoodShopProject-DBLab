$(function() {
    updateCartIndicator();
    updateWishlistIndicator();
    if (tokenHeader_value === null || tokenHeader_value === "") return;
    $('#menu-list li:eq(0)').before(`
        <li class="nav-item active dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Customer Services</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item" href="/customer/orders">My Orders</a>
                        <a class="dropdown-item" href="/customer/products">My Consumption</a>
                    </div>
                </li>
    `);
    $('#menu-list li:last').after(`<li class="nav-item"><a onclick="return logout()" class="nav-link">Log Out</a></li>`);
});

function logout() {
    callGetAjax("/logout");
    localStorage.setItem("token", "");
    localStorage.setItem("username", "");
    window.location.href = "/home";
}

function updateCartIndicator() {
    $('#cart-indicator').html(`[${JSON.parse(sessionStorage.getItem("cartList")).length}]`);
}

function updateWishlistIndicator() {
    $('#wishlist-indicator').html(`[${JSON.parse(sessionStorage.getItem("wishList")).length}]`);
}