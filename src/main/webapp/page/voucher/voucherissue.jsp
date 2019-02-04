<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
<title>发行代金券</title>
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
<link rel="stylesheet" href="${path}/assets/css/bootstrap-multiselect.min.css" />

<!-- 这里是本页内联样式开始 -->
<!-- 这里是本页内联样式结束 -->

<%@include file="../common/assets-js.jsp"%>
</head>

<script type="text/javascript">
function load() {
	  $.ajax({
	      url : '${path}/voucherissue/finds',
	      type : "post",
	      dataType : 'json',
	      success : function(data) {
	    	  /* var data = JSON.parse(obj); */
	    	  /* debugger */
	    	  console.log(data)
	         if (data != null && data != '') {
	            var relateCust = data;
	            var relhtml="";
	            for (var i = 0; i < relateCust.length; i++) {
	                var row = relateCust[i];
	                if (row.id != null && row.id != ''){
	                    relhtml += "<option value=\"" + row.id + "\">"+ row.text + "</option>";
	                 }
	            }
	                  $("#Xdpcid").empty().append(relhtml);
	                  $('#Xdpcid').multiselect({
	                           enableFiltering: true,
	                           includeSelectAllOption: true,
	                           maxHeight: 200, 
	                    });//多选下拉框
	            }
	       },error : function(data){
	    	   console.log(data)
	       }
	   });
	}
</script>

