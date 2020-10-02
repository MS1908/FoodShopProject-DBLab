var productWishList;

$(document).ready(function() {
    productWishList = $('#prod-wish-list');
    loadWishList();
});

function loadWishList() {
    JSON.parse(sessionStorage.getItem("wishList")).map(idProd => {
        callGetAjax(`api/v1/public/product/id?id=${idProd}`)
            .then(rs => {
                if (rs.result === "found") {
                    console.log(rs.data);
                    var item = rs.data;
                    productWishList.append(buildWishListRow(item));
                }
            }).catch(err => console.log(err));
    });
}

function addFromWishListToCart(idProd) {
    addToCart(idProd, 1);
    removeFromProdWishList(idProd);
}

function removeFromProdWishList(idProd) {
    removeFromWishList(idProd);
    $(`#wishlist-item-prod-id-${idProd}`).remove();
}

function buildWishListRow(item) {
    return `<tr id="wishlist-item-prod-id-${item.idProd}" class="text-center">
		        <td class="product-remove"><a onclick="return removeFromProdWishList(${item.idProd})"><span class="ion-ios-close"></span></a></td>
                <td>${item.prodName}</td>
				<td class="image-prod">
                    <div class="img" style="background-image:url(/resources/img/back-end/${item.image});"></div>
                </td>
				<td>${item.price}</td>
                <td>
                    <div class="form-group">
                        <a href="" onclick="return addFromWishListToCart(${item.idProd})"  class="btn py-3 px-4 btn-primary">Add to cart</a>
                    </div>
                </td>
            </tr><!-- END TR-->`;
}