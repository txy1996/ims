<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>标签</title>
<%@include file="../common/meta.jsp"%>
<%@include file="../common/assets-css.jsp"%>

<!-- 页面特殊插件样式 -->
<link rel="stylesheet"
	href="${path}/assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet" 
	href="${path}/assets/css/chosen.min.css" />
<link rel="stylesheet"
	href="${path}/assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet"
	href="${path}/assets/css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" 
	href="${path}/assets/css/daterangepicker.min.css" />
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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">标签列表</a>
						</li>
						<li class="active">标签列表</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							标签列表 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								共${list.total}个&emsp; <shiro:hasPermission name="label:add">
									<button type="button"
										class="btn btn-primary btn-xs show-add-form"
										data-toggle="modal" data-target="#user-form-div">添加</button>
								</shiro:hasPermission>
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<div style="position: relative;">
			<div>
				<%-- <from action="list">
					<select name="sel" id="sel">
						<option value="">请选择分类</option>
						<c:forEach items="${list2}" var="list2">

							<option value="${list2.lcid}"
								<c:if test="${lcid eq list2.text}">selected="selected"</c:if>><c:if
									test="${list2==list2}"></c:if>${list2.text}
							</option>
						</c:forEach> 
						
					</select>
					
					
					<button type="button" class="btn btn-primary btn-xs show-add-form" onclick="sel()">搜索</button>
				</from> --%>

						<input type="text" id="txt_departmentname" style="width: 200px;display:inline"
							name="txt_departmentname" class="form-control" value=""
							onclick="$('#treeview').show()" placeholder="分类名称">
							<button type="button" class="btn btn-primary btn-xs show-add-form" onclick="sel()">搜索</button>
						<div id="treeview" style="display: none; width:200px;z-index:999;position: absolute;top:0;"></div>
						

					</div>
					<div class="row" >
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-xs-12">
									<table id="simple-table"
										class="table  table-bordered table-hover user-list">
										<thead>
											<tr>
												<th><i class="fa  bigger-110 hidden-480"></i>ID</th>
												<th><i class="fa  bigger-110 hidden-480"></i>标签</th>
												<th><i class="fa  bigger-110 hidden-480"></i>所属分类</th>
												<th><i class="fa  bigger-110 hidden-480"></i>方案应用数</th>
												<th><i class="fa  bigger-110 hidden-480"></i>阶段应用数</th>
												<th><i class="fa  bigger-110 hidden-480"></i>商户应用数</th>
												<th><i class="fa  bigger-110 hidden-480"></i>用户应用数</th>
												<th><i class="fa  bigger-110 hidden-480"></i>创建人</th>

												<th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
											</tr>
										</thead>

										<tbody class="user-tbody" id="222">
											<shiro:hasPermission name="label:list">
												<c:forEach items="${list.list}" var="list">
													<tr>
														<td class="lid">${list.lid}</td>						
														<td class="lcinfo"><input type="hidden" id="lcinfo11" value="${list.lcinfo}"/>${list.lcinfo}</td>
														<td class="text"><input type="hidden" id="text11" value="${list.labelclass.text}"/>${list.labelclass.text}</td>
														<td class="fanum">${list.fanum }</td>
														<td class="djnum">${list.jdnum }</td>
														<td class="shnum">${list.shnum }</td>
														<td class="yhnum">${list.yhnum }</td>
														<td class="cjren">${list.cjren }</td>
														<td>
															<div class="hidden-sm hidden-xs btn-group">
																<shiro:hasPermission name="label:update">
																	<button class="btn btn-xs btn-info show-update-form"
																		data-toggle="modal" data-target="#exampleModal" data-whatever="${list.lcinfo}">
																		<i class="ace-icon fa fa-pencil bigger-120"></i>
																	</button>
																</shiro:hasPermission>

																<shiro:hasPermission name="label:delete">
																	<c:if test="${list.lcinfo ne 'admin'}">
																	<input type="hidden" id="urid11" <c:if test="${not empty urid }">vlaue="${urid }"</c:if>/>
																		<button class="btn btn-xs btn-danger delete-this-user">
																			<i class="ace-icon fa fa-trash-o bigger-120"></i>
																		</button>
																	</c:if>
																</shiro:hasPermission>

																<shiro:lacksPermission name="label:update">
																	<shiro:lacksPermission name="label:delete">
																		<span
																			class="label label-large label-grey arrowed-in-right arrowed-in">
																			<i class="ace-icon fa fa-lock" title="无权限"></i>
																		</span>
																	</shiro:lacksPermission>
																</shiro:lacksPermission>

															</div>
															<div class="hidden-md hidden-lg">
																<div class="inline pos-rel">
																	<customTag:hasAnyPermissions
																		name="label:update,label:delete">
																		<button
																			class="btn btn-minier btn-primary dropdown-toggle"
																			data-toggle="dropdown" data-position="auto">
																			<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
																		</button>
																	</customTag:hasAnyPermissions>
																	<shiro:lacksPermission name="label:update">
																		<shiro:lacksPermission name="label:delete">
																			<span
																				class="label label-large label-grey arrowed-in-right arrowed-in">
																				<i class="ace-icon fa fa-lock" title="无权限"></i>
																			</span>
																		</shiro:lacksPermission>
																	</shiro:lacksPermission>

																	<ul
																		class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																		<shiro:hasPermission name="label:update">
																			<li><a href="javascript:void(0);"
																				class="tooltip-success show-update-form"
																				data-toggle="modal" data-target="#user-form-div"
																				data-rel="tooltip" title="更新用户"> <span
																					class="green"> <i
																						class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																				</span>
																			</a></li>
																		</shiro:hasPermission>

																		<shiro:hasPermission name="label:delete">
																			<c:if test="${list.lcinfo ne 'admin'}">
																				<li><a href="javascript:void(0);"
																					class="tooltip-error delete-this-user"
																					data-rel="tooltip" title="删除"> <span
																						class="red"> <i
																							class="ace-icon fa fa-trash-o bigger-120"></i>
																					</span>
																				</a></li>
																			</c:if>
																		</shiro:hasPermission>
																	</ul>
																</div>
															</div>
														</td>
													</tr>
												</c:forEach>
											</shiro:hasPermission>
											<%--  <shiro:lacksPermission name="label:show">
                                        <td colspan="100">对不起，您无权限查看！</td>
                                    </shiro:lacksPermission> --%>
										</tbody>
									</table>
									<div style="display: none;margin-left:45%;color:red;" id="what">暂无数据</div>
								</div>
								<!-- /.span -->
							</div>
							<!-- /.row -->
							</div>
							<%--分页--%>
							<div class="row">
								<div class="col-xs-12 col-md-6">
									当前第${list.pageNum}页，共${list.pages}页，共${list.total}条记录</div>
								<div class="col-xs-12 col-md-6">
									<nav aria-lable="Page navigation">
										<ul class="pagination">
											<c:choose>
												<c:when test="${list.hasPreviousPage}">
													<li><a href="${path}/label/list?pageNum=1">首页</a></li>
													<li><a
														href="${path}/label/list?pageNum=${list.pageNum-1}"
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
														href="${path}/label/list?pageNum=${page}">${page}</a></li>
												</c:if>
												<c:if test="${page!=list.pageNum}">
													<li><a href="${path }/label/list?pageNum=${page}">${page}</a></li>
												</c:if>
											</c:forEach>

											<c:choose>
												<c:when test="${list.hasNextPage }">
													<li><a
														href="${path }/label/list?pageNum=${list.pageNum+1 }"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
													<li><a
														href="${path }/label/list?pageNum=${list.pages}">末页</a></li>
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
											<h4 class="blue bigger user-form-title">新增标签</h4>
										</div>
										<form id="user-form" name="user-form" class="user-form">
											<div class="modal-body">
												<div class="row">
													<div class="col-xs-12 col-sm-6">
														<div class="form-group">
															<label for="form-add-lid" style="display: none">标签ID<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-lid" name="lid"
																	style="display: none" placeholder="标签ID" />
															</div>
															<label for="form-add-text">标签所属分类<span
																style="color: #F00">*</span></label>
															<div>
																<select name="sel1" id="sel1">
																	<option value="">请选择分类</option>
																	<c:forEach items="${list2}" var="list2">

																		<option value="${list2.lcid}"
																			<c:if test="${lcid eq list2.text}">selected="selected"</c:if>><c:if
																				test="${list2==list2}"></c:if>${list2.text}
																		</option>
																	</c:forEach>

																</select>
																<!-- <input type="text" id="form-add-text" name="text" 
                                                                   placeholder="标签类名"/> -->
															</div>
															<label for="form-add-bname">内容<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-bname" name="lcinfo"
																	placeholder="标签内容" />
															</div>
															
															<!-- <label for="form-add-password">创建时间<span
																style="color: #F00">*</span></label>
															<div>
																minDate
																<input class="Wdate"
																	onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',Date:new Date(),})"
																	name="lcdate" />
															</div> -->
														</div>
													</div>

												</div>
											</div>
										</form>
										<div class="modal-footer">
											<button class="btn btn-sm" data-dismiss="modal" type="submit">
												<i class="ace-icon fa fa-times"></i>取消
											</button>
											<button type="button" data-dismiss="modal"
												class="btn btn-sm btn-primary " onclick="select()">确定</button>
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

								
								<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">×</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">修改标签</h4>
										</div>

										<div class="modal-body">
											
															<label for="form-add-lid1" style="display: none">标签ID<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-lid1" name="lid000"
																	style="display: none" placeholder="标签ID" />
															</div>
															<label for="form-add-text1">标签所属分类<span
																style="color: #F00">*</span></label>
															<div>
																<select name="sel11" id="sel11">
																	<option value="">请选择分类</option>
																	<c:forEach items="${list2}" var="list2">

																		<option value="${list2.lcid}"
																			<c:if test="${lcid eq list2.text}">selected="selected"</c:if>><c:if
																				test="${list2==list2}"></c:if>${list2.text}
																		</option>
																	</c:forEach>

																</select>
																<!-- <input type="text" id="form-add-text" name="text" 
                                                                   placeholder="标签类名"/> -->
															</div>
															<label for="form-add-bname1">内容<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="lcinfo12" name="lcinfo"
																	placeholder="标签内容"/>
															</div>															
														</div>
										
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">取消</button>
											<button type="button" class="btn btn-primary save" data-dismiss="modal" onclick="update()">确定</button>
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
	<script
		src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>

	<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
	<script src="${path}/assets/js/bootstrap-treeview.js"></script>
	<!-- ace脚本 -->
	<%@include file="../common/ace-scripts.jsp"%>

	<!-- 与此页相关的内联脚本 -->
	<script src="${path}/assets/custom-js/label/label.js"></script>

