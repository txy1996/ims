<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>新增优惠券</title>
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

<body class="no-skin">
	<%--top导航栏--%>
<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}

			function WorkLike() {
				var isAutoSend1 = document.getElementsByName('crefund');
				var crefund;
	            for (var i = 0; i < isAutoSend1.length; i++) {
	                if (isAutoSend1[i].checked == true) {
	                	crefund=isAutoSend1[i].value;
	                }
	            }
	            var isAutoSend2 = document.getElementsByName('cisood');
				var cisood;
	            for (var i = 0; i < isAutoSend2.length; i++) {
	                if (isAutoSend2[i].checked == true) {
	                	cisood=isAutoSend2[i].value;
	                }
	            }
	            var isAutoSend3 = document.getElementsByName('cisrepeat');
				var cisrepeat;
	            for (var i = 0; i < isAutoSend3.length; i++) {
	                if (isAutoSend3[i].checked == true) {
	                	cisrepeat=isAutoSend3[i].value;
	                }
	            }
	            
				var ccid = $("#ccid").val();
	        	var ctitle = $("#ctitle").val();
	        	var crange1 = $("#crange1").val();
	        	<%String s33 = (String) request.getParameter("sid");%>
				var sids = '<%=s33%>';
	        	/* var sorpname = $("#sorpname").val(); */
	        	var cdiscount = $("#cdiscount").val();
	        	var csum = $("#csum").val();
	        	var cfullcut = $("#cfullcut").val();
	        	var cmoney = $("#cmoney").val();	        	
	        	var cprice = $("#cprice").val();
	        	var cgoods = $("#cgoods").val();
	        	var csdate = $("#csdate").val();
	        	var codate = $("#codate").val();
	        	
	        	var cintegration = $("#cintegration").val();
	        	var img = $("input:hidden[name='img']").val()
	        	var cinfo = $("#cinfo").val();
	        	
	        	console.log(ccid)
	        	console.log(ctitle)
	        	console.log(crange1)
	        	console.log(sids)
	        	console.log(cdiscount)
	        	console.log(csum)
	        	console.log(cfullcut)
	        	console.log(cmoney)
	        	console.log(cprice)
	        	console.log(cgoods)	        	
	        	console.log(csdate)
	        	console.log(codate)	
	        	console.log(crefund)
	        	console.log(cisood)
	        	console.log(cisrepeat)	        	
	        	console.log(cintegration)
	        	/* console.log(ctotal) */
	        	/* console.log(camount) */
	        	/* console.log(uaid) */
	        	console.log(img)
	        	console.log(cinfo)
	        	var rowVal ={'ccid':ccid,'ctitle':ctitle,'crange1':crange1,'sids' :sids,
				/* 'sorpname':sorpname, */'cdiscount':cdiscount,'csum':csum,
				'cfullcut':cfullcut,'cmoney':cmoney,'cprice':cprice,
				'cgoods':cgoods,'csdate':csdate,'codate':codate,'crefund':crefund,
				'cisood':cisood,'cisrepeat':cisrepeat,/* 'cgoods1':cgoods1, */'cintegration':cintegration,/* 'ctotal':ctotal, */
				/* 'camount':camount, *//* 'uaid':uaid, */'img':img,'vinfo':cinfo
	        	};
	        	
	        	$.ajax({
	        		url: "${path}/coupon/add",
	        		type:"POST",
	        		dataType:"JSON",
	        		data: {'rowVal':JSON.stringify(rowVal)},
	        		//traditional:true,
	        		success:function(rowVal){
	        		alert('添加成功')
	        		window.location.href="${path}/coupon/list"
	        		},
	        		error:function(){
	        			alert('添加失败')
	        			window.location.href="${path}/coupon/addCoupon"
	        		}
	        		})
			}
		</script>
	<div class="main-container ace-save-state" id="main-container">

		<%--main-content内容--%>
		<div class="main-content">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state breadcrumbs-fixed"
					id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">优惠券管理</a>
						</li>
						<li class="active">新增优惠券</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">

						<h1>
							${sname }&nbsp;&nbsp;&nbsp;新增优惠券
						</h1>
					</div>
					<!-- /.page-header -->
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-xs-12">
									<table id="simple-table" style="border: 5px">

										<tr>
											<td>优惠券所属分类:</td>
											<td><select name="ccid" id="ccid">
													<option value="1">请选择分类</option>
													<c:forEach items="${list}" var="list">
														<option value="${list.ccid}"
															<c:if test="${ccname eq list.ccid}">selected="selected"</c:if>><c:if
																test="${list==list}"></c:if>${list.ccname}
														</option>
													</c:forEach>
											</select></td>
											<td>优惠券名字:</td>
											<td><input type="text" id="ctitle" name="ctitle"
												placeholder="" value="${ctitle }" /></td>
										</tr>
										<tr >
											<td height="80px">适用范围：</td>
											<td><select name="crange1" id="crange1"
												<c:if test="${not empty sid }">disabled="disabled"</c:if>>
													<option value="单店1"
														<c:if test="${crange1 eq '单店1'}">selected="selected"</c:if>>请选择</option>
													<option value="单店"
														<c:if test="${crange1 eq '单店'}">selected="selected"</c:if>>单店</option>
													<option value="品牌通用"
														<c:if test="${crange1 eq '品牌通用'}">selected="selected"</c:if>>品牌通用</option>
													<option value="全站通用">全站通用</option>
											</select></td>
											<%-- <td height="80px">所属目标:</td>
											<td height="80px"><input type="text" id="sorpname"
												name="sorpname" list="wlmslist" value="${model.sorpname}"
												placeholder=""
												<c:if test="${not empty sid }">disabled="disabled"</c:if> />
												<datalist id="wlmslist">
													<c:choose>
														<c:when test="${crange eq '单店1' or crange1 eq '单店'}">
															<c:forEach var="wl" items="${find2}">
																<option value="${wl.sid }">${wl.sname }[${wl.sc.scname }][${wl.zone.zname }]</option>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<c:forEach var="wl" items="${find1}">
																<option value="${wl.bid }">${wl.bname }</option>
															</c:forEach>
														</c:otherwise>
													</c:choose>
												</datalist></td> --%>
										</tr>
										<tr>
											<td>折扣率:</td>
											<td><input type="text" id="cdiscount" name="cdiscount"
												placeholder="" /></td>
											<td>折扣金额:</td>
											<td><input type="text" id="csum" name="csum"
												placeholder="" /></td>
											<td align="right">满减:</td>
											<td><input type="text" id="cfullcut" name="cfullcut"
												placeholder="" /></td>
										</tr>
										<tr>
											<td height="80px">进货价:</td>
											<td><input type="text" id="cmoney" name="cmoney"
												placeholder="" /></td>
											<!-- <td>销售价:</td>
											<td><input type="text" id="cprice" name="cprice" placeholder="" /></td> -->
											<td height="80px">所需金币:</td>
											<td><input type="text" id="cgoods" name="cgoods"
												placeholder="" /></td>
											<td align="right">销售价:</td>
											<td><input type="text" id="cprice" name="cprice"
												placeholder="" /></td>
										</tr>
										<tr>
											<td height="80px">生效时间:</td>
											 <td><input type="date" id="csdate" name="csdate" /></td> 
											<!-- <td><input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="csdate"/></td> -->
											<td>失效时间:</td>
											 <td><input type="date" id="codate" name="codate" /></td> 
											 <!-- <td><input class="Wdate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="codate"/></td> -->
										</tr>
										<tr>
											<td height="50px">过期处理方法:</td>
											<td><input type="radio" class="ace" name="crefund"
												value="0"><span class="lbl">失效不退款</span> <input
												type="radio" class="ace" name="crefund" value="1"><span
												class="lbl">延长有效期</span> <input type="radio" class="ace"
												name="crefund" checked value="2"><span class="lbl">过期可退款</span>
											</td>
										</tr>
										<tr>
											<td>是否找零:</td>
											<td><input type="radio" class="ace" name="cisood"
												value="1"><span class="lbl">找零</span> <input
												type="radio" class="ace" name="cisood" checked value="0"><span
												class="lbl">不找零</span></td>
										</tr>
										<tr>
											<td height="50px">是否可重复领取:</td>
											<td><input type="radio" class="ace" name="cisrepeat"
												value="1"><span class="lbl">无限</span> <input
												type="radio" class="ace" name="cisrepeat" checked value="0"><span
												class="lbl">不能</span></td>
										</tr>
										<tr>
											<!-- <td>赠送金币数:</td>
											<td><input type="text" id="cgoods1" name="cgoods1"
												placeholder="" /></td> -->
											<td height="80px">成长度数量:</td>
											<td><input type="text" id="cintegration"
												name="cintegration" placeholder="" /></td>
										</tr>
										<tr>
										</tr>
										<tr>
											<td height="80px">优惠券券图片模板:</td>
											<td>
											<form  enctype="multipart/form-data" action="couponissue:upload/upload" method="post">  
                 										<img id="pic" src=""  alt="" >  <!--  width="120" height="120"-->
                                                                <input type="file" name="cimg" id="cimg" onchange="setImg(this);"> <!--onchange="showPic(this);"  -->
                                                                <input type="hidden" name="img"  id="thumbUrl" />  
    												</form>
											</td>
										</tr>
										<tr>
											<td>券简介:</td>
											<td><textarea id="cinfo" name="cinfo"
													style="width: 300px; height: 120px" rows="3" maxlength="50"
													onchange="this.value=this.value.substring(0, 50)"
													onkeydown="this.value=this.value.substring(0, 50)"
													onkeyup="this.value=this.value.substring(0, 50)"
													placeholder="限50字"></textarea></td>

										</tr>
										<tr>
											<td>
											<td height="80px">
												<button type="button"
													class="btn btn-sm btn-primary user-submit"
													onclick="history.back()">取消</button>
												<button type="button"
													class="btn btn-sm btn-primary user-submit"
													onclick="WorkLike()">确定</button>
											</td>
										</tr>
									</table>

								</div>
								<!-- /.span -->
							</div>
						</div>
					</div>
					<!-- /.row -->
				</div>
			</div>
		</div>
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
	<!--这里是处理加载文本编辑器和上传图片路径的脚本-->
	<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
	<!-- ace脚本 -->
	<%@include file="../common/ace-scripts.jsp"%>
	<!-- 与此页相关的内联脚本 -->
