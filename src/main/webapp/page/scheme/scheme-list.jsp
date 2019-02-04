<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>方案管理</title>
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
    
    </script>

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">方案管理</a>
                    </li>
                    <li class="active">方案列表</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        方案管理
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${scheme.total}个方案&emsp;

                            <shiro:hasPermission name="scheme:add">
                                <button type="button" class="btn btn-primary btn-xs show-add-form" data-toggle="modal"
                                        data-target="#user-form-div">添加方案
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
                                <table id="simple-table" class="table  table-bordered table-hover user-list">
                                    <thead>
                                    <tr>
                                       <th><i class="fa fa-id-card bigger-110 hidden-480"></i>编号</th>
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>方案分类</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>方案名称</th>
                                        <th><i class="fa fa-location-arrow bigger-110 hidden-480"></i>方案介绍</th>
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>赞</th>
                                        <th><i class="fa fa-picture-o bigger-110 hidden-480"></i>踩</th>
                                        <th><i class="fa fa-paper-plane bigger-110 hidden-480"></i>方案状态</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>创建时间</th>
                                       	<th><i class="fa fa-flag bigger-110 hidden-480"></i>详情查看</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody class="user-tbody">
                                    <shiro:hasPermission name="scheme:list">
                                    <c:forEach items="${scheme.list}" var="scheme">
                                        <tr>
                                            <td class="sid">${scheme.sid}</td>
                                            <td class="scid">${scheme.scheme_class.scname}</td>
                                            <td class="sname"><a href="getMethod?id=${scheme.sid}">${scheme.sname}</a></td>
                                            <td class="sinfo">${scheme.sinfo}</td>
                                            <td class="spraise">${scheme.spraise}</td>
                                            <td class="soppose">${scheme.soppose}</td>
                                           <td class="sstate">
                                                <c:if test="${empty scheme.sstate}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${scheme.sstate==0}"><span
                                                        class="label label-sm label-warning">预览</span></c:if>
                                                <c:if test="${scheme.sstate==1}"><span
                                                        class="label label-sm label-success">预审</span></c:if>
                                                <c:if test="${scheme.sstate==2}"><span
                                                        class="label label-sm label-inverse">公开</span></c:if>
                                                 <c:if test="${scheme.sstate==3}"><span
                                                        class="label label-sm label-inverse">过期</span></c:if>
                                            </td>
 											<td class="sdate"> ${scheme.sdate}</td>
 											<td><a href="getScheme?id=1" class="show-role-perms">点击查看</a></td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <shiro:hasPermission name="scheme:update">
                                                        <button class="btn btn-xs btn-info show-update-form"
                                                                data-toggle="modal" data-target="#user-form-div">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="scheme:reset">
                                                    
                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="scheme:delete">
                                                            <button class="btn btn-xs btn-danger delete-this-user">
                                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                            </button>
                                                    </shiro:hasPermission>

                                                    <shiro:lacksPermission name="scheme:update">
                                                        <shiro:lacksPermission name="scheme:reset">
                                                            <shiro:lacksPermission name="scheme:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>
                                                    </shiro:lacksPermission>

                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                        <customTag:hasAnyPermissions name="scheme:update,scheme:reset,scheme:delete">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                            </button>
                                                        </customTag:hasAnyPermissions>
                                                        <shiro:lacksPermission name="scheme:update">
                                                            <shiro:lacksPermission name="scheme:reset">
                                                                <shiro:lacksPermission name="scheme:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                                </shiro:lacksPermission>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>

                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                            <shiro:hasPermission name="scheme:update">
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
                                                            <shiro:hasPermission name="scheme:reset">
                                                                <li>
                                                                    <a href="javascript:void(0);"
                                                                       class="tooltip-error reset-password"
                                                                       data-rel="tooltip" title="重置阶段信息">
																			<span class="orange">
																				<i class="ace-icon fa fa-flag bigger-120"></i>
																			</span>
                                                                    </a>
                                                                </li>
                                                            </shiro:hasPermission>
                                                            <shiro:hasPermission name="scheme:delete">
                                                                    <li>
                                                                        <a href="javascript:void(0);"
                                                                           class="tooltip-error delete-this-user"
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
                                    <shiro:lacksPermission name="scheme:list">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission>
                                    </tbody>
                                </table>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <%--分页--%>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${scheme.pageNum}页，共${scheme.pages}页，共${scheme.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${scheme.hasPreviousPage}">
                                                <li><a href="${path}/scheme/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/scheme/list?pageNum=${scheme.pageNum-1}"
                                                       aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${scheme.navigatepageNums }" var="page">
                                            <c:if test="${page==scheme.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/scheme/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=scheme.pageNum}">
                                                <li><a href="${path }/scheme/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${scheme.hasNextPage }">
                                                <li>
                                                    <a href="${path }/scheme/list?pageNum=${scheme.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/scheme/list?pageNum=${scheme.pages}">末页</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">末页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                    </ul>
                                </nav>
                            </div>
                        </div>

                        <!--添加、更新用户表单（二合一）-->
                        <div class="modal fade" id="user-form-div" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="blue bigger user-form-title"></h4>
                                    </div>
                                    <form id="user-form" name="user-form" class="user-form">
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-xs-12 col-sm-6">
                                                    <input type="hidden" name="sid" class="form-control">
                                                    <div class="form-group">
                                                      <label for="nameInput">分类名称<span style="color:#F00">*</span></label>
                                                        <div>
                                                         <select id="scid" name="scid">
      													<c:forEach var="list" items="${list}"> 
        												<option value="${list.scid}">${list.scname}</option>
      													</c:forEach>
														</select> 
														</div>
														
														<label for="codeInput">方案名称<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="sname" name="sname" placeholder=""/>
                                                        </div>
                                                        
                                                         <label for="codeInput">方案介绍<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="sinfo" name="sinfo" placeholder=""/>
                                                        </div>
                                                      
                                                    </div>
                                                </div>

                                                <div class="col-xs-12 col-sm-6">
                                                    <div class="form-group">
                                                         <label for="form-add-password">创建时间<span
                                                                style="color:#F00">*</span></label>
                                                        <div>                                                                        <!-- minDate -->
                                                        <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',Date:new Date(),})" name="sdate"/>
                                                        </div>

                                                    </div>
                                                    
                                                      
                                                        <label for="sstate">方案状态<span style="color:#F00">*</span></label>
                                                        <div id="sstate">
                                                            <label class="radio-inline">
                                                                <input name="sstate" type="radio" class="ace" value="0"/>
                                                                <span class="lbl">预览</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="sstate" type="radio" class="ace" value="1" />
                                                                <span class="lbl">预审</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="sstate" type="radio" class="ace"  value="2"/>
                                                                <span class="lbl">公开</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="sstate" type="radio" class="ace"  value="3"/>
                                                                <span class="lbl">过期</span>
                                                            </label>
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
                                        确认删除所选用户吗？
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
<script src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>

<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

<!-- 与此页相关的内联脚本 -->
<script src="${path}/assets/custom-js/scheme/scheme-list.js"></script>

</body>
</html>
