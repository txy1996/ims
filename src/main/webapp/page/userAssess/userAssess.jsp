<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>用户评论</title>
<%@include file="../common/meta.jsp"%>
<%@include file="../common/assets-css.jsp"%>

<!-- 页面特殊插件样式 -->
<link rel="stylesheet"
	href="${path}/assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet" href="${path}/assets/css/chosen.min.css" />
<link rel="stylesheet"
	href="${path}/assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet"
	href="${path}/assets/css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" href="${path}/assets/css/daterangepicker.min.css" />
<link rel="stylesheet"
	href="${path}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet"
	href="${path}/assets/css/bootstrap-colorpicker.min.css" />


<!-- 这里是本页内联样式开始 -->
<!-- 这里是本页内联样式结束 -->

<%@include file="../common/assets-js.jsp"%>

<style>
.star-vote {
	width: 120px;
	height: 20px;
	position: relative;
	overflow: hidden;
}

.star-vote>span {
	position: absolute;
	width: 120px;
	height: 20px;
	background-size: cover;
	background-repeat: no-repeat;
	left: 0px;
	top: 0px;
}

.star-vote>.add-star {
	background-image: url("${path}/resource/images/yellowstar.png");
}

.star-vote>.del-star {
	background-image: url("${path}/resource/images/whitestars.png");
	background-color: white;
}

.star-vote>.del-star0 {
	background-image: url("${path}/resource/images/whitestars.png");
	background-color: white;
}

.star-vote>.del-star1 {
	background-image: url("${path}/resource/images/whitestars.png");
	background-color: white;
	backgroundPosition: -24px 0px;
	left: 24px;
}

.star-vote>.del-star2 {
	background-image: url("${path}/resource/images/whitestars.png");
	background-color: white;
	backgroundPosition: -48px 0px;
	left: 48px;
}

.star-vote>.del-star3 {
	background-image: url("${path}/resource/images/whitestars.png");
	background-color: white;
	backgroundPosition: -72px 0px;
	left: 72px;
}

.star-vote>.del-star4 {
	background-image: url("${path}/resource/images/whitestars.png");
	background-color: white;
	backgroundPosition: -96px 0px;
	left: 96px;
}

