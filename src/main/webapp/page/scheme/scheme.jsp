<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>方案管理</title>
    <%@include file="../common/meta.jsp" %>
    <%@include file="../common/assets-css.jsp" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <%-- <link rel="stylesheet" href="${path}/assets/css/style.css" /> --%>
    <%--<link rel="stylesheet"--%>
    <%--href="${path}/assets/css/bootstrap.min.css"/>--%>
    <link rel="stylesheet"
          href="${path}/assets/css/fileinput.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/theme.css"/>
    <link rel="stylesheet" type="text/css"
          href="../assets/css/bootstrap-tagsinput.css"/>


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

        .ellipsis {
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }

        .container {
            height: auto;
            position: relative;
            margin: 0 auto;
            width: 100%;
            padding-right: 0px;
            padding-left: 0px;
        }

        .nav {
            position: absolute;
            width: 83%;
            top: 100%;
            z-index: 9999;
            overflow-y: auto;
            overflow-x: auto;
            height: 150px;
        }

        .ConditionalQuery {
            height: 35px;
            margin: 0 20px 0 0;
        }

        .QueryButton {
            margin: 0 20px 10px 0;
            width: 8%;
        }

        * {
            font-family: "sta cartman", "开心软件黑体简体", "开心软件二黑简体", sans-serif
        }
    </style>
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
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed"
                 id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">方案管理</a>
                    </li>
                    <li class="active">方案列表</li>
                </ul>
                <!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        方案管理
                        <small><i class="ace-icon fa fa-angle-double-right"></i>
                            共${scheme.total}个方案&emsp; <shiro:hasPermission name="scheme:add">
                                <button
                                        class="btn btn-primary btn-lg Refreshlabel show-add-form"
                                        data-toggle="modal" data-target="#scheme-form-div">添加
                                </button>
                            </shiro:hasPermission>
                        </small>
                    </h1>

                    <div class="scheme-filter ">
                        <input type="hidden" id="selectStatus" value="${request.sstate}">
                        方案状态:
                        <select id="ProgramStatus" name="ProgramStatus" class="ConditionalQuery">
                            <option value="-1">请选择....</option>
                            <option value="0">预览</option>
                            <option value="1">预审</option>
                            <option value="2">公开</option>
                            <option value="3">过期</option>
                        </select>
                        <input type="hidden" id="selectspnum" value="${request.spnum}">
                        适合人数:
                        <select id="SuitableNumber" name="SuitableNumber" class="ConditionalQuery">
                            <option>请选择....</option>
                            <option value="5-10人">5-10人</option>
                            <option value="11-50人">11-50人</option>
                            <option value="51-100人">51-100人</option>
                            <option value="101-300人">101-300人</option>
                            <option value="300人以上">300人以上</option>
                        </select>
                        <input type="hidden" id="selectduration" value="${request.sduration}">
                        方案时长:
                        <select id="duration" name="duration" class="ConditionalQuery">
                            <option>请选择....</option>
                            <option value="半天">半天</option>
                            <option value="一天(不含夜)">一天(不含夜)</option>
                            <option value="一天(含夜)">一天(含夜)</option>
                            <option value="一天半(含夜)">一天半(含夜)</option>
                            <option value="两天一夜">两天一夜</option>
                            <option value="两天两夜">两天两夜</option>
                            <option value="三天两夜">三天两夜</option>
                            <option value="三天以上">三天以上</option>
                        </select>
                        <input type="hidden" id="selectsrange" value="${request.srange}">
                        方案性质:
                        <select id="nature" name="nature" class="ConditionalQuery">
                            <option>请选择....</option>
                            <option value="内部人员-不外出">内部人员-不外出</option>
                            <option value="内部人员-外出">内部人员-外出</option>
                            <option value="外部人员-外出">外部人员-外出</option>
                            <option value="外部人员-不外出">外部人员-不外出</option>
                        </select>
                        <button type="button" class="btn btn-primary QueryButton">查询</button>
                    </div>
                </div>
                <!-- /.page-header -->


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
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>方案分类</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>方案名称</th>
                                        <th><i
                                                class="fa fa-location-arrow bigger-110 hidden-480"></i>方案介绍
                                        </th>
                                        <th><i
                                                class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>赞
                                        </th>
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
                                                <td class="sname">${scheme.sname}</td>
                                                <c:if test="${fn:length(scheme.sinfo)>100 }">
                                                    <td class="sinfo "
                                                        style="width: 30%;">${ fn:substring( scheme.sinfo ,0,100)}
                                                        ...
                                                    </td>
                                                </c:if>
                                                <c:if test="${fn:length(scheme.sinfo)<=100 }">
                                                    <td class="sinfo " style="width: 30%;">${scheme.sinfo}</td>
                                                </c:if>
                                                <td class="spraise">${scheme.spraise}</td>
                                                <td class="soppose">${scheme.soppose}</td>
                                                <td class="sstate"><c:if
                                                        test="${empty scheme.sstate}">
                                                    <span class="label label-sm label-primary">-</span>
                                                </c:if> <c:if test="${scheme.sstate==0}">
                                                    <span class="label label-sm label-warning">预览</span>
                                                </c:if> <c:if test="${scheme.sstate==1}">
                                                    <span class="label label-sm label-success">预审</span>
                                                </c:if> <c:if test="${scheme.sstate==2}">
                                                    <span class="label label-sm label-inverse">公开</span>
                                                </c:if> <c:if test="${scheme.sstate==3}">
                                                    <span class="label label-sm label-inverse">过期</span>
                                                </c:if></td>
                                                    <%-- <td class="sdate">${scheme.sdate}</td> --%>
                                                <td class="sdate"><fmt:formatDate
                                                        value="${scheme.sdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                                <td><a
                                                        href="${path}/schemeStage/getSchemeStage?sid=${scheme.sid}"
                                                        class="show-role-perms">点击查看</a></td>
                                                <td>
                                                    <div class="hidden-sm hidden-xs btn-group page-header">
                                                        <button class="btn btn-xs btn-info " data-toggle="modal"
                                                                data-target="#recommend" id="productid">
                                                            <i class="ace-icon fa  bigger-120">推荐</i>
                                                        </button>
                                                        <shiro:hasPermission name="scheme:update">
                                                            <button class="btn btn-xs btn-info show-update-form Refreshlabel"
                                                                    data-toggle="modal" data-target="#scheme-form-div">
                                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                            </button>
                                                        </shiro:hasPermission>
                                                        <shiro:hasPermission name="scheme:delete">
                                                            <button class="btn btn-xs btn-danger delete-this-scheme">
                                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                            </button>
                                                        </shiro:hasPermission>

                                                        <shiro:lacksPermission name="scheme:update">
                                                            <shiro:lacksPermission name="scheme:reset">
                                                                <shiro:lacksPermission name="scheme:delete">
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
                                                                    name="scheme:update,scheme:reset,scheme:delete">
                                                                <button
                                                                        class="btn btn-minier btn-primary dropdown-toggle"
                                                                        data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                                </button>
                                                            </customTag:hasAnyPermissions>
                                                            <shiro:lacksPermission name="scheme:update">
                                                                <shiro:lacksPermission name="scheme:reset">
                                                                    <shiro:lacksPermission name="scheme:delete">
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
                                                                <shiro:hasPermission name="scheme:update">
                                                                    <li><a href="javascript:void(0);"
                                                                           class="tooltip-success show-update-form"
                                                                           data-toggle="modal"
                                                                           data-target="#scheme-form-div"
                                                                           data-rel="tooltip" title="更新用户"> <span
                                                                            class="green"> <i
                                                                            class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																				</span>
                                                                    </a></li>
                                                                </shiro:hasPermission>
                                                                <shiro:hasPermission name="scheme:reset">
                                                                    <li><a href="javascript:void(0);"
                                                                           class="tooltip-error reset-password"
                                                                           data-rel="tooltip" title="重置阶段信息"> <span
                                                                            class="orange"> <i
                                                                            class="ace-icon fa fa-flag bigger-120"></i>
																				</span>
                                                                    </a></li>
                                                                </shiro:hasPermission>
                                                                <shiro:hasPermission name="scheme:delete">
                                                                    <li><a href="javascript:void(0);"
                                                                           class="tooltip-error delete-this-user"
                                                                           data-rel="tooltip" title="删除"> <span
                                                                            class="red">
																						<i class="ace-icon fa fa-trash-o bigger-120"></i>
																				</span>
                                                                    </a></li>
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
                            </div>
                            <!-- /.span -->
                        </div>
                        <!-- /.row -->

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
                                                <li><a
                                                        href="${path}/scheme/list?pageNum=1&urid=${request.urid }&sstate=${request.sstate}&spnum=${request.spnum}&sduration=${request.sduration}&srange=${request.srange}">首页</a>
                                                </li>
                                                <li><a
                                                        href="${path}/scheme/list?pageNum=${scheme.pageNum-1}&urid=${request.urid }&sstate=${request.sstate}&spnum=${request.spnum}&sduration=${request.sduration}&srange=${request.srange}"
                                                        aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                                </a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${scheme.navigatepageNums }" var="page">
                                            <c:if test="${page==scheme.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/scheme/list?pageNum=${page}&urid=${request.urid }&sstate=${request.sstate}&spnum=${request.spnum}&sduration=${request.sduration}&srange=${request.srange}">${page}</a>
                                                </li>
                                            </c:if>
                                            <c:if test="${page!=scheme.pageNum}">
                                                <li><a
                                                        href="${path }/scheme/list?pageNum=${page}&urid=${request.urid }&sstate=${request.sstate}&spnum=${request.spnum}&sduration=${request.sduration}&srange=${request.srange}">${page}</a>
                                                </li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${scheme.hasNextPage }">
                                                <li><a
                                                        href="${path }/scheme/list?pageNum=${scheme.pageNum+1 }&urid=${request.urid }&sstate=${request.sstate}&spnum=${request.spnum}&sduration=${request.sduration}&srange=${request.srange}"
                                                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                                </a></li>
                                                <li><a
                                                        href="${path }/scheme/list?pageNum=${scheme.pages}&urid=${request.urid }&sstate=${request.sstate}&spnum=${request.spnum}&sduration=${request.sduration}&srange=${request.srange}">末页</a>
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

                        <!-- 添加方案 -->
                        <div class="modal fade" id="scheme-form-div" tabindex="-1"
                             role="dialog" aria-labelledby="exampleModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="blue bigger scheme-form-title"></h4>
                                    </div>
                                    <form id="scheme-form" class="scheme-form" name="scheme-form"
                                          enctype="multipart/form-data">
                                        <div class="modal-body">
                                            <div class="input-group selectOption "
                                                 style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon ">方案分类</span>
                                                <select id="scid" name="scid" style="width: 100%;">
                                                    <option value="">选择方案分类</option>
                                                    <c:forEach var="list" items="${list}">
                                                        <option value="${list.scid}">${list.scname}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <div class="input-group" style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon " id="basic-sstate">方案状态</span>
                                                <select id="sstate" name="sstate" style="width: 100%;">
                                                    <option value="0">预览</option>
                                                    <option value="1">预审</option>
                                                    <option value="2">公开</option>
                                                    <option value="3">过期</option>
                                                </select>
                                            </div>

                                            <div class="input-group" style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon " id="basic-spnum">适合人数</span>
                                                <select id="spnum" name="spnum" style="width: 100%;">
                                                    <option value="5-10人">5-10人</option>
                                                    <option value="11-50人">11-50人</option>
                                                    <option value="51-100人">51-100人</option>
                                                    <option value="101-300人">101-300人</option>
                                                    <option value="300人以上">300人以上</option>
                                                </select>
                                            </div>

                                            <div class="input-group" style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon " id="basic-sduration">方案时长</span>
                                                <select id="sduration" name="sduration" style="width: 100%;">
                                                    <option value="半天">半天</option>
                                                    <option value="一天(不含夜)">一天(不含夜)</option>
                                                    <option value="一天(含夜)">一天(含夜)</option>
                                                    <option value="一天半(含夜)">一天半(含夜)</option>
                                                    <option value="两天一夜">两天一夜</option>
                                                    <option value="两天两夜">两天两夜</option>
                                                    <option value="三天两夜">三天两夜</option>
                                                    <option value="三天以上">三天以上</option>
                                                </select>
                                            </div>

                                            <div class="input-group" style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon " id="basic-srange">方案性质</span>
                                                <select id="srange" name="srange" style="width: 100%;">
                                                    <option value="内部人员-不外出">内部人员-不外出</option>
                                                    <option value="内部人员-外出">内部人员-外出</option>
                                                    <option value="外部人员-外出">外部人员-外出</option>
                                                    <option value="外部人员-不外出">外部人员-不外出</option>
                                                </select>
                                            </div>


                                            <input type="hidden" id="urid" name="urid" value="${request.urid }">
                                            <input type="hidden" id="sid" name="sid" value="">

                                            <div class="input-group" style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon ">方案名称</span>
                                                <input type="text" class="form-control"
                                                       placeholder="请输入方案名称..." name="sname" id="sname"
                                                       aria-describedby="basic-addon1">
                                            </div>


                                            <div class=" input-group  container"
                                                 style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon ">标签分类:</span>
                                                <input type="text"
                                                       id="txt_departmentname"
                                                       class="form-control" value=""
                                                       aria-describedby="basic-addon1"
                                                       onclick="$('#treeview').show()" placeholder="选择分类...">
                                                <div class="nav" id="treeview" style="display: none;"></div>
                                            </div>

                                            <div class="input-group tagsinput-primary form-group"
                                                 style="margin: 25px 0 0 0;">
                                                <input type="hidden" value="" id="newLabelids"
                                                       name="newLabelids" class="labelids"> <input
                                                    type="hidden" value="" id="oldLabelids" name="oldLabelids"
                                                    class="labelids"> <span class="input-group-addon "
                                            >标签列表</span> <input
                                                    id="tagsinputval" class="tagsinput" value=""
                                                    placeholder="" style="width: 100%">

                                            </div>


                                            <div class="input-group" style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon ">方案介绍</span>
                                                <textarea class="form-control" rows="3" id="sinfo" maxlength="500"
                                                          placeholder="请输入..." name="sinfo"></textarea>
                                            </div>

                                            <div class="input-group" style="margin: 25px 0 0 0;">
                                                <span class="input-group-addon ">方案预算</span>
                                                <input type="number" class="form-control" size="16"  min="1"
                                                       placeholder="请输入预算" name="sprice" id="sprice"
                                                       aria-describedby="basic-addon1">
                                            </div>

                                            <div class="input-group" style="margin: 25px 0 0 0;">
                                                <input id="oldSimg" name="oldSimg" type="hidden">
                                                <span class="input-group-addon ">方案图片</span>
                                                <div class="file-loading">
                                                    <input id="simg" name="file" type="file" accept="image">
                                                </div>
                                            </div>

                                        </div>
                                    </form>
                                    <div class="modal-footer">
                                        <button class="btn btn-sm" class="btn btn-default"
                                                data-dismiss="modal" type="submit">
                                            <i class="ace-icon fa fa-times"></i>取消
                                        </button>
                                        <button type="button"
                                                class="btn btn-sm btn-primary scheme-submit"></button>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="modal fade" id="property" tabindex="-1" role="dialog"
                             aria-labelledby="myproperty" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;
                                        </button>
                                        <h4 class="modal-title" id="myproperty">标签选择</h4>
                                    </div>
                                    <div class="modal-body" id="selectproperty"></div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                data-dismiss="modal" onclick="show()">提交
                                        </button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal -->
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


                        <%--推荐方案到广告--%>
                        <div class="modal fade" id="recommend" tabindex="-1"
                             role="dialog" aria-labelledby="exampleModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title" id="exampleModalLabel">推方案</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <input type="hidden" id="shopid" name="shopid">
                                            <input type="hidden" id="type" name="type" value="${promotion.ptype}">
                                            <input type="hidden" id="adid" name="adid" value="${promotion.id}">
                                            <input type="hidden" id="adname" name="adname" value="${promotion.pzone}">
                                            <button type="button" disabled="disabled"
                                                    class="btn btn-primary btn-xs"
                                                    style="height: 35px; margin-bottom: 4px;">选择推荐列表:
                                            </button>
                                            <select id="advertising" name="advertising"
                                                    style="height: 35px; width: 80%;">
                                                <option value="">请选择</option>
                                                <option value="6">纯文字方案列表</option>
                                                <option value="9">图文方案列表</option>
                                                <option value="12">方案纯图片列表</option>
                                            </select>
                                            <button type="button" disabled="disabled"
                                                    class="btn btn-primary btn-xs"
                                                    style="height: 35px; margin-bottom: 4px;">选择广告位:
                                            </button>
                                            <select id="position" name="position"
                                                    style="height: 35px; width: 80%;">
                                                <option value="">请选择</option>

                                            </select>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭
                                        </button>
                                        <button type="button" class="btn btn-primary" id="Add-To-Ad">提交</button>
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
<script src="${path}/assets/js/fileinput.js"></script>
<script src="${path}/assets/js/zh.js"></script>
<script src="${path}/assets/js/theme.js"></script>
<script
        src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
<script src="${path}/assets/js/bootstrap-treeview.js"></script>
<!-- 	<script src="../assets/js/tagsinput.js"></script> -->
<script src="../assets/js/bootstrap-tagsinput.js"></script>
<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>
<!-- 与此页相关的内联脚本 -->


<script
        src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.11.1/typeahead.bundle.min.js"></script>
<%--<script--%>
<%--src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.20/angular.min.js"></script>--%>
<%--<script src="../assets/js/bootstrap-tagsinput.min.js"></script>--%>
<%--<script src="../assets/js/bootstrap-tagsinput-angular.min.js"></script>--%>
<%--<script--%>
<%--src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/rainbow.min.js"></script>--%>
<%--<script--%>
<%--src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/language/generic.js"></script>--%>
<%--<script--%>
<%--src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/language/html.js"></script>--%>
<%--<script--%>
<%--src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/language/javascript.js"></script>--%>
<script src="../assets/js/app.js"></script>
<script src="../assets/js/app_bs3.js"></script>
<script src="${path}/assets/custom-js/scheme/scheme-list.js"></script>


</body>
<script>

</script>

</html>
