var bestSellingProductList;

$(document).ready(function() {
    bestSellingProductList = $('#best-seller-prod-list');
    callGetAjax("api/v1/public/product/best-seller")
        .then(rs => {
            if (rs.result === "found") {
                rs = rs.data;
                let content = '';
                rs.map(item => {
                    console.log(item.prodName);
                    content += getProductBlock(item);
                });
                bestSellingProductList.html(content);
            }
        }).catch(err => {
        console.log(err)
    })
});





