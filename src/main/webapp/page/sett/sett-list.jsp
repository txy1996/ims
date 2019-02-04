<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>系统设置</title>
    <%@include file="../common/meta.jsp" %>
    <%@include file="../common/assets-css.jsp" %>
    <!-- 页面特殊插件样式 -->
    <link rel="stylesheet" href="${path}/assets/css/jquery-ui.custom.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/chosen.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/bootstrap-datepicker3.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/bootstrap-timepicker.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/daterangepicker.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/bootstrap-colorpicker.min.css"/>

    <%@include file="../common/assets-js.jsp" %>
</head>

<body class="no-skin">
<%--top导航栏--%>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
       		} 
        function WorkLike() {
        	var systitle = $("#systitle").val();
        	/* console.log(systitle); */
        	/* console.log(words);
        	console.log("${path}"); */
        window.location.href='${path}/sett/list?pageNum=1&pageSize=8&systitle='+systitle; 
        	/* $.ajax({
                url:"${path}/sett/list",
                data:{systitle:systitle,pageNum:1,pageSize:8},
                type:"POST",
                traditional:true,
                success:function(){
                	location.href ="${path}/sett/list?systitle="+systitle;
                }
            });  */
		}
    </script>

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">系统设置管理</a>
                    </li>
                    <li class="active">系统设置列表</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        系统设置
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${sett.total}个&emsp;
                            <shiro:hasPermission name="sett:delete">
                               <!--  <button type="button" class="btn btn-warning btn-xs delete-query" data-toggle="modal"
                                        data-target="#delete-confirm-dialog">批量删除
                                </button> -->
                            </shiro:hasPermission>
                            <shiro:hasPermission name="sett:add">
                                <button type="button" class="btn btn-primary btn-xs show-add-form" data-toggle="modal"
                                        data-target="#perm-form-div">添加
                                </button>
                            </shiro:hasPermission>
                        </small>
                    </h1>
                </div><!-- /.page-header -->
	<input type="text" name="systitle" id="systitle" placeholder="系统名字查询" value="${falg}"/>
	<button id="serch" onclick="WorkLike()">查询</button>
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover perm-list">
                                    <thead>
                                    <tr>
                                        <!-- <th class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace select-all-btn"/>
                                                <span class="lbl"></span>
                                            </label>
                                        </th> -->
                                        <th><i class="fa fa-id-card bigger-110 hidden-480"></i>ID</th> 
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>系统名字</th>
                                        <th><i class="fa fa-edge bigger-110 hidden-480"></i>系统简介</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>关于我们</th>
                                        <th><i class="fa fa-location-arrow bigger-110 hidden-480"></i>联系我们</th>
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>小程序二维码</th>
                                        <th><i class="fa fa-picture-o bigger-110 hidden-480"></i>微信密钥</th>
                                        <th><i class="fa fa-paper-plane bigger-110 hidden-480"></i>微信校验码</th>
                                         <th><i class="fa bigger-110 hidden-480"></i>支付宝密钥</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>支付宝校验码</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>短信账号</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>短信密码</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>短信地址</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>状态</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <shiro:hasPermission name="sett:show">
                                    <c:forEach items="${sett.list}" var="sett">
                                        <tr>
                                           <%--  <td class="center">
                                                <label class="pos-rel">
                                                    <input type="checkbox" class="ace" name="permIds"
                                                           value="${sett.id}"/>
                                                    <span class="lbl"></span>
                                                </label>
                                            </td> --%>
                                            <td class="id">${sett.id}</td>
                                            <td class="systitle">${sett.systitle}</td>
                                            <td class="sysinfo">${sett.sysinfo}</td>
                                            <td class="sysreadme">${sett.sysreadme}</td>
                                            <td class="sysconnection">${sett.sysconnection}</td>
                                            <td class="sysxcx"> ${sett.sysxcx} </td>
                                            <td class="wxappid">${sett.wxappid}</td>
                                         	<td class="wxappsecret">${sett.wxappsecret}</td>
                                          	<td class="zfbappid">${sett.zfbappid}</td>
                                         	<td class="zfbappsecret">${sett.zfbappsecret}</td>
                                         	<td class="dxlogin">${sett.dxlogin}</td>
                                          	<td class="dxpwd">${sett.dxpwd}</td>
                                         	<td class="dxurl">${sett.dxurl}</td>
                                            <td class="sysstate">
                                                <c:if test="${sett.sysstate==0||sett.sysstate==null}"><span
                                                        class="label label-sm label-warning arrowed arrowed-righ">停用</span></c:if>
                                                <c:if test="${sett.sysstate==1}"><span
                                                        class="label label-sm label-success arrowed arrowed-righ">启用</span></c:if>
                                            </td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <shiro:hasPermission name="sett:update">
                                                        <button class="btn btn-xs btn-info show-update-form"
                                                                data-toggle="modal" data-target="#perm-form-div">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="sett:delete">
                                                        <button class="btn btn-xs btn-danger delete-this-perm">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>

                                                    <shiro:lacksPermission name="sett:update">
                                                        <shiro:lacksPermission name="sett:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                        </shiro:lacksPermission>
                                                    </shiro:lacksPermission>

                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                        <customTag:hasAnyPermissions
                                                                name="sett:update,sett:delete">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                            </button>
                                                        </customTag:hasAnyPermissions>
                                                        <shiro:lacksPermission name="sett:update">
                                                            <shiro:lacksPermission name="sett:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>
                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                            <shiro:hasPermission name="sett:update">
                                                                <li>
                                                                    <a href="javascript:void(0);"
                                                                       class="tooltip-success show-update-form"
                                                                       data-toggle="modal" data-target="#perm-form-div"
                                                                       data-rel="tooltip" title="编辑">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                                                    </a>
                                                                </li>
                                                            </shiro:hasPermission>
                                                            <shiro:hasPermission name="sett:delete">
                                                                <li>
                                                                    <a href="javascript:void(0);"
                                                                       class="tooltip-error delete-this-perm"
                                                                       data-rel="tooltip" title="删除">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                                                    </a>
                                                                </li>
                                                            </shiro:hasPermission>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="sett:show">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission>
                                    </tbody>
                                </table>
                                <div  id = "wu" style="display: none;margin-left:45%;color:red;" ></div>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <%--分页--%>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${sett.pageNum}页，共${sett.pages}页，共${sett.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${sett.hasPreviousPage}">
                                                <li><a href="${path}/sett/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/sett/list?pageNum=${sett.pageNum-1}"
                                                       aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${sett.navigatepageNums }" var="page">
                                            <c:if test="${page==sett.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/sett/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=sett.pageNum}">
                                                <li><a href="${path }/sett/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${sett.hasNextPage }">
                                                <li>
                                                    <a href="${path }/sett/list?pageNum=${sett.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/sett/list?pageNum=${sett.pages}">末页</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">末页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                    </ul>
                                </nav>
                            </div>
                        </div>


                        <!--添加、更新权限表单（二合一）-->
                        <div class="modal fade" id="perm-form-div" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="blue bigger perm-form-title"></h4>
                                    </div>
                                    <form id="perm-form" name="perm-form" class="perm-form">
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-xs-12 col-sm-6">
                                                    <input type="hidden" name="id" class="form-control" id="idInput">
                                                    <div class="form-group">
                                                        <label for="nameInput">名称<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="nameInput" name="systitle"
                                                                   placeholder=""/>
                                                        </div>
                                                        <label for="urlInput">系统简介<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="urlInput" name="sysinfo"
                                                                   placeholder=""/>
                                                        </div>
                                                        <label for="codeInput">关于我们<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="codeInput" name="sysreadme"
                                                                   placeholder=""/>
                                                        </div>
                                                        
													 <label for="sysconnectionInput">联系我们<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="sysconnectionInput" name="sysconnection"   placeholder=""/>
                                                        </div>
                                                        <label for="dxlogin">短信账号<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="dxlogin" name="dxlogin" placeholder=""/>
                                                        </div>
                                                          <label for="dxpwd">短信密码<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="dxpwd" name="dxpwd" placeholder=""/>
                                                        </div>
                                                        <label for="dxurl">短信地址<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="dxurl" name="dxurl" placeholder=""/>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="col-xs-12 col-sm-6">
                                                    <div class="form-group">
                                                        <label for="priority">小程序二维码<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="priority" name="sysxcx"
                                                                   placeholder="小程序二维码"/>
                                                        </div>
                                                      
                                                        <label for="pIdInput">微信秘钥<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="pIdInput" name="wxappid"
                                                                   placeholder=""/>
                                                        </div>
                                                          <label for="wxappsecret">微信校验码<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="wxappsecret" name="wxappsecret" placeholder=""/>
                                                        </div>
                                                        <label for="zfbappid">支付宝密钥<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="zfbappid" name="zfbappid" placeholder=""/>
                                                        </div>
                                                         <label for="zfbappsecret">支付宝校验码<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="zfbappsecret" name="zfbappsecret" placeholder=""/>
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" class="ace" name="sysstate"
                                                                       value="1"><span class="lbl">状态</span>
                                                            </label>
                                                        </div>

                                                    </div>
                                                </div>


                                            </div>
                                        </div>
                                    </form>
                                    <div class="modal-footer">
                                        <button class="btn btn-sm" data-dismiss="modal" type="submit"><i
                                                class="ace-icon fa fa-times"></i>取消
                                        </button>
                                        <button type="button" class="btn btn-sm btn-primary perm-submit"></button>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <!--  删除所选对话框 -->
                        <div class="modal fade " id="delete-confirm-dialog" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-sm" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">警告</h4>
                                    </div>
                                    <div class="modal-body">
                                        确认删除所选权限吗？
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                        <button type="button" class="btn btn-primary delete-selected-confirm">确认
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 提示框 -->
                        <div class="modal fade" id="op-tips-dialog" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-sm" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span class="close-tip" aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">提示信息</h4>
                                    </div>
                                    <div class="modal-body" id="op-tips-content">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
    <%--footer部分--%>
    <%@include file="../common/footer.jsp" %>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- 基本脚本 -->
<%@include file="../common/basic-scripts.jsp" %>

<!-- 页面特殊插件脚本 -->
<script src="${path}/assets/js/jquery.dataTables.min.js"></script>
<script src="${path}/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script src="${path}/assets/js/dataTables.buttons.min.js"></script>
<script src="${path}/assets/js/buttons.flash.min.js"></script>
<script src="${path}/assets/js/buttons.html5.min.js"></script>
<script src="${path}/assets/js/buttons.print.min.js"></script>
<script src="${path}/assets/js/buttons.colVis.min.js"></script>
<script src="${path}/assets/js/dataTables.select.min.js"></script>

<script src="${path}/assets/js/jquery-ui.custom.min.js"></script>
<script src="${path}/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${path}/assets/js/chosen.jquery.min.js"></script>
<script src="${path}/assets/js/spinbox.min.js"></script>
<script src="${path}/assets/js/moment.min.js"></script>
<script src="${path}/assets/js/jquery.knob.min.js"></script>
<script src="${path}/assets/js/autosize.min.js"></script>
<script src="${path}/assets/js/bootstrap-tag.min.js"></script>

<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

<!-- 与此页相关的内联脚本 -->
<%-- <script src="${path}/assets/custom-js/sett/sett.js"></script> --%>

</body>
<script>

$(function(){
	var b = ${sett.total}
	 if(b==0){
		 document.getElementById("wu").style.display = "block";
		 var c = "无相关数据！";
		 document.getElementById('wu').innerHTML=c;
	 }
})

//展示提示框
function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}

