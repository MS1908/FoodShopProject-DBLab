$(document).ready(function() {
    $('#coupon').val('');
    prefillForm();
    calculateBill();
});

function prefillForm() {
    callGetAjax(`/api/v1/customer/app-user/basic-info?username=${localStorage.getItem("username")}`)
        .then(rs => {
            if (rs.result === "found") {
                rs = rs.data;
                $('#full-name').val(rs.fullname);
                $('#ship-address').val(rs.address);
                $('#phone').val(rs.phone);
                $('#email-address').val(rs.email);
            } else {
                alert("Your info not available");
            }
        })
        .catch((err => {
            console.log(err)
        }));
}

function calculateBill() {
    var subTotal = 0;
    JSON.parse(sessionStorage.getItem("cartList")).map(cartItem => {
        callGetAjax(`/api/v1/public/product/id?id=${cartItem.idProd}`)
            .then(rs => {
                if (rs.result === "found") {
                    var item = rs.data;
                    subTotal += parseInt(item.price) * parseInt(cartItem.qty);
                    $('#cart-subtotal').html(subTotal);
                    $('#cart-total').html(parseFloat(subTotal) + parseFloat($('#cart-delivery-fee').html()));
                }
            }).catch(err => console.log(err));
    });
}


function submitOrder() {
    var fullName= $('#full-name').val();
    var address = $('#ship-address').val();
    var phone   = $('#phone').val();
    var email   = $('#email-address').val();
    var coupon  = $('#coupon').val();

    if (!validateEmail(email)) {
        alert("This email might not exist on God's green earth");
        return;
    }

    const orderForm = {
        username: localStorage.getItem("username"),
        fullName: fullName,
        address: address,
        phone: phone,
        email: email,
        coupon: coupon,
        cartItems: JSON.parse(sessionStorage.getItem("cartList"))
    };

    console.log(orderForm);

    callPostAjax("/api/v1/customer/order/submit", orderForm)
        .then(rs => {
            if (rs.result === "uploaded") {
                sessionStorage.setItem("cartList", JSON.stringify([]));
                alert('Your order is successfully submitted!');
                window.location.href = "/customer/orders";
            } else {
                $('#coupon').val('');
                alert('You order is failed to upload. Please try again.');
            }
        })
        .catch((err => {
            console.log(err);
            $('#coupon').val('');
            alert('You order is failed to upload. Please try again.');
        }));
}

function validateCoupon() {
    // call ajax to check if the username can use the coupon or not
    var validateCouponResult = $('#valid-coupon-noti');
    var username = localStorage.getItem("username");
    var coupon = $('#coupon').val();
    console.log(username + " " + coupon);
    callGetAjax(`/api/v1/customer/promotion/check-valid?cus-uname=${username}&cp-code=${coupon}`)
        .then(rs => {
            if (rs.result === "found") {
                validateCouponResult.css("color", "green");
                validateCouponResult.html("Successfully applied")
                var rawTotal = parseFloat($('#cart-subtotal').html()) + parseFloat($('#cart-delivery-fee').html());
                var discount = rs.data.discount / 100 * parseFloat(rawTotal);
                $('#cart-discount').html(discount);
                $('#cart-total').html(rawTotal - discount);
            } else {
                $('#coupon').val('');
                validateCouponResult.css("color", "red");
                validateCouponResult.html(rs.data)
            }
        })
        .catch((err => {
            console.log(err);
            $('#coupon').val('');
            alert("You cant mess with us boo!");
            logout();
    }));
}

function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}