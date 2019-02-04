var path = $("#sysPath").val();

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

function Selected() {
    var status = $("#selectStatus").val()
    var spnum = $("#selectspnum").val()
    var duration = $("#selectduration").val()
    var srange = $("#selectsrange").val()

    if (status != "") {
        $("#ProgramStatus").val(status)
    }
    if (spnum != "") {
        $("#SuitableNumber").val(spnum)
    }
    if (duration != "") {
        $("#duration").val(duration)
    }
    if (srange != "") {
        $("#nature").val(srange)
    }
}


$(document).on('ready', function () {
    Selected();
    $("#simg").fileinput({
        language: 'zh', //设置语言
        showUpload: false, //是否显示上传按钮
        previewFileType: "image",
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary btn-sm btn-success",
        browseLabel: "选择图片",
        removeClass: "btn btn-primary btn-sm btn-danger",
        removeLabel: "删除",
        allowedFileExtensions: ["jpg", "jpeg", "gif", "png", "bmp"],
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        msgFilesTooMany: 1,//"选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        autoReplace: true,
        overwriteInitial: false,
    });
});


function edit_image(path, con) {

    var krajeeGetCount = function (id) {
        var cnt = $('#' + id).fileinput('getFilesCount');
        return cnt === 0 ? 'You have no files remaining.' :
            'You have ' + cnt + ' file' + (cnt > 1 ? 's' : '') + ' remaining.';
    };

    $("#simg").fileinput({
        language: 'zh', //设置语言
        showUpload: false, //是否显示上传按钮
        previewFileType: "image",
        browseClass: "btn btn-primary btn-sm btn-success",
        showCaption: false,//是否显示标题
        browseLabel: "选择图片",
        removeClass: "btn btn-primary btn-sm btn-danger",
        removeLabel: "删除",
        allowedFileExtensions: ["jpg", "jpeg", "gif", "png", "bmp"],
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        msgFilesTooMany: 1,//"选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        autoReplace: true,
        overwriteInitial: false,
        // validateInitialCount: true,
        initialPreview: path,
        initialPreviewConfig: con,
    }).on('filebeforedelete', function () {
        var aborted = !window.confirm('Are you sure you want to delete this file?');
        if (aborted) {
            window.alert('File deletion was aborted! ' + krajeeGetCount('simg'));
        }
        ;
        return aborted;
    }).on('filedeleted', function () {
        setTimeout(function () {
            window.alert('File deletion was successful! ' + krajeeGetCount('simg'));
        }, 900);
    });
}

// 重置用户表单
function resetUserForm(title, button) {
    $('#simg').fileinput('reset').trigger('custom-event');
    $('#tagsinputval').tagsinput('removeAll');
    $("#treeview").hide();
    document.getElementById("scheme-form").reset()
    $(".scheme-form-title").html(title);
    $(".scheme-submit").html('<i class="ace-icon fa fa-check"></i>' + button);
}

// Bootstrap modal 多弹窗之叠加引起的滚动条遮罩阴影问题
$('#property').on('hidden.bs.modal', function () {
    setTimeout(function () {
        $('body').addClass('modal-open')
    }, 100)

})

// 添加用户框体
$(".show-add-form").click(
    function () {
        resetUserForm("添加方案", "添加");
        $(".scheme-form input[type='radio'][name='state'][value='1']")
            .prop("checked", true);
    });

// 更新方案信息
$(".user-list").on("click", ".show-update-form", function () {
    resetUserForm("更新方案信息", "更新");
    var sid = $(this).parents("tr").find(".sid").html();
    $("input[name='sid']").val(sid);
    $.ajax({
        url: "getScheme.html",
        data: {
            id: sid
        },
        type: "POST",
        dataType: "json",
        success: function (data) {
            var obj = $("#scid");
            for (var i = 0; i < obj[0].length; i++) {
                if (obj[0][i].value == data.scid) {
                    obj[0][i].selected = true; // 相等则选中
                }
            }

            //初始化方法
            // if (data.simg != null) {
            //     $("#simg").fileinput('destroy');
            //     var path = ["<img class='kv-preview-data file-preview-image' src='" + data.simg + " '>"]
            //     var con = [
            //         {caption: "Cats-1.jpg", width: "120px", key: 1}
            //     ]
            //     edit_image(path, con);
            // }
            $('#tagsinputval').tagsinput('removeAll');
            $("input[name='sname']").val(data.sname);
            $("textarea[name='sinfo']").val(data.sinfo);
            $("#sstate").val(data.sstate);
            $("#spnum").val(data.spnum);
            $("#sduration").val(data.sduration);
            $("#srange").val(data.srange);
            $("#sprice").val(data.sprice);
            $("#scid").val(data.scid)
            $("#sid").val(sid)
            $("#oldSimg").val(data.simg)
            showlabel(data.sid)


        }
    });
});

// 添加、更新动作
$(".scheme-submit").click(function () {
    if ($(this).html().indexOf("添加") > 0) {
        $.ajax({
            url: "add.html",// url
            type: "POST",
            data: new FormData($('.scheme-form')[0]),
            processData: false,
            contentType: false,
            success: function (data) {
                showTips("添加成功");
                $('#scheme-form-div').modal('hide')
                $('#simg').fileinput('reset').trigger('custom-event');
                $('#tagsinputval').tagsinput('removeAll');
                $("#treeview").hide();
                document.getElementById("scheme-form").reset()
                window.location.reload();
            },
            error: function () {
                showTips("添加失败");
            }
        });
    } else {
        // 更新方案信息
        $.ajax({
            url: "update.html",
            type: "POST",
            data: new FormData($('.scheme-form')[0]),
            processData: false,
            contentType: false,
            success: function (data) {
                showTips("更新成功！");
                $("#scheme-form-div").modal("hide");
                window.location.reload()
            },
            error: function () {
                showTips("更新失败！");
            }
        });
    }
});
// 标签分类树
var jsonDataTree = [];

$(".page-header").on("click", ".Refreshlabel", function () {
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
// 删除方案
$(".page-header").on("click", ".delete-this-scheme", function () {
    var sid = $(this).parents("tr").find(".sid").html();
    $.ajax({
        type: "post",
        url: "../scheme/delete.html",
        dataType: "json",// 特别重要
        data: {
            sid: sid
        },
        success: function (data) {

            window.location.reload();

        },
        error: function () {
            toastr.error('删除失败');
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
            lstype: 0

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

/*条件查询*/
$(".scheme-filter").on("click", ".QueryButton", function () {
    var sstate = $("#ProgramStatus option:selected");
    var spnum = $("#SuitableNumber option:selected");
    var sduration = $("#duration option:selected");
    var srange = $("#nature option:selected");


    var url = "../scheme/list?sstate=" + sstate.val() + "&spnum=" + spnum.val() + "&sduration=" + sduration.val() + "&srange=" + srange.val();
    window.location.href = url


});


// 点击上传商品id
$(".hidden-xs").on(
    "click",
    "#productid",
    function () {
        var id = $(this).parents("tr").find(".sid").html();
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
                scid: shopid,
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
