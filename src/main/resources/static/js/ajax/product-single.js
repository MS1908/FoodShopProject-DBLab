// tasks: (1) quantity button: increase, decrease(done); (2) product functionality : Minh's work
// increase and decrease is the same function -> refactor code: separate as an independent function

var idProd;
var relatedProductList;

$(document).ready(function() {
    idProd = parseInt(new URL(window.location.href).searchParams.get("id"));
    relatedProductList = $('#related-product-list');
    callGetAjax(`api/v1/public/product/id?id=${idProd}`)
        .then(rs => {
            if (rs.result === "found") {
                console.log(rs.data);
                rs = rs.data;
                var productUrl = `/resources/img/back-end/${rs.image}`;
                $('#product-name').html(rs.prodName);
                $('#product-price').html(rs.price);
                $('#product-image-url').attr("href", productUrl);
                $('#product-image').attr("src", productUrl);
                loadRelatedProducts();
            }
    }).catch(err => {
        console.log(err);
        $('#product-detail-information').html("<h3>The product is not available</h3>");
        $('#related-products-information').empty();
    });
});

function validateQtyInput() {
    var qtyInput = $('#quantity');
    var qty = parseInt(qtyInput.val());
    if (isNaN(qty)) {
        qtyInput.val(1);
        alert("Invalid Input");
    }
}

function increase() {
    // check view
    var qtyInput = $('#quantity');
    var qty = parseInt(qtyInput.val());
    if (qty < 100) {
        qtyInput.val(qty + 1);
    }
}

function decrease() {
    // check view
    var qtyInput = $('#quantity');
    var qty = parseInt(qtyInput.val());
    if (qty > 1) {
        qtyInput.val(qty - 1);
    }
}

function loadRelatedProducts() {
    callGetAjax(`/api/v1/public/product/related?id=${idProd}`).then(rs => {
        if (rs.result === "found") {
            rs = rs.data;
            let content = '';
            rs.map(item => {
                content += getProductBlock(item);
            });
            relatedProductList.html(content);
        }
    }).catch(err => {
        console.log(err);
    });
}

function addThisProductToCart() {
    addToCart(idProd, $('#quantity').val(), true);
}