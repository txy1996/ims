<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>新增商品</title>
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




<body class="no-skin" onload="load(${pcid})">

	<%--top导航栏--%>

	<div class="main-container ace-save-state " id="main-container">
		<script type="text/javascript">
			
		</script>

		<%--main-content内容--%>
		<div class="main-content ">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="page-header">
						<h1>
							添加商品 <small> <i class="ace-icon fa fa-angle-double-right"></i>
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-xs-12">
									<form class="product-add-from" name="product-add-from" enctype="multipart/form-data">
										<div class="form-group">
											<div class=" input-group input-group-sm col-xs-4">
												<span class="input-group-addon label-success"
													id="basic-addon1">所属商户:</span> <input type="hidden"
													value="${shop.sid}" id="sid" name="sid"> <input
													type="hidden" value="" id="pcid" name="cid">
												<h4>&nbsp;&nbsp;&nbsp;&nbsp;${shop.sname}</h4>
											</div>
										</div>
										<div class="form-group">
											<div class=" input-group input-group-sm col-xs-4"
												style="float: left; margin: 0 150px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon1">名称</span> <input type="text"
													class="form-control inputcommodity" name="pname"
													placeholder="请输入名称..." aria-describedby="basic-addon1">
											</div>
											<!-- <div class=" input-group input-group-sm col-xs-4"
												style="float: left; margin: 0 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon2">商品编码</span> <input type="text"
													class="form-control inputcommodity" name="pcode"
													placeholder="请输入商品编码..." aria-describedby="basic-addon1">
											</div> -->
										</div>
										<div class="form-group ">
											<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 150px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon3">图片</span> <input type="text"
													class="form-control inputcommodity" name="imgname"
													placeholder="请选择图片..." aria-describedby="basic-addon1"
													id="photoCover"> <span class="input-group-btn">
													<input id="lefile" type="file" style="display: none"
													name="file">
													<button class="btn btn-primary" type="button"
														onclick="$('input[id=lefile]').click();">选择</button>
												</span>
											</div>

											<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon4">状态</span> <select id="user"
													name="state" style="width: 100%;">
													<option value="0">未上架</option>
													<option value="1">上架</option>
													<option value="2">下架</option>
													<option value="3">已售罄</option>
												</select>
											</div>
										</div>

										<div class="form-group ">
											<!-- <div class=" input-group input-group-sm col-xs-4"
												style="float: left; margin: 25px 150px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon1">商品库存</span> <input type="text"
													class="form-control inputcommodity" name="stock"
													placeholder="请输入商品库存..." aria-describedby="basic-addon1">
											</div> -->

											<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon4">适用对象</span> <input type="text"
													class="form-control inputcommodity" name="sparefieldone"
													placeholder="请输入适用人群..." aria-describedby="basic-addon1">

											</div>
										</div>

										<div class="form-group ">
										<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon4">适用人数</span> <input type="text"
													class="form-control inputcommodity" name="ptitle"
													placeholder="请输入最大人数，如100..." aria-describedby="basic-addon1">

											</div>
											
											<div class=" input-group input-group-sm col-xs-4"
												style="float: left; margin: 25px 150px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon1">价格</span> <input type="text"
													class="form-control inputcommodity" name="price"
													placeholder="请输入价格..." aria-describedby="basic-addon1">
											</div>

											<div class=" input-group input-group-sm col-xs-4 "
												style="float: left; margin: 25px 180px 0 0;">
												<span class="input-group-addon label-success"
													id="basic-addon4">推荐理由</span> <input type="text"
													class="form-control inputcommodity" name="psad"
													placeholder="请输入商品推荐理由..." aria-describedby="basic-addon1">

											</div>
											
											<div 
												style="float: left; margin: 25px 180px 0 0; width:20px"  id="tyxs">
												<span class="input-group-addon label-success"
													id="basic-addon4">体验形式（如果课程没有，可不填）</span>
													<input type="hidden" name="sparefieldtwo" id="sparefieldtwo" />
													<div>
													<input type="text" name="mytext[]" id="field_1" /><a href="#" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="removeclass"><input type='button' style="float: left;margin: -28px 0 1px 200px;" value='删除'></a></span></p></div>	
													</div>
													<div style="float: left; margin: 55px 180px 40px 50px;"><a href="#" rel="external nofollow" rel="external nofollow" rel="external nofollow" id="AddMoreFileBox" class="btn btn-info1">+</a></div>
											</div>
										</div>

										<div class="form-group">
											<div class=" input-group input-group-sm col-xs-4 container"
												style="float: left; margin: 25px 800px 0 0;">
												<label for="exampleInputEmail1">所属分类:</label> <input
													type="hidden" value="" id="cid" name="cid" class="cid">
												<input type="text"  value="${pcname}" disabled="disabled">

												<div class="nav" id="treeview" style="display: none;"></div>

											</div>
										</div>

										<div class="form-group ">
											<input type="hidden" class="form-control" id="property"
												name="property">
											<div class=" input-group input-group-sm col-xs-10 property"
												id="selectproperty">

												<h5>商品属性:</h5>
											</div>
										</div>
										<div style="display: none;color:#F00" id="123">暂无属性</div>
										<div class="form-group ">
										<input type="hidden"  name = "info" id="info"/>
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
												onclick="addProduct()">提交</button>
										</div>
									</form>
								</div>
								<!-- /.span -->
							</div>
							<!-- /.row -->





							<!-- <div class="modal fade" id="property" tabindex="-1" role="dialog"
								aria-labelledby="myproperty" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myproperty">商品属性</h4>
										</div>
										<div class="modal-body" id="selectproperty"></div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="button" class="btn btn-primary"
												data-dismiss="modal" onclick="show()">提交</button>
										</div>
									</div>
									/.modal-content
								</div>
								/.modal
							</div> -->

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
	<!-- <script type="text/javascript" charset="utf-8"
		src="lang/zh-cn/zh-cn.js"></script> -->

	<!-- ace脚本 -->
	<%@include file="../common/ace-scripts.jsp"%>
	<!-- 与此页相关的内联脚本 -->
	<script type="text/javascript">
		var ue = UE.getEditor('myEditor');

		$('input[id=lefile]').change(function() {
			$('#photoCover').val($(this).val());
		});
		
		function addProduct() {
			console.log(ue.getContent())
			var ff = '';
			$("#tyxs input[type='text']").each(function(){
			    ff = ff + $(this).val()+"|"
			  });
			ff = ff.substr(0, ff.length - 1);
			$("#sparefieldtwo").val(ff)
			console.log($("#sparefieldtwo").val())
			$("#info").val(ue.getContent())
			debugger
			$.ajax({
				url : "${path}/product/addProductAddRequest",
				type : "POST",
				data : new FormData($('.product-add-from')[0]),
				processData : false,
				contentType : false,
				success : function(data) {
					var sid = $("#sid").val()
					var url = encodeURI("../product/selectProduct?sid=" + sid + "")
					window.location.href = url;
				},
				error : function() {
					alert("添加失败!");
				}
			});
		}
		
		
		
		// 刷新属性
		function load(pcid) {

			$("#pcid").val(pcid)
			$
					.ajax({
						url : "${path}/property/selectBypcid",
						dataType : "json",// 特别重要
						data : {
							pcid : pcid
						},
						type : "POST",
						success : function(data) {
							if(data.length==0){
								document.getElementById('123').style.display='block';
							}else{
								var tem = "<h5>商品属性:</h5>";
								for (var i = 0; i < data.length; i++) {
									var propertyvalue = data[i].propertyvalue.split('|')
									tem += "<div class=' input-group input-group-sm col-xs-3 property-div '"
											+ "style='float: left; margin: 20px 20px 0 0;'> "
											+ "<span class='input-group-addon ' >"
											+ data[i].name
											+ "</span> "
											+ "<select class='property-select'  style='width: 100%;'> ";
									if (propertyvalue.length > 0) {
										tem += "<option  propertyid=" + data[i].id
												+ "'>请选择</option>"
										for (var z = 0; z < propertyvalue.length; z++) {
											tem += "<option value='" + propertyvalue[z]
													+ "' propertyid='" + data[i].id + "'>"
													+ propertyvalue[z] + "</option> ";

										}
									}
									tem += "</select> " + "</div>";

								}

								$("#selectproperty").html(tem)
							}							
						},
						error : function() {

						}
					});

		}
		
		
		$(".property").on(
				"change",
				" .property-div .property-select",
				function() {
					var propertyvalue = $(this).val();
					var id = $(this).find("option:selected").attr("propertyid");
					var tem = id + ":" + propertyvalue;
					var flag = true;
					var property = $("#property").val();
					console.log(property)
					if (property.trim() != "") {
						property = property.substring(property.indexOf('[')+1, property
								.indexOf(']'));
						var arr = property.split(',');
						if (arr.length > 0) {
							for (var i = 0; i < arr.length; i++) {
								var p = arr[i].split(':');
								if (p[0] == id) {
                                    if(propertyvalue.trim()!="请选择"){
                                        arr[i] = tem;
                                        flag = false;
                                    }else {
                                        arr.splice(i, 1);
                                        flag = false;
                                    }
								}
							}
                            property = arr;
                            if (flag) {
                                property += "," + tem;
                                property=property.split(',');
                                if(property[0]==""){
                                    property.shift();
                                }
                            }
						}

					} else {
						property +=tem;
					}
					$("#property").val("["+property+"]");
				});
		
		
		var MaxInputs    = 8; //maximum input boxes allowed
		var InputsWrapper  = $("#tyxs"); //Input boxes wrapper ID
		var AddButton    = $("#AddMoreFileBox"); //Add button ID
		var x = InputsWrapper.length; //initlal text box count
		var FieldCount=1; //to keep track of text box added
		$(AddButton).click(function (e) //on add input button click
				{
				    if(x <= MaxInputs) //max input box allowed
				    {
				      FieldCount++; //text box added increment
				      //add input box
				      $(InputsWrapper).append('<div><input type="text" name="mytext[]" id="field_'+ FieldCount +'"/><a href="#" rel="external nofollow" rel="external nofollow" rel="external nofollow" class="removeclass"><input type="button" style="float: left;margin: -28px 1px 1px 200px;" value="删除"></a></div>');
				      x++; //text box increment
				    }
				return false;
				});
				$("body").on("click",".removeclass", function(e){ //user click on remove text
				    if( x > 1 ) {
				        $(this).parent('div').remove(); //remove text box
				        x--; //decrement textbox
				    }
				return false;
				});

						

	</script>
</body>

</html>
