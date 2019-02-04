var path = $("#sysPath").val();

// 展示提示框
function showTips(content) {
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}

// 重置用户表单
function resetUserForm(title, button) {
    $(".user-form-title").html(title);
    $("#AlternativeShop").html("");
    $("#stagename").val("");
    $("#stagessinfo").val("");
    $("#lssids").val("");
    $("#labellid").val("")
    $("#ztsid").val("");
    $("#sssid").val("");
    $("#sreplace").val("");
    $(".labelinput").html("")
    $("#treeview").hide();
    $('#tagsinputval').tagsinput('removeAll');
    $("#txt_departmentname").val("");
    $("#commoditytreeview").hide();
    $("#txt_commodity").val("");

    $(".user-submit").html('<i class="ace-icon fa fa-check"></i>' + button);
}

// 添加用户框体
$(".show-add-form").click(
    function () {
        resetUserForm("添加阶段", "添加");
        $(".user-form input[type='radio'][name='state'][value='1']").prop(
            "checked", true);

    });

// 更新阶段
$(".user-list")
    .on(
        "click",
        ".show-update-form",
        function () {
            var userTr = $(this).parents("tr");
            var ssname = userTr.find(".stagessname").val();
            var ssinfo = userTr.find(".ssinfo").val()
            var ssid = userTr.find(".ssid").val()
            var sname = userTr.find(".sname").val()
            var shopid = userTr.find(".shopid").val()
            var slogo = userTr.find(".slogo").val()
            var sssid = userTr.find(".sssid").val()
            var lssid = userTr.find(".lssid").val()
            var sreplace = userTr.find(".sreplace").val()
            resetUserForm("编辑:" + ssname + "", "更新");
            $
                .ajax({
                    url: "../schemeStage/foundProductBySsid.html",
                    dataType: "json",// 特别重要
                    data: {
                        ssid: ssid
                    },
                    type: "POST",
                    success: function (data) {

                        console.log(data)
                        $("#pids").val(data.pid);
                        $("#pnumber").val(data.num);
                        $("#stageId").val(ssid);
                        $("#ResetProductId").val(data.pid);
                        $("#ResetProductNum").val(data.num);
                        $("#stagename").val(ssname);
                        $("#stagessinfo").val(ssinfo);
                        $("#lssids").val(lssid);
                        $("#labellid").val(lssid)
                        $("#ztsid").val(shopid);
                        $("#sssid").val(sssid);
                        $("#sreplace").val(sreplace);
                        $("#schemesid").val($("#sid").val())
                        $(".labelinput").html("")
                        showlabel(ssid)
                    },
                    error: function () {
                        showTips("失败！");
                    }
                });

        });

// 刷新新增界面
$(".page-header")
    .on(
        "click",
        ".show-add-form",
        function () {
            $("#stagename").val("")
            $("#stagessinfo").val("")
            $("#schemesid").val($("#sid").val())

        });

// 添加、更新动作
$(".user-submit")
    .click(
        function () {
            console.log($(this).html().indexOf("添加"))
            if ($(this).html().indexOf("添加") > 0) {
                // 添加新阶段
                $
                    .ajax({
                        url: "../schemeStage/addSchemeStage.html",
                        type: "POST",
                        data: $(".user-form").serialize(),
                        dataType: "json",
                        success: function (data) {
                            $("#user-form-div").modal("hide");
                            showTips("添加成功！");
                            $(".close-tip").click(function () {
                                setTimeout(function () {
                                    window.location.reload()
                                }, 220);
                            })
                            var sid = $("#sid").val()
                            var url = encodeURI("../schemeStage/getSchemeStage?sid="
                                + sid + "")
                            window.location.href = url;
                        },
                        error: function () {
                            showTips("添加失败!");
                        }
                    });
            } else {
                // 更新用户信息
                $
                    .ajax({
                        url: "../schemeStage/updateSchemeStage.html",
                        data: $(".user-form").serialize(),
                        dataType: "json",
                        type: "POST",
                        success: function (data) {
                            $("#user-form-div").modal("hide");
                            showTips("更新成功!");
                            $(".close-tip").click(function () {
                                setTimeout(function () {
                                    window.location.reload()
                                }, 220);
                            })
                            var sid = $("#sid").val()
                            var url = encodeURI("../schemeStage/getSchemeStage?sid="
                                + sid + "")
                            window.location.href = url;
                        },
                        error: function () {
                            showTips("更新失败!");
                        }
                    });
            }
        });

