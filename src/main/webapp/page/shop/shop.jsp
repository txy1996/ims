<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>商户列表</title>
<%@include file="../common/meta.jsp"%>
<%@include file="../common/assets-css.jsp"%>
<head>
<meta charset="UTF-8">
<title>ueditor demo</title>
</head>

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
<link href="${path}/ueditor/themes/default/css/ueditor.css"
	rel="stylesheet">

<!-- 这里是本页内联样式开始 -->
<!-- 这里是本页内联样式结束 -->

<%@include file="../common/assets-js.jsp"%>
</head>

<body class="no-skin" id="shopbody">
	<%--top导航栏--%>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
			
			
			
			function WorkLike() {
				/* debugger; */
				var name2 = $("#name2").val();
				var name1 = $("#name1").val();
				var scid1 = $("#scid1").val();
				var bid1 = $("#bid1").val();
				/* console.log(words);
				console.log("${path}"); */
				console.log(name2)
				console.log(name1)
				console.log(scid1)
				console.log(bid1)
				window.location.href = "${path}/shop/list?name2=" + name2
						+ "&name1=" + name1 + "&scid1=" + scid1 + "&bid1="
						+ bid1;

				/* $.ajax({
				    url:"${path}/guest/list",
				    data:{words:words,pageNum:1,pageSize:8},
				    type:"POST",
				    traditional:true,
				    success:function(){
				       
				    }
				}); */
			}
		</script>

		<%--main-content内容--%>
		<div class="main-content">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state breadcrumbs-fixed"
					id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">商户列表</a>
						</li>
						<li class="active">商户列表</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							商户列表 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								共${list.total}个商户&emsp; <shiro:hasPermission name="shop:add">
									<button type="button"
										class="btn btn-primary btn-xs show-add-form"
										data-toggle="modal" data-target="#user-form-div">添加商户
									</button>
								</shiro:hasPermission>
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<select name="name1" id="name1">
						<option value="">请选择</option>
						<option value="商户名">商户名</option>
						<option value="联系电话">联系电话</option>
					</select> <select name="scid1" id="scid1">
						<option value="">请选择分类</option>
						<c:forEach items="${findAllSett}" var="findAllSett">

							<%-- <option value="${findAllSett.scid}" ><c:if test="${findAllSett==findAllSett}" >selected="selected"</c:if>${findAllSett.scname}
							</option> --%>
							<option value="${findAllSett.scid}"
								<c:if test="${scname eq findAllSett.scid}">selected="selected"</c:if>><c:if
									test="${findAllSett==findAllSett}"></c:if>${findAllSett.scname}
							</option>
						</c:forEach>
					</select> <select name="bid1" id="bid1">
						<option value="">请选择品牌</option>
						<c:forEach items="${selectall}" var="selectall">

							<option value="${selectall.bid}"
								<c:if test="${bname eq selectall.bid}">selected="selected"</c:if>><c:if
									test="${selectall==selectall}"></c:if>${selectall.bname}
							</option>
						</c:forEach>
					</select> <input type="text" name="name2" id="name2"
						placeholder="请输入商户名或联系电话"/>
					<button type="button" onclick="WorkLike()">查询</button>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-xs-12">
									<table id="simple-table"
										class="table  table-bordered table-hover user-list">
										<thead>
											<tr>
												<th><i class="fa  bigger-110 hidden-480"></i>商户id</th>
												<th><i class="fa  bigger-110 hidden-480"></i>商户名</th>
												<th><i class="fa  bigger-110 hidden-480"></i>地区</th>
												<th><i class="fa  bigger-110 hidden-480"></i>联系方式</th>
												<th><i class="fa  bigger-110 hidden-480"></i>分类</th>
												<th><i class="fa  bigger-110 hidden-480"></i>结算方式</th>
												<th><i class="fa  bigger-110 hidden-480"></i>代金券</th>
												<th><i class="fa  bigger-110 hidden-480"></i>优惠券</th>
												<th><i class="fa  bigger-110 hidden-480"></i>状态</th>
												<th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
											</tr>
										</thead>

										<tbody class="user-tbody" id="222">
											<shiro:hasPermission name="shop:list">
												<c:forEach items="${list.list}" var="list">

													<tr>

														<td class="sid">${list.sid}</td>
														<td class="sname" width=15%;><input type="text" name="bid"
															value="[${list.sb.bname }]" size="5" disabled="disabled" style:"border:none">
															${list.sname}</td>
														<td class="zid" >${list.zone.zname}</td>
														<%--   <td class="bid">${list.bid}</td>
                                            <td class="scid">${list.scid}</td> --%>
														<td class="stel" width=20%;>${list.scommerce}</td>
														<td class="scid" width=5%;>${list.sc.scname}</td>
														<td class=sbalancetype><c:if
																test="${list.sbalancetype=='1'}">
																<span class="label label-sm label-primary">银行转账</span>
															</c:if> <c:if test="${list.sbalancetype=='2'}">
																<span class="label label-sm label-warning">支付宝</span>
															</c:if> <c:if test="${list.sbalancetype=='3'}">
																<span class="label label-sm label-success">微信</span>
															</c:if> <c:if test="${list.sbalancetype=='4'}">
																<span class="label label-sm label-inverse">线下结算</span>
															</c:if></td>

														<td class="number" width=8%;>${list.number }</td>
														<td class="number1" width=8%;>${list.number1 }</td>
														<td class=sstate><c:if test="${list.sstate=='0'}">
																<span class="label label-sm label-warning">开业</span>
															</c:if> <c:if test="${list.sstate=='1'}">
																<span class="label label-sm label-success">暂停营业</span>
															</c:if> <c:if test="${list.sstate=='2'}">
																<span class="label label-sm label-inverse">闭店</span>
															</c:if></td>
														<!-- <td></td> -->
														<td width=15%; height=10%;><a
															href="${path }/voucherissue/list?sid=${list.sid}">发行代金券</a>
															<a href="${path }/couponissue/list?sid=${list.sid}">发行优惠券</a><br>
															<a href="${path }/shopvoucher/list?sid=${list.sid}">代金券管理</a>
															<a href="${path }/shopcoupon/list?sid=${list.sid}">优惠券管理</a><br>
															<!-- <button class="btn btn-xs btn-info jump-comment">
																<i class="ace-icon fa  bigger-120">评论管理</i>
															</button> -->
															<a class="jump-comment" style="cursor:pointer">评论管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a class="jump-comment111" style="cursor:pointer">商品管理</a><br>
															<a class="jifen" style="cursor:pointer">积分管理</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a class="jinbi" style="cursor:pointer">金币管理</a><br>
															<a href="${path }/photo/list?sid=${list.sid}">相册管理</a><br>
															<button type="button"
																		class="btn btn-primary btn-xs show-add-form"
																		data-toggle="modal" data-target="#exampleModal1"
																		data-whatever="${list.sid}" data-html="true"
																		data-content="1234">
																		推荐</button>
															 <%-- <a href="../userAssessst.jsp?sid=${list.sid}">评论管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
															<!-- <a href="">财务管理</a> -->
															<div class="hidden-sm hidden-xs btn-group">
																<shiro:hasPermission name="shop:update">
																	<button class="btn btn-xs btn-info show-update-form"
																		data-toggle="modal" data-target="#user-form-div">
																		<i class="ace-icon fa fa-pencil bigger-120"></i>
																		修改
																	</button>
																</shiro:hasPermission>

															</div>
															<div class="hidden-md hidden-lg">
																<div class="inline pos-rel">
																	<customTag:hasAnyPermissions name="shop:update">
																		<button
																			class="btn btn-minier btn-primary dropdown-toggle"
																			data-toggle="dropdown" data-position="auto">
																			<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
																		</button>
																	</customTag:hasAnyPermissions>
																	<shiro:lacksPermission name="shop:update">
																		<shiro:lacksPermission name="shop:delete">
																			<span
																				class="label label-large label-grey arrowed-in-right arrowed-in">
																				<i class="ace-icon fa fa-lock" title="无权限"></i>
																			</span>
																		</shiro:lacksPermission>
																	</shiro:lacksPermission>

																	<ul
																		class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																		<shiro:hasPermission name="shop:update">
																			<li><a href="javascript:void(0);"
																				class="tooltip-success show-update-form"
																				data-toggle="modal" data-target="#user-form-div"
																				data-rel="tooltip" title="更新用户"> <span
																					class="green"> <i
																						class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																				</span>
																			</a></li>
																		</shiro:hasPermission>
																	</ul>
																</div>
															</div></td>

													</tr>

												</c:forEach>
											</shiro:hasPermission>
											<shiro:lacksPermission name="shop:show">
												<td colspan="100">对不起，您无权限查看！</td>
											</shiro:lacksPermission>
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
													<li><a href="${path}/shop/list?pageNum=1">首页</a></li>
													<li><a
														href="${path}/shop/list?pageNum=${list.pageNum-1}"
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
														href="${path}/shop/list?pageNum=${page}">${page}</a></li>
												</c:if>
												<c:if test="${page!=list.pageNum}">
													<li><a href="${path }/shop/list?pageNum=${page}">${page}</a></li>
												</c:if>
											</c:forEach>

											<c:choose>
												<c:when test="${list.hasNextPage }">
													<li><a
														href="${path }/shop/list?pageNum=${list.pageNum+1 }"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
													<li><a href="${path }/shop/list?pageNum=${list.pages}">末页</a></li>
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
										<form id="user-form-add" name="user-form" class="user-form" enctype="multipart/form-data">
											<div class="modal-body">
												<div class="row">
													<div class="col-xs-12 ">
														<div class="form-group">

															<label for="form-add-bname" style="display: none">商户ID<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-bname" name="sid"
																	style="display: none" placeholder="商户ID" />
															</div>
															<label for="form-add-password">地区<span
																style="color: #F00">*</span></label>
															<div>
																<!--  <input type="text" id="form-add-password" name="zid" placeholder="地区"/>  -->
																<!--   <select name = "province" id = "province">
                                                              <option value = ''>请选择省</option>
                                                              </select>     
                                                              <select name = "city" id = "city">
                                                              <option value = ''>请选择市</option>
                                                              </select>  
                                                              <select name = "area" id = "area">
                                                              <option value = ''>请选择区/县</option>
                                                              </select>  -->
																<select name="zid" id="form-add-zid">
																	<option>请选择</option>
																	<c:forEach items="${zid}" var="zid">
																		<option value="${zid.zid}"><c:if
																				test="${zid==zid}"></c:if>${zid.zname}
																		</option>
																	</c:forEach>
																</select>
															</div>
															<label for="form-add-realName">品牌<span
																style="color: #F00">*</span></label>
															<div>
																<select name="bid" id="form-add-realName">
																	<option value=" ">请选择</option>
																	<c:forEach items="${selectall}" var="selectall">

																		<option value="${selectall.bid}"
																			<c:if test="${bname eq selectall.bid}">selected="selected"</c:if>><c:if
																				test="${selectall==selectall}"></c:if>${selectall.bname}
																		</option>
																	</c:forEach>
																</select>
															</div>
															<label for="form-add-sname">商户分类<span
																style="color: #F00">*</span></label>
															<div>
																<select name="scid" id="scid11">
																	<option value="">请选择分类</option>
																	<c:forEach items="${findAllSett}" var="findAllSett">

																		<%-- <option value="${findAllSett.scid}" ><c:if test="${findAllSett==findAllSett}" >selected="selected"</c:if>${findAllSett.scname}
							</option> --%>
																		<option value="${findAllSett.scid}"
																			<c:if test="${scname eq findAllSett.scid}">selected="selected"</c:if>><c:if
																				test="${findAllSett==findAllSett}"></c:if>${findAllSett.scname}
																		</option>
																	</c:forEach>
																</select>
															</div>
															<label for="form-add-sname">商户名<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-bname" name="sname"
																	placeholder="商户名" />
															</div>
															<label for="form-add-bname">地址<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-bname" name="saddress"
																	placeholder="地址" />
															</div>
															<label for="form-add-password">订餐联系方式<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-password" maxlength="50"
																	name="stel" placeholder="限50字" />
															</div>
															<label for="form-add-realName">经纬度<span
																style="color: #F00">*</span></label>
															<div>																
																 <input type="text" id="form-add-realName" name="scoordinate"
                                                                   placeholder="经纬度"/> 
                                                                   <button type="button" data-toggle="modal" name="jingweidu" id="jingweidu"
																	data-target="#myModal2" data-whatever="" onclick="lala()">请选择</button>
															</div>
															<label for="form-add-sname">商务洽谈联系方式<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-bname" name="scommerce"
																	placeholder="商务洽谈联系方式" />
															</div>

															<label for="form-add-bname">营业状态<span
																style="color: #F00">*</span></label>
															<div id="sstate">
																<label class="radio-inline"> <input
																	name="sstate" type="radio" class="ace" value="0" /> <span
																	class="lbl">开业</span>
																</label> <label class="radio-inline"> <input
																	name="sstate" type="radio" class="ace" value="1" /> <span
																	class="lbl">暂停营业</span>
																</label> <label class="radio-inline"> <input
																	name="sstate" type="radio" class="ace" value="2" /> <span
																	class="lbl">闭店</span>
																</label>
															</div>

															
															<label for="form-add-realName">编辑推荐(广告词)<span
																style="color: #F00">*</span></label>
															<div>
																<!-- <input type="text" id="form-add-realName" name="sad"
																	maxlength="300" placeholder="限10字" /> -->
																	<textarea id="editor2" name="sad"
																	style="width: 500px; height: 120px" rows="200"
																	maxlength="300"
																	onchange="this.value=this.value.substring(0, 300)"
																	onkeydown="this.value=this.value.substring(0, 300)"
																	onkeyup="this.value=this.value.substring(0, 300)"
																	placeholder="限300字"></textarea>
															</div>

															<label for="form-add-sname">商户简介<span
																style="color: #F00">*</span></label>
															<div>
																<textarea id="editor1" name="sinfo"
																	style="width: 500px; height: 120px" rows="200"
																	maxlength="1000"
																	onchange="this.value=this.value.substring(0, 1000)"
																	onkeydown="this.value=this.value.substring(0, 1000)"
																	onkeyup="this.value=this.value.substring(0, 1000)"
																	placeholder="限1000字"></textarea>
															</div>

															
															<label for="form-add-password">商户显示排序<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-password" name="ssort"
																	placeholder="商户显示排序" />
															</div>


															<label for="form-add-realName">商户协议结算模式<span
																style="color: #F00">*</span></label>

															<div id="sbalancetype">
																<label class="radio"> <input name="sbalancetype"
																	type="radio" class="ace" value="1" /> <span class="lbl">银行转账</span>
																</label> <label class="radio"> <input
																	name="sbalancetype" type="radio" class="ace" value="2" />
																	<span class="lbl">支付宝</span>
																</label> <label class="radio"> <input
																	name="sbalancetype" type="radio" class="ace" value="3" />
																	<span class="lbl">微信</span>
																</label> <label class="radio"> <input
																	name="sbalancetype" type="radio" class="ace" value="4" />
																	<span class="lbl">线下结算</span>
																</label>
															</div>

															<label for="form-add-sname">微信收款账号<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-sbwx" name="sbwx"
																	placeholder="微信收款账号" />
															</div>
															<label for="form-add-sbzfb">支付宝收款账号<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-bname" name="sbzfb"
																	placeholder="支付宝收款账号" />
															</div>
															<label for="form-add-password">银行卡收款账号<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-sbyhk" name="sbyhk"
																	placeholder="银行卡收款账号" />
															</div>
														
														<!-- <label for="form-add-password">商户形象图片<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-password" name="slogo"
																	placeholder="商户形象图片" />
															</div> -->

															<div class=" input-group input-group-sm col-xs-4 ">
																<label for="form-add-password">商户形象图片<span
																	style="color: #F00">*</span></label> <input type="text"
																	class="form-control inputcommodity" name="slogo"
																	placeholder="请选择形象图片..."
																	aria-describedby="basic-addon1" id="photoCover">
																<span class="input-group-btn"> <input id="slogo"
																	type="file" style="display: none" name="file">
																	<button class="btn btn-primary" type="button" style="margin-top:25px;"
																		onclick="$('input[id=slogo]').click();">选择</button>
																</span>
															</div>

															<!-- <label for="form-add-password">商户前台展示图片<span
																style="color: #F00">*</span></label>
															<div>
																<input type="text" id="form-add-password" name="styleimg"
																	placeholder="商户前台展示图片" />
															</div> -->
															
															<!-- <div class=" input-group input-group-sm col-xs-4 ">
																<label for="form-add-password">商户展示图片<span
																	style="color: #F00">*</span></label> <input type="text"
																	class="form-control inputcommodity" name="styleimg"
																	placeholder="请选择展示图片..."
																	aria-describedby="basic-addon1" id="photoCover1">
																<span class="input-group-btn"> <input id="styleimg"
																	type="file" style="display: none" name="file">
																	<button class="btn btn-primary" type="button" style="margin-top:25px;"
																		onclick="$('input[id=styleimg]').click();">选择</button>
																</span>
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
											<button type="button"
												class="btn btn-sm btn-primary user-submit"></button>
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
							
							<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
											</button>
											<h4 class="blue bigger">选择坐标</h4>
										</div>
										<input type="hidden" name="inp" id="inp" />
										<div class="modal-body" style="width:598px;height:400px;border:#ccc solid 1px;font-size:12px" id="map">
											
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">取消</button>
											<button type="button" class="btn btn-primary save1"
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
											<input type="hidden" name="ggid" id="ggid" value="${ggid }" />
											<input type="hidden" name="inp" id="inp" /> 选择推荐列表
												<select id="ggfl" onChange="getCategory()">
													<option value="-1">请选择数据列表分类</option>
													<option value="5">纯文字</option>
													<option value="11">纯图片</option>
													<option value="8">图文混合</option>
												</select><br>
												推荐到广告<input type="text"
														id="guanggao" name="guanggao" list="wlmslist"
														value="${model.sorpname}" placeholder="" />
													<datalist id="wlmslist">
													
													</datalist>
											</form>
											<div style="display: none;margin-left:45%;color:red;" id="what">暂无数据</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="button" class="btn btn-primary save111"
												data-dismiss="modal">确定</button>
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

	<%-- <script type="text/javascript" charset="utf-8"
		src="${path}/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="${path}/ueditor/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="${path}/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
		UE.getEditor('editor');
	</script>
	<script type="text/javascript">
		UE.getEditor('editor1');
	</script> --%>

	<!--这里是处理加载文本编辑器和上传图片路径的脚本-->


	<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>

	<!-- ace脚本 -->
	<%@include file="../common/ace-scripts.jsp"%>

	<!-- 与此页相关的内联脚本 -->
	<script src="${path}/assets/custom-js/shop.js"></script>

