
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="../common/meta.jsp"%>
<%@include file="../common/assets-css.jsp"%>
<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />
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
/** 重置浏览器默认标签样式 */
body, ul, li {
	margin: 0;
	padding: 0;
}

.xttblog {
	overflow: hidden;
	width: 600px;
	margin-top: 50px;
	margin-left: auto;
	margin-right: auto;
}

.box {
	margin-left: 5px;
	margin-top: 5px;
	list-style-type: none;
}

.box:after {
	content: ".";
	display: block;
	line-height: 0;
	width: 0;
	height: 0;
	clear: both;
	visibility: hidden;
	overflow: hidden;
}

.box li {
	float: left;
	line-height: 230px;
}

.box li, .box li a:visited {
	margin: 30px 3%;
	display: block;
	width: 100%;
	height: 100%;
	text-align: left;
	margin-left: -5px;
	margin-top: -5px;
	position: relative;
}

.box li  span {
	display: block;
	height: 25px;
	line-height: 20px;
	color: #999;
	font-size: 14px;
}

.box li:hover {
	border-color: #f00;
	z-index: 2;
}
</style>
</head>
<body class="no-skin">
	<div class="main-container ace-save-state" id="main-container">
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state breadcrumbs-fixed"
					id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">广告列表</a>
						</li>
						<li class="active">编辑广告</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>编辑广告</h1>
					</div>
					<form action="updatapro" method="post" name="xiangmu" id="xiangmu"
						enctype="multipart/form-data">
						<div>
							位置标题: <input type="text" name="bt"> <label
								for="form-add-iname" style="margin-left: 10%;">表现类型: <select
								name="ty" id="ty" onchange="gradeChange();">
									<option value="0">请选择</option>
									<option value="1">图片文字链接</option>
									<option value="2">图片链接</option>
									<option value="3">文字链接</option>
									<option value="4">视频链接</option>
									<option value="5">纯文字商户列表</option>
									<option value="6">纯文字方案列表</option>
									<option value="7">纯文字商品列表</option>
									<option value="8">图文商户列表</option>
									<option value="9">图文方案列表</option>
									<option value="10">图文商品列表</option>
									<option value="11">商户纯图片列表</option>
									<option value="12">方案纯图片列表</option>
									<option value="13">商品纯图片列表</option>
							</select>
							</label> <label for="form-add-iname" style="margin-left: 10%;">状态:
								<select name="ys">
									<option value="0">预审</option>
									<option value="1">发布</option>
									<option value="2">下架</option>
							</select>
							</label>
						</div>
						<div id="table1" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">

								 
								<!-- <label>图片1<span style="color: #F00">*</span></label>
								<img src="" id="mt" style="width: 30%; height: 100%;" />
								<input type="text" id="urll" name="urll" style="display: none"> -->
								<div>
									<input type=file name="myfiles" id="doc"
										onchange="showImage();">

									<div style="margin: 1% 0;">
										<label for="form-add-iname">文字内容: <input type="text"
											id="form-add-iname" name="wz" /></label> <label
											for="form-add-iname" style="margin-left: 10%;"> 链接地址:
											<select name="shopmore">
												<option value="URL">纯URL</option>
												<option value="S:">商户详情</option>
												<option value="F:">方案详情</option>
												<option value="P:">产品详情</option>
												<option value="LS:">商户列表</option>
												<option value="LF:">方案列表</option>
												<option value="LP:">产品列表</option>
										</select> <input type="text" id="form-add-iname" name="dz" />
										</label>
									</div>


								</div>





								<div id="localImag"
									style="position: absolute; left: 25%; top: 5%">
									<img id="preview" width=-1 height=-1 style="diplay: none" />
								</div>
								<!-- <label>图片2<span style="color: #F00">*</span></label>
								<div style="margin: 5px 0; position: relative;">
									<input type="file" name="myfiles" id="doc1">
								</div>
								<label>图片3<span style="color: #F00">*</span></label>
								<div style="margin: 5px 0; position: relative;">
									<input type="file" name="myfiles" />
								</div> -->

								<div>
									生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /> <label
										for="form-idd-adate" style="margin-left: 11%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table2" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<c:forEach items="${arr}" var="arr">
				                   <img src="${arr.url }" style="width: 10%; height: 10%;" />
									<div style="margin: 5px 0; position: relative;">
										<input type="file" name="myfiles" />
									</div>
				                   <%-- <input type = "text" value="${arr.words }" id = "words" >
				                   <input type = "text" value="${arr.address }" id = "address" > --%>
				               </c:forEach> 
								<!-- <label>图片1<span style="color: #F00">*</span></label>
								<img src="" id="mr" style="width: 30%; height: 100%;" /> -->
								<!-- <div style="margin: 5px 0; position: relative;">
									<input type=file name="myfiles" id="doc2"
										onchange="showImage1();">
								</div> -->
								<div id="localImag"
									style="position: absolute; left: 25%; top: 5%">
									<img id="preview1" width=-1 height=-1 style="diplay: none" />
								</div>
								<!-- <label>图片2<span style="color: #F00">*</span></label>
								<div style="margin: 5px 0; position: relative;">
									<input type="file" name="myfiles" id="doc1">
								</div>
								<label>图片3<span style="color: #F00">*</span></label>
								<div style="margin: 5px 0; position: relative;">
									<input type="file" name="myfiles" />
								</div>
								<label for="form-add-iname" style="margin: 1% 0;">链接地址:
									<input type="text" id="form-add-iname" name="dz2" />
								</label> -->
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table3" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<div style="margin: 1% 0;">
									<label for="form-add-iname">文字内容: <input type="text"
										id="form-add-iname" name="wz3" /></label> <label for="form-add-iname"
										style="margin-left: 110px;">链接地址: <input type="text"
										id="form-add-iname" name="dz3" /></label>
								</div>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 118px;">失效日期:
										<input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" />
									</label>
								</div>
							</c:forEach>
						</div>
						<div id="table4" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<label>视频: <input type="file" name="myfiles" /></label>
								<label for="form-add-iname" style="margin: 1% 0;">链接地址:
									<input type="text" id="form-add-iname" name="dz4" />
								</label>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table5" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<label for="form-add-iname" style="margin: 1% 0;">商户:</label>
								<div id="fnr" style="margin-left: 10%;"></div>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table6" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<!-- <label for="form-add-iname" style="margin: 1% 0;">方案:
				<input type="text" id="form-add-iname" name="fn"  style="margin-left: 25px;"/></label> -->
								<label for="form-add-iname" style="margin: 1% 0;">方案:</label>
								<div id="fnn" style="margin-left: 10%;"></div>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table7" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<!-- <label for="form-add-iname" style="margin:1% 0;">商品:
				<input type="text" id="form-add-iname" name="sp" style="margin-left: 25px;"/></label> -->
								<label for="form-add-iname" style="margin: 1% 0;">商品:</label>
								<div id="fnc" style="margin-left: 10%;"></div>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table8" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<c:forEach items="${arrp}" var="arrp">
									<input type="text" value="${arrp.sid}" style="display: none">
									<input type="text" value="${arrp.sname}">
									<img src="${arrp.slogo }" style="width: 10%; height: 10%;" />
									<div style="margin: 5px 0; position: relative;">
										<input type="file" name="myfiles" />
									</div>
									<%-- <div>
										<input type="button" value="修改"
											onclick="updata(${arrp.sid},${list.ptype });"> <input
											type="button" value="删除"
											onclick="deleta(${arrp.sid},${list.ptype });">
									</div> --%>
								</c:forEach>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table9" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<c:forEach items="${arrs}" var="arrs">
									<input type="text" value="${arrs.sid}" style="display: none">
									<input type="text" value="${arrs.sname}">
									<img src="${arrs.simg }" style="width: 10%; height: 10%;" />
									<div style="margin: 5px 0; position: relative;">
										<input type="file" name="myfiles" />
									</div>
									<%-- <div>
										<input type="button" value="修改"
											onclick="updata(${arrs.sid},${list.ptype });"> <input
											type="button" value="删除"
											onclick="deleta(${arrs.sid},${list.ptype });">
									</div> --%>
								</c:forEach>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table10" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									name="psour" style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
									
								<c:forEach items="${arry}" var="arry">
									<input type="text" value="${arry.id}" style="display: none"
										id="tenid">
									<input type="text" value="${arry.pname}" name="tenname"
										id="tenname">
									
									<img src="${arry.img.url }" style="width: 10%; height: 10%;" />
									<div style="margin: 5px 0; position: relative;">
										<input type="file" name="myfiles" />
									</div>
									<%-- <div>
									    <input type="button" value="修改" onclick="updata(${arry.id},${list.ptype });">  
										<input type="button" value="删除" onclick="deleta(${arry.id},${list.ptype });">
									</div> --%>
								</c:forEach>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table11" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<div class="xttblog">
									<ul class="box">
										<li id="mm"></li>
									</ul>
								</div>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table12" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<div class="xttblog">
									<ul class="box">
										<li id="mn"></li>
									</ul>
								</div>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.sdate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div id="table13" style="display: none">
							<c:forEach items="${list}" var="list">
								<input type="text" value="${list.id }" id="id" name="id"
									style="display: none">
								<input type="text" value="${list.ptype }" id="ptype"
									style="display: none">
								<input type="text" value="${list.psource }" id="psource"
									style="display: none">
								<input type="text" value="${list.pzone }" id="pzone"
									style="display: none">
								<input type="text" value="${list.state }" id="state"
									style="display: none">
								<div class="xttblog">
									<ul class="box" id="mo">
										<li>
											<!--<img src="" id = "img1"  style="width: 100%;height: 100%;"/>
                      <span>  <input name="" type="button"  value="删除" onclick="deleta();" style="border:1px solid; 
                         border-radius:20px;background:#06C; font-size:14px; font-family: '微软雅黑'; color:#FFF;"/> 
                                                                              关于我们</span> -->
										</li>
									</ul>
								</div>
								<div style="margin: 1% 0;">
									<label for="form-idd-adate">生效日期: <input class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="stadate" value="${list.odate}" /></label> <label
										for="form-idd-adate" style="margin-left: 10%;">失效日期: <input
										class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										name="enddate" value="${list.odate}" /></label>
								</div>
							</c:forEach>
						</div>
						<div style="margin: 1% 0;">
							<input class="sub-btn fl" type="button" id="sub" name="Submit"
								value="编辑"> <input type="button" class="sub-btn fl"
								value="返回" onclick="javascript:history.go(-1);"
								style="margin-left: 1%;" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 基本脚本 -->
	<%@include file="../common/basic-scripts.jsp"%>
	<script src="${path}/assets/js/jquery-form.js"></script>

	<script
		src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>

	<%@include file="../common/ace-scripts.jsp"%>
