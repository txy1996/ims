<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>积分金币操作项管理</title>
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
		</script>

		<%--main-content内容--%>
		<div class="main-content">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state breadcrumbs-fixed"
					id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">用户管理</a>
						</li>
						<li class="active">积分金币操作项列表</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							积分金币管理 <small> <i
								class="ace-icon fa fa-angle-double-right"></i> <span id="amount">共${list.total}个操作项&emsp;</span>
								<button type="button"
									class="btn btn-primary btn-xs show-add-form"
									data-toggle="modal" data-target="#user-form-div">添加操作项
								</button>
								<button type="button"
									class="btn btn-primary btn-xs update-item">更新
								</button>
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<div class="user-search ">
						<button type="button" disabled="disabled"
							class="btn btn-primary btn-xs"
							style="height: 35px; margin-bottom: 4px;">搜索</button>
						<select id="igori" name="igori" style="height: 35px;">
							<option value="">请选择</option>
							<option value="1">金币</option>
							<option value="0">积分</option>
						</select> <input type="text" name="inameinput" id="inameinput"
							placeholder="请输入..." />
						<button style="height: 35px;"
							class="btn btn-success btn-xs  search-query">查询</button>

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
														type="checkbox" class="ace select-all-btn" /> <span
														class="lbl"></span>
												</label></th>
												<th><i class="fa fa-id-card bigger-110 hidden-480"></i>ID</th>
												<th><i class="fa fa-user bigger-110 hidden-480"></i>项目名字</th>
												<th><i
													class="fa fa-user-circle-o bigger-110 hidden-480"></i>操作分值</th>
												<th><i
													class="fa fa-user-circle-o bigger-110 hidden-480"></i>类型</th>

												<th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
											</tr>
										</thead>

										<tbody class="user-tbody">

											<c:forEach items="${list.list}" var="list">
												<tr>
													<td class="center"><label class="pos-rel"> <input
															type="checkbox" class="ace" name="id" value="${list.id}" />
															<span class="lbl"></span>
													</label></td>
													<td class="id">${list.id}</td>
													<td class="iname">${list.iname}</td>
													<td class="inum">${list.inum}</td>
													<td class="igori"><c:if test="${empty list.igori}">
															<span class="label label-sm label-primary">-</span>
														</c:if> <c:if test="${list.igori==0}">
															<input type="hidden" name="igorinum" value="0">
															<span class="label label-sm label-warning">积分</span>
														</c:if> <c:if test="${list.igori==1}">
															<input type="hidden" name="igorinum" value="1">
															<span class="label label-sm label-success">金币</span>
														</c:if></td>
													<td>
														<div class="hidden-sm hidden-xs btn-group">
															<button class="btn btn-xs btn-info show-update-form"
																data-toggle="modal" data-target="#user-form-div">
																<i class="ace-icon fa  bigger-120 ">修改</i>
															</button>
															<button class="btn btn-xs btn-info show-delete-form">
																<i class="ace-icon fa  bigger-120">删除</i>
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
									当前第${list.pageNum}页，共${list.pages}页，共${list.total}条记录</div>
								<div class="col-xs-12 col-md-6">
									<nav aria-lable="Page navigation">
										<ul class="pagination">
											<c:choose>
												<c:when test="${list.hasPreviousPage}">
													<li><a href="${path}/giitem/list?pageNum=1">首页</a></li>
													<li><a
														href="${path}/giitem/list?pageNum=${list.pageNum-1}"
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
														href="${path}/giitem/list?pageNum=${page}">${page}</a></li>
												</c:if>
												<c:if test="${page!=list.pageNum}">
													<li><a href="${path }/giitem/list?pageNum=${page}">${page}</a></li>
												</c:if>
											</c:forEach>

											<c:choose>
												<c:when test="${list.hasNextPage }">
													<li><a
														href="${path }/giitem/list?pageNum=${list.pageNum+1 }"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
													<li><a
														href="${path }/giitem/list?pageNum=${list.pages}">末页</a></li>
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
												<div class="form-group">
													<input type="hidden" id="id" name="id"> <label
														for="recipient-name" class="control-label">项目名称:</label> <input
														type="text" class="form-control" id="iname" name="iname">
												</div>
												<div class="form-group">
													<label for="recipient-name" class="control-label">操作分值:</label>
													<input type="text" class="form-control" id="inum"
														name="inum">
												</div>
												<div class="form-group">
													<label for="message-text" class="control-label">操作类型:</label>
													<select id="igori" name="igori" class="igori"
														style="height: 35px; width: 100%;">
														<option>请选择</option>
														<option value="1">金币</option>
														<option value="0">积分</option>
													</select>
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






							<div class="modal fade" id="" tabindex="-1" role="dialog"
								aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel">添加操作项</h4>
										</div>
										<form id="item-form" name="item-form" class="item-form">
											<div class="modal-body">
												<div class="form-group">
													<label for="recipient-name" class="control-label">项目名称:</label>
													<input type="text" class="form-control" id="iname"
														name="iname">
												</div>
												<div class="form-group">
													<label for="recipient-name" class="control-label">操作分值:</label>
													<input type="text" class="form-control" id="inum"
														name="inum">
												</div>
												<div class="form-group">
													<label for="message-text" class="control-label">操作类型:</label>
													<select id="igori" name="igori"
														style="height: 35px; width: 100%;">
														<option>请选择</option>
														<option value="1">金币</option>
														<option value="0">积分</option>
													</select>
												</div>
											</div>
										</form>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="button" class="btn btn-primary item-submit"
												data-dismiss="modal">提交</button>
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
												data-dismiss="modal">取消</button>
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
	<script src="${path}/assets/custom-js/integra/goog_integration_item.js"></script>



</body>


</html>
