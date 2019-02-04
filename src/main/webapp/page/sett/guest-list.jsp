<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>留言管理日志</title>
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
<style>
    #serch {
        /* background-color: red; */
        border: 0;
        margin-left: 50px;
    }

    .gbinfo {
        width: 50%;

    }
</style>
<body class="no-skin">
<%--top导航栏--%>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">

        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }

        function WorkLike() {
            var words = $("#condition").val();
            window.location.href = "${path}/guest/list?pageNum=1&pageSize=8&status=" + words;
        }
    </script>

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">留言管理</a>
                    </li>
                    <li class="active">留言管理列表</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        留言管理
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${guest.total}条信息&emsp;
                            <shiro:hasPermission name="guest:delete">
                                <!-- <button type="button" class="btn btn-warning btn-xs delete-query" data-toggle="modal"
                                data-target="#delete-confirm-dialog">删除所选日志
                                </button> -->
                            </shiro:hasPermission>


                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <select id="condition" style="width: 20%">
                    <option>请选择...</option>
                    <option value="all">所有留言</option>
                    <option value="Pending">未回复的留言</option>
                    <option value="Processed">已回复的留言</option>
                </select>
                <button type="button" class="btn btn-primary" style="margin:0 0 5px 5px " id="serch"
                        onclick="WorkLike()">查询
                </button>
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover log-list">
                                    <thead>
                                    <tr>
                                        <th class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace select-all-btn"/>
                                                <span class="lbl"></span>
                                            </label>
                                        </th>
                                        <th><i class="fa bigger-110 hidden-480"></i>编号</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>用户</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>留言内容</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>留言时间</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <shiro:hasPermission name="guest:list">
                                        <c:forEach items="${guest.list}" var="guest">
                                            <tr>
                                                <td class="center">
                                                    <label class="pos-rel">
                                                        <input type="checkbox" class="ace" name="gbid"
                                                               value="${guest.gbid}"/>
                                                        <span class="lbl"></span>
                                                    </label>
                                                </td>
                                                <td class="gbid">${guest.gbid}</td>
                                                <td class="username">${guest.username}</td>
                                                <td class="gbinfo">${guest.gbinfo}</td>
                                                <td class="gbdate">${guest.gbdate}</td>
                                                <td>
                                                    <div class="hidden-sm hidden-xs btn-group">
                                                        <button class="btn btn-xs btn-info Message-details"
                                                                data-toggle="modal"
                                                                data-target="#myModal">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                        <button class="btn btn-xs btn-danger delete-this-log">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="loginLog:show">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission>
                                    </tbody>
                                </table>
                                <div id="wu" style="display: none;margin-left:45%;color:red;"></div>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <%--分页--%>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${guest.pageNum}页，共${guest.pages}页，共${guest.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${guest.hasPreviousPage}">
                                                <li><a href="${path}/guest/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/guest/list?pageNum=${guest.pageNum-1}"
                                                       aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${guest.navigatepageNums }" var="page">
                                            <c:if test="${page==guest.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/guest/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=guest.pageNum}">
                                                <li><a href="${path }/guest/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${guest.hasNextPage }">
                                                <li>
                                                    <a href="${path }/guest/list?pageNum=${guest.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/guest/list?pageNum=${guest.pages}">末页</a>
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
                                        确认删除所选日志吗？
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                        <button type="button" class="btn btn-primary delete-selected-confirm">确认
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">用户留言详情及回复</h4>
                                    </div>
                                    <form class="guestbook-add-from" name="guestbook-add-from"
                                          enctype="multipart/form-data">
                                        <div class="modal-body">
                                            <div id="message">
                                                <div id="UserComments">

                                                </div>

                                                <div id="Reply" align="right">

                                                </div>
                                            </div>

                                        </div>
                                        <div class=" input-group col-xs-14"
                                             style="margin: 20px 0 0 0;">
                                            <button type="button" class="btn btn-info "
                                                    style=" width: 100%;" disabled="disabled">回复
                                            </button>
                                            <div id="myEditor" name="gbinfo"
                                                 style=" width: 100%; height: 10%;"></div>
                                        </div>
                                </div>
                                </form>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                    </button>
                                    <button type="button" class="btn btn-primary " onclick="saveGuestBook()" data-dismiss="modal">确认</button>
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
<script type="text/javascript" src="${path}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${path}/ueditor/ueditor.all.js"></script>

<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

<!-- 与此页相关的内联脚本 -->
<script src="${path}/assets/custom-js/sett/guest.js"></script>
<script type="text/javascript">
    var ue = UE.getEditor('myEditor');

    $('input[id=lefile]').change(function () {
        $('#photoCover').val($(this).val());
    });
</script>
<script type="text/javascript">
    $(function () {
        var b =
        ${guest.total}
        if (b == 0) {
            document.getElementById("wu").style.display = "block";
            var c = "无相关数据！";
            document.getElementById('wu').innerHTML = c;
        }
    })
</script>
</body>
</html>
