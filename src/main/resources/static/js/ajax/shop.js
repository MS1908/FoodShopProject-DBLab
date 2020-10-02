var productList;
var categoryList;

$(document).ready(function() {
    productList = $('#product-list');
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
                content += getProductBlock(item);
            });
            productList.html(content);
            updateCategoryList(idCat);
        }
    }).catch(err => {
        console.log(err);
    })
}


