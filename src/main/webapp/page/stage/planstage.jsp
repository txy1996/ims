<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
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
                        <a href="#">菜单及权限管理</a>
                    </li>
                    <li class="active">菜单及权限列表</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        阶段详情页面
                    &nbsp;&nbsp;&nbsp;&nbsp;<a href="JavaScript:history.back(-1)" class="btn btn-primary btn-xs show-add-form"  >返回</a>
                    </h1>
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover perm-list">
                                    <thead>
                                    <tr>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>方案分类名</th>
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>方案名</th>
                                        <th><i class="fa fa-edge bigger-110 hidden-480"></i>方案介绍</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>方案分类简介</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>被赞次数</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>被踩次数</th>
                                         <th><i class="fa fa-key bigger-110 hidden-480"></i>阶段名</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>阶段介绍</th> 
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>方案状态</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>创建时间</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>创建人</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>对应商家</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <shiro:hasPermission name="scheme:list">
                                    <c:forEach items="${list.list}" var="list">
                                        <tr>
                                            <td class="scname">${list.scheme_class.scname}</td>
                                            <td class="sname">${list.sname}</td>
                                            <td class="sinfo">${list.sinfo}</td>
                                            <td class="scinfo">${list.scheme_class.scinfo}</td>
                                            <td class="spraise">${list.spraise}</td>
                                            <td class="soppose">${list.soppose}</td>
                                             <td class="ssname">${list.sctage.ssname}</td>
                                            <td class="ssinfo">${list.sctage.ssinfo}</td> 
                                            <td class="sstate">
                                                <c:if test="${empty list.sstate}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${list.sstate==0}"><span
                                                        class="label label-sm label-warning">预览</span></c:if>
                                                <c:if test="${list.sstate==1}"><span
                                                        class="label label-sm label-success">预审</span></c:if>
                                                <c:if test="${list.sstate==2}"><span
                                                        class="label label-sm label-inverse">公开</span></c:if>
                                                 <c:if test="${list.sstate==3}"><span
                                                        class="label label-sm label-inverse">过期</span></c:if>
                                            </td>
                                            
                                            <td class="sdate">${list.sdate}</td>
                                            <td class="username">${list.sys_user.username}</td>
                                            <td><a href = "${path }/scheme/getshop?id=${list.sid }">点击查看</a></td>
                                        </tr>
                                        </c:forEach>
                                        </shiro:hasPermission>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
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

</body>
</html>
