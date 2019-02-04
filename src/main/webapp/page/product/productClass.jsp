<%@page import="com.pydyun.ims.model.Property"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>商品分类管理</title>
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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">分类管理</a>
						</li>
						<li class="active">分类列表</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							分类管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								共${list.total}个&emsp; <shiro:hasPermission
									name="productclass:add">
									<button type="button"
										class="btn btn-primary btn-xs show-add-form"
										data-toggle="modal" data-target="#user-form-div">新增分类根节点
									</button>
								</shiro:hasPermission>
							</small>
						</h1>
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
												<!--  <th><i class="fa  bigger-110 hidden-480"></i>所属分类</th> -->
												<th><i class="fa  bigger-110 hidden-480"></i>ID</th>
												<th><i class="fa  bigger-110 hidden-480"></i>类别描述</th>
												<th><i class="fa  bigger-110 hidden-480"></i>父级类别</th>
												<th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
											</tr>
										</thead>

										<tbody class="user-tbody" id="222">
											<shiro:hasPermission name="productclass:list">
												<c:forEach items="${list.list}" var="list">
													<tr>

														<td class="id" id="id1">${list.id}</td>
														<%-- <td class="scscid">${list.shop.sname}</td> --%>
														<td class="text">${list.text}</td>
														<td class="ccname">${list.ccname}</td>
														<td>
															<div class="hidden-sm hidden-xs btn-group">
																<shiro:hasPermission name="productclass:add">
																	<button type="button"
																		class="btn btn-primary btn-xs show-add-form"
																		data-toggle="modal" data-target="#exampleModal"
																		data-whatever="${list.id}">
																		新增分类</button>
																</shiro:hasPermission>
																	<button type="button"
																		class="btn btn-primary btn-xs show-add-form" onclick="dele(${list.id})">删除分类</button>
															</div>
																	
															<div class="hidden-sm hidden-xs btn-group">
																<shiro:hasPermission name="productclass:select">
																	<%-- <input type="button" class="btn btn-primary btn-xs show-add-form" data-toggle="modal" data-targe="#exampleModal1" onclick="value1(${list.id})" value="属性"/> --%>
																	<button type="button"
																		class="btn btn-primary btn-xs show-add-form"
																		data-toggle="modal" data-target="#exampleModal1"
																		data-whatever="${list.id}" data-html="true"
																		data-content="1234">
																		属性</button>
																</shiro:hasPermission>

															</div>
														</td>
													</tr>
												</c:forEach>
											</shiro:hasPermission>
											<%-- <shiro:lacksPermission name="productclass:show">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission> --%>
										</tbody>
									</table>
										<div style="display: none;margin-left:45%;color:red;" id="what">暂无数据</div>								
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
													<li><a href="${path}/productclass/list?pageNum=1">首页</a></li>
													<li><a
														href="${path}/productclass/list?pageNum=${list.pageNum-1}"
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
														href="${path}/productclass/list?pageNum=${page}">${page}</a></li>
												</c:if>
												<c:if test="${page!=list.pageNum}">
													<li><a
														href="${path }/productclass/list?pageNum=${page}">${page}</a></li>
												</c:if>
											</c:forEach>

											<c:choose>
												<c:when test="${list.hasNextPage }">
													<li><a
														href="${path }/productclass/list?pageNum=${list.pageNum+1 }"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
													<li><a
														href="${path }/productclass/list?pageNum=${list.pages}">末页</a></li>
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
															<label for="form-add-realName" style="display: none">商品分类ID
																<input type="text" id="id" name="id" />
															</label> <label for="form-add-realName">类别描述<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-realName" name="text"
																	placeholder="类别描述" />
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
												class="btn btn-sm btn-primary user-submit"></button>
										</div>
									</div>

								</div>
							</div>



							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">×</span>
											</button>
											<h3 class="blue bigger user-form-title" id="myModalLabel">新增分类</h3>
										</div>
										<div class="modal-body">
											<form id="for" class="for" name="for">
												<div class="form-group" style="display: none">
													<label for="recipient-name" class="control-label">商品分类id:</label>
													<input type="text" class="form-control" id="id" name="id"
														readonly unselectable="on">
												</div>
												<div class="form-group">
													<label for="recipient-name" class="control-label">商品父级分类:</label>
													<input type="text" class="form-control" id="ccname1" name="ccname1"
														readonly unselectable="on">
												</div>
												<div class="form-group">
													<label for="recipient-name" class="control-label">请选择商品模板:</label>
													<!-- <input type="text" class="form-control" id="ccname1" name="ccname1"
														readonly unselectable="on"> -->
														<select id="templet_list" name="templet_list">
															<option></option>
														</select>
												</div>
												<!-- <div class="form-group">
													<label for="recipient-name" class="control-label">商品详情模板:</label>
													<select id="templet_product">
															<option></option>
														</select>
												</div> -->
												<div class="form-group">
													<label for="message-text" class="control-label">分类描述:</label>
													<textarea class="form-control" id="text" name="text"></textarea>
												</div>
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">取消</button>
											<button type="button" class="btn btn-primary save"
												data-dismiss="modal">确定</button>
										</div>

									</div>
								</div>
							</div>



							<div class="modal fade" id="exampleModal1" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">×</span>
											</button>
											<h4 class="blue bigger user-form-title" id="myModalLabel1"></h4>
										</div>

										<div class="modal-body">
											<form id="for1" class="for1" name="for1">
												<input type="hidden" name="inp" id="inp" /> 已有属性
												<table class="table  table-bordered table-hover user-list"
													id="table">
													<thead>
														<tr>
															<!--  <th><i class="fa  bigger-110 hidden-480"></i>所属分类</th> -->
															<th><i class="fa  bigger-110 hidden-480"></i>属性名</th>
															<th><i class="fa  bigger-110 hidden-480"></i>属性值</th>
															<th><i
																class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
														</tr>
													</thead>
													<tbody id="333">

														<shiro:hasPermission name="productclass:list">
															<%-- <c:forEach items="${playList }" var="list1"> --%>
															<tr>
																<td class="name" id="name1"></td>
																<td class="propertyvalue" id="propertyvalue1"></td>
																<td id="ref"></td>
															</tr>
														</shiro:hasPermission>

														<%-- <shiro:lacksPermission name="productclass:show">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission> --%>
													</tbody>

												</table>
												
											</form>
											<div style="display: none;margin-left:45%;color:red;" id="what">暂无数据</div>
											<div>
												<form class="for2" id="for2" name="for2">
													<span>选择已有属性：</span><br> <input type="text"
														id="sorpname" name="sorpname" list="wlmslist"
														value="${model.sorpname}" placeholder=""
														onChange="getCategory()" />
													<datalist id="wlmslist">
													</datalist>
													
														<br><button type="button" data-toggle="modal"
														data-target="#myModal2">添加其他属性</button>
												</form>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<!-- <button type="button" class="btn btn-primary save1"
												data-dismiss="modal">确定</button> -->
										</div>

									</div>
								</div>
							</div>

							<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
											</button>
											<h4 class="blue bigger user-form-title" id="myModalLabel123"></h4>
										</div>
										<div class="modal-body">
											<form action="">
												属性名:<input type="text" id="fname" name="fname" /><br>
												<br> 属性值:<input type="text" id="fpropertyvalue" />
												<div class="modal-footer">
													<button type="button" class="btn btn-default"
														data-dismiss="modal">取消</button>
													<button type="button" class="btn btn-primary"
														data-dismiss="modal" onclick="showRegist()">确定</button>
												</div>
											</form>
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
	<script src="${path}/assets/custom-js/productclass.js"></script>

</body>
<script>
var tableObj = document.getElementById('222').rows[0];
if (tableObj == null) {
	document.getElementById("what").style.display="";
}

/* $('#op-tips-dialog').on('hidden.bs.modal', function () { 
	document.getElementsByTagName('body')[0].className = 'modal-open'; 
	});  */
</script>
</html>