<body class="no-skin" onload="load()">
	<%--top导航栏--%>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}

			
			
			
			

			
			function WorkLike() {
				
				/* var path,clip = $("#image"),FileReader = window.FileReader;
				$("#file").change(function() {
					if (FileReader) {//chrome浏览器处理
						var reader = new FileReader(),
							file = this.files[0];
						reader.onload = function(e) {
							clip.attr("src", e.target.result);//这里是把图片转成64位数据存入<img>中的src里
						};
						reader.readAsDataURL(file);
						//这里需要延迟一下，否则无法放入文本框内
						//setTimeout("showchange()",1000);
					}
					else {//其他浏览器处理，火狐在这里就不写出来了，网上资料很多
						path = $(this).val();
						if (/"\w\W"/.test(path)) {
							path = path.slice(1,-1);
						}
						clip.attr("src",path);
					}
				}); */

				
				var isAutoSend1 = document.getElementsByName('vrefund');
				var vrefund;
				for (var i = 0; i < isAutoSend1.length; i++) {
					if (isAutoSend1[i].checked == true) {
						vrefund = isAutoSend1[i].value;
					}
				}
				var isAutoSend2 = document.getElementsByName('visood');
				var visood;
				for (var i = 0; i < isAutoSend2.length; i++) {
					if (isAutoSend2[i].checked == true) {
						visood = isAutoSend2[i].value;
					}
				}
				var vcid = $("#vcid").val();
				var vtitle = $("#vtitle").val();
				var vrange1 = $("#vrange1").val();
				<%String s33 = (String) request.getParameter("sid");%>
				var sids = '<%=s33%>';
				var sorpname1 = $("#sorpname").val();
				var vmoney = $("#vmoney").val();
				var vcost = $("#vcost").val();
				var vprice = $("#vprice").val();
				var vsdate = $("#vsdate").val();
				var vodate = $("#vodate").val();
				var vgoods = $("#vgoods").val();
				var vintegration = $("#vintegration").val();
				var vtotal = $("#vtotal").val();
				var vamount = $("#vamount").val();
				var uaid = $("#uaid").val();
				var img = $("input:hidden[name='img']").val()
				var vinfo = $("#vinfo").val();
				var xdprice = $("#Xdprice").val();
				var xdpcid1  = $("#Xdpcid").val();
				var xdpcid  = xdpcid1.toString();
				var sorpname='';
				/* if($("#sorpname").prop("disabled")==true){//如果按钮是不可用的 */
					sorpname = $('#wlmslist option').filter(function() {
				        return this.value == sorpname1;
				    }).data('xyz');
				/* }else{
					sorpname = $("#sorpname").val();
				} */
			    
				console.log("------------")
				console.log(xdprice)
				console.log($("#Xdpcid").val())
				console.log(xdpcid)
				console.log(sorpname)
				console.log("------------")
				console.log(vcid)
				console.log(vtitle)
				console.log(vrange1)
				console.log(sorpname)
				console.log(vmoney)
				console.log(vcost)
				console.log(vprice)
				console.log(vsdate)
				console.log(vodate)
				console.log(vrefund)
				console.log(visood)
				console.log(vgoods)
				console.log(vintegration)
				console.log(vtotal)
				console.log(vamount)
				console.log(img)
				console.log(uaid)
				console.log(vinfo)
				var rowVal = {
					'vcid' : vcid,
					'vtitle' : vtitle,
					'vrange1' : vrange1,
					'sids' :sids,
					'sorpname' : sorpname,
					'vmoney' : vmoney,
					'vcost' : vcost,
					'vprice' : vprice,
					'vsdate' : vsdate,
					'vodate' : vodate,
					'vrefund' : vrefund,
					'visood' : visood,
					'vgoods' : vgoods,
					'vintegration' : vintegration,
					'vtotal' : vtotal,
					'vamount' : vamount,
					'uaid' : uaid,
					'img' : img,
					'vinfo' : vinfo,
					'xdprice' : xdprice,
					'xdpcid' : xdpcid
				};

				/* window.location.href="${path}/voucherissue/add?vcid="+vcid+"&vtitle="+vtitle
					 +"&vrange1="+vrange1+"&sorpname="+sorpname
					 +"&vmoney="+vmoney+"&vocst="+vcost
					 +"&vprice="+vprice+"&vsdate="+vsdate
					 +"&vodate="+vodate+"&vrefund="+vrefund
					 +"&visood="+visood+"&vgoods="+vgoods
					 +"&vintegration="+vintegration+"&vtotal="+vtotal
					 +"&vamount="+vamount+"&uaid="+uaid
					 +"&vimg="+vimg+"&vinfo="+vinfo
					 ; */
				/* var rowStr =JSON.stringify(rowVal);
				dataStr ="dataArr="+eval('('+JSON.stringify(dataArr.toString())+')'); */

				$.ajax({
					url : "${path}/voucherissue/add",
					type : "POST",
					dataType : "JSON",
					data : {
						'rowVal' : JSON.stringify(rowVal)
					},
					//traditional:true,
					success : function(rowVal) {
						alert('发行成功')
						if(sids!="null"){
							window.location.href = "${path}/shop/list?name2=" + ""
							+ "&name1=" + "" + "&scid1=" + "" + "&bid1="
							+ "";
						}else{
							history.go(0)
						}
					},
					error : function() {						
						alert('发行失败')
						if(sids!="null"){
							window.location.href = "${path}/shop/list?name2=" + ""
							+ "&name1=" + "" + "&scid1=" + "" + "&bid1="
							+ "";
						}else{
							history.go(0)
						}
					}
				})
			}
		</script>

		<%--main-content内容--%>
		<div class="main-content">

			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state breadcrumbs-fixed"
					id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">代金券管理</a>
						</li>
						<li class="active">发行代金券</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">

						<h1>
							${sname }&nbsp;&nbsp;&nbsp;发行代金券
							<%-- <small> <i class="ace-icon fa fa-angle-double-right"></i>
								共1个商户&emsp; <shiro:hasPermission name="shop:add">
									<button type="button"
										class="btn btn-primary btn-xs show-add-form"
										data-toggle="modal" data-target="#user-form-div">添加商户
									</button>
								</shiro:hasPermission>
							</small> --%>
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
											<td>代金券所属分类:</td>
											<td><select name="vcid" id="vcid">
													<option value="1">请选择分类</option>
													<c:forEach items="${list}" var="list">
														<option value="${list.vcid}"
															<c:if test="${vcname eq list.vcid}">selected="selected"</c:if>><c:if
																test="${list==list}"></c:if>${list.vcname}
														</option>
													</c:forEach>
											</select></td>
											<td>代金券名字:</td>
											<td><input type="text" id="vtitle" name="vtitle"
												placeholder="" value="${vtitle }" /></td>												
										</tr>
										<tr>
											<td>适用范围：</td>
											<td><select name="vrange1" id="vrange1"
												<c:if test="${not empty sid }">disabled="disabled"</c:if>>
													<option value="单店1"
														<c:if test="${vrange1 eq '单店1'}">selected="selected"</c:if>>请选择</option>
													<option value="单店"
														<c:if test="${vrange1 eq '单店'}">selected="selected"</c:if>>单店</option>
													<option value="品牌通用"
														<c:if test="${vrange1 eq '品牌通用'}">selected="selected"</c:if>>品牌通用</option>
													<option value="全站通用">全站通用</option>
											</select></td>
											<td height="80px">所属目标:</td>
											<td height="80px"><input type="text" id="sorpname"
												name="sorpname" list="wlmslist" placeholder=""
												<c:if test="${not empty sid }">disabled="disabled"</c:if>>
												<datalist id="wlmslist">
													<c:choose>
														<c:when test="${vrange eq '单店1' or vrange1 eq '单店'}">
															<c:forEach var="wl" items="${find2}">
																<option data-xyz="${wl.sid }">${wl.sname }[${wl.sc.scname }][${wl.zone.zname }]</option>
															</c:forEach>
														</c:when>
														<%-- <c:when test="${vrange eq '全站通用' }"></c:when> --%>
														<c:otherwise>
															<c:forEach var="wl" items="${find1}">
																<option data-xyz="${wl.bid }">${wl.bname }</option>
															</c:forEach>
														</c:otherwise>
													</c:choose>
												</datalist></td>
												<td align="right">限制商品:</td>
											<td><select id="Xdpcid" multiple="multiple"></select>
												<!-- <option value="0">全品类</option> -->
											</select>
											<p style="color:red">限定某类商品可以使用本券</p>
											</td>
										</tr>
										<tr>
											<td>面额:</td>
											<td><input type="text" id="vmoney" name="vmoney"
												placeholder="" /></td>
											<td>进货价:</td>
											<td><input type="text" id="vcost" name="vcost"
												placeholder="" /></td>
											<td align="right">销售价:</td>
											<td><input type="text" id="vprice" name="vprice"
												placeholder="" /></td>
										</tr>
										<tr>
											<td height="80px">生效时间:</td>
											<td><input type="date" id="vsdate" name="vsdate" /></td>
											<td>失效时间:</td>
											<td><input type="date" id="vodate" name="vodate" /></td>
											<td align="right">最低消费:</td>
											<td><input type="text" id="Xdprice"
												name="Xdprice" placeholder="" /><p style="color:red">代金券使用的最低消费，0为无限制</p></td>
										</tr>
										<tr>
											<td height="50px">过期处理方法:</td>
											<td><input type="radio" class="ace" name="vrefund"
												value=""><span class="lbl">失效不退款</span> <input
												type="radio" class="ace" name="vrefund" value="0"><span
												class="lbl">延长有效期</span> <input type="radio" class="ace"
												name="vrefund" checked value="1"><span class="lbl">过期可退款</span>
											</td>
										</tr>
										<tr>
											<td>是否找零:</td>
											<td><input type="radio" class="ace" name="visood"
												value="1"><span class="lbl">找零</span> <input
												type="radio" class="ace" name="visood" checked value="0"><span
												class="lbl">不找零</span></td>
										</tr>
										<tr>
											<td>赠送金币数:</td>
											<td><input type="text" id="vgoods" name="vgoods"
												placeholder="" /></td>
											<td height="80px">赠送积分数:</td>
											<td><input type="text" id="vintegration"
												name="vintegration" placeholder="" /></td>												
										</tr>
										<tr>
											<td>发行总量:</td>
											<td><input type="text" id="vtotal" name="vtotal"
												placeholder="" /></td>
											<td>发行总金额:</td>
											<td><input type="text" id="vamount" name="vamount"
												placeholder="" /></td>
											<td align="right" width="100px">销售代表:</td>
											<td><select name="uaid" id="uaid">
													<option value="0">请选择代表</option>
													<c:forEach items="${users}" var="users">
														<option value="${users.id}"><c:if
																test="${users==users}"></c:if>${users.username}
														</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td height="80px">代金券图片模板:</td>
											<td>
											<form  enctype="multipart/form-data" action="voucherissue:upload/upload" method="post">  
                 										<img id="pic" src=""  alt="" >  <!--  width="120" height="120"-->
                                                                <input type="file" name="vimg" id="vimg" onchange="setImg(this);"> <!--onchange="showPic(this);"  -->
                                                                <input type="hidden" name="img"  id="thumbUrl" />  
    												</form>
												</td>
										</tr>
										<tr>
											<td>券简介:</td>
											<td><textarea id="vinfo" name="vinfo"
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
							<!-- PAGE CONTENT ENDS -->
						</div>
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
	<!--这里是处理加载文本编辑器和上传图片路径的脚本-->
	<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
	<script src="${path}/assets/js/bootstrap-multiselect.min.js"></script>
	<!-- ace脚本 -->
	<%@include file="../common/ace-scripts.jsp"%>
	<!-- 与此页相关的内联脚本 -->
