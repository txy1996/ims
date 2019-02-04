<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/global.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>方案记录</title>
    <%@include file="../common/meta.jsp" %>
    <%@include file="../common/assets-css.jsp" %>

    <!-- 页面特殊插件样式 -->
    <link rel="stylesheet"
          href="${path}/assets/css/jquery-ui.custom.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/chosen.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/bootstrap-datepicker3.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/bootstrap-timepicker.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/daterangepicker.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/bootstrap-colorpicker.min.css"/>

    <!-- 这里是本页内联样式开始 -->
    <!-- 这里是本页内联样式结束 -->

    <%@include file="../common/assets-js.jsp" %>
</head>

<body class="no-skin Refreshbody" id="Refreshbody">
<%--top导航栏--%>

<div class="main-container ace-save-state">


    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed"
                 id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">方案记录</a>
                    </li>
                    <li class="active">方案记录</li>
                </ul>
                <!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        方案记录
                        <small><i
                                class="ace-icon fa fa-angle-double-right"></i>
                            共${list.total}个&emsp;
                            <button type="button" id="addgoodsshop" style="display: none;"
                                    class="btn btn-primary btn-xs show-add-form"
                                    data-toggle="modal" data-target="#user-form-div">添加记录
                            </button>

                        </small>
                    </h1>
                </div>
                <!-- /.page-header -->


                <%--<div class="goods-user-filter ">--%>
                    <%--<button type="button" disabled="disabled"--%>
                            <%--class="btn btn-primary btn-xs"--%>
                            <%--style="height: 35px; margin-bottom: 4px;">起止时间--%>
                    <%--</button>--%>
                    <%--<input type="date" id="starttime" placeholder="请输入开始时间"/> 到 <input--%>
                        <%--type="date" id="endtime" placeholder="请输入结束时间"/>--%>
                    <%--<button style="height: 35px;"--%>
                            <%--class="btn btn-success btn-xs  user-filter">查询--%>
                    <%--</button>--%>


                <%--</div>--%>
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table"
                                       class="table  table-bordered table-hover user-list">
                                    <thead>
                                    <tr>
                                        <th><i class="fa fa-id-card bigger-110 hidden-480"></i>编号</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>方案名称</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>用户名称</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>联系电话</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>状态</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>时间</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody class="user-tbody">

                                    <c:forEach items="${list.list}" var="list">
                                        <tr>
                                            <td class="srid">${list.srid}</td>
                                            <td class="sname">${list.sname}</td>
                                            <td class="username">${list.username}</td>
                                            <td class="phone">${list.phone}</td>
                                            <td class="statusValue" style="display:none">${list.status}</td>
                                            <td class="status" >
                                                <c:if test="${empty list.status}">
                                                    <span class="label label-sm label-primary">-</span>
                                                </c:if> <c:if test="${list.status==0}">
                                                <span class="label label-sm label-warning">待处理</span>
                                            </c:if> <c:if test="${list.status==1}">
                                                <span class="label label-sm label-success">处理中</span>
                                            </c:if> <c:if test="${list.status==2}">
                                                <span class="label label-sm label-inverse" >已处理</span>
                                            </c:if>
                                            </td>
                                            <td class="date"><fmt:formatDate value="${list.date}"
                                                                             pattern="yyyy-MM-dd HH:mm"/></td>
                                            <td class="date">
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <button class="btn btn-xs btn-info carry-out">
                                                        <c:if test="${empty list.status}">
                                                        </c:if> <c:if test="${list.status==0}">
                                                        <i class="ace-icon fa  bigger-120">处理</i>
                                                    </c:if> <c:if test="${list.status==1}">
                                                        <i class="ace-icon fa  bigger-120">完成</i>
                                                    </c:if>
                                                        <c:if test="${list.status==2}">
                                                            <i class="ace-icon fa  bigger-120">-</i>
                                                        </c:if>
                                                    </button>

                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.span -->
                        </div>
                        <!-- /.row -->

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
                                                <li>
                                                    <a href="${path}/schemeRecording/list?pageNum=1">首页</a>
                                                </li>
                                                <li><a
                                                        href="${path}/schemeRecording/list?pageNum=${list.pageNum-1}"
                                                        aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                                </a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${list.navigatepageNums }" var="page">
                                            <c:if test="${page==list.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/schemeRecording/list?pageNum=${page}">${page}</a>
                                                </li>
                                            </c:if>
                                            <c:if test="${page!=list.pageNum}">
                                                <li>
                                                    <a href="${path }/schemeRecording/list?pageNum=${page}">${page}</a>
                                                </li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${list.hasNextPage }">
                                                <li><a
                                                        href="${path }/schemeRecording/list?pageNum=${list.pageNum+1 }"
                                                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                                </a></li>
                                                <li><a
                                                        href="${path }/schemeRecording/list?pageNum=${list.pages}">末页</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">末页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                    </ul>
                                </nav>
                            </div>
                        </div>


                        <!--  删除所选对话框 -->
                        <div class="modal fade " id="delete-confirm-dialog" tabindex="-1"
                             role="dialog" aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-sm" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title">警告</h4>
                                    </div>
                                    <div class="modal-body">确认删除所选用户吗？</div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">取消
                                        </button>
                                        <button type="button"
                                                class="btn btn-primary delete-selected-confirm">确认
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 提示框 -->
                        <div class="modal fade" id="op-tips-dialog" tabindex="-1"
                             role="dialog" aria-labelledby="mySmallModalLabel">
                            <div class="modal-dialog modal-sm" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span class="close-tip" aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title">提示信息</h4>
                                    </div>
                                    <div class="modal-body" id="op-tips-content"></div>
                                </div>
                            </div>
                        </div>
                        <%--隐藏域--%>
                        <div id="sysPath" hidden>${path}</div>
                        <!-- PAGE CONTENT ENDS -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.page-content -->
        </div>
    </div>
    <!-- /.main-content -->
    <%--footer部分--%>
    <%@include file="../common/footer.jsp" %>

    <a href="#" id="btn-scroll-up"
       class="btn-scroll-up btn btn-sm btn-inverse"> <i
            class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>
<!-- /.main-container -->

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
<script
        src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>

<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>

<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

<!-- 与此页相关的内联脚本 -->
<script src="${path}/assets/custom-js/schemeRecording/schemeRecording.js"></script>

</body>
</html>