// 查询标签
$(".addandupdatediv")
    .on(
        "click",
        "#Presetlabel",
        function () {
            $
                .ajax({
                    url: "../label/foundLabelAll.html",
                    dataType: "json",// 特别重要
                    data: {},
                    type: "POST",
                    success: function (data) {
                        console.log(data)
                        var tem = "";
                        for (var i = 0; i < data.length; i++) {
                            var z = i % 6;
                            switch (z) {
                                case 0:
                                    var class0 = "label-default";
                                    break;
                                case 1:
                                    var class0 = "label-primary"
                                    break;
                                case 2:
                                    var class0 = "label-success"
                                    break;
                                case 3:
                                    var class0 = "label-info"
                                    break;
                                case 4:
                                    var class0 = "label-warning"
                                    break;
                                case 5:
                                    var class0 = "label-danger"
                                    break;
                            }
                            tem += "<span class='label "
                                + class0
                                + "' "
                                + "style='height:25px; margin: 0 10px 10px 0;'>"
                                + "<input type='checkbox' name='label' "
                                + "' value='" + data[i].lid
                                + "," + data[i].lcinfo + "' />"
                                + " " + data[i].lcinfo
                                + "</span>"
                        }

                        $("#selectlabel").html(tem)

                    },
                    error: function () {

                    }
                });

        });

// Bootstrap modal 多弹窗之叠加引起的滚动条遮罩阴影问题
$('#myModal').on('hidden.bs.modal', function () {
    setTimeout(function () {
        $('body').addClass('modal-open')
    }, 100)

})

// Bootstrap modal 多弹窗之叠加引起的滚动条遮罩阴影问题
$('#myshop').on('hidden.bs.modal', function () {
    $("#merchantlist").val("")
    $("#shopname").html("")
    $("#featuredshopimg").html("")
    $("#shopinfo").text("")
    setTimeout(function () {
        $('body').addClass('modal-open')
    }, 100)

})
// Bootstrap modal 多弹窗之叠加引起的滚动条遮罩阴影问题
$('#myalbum').on('hidden.bs.modal', function () {
    setTimeout(function () {
        $('body').addClass('modal-open')
    }, 100)
})
$('#property').on('hidden.bs.modal', function () {
    setTimeout(function () {
        $('body').addClass('modal-open')
    }, 100)
})
$('#mygoodsModal').on('hidden.bs.modal', function () {
    $("#paging").html("");
    setTimeout(function () {
        $('body').addClass('modal-open')
    }, 100)
})
$('#user-form-div').on('hidden.bs.modal', function () {
    $("#pids").val("");
    $("#pnumber").val("");
    $("#goodsinfo").html("")


})
// Bootstrap modal 多弹窗之叠加引起的滚动条遮罩阴影问题
$('#exampleModal').on('hidden.bs.modal', function () {
    $("#shopnametwo").html("")
    $("#merchantlisttwo").val("")
    setTimeout(function () {
        $('body').addClass('modal-open')
    }, 100)

})


// 按键事件
$(".modal-body").on(
    "keyup",
    ".merchantlist",
    function () {
        var merchantlist = $("#merchantlist").val()
        var merchantlisttwo = $("#merchantlisttwo").val()
        if (merchantlist.length >= 1 || merchantlisttwo.length >= 1) {
            $("#shopname").html("")
            $("#shopnametwo").html("")
            if (merchantlist == "") {
                merchantlist = merchantlisttwo
            }

            $.ajax({
                url: "../shop/getByShopName.html",
                dataType: "json",// 特别重要
                data: {
                    sname: merchantlist
                },
                type: "POST",
                success: function (data) {

                    var tem = "";
                    for (var i = 0; i < data.length; i++) {
                        tem += "<option value='" + data[i].sname + "' "
                            + "data-value='" + data[i].sname + " ' "
                            + "data-id='" + data[i].sid + "'>";
                    }
                    $("#shopname").html(tem)
                    $("#shopnametwo").html(tem)

                },
                error: function () {
                    showTips("失败！");
                }
            });
        }
    });


