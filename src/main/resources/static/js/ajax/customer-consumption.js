var customerConsumptionList;

$(document).ready(function() {
    customerConsumptionList = $('#cus-consume-list');
    loadConsumptionList();
});

function loadConsumptionList() {
    console.log("Load Products ...")
    var productUrl = `/api/v1/customer/product/consumption?username=${localStorage.getItem("username")}`;
    callGetAjax(productUrl).then(rs => {
        if (rs.result === "found") {
            rs = rs.data;
            let content = '';
            rs.map(item => {
                content += getCustomerConsumptionRow(item);
            });
            customerConsumptionList.html(content);
        }
    }).catch(err => {
        console.log(err);
    })
}

function getCustomerConsumptionRow(item) {
    return `<tr class="text-center">
                <td class="image-prod">
                    <div class="img" style="background-image:url(/resources/img/back-end/${item.image});"></div>
                </td>
                <td>${item.prodName}</td>
                <td class="total">${item.price}</td>
                <td>${item.consumption}</td>
                <td>
                    <div class="form-group">
                        <a href="#" onclick="return addToCart(${item.idProd}, 1, added=true)" class="btn py-3 px-4 btn-primary">Add to Cart</a>
                    </div>
                </td>
            </tr>`;
}