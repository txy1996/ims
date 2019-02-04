<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>商品管理列表</title>
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

        .container {
            height: auto;
            position: relative;
            margin: 0 auto;
        }

        .nav {
            position: absolute;
            width: 83%;
            top: 100%;
            z-index: 9999;
            overflow-y: auto;
            overflow-x: auto;
            height: 250px;
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
    </script>

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed"
                 id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">商品管理</a>
                    </li>
                    <li class="active">商品列表</li>
                </ul>
                <!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        商品列表管理
                        <small><i
                                class="ace-icon fa fa-angle-double-right"></i> <span
                                id="amount">共${list.total}个商品&emsp;</span>
                            <%-- <a class='btn btn-primary btn-xs'
                            href="${path}/product/addProduct?sid=${request.sid}">添加商品</a> --%>
                            <button type="button"
                                    class="btn btn-primary btn-xs show-add-form"
                                    data-toggle="modal" data-target="#user-form-div"
                                    data-whatever="${request.sid}" data-html="true"
                            >添加商品
                            </button>
                        </small>
                    </h1>
                </div>
                <!-- /.page-header -->
                <div class=" input-group input-group-sm col-xs-3 container"
                     style="float: left; margin: 0 20px 0 0;">
                    <span class="input-group-addon ">搜索:</span> <input type="hidden"
                                                                       value="${request.cname}" id="cname" name="cname"
                                                                       class="cname">
                    <input type="text" id="txt_departmentname"
                           name="txt_departmentname" class="form-control" value=""
                           onclick="$('#treeview').show()" placeholder="选择分类...">
                    <div class="nav" id="treeview" style="display: none;"></div>
                </div>

                <div class=" input-group input-group-sm col-xs-2 state"
                     style="float: left; margin: 0 20px 0 0;">
                    <select id="stateQuery" name="state" style="width: 100%;">
                        <option value="">请选择商品状态</option>
                        <option value="0">未上架</option>
                        <option value="1">上架</option>
                        <option value="3">已售罄</option>
                        <option value="2">已下架</option>
                    </select>
                </div>

                <div class=" input-group input-group-sm col-xs-2 "
                     style="float: left; margin: 0 20px 0 0;">
                    <input type="text" class="form-control inputcommodity"
                           name="pname" placeholder="请输入商品名称..."
                           aria-describedby="basic-addon1">
                </div>
                <div class=" input-group input-group-sm col-xs-2 "
                     style="float: left; margin: 0 20px 0 0;">
                    <button type="button" class="btn btn-primary" id="NameQuery"
                            style="width: 70%">查询
                    </button>
                    <input type="hidden" id="sid" value="${request.sid}">
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
                                        <th><i class="fa fa-user bigger-110 hidden-480"></i>分类</th>
                                        <th><i
                                                class="fa fa-user-circle-o bigger-110 hidden-480"></i>商户名称
                                        </th>
                                        <th><i
                                                class="fa fa-user-circle-o bigger-110 hidden-480"></i>商品名字
                                        </th>

                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>销量</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>库存</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>状态</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody class="user-tbody">

                                    <c:forEach items="${list.list}" var="list">
                                        <tr>
                                            <td class="center"><label class="pos-rel"> <input
                                                    type="checkbox" class="ace" name="id" value="${list.id}"/>
                                                <span class="lbl"></span>
                                            </label></td>
                                            <td class="id">${list.id}</td>
                                            <td class="cname">${list.cname}</td>
                                            <td class="sname">${list.sname}</td>
                                            <td class="pname">${list.pname}</td>
                                            <td class="spunum">${list.spunum}</td>
                                            <td class="stock">${list.stock}</td>
                                            <td class="state"><c:if test="${empty list.state}">
                                                <span class="label label-sm label-primary">-</span>
                                            </c:if> <c:if test="${list.state==0}">
                                                <span class="label label-sm label-warning">未上架</span>
                                            </c:if> <c:if test="${list.state==1}">
                                                <span class="label label-sm label-success">上架</span>
                                            </c:if> <c:if test="${list.state==2}">
                                                <span class="label label-sm label-info">下架</span>
                                            </c:if></td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <a class='btn btn-primary btn-xs'
                                                       href="${path}/product/updateProduct?id=${list.id}&sid=${request.sid}"><i
                                                            class="ace-icon fa  bigger-120 ">修改</i></a>
                                                    <button class="btn btn-xs btn-info TransferId"
                                                            data-toggle="modal" data-target="#exampleModal">
                                                        <i class="ace-icon fa  bigger-120">状态</i>
                                                    </button>
                                                    <button class="btn btn-xs btn-info " data-toggle="modal"
                                                            data-target="#recommend" id="productid">
                                                        <i class="ace-icon fa  bigger-120">推荐</i>
                                                    </button>
                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel"></div>
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
                        <div id="pagebottom" class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${list.pageNum}页，共${list.pages}页，共${list.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${list.hasPreviousPage}">
                                                <li><a
                                                        href="${path}/product/selectProduct?pageNum=1&sid=${request.sid}&pcid=${request.pcid}&cname=${request.cname}">首页</a>
                                                </li>
                                                <li><a
                                                        href="${path}/product/selectProduct?pageNum=${list.pageNum-1}&sid=${request.sid}&pcid=${request.pcid}&cname=${request.cname}"
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
                                                        href="${path}/product/selectProduct?pageNum=${page}&sid=${request.sid}&pcid=${request.pcid}&cname=${request.cname}"
                                                    >${page}</a>
                                                </li>
                                            </c:if>
                                            <c:if test="${page!=list.pageNum}">
                                                <li><a
                                                        href="${path }/product/selectProduct?pageNum=${page}&sid=${request.sid}&pcid=${request.pcid}&cname=${request.cname}">${page}</a>
                                                </li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${list.hasNextPage }">
                                                <li><a
                                                        href="${path }/product/selectProduct?pageNum=${list.pageNum+1 }&sid=${request.sid}&pcid=${request.pcid}&cname=${request.cname}"
                                                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                                </a></li>
                                                <li><a
                                                        href="${path }/product/selectProduct?pageNum=${list.pages}&sid=${request.sid}&pcid=${request.pcid}&cname=${request.cname}">末页</a>
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
                                                    <div class="form-group">

                                                        <div
                                                                class=" input-group input-group-sm col-xs-4 container"
                                                                style="float: left; margin: 25px 800px 0 0;">
                                                            <%--@declare id="exampleinputemail1"--%><input id="inp"
                                                                                                           type="hidden">
                                                            <label for="exampleInputEmail1">商品分类:</label> <input
                                                                type="hidden" value="" id="cid" name="cid" class="cid">
                                                            <input type="text" id="txt_departmentname1"
                                                                   name="txt_departmentname1" class="form-control"
                                                                   value="" onclick="$('#treeview1').show()"
                                                                   placeholder="分类名称" style="width:150px;">
                                                            <div class="nav" id="treeview1"
                                                                 style="display: none; width:200px;height:300px;"></div>

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
                                                class="btn btn-sm btn-primary savepro">确定
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </div>


                        <div class="modal fade" id="exampleModal" tabindex="-1"
                             role="dialog" aria-labelledby="exampleModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title">更改商品状态</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <input type="hidden" value="" id="commodityId" name="id">
                                            <button type="button" disabled="disabled"
                                                    class="btn btn-primary btn-xs"
                                                    style="height: 35px; margin-bottom: 4px;">状态:
                                            </button>
                                            <select id="state" name="state"
                                                    style="height: 35px; width: 80%;">
                                                <option value="">请选择</option>
                                                <option value="0">未上架</option>
                                                <option value="1">上架</option>
                                                <option value="3">已售罄</option>
                                                <option value="2">已下架</option>
                                            </select>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                data-dismiss="modal" id="updateState">提交
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="modal fade" id="recommend" tabindex="-1"
                             role="dialog" aria-labelledby="exampleModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title" id="exampleModalLabel">推荐商品</h4>
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
                                                <option value="7">纯文字商品列表</option>
                                                <option value="10">图文商品列表</option>
                                                <option value="13">商品纯图片列表</option>
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
<script src="${path}/assets/js/bootstrap-treeview.js"></script>
<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

<!-- 与此页相关的内联脚本 -->
<script src="${path}/assets/custom-js/product/product-list.js"></script>


</body>


</html>
