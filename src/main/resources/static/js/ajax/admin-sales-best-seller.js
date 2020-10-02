var body;

$(document).ready(function() {
    body = $('#admin-best-seller');
    loadBestSellerCategory();
});

function loadBestSellerCategory() {
    callGetAjax(`/api/v1/admin/product/best-sellers/category?month=7`).then(rs => {
        if (rs.result === "found") {
            rs = rs.data;
            let content = '';
            for (const [key, value] of Object.entries(rs)) {
                content += getBestSellerCategoryBlock(key, value);
            }
            body.html(content);
        }
    }).catch(err => {
        console.log(err);
    })
}

function getBestSellerCategoryBlock(key, value) {
    console.log(key);
    console.log(value);
    var bestSellerBlocks = "";
    value.map(item => {
        console.log(item);
        bestSellerBlocks += getBestSellerBlock(item);
    });

    return`<div class="container">
        <div class="row justify-content-center mb-3 pb-3">
            <div class="col-md-12 heading-section text-center ftco-animate fadeInUp ftco-animated">
                <span class="subheading">Products</span>
                <h2 class="mb-4">${key}</h2>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row justify-content-center mb-3 pb-3">
            ${bestSellerBlocks}
        </div>
    </div>`;
}

function getBestSellerBlock(item) {
    return `<div class="col-md-6 col-lg-3 ftco-animate fadeInUp ftco-animated">
                <div class="product">
                    <a href="/product?id=${item.idProd}" class="img-prod"><img class="img-fluid" src="/resources/img/back-end/${item.image}" alt=""><span class="status">HOT</span><div class="overlay"></div></a>
                    <div class="text py-3 pb-4 px-3 text-center">
                        <h3><a href="/product?id=${item.idProd}">${item.prodName}</a><span style="color: red !important"> - ${item.qty}</span></h3>
                    </div>
                </div>
            </div>`
}