// 选择标签后,将其刷新到面板,将标签id集合刷新到位置上
function show() {
    obj = document.getElementsByName("label");
    check_val = [];
    for (k in obj) {
        if (obj[k].checked)
            check_val.push(obj[k].value);
    }
    if (check_val.length > 10) {
        alert("对不起,此次操作无效,只能选择10个标签,现在已选择'" + check_val.length + "' 个")
        return;
    }
    var tem = ""
    var labellid = ""
    for (var i = 0; i < check_val.length; i++) {
        var m = check_val[i].split(",");
        var z = i % 6;
        switch (z) {
            case 0:
                var class0 = "label-default";
                break;
            case 1:
                var class0 = "label-primary"
                break;
            case 2:
                var class0 = "label-success"
                break;
            case 3:
                var class0 = "label-info"
                break;
            case 4:
                var class0 = "label-warning"
                break;
            case 5:
                var class0 = "label-danger"
                break;
        }
        if (labellid == "") {
            labellid += m[0];
        } else {
            labellid += "," + m[0];
        }
        tem += "<span class='label " + class0 + "' "
            + "style='height:25px; margin: 0 10px 10px 0;'>" + " " + m[1]
            + "</span>"

    }
    $("#labellid").val(labellid)
    $(".labelinput").html(tem)
}

function spare(i) {
    $("#numzero").val(i)

}


// __________________________________________________________________

// 标签分类树
var jsonDataTree = [];

$(function () {
    $.ajax({
        type: "post",
        url: "../labelclass/selectall.html",
        dataType: "json",// 特别重要
        success: function (data) {

            jsonDataTree = transData(data, 'lcid', 'lclcid', 'nodes');

        },
        error: function () {
            toastr.error('Error');
        },
    });

});

function transData(a, idStr, pidStr, chindrenStr) {
    var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;
    for (; i < len; i++) {
        hash[a[i][id]] = a[i];

    }
    for (; j < len; j++) {
        var aVal = a[j], hashVP = hash[aVal[pid]];
        if (hashVP) {
            !hashVP[children] && (hashVP[children] = []);
            hashVP[children].push(aVal);
        } else {
            r.push(aVal);
        }
    }
    return r;
}

$("#txt_departmentname").click(function () {
    var options = {
        bootstrap2: false,
        showTags: true,
        levels: 1,
        highlightSelected: true,
        showCheckbox: false,
        backColor: "#FCFCFC",// 背景色
        onhoverColor: "#00868B",// 鼠标悬浮颜色
        selectedColor: "yellow",// 选中颜色
        checkedIcon: "glyphicon glyphicon-check",
        data: jsonDataTree,
        emptyIcon: "glyphicon",
        collapsed: true,
        onNodeSelected: function (event, data) {
            $("#txt_departmentname").val(data.text);
            QueryAttribute(data.lcid)
            $("#treeview").hide();
            $("#property").modal("show");

        }

    };
    $('#treeview').treeview(options);

});

function QueryAttribute(pcid) {

    $("#pcid").val(pcid)
    $.ajax({
        url: "../label/selectByLcid.html",
        dataType: "json",// 特别重要
        data: {
            lcid: pcid
        },
        type: "POST",
        success: function (data) {

            var tem = "";
            for (var i = 0; i < data.length; i++) {
                var z = i % 6;
                switch (z) {
                    case 0:
                        var class0 = "label-default";
                        break;
                    case 1:
                        var class0 = "label-primary"
                        break;
                    case 2:
                        var class0 = "label-success"
                        break;
                    case 3:
                        var class0 = "label-info"
                        break;
                    case 4:
                        var class0 = "label-warning"
                        break;
                    case 5:
                        var class0 = "label-danger"
                        break;
                }
                tem += "<span class='label " + class0 + "' "
                    + "style='height:35px; margin: 0 10px 10px 0;'>"
                    + "<input type='checkbox' name='label' " + "' value='"
                    + data[i].lid + "," + data[i].lcinfo + "' />" + " "
                    + data[i].lcinfo + "</span>"
            }

            $("#selectproperty").html(tem)

        },
        error: function () {

        }
    });

}

$('#tagsinputval').tagsinput({
    tagClass: function (item) {
        switch (item.continent) {
            case 'Europe':
                return 'badge label-info';
            case 'America':
                return 'badge label-important';
            case 'Australia':
                return 'badge label-success';
            case 'Africa':
                return 'badge badge-inverse';
            case 'Asia':
                return 'badge badge-warning';
        }
    },
    itemValue: 'value',
    itemText: 'text',
    typeahead: {
        source: function (query) {
            return $.getJSON('../assets/cities.json');
        }
    }
});