// 重置权限表单
function resetPermForm(title,button){
    $(".perm-form input[type='text']").val("");
    $(".perm-form input[type='checkbox']").prop("checked",false);

    $(".perm-form-title").html(title);
    $(".perm-submit").html('<i class="ace-icon fa fa-check"></i>'+button);
}

//添加权限框体
$(".show-add-form").click(function(){
    resetPermForm("添加","添加");
});


// 更新权限框体
$(".perm-list").on("click",".show-update-form",function(){
    resetPermForm("更新信息","更新");

    var id=$(this).parents("tr").find(".id").html();
    $.ajax({
        url:"getSett.html",
        data:{id:id},
        type:"POST",
        dataType:"json",
        success:function(data){
            $(".perm-form input[name='id']").val(id);
            $("input[name='systitle']").val(data.systitle);
            $("input[name='sysinfo']").val(data.sysinfo);
        	$("input[name='sysreadme']").val(data.sysreadme);
        	$("input[name='sysconnection']").val(data.sysconnection);
        	$("input[name='sysxcx']").val(data.sysxcx);
        	$("input[name='wxappid']").val(data.wxappid);
        	$("input[name='wxappsecret']").val(data.wxappsecret);
        	$("input[name='zfbappid']").val(data.zfbappid);
        	$("input[name='zfbappsecret']").val(data.zfbappsecret);
        	$("input[name='dxlogin']").val(data.dxlogin);
        	$("input[name='dxpwd']").val(data.dxpwd);
        	$("input[name='dxurl']").val(data.dxurl);
            if(data.sysstate===1){
                $(".perm-form input[type='checkbox'][name='sysstate']").prop("checked",true);
            }

        }
    });
});