</body>
<script>
$('input[id=slogo]').change(function() {
	$('#photoCover').val($(this).val());
});

$('input[id=styleimg]').change(function() {
	$('#photoCover1').val($(this).val());
});
</script>

  <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=5c4b6cfcdf62237013fe7c34ddb9d80c&s=1"></script> 
 <script type="text/javascript"> 
	var aaa="";
	function init() {
		//debugger
		var a= document.getElementById('jingweidu').value;
		//debugger
		 if(a!=""){
			 console.log("---------")
			 console.log(a)
			 console.log("---------")
			 var arr = a.split(',');
			 console.log(arr[0])
			 console.log(arr[1])
			var map = new BMap.Map("map");            // 创建Map实例
			var point = new BMap.Point(arr[1], arr[0]); // 创建点坐标
			map.centerAndZoom(point,15);     
		 } else{
			 	var map = new BMap.Map("map");
				var point = new BMap.Point(104.07, 30.67);
				map.centerAndZoom(point, 15);
		 }         
		map.enableScrollWheelZoom();                 //启用滚轮放大缩小
		map.setDefaultCursor("crosshair");
		map.addEventListener("click",function(e){
			alert(e.point.lng + "," + e.point.lat);
			aaa=e.point.lat+","+e.point.lng
			console.log(aaa)
			
		});
	}  
	
	$(".save1").click(function() {
		console.log("1234")
		console.log(aaa)
		console.log("5678")
		$("input[name='scoordinate']").val(aaa);
	})
	function lala(){
		init();  //异步加载地图 *//
	}
		
	$('#myModal2').on('hidden.bs.modal', function () { 
		document.getElementsByTagName('body')[0].className = 'modal-open'; 
		});
	
	 $('#op-tips-dialog').on('hidden.bs.modal', function () { 
		document.getElementsByTagName('body')[0].className = 'modal-open'; 
		});
	 var tableObj = document.getElementById('222').rows[0];
	 if (tableObj == null) {
	 	document.getElementById("what").style.display="";
	 }
	</script>

</html>