// 选择标签后,将其刷新到面板,将标签id集合刷新到位置上
function show() {
    obj = document.getElementsByName("label");
    check_val = [];
    for (k in obj) {
        if (obj[k].checked)
            check_val.push(obj[k].value);
    }
    if (check_val.length > 10) {
        alert("对不起,此次操作无效,只能选择10个标签,现在已选择'" + check_val.length + "' 个")
        return;
    }
    var tem = ""
    var labellid = ""
    for (var i = 0; i < check_val.length; i++) {
        var m = check_val[i].split(",");
        $('#tagsinputval').tagsinput('add', {
            "value": m[0],
            "text": m[1],
            "continent": "Africa"
        });
    }
    var newLabelids = $("#tagsinputval").val()
    $("#newLabelids").val(newLabelids)

}

function showlabel(sid) {
    $.ajax({
        dataType: "json",// 预期服务器返回的数据类型
        url: "../scheme/findBySid.html",// url
        data: {
            sid: sid,
            lstype: 1

        },
        type: "POST",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $('#tagsinputval').tagsinput('add', {
                    "value": data[i].lid,
                    "text": data[i].lcinfo,
                    "continent": "Africa"
                });
            }
            var labelids = $("#tagsinputval").val()
            $("#oldLabelids").val(labelids)
            $("#newLabelids").val(labelids)
        },
        error: function () {
            alert("异常！");
        }
    });
}

$('#tagsinputval').on('itemRemoved', function (event) {
    var labelids = $("#tagsinputval").val()
    $("#newLabelids").val(labelids)
});

//删除阶段
$(".user-list").on("click", ".delete-schemestage", function () {
    var userTr = $(this).parents("tr");
    var ssid = userTr.find(".ssid").val();
    console.log(ssid)
    $.ajax({
        url: "../schemeStage/deleteStage.html",
        dataType: "json",// 特别重要
        data: {
            ssid: ssid,

        },
        type: "POST",
        success: function (data) {
            window.location.reload();
        },
        error: function () {
            alert("删除失败！");
        }
    });

});

$("#add").click(function () {
    $("#add1").append("");
});


/*------------------------时间2018-09-20-14:57---------------------------------------------------------------*/
/*商品分类*/
var commodityjsonDataTree = [];
$(function () {
    $.ajax({
        type: "post",
        url: "../productclass/selectAll.html",
        dataType: "json",// 特别重要
        success: function (data) {

            commodityjsonDataTree = commoditytransData(data, 'id', 'cid', 'nodes');

        },
        error: function () {
            toastr.error('Error');
        },
    });
});

/*商品分类*/
function commoditytransData(a, idStr, pidStr, chindrenStr) {
    var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;
    for (; i < len; i++) {
        hash[a[i][id]] = a[i];

    }
    for (; j < len; j++) {
        var aVal = a[j], hashVP = hash[aVal[pid]];
        if (hashVP) {
            !hashVP[children] && (hashVP[children] = []);
            hashVP[children].push(aVal);
        } else {
            r.push(aVal);
        }
    }
    return r;
}

/*商品分类*/
$("#txt_commodity").click(function () {
    var options = {
        bootstrap2: false,
        showTags: true,
        levels: 1,
        highlightSelected: true,
        showCheckbox: false,
        backColor: "#FCFCFC",// 背景色
        onhoverColor: "#00868B",// 鼠标悬浮颜色
        selectedColor: "yellow",// 选中颜色
        checkedIcon: "glyphicon glyphicon-check",
        data: commodityjsonDataTree,
        emptyIcon: "glyphicon",
        collapsed: true,
        onNodeSelected: function (event, data) {
            $("#txt_commodity").val(data.text);
            $("#commoditytreeview").hide();
            ClassificationQuery(data.id, data.text);
            $("#mygoodsModalLabel").text(data.text)
            $("#mygoodsModal").modal("show");
        }

    };
    $('#commoditytreeview').treeview(options);

});

// 根据商品分类查询
function ClassificationQuery(pcid, cname) {
    $.ajax({
        dataType: "json",// 预期服务器返回的数据类型
        url: "../product/findProductByClass.html",// url
        data: {
            pcid: pcid,
            cname: cname,
        },
        type: "POST",
        success: function (data) {
            console.log(data)
            $("#cid").val(pcid)
            PagingData(data);
        },
        error: function () {
            alert("异常！");
        }
    });

}

