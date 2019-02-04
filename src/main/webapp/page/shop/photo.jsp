<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>相册</title>
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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">相册列表</a>
						</li>
						<li class="active">相册列表</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							相册列表 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								共${listalbum.total}个 &emsp; <%-- <shiro:hasPermission name="photo:delete">
                                <button type="button" class="btn btn-warning btn-xs delete-query" data-toggle="modal"
                                        data-target="#delete-confirm-dialog">删除所选品牌
                                </button>
                            </shiro:hasPermission> --%> <shiro:hasPermission
									name="photo:add">
									<button type="button"
										class="btn btn-primary btn-xs show-add-form"
										data-toggle="modal" data-target="#user-form-div">新增相册
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
												<th><i class="fa  bigger-110 hidden-480"></i>相册名</th>

												<th><i class="fa  bigger-110 hidden-480"></i>相册简介</th>
												<th><i class="fa  bigger-110 hidden-480"></i>封面图</th>
												<th><i class="fa  bigger-110 hidden-480"></i>创建时间</th>

												<th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
											</tr>
										</thead>

										<tbody class="user-tbody">
											<shiro:hasPermission name="photo:list">
												<c:forEach items="${listalbum.list}" var="list">
													<tr>

														<td style="display: none;" class="aid">${list.aid}</td>
														<td id = "sid" class="sid" style="display: none;">${list.sid}</td>
														<td class="aname">${list.aname}</td>
														<td class="ainfo">${list.ainfo}</td>
														<td class="aimg">
														<a href="javascript:void(0);" onclick="imag(${list.aid});">
														<img  src="${list.aimg}" width="120" height="120" /> 
														</a>
														</td>
														<td class="adate">${list.adate}</td>

														<td>
															<div class="hidden-sm hidden-xs btn-group">
																<shiro:hasPermission name="photo:update">
																	<button class="btn btn-xs btn-info show-update-form"
																		data-toggle="modal" data-target="#user-form-div">
																		<i class="ace-icon fa fa-pencil bigger-120"></i>
																	</button>
																</shiro:hasPermission>

																<shiro:hasPermission name="photo:delete">
																	<c:if test="${list.aname ne 'admin'}">
																		<button class="btn btn-xs btn-danger delete-this-user">
																			<i class="ace-icon fa fa-trash-o bigger-120"></i>
																		</button>
																	</c:if>
																</shiro:hasPermission>

																<shiro:lacksPermission name="photo:update">
																	<shiro:lacksPermission name="photo:delete">
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
																		name="photo:update,photo:delete">
																		<button
																			class="btn btn-minier btn-primary dropdown-toggle"
																			data-toggle="dropdown" data-position="auto">
																			<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
																		</button>
																	</customTag:hasAnyPermissions>
																	<shiro:lacksPermission name="photo:update">
																		<shiro:lacksPermission name="photo:delete">
																			<span
																				class="label label-large label-grey arrowed-in-right arrowed-in">
																				<i class="ace-icon fa fa-lock" title="无权限"></i>
																			</span>
																		</shiro:lacksPermission>
																	</shiro:lacksPermission>

																	<ul
																		class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-