<script type="text/javascript">

function sel(){
	//var aa=$('#sel').find('option:selected').text()
	var aa=$("#txt_departmentname").val();
	console.log(aa)
	var urid=${urid }
	$.ajax({
        type:"POST",
        url:"${path}/label/list",
        data: {
        	text:$("#txt_departmentname").val(),
        	urid:urid
        },//必要
        success:function(data){
        	//location.reload();
        	//console.log(data)
        	$("body").html(data);
        },error:function(){
        	console.log("asadd")
        }
    });
}



 function select(){
	var aaa=$('#sel1').find('option:selected').text()
	console.log(aaa)
	var bbb=$('#form-add-bname').val();
	console.log(bbb)
	var urid=${urid }
	console.log(urid)
	 $.ajax({
        type:"POST",
        url:"${path}/label/add",
        data: {
        	text:aaa,
        	lcinfo:bbb,
        	urid:urid
        },//必要
        success:function(){
        	//location.reload();
        	//console.log(data)
        	console.log("success")
        	alert("新增成功");
        },error:function(){
        	console.log("error")
        	alert("新增失败");
        }
    }); 
	
} 
 
 /* $('#exampleModal').on('show.bs.modal', function (event) {
	    var button = $(event.relatedTarget) // 触发事件的按钮
	    var recipient = button.data('whatever') // 解析出data-whatever内容
	    //console.log($("td[name='text']").html())
	    var modal = $(this)
	    modal.find('.modal-body input').val(recipient)
	    
	}) */
	
