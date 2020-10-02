

function loadCategoryList() {
    console.log("Load Categories ...");
    callGetAjax("/api/v1/public/category/all").then (rs => {
        if (rs.result === "found") {
            rs = rs.data;
            let content = '<li><a idCat="0" onclick="return loadProductList(0)">All</a></li>';
            rs.map(item => {
                console.log(item.catName);
                content += `<li><a idCat="${item.idCat}" onclick="return loadProductList(${item.idCat})">${item.catName}</a></li>`;
            });
            categoryList.html(content);
        }
    }).catch(err => {
        console.log(err)
    })
}

function updateCategoryList(idCat) {
    categoryList.find('a').each(function() {
        if ($(this).attr('idCat') == idCat) {
            $(this).addClass('active');
        } else $(this).removeClass('active');
    })
}