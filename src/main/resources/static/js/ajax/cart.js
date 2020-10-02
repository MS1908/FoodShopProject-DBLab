var cartItemList;

$(document).ready(function() {
    cartItemList = $('#cart-item-list');
    loadCart();
});

function loadCart() {
    JSON.parse(sessionStorage.getItem("cartList")).map(cartItem => {
        callGetAjax(`/api/v1/public/product/id?id=${cartItem.idProd}`)
            .then(rs => {
                if (rs.result === "found") {
                    var item = rs.data;
                    cartItemList.append(buildCartRow(item, cartItem.qty));
                    updateCartTotal();
                }
            }).catch(err => console.log(err));
    });

}

function validateQtyInput(idProd) {
    var qtyInput = $(`#qty-prod-id-${idProd}`);
    var qty = qtyInput.val();
    console.log(qty + " is NaN: " + isNaN(qty));
    if (isNaN(qty)) {
        qtyInput.val(1);
        alert("Invalid Input");
    }
    updateItemSubTotal(idProd);
    addToCart(idProd, parseInt(qtyInput.val()), false);
}

function increase(idProd) {
    // check view
    var qtyInput = $(`#qty-prod-id-${idProd}`);
    var qty = parseInt(qtyInput.val());
    if (qty < 100) {
        qtyInput.val(qty + 1);
    }
    updateItemSubTotal(idProd);
    addToCart(idProd, qtyInput.val(), false);
}

function decrease(idProd) {
    // check view
    var qtyInput = $(`#qty-prod-id-${idProd}`);
    var qty = parseInt(qtyInput.val());
    if (qty > 1) {
        qtyInput.val(qty - 1);
    }
    updateItemSubTotal(idProd);
    addToCart(idProd, qtyInput.val(), false);
}

function updateItemSubTotal(idProd) {
    // after change qty input -> re-compute the subtotal
    var price = parseInt($(`#cart-item-prod-id-${idProd} td.price`).html());
    var qtyInput = $(`#qty-prod-id-${idProd}`);
    var qty = parseInt(qtyInput.val());
    var total = price * qty;
    $(`#cart-item-prod-id-${idProd} td.total`).html(total);
    updateCartTotal();
}

function removeFromProdCartList(idProd) {
    removeFromCartList(idProd);
    $(`#cart-item-prod-id-${idProd}`).remove();
    updateCartTotal();
}

function updateCartTotal() {
    var subtotal = 0;
    cartItemList.find('.total').each(function () {
        subtotal += parseInt($(this).html());
    })
    $('#cart-subtotal').html(subtotal);

    var deliveryFee = parseInt($('#cart-delivery-fee').html());

    var cartTotal = subtotal + deliveryFee;
    $('#cart-total').html(cartTotal);
    // sum all subtotal from the list;
    // var = $('#cart-subtotal')
    // var = $('#cart-delivery-fee')
    // var = $('#cart-total') = sum 2 above
    // take good care of error
}

function checkout() {
    if (cartList === null || cartList.length === 0){
        console.log("no item in cart");
        alert("No item in cart!");
    } else if (tokenHeader_value === null || tokenHeader_value === "") {
        sessionStorage.setItem("previousPage", "/customer/checkout");
        console.log("login first");
        window.location.href = "/login";
    } else {
        window.location.href = "/customer/checkout";
    }
}

function buildCartRow(item, qty) {
    var curTotal = item.price * qty;
    console.log(item.prodName + ' ' + curTotal);
    return `<tr id="cart-item-prod-id-${item.idProd}" class="text-center">` +
                `<td class="product-remove"><a onclick="return removeFromProdCartList(${item.idProd})"><span class="ion-ios-close"></span></a></td>` +
                `<td class="image-prod"><div class="img" style="background-image:url(/resources/img/back-end/${item.image}"></div></td>` +
                `<td class="product-name"><h3>${item.prodName}</h3></td>` +
                `<td class="price">${item.price}</td>` +

                '<td class="quantity">' +
                    '<div class="input-group mb-3">' +
                        '<span class="input-group-btn mr-2">' +
                            `<button onclick="return decrease(${item.idProd})" type="button" class="quantity-left-minus btn" data-type="minus" data-field=""><i class="ion-ios-remove"></i></button>` +
                        '</span>' +
                        `<input id="qty-prod-id-${item.idProd}" onchange="return validateQtyInput(${item.idProd})" type="text" name="quantity" class="quantity form-control input-number" value="${qty}" min="1" max="100">` +
                        '<span class="input-group-btn ml-2">' +
                            `<button onclick="return increase(${item.idProd})" type="button" class="quantity-right-plus btn" data-type="plus" data-field=""><i class="ion-ios-add"></i></button>` +
                        '</span>' +
                    '</div>' +
                '</td>' +

                `<td id="cart-item-total-${item.idProd}" class="total">${curTotal}</td>` +
            `</tr><!-- END TR-->`;
}



