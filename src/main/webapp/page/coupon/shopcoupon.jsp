<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>用户代金券</title>
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
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">优惠券管理</a>
                    </li>
                    <li class="active">商户优惠券</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        ${findname } 优惠券
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            共${list.total}个&emsp;
                                                        
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


						库存
						<select id="vstore" style="height: 35px;">
						<option value="">请选择</option>
						<option value="0~150">0-150</option>
						<option value="150~300">150-300</option>
						<option value="300~450">300-450</option>
						<option value="450~600">450-600</option>
						<option value="600~750">600-750</option>
						<option value="750~900">750-900</option>
						<option value="900~10000">900以上</option>
							<%-- <c:forEach items="${list2}" var="list2">

							<option value="${findAllSett.scid}" ><c:if test="${findAllSett==findAllSett}" >selected="selected"</c:if>${findAllSett.scname}
							</option>
							<option value="${list2.uvlstate}"
								<c:if test="${uvlstate eq list2.uvlid}">selected="selected"</c:if>><c:if
									test="${list2==list2}"></c:if>${list2.uvlstate}
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
                                        <th><i class="fa fa-location-arrow bigger-110 hidden-480"></i>面值</th>
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>售价</th>
                                         <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>适用范围</th>
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>总量</th>
                                        <th><i class="fa fa-sort-numeric-asc bigger-110 hidden-480"></i>库存</th>
                                        <th><i class="fa fa-picture-o bigger-110 hidden-480"></i>生效日期-失效日期</th>                                 
                                        <th><i class="fa fa-cog fa-spin bigger-110 hidden-480"></i>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody id="222">
                                    <shiro:hasPermission name="shopcoupon:list">
                                    <c:forEach items="${list.list}" var="list">
                                        
                                       
                                        
                                        <tr>
                                        	
                                            <td class="vid">${list.cid}</td> 
                                            <td class="vtitle">${list.ctitle}</td> 
                                            <td class="vmoney">${list.cmoney}</td> 
                                            <td class="vprice">${list.cprice}</td>	
                                            <td class="vsdate">${findname}</td> 
                                            <td class="vodate">${list.cnum}</td> 
                                            <td class="vodate">${list.cstore}</td> 
                                            <td class="vgoods" id="aaa"> <input type="hidden" id="date" value="${list.codate }"/>${list.csdate}-${list.codate }</td>                                             
                                                                                       	                                       
                                            
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">

																<%-- <shiro:hasPermission name="shopcoupon:update"> --%>
																	<button class="btn btn-xs btn-info show-update-form"
																		data-toggle="modal" data-target="#user-form-div">
																		<!-- <i class="ace-icon fa fa-pencil bigger-120"></i> -->
																		修改
																	</button>
																<%-- </shiro:hasPermission> --%>
																<button type="button" class="btn btn-xs btn-info" onclick="zuofei(${list.cid})" <c:if test="${list.cstore ne list.cnum }">disabled="disabled"</c:if>>作废</button>	
																
																	
																	
															</div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="shopcoupon:list">
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
                                                <li><a href="${path}/shopcoupon/list?pageNum=1">首页</a></li>
                                                <li>
                                                    <a href="${path}/shopcoupon/list?pageNum=${list.pageNum-1}"
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
                                                        href="${path}/shopcoupon/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=list.pageNum}">
                                                <li><a href="${path }/shopcoupon/list?pageNum=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${list.hasNextPage }">
                                                <li>
                                                    <a href="${path }/shopcoupon/list?pageNum=${list.pageNum+1 }"
                                                       aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                                <li><a href="${path }/shopcoupon/list?pageNum=${list.pages}">末页</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="disabled"><a href="javascript:void(0)">末页</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                    </ul>
                                </nav>
                            </div>
                        </div>

							<div class="modal fade" id="user-form-div" tabindex="-1" role="dialog"
                             aria-labelledby="mySmallModalLabel">
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
                                                    <input type="hidden" name="cid" class="form-control">
                                                    <div class="form-group">                                                                                                          
														
														<label for="codeInput">优惠券名字<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="ctitle" name="ctitle" placeholder=""/>
                                                        </div>
                                                        
                                                         <label for="codeInput">面值<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="cmoney" name="cmoney" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="codeInput">售价<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="cprice" name="cprice" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="codeInput">适用范围<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="crange" name="crange" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="codeInput">总量<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="cnum" name="cnum" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="codeInput">库存<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input type="text" id="cstore" name="cstore" placeholder=""/>
                                                        </div>
                                                        
                                                        <label for="codeInput">生效日期<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',Date:new Date(),})" name="csdate"/>
                                                        </div>
                                                        
                                                        <label for="codeInput">失效日期<span style="color:#F00">*</span></label>
                                                        <div>
                                                            <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',Date:new Date(),})" name="codate"/>
                                                        </div>
                                                      
                                                    </div>
                                                </div>                                                
                                            </div>
                                        </div>
                                    </form>
                                    <div class="modal-footer">
                                        <button class="btn btn-sm" data-dismiss="modal" type="submit"><i
                                                class="ace-icon fa fa-times"></i>取消
                                        </button>
                                        <button type="button" class="btn btn-sm btn-primary user-submit">确定</button>
                                    </div>
                                </div>

                            </div>
                        </div>
							
							
							
							<!-- <div class="modal fade" id="exampleModal1" tabindex="-1"
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
													<label for="recipient-name1" class="control-label">Recipient:</label>
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
							</div> -->


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
<script src="${path}/assets/custom-js/coupon/shopcoupon.js"></script>

</body>
<script>

function select(){
	var a=$("#starttime").val();
	var b=$("#endtime").val();
	/* var c="'"+${findname }+"'"; */
	console.log(a);
	console.log(b);
	console.log("${findname }")
	var cc=${sid}
	$.ajax({
		url : "../shopcoupon/list.html",
		dataType : "html",// 特别重要
		data : {
			starttime : a,
			endtime:b,
			sid:cc
		},
		type : "POST",
		success : function(data) {
			$("#Refreshbody").html(data)
		},
		error : function() {
			console.log("1")
		}
	});
}

function select1(){
	var a=$("#vstore").val();
	console.log(a)
	console.log("${findname }")
	$.ajax({
		url : "../shopcoupon/list.html",
		dataType : "html",// 特别重要
		data : {
			cstore : a,
			sid:"${sid }"
		},
		type : "POST",
		success : function(data) {
			$("#Refreshbody").html(data)
		},
		error : function() {

		}
	});
}


var tableObj = document.getElementById('222').rows[0];
if (tableObj == null) {
	document.getElementById("what").style.display="";
}


</script>
</html>
