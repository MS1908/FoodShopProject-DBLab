// callPutAjax OrdersAdminController
// alert result in both case failure and success
// redirect back to /admin/orders finally
// reference admin-product-details.js function deleteProduct
// logic requirement:
// + check the increasing level of status
// + based on constants in cart.js
var idOrder;
var curPaymentStatus;
var curProcessStatus;

$(document).ready(function() {
    idOrder = new URL(window.location.href).searchParams.get("id");
    callGetAjax(`/api/v1/customer/order/id?id=${idOrder}`)
        .then(rs => {
            if (rs.result === "found") {
                var orderProdList = $('#order-prod-list');
                var order = rs.data;
                var salesList = order.salesList;
                $('#full-name').html(order.customerName);
                $('#ship-address').html(order.address);
                $('#phone-number').html(order.phone);
                $('#email-address').html(order.email);
                $('#order-date').html(order.date);
                $('#order-total-cost').html(order.totalCost);
                $('#order-pay').html(getPaymentStatus(order.paymentStatus));
                curPaymentStatus = order.paymentStatus;
                $('#order-process').html(getProcessStatus(order.processStatus));
                curProcessStatus = order.processStatus;

                if (order.processStatus === CANCELLED || order.processStatus === SHIPPED) {
                    $('#admin-ord-stt-func').remove();
                } else {
                    $('#admin-ord-stt-func a').html(`<span>Change Process to</span><br><span>${getProcessStatus(order.processStatus + 1)}</span>`);
                }

                if (order.processStatus === CANCELLED) {
                    $('#admin-ord-pay-func').remove();
                } else {
                    $('#admin-ord-pay-func a').html(`<span>Change Payment to</span><br><span>${getPaymentStatus(!order.paymentStatus)}</span>`);
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
                window.location.href = "/admin/orders";
            }
        })
        .catch((err => {
            console.log(err);
        }));

});


function changeStatus() {
    callGetAjax(`/api/v1/admin/order/update/process-status?new-status=${curProcessStatus + 1}&id=${idOrder}`)
        .then(rs => {
            alert(rs.data);
             window.location.href = `/admin/orders/details?id=${idOrder}`;
        }).catch(err => {
        console.log(err);
        alert("Failed to Update");
        window.location.href = `/admin/orders/details?id=${idOrder}`;
    })
}

function changePayment() {
    callGetAjax(`/api/v1/admin/order/update/payment-status?new-status=${!curPaymentStatus}&id=${idOrder}`)
        .then(rs => {
            alert(rs.data);
            window.location.href = `/admin/orders/details?id=${idOrder}`;
        }).catch(err => {
            console.log(err);
            alert("Failed to Update");
            window.location.href = `/admin/orders/details?id=${idOrder}`;
    })

}