function showTips(content) {
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
    setTimeout("hideTips()", 2500);

}

function hideTips() {
    $("#op-tips-dialog").modal("hide");
    window.location.reload()
}

//删除订单记录
$(".perm-list").on("click", ".delete-this-perm", function () {
    var permTr = $(this).parents("tr");
    var oid = permTr.find(".oid").html();
    if (confirm('确认删除该条记录吗？')) {
        //请求删除该权限
        $.ajax({
            url: "delete.html",
            data: {id: oid},
            type: "POST",
            success: function () {
                permTr.remove();
                showTips("删除成功！");
            },
            error: function () {
                showTips("删除失败！");
            }
        });
    }
});

// 更新订单
$(".perm-list").on("click", ".show-update-form", function () {
    var userTr = $(this).parents("tr");
    var oid = userTr.find(".oid").html();
    var oshname = userTr.find(".oshname").html();
    var oshtel = userTr.find(".oshtel").html();
    var oshaddress = userTr.find(".oshaddress").html();
    var ostae = $("#ostae" + oid + "").val()
    $("#ostae").val(ostae)
    $("#oshname").val(oshname)
    $("#oshaddress").val(oshaddress)
    $("#oshtel").val(oshtel)
    $("#oid").val(oid)
});


// 更新订单
$(".modal-footer").on("click", ".perm-submit", function () {
    $.ajax({
        url: "../order/update1.html",
        data: new FormData($('.order-form')[0]),
        type: "POST",
        processData: false,
        contentType: false,
        success: function () {
            $("#perm-form-div").modal("hide");
            showTips("更新成功！");
        },
        error: function () {
            showTips("更新失败！");
        }
    });
});

/*条件查询*/
$(".scheme-filter").on("click", ".QueryButton", function () {
    var ostae = $("#OrderStatus option:selected");
    var oisinvoice = $("#needRecite option:selected");
    var oshtel = $("#phone").val();
    var oexpresssn = $("#trackingnumber").val();
    var url = "../order/findOrderAll?ostae=" + ostae.val() + "&oisinvoice=" + oisinvoice.val() + "&oshtel=" + oshtel + "&oexpresssn=" + oexpresssn;
    window.location.href = url

});

function Selected() {
    var status = $("#selectStatus").val()
    var spnum = $("#selectspnum").val()
    var duration = $("#selectduration").val()
    var srange = $("#selectsrange").val()
    console.log(status)
    console.log(spnum)
    console.log(duration)
    console.log(srange)
    if (status != "") {
        $("#OrderStatus").val(status)
    }
    if (spnum != "") {
        $("#needRecite").val(spnum)
    }
    if (duration != "") {
        $("#phone").val(duration)
    }
    if (srange != "") {
        $("#trackingnumber").val(srange)
    }
}

$(document).ready(function () {
    // Selected()
});
