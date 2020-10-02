var customerOrderList;

$(document).ready(function() {
    customerOrderList = $('#cus-order-list');
    loadCustomerOrderList();
});

function loadCustomerOrderList() {
    callGetAjax(`/api/v1/customer/order/all`).then(rs => {
        if (rs.result === "found") {
            rs = rs.data;
            let content = '';
            rs.map(order => {
                content += getCustomerOrderRow(order);
            });
            customerOrderList.html(content);
        }
    }).catch(err => {
        console.log(err);
    })
}

function getCustomerOrderRow(order) {
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
                        <a href="/customer/orders/details?id=${order.idOrder}" class="btn py-3 px-4 btn-primary">Details</a>
                    </div>
                </td>
            </tr>`
}