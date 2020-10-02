var adminSalesList;

$(document).ready(function () {
    adminSalesList = $('#admin-sales-list');
    searchSales();
});

function searchSales() {
    var beginDate = $('#begin-date').val();
    var endDate = $('#end-date').val();
    var url =`/api/v1/admin/sales/stats?begin-date=${beginDate}&end-date=${endDate}`;

    callGetAjax(url).then(rs => {
        if (rs.result === "found") {
            rs = rs.data;
            let content = '';
            rs.map(item => {
                content += getSalesRow(item);
            });
            adminSalesList.html(content);
        } else if (rs.result === "not found") {
            let content = `<tr class="text-center"><td style="color: red">${rs.data}</td></tr>`;
            adminSalesList.html(content);
        }
    }).catch(err => {
        console.log(err);
    })
}

function getSalesRow(item) {
    return `<tr class="text-center">
                <td class="image-prod">
                    <div class="img" style="background-image:url(/resources/img/back-end/${item.image});"></div>
                </td>
                <td><a href="/admin/products/details?id=${item.idProd}" class="img-prod">${item.prodName}</a></td>
                <td class="process">${item.qty}</td>
            </tr><!-- END TR-->`
}