.star-vote>.del-star5 {
	background-image: url("${path}/resource/images/whitestars.png");
	background-color: white;
	backgroundPosition: -120px 0px;
	left: 120px;
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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">评论管理</a>
						</li>
						<li class="active">评论列表</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>



				<div class="page-content">
					<div class="page-header">
						<h1>
							用户评论 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								<input type="hidden" class="size" value="${list.total}">
								<span id="amount">共${list.total}条评论&emsp;</span> <shiro:hasPermission
									name="userAssess:delete">
									<button type="button"
										class="btn btn-warning btn-xs delete-query"
										data-toggle="modal" data-target="#delete-confirm-dialog">删除评论
									</button>
								</shiro:hasPermission> <shiro:hasPermission name="userAssess:add">
									<button type="button"
										class="btn btn-primary btn-xs show-add-form"
										data-toggle="modal" data-target="#user-form-div">添加评论
									</button>
								</shiro:hasPermission>
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<div class="user-search ">
						<button type="button" disabled="disabled"
							class="btn btn-primary btn-xs"
							style="height: 35px; margin-bottom: 4px;">搜索</button>
						<select id="searchfor" style="height: 35px;">
							<option>请选择</option>
							<option value="0">商户名称</option>
							<option value="1">方案名称</option>
							<option value="2">阶段名称</option>
							<option value="3">商品名称</option>
						</select> <input type="text" id="commentinfo" placeholder="请输入" />
						<button style="height: 35px;"
							class="btn btn-success btn-xs  search-query">查询</button>

						<button disabled="disabled"
							style="margin-left: 160px; margin-bottom: 4px; height: 35px;"
							class="btn btn-primary btn-xs">筛选</button>
						<select id="queryRating" name="lclcid" style="height: 35px;">
							<option>筛选分值</option>
							<option value="0">0分</option>
							<option value="1">1分</option>
							<option value="2">2分</option>
							<option value="3">3分</option>
							<option value="4">4分</option>
							<option value="5">5分</option>
						</select>
					</div>

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-xs-12">


									<div class="table-responsive">
										<table id="simple-table " class="table    table-bordered">
											<tbody class="user-tbody">
												<shiro:hasPermission name="userAssess:list">
													<input type="hidden" id="uaoid" value="${request.uaoid}">
													<input type="hidden" id="uaotype"
														value="${request.uaotype}">
													<c:forEach items="${list.list}" var="list">
														<tr>
															<td class="username" align="justify">评论人:${list.username}[
																<c:if test="${empty list.uaisanonymous}">
																	<span class="label label-sm label-primary">-</span>
																</c:if> <c:if test="${list.uaisanonymous==0}">
																	<span class="label label-sm label-warning">[匿名]</span>
																</c:if> <c:if test="${list.uaisanonymous==1}">
																	<span class="label label-sm label-success">[实名]</span>
																</c:if> ] <input type="hidden" id="uaid" value="${list.uaid}">
																[ <c:if test="${empty list.uaotype}">
																	<span class="label label-sm label-primary">-</span>
																</c:if> <c:if test="${list.uaotype==0}">
																	<span class="label label-sm label-warning">[商户]</span>
																</c:if> <c:if test="${list.uaotype==1}">
																	<span class="label label-sm label-success">[方案]</span>
																</c:if> <c:if test="${list.uaotype==2}">
																	<span class="label label-sm label-info">[阶段]</span>
																</c:if> <c:if test="${list.uaotype==3}">
																	<span class="label label-sm label-danger">[商品]</span>
																</c:if> ] <c:if test="${empty list.uaotype}">
																	<span class="label label-sm label-primary">---</span>
																</c:if> <c:if test="${list.uaotype==0}">
																	:${list.shopname}
																</c:if> <c:if test="${list.uaotype==1}">
																	:${list.schemename}
																</c:if> <c:if test="${list.uaotype==2}">
																	:${list.stage}
																</c:if> <c:if test="${list.uaotype==3}">
																	:${list.pname}
																</c:if>
															</td>
															<td class="uanum " align="justify">
																<div id="${list.uaid}" class="star-vote">
																	<span class="add-star"></span> <span
																		class="del-star${list.uanum}"></span>
																</div>
															</td>
															<td class="uadate" align="justify">${list.uadate}</td>

														</tr>
														<tr>
															<td colspan='10'><c:set var="ualabels"
																	value="${list.ualabels}" /> <c:forEach var="label"
																	items="${fn:split(fn:replace(fn:replace(ualabels,']',''),'[',''),',')}">
																	<%-- <td class="success"  >${label}</td> --%>
																	<span class="label label-sm label-success"
																		style="font-size: 13px">${label}</span>
																</c:forEach></td>

														</tr>
														<tr>
															<td class="uainfo info" colspan='10'>评论内容:${list.uainfo}</td>
														</tr>
														<tr>
															<td class="active" colspan='10'></td>
														</tr>
													</c:forEach>
												</shiro:hasPermission>
												<shiro:lacksPermission name="user:show">
													<td colspan="100">对不起，您无权限查看！</td>
												</shiro:lacksPermission>
											</tbody>
										</table>
									</div>
								</div>
								<!-- /.span -->
							</div>
							<!-- /.row -->

							<%--分页--%>
							<div id="pagebottom" class="row">
								<div class="col-xs-12 col-md-6">
									当前第${list.pageNum}页，共${list.pages}页，共${list.total}条记录</div>
								<div class="col-xs-12 col-md-6">
									<nav aria-lable="Page navigation">
										<ul class="pagination">
											<c:choose>
												<c:when test="${list.hasPreviousPage}">
													<li><a
														href="${path}/user/list?pageNum=1&uaoid=${response.uaoid}&uaotype=${response.uaotype}">首页</a></li>
													<li><a
														href="${path}/user/list?pageNum=${list.pageNum-1}&uaoid=${response.uaoid}&uaotype=${response.uaotype}"
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
														href="${path}/user/list?pageNum=${page}&uaoid=${response.uaoid}&uaotype=${response.uaotype}">${page}</a></li>
												</c:if>
												<c:if test="${page!=list.pageNum}">
													<li><a
														href="${path }/user/list?pageNum=${page}&uaoid=${response.uaoid}&uaotype=${response.uaotype}">${page}</a></li>
												</c:if>
											</c:forEach>

											<c:choose>
												<c:when test="${list.hasNextPage }">
													<li><a
														href="${path }/user/list?pageNum=${list.pageNum+1 }&uaoid=${response.uaoid}&uaotype=${response.uaotype}"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
													<li><a
														href="${path }/user/list?pageNum=${list.pages}&uaoid=${response.uaoid}&uaotype=${response.uaotype}">末页</a></li>
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
												data-dismiss="modal">取消</button>
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
		<%@include file="../common/footer.jsp"%>

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- 基本脚本 -->
	<%@include file="../common/basic-scripts.jsp"%>

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
	<%@include file="../common/ace-scripts.jsp"%>



	<!-- 与此页相关的内联脚本 -->
	<script src="${path}/assets/custom-js/userAssess-list.js"></script>


</body>


</html>