right dropdown-caret dropdown-close">
																		<shiro:hasPermission name="photo:update">
																			<li><a href="javascript:void(0);"
																				class="tooltip-success show-update-form"
																				data-toggle="modal" data-target="#user-form-div"
																				data-rel="tooltip" title="更新用户"> <span
																					class="green"> <i
																						class="ace-icon fa fa-pencil-square-o bigger-120"></i>


																				</span>
																			</a></li>
																		</shiro:hasPermission>

																		<shiro:hasPermission name="photo:delete">
																			<c:if test="${list.aname ne 'admin'}">
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
											<shiro:lacksPermission name="photo:show">
												<td colspan="100">对不起，您无权限查看！</td>
											</shiro:lacksPermission>
										</tbody>
									</table>
								</div>
								<!-- /.span -->
							</div>
							<!-- /.row -->
							<%--分页--%>
							<div class="row">
								<div class="col-xs-12 col-md-6">
									当前第${listalbum.pageNum}页，共${listalbum.pages}页，共${listalbum.total}条记录
								</div>
								<div class="col-xs-12 col-md-6">
									<nav aria-lable="Page navigation">
										<ul class="pagination">
											<c:choose>
												<c:when test="${listalbum.hasPreviousPage}">
													<li><a href="${path}/photo/list?pageNum=1">首页</a></li>
													<li><a
														href="${path}/photo/list?pageNum=${listalbum.pageNum-1}"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:when>
												<c:otherwise>
													<li class="disabled"><a href="javascript:void(0)">首页</a></li>
												</c:otherwise>
											</c:choose>

											<c:forEach items="${listalbum.navigatepageNums }" var="page">
												<c:if test="${page==listalbum.pageNum}">
													<li class="active"><a
														href="${path}/photo/list?pageNum=${page}">${page}</a></li>
												</c:if>
												<c:if test="${page!=listalbum.pageNum}">
													<li><a href="${path }/photo/list?pageNum=${page}">${page}</a></li>
												</c:if>
											</c:forEach>

											<c:choose>
												<c:when test="${listalbum.hasNextPage }">
													<li><a
														href="${path }/photo/list?pageNum=${listalbum.pageNum+1 }"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
													<li><a
														href="${path }/photo/list?pageNum=${listalbum.pages}">末页</a></li>
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
										<form id="user-form" name="user-form" class="user-form" enctype="multipart/form-data" action="photo:add/addalbum"> 
											<div class="modal-body">
												<div class="row">
													<div class="col-xs-12 col-sm-6">
														<div class="form-group">
															<label for="form-add-bname" style="display: none;">相册ID<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-bname" name="aid"
																	style="display: none;" placeholder="相册ID" />
															</div>
															<label for="form-add-sid" style="display: none;">商户ID<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="sid" name="sid"  style="display: none;"
																	/>
															</div>
															<label for="form-add-bname">相册名<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="aname" name="aname"
																	placeholder="相册名" />
															</div>
															<label for="form-add-password">相册简介<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="ainfo" name="ainfo"
																	placeholder="相册
																	简介" />
															</div>
															
															
															
															    <label >封面图<span style="color: #F00">*</span></label>
																<div>
                                                                <img id="pic" src="" width="120" alt="">  <!--  width="120" height="120"-->
                                                                <input type="file" name="aimg" id="aimg" onchange="setImg(this);"> <!--onchange="showPic(this);"  -->
                                                                <input type="hidden" name="img"  id="thumbUrl"/>
																</div> 
																
																
																
															   <label for="form-add-adate">创建时间<span style="color:#F00">*</span></label>
                                                        <div>
                                                           <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" id = "adate" name="adate" />
                                                        </div>  
														</div>
													</div>
												</div>
											</div>
										</form>
										
 <script type="text/javascript">
 
 //查看照片
 function imag(aid){
	 $.ajax({
		 type:"post",
		 dataType:"text",
		 data:{"aid":aid,
			 pageNum:1,
         	pageSize:8	 
		 },
		 url:'${path}/photo/list',//目标地址
		 success:function(data){
			location.href="${path}/photo/list?pageNum=1&pageSize=8&aid=" + aid;
		 },
		 })
	 /*  $.ajax({
	        url:"images.html",
	        data:{aid:aid},
	        type:"POST",
	        dataType:"json",
	         success:function(data){
	        	 debugger;
	        var data = JSON.stringify(data);
	        window.location.href="../page/shop/images.jsp?" + "data=" + data;
	        } 
	    }); */ 
	 /*   debugger; 
	        window.location.href="../page/shop/images.jsp?" + "aid=" + aid; 
 */ }
 
   function setImg(aimg){//用于进行图片上传，返回地址
      var f=$(aimg).val();
     if(f == null || f ==undefined || f == ''){
         return false;
     }
     if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
     {
         alertLayel("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
         $(aimg).val('');
         return false;
     }
     var data = new FormData();
     $.each($(aimg)[0].files,function(i,file){
         data.append('file', file);
     }); 
     $.ajax({
    	 type: "POST",
         url: "upload.html",
         data: data,
         cache: false,
         contentType: false,    //不可缺
         processData: false,    //不可缺
         dataType:"json",
         success: function(suc) {
        	 $("input[name='img']").val(suc);
                },
     });
 } 
//图片回显+图片格式+文件类型
function showPic(obj) { 
	  
        var newPreview = document.getElementById('pic'); 
        if (obj) { 
            //ie浏览器兼容 
            if (window.navigator.userAgent.indexOf("MSIE") >= 1) { 
                obj.select(); 
                newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);"; 

                var path = document.selection.createRange().text;
                var flag = judgeImgSuffix(path);
                if(flag){
                    newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = document.selection.createRange().text;
                }else{
                    alert("要求图片格式为png,jpg,jpeg,bmp");
                }

                return; 
            } 
            
           
            
            //firefox浏览器兼容 
            else if (window.navigator.userAgent.indexOf("Firefox") >= 1) { 
                if (obj.files) { 
                    newPreview.src = window.URL.createObjectURL(obj.files.item(0)); 
                    return; 
                } 
                newPreview.src = obj.value; 
                        return; 
                    } 
                    newPreview.src = obj.value; 
                    return; 
                } 
       
            } 

            function judgeImgSuffix(path){
                var index = path.lastIndexOf('.');
                var suffix = "";
                if(index > 0){
                    suffix = path.substring(index+1);
                }
                if("png"==suffix || "jpg"==suffix || "jpeg"==suffix || "bmp"==suffix || "PNG"==suffix || "JPG"==suffix || "JPEG"==suffix || "BMP"==suffix){
                    return true;
                }else{
                    return false;
                }

            }
</script> 
										<div class="modal-footer">
											<button class="btn btn-sm" data-dismiss="modal" type="submit">
												<i class="ace-icon fa fa-times"></i>取消
											</button>
											<button type="button"
												class="btn btn-sm btn-primary user-submit" onclick="addsid();"></button>
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
	<script src="${path}/assets/js/ajaxfileupload.js"></script>
	<script src="${path}/assets/js/commonjs.js"></script>
	<script src="${path}/assets/js/md5.js"></script>
	<script src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>

	<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>

	<!-- ace脚本 -->
	<%@include file="../common/ace-scripts.jsp"%>

	<!-- 与此页相关的内联脚本 -->
	<script src="${path}/assets/custom-js/photo.js"></script>
<script type="text/javascript">

//获取商户id
 function addsid(){
 var sid = ${sid};
  $("input[name='sid']").val(sid); 
} 
</script>
</body>
</html>