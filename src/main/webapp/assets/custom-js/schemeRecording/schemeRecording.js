// 展示提示框
function showTips(content) {
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
    setTimeout("hideTips()", 2500);
}

function hideTips() {
    $("#op-tips-dialog").modal("hide");
    window.location.reload()
}

// 点击上传商品id
$(".user-tbody").on(
    "click",
    ".carry-out",
    function () {
        var userTr = $(this).parents("tr");
        var srid = userTr.find(".srid").html();
        var status = userTr.find(".statusValue").html();
        if(status!=2){
            $.ajax({
                type: "post",
                url: "../schemeRecording/updateSchemeRecording.html",
                dataType: "json",// 特别重要
                data: {
                    status: ++status,
                    srid: srid,
                },
                success: function (data) {
                    var url = "../schemeRecording/list";
                    window.location.href = url
                },
                error: function () {
                },
            })
        }


    });