//添加、更新动作
$(".perm-submit").click(function(){
    if($(this).html().indexOf("添加")>0){
        //请求添加新权限
        $.ajax({
            url:"add.html",
            type:"POST",
            data:$(".perm-form").serialize(),
            dataType:"json",
            success:function(data){
                $("#perm-form-div").modal("hide");
                showTips("添加成功！");
                $(".close-tip").click(function () {
                        setTimeout(function(){window.location.reload()},220);
                    }
                )
            },
            error:function(){
                showTips("添加失败！");
            }
        });
    }else{
        //请求更新权限
        $.ajax({
            url:"update.html",
            data:$(".perm-form").serialize(),
            type:"POST",
            success:function(){
                $("#perm-form-div").modal("hide");
                showTips("更新成功！");
                /* $(".close-tip").click(function () {
                        setTimeout(function(){window.location.reload()},220);
                    }
                ) */
                window.location.href='${path}/sett/list';
            },
            error:function(){
                showTips("更新失败！");
            }
        });
    }
});

//全选/取消全选出现的active阴影
var active_class = 'active';
$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
    var th_checked = this.checked;//checkbox inside "TH" table header

    $(this).closest('table').find('tbody > tr').each(function(){
        var row = this;
        if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
        else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
    });
});

//单行选中出现active阴影
$('#simple-table').on('click', 'td input[type=checkbox]' , function(){
    var $row = $(this).closest('tr');
    if($row.is('.detail-row ')) return;
    if(this.checked) $row.addClass(active_class);
    else $row.removeClass(active_class);
});

//删除单个角色
$(".perm-list").on("click",".delete-this-perm",function(){
    var permTr=$(this).parents("tr");
    var id=permTr.find(".id").html();
    var name=permTr.find(".name").html();
    if(confirm('确认删除该条数据吗？')){
        //请求删除该权限
        $.ajax({
            url:"delete.html",
            data:{id:id},
            type:"POST",
            success:function(){
                permTr.remove();
                showTips("删除成功！");
            },
            error:function(){
                showTips("删除失败！");
            }
        });
    }
});

//批量删除角色
$(".delete-selected-confirm").click(function(){
    $("#delete-confirm-dialog").modal("hide");
    var cbs=$("input[name='permIds']:checked")
    if(cbs.length===0){
        showTips("没有选中任意项！");
    }else{
        var permIds=new Array();
        $.each(cbs,function(i,cb){
            permIds[i]=cb.value;
        });
        $.ajax({
            url:"deleteMore.html",
            data:{permIds:permIds},
            type:"POST",
            traditional:true,
            success:function(){
                cbs.parent().parent().parent().remove();
                showTips("删除所选成功！");
            },
            error:function(){
                showTips("删除所选失败！");
            }
        });
    }
});
</script>
</html>