</body>
<script>
	$(function() {
		$("#vrange1")
				.change(
						function() {
							var a = "全站通用";
							var sorpname=$("#sorpname").val();
							var vcid = $("#vcid").val();
							var vtitle = $("#vtitle").val();
							<%String s2 = (String) request.getParameter("bid");%>
							var bid = '<%=s2%>';
							<%String s3 = (String) request.getParameter("sid");%>
							var sid = '<%=s3%>';
							console.log(bid);
							console.log(sid);
							if ($(this).val() == a) {
								$("#sorpname").attr("disabled", "disabled");
							} else {
								console.log($(this).val());
								$("#sorpname").removeAttr("disabled");
								window.location.href = "${path}/voucherissue/list?vrange1="
										+ $(this).val()
										+ "&vcid="
										+ vcid
										+ "&vtitle=" + vtitle;
							}
						});//change：每次选择选项获取选中值
	});
	
	function setImg(vimg){//用于进行图片上传，返回地址
	      var f=$(vimg).val();
	      var file = vimg.files[0];
	     if(f == null || f ==undefined || f == ''){
	         return false;
	     }
	     if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
	     {
	         alertLayel("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
	         $(vimg).val('');
	         return false;
	     }/* else{
	    	 var pic = new Image();
	         pic.src = f;
	         var height = f.height;
	         var width = f.width;
	         var filesize = f.filesize;
	          alert(height+"x.."+filesize);
	         if(width!==300 && height!==150 && filesize>1024000){
	          alert('请上传300*150像素 或者大小小于1000k的图片');
	          return false;
	         } 
	     } */
	     var data = new FormData();
	     $.each($(vimg)[0].files,function(i,file){
	         data.append('file', file);
	     });
         console.log(vimg);
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
			 /* console.log(document.getElementById("pic").style.width);
			console.log("aa");  */
             /* var img = document.getElementById("pic");
             img.src = e.target.result; */

             var img=new Image();  
                 img.onload=function(){
                	 if(img.height==150&&img.width==300){
                	 alert("图片满足要求");
                	 }else{
                		 alert("请上传300x150像素的图片");
                	 }
                	 };
                 /* img.onerror=function(){alert("error!")};  */ 
                 img.src=e.target.result;  
                 /* function show(){alert("body is loaded");};  
                 window.onload=show;  */
             
             
             //或者 img.src = this.result;  //e.target == this            
         }
		/* if(document.getElementsByTagName('img')[0].style.width!=="300px" && document.getElementsByTagName('img')[0].style.height!=="150px"){
			alert('请上传300*150像素的图片');
		}else{ */  
         reader.readAsDataURL(file)
	  /* } */  
	  var obj={};
	  var obj1={};
	  var sid = ${sid}
	  console.log("--------")
	  console.log(sid)
	  console.log("--------")
	  var sorpname1 = $("#sorpname").val();
	  var sid1 = $('#wlmslist option').filter(function() {
				        return this.value == sorpname1;
				    }).data('xyz');
	  console.log("0000000000000000000000000")
	  console.log(sid1)
	  console.log("0000000000000000000000000")
	  var objInput1 = document.getElementById("simple-table").getElementsByTagName("input");
	            	$(objInput1).each(function(i,item){
	            		var name=$(this).attr('name');
	            		var val=item.value;
	            		eval("obj."+name+"="+'val'); 
					
					});
	            	data.append('obj',JSON.stringify(obj))
	            	 console.info(obj)
	            	 data.append('sid1',sid1)
	  var objInput2 = document.getElementById("simple-table").getElementsByTagName("select");
	            	$(objInput2).each(function(i,item){
	            		var name=$(this).attr('name');
	            		var val=item.value;
	            		eval("obj1."+name+"="+'val'); 					
					});  
	            	data.append('obj1',JSON.stringify(obj1))
	            	console.info(obj1)
	            	data.append('sid',sid)
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
