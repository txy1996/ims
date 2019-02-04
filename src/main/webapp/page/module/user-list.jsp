<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>用户管理</title>
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
    <style type="text/css">
        .jump-gold:hover {
            background-color: rgb(79, 153, 198);
        }

        .jump-isum:hover {
            background-color: rgb(79, 153, 198);
        }
    </style>
</head>

<body class="no-skin" id="Refreshbody">
<%--top导航栏--%>


<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }

        function searchfor() {
            var Userattribute = $("#user").val();
            var userinfo = $("#userinfo").val();
            var filter = $("#filter").val();
            var minNum = $("#start").val();
            var maxNum = $("#end").val();
            var url = encodeURI("${path}/user/list?Userattribute="
                + Userattribute + "&userinfo=" + userinfo + "&filter="
                + filter + "&minNum=" + minNum + "&maxNum=" + maxNum)
            window.location.href = url;
        }
    </script>

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed"
                 id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">用户管理</a>
                    </li>
                    <li class="active">用户列表</li>
                </ul>
                <!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        用户管理
                        <small><i class="ace-icon fa fa-angle-double-right"></i>
                            <span id="amount">共${users.total}位用户&emsp;</span> <shiro:hasPermission
                                    name="user:delete">
                                <button type="button"
                                        class="btn btn-warning btn-xs delete-query"
                                        data-toggle="modal" data-target="#delete-confirm-dialog">删除所选用户
                                </button>
                            </shiro:hasPermission> <shiro:hasPermission name="user:add">
                                <button type="button"
                                        class="btn btn-primary btn-xs show-add-form"
                                        data-toggle="modal" data-target="#user-form-div">添加新用户
                                </button>
                            </shiro:hasPermission>
                        </small>
                    </h1>
                </div>
                <!-- /.page-header -->
                <div class="user-search ">
                    <button type="button" disabled="disabled"
                            class="btn btn-primary btn-xs"
                            style="height: 35px; margin-bottom: 4px;">搜索
                    </button>
                    <select id="user" name="lclcid" style="height: 35px;">
                        <option value="Undefined">请选择</option>
                        <option value="username">用户名</option>
                        <option value="urtname">真实姓名</option>
                        <option value="mobile">电话号码</option>
                    </select> <input type="text" name="username" id="userinfo"
                                     placeholder="请输入用户查询"/>
                    <button style="height: 35px;" onclick="searchfor()"
                            class="btn btn-success btn-xs  search-query">查询
                    </button>
                    <!-- 						 <button style="height: 35px;" onclick="searchfor()"
                        class="btn btn-success btn-xs  search-query">查询</button> -->


                    <button disabled="disabled"
                            style="margin-left: 160px; margin-bottom: 4px; height: 35px;"
                            class="btn btn-primary btn-xs">筛选
                    </button>
                    <select id="filter" name="lclcid" style="height: 35px;">
                        <option value="filter">请选择</option>
                        <option value="coupon">优惠券张数</option>
                        <option value="vmoney">代金券金额</option>
                        <option value="gnum">金币数量</option>
                        <option value="isum">积分数量</option>
                    </select> <input type="text" id="start" style="width: 50px;"
                                     placeholder="请输入"/> AND <input type="text" style="width: 50px;"
                                                                    id="end" placeholder="请输入"/>
                    <button id="serch" onclick="searchfor()" style="height: 35px;"
                            class="btn btn-success btn-xs  search-query">查询
                    </button>
                    <!-- 						<button id="serch" onclick="filter()" style="height: 35px;"
                        class="btn btn-success btn-xs">查询</button> -->
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table"
                                       class="table  table-bordered table-hover user-list">
                                    <thead>
                                    <tr>
                                        <th class="center"><label class="pos-rel"> <input
                                                type="checkbox" class="ace select-all-btn"/> <span
                                                class="lbl"></span>
                                        </label></th>
                                        <th><i class="fa fa-id-card bigger-110 hidden-480"></i>ID</th>
                                        <th><i class="fa fa-user bigger-110 hidden-480"></i>用户名</th>
                                        <th><i
                                                class="fa fa-user-circle-o bigger-110 hidden-480"></i>真实姓名
                                        </th>
                                        <th><i
                                                class="fa fa-user-circle-o bigger-110 hidden-480"></i>电话
                                        </th>
                                        <th><i
                                                class="fa fa-user-circle-o bigger-110 hidden-480"></i>积分
                                        </th>
                                        <th><i
                                                class="fa fa-user-circle-o bigger-110 hidden-480"></i>金币
                                        </th>
                                        <th><i class="fa fa-users bigger-110 hidden-480"></i>代金券</th>
                                        <th><i class="fa fa-clock-o bigger-110 hidden-480"></i>优惠券</th>
                                        <th><i class="fa fa-heartbeat bigger-110 hidden-480"></i>状态</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody class="user-tbody">
                                    <shiro:hasPermission name="user:show">
                                        <c:forEach items="${users.list}" var="list">
                                            <tr>
                                                <td class="center"><label class="pos-rel"> <input
                                                        type="checkbox" class="ace" name="userIds"
                                                        value="${list.urid}"/> <span class="lbl"></span>
                                                </label></td>
                                                <input type="hidden" class="state" value="${list.state}">
                                                <td class="userId">${list.urid}</td>
                                                <td class="username">${list.username}</td>
                                                <td class="real_name">${list.real_name}</td>
                                                <td class="mobile">${list.mobile}</td>
                                                <c:choose>
                                                    <c:when test="${empty list.isum }">
                                                        <td class="isum jump-isum" style="cursor: pointer">0</td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td class="isum jump-isum"
                                                            style="cursor: pointer">${list.isum}</td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${empty list.gnum }">
                                                        <td class="gnum jump-gold" style="cursor: pointer">0</td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td class="gnum jump-gold"
                                                            style="cursor: pointer">${list.gnum}</td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <td class="voucher">${list.vmoney}/${list.voucher}</td>
                                                <c:choose>
                                                    <c:when test="${empty list.coupon }">
                                                        <td class="coupon">0</td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td class="coupon">${list.coupon}</td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <td ><c:if test="${empty list.state}">
                                                    <span class="label label-sm label-primary">-</span>
                                                </c:if> <c:if test="${list.state==0}">
                                                    <span class="label label-sm label-warning">未激活</span>
                                                </c:if> <c:if test="${list.state==1}">
                                                    <span class="label label-sm label-success">正常</span>
                                                </c:if> <c:if test="${list.state==2}">
                                                    <span class="label label-sm label-inverse">锁定</span>
                                                </c:if></td>

                                                <td>
                                                    <div class="hidden-sm hidden-xs btn-group">

                                                        <a class='btn btn-info btn-xs'
                                                           href="${path}/order/findOrderAll?urid=${list.urid}"><i
                                                                class="ace-icon fa  bigger-120 ">订单</i></a>

                                                        <button class="btn btn-xs btn-info reset-password">
                                                            <i class="ace-icon fa  bigger-120">发票</i>
                                                        </button>

                                                        <a class='btn btn-info btn-xs'
                                                           href="${path}/scheme/list?urid=${list.urid}"><i
                                                                class="ace-icon fa  bigger-120 ">方案</i></a>

                                                        <a class='btn btn-info btn-xs'
                                                           href="${path}/userAssess/list?urid=${list.urid}"><i
                                                                class="ace-icon fa  bigger-120 ">评论</i></a>

                                                        <a class='btn btn-info btn-xs'
                                                           href="${path}/label/list?urid=${list.urid}"><i
                                                                class="ace-icon fa  bigger-120 ">标签</i></a>

                                                        <button class="btn btn-xs btn-info voucher">
                                                            <i class="ace-icon fa  bigger-120">代金券</i>
                                                        </button>


                                                        <button class="btn btn-xs btn-info usercoupon">
                                                            <i class="ace-icon fa  bigger-120">优惠券</i>
                                                        </button>

                                                        <button class="btn btn-xs btn-info lock-user">
                                                            <c:if test="${empty list.state}">
                                                            </c:if> <c:if test="${list.state==0}">
                                                            <i class="ace-icon fa  bigger-120">激活</i>
                                                        </c:if> <c:if test="${list.state==1}">
                                                            <i class="ace-icon fa  bigger-120">锁定</i>
                                                        </c:if> <c:if test="${list.state==2}">
                                                            <i class="ace-icon fa  bigger-120">解锁</i>
                                                        </c:if>
                                                        </button>

                                                        <shiro:hasPermission name="user:update">
                                                            <button class="btn btn-xs btn-info show-update-form"
                                                                    data-toggle="modal" data-target="#user-form-div">
                                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                            </button>
                                                        </shiro:hasPermission>
                                                        <shiro:hasPermission name="user:reset">
                                                            <button class="btn btn-xs btn-warning reset-password">
                                                                <i class="ace-icon fa fa-flag bigger-120"></i>
                                                            </button>
                                                        </shiro:hasPermission>

                                                            <%-- <shiro:hasPermission name="user:delete">
                                                    <c:if test="${user.username ne 'admin'}">
                                                        <button class="btn btn-xs btn-danger delete-this-user">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </c:if>
                                                </shiro:hasPermission> --%>

                                                        <shiro:lacksPermission name="user:update">
                                                            <shiro:lacksPermission name="user:reset">
                                                                <shiro:lacksPermission name="user:delete">
																			<span
                                                                                    class="label label-large label-grey arrowed-in-right arrowed-in">
																				<i class="ace-icon fa fa-lock"
                                                                                   title="无权限"></i>
																			</span>
                                                                </shiro:lacksPermission>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>

                                                    </div>
                                                    <div class="hidden-md hidden-lg">
                                                        <div class="inline pos-rel">
                                                            <customTag:hasAnyPermissions
                                                                    name="user:update,user:reset,user:delete">
                                                                <button
                                                                        class="btn btn-minier btn-primary dropdown-toggle"
                                                                        data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                                </button>
                                                            </customTag:hasAnyPermissions>
                                                            <shiro:lacksPermission name="user:update">
                                                                <shiro:lacksPermission name="user:reset">
                                                                    <shiro:lacksPermission name="user:delete">
																				<span
                                                                                        class="label label-large label-grey arrowed-in-right arrowed-in">
																					<i class="ace-icon fa fa-lock"
                                                                                       title="无权限"></i>
																				</span>
                                                                    </shiro:lacksPermission>
                                                                </shiro:lacksPermission>
                                                            </shiro:lacksPermission>

                                                            <ul
                                                                    class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                <shiro:hasPermission name="user:update">
                                                                    <li><a href="javascript:void(0);"
                                                                           class="tooltip-success show-update-form"
                                                                           data-toggle="modal"
                                                                           data-target="#user-form-div"
                                                                           data-rel="tooltip" title="更新用户"> <span
                                                                            class="green"> <i
                                                                            class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																				</span>
                                                                    </a></li>
                                                                </shiro:hasPermission>
                                                                <shiro:hasPermission name="user:reset">
                                                                    <li><a href="javascript:void(0);"
                                                                           class="tooltip-error reset-password"
                                                                           data-rel="tooltip" title="重置密码"> <span
                                                                            class="orange"> <i
                                                                            class="ace-icon fa fa-flag bigger-120"></i>
																				</span>
                                                                    </a></li>
                                                                </shiro:hasPermission>
                                                                <shiro:hasPermission name="user:delete">
                                                                    <c:if test="${user.username ne 'admin'}">
                                                                        <li><a href="javascript:void(0);"
                                                                               class="tooltip-error delete-this-user"
                                                                               data-rel="tooltip" title="删除"> <span
                                                                                class="red"> <i
                                                                                class="ace-icon fa fa-trash-o bigger-120"></i>
																					</span>
                                                                        </a></li>
                                                                    </c:if>
                                                                </shiro:hasPermission>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="user:show">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.span -->
                        </div>
                        <!-- /.row -->

                        <%--分页--%>
                        <div id="pagebottom" class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${users.pageNum}页，共${users.pages}页，共${users.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${users.hasPreviousPage}">
                                                <li><a href="${path}/user/list?pageNum=1">首页</a></li>
                                                <li><a
                                                        href="${path}/user/list?pageNum=${users.pageNum-1}"
                                                        aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                                </a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${users.navigatepageNums }" var="page">
                                            <c:if test="${page==users.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/user/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=users.pageNum}">
                                                <li><a href="${path }/user/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${users.hasNextPage }">
                                                <li><a
                                                        href="${path }/user/list?pageNum=${users.pageNum+1 }"
                                                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                                </a></li>
                                                <li><a
                                                        href="${path }/user/list?pageNum=${users.pages}">末页</a></li>
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
                        <div class="modal fade" id="user-form-div" tabindex="-1"
                             role="dialog" aria-labelledby="mySmallModalLabel">
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
                                                    <input type="hidden" name="id" class="form-control">
                                                    <div class="form-group">
                                                        <label for="form-add-username">用户名<span
                                                                style="color: #F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-username"
                                                                   name="username" placeholder=""/>
                                                        </div>
                                                        <label for="form-add-password">密码<span
                                                                style="color: #F00">*</span></label>
                                                        <div>
                                                            <input type="password" id="form-add-password"
                                                                   name="password" placeholder=""/>
                                                        </div>
                                                        <label for="form-add-realName">网名<span
                                                                style="color: #F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-realName"
                                                                   name="realName" placeholder=""/>
                                                        </div>
                                                        <label for="form-add-urtname">真实姓名<span
                                                                style="color: #F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-urtname" name="urtname"
                                                                   placeholder=""/>
                                                        </div>
                                                        <label for="form-add-urautograph">个性签名<span
                                                                style="color: #F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-urautograph"
                                                                   name="urautograph" placeholder=""/>
                                                        </div>
                                                        <label for="form-add-mobile">电话<span
                                                                style="color: #F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-mobile" name="mobile"
                                                                   placeholder=""/>
                                                        </div>
                                                        <label for="state">帐号状态<span
                                                                style="color: #F00">*</span></label>
                                                        <div id="state">
                                                            <label class="radio-inline"> <input name="state"
                                                                                                type="radio" class="ace"
                                                                                                value="0"/> <span
                                                                    class="lbl">未激活</span>
                                                            </label> <label class="radio-inline"> <input
                                                                name="state" type="radio" class="ace" value="1"
                                                                checked/>
                                                            <span class="lbl">正常</span>
                                                        </label> <label class="radio-inline"> <input
                                                                name="state" type="radio" class="ace" value="2"/> <span
                                                                class="lbl">锁定</span>
                                                        </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="col-xs-12 col-sm-6">
                                                    <div class="form-group">
                                                        <label>选择角色</label>
                                                        <div class="row">
                                                            <div class="col-xs-8 col-sm-11">
                                                                <div class="roles-div"></div>
                                                            </div>
                                                        </div>

                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <div class="modal-footer">
                                        <button class="btn btn-sm" data-dismiss="modal" type="submit">
                                            <i class="ace-icon fa fa-times"></i>取消
                                        </button>
                                        <button type="button"
                                                class="btn btn-sm btn-primary user-submit"></button>
                                    </div>
                                </div>

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
                        <div class="modal fade closetop" id="op-tips-dialog"
                             tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
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

<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>

<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

<!-- 与此页相关的内联脚本 -->
<script src="${path}/assets/custom-js/user-list.js"></script>


</body>


</html>
