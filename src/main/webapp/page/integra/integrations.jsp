<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>用户积分</title>
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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">积分列表</a>
						</li>
						<li class="active">积分列表</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							积分列表 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								共${list.total}个&emsp; <shiro:hasPermission name="integral:add">
									<button id="addintegrations" type="button"
										style="display: none;"
										class="btn btn-primary btn-xs show-add-form"
										data-toggle="modal" data-target="#user-form-div">添加积分
									</button>
								</shiro:hasPermission>
							</small>
						</h1>
					</div>
					<!-- /.page-header -->




					<div class="integral-user-filter ">
						<button type="button" disabled="disabled"
							class="btn btn-primary btn-xs"
							style="height: 35px; margin-bottom: 4px;">起止时间</button>
						<input type="date" id="starttime" placeholder="请输入开始时间" /> 到 <input
							type="date" id="endtime" placeholder="请输入结束时间" />
						<button style="height: 35px;"
							class="btn btn-success btn-xs  user-filter">查询</button>


						<button disabled="disabled"
							style="margin-left: 160px; margin-bottom: 4px; height: 35px;"
							class="btn btn-primary btn-xs">筛选</button>
						<select id="selectintegral" style="height: 35px;">
							<option>请选择...</option>
							<c:forEach items="${googAndIntegration}" var="item">
								<option value="${item.iname} ">${item.iname}</option>
							</c:forEach>
						</select>
						<!-- <button id="serch" style="height: 35px;"
							class="btn btn-success btn-xs  search-query">查询</button>
					</div> -->


						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-xs-12">
										<table id="simple-table"
											class="table  table-bordered table-hover user-list">
											<thead>
												<tr>
													<th><i class="fa  bigger-110 hidden-480"></i>用户名</th>
													<th><i class="fa  bigger-110 hidden-480"></i>获得时间</th>
													<th><i class="fa  bigger-110 hidden-480"></i>获得积分原因</th>
													<th><i class="fa  bigger-110 hidden-480"></i>本次获得分值</th>
													<th><i class="fa  bigger-110 hidden-480"></i>积分总额</th>

												</tr>
											</thead>

											<tbody class="user-tbody">
												<shiro:hasPermission name="integral:list">
													<c:forEach items="${list.list}" var="list">
														<tr>
															<td style="display: none;" class="iid">${list.iid}</td>
															<td class="urfname">${list.sys_user.username}</td>
															<td class="igetdate">${list.igetdate}</td>
															<td class="igetinfo">${list.igetinfo}</td>
															<td class="igetnum">${list.igetnum}</td>
															<td class="isum">${list.isum}</td>


														</tr>
													</c:forEach>
												</shiro:hasPermission>

											</tbody>
										</table>
									</div>
									<!-- /.span -->
								</div>
								<!-- /.row -->

								<%--分页--%>
								<div class="row">
									<div class="col-xs-12 col-md-6">
										当前第${list.pageNum}页，共${list.pages}页，共${list.total}条记录</div>
									<div class="col-xs-12 col-md-6">
										<nav aria-lable="Page navigation">
											<ul class="pagination">
												<c:choose>
													<c:when test="${list.hasPreviousPage}">
														<li><a
															href="${path}/integral/list?pageNum=1&urid=${request.urid}&username=${request.username}">首页</a></li>
														<li><a
															href="${path}/integral/list?pageNum=${list.pageNum-1}&urid=${request.urid}&username=${request.username}"
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
															href="${path}/integral/list?pageNum=${page}&urid=${request.urid}&username=${request.username}">${page}</a></li>
													</c:if>
													<c:if test="${page!=list.pageNum}">
														<li><a
															href="${path }/integral/list?pageNum=${page}&urid=${request.urid}&username=${request.username}">${page}</a></li>
													</c:if>
												</c:forEach>

												<c:choose>
													<c:when test="${list.hasNextPage }">
														<li><a
															href="${path }/integral/list?pageNum=${list.pageNum+1 }&urid=${request.urid}&username=${request.username}"
															aria-label="Next"> <span aria-hidden="true">&raquo;</span>
														</a></li>
														<li><a
															href="${path }/integral/list?pageNum=${list.pages}&urid=${request.urid}&username=${request.username}">末页</a></li>
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
															<div class="form-group">

																<input type="hidden" id="urid" value="${request.urid}">
																<label for="form-add-password">被操作对象<span
																	style="color: #F00">*</span></label>
																<div>
																	<input type="hidden" id="username"
																		value="${request.username}">
																	<h4>${request.username}</h4>
																</div>

																<label for="form-add-bname">操作项<span
																	style="color: #F00">*</span></label>
																<div>
																	<input type="text" id="operating" list="ide"
																		onchange="inputSelect()" placeholder="操作项" />
																	<datalist id="ide">
																		<c:forEach items="${googAndIntegration}" var="item">
																			<c:choose>
																				<c:when test="${item.inum>0}">
																					<option value="${item.iname}[+${item.inum} ] " />
																				</c:when>
																				<c:otherwise>
																					<option value="${item.iname}[${item.inum} ] " />
																				</c:otherwise>
																			</c:choose>
																		</c:forEach>
																	</datalist>
																</div>
																<label for="form-add-password">操作原因<span
																	style="color: #F00">*</span></label>
																<div>
																	<input type="text" id="igetinfo" name="igetinfo"
																		placeholder="操作原因" />
																</div>
															</div>
														</div>

													</div>
												</div>
											</form>
											<div class="modal-footer">
												<button class="btn btn-sm" data-dismiss="modal"
													type="submit">
													<i class="ace-icon fa fa-times"></i>取消
												</button>
												<button type="button"
													class="btn btn-sm btn-primary user-submit"></button>
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
	<script src="${path}/assets/custom-js/integra/integrations.js"></script>
</body>
</html>
