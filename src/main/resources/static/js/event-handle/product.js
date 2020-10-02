// reference: https://www.w3schools.com/Js/js_classes.asp
var cartList = JSON.parse(sessionStorage.getItem("cartList"));
var wishList = JSON.parse(sessionStorage.getItem("wishList"));


class CartItem {
    constructor(idProd, qty) {
        this.idProd = idProd;
        this.qty = qty;
    }
}

function updateCartItemQty(cartItem, qty, added) {
    var newQty = parseInt(added ? parseInt(cartItem.qty) + parseInt(qty) : qty);
    cartItem.qty = newQty < 0 ? 1 : newQty;
}

function saveCartList() {
    sessionStorage.setItem("cartList", JSON.stringify(cartList));
}

function saveWishList() {
    sessionStorage.setItem("wishList", JSON.stringify(wishList));
}

function addToCart(idProd, qty, added) {
    var item = new CartItem(idProd, qty);
    var exist = false;
    for (var i = 0; i < cartList.length; i++) {
        if (cartList[i].idProd === idProd) {
            item = cartList[i];
            exist = true;
            break;
        }
    }

    if (exist) {
        updateCartItemQty(item, qty, added);
    } else {
        cartList.push(item);
    }
    // save the cart
    saveCartList();
    updateCartIndicator();
    console.log("Done add to Cart");
}

function addToWishList(idProd) {
    var exist = false;
    for (var i = 0; i < wishList.length; i++) {
        if (wishList[i] === idProd) {
            exist = true;
            break;
        }
    }

    if (!exist) wishList.push(idProd);
    // save wish list
    saveWishList();
    updateWishlistIndicator();
    console.log("Done add to wish list");
}

function removeFromCartList(idProd) {
    var deleteElement;
    for (var i = 0; i < cartList.length; i++) {
        if (cartList[i].idProd === idProd) {
            deleteElement = i;
            break;
        }
    }
    cartList.splice(i, 1);
    saveCartList();
    updateCartIndicator();
}

function removeFromWishList(idProd) {
    var deleteElement;
    for (var i = 0; i < wishList.length; i++) {
        if (wishList[i] === idProd) {
            deleteElement = i;
            break;
        }
    }
    wishList.splice(i, 1);
    saveWishList();
    updateWishlistIndicator();
}

function getProductBlock(item) {
    return `<div class="col-md-6 col-lg-3 ftco-animate fadeInUp ftco-animated">
                <div class="product">
                    <a href="/product?id=${item.idProd}" class="img-prod"><img class="img-fluid" src="/resources/img/back-end/${item.image}" alt=""><span class="status">HOT</span><div class="overlay"></div></a>
                    <div class="text py-3 pb-4 px-3 text-center">
                        <h3><a href="/product?id=${item.idProd}">${item.prodName}</a></h3>
                        <div class="d-flex"><div class="pricing"><p class="price"><span class="price-sale">${item.price}</span></p></div></div>
                        <div class="bottom-area d-flex px-3">
                            <div class="m-auto d-flex">
                                <a href="/product?id=${item.idProd}" class="add-to-cart d-flex justify-content-center align-items-center text-center"><span><i class="ion-ios-menu"></i></span></a>
                                <a onclick="return addToCart(${item.idProd}, 1, added=true)" class="buy-now d-flex justify-content-center align-items-center mx-1"><span><i class="ion-ios-cart"></i></span></a>
                                <a onclick="return addToWishList(${item.idProd})" class="heart d-flex justify-content-center align-items-center "><span><i class="ion-ios-heart"></i></span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>`;
}

