<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>代金券</title>
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
                        <a href="#">代金券管理</a>
                    </li>
                    <li class="active">代金券列表</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        代金券
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${voucher.total}个&emsp;
                            
                            <shiro:hasPermission name="voucher:add">
                                <button type="button" class="btn btn-primary btn-xs show-add-form" data-toggle="modal"
                                        data-target="#perm-form-div">添加新信息
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
                                        <th><i class="fa fa-id-card bigger-110 hidden-480"></i>代金券ID</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>面额</th>
                                        <th><i class="fa fa-location-arrow bigger-110 hidden-480"></i>进货价</th>
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>销售价</th>
                                        <th><i class="fa fa-picture-o bigger-110 hidden-480"></i>生效日期</th>
                                        <th><i class="fa fa-paper-plane bigger-110 hidden-480"></i>失效日期</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>置换</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>积分数量</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>代金券图片</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>代金券名字</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>代金券简介</th>
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>代金券分类名称</th>
                                        <th><i class="fa fa-edge bigger-110 hidden-480"></i>实用范围</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>是否找零</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>过期处理</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <shiro:hasPermission name="voucher:list">
                                    <c:forEach items="${voucher.list}" var="voucher">
                                        <tr>
                                            <td class="vid">${voucher.vid}</td> <!-- 代金券Id -->
                                            <td class="vmoney">${voucher.vmoney}</td> <!-- 面额 -->
                                            <td class="vcost">${voucher.vcost}</td> <!-- 进货价 -->
                                            <td class="vprice">${voucher.vprice}</td>	<!-- 销售价 -->
                                            <td class="vsdate">${voucher.vsdate}</td> <!-- 生效日期 -->
                                            <td class="vodate">${voucher.vodate}</td> <!-- 失效日期 -->
                                            <td class="vgoods">${voucher.vgoods}</td> <!-- 置换 -->
                                            <td class="vintegration">${voucher.vintegration}</td> <!-- 积分数量 -->
                                            <td class="vimg">${voucher.vimg}</td> <!-- 图片-->
                                            <td class="vtitle">${voucher.vtitle}</td> <!-- 代金券名字 -->
                                            <td class="vinfo">${voucher.vinfo}</td> <!-- 代金券简介 -->
                                            <td class="vcid">${voucher.voucherclass.vcname}</td> <!-- 代金券分类 -->
                                           	<!-- 实用范围 -->
                                            <td class="vrange">
                                                <c:if test="${empty voucher.vrange}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${voucher.vrange=='all'}"><span
                                                        class="label label-sm label-warning">全站</span></c:if>
                                                <c:if test="${voucher.vrange=='p:1'}"><span
                                                        class="label label-sm label-success">品牌店</span></c:if>
                                                <c:if test="${voucher.vrange=='s:1'}"><span
                                                        class="label label-sm label-inverse">单店</span></c:if>
                                            </td>
                                            <!-- 是否找零 -->
                                            <td class="visood">
                                                <c:if test="${voucher.visood==0||voucher.visood==null}"><span
                                                        class="label label-sm label-warning arrowed arrowed-righ">否</span></c:if>
                                                <c:if test="${voucher.visood==1}"><span
                                                        class="label label-sm label-success arrowed arrowed-righ">是</span></c:if>
                                            </td>
                                            <!-- 过期处理 -->
                                            <td class="vrefund">
                                                <c:if test="${voucher.vrefund==0||voucher.vrefund==null}"><span
                                                        class="label label-sm label-warning arrowed arrowed-righ">不处理</span></c:if>
                                                <c:if test="${voucher.vrefund==1}"><span
                                                        class="label label-sm label-success arrowed arrowed-righ">处理</span></c:if>
                                            </td>
                                            
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <shiro:hasPermission name="voucher:update">
                                                        <button class="btn btn-xs btn-info show-update-form"
                                                                data-toggle="modal" data-target="#perm-form-div">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="voucher:delete">
                                                        <button class="btn btn-xs btn-danger delete-this-perm">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>

                                                    <shiro:lacksPermission name="voucher:update">
                                                        <shiro:lacksPermission name="voucher:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                        </shiro:lacksPermission>
                                                    </shiro:lacksPermission>

                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                        <customTag:hasAnyPermissions
                                                                name="voucher:update,voucher:delete">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                            </button>
                                                        </customTag:hasAnyPermissions>
                                                        <shiro:lacksPermission name="voucher:update">
                                                            <shiro:lacksPermission name="voucher:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>
                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                            <shiro:hasPermission name="voucher:update">
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
                                                            <shiro:hasPermission name="voucher:delete">
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
                                    <shiro:lacksPermission name="voucher:list">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission>
                                    </tbody>
                                </table>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <%--分页--%>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${voucher.pageNum}页，共${voucher.pages}页，共${voucher.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${voucher.hasPreviousPage}">
                                                <li><a href="${path}/voucher/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/voucher/list?pageNum=${voucher.pageNum-1}"
                                                       aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${voucher.navigatepageNums }" var="page">
                                            <c:if test="${page==voucher.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/voucher/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=voucher.pageNum}">
                                                <li><a href="${path }/voucher/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${voucher.hasNextPage }">
                                                <li>
                                                    <a href="${path }/voucher/list?pageNum=${voucher.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/voucher/list?pageNum=${voucher.pages}">末页</a></li>
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
                                                    <input type="hidden" name="vid" class="form-control" id="vidInput">
                                                    <div class="form-group">
                                                        <label for="nameInput">面额<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="vmoney" name="vmoney" placeholder=""/>
                                                        </div>
                                                        <label for="urlInput">进货价<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="vcost" name="vcost" placeholder=""/>
                                                        </div>
                                                        <label for="codeInput">销售价<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="vprice" name="vprice" placeholder=""/>
                                                        </div>
                                                        <label for="codeInput">代金券名字<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="vtitle" name="vtitle" placeholder=""/>
                                                        </div>
                                                        <label for="codeInput">代金券简介<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="vinfo" name="vinfo" placeholder=""/>
                                                        </div>
                                                        <label for="codeInput">代金券图片<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="vimg" name="vimg" placeholder=""/>
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" class="ace" name="visood" value="1"><span class="lbl">是否找零</span>
                                                            </label>
                                                        </div>


                                                    </div>
                                                </div>


                                                <div class="col-xs-12 col-sm-6">
                                                    <div class="form-group">
                                                        <label for="priority">积分数量<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="vintegration" name="vintegration" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="form-add-password">生效时间<span style="color:#F00">*</span></label>
                                                        <div>                                                                      
                                                        <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="vsdate"/>
                                                        </div>
                                                        <label for="form-add-password">失效时间<span style="color:#F00">*</span></label>
                                                        <div>                                                                     
                                                        <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="vodate"/>
                                                        </div>
                                                        
                                                         <label for="vcname">代金券类型<span style="color:#F00">*</span></label>
                                                       <div>
                                                         <select id="vcid" name="vcid">
                                                      <!--    <option selected>--请选择--</option> -->
      													<c:forEach var="listCname" items="${listCname}"> 
        												<option value="${listCname.vcid}">${listCname.vcname}</option>
      													</c:forEach>
														</select> 
                                                        </div>       
												   <label for="vrange">实用范围<span style="color:#F00">*</span></label>
                                                        <div id="vrange">
                                                            <label class="radio-inline">
                                                                <input name="vrange" type="radio" class="ace" value="all"/>
                                                                <span class="lbl">全站</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="vrange" type="radio" class="ace" value="p:1"/>
                                                                <span class="lbl">品牌店</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="vrange" type="radio" class="ace"  value="s:1"/>
                                                                <span class="lbl">单体店</span>
                                                            </label>
                                                        </div>
                                                        
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" class="ace" name="vrefund"value="1"><span class="lbl">过期处理</span>
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
<script src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

<!-- 与此页相关的内联脚本 -->
<%-- <script src="${path}/assets/custom-js/voucher/voucher.js"></script> --%>

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
    var vid=$(this).parents("tr").find(".vid").html();
   
    $.ajax({
        url:"getVoucher.html",
        data:{id:vid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	 $(".perm-form input[name='vid']").val(vid);
        	 $(".perm-form input[name='vmoney']").val(data.vmoney);
             $(".perm-form input[name='vcost']").val(data.vcost);
             $(".perm-form input[name='vprice']").val(data.vprice);
             $(".perm-form input[name='vsdate']").val(data.vsdate);
             $(".perm-form input[name='vodate']").val(data.vodate);
             $(".perm-form input[name='vgoods']").val(data.vgoods);
             $(".perm-form input[name='vintegration']").val(data.vintegration);
             $(".perm-form input[name='vtitle']").val(data.vtitle);
             $(".perm-form input[name='vinfo']").val(data.vinfo);
             $(".perm-form input[name='vimg']").val(data.vimg);
             if(data.vrange==='all'){
                 $(".perm-form input[type='radio'][name='vrange']").prop("checked",false);
                 $(".perm-form input[type='radio'][name='vrange'][value='all']").prop("checked",true);
             }else if(data.vrange==='p:1'){
                 $(".perm-form input[type='radio'][name='vrange']").prop("checked",false);
                 $(".perm-form input[type='radio'][name='vrange'][value='p:1']").prop("checked",true);
             }else if(data.vrange==='s:1'){
                 $(".perm-form input[type='radio'][name='vrange']").prop("checked",false);
                 $(".perm-form input[type='radio'][name='vrange'][value='s:1']").prop("checked",true);
             }else{
                 $(".perm-form input[type='radio'][name='vrange']").prop("checked",false);
             }
             
             if(data.visood===1){
                 $(".perm-form input[type='checkbox'][name='visood']").prop("checked",true);
             }
             if(data.vrefund===1){
                 $(".perm-form input[type='checkbox'][name='vrefund']").prop("checked",true);
             }

        }
    });
});