$(document).mousemove(function (e) {
    x = e.pageX;
    y = e.pageY;
});
/*失去焦点隐藏下拉树--标签分类*/
$("#txt_commodity").blur(function () {
    var id = "commoditytreeview"
    Determinehide(id);
});

/*失去焦点隐藏下拉树--商品分类*/
$("#txt_departmentname").blur(function () {
    var id = "treeview"
    Determinehide(id);
});

function Determinehide(id) {
    //x的值相对于文档的左边缘。y的值相对于文档的上边缘
//x,y是全局变量;
//判断鼠标是否在某DIV中
    var div = $("#" + id + "");//获取你想要的DIV
    var y1 = div.offset().top;  //div上面两个的点的y值
    var y2 = y1 + div.height();//div下面两个点的y值
    var x1 = div.offset().left;  //div左边两个的点的x值
    var x2 = x1 + div.width();  //div右边两个点的x的值

    if (x < x1 || x > x2 || y < y1 || y > y2) {
        $("#" + id + "").hide()
    } else {
        $("#" + id + "").show()
    }
    ;
}

/*分页数据*/
function getResult(pageNum, pageSize) {
    var cid = $("#cid").val()
    var pname = $("#goodsname").val()
    var sname = $("#shopsname").val()
    $.ajax({
        type: "post",
        url: "../product/findProductByClass.html",
        data: {
            pageNum: pageNum,
            pageSize: pageSize,
            pcid: cid,
            sname: sname,
            pname: pname,
        },
        dataType: "json",
        success: function (data) {
            PagingData(data);

        }
    });
}

/*商品分页数据*/
function PagingData(data) {
    goods();
    var pid = $("#pids").val();//阶段下商品id,如果存在,会默认选中
    var pnum = $("#pnumber").val();//商品的数量
    var pids = pid.split(",")
    var pnumber = pnum.split(",")
    var tem = "";
    var flag = true;
    var oldpid = [];
    var oldnum = [];
    var q = 0;
    for (var i = 0; i < data.size; i++) {
        flag = true
        if (pids.length > 0) {
            for (var x = 0; x < pids.length; x++) {
                if (pids[x] == data.list[i].id) {

                    oldpid[q++] = pids[x]
                    oldnum[q++] = pnumber[x]
                    tem += "<tr>\n" +
                        "  <td class=\"center\"><label class=\"pos-rel\"> <input\n" +
                        " type=\"checkbox\" class=\"ace\" name=\"id\" checked='checked' value='" + data.list[i].id + "'/>\n" +
                        " <span class=\"lbl\"></span>\n" +
                        " </label>\n" +
                        "<input type=\"hidden\" name=\"sid\"value='" + data.list[i].sid + "'>\n" +
                        " </td>\n" +
                        "  <td class=\"id\">" + data.list[i].id + "</td>\n" +
                        " <td class=\"cname\">" + data.list[i].cname + "</td>\n" +
                        " <td class=\"sname\">" + data.list[i].sname + "</td>\n" +
                        " <td class=\"pname\">" + data.list[i].pname + "</td>\n" +
                        " <td class=\"pnum\"><input  class='num-css' type=\"number\" name=\"pnum\" min=\"1\" max=\"10000\" value='" + pnumber[x] + "'/></td>\n" +
                        " </tr>"
                    flag = false
                }
            }
            if (flag) {
                tem += "<tr>\n" +
                    "  <td class=\"center\"><label class=\"pos-rel\"> <input\n" +
                    " type=\"checkbox\" class=\"ace\" name=\"id\" value='" + data.list[i].id + "'/>\n" +
                    " <span class=\"lbl\"></span>\n" +
                    " </label>\n" +
                    "<input type=\"hidden\" name=\"sid\"value='" + data.list[i].sid + "'>\n" +
                    " </td>\n" +
                    "  <td class=\"id\">" + data.list[i].id + "</td>\n" +
                    " <td class=\"cname\">" + data.list[i].cname + "</td>\n" +
                    " <td class=\"sname\">" + data.list[i].sname + "</td>\n" +
                    " <td class=\"pname\">" + data.list[i].pname + "</td>\n" +
                    " <td class=\"pnum\"><input  class='num-css' type=\"number\" name=\"pnum\" min=\"1\" max=\"10000\" value='1'/></td>\n" +
                    " </tr>"
            }
        } else {
            tem += "<tr>\n" +
                "  <td class=\"center\"><label class=\"pos-rel\"> <input\n" +
                " type=\"checkbox\" class=\"ace\" name=\"id\" value='" + data.list[i].id + "'/>\n" +
                " <span class=\"lbl\"></span>\n" +
                " </label>\n" +
                "<input type=\"hidden\" name=\"sid\"value='" + data.list[i].sid + "'>\n" +
                " </td>\n" +
                "  <td class=\"id\">" + data.list[i].id + "</td>\n" +
                " <td class=\"cname\">" + data.list[i].cname + "</td>\n" +
                " <td class=\"sname\">" + data.list[i].sname + "</td>\n" +
                " <td class=\"pname\">" + data.list[i].pname + "</td>\n" +
                " <td class=\"pnum\"><input  class='num-css' type=\"number\" name=\"pnum\" min=\"1\" max=\"10000\" value='1'/></td>\n" +
                " </tr>"
        }


    }

    $("#goodsinfo").html(tem)
    $("#goodsId").val(oldpid)
    $("#goodsNum").val(oldnum)
    if (data.total > 0) {
        createPageNav({
            $container: $("#paging"),
            pageCount: data.lastPage,
            currentNum: data.pageNum,
            maxCommonLen: 5,
            afterFun: function (num) {
                getResult(num, 8);
            }
        });
    }
}

