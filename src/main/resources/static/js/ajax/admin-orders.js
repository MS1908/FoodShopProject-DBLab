var adminOrderList;

$(document).ready(function() {
    adminOrderList = $('#admin-order-list');
    loadAdminOrderList();
});

function loadAdminOrderList() {
    callGetAjax(`/api/v1/admin/order/all`).then(rs => {
        if (rs.result === "found") {
            rs = rs.data;
            let content = '';
            rs.map(order => {
                content += getAdminOrderRow(order);
            });
            adminOrderList.html(content);
        }
    }).catch(err => {
        console.log(err);
    })
}

function getAdminOrderRow(order) {
    var couponCode = "";
    if (order.coupon !== null) couponCode = order.coupon.couponCode;
    return `<tr class="text-center">
                <td>${order.date}</td>
                <td>${order.address}</td>
                <td class="total">${order.totalCost}</td>
                <td class="payment">${getPaymentStatus(order.paymentStatus)}</td>
                <td class="process">${getProcessStatus(order.processStatus)}</td>
                <td>${couponCode}</td>
                <td>    
                    <div class="form-group">
                        <a href="/admin/orders/details?id=${order.idOrder}" class="btn py-3 px-4 btn-primary">Update</a>
                    </div>
                </td>
            </tr>`
}