<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>优惠券</title>
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
                        <a href="#">优惠券列表</a>
                    </li>
                    <li class="active">优惠券列表</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        优惠券列表
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${list.total}个&emsp;
                        </small>
                        <a href="addCoupon" class="btn btn-primary btn-xs show-add-form" 
                                        >添加优惠券</a>
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
                                    <th><i class="fa fa-id-card bigger-110 hidden-480"></i>优惠券ID</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>金额</th>
                                        <th><i class="fa fa-location-arrow bigger-110 hidden-480"></i>进货价</th>
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>销售价</th>
                                        <th><i class="fa fa-picture-o bigger-110 hidden-480"></i>生效日期</th>
                                        <th><i class="fa fa-paper-plane bigger-110 hidden-480"></i>失效日期</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>置换</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>积分数量</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>优惠券图片</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>优惠券名字</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>优惠券简介</th>
                                        <th><i class="fa fa-envira bigger-110 hidden-480"></i>优惠券分类名称</th>
                                        <th><i class="fa fa-edge bigger-110 hidden-480"></i>实用范围</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>是否找零</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>过期处理</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>查看详情</th>
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody class="user-tbody">
                                    <shiro:hasPermission name="coupon:list">
                                    <c:forEach items="${list.list}" var="list">
                                             <tr>
                                            <td class="cid" >${list.cid}</td>
                                            <td class="csum">${list.csum}</td>
                                            <td class="cmoney">${list.cmoney}</td>
                                            <td class="cprice">${list.cprice}</td>
                                            <td class="csdate">${list.csdate}</td>
                                            <td class="codate">${list.codate}</td>
                                            <td class="cgoods">${list.cgoods}</td>
                                            <td class="cintegration">${list.cintegration}</td>
                                            <td class = "cimg">
                                           <img src = "${path }/uploa/image/${list.cimg}">
                                           </td>
                                            <td class="ctitle" >${list.ctitle}</td> 
                                            <td class="cinfo">${list.cinfo}</td>
                                            <td class="ccid">${list.couponclass.ccname }</td>
                                            <!--适用商户 -->
                                            <td class="crange">
                                            <c:if test="${empty list.crange}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${list.crange=='all'}"><span
                                                        class="label label-sm label-warning">全站</span></c:if>
                                                <c:if test="${list.crange=='p:1'}"><span
                                                        class="label label-sm label-success">品牌店</span></c:if>
                                                <c:if test="${list.crange=='s:1'}"><span
                                                        class="label label-sm label-inverse">单店</span></c:if>
                                            </td>                                                                                    
                                            <!--是否找零  -->
                                            <td class="cisood">
                                             <c:if test="${list.cisood==0 || list.cisood==null}"><span
                                                        class="label label-sm label-warning ">否</span></c:if>
                                                <c:if test="${list.cisood==1}"><span
                                                        class="label label-sm label-success ">是</span></c:if>
                                            </td>
                                            <td class="crefund">${list.crefund}</td>
                                           <%--  <td class="cdiscount">${list.cdiscount}</td>
                                            <td class="cfullcut">${list.cfullcut}</td> --%>
                                            <td><a href="getCoupon?id=${list.cid }">点击查看</a></td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <shiro:hasPermission name="coupon:update">
                                                        <button class="btn btn-xs btn-info show-update-form"
                                                                data-toggle="modal" data-target="#user-form-div">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>
                                                 
                                                    <shiro:hasPermission name="coupon:delete">
                                                         <c:if test="${list.ctitle ne 'admin'}">
                                                            <button class="btn btn-xs btn-danger delete-this-user">
                                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                            </button>
                                                        </c:if> 
                                                    </shiro:hasPermission>

                                                    <shiro:lacksPermission name="coupon:update">
                                                            <shiro:lacksPermission name="coupon:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                        </shiro:lacksPermission>
                                                    </shiro:lacksPermission>

                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                        <customTag:hasAnyPermissions name="coupon:update,coupon:delete">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                            </button>
                                                        </customTag:hasAnyPermissions>
                                                        <shiro:lacksPermission name="coupon:update">
                                                                <shiro:lacksPermission name="coupon:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>

                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                            <shiro:hasPermission name="coupon:update">
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
                                                    
                                                            <shiro:hasPermission name="coupon:delete">
                                                                <c:if test="${list.ctitle ne 'admin'}">
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
                                   <%--  <shiro:lacksPermission name="coupon:show">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission> --%>
                                    </tbody>
                                </table>
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
                                                <li><a href="${path}/coupon/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/coupon/list?pageNum=${list.pageNum-1}"
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
                                                        href="${path}/coupon/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=list.pageNum}">
                                                <li><a href="${path }/coupon/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${list.hasNextPage }">
                                                <li>
                                                    <a href="${path }/coupon/list?pageNum=${list.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/coupon/list?pageNum=${list.pages}">末页</a></li>
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
                                                    <div class="form-group">
                                                         <label for="form-add-cid" style="display: none">券ID<span
                                                                style="color:#F00">*</span></label>
                                                                 <div>
                                                            <input type="text" id="form-add-csum"  style="display: none"
                                                                   name="cid" placeholder="id"/>
                                                        </div>
                                                           <label for="form-add-csum">金额<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-csum"
                                                                   name="csum" placeholder="金额"/>
                                                        </div>
                                                          <label for="ccid">优惠券分类<span style="color:#F00">*</span></label>
                                                       <div>
                                                        <label for="form-add-cmoney">进货价<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-cmoney"
                                                                   name="cmoney" placeholder="进货价"/>
                                                        </div>
                                                        <label for="form-add-cprice">销售价<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-cprice"
                                                                   name="cprice" placeholder="销售价"/>
                                                        </div>
                                                        <label for="form-add-csdate">有效期起<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="csdate"/>
                                                        </div>
                                                        <label for="form-add-codate">有效期止<span style="color:#F00">*</span></label>
                                                        <div>
                                                           <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="codate"/>
                                                        </div>
                                                        <label for="form-add-cgoods">买本券所需金币<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-cgoods"
                                                                   name="cgoods" placeholder="买本券所需金币"/>
                                                        </div>
                                                          <label for="form-add-cintegration">积分数量<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-cintegration"
                                                                   name="cintegration" placeholder="积分数量"/>
                                                        </div>
                                                        <label for="form-add-bname">优惠券名字<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-bname" name="ctitle" 
                                                                   placeholder="优惠券名字"/>
                                                        </div> 
                                                        <label for="form-add-cinfo">优惠券介绍<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-cinfo"
                                                                   name="cinfo" placeholder="优惠券介绍"/>
                                                        </div>
                                                        <div>
                                                        <label for="form-add-cinfo">优惠券分类名称<span
                                                                style="color:#F00">*</span></label>
                                                         </div>
                                                         <div>
                                                         <select id="ccid" name="ccid">
      													<c:forEach var="name" items="${name}"> 
        												<option value="${name.ccid}">${name.ccname}</option>
      													</c:forEach>
														</select> 
                                                        </div>       
                                                        <label for="crange">适用商户<span style="color:#F00">*</span></label>
                                                        <div id="crange">
                                                            <label class="radio-inline">
                                                                <input name="crange" type="radio" class="ace" value="all"/>
                                                                <span class="lbl">全站</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="crange" type="radio" class="ace" value="p:1"/>
                                                                <span class="lbl">品牌店</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="crange" type="radio" class="ace"  value="s:1"/>
                                                                <span class="lbl">单店</span>
                                                            </label>
                                                        </div>
                                                        <!-- <label for="form-add-cdiscount">折扣率<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-cdiscount"
                                                                   name="cdiscount" placeholder="折扣率"/>
                                                        </div>
                                                     
                                                        <label for="form-add-cfullcut">满减<span
                                                                style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="form-add-cfullcut"
                                                                   name="cfullcut" placeholder="满减"/>
                                                        </div> -->
                                                        <label for="cisood">是否找零<span style="color:#F00">*</span></label>
                                                        <div id="cisood">
                                                            <label class="radio-inline">
                                                                <input name="cisood" type="radio" class="ace" value="0"/>
                                                                <span class="lbl">否</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="cisood" type="radio" class="ace" value="1"/>
                                                                <span class="lbl">是</span>
                                                            </label>
                                                        </div>
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
<script src="${path}/assets/custom-js/coupon/coupon.js"></script>

</body>
</html>