</body>
<script type="text/javascript">
function deleta(id,ptype){
		$.ajax({
	        url:"delete",
	        data:{
	        	obj:ptype,
	        	id:id
	        	},
	        type:"POST",
	        dataType:"json",
        success:function(data){
        	if(data == 1){
        		document.getElementById("table1").style.display = "block";
        		window.location.reload();
        	}else if(data == 2){
        		document.getElementById("table2").style.display = "block";
        		window.location.reload();
        	}else if(data == 3){
        		document.getElementById("table3").style.display = "block";
        		window.location.reload();
        	}else if(data == 4){
        		document.getElementById("table4").style.display = "block";
        		window.location.reload();
        	}else if(data == 5){
        		document.getElementById("table5").style.display = "block";
        		window.location.reload();
        	}else if(data == 6){
        		document.getElementById("table6").style.display = "block";
        		window.location.reload();
        	}else if(data == 7){
        		document.getElementById("table7").style.display = "block";
        		window.location.reload();
        	}else if(data == 8){
        		document.getElementById("table8").style.display = "block";
        		window.location.reload();
        	}else if(data == 9){
        		document.getElementById("table9").style.display = "block";
        		window.location.reload();
        	}else if(data == 10){
        		document.getElementById("table10").style.display = "block";
        		window.location.reload();
        	}else if(data == 11){
        		document.getElementById("table11").style.display = "block";
        		window.location.reload();
        	}else if(data == 12){
        		document.getElementById("table12").style.display = "block";
        		window.location.reload();
        	}else {
        		document.getElementById("table13").style.display = "block";
        		window.location.reload();
        	}
        }
	})
}
	function updata(id,ptype) {
		$.ajax({
	        url:"updata",
	        data:{
	        	obj:ptype,
	        	id:id
	        	},
	        type:"POST",
	        dataType:"json",
        success:function(data){
        	if(data == 1){
        		document.getElementById("table1").style.display = "block";
        		window.location.reload();
        	}else if(data == 2){
        		document.getElementById("table2").style.display = "block";
        		window.location.reload();
        	}else if(data == 3){
        		document.getElementById("table3").style.display = "block";
        		window.location.reload();
        	}else if(data == 4){
        		document.getElementById("table4").style.display = "block";
        		window.location.reload();
        	}else if(data == 5){
        		document.getElementById("table5").style.display = "block";
        		window.location.reload();
        	}else if(data == 6){
        		document.getElementById("table6").style.display = "block";
        		window.location.reload();
        	}else if(data == 7){
        		document.getElementById("table7").style.display = "block";
        		window.location.reload();
        	}else if(data == 8){
        		document.getElementById("table8").style.display = "block";
        		window.location.reload();
        	}else if(data == 9){
        		document.getElementById("table9").style.display = "block";
        		window.location.reload();
        	}else if(data == 10){
        		document.getElementById("table10").style.display = "block";
        		window.location.reload();
        	}else if(data == 11){
        		document.getElementById("table11").style.display = "block";
        		window.location.reload();
        	}else if(data == 12){
        		document.getElementById("table12").style.display = "block";
        		window.location.reload();
        	}else {
        		document.getElementById("table13").style.display = "block";
        		window.location.reload();
        	}
        }
	})
	}