//添加、更新动作
$(".perm-submit").click(function(){

	debugger;
    if($(this).html().indexOf("添加")>0){
    	var msg = confirm("是否新增该信息？");
        //请求添加新权限
        $.ajax({
            url:"add.html",
            type:"POST",
            data:$(".perm-form").serialize(),
            dataType:"json",
            success:function(data){
               /*  $("#perm-form-div").modal("hide");
                showTips("添加成功！");
                $(".close-tip").click(function () {
                        setTimeout(function(){window.location.reload()},220);
                    }
                ) */
            	if(msg==true){
            		alert("添加成功");
            		 window.location.href='${path}/voucher/list';    
            	}else{
            		alert("数据错误，请重新提交");
            	}
            	 /* window.location.href='${path}/voucher/list';   */    
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
               /*  $("#perm-form-div").modal("hide");
                showTips("更新成功！");
                $(".close-tip").click(function () {
                        setTimeout(function(){window.location.reload()},220);
                    }
                ) */
           /*  	 window.location.href='${path}/voucher/list';    */  
            	  if(confirm("是否更新该信息")){
            	        window.location.href='${path}/voucher/list';        	   
            	           }
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
    var vid=permTr.find(".vid").html();
   /* var name=permTr.find(".name").html();*/
    if(confirm('确认删除该条数据吗？')){
        //请求删除该权限
        $.ajax({
            url:"delete.html",
            data:{id:vid},
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
