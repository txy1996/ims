<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>公司信息</title>
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
        function toSearch() {
        	/*  debugger; */ 
        	var cidentify = $("#cidentify").val();
        	var ccode =$("#ccode").val();
        	var caccount = $("#caccount").val();
      /*   window.location.href='${path}/company/list?pageNum=1&pageSize=8&cidentify='+cidentify+'&ccode='+ccode+'&caccount='+caccount; */
       	$.ajax({
                url:"${path}/company/list",
                data:{
                	"cidentify":cidentify,
                	  "ccode":ccode,
                	  "caccount":caccount,
                	   pageNum:1,
                	   pageSize:8
                	},
                type:"POST",
                traditional:true,
                success:function(){
                	location.href ='${path}/company/list?pageNum=1&pageSize=8&cidentify='+cidentify+'&ccode='+ccode+'&caccount='+caccount;
                }
            });   
        	
        }
    </script>

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">公司信息管理</a>
                    </li>
                    <li class="active">公司信息列表</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                      公司信息
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${company.total}个&emsp;
                         <%--  <shiro:hasPermission name="perm:delete">
                                <button type="button" class="btn btn-warning btn-xs delete-query" data-toggle="modal"
                                        data-target="#delete-confirm-dialog">删除所选权限
                                </button>
                            </shiro:hasPermission> --%>
                            <shiro:hasPermission name="company:add">
                                <button type="button" class="btn btn-primary btn-xs show-add-form" data-toggle="modal"
                                        data-target="#perm-form-div">添加新信息
                                </button>
                            </shiro:hasPermission>
                        </small>
                    </h1>
                </div><!-- /.page-header -->
				<input type="text" placeholder="请输入纳税人识别号" id ="cidentify" name="cidentify" value = "${falg }"/>
				<input type="text" placeholder="请输入信用代码" id ="ccode" name="ccode" value = "${falg1 }"/>
				<input type="text" placeholder="请输入开户行账号" id ="caccount" name="caccount" value = "${falg2 }"/>
				<button id ="search" onclick="toSearch()" style="border:0px;background-color: rgb(66,139,202);color:white">查询</button>
				<input type="button" id="back" name="back" value="返回" onclick="javascript:history.back(-1);" style="border:0px;background-color: rgb(66,139,202);color:white"/>
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover perm-list">
                                    <thead>
                                    <tr>
                                        <th><i class="fa fa-id-card bigger-110 hidden-480"></i>公司编号</th>
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>所属地区</th>
                                        <th><i class="fa fa-edge bigger-110 hidden-480"></i>机构</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>纳税人识别号</th>
                                       <!--  <th><i class="fa fa-location-arrow bigger-110 hidden-480"></i>导航节点</th> -->
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>信用代码</th>
                                        <th><i class="fa fa-picture-o bigger-110 hidden-480"></i>注册地址</th>
                                        <th><i class="fa fa-paper-plane bigger-110 hidden-480"></i>开户行</th>
                                        <th><i class="fa fa-picture-o bigger-110 hidden-480"></i>开户账号</th>
                                        <th><i class="fa fa-paper-plane bigger-110 hidden-480"></i>联系电话</th>
                                        <th><i class="fa fa-paper-plane bigger-110 hidden-480"></i>公司简介</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>是否一般纳税人</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <shiro:hasPermission name="company:list">
                                    <c:forEach items="${company.list}" var="company">
                                        <tr>
                                            <td class="companyId">${company.cid}</td>
                                            <td class="Zname">${company.zone.zname}</td>
                                            <td class="cname">${company.cname}</td>
                                            <td class="cidentify">${company.cidentify}</td>
                                            <td class="ccode">${company.ccode}</td>
                                            <td class="caddress">${company.caddress}</td>
                                            <td class="cbank">${company.cbank}</td>
                                            <td class="caccount">${company.caccount}</td>
                                            <td class="ctel">${company.ctel}</td>
                                            <td class="cinfo">${company.cinfo}</td>
                                            <td class="cgeneral_taxpayer">
                                            <c:if test="${company.cgeneral_taxpayer==0||company.cgeneral_taxpayer==null}"><span
                                                  class="label label-sm label-warning arrowed arrowed-righ">否</span></c:if>
                                            <c:if test="${company.cgeneral_taxpayer==1}"><span
                                                  class="label label-sm label-success arrowed arrowed-righ">是</span></c:if>
                                            </td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <shiro:hasPermission name="company:update">
                                                        <button class="btn btn-xs btn-info show-update-form"
                                                                data-toggle="modal" data-target="#perm-form-div">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="company:delete">
                                                        <button class="btn btn-xs btn-danger delete-this-perm">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>

                                                    <shiro:lacksPermission name="company:update">
                                                        <shiro:lacksPermission name="company:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                        </shiro:lacksPermission>
                                                    </shiro:lacksPermission>

                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                        <customTag:hasAnyPermissions
                                                                name="company:update,company:delete">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                            </button>
                                                        </customTag:hasAnyPermissions>
                                                        <shiro:lacksPermission name="company:update">
                                                            <shiro:lacksPermission name="company:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>
                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                            <shiro:hasPermission name="company:update">
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
                                                            <shiro:hasPermission name="company:delete">
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
                                    <shiro:lacksPermission name="company:list">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission>
                                    </tbody>
                                </table>
                                <div id = "wu" style="color:red;margin-left: 45%;"></div>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <%--分页--%>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${company.pageNum}页，共${company.pages}页，共${company.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${company.hasPreviousPage}">
                                                <li><a href="${path}/company/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/company/list?pageNum=${company.pageNum-1}"
                                                       aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${company.navigatepageNums }" var="page">
                                            <c:if test="${page==company.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/company/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=company.pageNum}">
                                                <li><a href="${path }/company/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${company.hasNextPage }">
                                                <li>
                                                    <a href="${path }/company/list?pageNum=${company.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/company/list?pageNum=${company.pages}">末页</a></li>
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
                                                    <input type="hidden" name="cid" class="form-control" id="idInput">
                                                    <div class="form-group">
                                                    
                                                    
                                                        <label for="zidInput">所属地区<span style="color:#F00">*</span></label>
                                                        <div>
													    <select name = "zid">
														<option>请选择地区</option>
														<c:forEach items="${zone}" var="zname">
															<option value="${zname.zid}">${zname.zname}</option>
														</c:forEach>
													   </select>
													   </div>
													
                                                        <label for="cnameInput">机构<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="cnameInput" name="cname" placeholder=""/>
                                                        </div>
                                                        <label for="cidentifyInput">纳税人识别号<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="cidentifyInput" name="cidentify" placeholder=""/>
                                                        </div>
                                                          <label for="ccodeInput">信用代码<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="ccodeInput" name="ccode" placeholder=""/>
                                                        </div>
                                                         <label for="ctelInput">联系电话<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="ctelInput" name="ctel" placeholder=""/>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="col-xs-12 col-sm-6">
                                                    <div class="form-group">
                                                        <label for="caddress">注册地址<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="caddress" name="caddress"  placeholder=""/>
                                                        </div>
                                                       
                                                        <label for="cbankInput">开户行<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="cbankInput" name="cbank" placeholder=""/>
                                                        </div>
                                                        <label for="caccountInput">开户账号<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="caccountInput" name="caccount" placeholder=""/>
                                                        </div>
                                                        <label for="cinfoInput">公司简介<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="cinfoInput" name="cinfo" placeholder=""/>
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" class="ace" name="cgeneral_taxpayer" value="1"><span class="lbl">是否一般纳税人</span>
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
<%-- <script src="${path}/assets/custom-js/company/company-list.js"></script> --%>

</body>
<script>
$(function(){
  var a = ${company.total};
  if(a == 0){
	  var c = "无相关数据！"
	  document.getElementById("wu").innerHTML = c;
  }
})
//展示提示框
function showTips(content){
 $("#op-tips-content").html(content);
 $("#op-tips-dialog").modal("show");
}

//重置权限表单
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


//更新权限框体
$(".perm-list").on("click",".show-update-form",function(){
 resetPermForm("更新信息","更新");
 var companyId=$(this).parents("tr").find(".companyId").html();
 $.ajax({
     url:"getMessage.html",
     data:{id:companyId},
     type:"POST",
     dataType:"json",
     success:function(data){
         $(".perm-form input[name='cid']").val(data.cid);
         $(".perm-form select[name='zid']").val(data.zid);
         $(".perm-form input[name='cname']").val(data.cname);
     	$(".perm-form input[name='cidentify']").val(data.cidentify);
     	$(".perm-form input[name='ccode']").val(data.ccode);
     	$(".perm-form input[name='ctel']").val(data.ctel);
     	$(".perm-form input[name='caddress']").val(data.caddress);
     	$(".perm-form input[name='cbank']").val(data.cbank);
     	$(".perm-form input[name='caccount']").val(data.caccount);
     	$(".perm-form input[name='cinfo']").val(data.cinfo);
         if(data.cgeneral_taxpayer==1){
             $(".perm-form input[type='checkbox'][name='cgeneral_taxpayer']").prop("checked",true);
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
         /* dataType:"json", */
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
             )*/
             window.location.href='${path}/company/list';
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
 var companyId=permTr.find(".companyId").html();
/*  var name=permTr.find(".name").html();*/
 if(confirm('确认删除该条数据吗？')){
     //请求删除该权限
     $.ajax({
         url:"delete.html",
         data:{id:companyId},
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
