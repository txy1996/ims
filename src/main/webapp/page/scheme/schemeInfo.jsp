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
  	left:482px;
  	top:-58px;
  }
  .sstate{
  	position: relative;
  	left:359px;
  	top:-32px;
  }
.urid{
		position: relative;
		left:258px;
  	top:-7px;
}
</style>


<body class="no-skin">
<header>
		<h1 style="line-height: 50px;">方案信息详情列表</h1>
	</header>

	<section id="cd-timeline" class="cd-container">
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				
			</div><!-- cd-timeline-img -->
			<div class="cd-timeline-content">
				<h2>${schemeIo.sname}</h2>
				<p style="margin-left: 88px;margin-top: -27px;color:red;">赞：${schemeIo.spraise}</p>
				<p style="margin-left: 140px;margin-top: -30px;color:red;">踩：${schemeIo.soppose}</p>
				<p>${schemeIo.sinfo}</p>
				<a href="getStage?id=${schemeIo.sid }" class="cd-read-more">点击查看阶段信息</a>
				<span class="cd-date">创建时间：
				<fmt:formatDate value="${schemeIo.sdate}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
				</span>
				<span class="scid">所属分类：${schemeIo.scheme_class.scname}</span>
				<span class="sstate">方案状态：
                      <c:if test="${schemeIo.sstate==0}"><span class="label label-sm label-warning">预览</span></c:if>
                      <c:if test="${schemeIo.sstate==1}"><span class="label label-sm label-success">预审</span></c:if>
                      <c:if test="${schemeIo.sstate==2}"><span class="label label-sm label-inverse">公开</span></c:if>
                      <c:if test="${schemeIo.sstate==3}"><span class="label label-sm label-inverse">过期</span></c:if>
				</span>
				<span class="urid">创建人：&nbsp;&nbsp;&nbsp;${schemeIo.user.urtname}</span>
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
