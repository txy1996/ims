<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>编辑商品</title>
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



<link href="${path}/assets/css/bootstrap.min.css" rel="stylesheet">
<!-- 这里是本页内联样式开始 -->
<!-- 这里是本页内联样式结束 -->
<%@include file="../common/assets-js.jsp"%>
</head>
<style>
.div-input-spacing {
	margin: 20px 0 0 0;
}

.inputcommodity {
	width: 50%;
	height: auto;
}

.container {
	height: 50px;
	position: relative;
	margin: 0 auto;
}

.nav {
	position: absolute;
	width: 100%;
	top: 100%;
	z-index: 9999;
	overflow-y: auto;
	overflow-x: auto;
	height: 250px;
}
</style>


<body class="no-skin">

	<%--top导航栏--%>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			
		</script>

		<%--main-content内容--%>
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="page-header">
						<h1>
							编辑商品 <small> <i class="ace-icon fa fa-angle-double-right"></i>
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-xs-12">
									<form class="product-update-from" enctype="multipart/form-data">
										<div class="form-group">
											<div class=" input-group input-group-sm col-xs-4">
												<span class="input-group-addon label-success"
													id="basic-addon1">所属商户:</span> <input type="hidden"
													value="${shop.sid}" id="sid" name="sid"> <input
													type="hidden" value="${response.cid}" id="pcid" name="cid">
												<input type="hidden" value="${response.id}" id="id"
													name="id">
												<h4>&nbsp;&nbsp;&nbsp;&nbsp;${shop.sname}</h4>
											</div>
										</div>
										<div class="form-group">
											<div class=" input-group input-group-sm col-xs-4"
												style="float: left; margin: 0 150px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon1">名称</span> <input type="text"
													class="form-control inputcommodity" name="pname"
													value="${response.pname}">
											</div>
											<div class=" input-group input-group-sm col-xs-4"
												style="float: left; margin: 0 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon2">广告词</span> <input type="text"
													class="form-control inputcommodity" name="psad"
													value="${response.psad}" aria-describedby="basic-addon1">
											</div>
										</div>
										<div class="form-group ">
											<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 150px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon3">图片</span> <input type="text"
													class="form-control inputcommodity" name="imgname"
													value="${response.imgname}" aria-describedby="basic-addon1"
													id="photoCover"> <input type="hidden"
													value="${response.url}" id="url" name="url" class="url">
												<input type="hidden" value="${response.imgid}" id="imgid"
													name="imgid" class="imgid"> <span
													class="input-group-btn"> <input id="lefile"
													type="file" style="display: none" name="file">
													<button class="btn btn-primary" type="button"
														onclick="$('input[id=lefile]').click();">选择</button>
												</span>
											</div>

											<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon4">状态</span> <select id="state"
													name="state" style="width: 100%;">
													<option value="0">未上架</option>
													<option value="1">上架</option>
													<option value="2">下架</option>
													<option value="3">已售罄</option>
												</select>

											</div>
										</div>

										<div class="form-group ">
											<div class=" input-group input-group-sm col-xs-4"
												style="float: left; margin: 25px 150px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon1">面积</span> <input type="text"
													class="form-control inputcommodity" name="sparefieldone"
													value="${response.sparefieldone}" aria-describedby="basic-addon1">
											</div>

											<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon4">适用人数</span> <input type="text"
													class="form-control inputcommodity" name="ptitle"
													value="${response.ptitle}" aria-describedby="basic-addon1">

											</div>
										</div>

										<div class="form-group ">
											<div class=" input-group input-group-sm col-xs-4"
												style="float: left; margin: 25px 150px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon1">全天价格</span> <input type="text"
													class="form-control inputcommodity" name="price"
													value="${response.price}" placeholder="请输入商品原价..."
													aria-describedby="basic-addon1">
											</div>

											<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon4">半天价格</span> <input type="text"
													class="form-control inputcommodity" name="yprice"
													value="${response.yprice}" placeholder="请输入商品优惠价..."
													aria-describedby="basic-addon1">

											</div>
										</div>

										<div class="form-group ">
											<div class=" input-group input-group-sm col-xs-4 container"
												style="float: left; margin: 25px 800px 0 0;">
												<label for="exampleInputEmail1">所属分类:</label> <input
													type="hidden" value="${response.cid}" id="cid" name="cid"
													class="cid"> <input type="text"
													id="txt_departmentname" name="txt_departmentname"
													class="form-control" value=""
													onclick="$('#treeview').show()" placeholder="分类名称">
												<div class="nav" id="treeview" style="display: none;"></div>

											</div>
										</div>


										<div class="form-group ">
											<input type="hidden" class="form-control" id="property"
													value="${response.property}" name="property">
											<div class=" input-group input-group-sm col-xs-10 property"
												id="selectproperty">
												<h5>商品属性:</h5>
												
											</div>
										</div>

										<div class="form-group ">

											<div class=" input-group col-xs-10"
												style="float: left; margin: 25px 0 0 0;">

												<button type="button" class="btn btn-info "
													style="float: left; width: 800px;" disabled="disabled">商品详情:</button>

												<div id="myEditor" name="info"
													style="float: left; margin: 15px 0px 0 0; width: 800px; height: 240px;"></div>
											</div>
										</div>

										<div style="float: right; margin: 20px 150px 0 0;">
											<button type="button" class="btn btn-default">取消</button>
											<button type="button" class="btn btn-primary"
												onclick="updateProduct()">提交</button>
										</div>
									</form>
								</div>
								<!-- /.span -->
							</div>
							<!-- /.row -->



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
	<script src="${path}/assets/js/bootstrap-treeview.js"></script>
	<script
		src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
	<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
	<script type="text/javascript" src="${path}/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="${path}/ueditor/ueditor.all.js"></script>
<!-- 	<script type="text/javascript" charset="utf-8"
		src="lang/zh-cn/zh-cn.js"></script>
 -->
	<!-- ace脚本 -->
	<%@include file="../common/ace-scripts.jsp"%>
	<!-- 与此页相关的内联脚本 -->
	<script src="${path}/assets/custom-js/product/update-4.js"></script>
	<script type="text/javascript">
		
	</script>
</body>

</html>
