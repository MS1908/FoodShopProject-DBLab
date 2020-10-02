var adminPromoAppliedList;
var adminPromoToApplyList;

var appliedList = [];
var toApplyList =  [{username : 'Minh', totalSpense : '100000'},
                    {username : 'Long', totalSpense : '1000000'},
                    {username : 'Thanh', totalSpense : '2000000'}
                    ];

$(document).ready(function() {
    adminPromoAppliedList = $('#admin-promo-applied-user-list');
    adminPromoToApplyList = $('#admin-promo-user-list');
    loadCustomerList();
});

function loadCustomerList() {
    callGetAjax("/api/v1/admin/promotion/apply-list").then(rs => {
            if (rs.result === "found") {
                rs = rs.data;
                toApplyList = rs;
                updateToApplyList();
            }
        }
    ).catch(err => {
        console.log(err);
    })
}

function getAppliedRow(item) {
    return `<tr id="${item.username}" class = "text-center">
                <td>${item.username}</td>
                <td>
                     <div class="form-group">
                         <a onclick="return removeCustomer(${item.username})" class="btn py-3 px-4 btn-primary" style="color: white">Remove</a>
                     </div>
                </td>
            </tr>`;
}

function getToApplyRow(item) {
    return `<tr id="${item.username}" class = "text-center">
                <td>${item.username}</td>
                <td class = "total">${item.totalSpense}</td>
                <td>
                     <div class="form-group">
                         <a onclick="return addCustomer(${item.username})" class="btn py-3 px-4 btn-primary" style="color: white">Add</a>
                     </div>
                </td>
            </tr>`;
}

function createCoupon() {
    var couponCode = $('#coupon-code').val();
    var discount = $('#coupon-discount').val();
    var expiredDate = $('#coupon-date').val();

    const promotionForm = {
        couponCode : couponCode,
        discount : discount,
        expiredDate : expiredDate,
        receivers : appliedList.map(user => user.username)
    };

    console.log(promotionForm);

    callPostAjax(`/api/v1/admin/promotion/submit`, promotionForm)
        .then(rs => {
            alert(rs.data);
            window.location.href = "/admin/promotions";
        }).catch(err => {
            console.log(err);
            alert("Internal Server Error! Try again later.");

    });
}

function addAll() {
    appliedList = appliedList.concat(toApplyList.splice(0, toApplyList.length));

    updateAppliedList();
    updateToApplyList();
}

async function addCustomer(username) {

    let idxToAdd = await (async () =>
    {
        for (let i = 0; i < toApplyList.length; i++) {
            if (toApplyList[i].username === username) {

                return i;
            }
        }
    });
    appliedList.unshift(toApplyList.splice(idxToAdd, 1)[0]);

    updateAppliedList();
    updateToApplyList();
}

function removeAll() {
    toApplyList = toApplyList.concat(appliedList.splice(0, appliedList.length));

    updateAppliedList();
    updateToApplyList();
}

async function removeCustomer(username) {
    let idxToRemove = await (async () =>
    {
        for (let i = 0; i < appliedList.length; i++) {
            if (appliedList[i].username === username) {
                return i;
            }
        }
    });
    toApplyList.unshift(appliedList.splice(idxToRemove, 1)[0]);

    updateAppliedList();
    updateToApplyList();
}

function updateAppliedList() {
    var htmlRet =   `<tr>
                    <td> </td>
                    <td>
                        <div class="form-group">
                            <a onclick="return removeAll()" class="btn py-3 px-4 btn-primary" style="color: white">Remove all</a>
                        </div>
                    </td>
                </tr>`;
    appliedList.map(item => htmlRet += getAppliedRow(item));
    adminPromoAppliedList.html(htmlRet);
}

function updateToApplyList() {
    var htmlRet =   `<tr>
                    <td> </td>
                    <td> </td>
                    <td>
                        <div class="form-group">
                            <a onclick="return addAll()" class="btn py-3 px-4 btn-primary" style="color: white">Add all</a>
                        </div>
                    </td>
                </tr>`;
    toApplyList.map(item => htmlRet += getToApplyRow(item));
    adminPromoToApplyList.html(htmlRet);
}