</body>
<script>

	$(function() {
		$("#crange1")
				.change(
						function() {
							var a = "全站通用";
							/* var sorpname=$("#sorpname").val(); */
							var ccid = $("#ccid").val();
							var ctitle = $("#ctitle").val();
							<%String s2 = (String) request.getParameter("bid");%>
							var bid = '<%=s2%>';
							<%String s3 = (String) request.getParameter("sid");%>
							var sid = '<%=s3%>';
							console.log(bid);
							console.log(sid);
							/* if ($(this).val() == a) {
								$("#sorpname").attr("disabled", "disabled");
							} else {
								console.log($(this).val());
								$("#sorpname").removeAttr("disabled");
								window.location.href = "${path}/couponissue/list?crange1="
										+ $(this).val()
										+ "&ccid="
										+ ccid
										+ "&ctitle=" + ctitle;
							} */
						});//change：每次选择选项获取选中值
	});
	
	
	 function setImg(cimg){//用于进行图片上传，返回地址
	      var f=$(cimg).val();
	      var file = cimg.files[0];
	     if(f == null || f ==undefined || f == ''){
	         return false;
	     }
	     if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
	     {
	         alertLayel("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
	         $(cimg).val('');
	         return false;
	     }
	     var data = new FormData();
	     $.each($(cimg)[0].files,function(i,file){
	         data.append('file', file);
	     }); 	     	              
         console.log(cimg);
         console.log(file);
         console.log("file.size = " + file.size);  //file.size 单位为byte
         var reader = new FileReader();
         //读取文件过程方法
         reader.onloadstart = function (e) {
             console.log("开始读取....");
         }
         reader.onprogress = function (e) {
             console.log("正在读取中....");
         }
         reader.onabort = function (e) {
             console.log("中断读取....");
         }
         reader.onerror = function (e) {
             console.log("读取异常....");
         }
         reader.onload = function (e) {
             console.log("成功读取....");

             var img=new Image();  
                 img.onload=function(){
                	 if(img.height==150&&img.width==300){
                	 alert("图片满足要求");
                	 }else{
                		 alert("请上传300x150像素的图片");
                	 }
                	 };
                 img.src=e.target.result;  
         }
         reader.readAsDataURL(file)
	     
	     var data = new FormData();
	     $.each($(cimg)[0].files,function(i,file){
	         data.append('file', file);
	     }); 
	     
	     var obj={};
		  var obj1={};
		  var objInput1 = document.getElementById("simple-table").getElementsByTagName("input");
		            	$(objInput1).each(function(i,item){
		            		var name=$(this).attr('name');
		            		var val=item.value;
		            		eval("obj."+name+"="+'val'); 
						
						});	            	
		            	data.append('obj',JSON.stringify(obj))
		            	 console.info(obj)
		  var objInput2 = document.getElementById("simple-table").getElementsByTagName("select");
		            	$(objInput2).each(function(i,item){
		            		var name=$(this).attr('name');
		            		var val=item.value;
		            		eval("obj1."+name+"="+'val'); 					
						});  
		            	data.append('obj1',JSON.stringify(obj1))
		            	console.info(obj1)
	     
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
</html>
			 