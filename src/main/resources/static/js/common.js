const tokenHeader_value = localStorage.getItem("token");
console.log(tokenHeader_value);

var passwordAdmin = '';
var dmLoaiXas = [];

if (sessionStorage.getItem("cartList") === null || sessionStorage.getItem("cartList") === "") sessionStorage.setItem("cartList", JSON.stringify([]));
if (sessionStorage.getItem("wishList") === null || sessionStorage.getItem("wishList") === "") sessionStorage.setItem("wishList", JSON.stringify([]));


function formatNumber(nStr, decSeperate, groupSeperate) {
    nStr += '';
    x = nStr.split(decSeperate);
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
    }
    return x1 + x2;
}

function formatMoney(money) {
    return formatNumber(money, ".", ".");
}

function mathRound(x){
    var n = parseFloat(x);
    var dt = Math.round(n * 1000)/1000;
    return dt;
}

// Replaces all instances of the given substring.
String.prototype.replaceAllll = function (
    strTarget, // The substring you want to replace
    strSubString // The string you want to replace in.
) {
    var strText = this;
    var intIndexOfMatch = strText.indexOf(strTarget);

// Keep looping while an instance of the target string
// still exists in the string.
    while (intIndexOfMatch !== -1) {
// Relace out the current instance.
        strText = strText.replace(strTarget, strSubString);

// Get the index of any next matching substring.
        intIndexOfMatch = strText.indexOf(strTarget);
    }

// Return the updated string with ALL the target strings
// replaced out with the new substring.
    return (strText);
};

async function redirect(url) {
    $.ajax({
        url: "/app/test",
        type: "GET",
        beforeSend: function(xhr) {
            xhr.setRequestHeader('Authorization', 'Basic ' + encoded);
        },
        success: function() {
            setTimeout(function() {
                window.location.href = '/app/test.html';
            }, 333);
        }
    });
}

async function callPostAjaxWithFiles(url, formWithFiles){
    let rs = null;
    await $.ajax({
        type: "POST",
        url: url,
        data: formWithFiles,
        enctype: 'multipart/form-data',
        contentType: false,
        processData: false,
        cache: false,
        success: function (result) {
            rs = result;
        },
        error: function (err) {
            console.log(err);
        }
    });
    return rs;
}

function print(str){
    console.log(str);
}

function redirect(href){
    window.location.href = href;
}

async function callGetAjax(url) {
    let rs = null;
    await $.ajax({
        async: false,
        type: 'GET',
        url: url,
        headers: {
            "Authorization": tokenHeader_value,
        },
        dataTypes: "json",
        timeout: 3000,
        success: function (result) {
            rs = result;
        }
    });
    return rs;
}

async function callPostAjax(url, payload) {
    let rs = null;
    await $.ajax({
        type: "POST",
        url: url,
        timeout: 10000,
        contentType: "application/json",
        data: JSON.stringify(payload),
        headers: {
            "Authorization": tokenHeader_value,
        },
        success: function (result) {
            rs = result;
        },
        error: function (error) {
            console.log(error);
        }
    });
    return rs;
}

async function callPutAjax(url, payload) {
    let rs = null;
    await $.ajax({
        type: "PUT",
        url: url,
        contentType: "application/json",
        data: JSON.stringify(payload),
        headers: {
            "Authorization": tokenHeader_value,
        },
        success: function (result) {
            rs = result;
        },
        error: function (error) {
            console.log(error);
        }
    });
    return rs;
}

async function callDeleteAjax(url) {
    let rs = null;
    await $.ajax({
        type: "PUT",
        url: url,
        headers: {
            "Authorization": tokenHeader_value,
        },
        success: function (result) {
            rs = result;
        },
        error: function (error) {
            console.log(error);
        }
    });
    return rs;
}

function errMess(jqXHR, textStatus, errorThrown) {
    console.log('jqXHR:');
    console.log(jqXHR);
    console.log('textStatus:');
    console.log(textStatus);
    console.log('errorThrown:');
    console.log(errorThrown);
}
