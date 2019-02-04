<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>用户管理</title>
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

    <!-- 这里是本页内联样式开始 -->
    <!-- 这里是本页内联样式结束 -->

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
    	var bt = $("#bt").val();
    	var stadate = $("#stadate").val();
    	var enddate = $("#enddate").val();
        var ptype=$("#ptype").val(); 
        if(ptype == 1){
        var	ptype = 1;
    	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate+"&ptype="+ptype;
        }else if (ptype == 2){
        	var ptype = 2;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 3){
        	var ptype = 3;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 4){
        	var ptype = 4;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 5){
        	var ptype = 5;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 6){
        	var ptype = 6;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 7){
        	var ptype = 7;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 8){
        	var ptype = 8;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 9){
        	var ptype = 9;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 10){
        	var ptype = 10;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 11){
        	var ptype = 11;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else if (ptype == 12){
        	var ptype = 12;
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
        }else{
        	window.location.href="${path}/promotion/polling?bt="+bt+"&stadate="+stadate+"&enddate="+enddate + "&ptype="+ptype;
            }  
	}
    function addp() {
    	window.location.href="${path}/promotion/addp";
	}
   
    </script>

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">广告列表</a>
                    </li>
                    <li class="active">广告列表</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        广告列表
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${list.total}个&emsp;
                            <shiro:hasPermission name="promotion:add">
                              <!--    <button type="button" class="btn btn-primary btn-xs show-add-form" data-toggle="modal"
                                        data-target="#user-form-div"  >添加
                                </button>  -->
                                <input type="button" value="新增" onclick="addp();">
                            </shiro:hasPermission>
                        </small>
                    </h1>
                </div>
                                                         分类:   
                 <select name="ptype" id = "ptype" >
				        <option value = "">请选择</option>
						<option value="1">图片文字链接</option>
						<option value="2">图片链接</option>
						<option value="3">文字链接</option>
						<option value="4">视频链接</option>
						<option value="5">纯文字商户列表</option>
						<option value="6">纯文字方案列表</option>
						<option value="7">纯文字商品列表</option>
						<option value="8">图文商户列表</option>
						<option value="9">图文方案列表</option>
						<option value="10">图文商品列表</option>
						<option value="11">商户纯图片列表</option>
						<option value="12">方案纯图片列表</option>
						<option value="13">商品纯图片列表</option>
				</select> 
				<input name="type" id = "type" value = "${falg4 }" style="display: none"/> 
			<input type="text" name="bt" id="bt" placeholder="位置标题关键字" value = "${falg1 }"/> 
				日期:
				<input class="Wdate"
					onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name = "stadate" id = "stadate" value = "${falg2 }"/>
				TO
				<input class="Wdate"
					onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name = "enddate" id = "enddate" value = "${falg3 }"/> 
				<button id="serch" onclick="WorkLike()">查询</button>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover user-list">
                                    <thead>
                                    <tr>
                                        <th><i class="fa fa-id-card bigger-110 hidden-480"></i>ID</th>
                                        <th><i class="fa fa-user bigger-110 hidden-480"></i>类型</th>
                                        <th><i class="fa fa-user-circle-o bigger-110 hidden-480"></i>位置标题</th>
                                        <th><i class="fa fa-user-circle-o bigger-110 hidden-480"></i>生效日期</th>
                                        <th><i class="fa fa-user-circle-o bigger-110 hidden-480"></i>失效日期</th>
                                        <th><i class="fa fa-user-circle-o bigger-110 hidden-480"></i>状态</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>
                                    
                                    <tbody class="user-tbody">
                                    <shiro:hasPermission name="promotion:list">
                                    <c:forEach items="${list.list}" var="list">
                                        <tr>
                                             <td class="id">${list.id}</td> 
                                            <td>
                                                <c:if test="${empty list.ptype}"><span
                                                        class="label label-sm label-success">-</span></c:if>
                                                <c:if test="${list.ptype==1}"><span
                                                        class="label label-sm label-success">图片文字链接</span></c:if>
                                                <c:if test="${list.ptype==2}"><span
                                                        class="label label-sm label-success">图片链接</span></c:if>
                                                <c:if test="${list.ptype==3}"><span
                                                        class="label label-sm label-success">文字链接</span></c:if>
                                                <c:if test="${list.ptype==4}"><span
                                                        class="label label-sm label-success">视频链接</span></c:if>
                                                <c:if test="${list.ptype==5}"><span
                                                        class="label label-sm label-success">纯文字商户列表</span></c:if>
                                                <c:if test="${list.ptype==6}"><span
                                                        class="label label-sm label-success">纯文字方案列表</span></c:if>
                                                <c:if test="${list.ptype==7}"><span
                                                        class="label label-sm label-success">纯文字商品列表</span></c:if>
                                                <c:if test="${list.ptype==8}"><span
                                                        class="label label-sm label-success">图文商户列表</span></c:if>
                                                <c:if test="${list.ptype==9}"><span
                                                        class="label label-sm label-success">图文方案列表</span></c:if>
                                                <c:if test="${list.ptype==10}"><span
                                                        class="label label-sm label-success">图文商品列表</span></c:if>  
                                                <c:if test="${list.ptype==11}"><span
                                                        class="label label-sm label-success">商户纯图片列表</span></c:if>
                                                <c:if test="${list.ptype==12}"><span
                                                        class="label label-sm label-success">方案纯图片列表</span></c:if>
                                                <c:if test="${list.ptype==13}"><span
                                                        class="label label-sm label-success">商品纯图片列表</span></c:if>  
                                            </td>
                                            
                                            <td class="pzone">${list.pzone}</td>
                                            <td class="sdate">${list.sdate}</td>
                                            <td class="odate">${list.odate}</td>
                                            <td>
                                                <c:if test="${empty list.state}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${list.state==0}"><span
                                                        class="label label-sm label-warning">预审</span></c:if>
                                                <c:if test="${list.state==1}"><span
                                                        class="label label-sm label-success">发布</span></c:if>
                                                <c:if test="${list.state==2}"><span
                                                        class="label label-sm label-inverse">下架</span></c:if>
                                            </td>
                                            <td>
                                             <a href="${path}/promotion/edit?id=${list.id}" class="ace-icon fa fa-pencil bigger-120 btn btn-xs btn-info show-update-form">编辑</a>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                
                                                    <shiro:hasPermission name="promotion:update">
                                                        <button class="btn btn-xs btn-info show-update-form"
                                                                data-toggle="modal" data-target="#user-form-div" >
                                                            <i class="ace-icon fa fa-pencil bigger-120" >修改</i>
                                                        </button>
                                                    </shiro:hasPermission>
                                                 
                                                    <shiro:hasPermission name="promotion:delete">
                                                         <c:if test="${list.pzone ne 'admin'}">
                                                            <button class="btn btn-xs btn-danger delete-this-user">
                                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                            </button>
                                                        </c:if> 
                                                    </shiro:hasPermission>

                                                    <shiro:lacksPermission name="promotion:update">
                                                            <shiro:lacksPermission name="promotion:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                        </shiro:lacksPermission>
                                                    </shiro:lacksPermission>

                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                        <customTag:hasAnyPermissions name="promotion:update,promotion:delete">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                            </button>
                                                        </customTag:hasAnyPermissions>
                                                        <shiro:lacksPermission name="promotion:update">
                                                                <shiro:lacksPermission name="promotion:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>

                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                            <shiro:hasPermission name="promotion:update">
                                                                <li>
                                                                    <a href="javascript:void(0);"
                                                                       class="tooltip-success show-update-form"
                                                                       data-toggle="modal"
                                                                       data-target="#user-form-div"
                                                                       data-rel="tooltip" title="更新用户">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                                                    </a>
                                                                </li>
                                                            </shiro:hasPermission>
                                                    
                                                            <shiro:hasPermission name="promotion:delete">
                                                                <c:if test="${list.pzone ne 'admin'}">
                                                                    <li>
                                                                        <a href="javascript:void(0);"
                                                                           class="tooltip-error delete-this-user"
                                                                           data-rel="tooltip" title="删除">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                                                        </a>
                                                                    </li>
                                                                </c:if>
                                                            </shiro:hasPermission>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </shiro:hasPermission>
                                    </tbody>
                                </table>
                                           <div  id = "wu" style="display: none;margin-left:40%;color:red;" ></div>
                            </div><!-- /.span -->
                        </div><!-- /.row -->
                                    

                        <%--分页--%>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${list.pageNum}页，共${list.pages}页，共${list.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${list.hasPreviousPage}">
                                                <li><a href="${path}/promotion/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/promotion/list?pageNum=${list.pageNum-1}"
                                                       aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${list.navigatepageNums }" var="page">
                                            <c:if test="${page==list.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/promotion/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=list.pageNum}">
                                                <li><a href="${path }/promotion/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${list.hasNextPage }">
                                                <li>
                                                    <a href="${path }/promotion/list?pageNum=${list.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/promotion/list?pageNum=${list.pages}">末页</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">末页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                    </ul>
                                </nav>
                            </div>
                        </div>
                         <div class="modal fade" id="user-form-div" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="blue bigger user-form-title"></h4>
                                    </div>
                                    <form id="user-form-add" name="user-form" class="user-form">
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-xs-12 ">
                                                    <div class="form-group">
                                                        
                                                        <label for="form-add-bname" style="display: none">商户ID<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-bname" name="id" style="display: none"
                                                                   placeholder="ID"/>
                                                        </div>
                                                        
                                                        
                                                        
                                                         <label for="form-add-password">状态<span style="color:#F00">*</span></label> 
                                                         <div id="state">
                                                            <label class="radio-inline">
                                                                <input name="state" type="radio" class="ace" value="0"/>
                                                                <span class="lbl">预审</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="state" type="radio" class="ace" value="1"/>
                                                                <span class="lbl">发布</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="state" type="radio" class="ace"  value="2"/>
                                                                <span class="lbl">下架</span>
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
                                        <button type="button" class="btn btn-sm btn-primary user-submit"></button>
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
                        <%--隐藏域--%>
                        <div id="sysPath" hidden>${path}</div>
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
<script src="${path}/assets/js/bootstrap-datepicker.min.js"></script>
<script src="${path}/assets/js/bootstrap-timepicker.min.js"></script>
<script src="${path}/assets/js/moment.min.js"></script>
<script src="${path}/assets/js/daterangepicker.min.js"></script>
<script src="${path}/assets/js/bootstrap-datetimepicker.min.js"></script>
<script src="${path}/assets/js/bootstrap-colorpicker.min.js"></script>
<script src="${path}/assets/js/jquery.knob.min.js"></script>
<script src="${path}/assets/js/autosize.min.js"></script>
<script src="${path}/assets/js/jquery.inputlimiter.min.js"></script>
<script src="${path}/assets/js/jquery.maskedinput.min.js"></script>
<script src="${path}/assets/js/bootstrap-tag.min.js"></script>

<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
<script src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>
<script src="${path}/assets/custom-js/promotion/promotion.js"></script>
<!-- 与此页相关的内联脚本 -->
<script type="text/javascript">
$(function(){
	var  a = document.getElementById("type").value; 
	 $("#ptype").val(a);
	 var b = ${list.total}
	 if(b==0){
		 document.getElementById("wu").style.display = "block";
		 var c = "无相关数据！";
		 document.getElementById('wu').innerHTML=c;
	 }
})
</script>
</body>
</html>