var jsonDataTree = [];

$(function() {
	$.ajax({
		type : "post",
		url : "../label/tree.html",
		dataType : "json",// 特别重要
		success : function(data) {
			console.log("3")
			jsonDataTree = transData(data, 'lcid', 'lclcid', 'nodes');
		},
		error : function() {
			toastr.error('Error');
		},
	});
});

function transData(a, idStr, pidStr, chindrenStr) {
	var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;
	for (; i < len; i++) {
		hash[a[i][id]] = a[i];

	}
	for (; j < len; j++) {
		var aVal = a[j], hashVP = hash[aVal[pid]];
		if (hashVP) {
			!hashVP[children] && (hashVP[children] = []);
			hashVP[children].push(aVal);
		} else {
			r.push(aVal);
		}
	}
	console.log("1")
	console.log(r)
	console.log("2")
	return r;
}

$("#txt_departmentname").click(function() {
	console.log("123")
	console.log(jsonDataTree)
	console.log("456")
	var options = {
		bootstrap2 : false,
		showTags : true,
		levels : 1,
		highlightSelected : true,
		showCheckbox : false,
		checkedIcon : "glyphicon glyphicon-check",
		data : jsonDataTree,
		emptyIcon : "glyphicon",
		onNodeSelected : function(event, data) {
			$("#txt_departmentname").val(data.text);
			$("#treeview").hide();			
		}

	};
	$('#treeview').treeview(options);
});

var tableObj = document.getElementById('222').rows[0];
if (tableObj == null) {
	document.getElementById("what").style.display="";
}

</script>
</body>
</html>
