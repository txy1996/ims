<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>用户管理</title>
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
	<link rel="stylesheet" href="${path}/assets/css/timeline.css"/>
    <!-- 这里是本页内联样式开始 -->
    <!-- 这里是本页内联样式结束 -->
    <%@include file="../common/assets-js.jsp" %>
</head>
<style>
 .scid{
  	position: relative;
  	left:442px;
  	top:-60px;
  }
  .sstate{
  	position: relative;
  	left:359px;
  	top:-32px;
  }
.urid{
		position: relative;
		left:260px;
  	top:-35px;
}
.cisood{
	position: relative;
	left:440px;
	top:-31px;
}
.crefund{
		position: relative;
	left:560px;
	top:-27px;
}
</style>


<body class="no-skin">
<header>
		<h1 style="line-height: 50px;">优惠券信息详情列表</h1>
	</header>

	<section id="cd-timeline" class="cd-container">
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
			</div><!-- cd-timeline-img -->
			<div class="cd-timeline-content">
				<h2>${coupon.ctitle}</h2>
				<p style="margin-left: 88px;margin-top: -27px;color:red;">折扣率：${coupon.cdiscount}</p>
				<p style="margin-left: 190px;margin-top: -30px;color:red;">金额：${coupon.csum}</p>
				<p style="margin-left: 265px;margin-top: -30px;color:red;">进货价：${coupon.cmoney}</p>
				<p style="margin-left: 350px;margin-top: -30px;color:red;">销售价：${coupon.cprice}</p>
				<p>${coupon.cinfo}</p>
				<a href="getStage?id=${schemeIo.sid }" class="cd-read-more">修改优惠券信息</a>
				<span class="cd-date">起始时间：${coupon.csdate}</span>
				<span class="scid">终止时间：${coupon.codate}</span>
				<%-- <span class="sstate">方案状态：${coupon.codate}</span> --%>
				<span class="urid">优惠券分类：
				  <c:if test="${empty coupon.crange}">
				  <span class="label label-sm label-primary">-</span></c:if>
                   <c:if test="${coupon.crange=='all'}">
                   <span class="label label-sm label-warning">全站</span>
                   </c:if>
                   <c:if test="${coupon.crange=='p:1'}">
                   <span class="label label-sm label-success">品牌店</span></c:if>
                   <c:if test="${coupon.crange=='s:1'}">
                   <span class="label label-sm label-inverse">单店</span></c:if>
				</span>
				<div class="cisood">是否找零：
				<c:if test="${coupon.cisood==0 || coupon.cisood==null}">
				<span class="label label-sm label-warning ">否</span></c:if>
                 <c:if test="${coupon.cisood==1}">
                 <span class="label label-sm label-success ">是</span></c:if>
				</div>
				<span class="crefund">成长度数量：${coupon.cintegration }</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->
	</section> <!-- cd-timeline -->
<%--top导航栏--%>

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
<script src="${path}/assets/js/modernizr.js"></script>
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
<script src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>

</body>
<script>
$(function(){
	var $timeline_block = $('.cd-timeline-block');
	//hide timeline blocks which are outside the viewport
	$timeline_block.each(function(){
		if($(this).offset().top > $(window).scrollTop()+$(window).height()*0.75) {
			$(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden');
		}
	});
	//on scolling, show/animate timeline blocks when enter the viewport
	$(window).on('scroll', function(){
		$timeline_block.each(function(){
			if( $(this).offset().top <= $(window).scrollTop()+$(window).height()*0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) {
				$(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
			}
		});
	});
});
</script>

</html>
