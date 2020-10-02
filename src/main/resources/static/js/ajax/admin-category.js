var adminCategoryList;

$(document).ready(function() {
    adminCategoryList = $('#admin-cat-list');
    loadAdminCategoryList();
});

function loadAdminCategoryList() {
    callGetAjax(`/api/v1/public/category/all`).then(rs => {
        if (rs.result === "found") {
            rs = rs.data;

            let content = '';
            rs.map(item => {
                content += getAdminCategoryRow(item)
            });
            adminCategoryList.html(content);
        }
    }).catch(err => {
        console.log(err);
    })
}

function validatePriorInput(){
// check input value: positive integer
    var priorInput = $('#cat-priority');
    var prior = parseInt(priorInput.val());
    if (isNaN(prior) || prior <= 0) {
        priorInput.val('');
        alert("Invalid Priority");
    }
}

function addCategory() {
// create form =(catName, priority) and call api upload AdminCategoryController
// alert the result message
    var catName = $('#cat-name').val();
    var priority = $('#cat-priority').val();

    if (validatePriorInput()) {
        return;
    } else if (catName.trim().length === 0) {
        alert('Missing category name');
        return;
    }

    const categoryForm = {
        catName: catName,
        priority: priority
    };

    console.log(categoryForm);

    callPostAjax("/api/v1/admin/category/upload", categoryForm)
        .then(rs => {
            if (rs.result === "uploaded") {
                alert('Upload successfully');
                $('#cat-name').val("");
                $('#cat-priority').val("");
                loadAdminCategoryList();
            } else {
                alert('Upload fail');
            }
        })
        .catch((err => {
            console.log(err)
        }));

}

function getAdminCategoryRow(item) {
    return `<tr>
                <td>${item.catName}</td>
                <td>${item.priority}</td>
            </tr>`;

}