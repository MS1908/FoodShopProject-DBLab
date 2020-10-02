var productList;
var categoryList;

$(document).ready(function() {
    productList = $('#admin-prod-list');
    categoryList = $('#prod-cat-list');
    loadCategoryList();
    loadProductList(0);
});

function loadProductList(idCat) {
    console.log("Load Products ...")
    var productUrl = "/api/v1/public/product"
    productUrl += (idCat === 0 ? `/all` : `/cat?id-cat=${idCat}`);
    callGetAjax(productUrl).then(rs => {
        if (rs.result === "found") {
            rs = rs.data;
            let content = '';
            rs.map(item => {
                content += getProductRow(item);
            });
            productList.html(content);
            updateCategoryList(idCat);
        }
    }).catch(err => {
        console.log(err);
    })
}

function getProductRow(item) {
    return `<tr class="text-center">
                <td class="image-prod">
                    <div class="img" style="background-image:url(/resources/img/back-end/${item.image});"></div>
                </td>
                <td>${item.prodName}</td>
                <td class="total">${item.price}</td>
                <td>${item.category.catName}</td>
                <td>
                    <div class="form-group">
                        <a href="/admin/products/details?id=${item.idProd}" class="btn py-3 px-4 btn-primary">Update</a>
                    </div>
                </td>
            </tr>`;
}