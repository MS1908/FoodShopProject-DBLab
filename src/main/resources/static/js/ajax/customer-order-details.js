var idOrder;
var curOrder = null;

$(document).ready(function() {
    idOrder = new URL(window.location.href).searchParams.get("id");
    callGetAjax(`/api/v1/customer/order/id?id=${idOrder}`)
        .then(rs => {
            if (rs.result === "found") {
                var orderProdList = $('#cus-ord-prod-list');
                var order = rs.data;
                var salesList = order.salesList;
                $('#full-name').html(order.customerName);
                $('#ship-address').html(order.address);
                $('#phone-number').html(order.phone);
                $('#email-address').html(order.email);
                $('#order-date').html(order.date);
                $('#order-total-cost').html(order.totalCost);
                $('#order-pay').html(getPaymentStatus(order.paymentStatus));
                $('#order-process').html(getProcessStatus(order.processStatus));
                if (order.processStatus === CANCELLED || order.processStatus > CONFIRMED || order.paymentStatus) {
                    $('#cus-ord-func').remove();
                }
                var couponCode = "";
                if (order.coupon !== null) couponCode = order.coupon.couponCode + " - " + order.coupon.discount + "%";
                $('#order-coupon').html(couponCode);
                salesList.map(item => {
                    orderProdList.append(`
                        <tr class="text-center">
                            <td class="image-prod">
                                <div class="img"
                                     style="background-image:url(/resources/img/back-end/${item.product.image});"></div>
                            </td>
                            <td>${item.product.prodName}</td>
                            <td>${item.quantity}</td>
                        </tr><!-- END TR-->
                    `);
                })
            } else {
                window.location.href = "/customer/orders";
            }
        })
        .catch((err => {
            console.log(err);
        }));
});

function cancelOrder() {
    callGetAjax(`/api/v1/customer/order/cancel?id=${idOrder}`)
        .then(rs => {
            alert(rs.data);
            window.location.href = `/customer/orders/details?id=${idOrder}`;
    }).catch(err => {
        console.log(err);
    })
}