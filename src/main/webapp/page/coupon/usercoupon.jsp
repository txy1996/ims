<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>用户优惠券</title>
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
                        <a href="#">优惠券管理</a>
                    </li>
                    <li class="active">用户优惠券</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        ${findname }的代金券
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${page.total}个&emsp;
                                                        
                        </small>
                    </h1>
                </div><!-- /.page-header -->

					<div class="goods-user-filter ">
						<button type="button" disabled="disabled"
							class="btn btn-primary btn-xs"
							style="height: 35px; margin-bottom: 4px;">起止时间</button>
						<input type="date" id="starttime" placeholder="请输入开始时间" /> 到 <input
							type="date" id="endtime" placeholder="请输入结束时间" />
						<button style="height: 35px;"
							class="btn btn-success btn-xs  user-filter" onclick="select()">查询</button>


						券状态
						<select id="state" style="height: 35px;">
						<option value="lala">请选择</option>
						<option value="0">[0]已失效</option>
						<option value="1">[1]正常券</option>
						<option value="2">[2]已延期</option>
						<option value="3">[3]未激活</option>
						<option value="4">[4]未激活</option>
						<option value="5">[5]已遗失</option>
						<option value="6">[6]已核销</option>
							<%-- <c:forEach items="${list2}" var="list2">

							<option value="${findAllSett.scid}" ><c:if test="${findAllSett==findAllSett}" >selected="selected"</c:if>${findAllSett.scname}
							</option>
							<option value="${list2.ucstate}"
								<c:if test="${uvctate eq list2.uclid}">selected="selected"</c:if>><c:if
									test="${list2==list2}"></c:if>${list2.ucstate}
							</option>
						</c:forEach> --%>
							<!-- <option>请选择</option>
							<option>已过期</option>
							<option>已核销</option> -->
						</select>
						<button id="serch" style="height: 35px;"
							class="btn btn-success btn-xs  search-query" onclick="select1()">查询</button>
					</div>

					<div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover perm-list">
                                    <thead>
                                    <tr>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>ID</th>
                                        <th><i class="fa fa-key bigger-110 hidden-480"></i>优惠券名字</th>
                                        <!-- <th><i class="fa fa-location-arrow bigger-110 hidden-480"></i>优惠方式</th> -->
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>购买价格</th>
                                         <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>适用范围</th>
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>状态</th>
                                        <th><i class="fa fa-picture-o bigger-110 hidden-480"></i>生效日期-失效日期</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>使用商户</th>
                                        <th><i class="fa fa-flag bigger-110 hidden-480"></i>获取方式</th>                                  
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody id="222">
                                    <shiro:hasPermission name="usercoupon:list">
                                    <c:forEach items="${list.list}" var="list">
                                        
                                        
                                        
                                        
                                        <tr>
                                        	
                                            <td class="vid"><input type="hidden" id="uclid1" value="${list.uclid}"/>${list.uclid}</td> 
                                            <td class="vmoney"><input type="hidden" id="hi" value="${list.cou.cid }"/>${list.cou.ctitle}</td> 
                                            <!-- <td class="vcost">不知道</td>  -->
                                            <td class="vprice">${list.cou.cprice}</td>	
                                            <td class="vsdate">${list.a}
											<c:set var="theString" value="${list.cou.crange}"/>                                        
                                            <c:choose> 
                                            <c:when test="${fn:contains(theString,'p')}">[品牌]</c:when>
                                            <c:when test="${fn:contains(theString,'s')}">[单店]</c:when>
                                            <c:when test="${fn:contains(theString,'all')}">[全站]</c:when>
                                            </c:choose>