/*获取选中的商品*/
function GetTheProductId() {
    goods();
    var pids = $("#pids").val()
    var pnumber = $("#pnumber").val()
    console.log(pids)
    console.log(pnumber)
    $("#ResetProductId").val(pids);
    $("#ResetProductNum").val(pnumber);
    var oldpid = [];
    var oldnum = [];
    $("#goodsId").val(oldpid)
    $("#goodsNum").val(oldnum)
    $("#mygoodsModal").modal("hide");

}

/*取消后重新加载数据*/
function ReloadData() {

    var ResetProductId = $("#ResetProductId").val();
    var ResetProductNum = $("#ResetProductNum").val();
    console.log(ResetProductId)
    console.log(ResetProductNum)
    $("#pids").val(ResetProductId);
    $("#pnumber").val(ResetProductNum);
    var oldpid = [];
    var oldnum = [];
    $("#goodsId").val(oldpid)
    $("#goodsNum").val(oldnum)

}

Array.prototype.remove = function (val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};


function goods() {
    var obj = document.getElementsByName("id");
    var pnum = document.getElementsByName("pnum");
    var check_val = [];
    var num = []
    for (k in obj) {
        if (obj[k].checked) {
            check_val.push(obj[k].value);
            if (k > 0) {
                num.push(pnum[k - 1].value)
            }
        }
    }
    obj = null
    pnum = null
    var goodsId = $("#goodsId").val().split(",")
    var goodsNum = $("#goodsNum").val().split(",")
    // $("#goodsId").val(oldpid)
    // $("#goodsNum").val(oldnum)
    console.log("goodsId")
    console.log(goodsId)
    console.log(check_val)
    console.log(num)
    var pids = $("#pids").val().split(",")
    var pnumber = $("#pnumber").val().split(",")
    for (var i = 0; i < goodsId.length; i++) {
        pids.remove(goodsId[i])
    }
    for (var i = 0; i < goodsNum.length; i++) {
        pnumber.remove(goodsNum[i])
    }
    check_val = check_val.concat(pids)
    num = num.concat(pnumber)
    console.log(check_val)
    console.log(num)
    deleteRepetion(check_val, num)

}

function deleteRepetion(arr, num) {
    var arrTable = {}, arrData = [];
    var numData = [];
    for (var i = 0; i < arr.length; i++) {
        if (!arrTable[arr[i]] && arr[i] != "") {
            arrTable[arr[i]] = true;
            arrData.push(arr[i])
            numData.push(num[i])
        }
    }
    console.log(arrData)
    console.log(numData)
    $("#pids").val(arrData)
    $("#pnumber").val(numData)
}


/*商品条件查询*/
$(".modal-body").on("click", ".search-query", function () {
    var pname = $("#goodsname").val()
    var sname = $("#shopsname").val()
    var cid = $("#cid").val()
    $.ajax({
        type: "post",
        url: "../product/findProductByClass.html",
        data: {
            sname: sname,
            pname: pname,
            pcid: cid,
        },
        dataType: "json",
        success: function (data) {
            PagingData(data);
        }
    });

})
