var jsonDataTree = [];

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

$(function () {
    $.ajax({
        type: "post",
        url: "../productclass/selectAll.html",
        dataType: "json",// 特别重要
        success: function (data) {

            jsonDataTree = transData(data, 'id', 'cid', 'nodes');

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
            $("#treeview").hide();
            ClassificationQuery(data.id, data.text);
        }

    };
    $('#treeview').treeview(options);

});


// 根据分类查询
function ClassificationQuery(pcid, cname) {
    var sid = $("#sid").val()
    var url = encodeURI("../product/selectProduct?pcid=" + pcid + "&cname="
        + cname + "&sid=" + sid)
    window.location.href = url;

}

window.onload = function () {
    var cname = $("#cname").val();
    if (cname != "") {
        $("#txt_departmentname").val(cname);
    }

}

// 选择查询
$(".state").on(
    "change",
    "#stateQuery",
    function () {
        var state = $("#stateQuery").val()
        var sid = $("#sid").val()
        var url = encodeURI("../product/selectProduct?state=" + state
            + "&sid=" + sid)
        window.location.href = url;

    });
// 根据商品名称查询
$(".input-group").on(
    "click",
    "#NameQuery",
    function () {

        var pname = $("input[name='pname']").val();
        var sid = $("#sid").val()
        var url = encodeURI("../product/selectProduct?pname=" + pname
            + "&sid=" + sid)
        window.location.href = url;

    });

$(".hidden-sm").on("click", ".TransferId", function () {
    var userTr = $(this).parents("tr");
    var id = userTr.find(".id").html();
    $("#commodityId").val(id);

});

// 修改状态
$(".modal-footer").on("click", "#updateState", function () {
    var state = $("#state").val()
    var id = $("#commodityId").val()
    $.ajax({
        url: "../product/updateProductState.html",
        dataType: "json",// 特别重要
        data: {
            state: state,
            id: id
        },
        type: "POST",
        success: function (data) {
            var url = encodeURI("../product/selectProduct")
            window.location.href = url;
        },
        error: function () {
            showTips("添加失败！");
        }
    });

});


var jsonDataTree = [];
var recipient = '';
var proclass = '';
$('#user-form-div').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // 触发事件的按钮
    recipient = button.data('whatever') // 解析出data-whatever内容
    var modal = $(this)
    modal.find('.modal-body input #inp').val(recipient)
    /*$.ajax({
            url : "../productclass/selectall.html",
            type : "POST",
            dataType : "json",
            data : {
            'sid' : recipient
            },
            success : function(data) {
            console.log(data)
        }
})*/
    $(function () {
        $.ajax({
            type: "post",
            url: "../product/selectAll.html",
            dataType: "json",// 特别重要
            success: function (data) {
                jsonDataTree = transData1(data, 'id', 'cid', 'nodes');
            },
            error: function () {
                toastr.error('Error');
            },
        });
    });
})


function transData1(a, idStr, pidStr, chindrenStr) {
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

$("#txt_departmentname1").click(function () {
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
            $("#txt_departmentname1").val(data.text);
            proclass = data.id;
            /*QueryAttribute(data.id)*/
            // $("#property").modal("show");
            $("#treeview1").hide();
        }

    };
    $('#treeview1').treeview(options);

});

$(".savepro").click(function () {
    var pcname = $("#txt_departmentname1").val();
    var sid = recipient;
    var pcid = proclass;
    $.ajax({
        type: "post",
        url: "../product/findmodel.html",
        dataType: "json",// 特别重要
        data: {
            'pcid': pcid
        },
        success: function (data) {
            console.log(data)
            window.location.href = '../product/addProduct?sid=' + sid + '&pcname=' + pcname + '&pcid=' + pcid + '&model=' + data
        },
        error: function () {
            toastr.error('Error');
        },
    })

})

function ProductID() {

}

// 点击上传商品id
$(".hidden-xs").on(
    "click",
    "#productid",
    function () {
        var id = $(this).parents("tr").find(".id").html();
        $("#shopid").val(id)
        var type = $("#type").val()
        var adid = $("#adid").val()
        var adname = $("#adname").val()
        if (type != "" && adid != "" && adname != "") {
            $("#advertising").val(type)
            var string = "<option value='" + adid + "'>" + adname + "</option>";
            $("#position").html(string)
            $("#position").val(adid)
        }

    });

// 广告分类查询
$(".modal-body").on(
    "change",
    "#advertising",
    function () {
        var advertising = $("#advertising").val();
        $.ajax({
            type: "post",
            url: "../promotion/findPromotionByPtype.html",
            dataType: "json",// 特别重要
            data: {
                ptype: advertising
            },
            success: function (data) {
                var string = "<option value=\"\">请选择</option>";
                for (var i = 0; i < data.length; i++) {
                    string += "<option value='" + data[i].id + "'>" + data[i].pzone + "</option>"
                }
                $("#position").html(string)
            },
            error: function () {
                toastr.error('Error');
            },
        })

    });


// 点击上传商品id
$(".modal-footer").on(
    "click",
    "#Add-To-Ad",
    function () {
        var shopid = $("#shopid").val()
        var position = $("#position").val()
        var advertising = $("advertising").val()
        $.ajax({
            type: "post",
            url: "../promotion/Recommend.html",
            dataType: "json",// 特别重要
            data: {
                id: position,
                pid: shopid,
            },
            success: function (data) {
                $("#recommend").modal("hide");
                showTips("推荐成功！");
            },
            error: function () {
                toastr.error('Error');
            },
        })

    });
// /*失去焦点隐藏下拉树*/
// $("#txt_departmentname").blur(function(){
//     $("#treeview").hide()
// });