</td> 
                                            <td class="vodate"><input type="hidden" id="state1" value="${list.ucstate}"/>${list.ucstate}</td> 
                                            <td class="vgoods" id="aaa"><input type="hidden" id="date" value="${list.cou.codate }"/>${list.cou.csdate}-${list.cou.codate }</td> 
                                            <td class="vintegration">${list.sb.bname }[${list.s.sname }]</td> 
                                            <td class="vimg">${list.ucgetchannel}</td> 
                                                                                       	                                       
                                            
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
																
																	<button type="button" class="btn btn-xs btn-info" data-toggle="modal" data-target="#exampleModal"
                    												data-whatever="${list.uclid}" <c:if test="${not empty list.ucInvalid }">disabled="disabled"</c:if> <c:if test="${not empty list.s.sname }">disabled="disabled"</c:if>>作废
            														</button>
																
																	<button type="button" class="btn btn-xs btn-info" data-toggle="modal" data-target="#exampleModal1"
                    												data-whatever="${list.uclid}" <c:if test="${not empty list.uvlInvalid }">disabled="disabled"</c:if> <c:if test="${not empty list.s.sname }">disabled="disabled"</c:if>>延期
            														</button>
															</div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="usercoupon:list">
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
                                当前第${list.pageNum}页，共${list.pages}页，共${list.total}条记录
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <nav aria-lable="Page navigation">
                                    <ul class="pagination">
                                        <c:choose>
                                            <c:when test="${list.hasPreviousPage}">
                                                <li><a href="${path}/usercoupon/list?pageNum=1&urid=${urid1 }">首页</a></li>
                                                <li>
                                                    <a href="${path}/usercoupon/list?pageNum=${list.pageNum-1}&urid=${urid1 }"
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
                                                        href="${path}/usercoupon/list?pageNum=${page}&urid=${urid1 }">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=list.pageNum}">
                                                <li><a href="${path }/usercoupon/list?pageNum=${page}&urid=${urid1 }">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${list.hasNextPage }">
                                                <li>
                                                    <a href="${path }/usercoupon/list?pageNum=${list.pageNum+1 }&urid=${urid1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/usercoupon/list?pageNum=${list.pages}&urid=${urid1 }">末页</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">末页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                    </ul>
                                </nav>
                            </div>
                        </div>

							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">×</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel"></h4>
										</div>
										<div class="modal-body">
											<form>
												<div class="form-group">
													<!-- <label for="recipient-name1" class="control-label">Recipient:</label> -->
													<input type="hidden" class="form-control"
														id="recipient-name1">
												</div>
												<div class="form-group">
													<label for="message-text" class="control-label">作废理由:</label>
													<textarea class="form-control" id="message-text"></textarea>
												</div>
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="save1()">save</button>
										</div>
									</div>
								</div>
							</div>
							
							
							
							<div class="modal fade" id="exampleModal1" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">×</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel"></h4>
										</div>
										<div class="modal-body">
											<form>
												<div class="form-group">
													<!-- <label for="recipient-name1" class="control-label">Recipient:</label> -->
													<input type="hidden" class="form-control"
														id="recipient-name11">
												</div>
												<div class="form-group">
													<label for="message-text" class="control-label">延期理由:</label>
													<textarea class="form-control" id="message-text1"></textarea>
												</div>
												<div>
													<select id="se">
														<option  value="7">7天</option>
														<option  value="15">半个月</option>
														<option  value="30">一个月</option>
													</select>
												</div>
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="save()">save</button>
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
<script src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

<!-- 与此页相关的内联脚本 -->
<%-- <script src="${path}/assets/custom-js/voucher/voucher.js"></script> --%>

</body>
<script>

function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}

function select(){
	var a=$("#starttime").val();
	var b=$("#endtime").val();
	/* var c="'"+${findname }+"'"; */
	console.log(a);
	console.log(b);
	console.log("${findname }")
	$.ajax({
		url : "../usercoupon/list.html",
		dataType : "html",// 特别重要
		data : {
			starttime : a,
			endtime:b,
			name:"${findname }"
		},
		type : "POST",
		success : function(data) {
			$("#Refreshbody").html(data)
		},
		error : function() {

		}
	});
}

function select1(){
	var a=$("#state").val();
	console.log(a)
	console.log("${findname }")
	$.ajax({
		url : "../usercoupon/list.html",
		dataType : "html",// 特别重要
		data : {
			ucstate : a,
			name:"${findname }"
		},
		type : "POST",
		success : function(data) {
			$("#Refreshbody").html(data)
		},
		error : function() {

		}
	});
}
var recipient='';
$('#exampleModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // 触发事件的按钮
    recipient = button.data('whatever') // 解析出data-whatever内容
    console.log(recipient)
    var modal = $(this)
    //modal.find('.modal-title').text('Message To ' + recipient)
    modal.find('.modal-body input #recipient-name1').val(recipient)
})

$('#exampleModal1').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // 触发事件的按钮
    recipient = button.data('whatever') // 解析出data-whatever内容
    console.log(recipient)
    var modal = $(this)
    //modal.find('.modal-title').text('Message To ' + recipient)
    modal.find('.modal-body input #recipient-name11').val(recipient)
})

/* $(".save1").click(function(){
	
}) */

function save1(){
	console.log("asas")
	console.log($("#recipient-name11").val())
	console.log("333")
	$.ajax({
        url:"../usercoupon/update.html",
        type:"POST",
        data:{
        	uclid:recipient,
        	ucinfo:$("#message-text").val()
        },
        success:function(){
        	$(".exampleModal").modal("hide");
        	showTips("作废成功");
        	$(".close-tip").click(function () {
        		setTimeout(function(){window.location.reload()},220);
        	})                                	
        },
        error:function(){
        	$(".exampleModal").modal("hide");
            showTips("作废失败！");
        }
})
}

function save(){
	console.log("asas")
	console.log(recipient)
	console.log($("#se").val())
	console.log("333")
	console.log($("#hi").val())
	console.log("444")
	console.log($("#date").val())
	$.ajax({
        url:"../usercoupon/update1.html",
        type:"POST",
        data:{
        	uclid:recipient,
        	ucinfo:$("#message-text1").val(),
        	time:$("#se").val(),
        	cid:$("#hi").val(),
        	state:$("#state1").val()
        },
        success:function(){
        	$(".exampleModal").modal("hide");
        	showTips("延期成功");
        	$(".close-tip").click(function () {
        		setTimeout(function(){window.location.reload()},220);
        	})                                	
        },
        error:function(){
        	$(".exampleModal").modal("hide");
            showTips("延期失败！");
            //alter("延期失败")
        }
})
}

var tableObj = document.getElementById('222').rows[0];
if (tableObj == null) {
	document.getElementById("what").style.display="";
}
</script>
</html>
