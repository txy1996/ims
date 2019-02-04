<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("basePath", basePath);  
%>  
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>菜单及权限管理</title>
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
    </script>

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">阶段信息</a>
                    </li>
                    <li class="active">阶段信息</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        方案所含商家列表信息
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${staShop.total}条方案所含商家列表信息&emsp;
                            <shiro:hasPermission name="staShop:add">
                                <button type="button" class="btn btn-primary btn-xs show-add-form" data-toggle="modal"
                                        data-target="#perm-form-div">添加方案所含商家列表信息
                                </button>
                            </shiro:hasPermission>
                        </small>
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover perm-list">
                                    <thead>
                                    <tr>
                                        <th><i class="fa fa-id-card bigger-110 hidden-480"></i>ID</th>
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>广告词</th>
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>图片</th>
                                        <th><i class="fa fa-edge bigger-110 hidden-480"></i>商户名称</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>阶段名称</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>阶段介绍</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <shiro:hasPermission name="staShop:list">
                                    <c:forEach items="${staShop.list}" var="staShop">
                                        <tr>
                                            <td class="sssid">${staShop.sssid}</td>
                                            <td class="ssad">${staShop.ssad}</td>
                                            <td class="ssimgs">${basePath}${staShop.ssimgs}</td>
                                            <td class="sname">${staShop.shop.sname}</td>
                                            <td class="ssname">${staShop.stage.ssname}</td>
                                            <td class="ssinfo">${staShop.stage.ssinfo}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <shiro:hasPermission name="staShop:update">
                                                        <button class="btn btn-xs btn-info show-update-form"
                                                                data-toggle="modal" data-target="#perm-form-div">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="staShop:delete">
                                                        <button class="btn btn-xs btn-danger delete-this-perm">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>

                                                    <shiro:lacksPermission name="staShop:update">
                                                        <shiro:lacksPermission name="staShop:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                        </shiro:lacksPermission>
                                                    </shiro:lacksPermission>

                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                        <customTag:hasAnyPermissions
                                                                name="staShop:update,staShop:delete">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                            </button>
                                                        </customTag:hasAnyPermissions>
                                                        <shiro:lacksPermission name="staShop:update">
                                                            <shiro:lacksPermission name="staShop:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>
                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                            <shiro:hasPermission name="staShop:update">
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
                                                            <shiro:hasPermission name="staShop:delete">
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
                                    <shiro:lacksPermission name="staShop:list">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission>
                                    </tbody>
                                </table>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <%--分页--%>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${staShop.pageNum}页，共${staShop.pages}页，共${staShop.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${staShop.hasPreviousPage}">
                                                <li><a href="${path}/staShop/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/staShop/list?pageNum=${staShop.pageNum-1}"
                                                       aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${staShop.navigatepageNums }" var="page">
                                            <c:if test="${page==staShop.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/staShop/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=staShop.pageNum}">
                                                <li><a href="${path }/staShop/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${staShop.hasNextPage }">
                                                <li>
                                                    <a href="${path }/staShop/list?pageNum=${staShop.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/staShop/list?pageNum=${staShop.pages}">末页</a></li>
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
                                    <form id="perm-form" name="perm-form" class="perm-form" enctype="multipart/form-data">
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-xs-12 col-sm-6">
                                                    <input type="hidden" name="sssid" class="form-control" id="sssidInput">
                                                    <div class="form-group">
                                                    <%--   <div>
                                                     <select id="sid" name="sid" >
                                                      <!-- 	<option>--请选择方案名称--</option> -->
      													<c:forEach var="var" items="${list}"> 
        												<option value="${var.sid}">${var.sname}</option>
      													</c:forEach>
														</select> 
														
														 
                                                        </div>   --%>
                                                        <label for="ssname">广告词<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="ssad" name="ssad"
                                                                   placeholder="广告词"/>
                                                        </div>
                                                        <label for="ssname">图片<span
                                                                style="color:#F00">*</span></label>
                                                      <!--   <div>
                                                            <input type="text" id="ssimgs" name="ssimgs"
                                                                   placeholder=""/>
                                                        </div> -->
                                                        <input type="file" name="file" />
                                                    
                                                       <!--   <label for="sid">sid<span style="color:#F00">*</span></label> -->
                                                        <div>
                                                     <select id="shopid" name="shopid" >
                                                      <!-- 	<option>--请选择方案名称--</option> -->
      													<c:forEach var="var" items="${list}"> 
        												<option value="${var.sid}">${var.sname}</option>
      													</c:forEach>
														</select> 
                                                        </div> 
                                                          
                                                          <select id="ssid" name="ssid" >
                                                      <!-- 	<option>--请选择方案名称--</option> -->
      													<c:forEach var="var" items="${stage}"> 
        												<option value="${var.ssid}">${var.ssname}</option>
      													</c:forEach>
														</select> 
                                                        </div> 
                                                          
                                                        <label for="ssinfo">阶段介绍<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="ssinfo" name="ssinfo"
                                                                   placeholder="ssinfo"/>
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
<%-- <script src="${path}/assets/custom-js/scheme/stageShop.js"></script>  --%>

</body>
<script>
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
    resetPermForm("添加新权限","添加");
});


// 更新权限框体
$(".perm-list").on("click",".show-update-form",function(){
    resetPermForm("更新权限信息","更新");
    var sssid=$(this).parents("tr").find(".sssid").html();
    $.ajax({
        url:"getStaShop.html",
        data:{id:sssid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	console.log(data);
        	var obj = $("#shopid"); 
        	for(var i=0;i<obj[0].length;i++){  
        	    if(obj[0][i].value==data.shopid){  
        	    	obj[0][i].selected=true;  //相等则选中  
        	    }  
        	} 
        	debugger;
        	var obj = $("#ssid"); 
        	for(var i=0;i<obj[0].length;i++){  
        	    if(obj[0][i].value==data.ssid){  
        	    	obj[0][i].selected=true;  //相等则选中  
        	    }  
        	} 
            $(".perm-form input[name='sssid']").val(sssid);
            $(".perm-form input[name='ssad']").val(data.ssad);
            $(".perm-form input[name='ssimgs']").val(data.ssimgs);
            $(".perm-form input[name='ssinfo']").val(data.stage.ssinfo);
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
            	if(confirm("是否添加该条信息")){
            	  window.location.href='${path}/staShop/list';  
        	           }
            }
        });
    }else{
        //请求更新权限
        $.ajax({
            url:"update.html",
            data:$(".perm-form").serialize(),
            type:"POST",
            success:function(){
            	if(confirm("是否更新该条信息")){
              	  window.location.href='${path}/staShop/list';  
          	   }
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
	debugger;
    var permTr=$(this).parents("tr");
    var sssid=permTr.find(".sssid").html();
    if(confirm('确认删除该条信息吗？')){
        //请求删除该权限
        $.ajax({
            url:"delete.html",
            data:{id:sssid},
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
</script>
</html>