$("#sub").click(function() {
	$("#xiangmu").ajaxSubmit(function(data) {
		if (data == 1) {
			alert("失败");
			window.location.href = "${path}/promotion/edit";
		} else {
			alert("成功");
			window.location.href = "${path}/promotion/list";
		}
	});
});
$(function(){
	var data = document.getElementById("ptype").value;
		if (data == 1) {
			document.getElementById("table1").style.display = "block";
			//var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
			<c:forEach items="${arr}" var="arr">
				$("#mt").attr("src","${arr.url}");
				$("input[name='urll']").val("${arr.url}");
				$("input[name='wz']").val("${arr.words}");
				$("input[name='dz']").val("${arr.address}");
			    $("select[name='shopmore']").val("${arr.marking}");
            </c:forEach> 
			var url = document.getElementById("url").value;
			var words = document.getElementById("words").value;
			var address = document.getElementById("address").value;
			//var str= new Array();//定义一数组
				//str = psource.replace(/\[|]/g,'')//去中括号
				//str=str.replace("IU:","");
			//str = psource.split("#"); //字符分割
			//for (i=0;i<psource.length ;i++ )
			//{
				
				/* var y=str[i].indexOf(".");
				if(y=9){
					$("#mt").attr("src",str[i]);
					
				}else if(y<0){ 
					$("input[name='wz']").val(str[i]);
				}else{
					$("input[name='dz']").val(str[i]);
				} */
				
			//}
		} else if (data == 2) {
			document.getElementById("table2").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			for (i=0;i<str.length ;i++ )
			{
				var y=str[i].indexOf("www");
				if(y<0){
					$("#mr").attr("src",str[i]);
				}else{
				 $("input[name='dz2']").val(str[i]);
				}
			}
		} else if (data == 0) {
			document.getElementById("table2").style.display = "none";
			document.getElementById("table1").style.display = "none";
			document.getElementById("table3").style.display = "none";
			document.getElementById("table4").style.display = "none";
			document.getElementById("table5").style.display = "none";
			document.getElementById("table6").style.display = "none";
			document.getElementById("table7").style.display = "none";
			document.getElementById("table8").style.display = "none";
			document.getElementById("table9").style.display = "none";
			document.getElementById("table10").style.display = "none";
			document.getElementById("table11").style.display = "none";
			document.getElementById("table12").style.display = "none";
			document.getElementById("table13").style.display = "none";
		} else if (data == 3) {
			document.getElementById("table3").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ys']").val(state);
			$("select[name='ty']").val(data);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			for (i=0;i<str.length ;i++ )
			{
				var y=str[i].indexOf("www");
				if(y<0){
				 $("input[name='wz3']").val(str[i]);
				}else{
				 $("input[name='dz3']").val(str[i]);
				}
			}
		} else if (data == 4) {
			document.getElementById("table4").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ys']").val(state);
			$("select[name='ty']").val(data);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			for (i=0;i<str.length ;i++ )
			{
				 $("input[name='dz4']").val(str[i]);
			}
		} else if (data == 5) {
			document.getElementById("table5").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			var html = '';
			for (i=0;i<str.length ;i++ )
			{
				html +="<div><span><input type="+'"button"'+"value="+'"删除"'+"onclick="+'"deleta();"' +"style="+"'border:1px solid;margin-left: 5%;"+"border-radius:20px;"+"background:#06C;"
				+" font-size:14px;" +"color:#FFF;'" +"/>"+"<input id='topp' name='sh' type="+'"text"'+"value=" +str[i]+">"+"</span></div>"
				/*  $("input[name='sh']").val(str[i]); */
			}
			document.getElementById('fnr').innerHTML = html;
		} else if (data == 6) {
			document.getElementById("table6").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			var html = '';
			for (i=0;i<str.length ;i++ )
			{
				html +="<div><span><input type="+'"button"'+"value="+'"删除"'+"onclick="+'"deleta();"' +"style="+"'border:1px solid;margin-left: 5%;"+"border-radius:20px;"+"background:#06C;"
					+" font-size:14px;" +"color:#FFF;'" +"/>"+"<input id='topp' name='sp' type="+'"text"'+"value=" +str[i]+">"+"</span></div>"
				/*  $("input[name='fn']").val(str[i]); */
			}
			document.getElementById('fnn').innerHTML = html;
		} else if (data == 7) {
			document.getElementById("table7").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			var html = '';
			for (i=0;i<str.length ;i++ )
			{
				html +="<div><span><input type="+'"button"'+"value="+'"删除"'+"onclick="+'"deleta();"' +"style="+"'border:1px solid;margin-left: 5%;"+"border-radius:20px;"+"background:#06C;"
				+" font-size:14px;" +"color:#FFF;'" +"/>"+"<input id='topp' disabled='disabled' name='fn' type="+'"text"'+"style="+'"border-radius:20px;margin: 1% 0;"'+ "value=" +str[i]+">"+"</span></div>"
				/*  $("input[name='sp']").val(str[i]); */
			}
			document.getElementById('fnc').innerHTML = html;
		} else if (data == 8) {
			document.getElementById("table8").style.display = "block";
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
		} else if (data == 9) {
			document.getElementById("table9").style.display = "block";
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
		} else if (data == 10) {
			document.getElementById("table10").style.display = "block";
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			/* var str= new Array();//定义一数组
			str = document.getElementsByTagName("tenname");
			for(i=1;i<str.lenght;i++)
			{
				var tenna =  document.getElementById('tenna' + i);
				document.write(tenna.value)
			} */
			$("input[name='tenna']").val(tenname);
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
		} else if (data == 11) {
			document.getElementById("table11").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			var html = '';
			for (i=0;i<str.length ;i++ ){
				/*照片下面的删除按钮  */
			/* var patrn=/[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/gi; //判断是否存在中文
			if(patrn.exec(str[i])){ 
			var a = str[i]; 
			} */
				html +="<div class='lll'><img id='img' src='"+str[i]+  "'style=" + "width:" + "30%;" + "height:100%;"+ " />"+
				"<span><input  type="+'"button"'+"value="+'"删除"'+"onclick="+'"deleta();"' +"style="+"'border:1px solid;margin-left: 5%;"+"border-radius:20px;"+"background:#06C;"
				+" font-size:14px;" +"color:#FFF;'" +"/>"+"</span></div>";
			}
			document.getElementById('mm').innerHTML = html;
		} else if (data == 12) {
			document.getElementById("table12").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			var html = '';
			for (i=0;i<str.length ;i++ )
			{
				html +="<div class='lll'><img id='img' src='"+str[i]+  "'style=" + "width:" + "30%;" + "height:100%;"+ " />"+
				"<span><input  type="+'"button"'+"value="+'"删除"'+"onclick="+'"deleta();"' +"style="+"'border:1px solid;margin-left: 5%;"+"border-radius:20px;"+"background:#06C;"
				+" font-size:14px;" +"color:#FFF;'" +"/>"+"</span></div>";
			}
			document.getElementById('mn').innerHTML = html;
		} else {
			document.getElementById("table13").style.display = "block";
			var psource = document.getElementById("psource").value;
			var pzone = document.getElementById("pzone").value;
			var state = document.getElementById("state").value;
			$("input[name='bt']").val(pzone);
			$("select[name='ty']").val(data);
			$("select[name='ys']").val(state);
			var str= new Array();//定义一数组
			str = psource.split("#"); //字符分割
			var html = '';
			for (i=0;i<str.length ;i++ )
			{
				html +="<div class='lll'><img id='img' src='"+str[i]+  "'style=" + "width:" + "30%;" + "height:100%;"+ " />"+
				"<span><input  type="+'"button"'+"value="+'"删除"'+"onclick="+'"deleta();"' +"style="+"'border:1px solid;line-height:20px;border-radius:20px;background:#06C;font-size:14px;color:#FFF;'" 
				+"/></span></div>";
			}
			document.getElementById('mo').innerHTML = html;
		}

	})

	

	function showImage() {
		var docObj = document.getElementById("doc");
		var imgObjPreview = document.getElementById("preview");
		if (docObj.files && docObj.files[0]) {
			//火狐下，直接设img属性  
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '300px';
			imgObjPreview.style.height = '120px';
			//imgObjPreview.src = docObj.files[0].getAsDataURL();  
			//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式  
			imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		} else {
			//IE下，使用滤镜  
			docObj.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImag");
			//必须设置初始大小  
			localImagId.style.width = "250px";
			localImagId.style.height = "200px";
			//图片异常的捕捉，防止用户修改后缀来伪造图片 
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localImagId.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}
		return true;
	}
	function gradeChange(){
		var objS = document.getElementById("ty");
	    var grade = objS.options[objS.selectedIndex].value;
	    if(grade == 1){
	    	document.getElementById("table1").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 2 ){
	    	document.getElementById("table2").style.display="block";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 0){
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 3){
	    	document.getElementById("table3").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 4){
	    	document.getElementById("table4").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 5){
	    	document.getElementById("table5").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 6){
	    	document.getElementById("table6").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 7){
	    	document.getElementById("table7").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }
	    else if(grade == 8){
	    	document.getElementById("table8").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 9){
	    	document.getElementById("table9").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 10){
	    	document.getElementById("table10").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 11){
	    	document.getElementById("table11").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else if(grade == 12){
	    	document.getElementById("table12").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table13").style.display="none";
	    }else{
	    	document.getElementById("table13").style.display="block";
	    	document.getElementById("table2").style.display="none";
	    	document.getElementById("table1").style.display="none";
	    	document.getElementById("table3").style.display="none";
	    	document.getElementById("table4").style.display="none";
	    	document.getElementById("table5").style.display="none";
	    	document.getElementById("table6").style.display="none";
	    	document.getElementById("table7").style.display="none";
	    	document.getElementById("table8").style.display="none";
	    	document.getElementById("table9").style.display="none";
	    	document.getElementById("table10").style.display="none";
	    	document.getElementById("table11").style.display="none";
	    	document.getElementById("table12").style.display="none";
	    }
	    
	}
</script>

</html>

