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

<body class="no-skin" id="Refreshbody">
<%--top导航栏--%>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
        
        function toSearch(id) {
        	 //debugger;  
        	var oshtel =$("#oshtel").val();
        	var oexpresssn = $("#oexpresssn").val();
        	console.log(id)
       	$.ajax({
                url:"${path}/order/list",
                data:{
                	urid:id,
                	"oshtel":oshtel,
                	"oexpresssn":oexpresssn,
                	pageNum:1,
                	pageSize:8
                	},
                dataType : "html",// 特别重要
                type:"POST",
                traditional:true,
                success:function(data){
                	//location.href ='${path}/order/list?pageNum=1&pageSize=8&oshtel='+oshtel+'&oexpresssn='+oexpresssn;
               		console.log("加载中...");
               		$("#Refreshbody").html(data)
                }
            });   
        	
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
                        订单
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${order.total}个&emsp;
                            <%-- <shiro:hasPermission name="order:delete">
                                <button type="button" class="btn btn-warning btn-xs delete-query" data-toggle="modal"
                                        data-target="#delete-confirm-dialog">删除所选权限
                                </button>
                            </shiro:hasPermission> --%>
                            <shiro:hasPermission name="order:add">
                                <button type="button" class="btn btn-primary btn-xs show-add-form" data-toggle="modal"
                                        data-target="#perm-form-div">添加新权限
                                </button>
                            </shiro:hasPermission>
                        </small>
                    </h1>
                </div><!-- /.page-header -->
              <!--  <input type="text" id="oshname" name="oshname" placeholder="请输入收货人名字"/> -->
          	<label>联系电话：</label>     
              <input type="text" id="oshtel" name="oshtel" placeholder="请输入收货人联系电话"/>
                <!-- <input type="text" id="oexpress" name="oexpress" placeholder="请输入快递公司"/> -->
              <label>  快递单号 ：</label>
             <input type="text" id="oexpresssn" name="oexpresssn" placeholder="请输入快递单号"/>
                <button id ="search" onclick="toSearch(${urid})" style="border:0px;background-color: rgb(66,139,202);color:white">查询</button>
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover perm-list">
                                    <thead>
                                    <tr>
                                        <th><i class="fa bigger-110 hidden-480"></i>ID</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>公司名称</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>下单时间</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>数量</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>所获积分</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>总金额</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>所需金币</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>非成功原因</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>收货人</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>联系电话</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>地址</th>
                               			<th><i class="fa bigger-110 hidden-480"></i>快递公司</th>
                                    	<th><i class="fa  bigger-110 hidden-480"></i>快递单号</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>支付方式</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>是否需要发票</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>支付来源</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>支付状态</th>
                                        <th><i class="fa bigger-110 hidden-480"></i>订单状态</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>收货方式</th>
                                        <th><i class="fa  bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody id="222">
                                    <shiro:hasPermission name="order:list">
                                    <c:forEach items="${order.list}" var="order">
                                        <tr>
                                            <td class="oid">${order.oid}</td>
                                            <td class="cname">${order.company.cname}</td>
                                            <td class="odate">
                                            	<fmt:formatDate value="${order.odate}" type="both"
                                                                pattern="yyyy-MM-dd HH:mm:ss"/>
                                            </td>
                                            <td class="onum">${order.onum}</td>
                                            <td class="ogetintegration">${order.ogetintegration}</td>
                                            <td class="omoney">${order.omoney}</td>
                                            <td class="ogoods">${order.ogoods}</td>
                                            <td class="onoinfo">${order.onoinfo}</td>
                                            <td class="oshtel">${order.oshname}</td>
                                            <td class="oshtel">${order.oshtel}</td>
                                            <td class="oshaddress">${order.oshaddress}</td>
                                            <td class="oexpress">${order.oexpress}</td>
                                           <td class="oexpresssn">${order.oexpresssn}</td>
                                            <td class="opaytype">
                                                <c:if test="${order.opaytype==0||order.opaytype==null}"><span
                                                        class="label label-sm label-warning arrowed arrowed-righ">货到付款</span></c:if>
                                                <c:if test="${order.opaytype==1}"><span
                                                        class="label label-sm label-success arrowed arrowed-righ">在线支付</span></c:if>
                                            </td>
                                            <td class="oisinvoice">
                                                <c:if test="${order.oisinvoice==0||order.oisinvoice==null}">
                                                <span class="label label-sm label-warning arrowed arrowed-righ">是</span></c:if>
                                                <c:if test="${order.oisinvoice==1}">
                                                <span class="label label-sm label-success arrowed arrowed-righ">否</span></c:if>
                                            </td>
                                            
                                              <td>
                                                <c:if test="${empty order.opaymodel}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${order.opaymodel==0}"><span
                                                        class="label label-sm label-warning">支付宝</span></c:if>
                                                <c:if test="${order.opaymodel==1}"><span
                                                        class="label label-sm label-success">微信</span></c:if>
                                                <c:if test="${order.opaymodel==2}"><span
                                                        class="label label-sm label-inverse">金币</span></c:if>
                                            </td>
                                            
                                        
                                             <td>
                                                <c:if test="${empty order.oispay}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${order.oispay==0}"><span
                                                        class="label label-sm label-warning">未支付</span></c:if>
                                                <c:if test="${order.oispay==1}"><span
                                                        class="label label-sm label-success">已支付</span></c:if>
                                                <c:if test="${order.oispay==2}"><span
                                                        class="label label-sm label-inverse">未接受</span></c:if>
                                                <c:if test="${order.oispay==3}"><span
                                                        class="label label-sm label-inverse">已接受</span></c:if>
                                                <c:if test="${order.oispay==4}"><span
                                                        class="label label-sm label-inverse">退款中</span></c:if>
                                                <c:if test="${order.oispay==5}"><span
                                                        class="label label-sm label-inverse">退款成功</span></c:if>
                                                <c:if test="${order.oispay==6}"><span
                                                        class="label label-sm label-inverse">申请退款</span></c:if>
                                            </td>
                                            
                                         
                                            
                                             <td>
                                                <c:if test="${empty order.ostae}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${order.ostae==0}"><span
                                                        class="label label-sm label-warning">下单</span></c:if>
                                                <c:if test="${order.ostae==1}"><span
                                                        class="label label-sm label-success">支付</span></c:if>
                                                <c:if test="${order.ostae==2}"><span
                                                        class="label label-sm label-inverse">取消</span></c:if>
                                                 <c:if test="${order.ostae==3}"><span
                                                        class="label label-sm label-inverse">关闭</span></c:if>
                                            </td>
                                            
                                            
                                             <td>
                                                <c:if test="${empty order.oshfs}"><span
                                                        class="label label-sm label-primary">-</span></c:if>
                                                <c:if test="${order.oshfs==0}"><span
                                                        class="label label-sm label-warning">电子收货</span></c:if>
                                                <c:if test="${order.oshfs==1}"><span
                                                        class="label label-sm label-success">快递</span></c:if>
                                                <c:if test="${order.oshfs==2}"><span
                                                        class="label label-sm label-inverse">自提</span></c:if>
                                            </td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <shiro:hasPermission name="order:update">
                                                        <button class="btn btn-xs btn-info show-update-form"
                                                                data-toggle="modal" data-target="#perm-form-div">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="order:delete">
                                                        <button class="btn btn-xs btn-danger delete-this-perm">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </shiro:hasPermission>

                                                    <shiro:lacksPermission name="order:update">
                                                        <shiro:lacksPermission name="order:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                        </shiro:lacksPermission>
                                                    </shiro:lacksPermission>

                                                </div>
                                                <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                        <customTag:hasAnyPermissions
                                                                name="order:update,order:delete">
                                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                                    data-toggle="dropdown" data-position="auto">
                                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                            </button>
                                                        </customTag:hasAnyPermissions>
                                                        <shiro:lacksPermission name="order:update">
                                                            <shiro:lacksPermission name="order:delete">
                                                    <span class="label label-large label-grey arrowed-in-right arrowed-in">
                                                        <i class="ace-icon fa fa-lock" title="无权限"></i>
                                                    </span>
                                                            </shiro:lacksPermission>
                                                        </shiro:lacksPermission>
                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                            <shiro:hasPermission name="order:update">
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
                                                            <shiro:hasPermission name="order:delete">
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
                                    <shiro:lacksPermission name="order:list">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission>
                                    </tbody>
                                </table>
                                <div style="display: none;margin-left:45%;color:red;" id="what">暂无数据</div>
                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <%--分页--%>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                当前第${order.pageNum}页，共${order.pages}页，共${order.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${order.hasPreviousPage}">
                                                <li><a href="${path}/order/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/order/list?pageNum=${order.pageNum-1}"
                                                       aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">首页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach items="${order.navigatepageNums }" var="page">
                                            <c:if test="${page==order.pageNum}">
                                                <li class="active"><a
                                                        href="${path}/order/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=order.pageNum}">
                                                <li><a href="${path }/order/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${order.hasNextPage }">
                                                <li>
                                                    <a href="${path }/order/list?pageNum=${order.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/order/list?pageNum=${order.pages}">末页</a></li>
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
                                                    <input type="hidden" name="oid" class="form-control" id="idInput">
                                                    <div class="form-group">
                                                        <label for="odate">下单时间<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="Date" id="odate" name="odate" value=""/>
                                                        </div>
                                                         <label for="onum">购买数量<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="onum" name="onum" min="1" placeholder=""/>
                                                        </div>
                                                         <label for="omoney">总金额<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="omoney" name="omoney" placeholder=""/>
                                                        </div>
                                                        
                                                         <label for="ogoods">所需金币<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="ogoods" name="ogoods" placeholder=""/>
                                                        </div>
                                                        
                                                         <label for="ogetintegration">所获得积分<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="ogetintegration" name="ogetintegration" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="onoinfo">非成功的原因<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="onoinfo" name="onoinfo" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="oshname">收货人名字<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="oshname" name="oshname" placeholder=""/>
                                                        </div>
                                                        
                                                           <label for="oshtel">收货人电话<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="oshtel" name="oshtel" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="oshaddress">收货人地址<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="oshaddress" name="oshaddress" placeholder=""/>
                                                        </div>
                                                        
                                                         
                                                        
                                                        
                                                    </div>
                                                </div>


                                                <div class="col-xs-12 col-sm-6">
                                                    <div class="form-group">
                                                    
                                                     <label for="oexpress">快递公司<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="oexpress" name="oexpress" placeholder=""/>
                                                        </div>
                                                         
                                                          <label for="oexpresssn">快递单号<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="oexpresssn" name="oexpresssn" placeholder=""/>
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" class="ace" name="opaytype" value="1"><span class="lbl">在线支付</span>
                                                            </label>
                                                        </div>
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" class="ace" name="oisinvoice" value="1"><span class="lbl">不需要发票</span>
                                                            </label>
                                                        </div>
                                                        
                                                         <label for="opaymodel">支付来源<span style="color:#F00">*</span></label>
                                                        <div id="opaymodel">
                                                            <label class="radio-inline">
                                                                <input name="opaymodel" type="radio" class="ace" value="0"/>
                                                                <span class="lbl">支付宝</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="opaymodel" type="radio" class="ace" value="1"  checked/>
                                                                <span class="lbl">微信</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="opaymodel" type="radio" class="ace"  value="2"/>
                                                                <span class="lbl">金币</span>
                                                            </label>
                                                        </div>
                                                        
                                                          <label for="oispay">支付状态<span style="color:#F00">*</span></label>
                                                        <div id="oispay">
                                                            <label class="radio-inline">
                                                                <input name="oispay" type="radio" class="ace" value="0"/>
                                                                <span class="lbl">未支付</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="oispay" type="radio" class="ace" value="1"  checked/>
                                                                <span class="lbl">已支付</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="oispay" type="radio" class="ace"  value="2"/>
                                                                <span class="lbl">未接受</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="oispay" type="radio" class="ace"  value="3"/>
                                                                <span class="lbl">已接受</span>
                                                            </label>
                                                              <label class="radio-inline">
                                                                <input name="oispay" type="radio" class="ace"  value="4"/>
                                                                <span class="lbl">退款中</span>
                                                            </label>
                                                              <label class="radio-inline">
                                                                <input name="oispay" type="radio" class="ace"  value="5"/>
                                                                <span class="lbl">退款成功</span>
                                                            </label>
                                                              <label class="radio-inline">
                                                                <input name="oispay" type="radio" class="ace"  value="6"/>
                                                                <span class="lbl">申请退款</span>
                                                            </label>
                                                        </div>
                                                        
                                                         <label for="ostae">订单状态<span style="color:#F00">*</span></label>
                                                        <div id="ostae">
                                                            <label class="radio-inline">
                                                                <input name="ostae" type="radio" class="ace" value="0"/>
                                                                <span class="lbl">下单</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="ostae" type="radio" class="ace" value="1"  checked/>
                                                                <span class="lbl">支付</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="ostae" type="radio" class="ace"  value="2"/>
                                                                <span class="lbl">取消</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="ostae" type="radio" class="ace"  value="3"/>
                                                                <span class="lbl">关闭</span>
                                                            </label>
                                                        </div>
                                                        
                                                        
                                                         <label for="oshfs">收货方式<span style="color:#F00">*</span></label>
                                                        <div id="oshfs">
                                                            <label class="radio-inline">
                                                                <input name="oshfs" type="radio" class="ace" value="0"/>
                                                                <span class="lbl">电子收货</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="oshfs" type="radio" class="ace" value="1"  checked/>
                                                                <span class="lbl">快递</span>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="oshfs" type="radio" class="ace"  value="2"/>
                                                                <span class="lbl">自提</span>
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

<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>
<script src="${path}/assets/custom-js/order/order-list.js"></script>
<!-- 与此页相关的内联脚本 -->
</body>
<script>
var tableObj = document.getElementById('222').rows[0];
if (tableObj == null) {
	document.getElementById("what").style.display="";
}
</script>
</html>
