// implement save Product

var idProd;
var idCategory;
var initProdImg;
var prodCatSelect;

$(document).ready(function() {
    loadProduct();
});

function loadCat() {
    prodCatSelect = $('#prod-cat');
    callGetAjax("/api/v1/public/category/all").then(rs => {
        if (rs.result === "found") {
            rs = rs.data;
            var content = '';
            rs.map(cat => {
                console.log(cat.catName);
                content += `<option value="${cat.idCat}">${cat.catName}</option>`
            });
            prodCatSelect.html(content);
            updateProdCat(idCategory);
        }
    }).catch(err => {
        console.log(err)
    });
}

function loadProduct() {
    if (window.location.href.endsWith('new')) {
        initProdImg = "Sample.jpg";
        idProd = null;
        idCategory = 6;
        loadCat();
    } else {
        idProd = new URL(window.location.href).searchParams.get("id");
        callGetAjax(`/api/v1/public/product/id?id=${idProd}`)
            .then(rs => {
                if (rs.result === "found") {
                    rs = rs.data;
                    $("#prod-id").val(rs.idProd);
                    $("#prod-name").val(rs.prodName);
                    $("#prod-price").val(rs.price);
                    // product img
                    initProdImg = rs.image;
                    resetImgInput();
                    // product category
                    idCategory = rs.category.idCat;
                    loadCat();
                }
            })
            .catch(err => {
                console.log(err);
                alert("Don't abuse the software please");
                window.location.href = "/admin";
            });
    }
}

function updateProdCat(idCate) {
     prodCatSelect.val(idCate).change();
}

function loadImage(input) {
    if (input.files && input.files[0]) {
        console.log(input.files);
        var prodImgBlock = $('#product-image');
        prodImgBlock.attr("src", URL.createObjectURL(input.files[0]));
        console.log(input.files);
    }
}

async function saveProduct() {
    var idProd = $('#prod-id').val();
    var prodName = $('#prod-name').val();
    var price = $('#prod-price').val();
    var image = await uploadProdImg();
    var idCat = $('#prod-cat').val();
    var deleted = false;

    if($("input[type='radio'].form-control").is(':checked')) {
        var deleted_type = $("input[type='radio'].form-control:checked").val();
    }
    if (deleted_type === "deleted") deleted = true;
    
    const productForm = {
        idProd: idProd,
        prodName: prodName,
        price: price,
        image: image,
        deleted: deleted,
        idCat: idCat
    };
    console.log(productForm);

    var postProdURL = "/api/v1/public/demo/product/update";
    if (window.location.href.includes('new'))
         postProdURL = "/api/v1/admin/product/upload";
    else
         postProdURL = "/api/v1/admin/product/update";

    
    await callPostAjax(postProdURL, productForm)
           .then(rs => {
                console.log(rs.result + " : " + rs.data);
                alert(rs.result);
                window.location.href = "/admin/products";
           })
           .catch((err => {
               console.log(err)
               alert(rs.result);
               window.location.href = "/admin/products";
           }));
}

async function uploadProdImg() {
    let prodImgName = initProdImg;
    let imgFileInput = $('#prod-img-file')[0];
    var imgFile = (imgFileInput.files && imgFileInput.files[0]) ? imgFileInput.files[0] : null;
    if (imgFile !== null) {
        var prodImg = new FormData();
        prodImg.append("imageFile", imgFile);

        await callPostAjaxWithFiles("/api/v1/public/file/upload/prod-img", prodImg)
            .then(rs => {
                if (rs.result === "uploaded") prodImgName = rs.data;
                console.log(rs.data);
            })
            .catch((err => {
                console.log(err)
            }));
    } 
    return prodImgName;
}

function resetImgInput() {
    $('#prod-img-file').val('');
    var productUrl = `/resources/img/back-end/${initProdImg}`;
    $('#product-image-url').attr("href", productUrl);
    $('#product-image').attr("src", productUrl);
}

function deleteProduct() {
    callPutAjax(`/api/v1/admin/product/delete?id=${idProd}`, '')
        .then(rs => {
            if (rs.result === "deleted") {
                alert("Delete the product");
                window.location.href = "/admin/products";
            }
        })
        .catch(err => {
            console.log(err);
            alert("Don't abuse the software please");
            window.location.href = "/admin/products";
        })
}

function cancel() {
    window.location.href = "/admin/products";
}