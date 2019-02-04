<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>订单详情</title>
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

<body class="no-skin" id="Refreshbody">
<%--top导航栏--%>

<div class="main-container ace-save-state" id="main-container">
    <%--main-content内容--%>
    <div class="main-content">
        <div class="page-header">
            <h1>
                订单详情
                <small><i class="ace-icon fa fa-angle-double-right"></i>
                </small>
            </h1>
        </div>
        <div class="main-content-inner">
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->

                        <div class="form-group">
                            <div class="try-online" style="width: 100%"><a style="width: 100%"
                                                                           class="btn-try btn btn-success btn-lg disabled">订单详情</a>
                            </div>
                            <table class="table table-hover">
                                <tr>
                                    <td>订单批次号：${orderInfo.onoun}</td>
                                    <td>下单时间：${orderInfo.odate}</td>
                                    <td>购买数量:${orderInfo.onum}件</td>
                                    <td>支付状态:
                                        <c:if test="${empty orderInfo.oispay}"><span
                                                class="label label-sm label-primary">-</span></c:if>
                                        <c:if test="${orderInfo.oispay==0}"><span
                                                class="label label-sm label-warning">未支付</span></c:if>
                                        <c:if test="${orderInfo.oispay==1}"><span
                                                class="label label-sm label-success">已支付</span></c:if>
                                        <c:if test="${orderInfo.oispay==2}"><span
                                                class="label label-sm label-inverse">未接受</span></c:if>
                                        <c:if test="${orderInfo.oispay==3}"><span
                                                class="label label-sm label-inverse">已接受</span></c:if>
                                        <c:if test="${orderInfo.oispay==4}"><span
                                                class="label label-sm label-inverse">退款中</span></c:if>
                                        <c:if test="${orderInfo.oispay==5}"><span
                                                class="label label-sm label-inverse">退款成功</span></c:if>
                                        <c:if test="${orderInfo.oispay==6}"><span
                                                class="label label-sm label-inverse">申请退款</span></c:if>
                                    </td>
                                    <td>订单状态:
                                        <c:if test="${empty orderInfo.ostae}"><span
                                                class="label label-sm label-primary">-</span></c:if>
                                        <c:if test="${orderInfo.ostae==0}"><span
                                                class="label label-sm label-warning">下单</span></c:if>
                                        <c:if test="${orderInfo.ostae==1}"><span
                                                class="label label-sm label-success">支付</span></c:if>
                                        <c:if test="${orderInfo.ostae==2}"><span
                                                class="label label-sm label-inverse">取消</span></c:if>
                                        <c:if test="${orderInfo.ostae==3}"><span
                                                class="label label-sm label-inverse">关闭</span></c:if>
                                        <c:if test="${orderInfo.ostae==4}"><span
                                                class="label label-sm label-inverse">待评论</span></c:if>
                                        <c:if test="${orderInfo.ostae==5}"><span
                                                class="label label-sm label-inverse">已评论</span></c:if>
                                    </td>

                                    <td class="oisinvoice">
                                        是否需要发票：
                                        <c:if test="${orderInfo.oisinvoice==0||orderInfo.oisinvoice==null}">
                                            <span class="label label-sm label-warning arrowed arrowed-righ">是</span></c:if>
                                        <c:if test="${orderInfo.oisinvoice==1}">
                                            <span class="label label-sm label-success arrowed arrowed-righ">否</span></c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td>订单总金额：${orderInfo.omoney}</td>
                                    <td class="opaytype">
                                        支付方式：
                                        <c:if test="${orderInfo.opaytype==0||order.opaytype==null}"><span
                                                class="label label-sm label-warning arrowed arrowed-righ">货到付款</span></c:if>
                                        <c:if test="${orderInfo.opaytype==1}"><span
                                                class="label label-sm label-success arrowed arrowed-righ">在线支付</span></c:if>
                                    </td>
                                    <td> 支付来源：
                                        <c:if test="${empty orderInfo.opaymodel}"><span
                                                class="label label-sm label-primary">-</span></c:if>
                                        <c:if test="${orderInfo.opaymodel==0}"><span
                                                class="label label-sm label-warning">支付宝</span></c:if>
                                        <c:if test="${orderInfo.opaymodel==1}"><span
                                                class="label label-sm label-success">微信</span></c:if>
                                    </td>
                                    <td> 收货方式：
                                        <c:if test="${empty orderInfo.oshfs}"><span
                                                class="label label-sm label-primary">-</span></c:if>
                                        <c:if test="${orderInfo.oshfs==0}"><span
                                                class="label label-sm label-warning">电子</span></c:if>
                                        <c:if test="${orderInfo.oshfs==1}"><span
                                                class="label label-sm label-warning">快递</span></c:if>
                                        <c:if test="${orderInfo.oshfs==2}"><span
                                                class="label label-sm label-success">自提</span></c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td>收货人名字:${orderInfo.oshname}</td>
                                    <td>收货人联系电话:${orderInfo.oshtel}</td>
                                    <td>收货人地址:${orderInfo.oshaddress}</td>
                                </tr>
                                <tr>
                                    <td>快递公司:${orderInfo.oexpress}</td>
                                    <td>快递单号:${orderInfo.oexpresssn}</td>
                                    <td>运费:${orderInfo.ofreight}</td>
                                </tr>
                                <tr>
                                    <td colspan="6">用户留言：${orderInfo.omsg}</td>
                                </tr>
                            </table>
                            <div class="try-online" style="width: 100%"><a style="width: 100%"
                                                                           class="btn-try btn btn-success btn-lg disabled">商户详情</a>
                            </div>
                            <table class="table table-hover">
                                <tr>
                                    <td rowspan="4" style="width: 25%">
                                        <img src="${orderInfo.slogo}" alt="..."
                                             class="img-rounded img-responsive center-block"
                                             style="width: 140px; height: 140px; "></td>
                                </tr>
                                <tr>
                                    <td>商户名称:${orderInfo.sname}</td>
                                </tr>
                                <tr>
                                    <td>商户电话:${orderInfo.stel}</td>
                                </tr>
                                <tr>
                                    <td>商户地址:${orderInfo.saddress}</td>
                                </tr>
                            </table>
                            <div class="try-online" style="width: 100%"><a style="width: 100%"
                                                                           class="btn-try btn btn-success btn-lg disabled">商品详情</a>
                            </div>
                            <table class="table table-hover">
                                <c:forEach items="${orderProduct}" var="product">
                                    <tr>
                                        <td rowspan="5" style="width: 25%">
                                            <img src="${product.url}" alt="..."
                                                 class="img-rounded img-responsive center-block"
                                                 style="width: 140px; height: 140px; "></td>
                                    </tr>
                                    <tr>
                                        <td>商品名称:${product.pname}</td>
                                    </tr>
                                    <tr>
                                        <td>商品价格:${product.yprice}</td>
                                    </tr>
                                    <tr>
                                        <td>购买数量:${product.ognum}</td>
                                    </tr>
                                    <tr>
                                        <td>总金额:${product.ogmoney}</td>
                                    </tr>
                                </c:forEach>
                            </table>

                            <div class="try-online" style="width: 100%"><a style="width: 100%"
                                                                           class="btn-try btn btn-success btn-lg disabled"></a>
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
<script src="${path}/assets/custom-js/order/order-list.js"></script>
<!-- 与此页相关的内联脚本 -->
</body>

</html>
