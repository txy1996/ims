// 展示提示框
function showTips(content) {
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}

//删除单条日志
$(".log-list").on("click", ".delete-this-log", function () {
    var logTr = $(this).parents("tr");
    var gbid = logTr.find(".gbid").html();
    console.log(gbid)
    if (confirm('请确认是否删除该条日志')) {
        console.log(gbid)
        $.ajax({
            url: "../guest/delete.html",
            data: {ids: JSON.stringify([gbid])},
            type: "POST",
            success: function (data) {
                logTr.remove();

            },
            error: function () {
                alert("删除失败！");
            }
        });
    }
});
//用户留言详情
$(".log-list").on("click", ".Message-details", function () {
    var logTr = $(this).parents("tr");
    var gbid = logTr.find(".gbid").html();
    var username = logTr.find(".username").html();
    var gbinfo = logTr.find(".gbinfo").html();
    var gbdate = logTr.find(".gbdate").html();
    $.ajax({
        url: "../guest/getGuestBookDetails.html",
        dataType: "json",// 特别重要
        data: {
            gbid: gbid
        },
        type: "POST",
        success: function (data) {
            var tem = "<div id=\"UserComments\">\n" +
                "<input type=\"hidden\" name=\"auid\" value=\"" + gbid + "\">" +
                "<strong>名称:</strong><span>" + username + "</span>\n" +
                "  <strong>时间:</strong><span>" + gbdate + "</span>\n" +
                " <div>\n" +
                " <p>" + gbinfo + "</p>\n" +
                " </div>\n" +
                " <HR align=center width=100% color=#987cb9 SIZE=8>\n" +
                "</div>"
            $("#UserComments").html(tem)
            var tem1 = "<div id=\"Reply\" align=\"right\">";
            for (var i = 0; i < data.length; i++) {
                tem1 += "<div>\n" +
                    "<strong>名称:</strong><span>系统回复</span>\n" +
                    "<strong>时间:</strong><span>" + data[i].gbdate + "</span>\n" +
                    " <div>\n" +
                    "<p>" + data[i].gbinfo + "</p>\n" +
                    "</div>\n" +
                    "<HR align=center width=100% color=#987cb9 SIZE=8>\n" +
                    " </div>"
            }
            tem1 += "</div>"
            $("#Reply").html(tem1)
        },
        error: function () {

        }
    });
});


function saveGuestBook() {
    $.ajax({
        url: "../guest/saveGuestBook.html",
        data: new FormData($('.guestbook-add-from')[0]),
        type: "POST",
        processData: false,
        contentType: false,
        success: function (data) {

            console.log(data)
            alert("回复成功!");
            ue.setContent("");
        },
        error: function () {
            alert("回复失败!");
        }
    });
}


//全选/取消全选出现的active阴影
var active_class = 'active';
$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {
    var th_checked = this.checked;//checkbox inside "TH" table header

    $(this).closest('table').find('tbody > tr').each(function () {
        var row = this;
        if (th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
        else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
    });
});

//单行选中出现active阴影
$('#simple-table').on('click', 'td input[type=checkbox]', function () {
    var $row = $(this).closest('tr');
    if ($row.is('.detail-row ')) return;
    if (this.checked) $row.addClass(active_class);
    else $row.removeClass(active_class);
});

//批量删除日志
$(".delete-selected-confirm").click(function () {
    $("#delete-confirm-dialog").modal("hide");
    var cbs = $("input[name='logIds']:checked")
    if (cbs.length === 0) {
        showTips("您未选择日志！");
    } else {
        var logIds = new Array();
        $.each(cbs, function (i, cb) {
            logIds[i] = cb.value;
        });

        $.ajax({
            url: "../guest/deleteGuestBook.html",
            data: {ids: JSON.stringify(logIds)},
            type: "POST",
            traditional: true,
            success: function () {
                cbs.parent().parent().parent().remove();
                showTips("删除所选成功！");
            }
        });
    }
});
