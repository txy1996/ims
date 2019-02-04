<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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

    <!-- 这里是本页内联样式开始 -->
    <!-- 这里是本页内联样式结束 -->

    <%@include file="../common/assets-js.jsp" %>
</head>

<body class="no-skin">
<%--top导航栏--%>

<div class="main-container ace-save-state" id="main-container">

    <%--main-content内容--%>
    <div class="main-content">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">广告列表</a>
                    </li>
                    <li class="active">新增广告</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        新增广告
                    </h1>
                </div>
                <form action="filesUpload" method="post" name="xiangmu" id="xiangmu"
                      enctype="multipart/form-data">
                    <div>
                        位置标题:
                        <input type="text" name="bt">
                        <label for="form-add-iname" style="margin-left: 10%;">表现类型:
                            <select name="ty" onchange="gradeChange();" id="ty">
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
                            </select></label>
                        <label for="form-add-iname" style="margin-left: 10%;">状态:
                            <select name="ys">
                                <option value="0">预审</option>
                                <option value="1">发布</option>
                                <option value="2">下架</option>
                            </select></label>
                    </div>
                    <div id="table1" style="display: none">
                        <label>图片1<span style="color: #F00">*</span></label>
                        <div>
                            <input type=file name="myfiles" id="doc" onchange="showImage();">
                            <div style="margin: 1% 0;">
                                文字内容:
                                <input type="text" id="form-add-iname" name="woz"/>
                                <label for="form-add-iname" style="margin-left: 10%;">
                                    链接地址:
                                    <select name="shopmore">
                                        <option value="URL">纯URL</option>
                                        <option value="S:">商户详情</option>
                                        <option value="F:">方案详情</option>
                                        <option value="P:">产品详情</option>
                                        <option value="LS:">商户列表</option>
                                        <option value="LF:">方案列表</option>
                                        <option value="LP:">产品列表</option>
                                    </select>
                                    <input type="text" id="form-add-iname" name="doz"/></label>
                            </div>
                        </div>
                        <div id="localImag" style="position: absolute; left: 25%; top: 5%">
                            <img id="preview" width=-1 height=-1 style="diplay: none"/>
                        </div>

                        <label>图片2<span style="color: #F00">*</span></label>
                        <div style="margin: 5px 0; position: relative;">
                            <input type="file" name="myfiles" id="doc1">
                            <div style="margin: 1% 0;">
                                文字内容:
                                <input type="text" id="form-add-iname" name="wtz"/>
                                <label for="form-add-iname" style="margin-left: 10%;">
                                    链接地址:
                                    <select name="shopmore1">
                                        <option value="URL">纯URL</option>
                                        <option value="S:">商户详情</option>
                                        <option value="F:">方案详情</option>
                                        <option value="P:">产品详情</option>
                                        <option value="LS:">商户列表</option>
                                        <option value="LF:">方案列表</option>
                                        <option value="LP:">产品列表</option>
                                    </select>
                                    <input type="text" id="form-add-iname" name="dtz"/></label>
                            </div>
                        </div>

                        <label>图片3<span style="color: #F00">*</span></label>
                        <div style="margin: 5px 0; position: relative;">
                            <input type="file" name="myfiles"/>
                            <div style="margin: 1% 0;">
                                文字内容:
                                <input type="text" id="form-add-iname" name="wz"/>
                                <label for="form-add-iname" style="margin-left: 10%;">
                                    链接地址:
                                    <select name="shopmore2">
                                        <option value="URL">纯URL</option>
                                        <option value="S:">商户详情</option>
                                        <option value="F:">方案详情</option>
                                        <option value="P:">产品详情</option>
                                        <option value="LS:">商户列表</option>
                                        <option value="LF:">方案列表</option>
                                        <option value="LP:">产品列表</option>
                                    </select>
                                    <input type="text" id="form-add-iname" name="dz"/></label>
                            </div>
                        </div>
                    </div>

                    <div id="table2" style="display: none;">

                        <label>图片1<span style="color: #F00">*</span></label>
                        <div style="margin: 5px 0; position: relative;">
                            <input type=file name="myfiles" id="doc2" onchange="showImage1();">


                            链接地址:
                            <select name="shops">
                                <option value="URL">纯URL</option>
                                <option value="S:">商户详情</option>
                                <option value="F:">方案详情</option>
                                <option value="P:">产品详情</option>
                                <option value="LS:">商户列表</option>
                                <option value="LF:">方案列表</option>
                                <option value="LP:">产品列表</option>
                            </select>
                            <input type="text" id="form-add-iname" name="tu" placeholder="内容" style="margin: 1% 0;"/>
                        </div>
                        <div id="localImag" style="position: absolute; left: 25%; top: 5%">
                            <img id="preview1" width=-1 height=-1 style="diplay: none"/>
                        </div>

                        <label>图片2<span style="color: #F00">*</span></label>
                        <div style="margin: 5px 0; position: relative;">
                            <input type="file" name="myfiles" id="doc1">

                            链接地址:
                            <select name="shops1">
                                <option value="URL">纯URL</option>
                                <option value="S:">商户详情</option>
                                <option value="F:">方案详情</option>
                                <option value="P:">产品详情</option>
                                <option value="LS:">商户列表</option>
                                <option value="LF:">方案列表</option>
                                <option value="LP:">产品列表</option>
                            </select>

                            <input type="text" id="form-add-iname" name="tp" placeholder="内容" style="margin: 1% 0;"/>
                        </div>

                        <label>图片3<span style="color: #F00">*</span></label>
                        <div style="margin: 5px 0; position: relative;">
                            <input type="file" name="myfiles"/>

                            链接地址:
                            <select name="shops2">
                                <option value="URL">纯URL</option>
                                <option value="S:">商户详情</option>
                                <option value="F:">方案详情</option>
                                <option value="P:">产品详情</option>
                                <option value="LS:">商户列表</option>
                                <option value="LF:">方案列表</option>
                                <option value="LP:">产品列表</option>
                            </select>

                            <input type="text" id="form-add-iname" name="dz2" placeholder="内容" style="margin: 1% 0;"/>
                        </div>

                    </div>

                    <div id="table3" style="display: none">
                        <div style="margin: 1% 0">
                            文字内容:
                            <input type="text" id="form-add-iname" name="wz3" placeholder="文字内容"/>
                            <label for="form-add-iname" style="margin-left: 10%;">链接地址:
                                <input type="text" id="form-add-iname" name="dz3" placeholder="链接地址"/></label>
                        </div>
                    </div>
                    <div id="table4" style="display: none">
                        <label>视频<span style="color: #F00">*</span></label>
                        <div style="margin: 5px 0; position: relative;">
                            <input type="file" name="myfiles"/>
                        </div>
                        <label for="form-add-iname" style="margin: 1% 0">链接地址:
                            <input type="text" id="form-add-iname" name="dz4" placeholder="链接地址"/></label>
                    </div>


                    <div id="table5" style="display: none;">

                    </div>

                    <div id="table6" style="display: none">
                        <!-- <label for="form-add-iname" style="margin: 1% 0;">方案:
                        <input type="text" id="form-add-iname" name="fn" placeholder="方案" style="margin-left: 23px;"/></label> -->
                    </div>
                    <div id="table7" style="display: none">
                        <!-- <label for="form-add-iname" style="margin: 1% 0;">商品:
                        <input type="text" id="form-add-iname" name="sp" placeholder="商品" style="margin-left: 23px;"/></label> -->
                    </div>
                    <div id="table8" style="display: none">

                        <!-- <label>图片<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label for="form-add-iname" style="margin: 1% 0;">商户:
                                <input type="text" id="form-add-iname" name="tsh" placeholder="商户" style="margin-left: 23px;"/></label> -->
                    </div>
                    <div id="table9" style="display: none">

                        <!-- <label>图片<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label for="form-add-iname" style="margin: 1% 0;">方案:
                                <input type="text" id="form-add-iname" name="tfn" placeholder="方案" style="margin-left: 23px;"/></label> -->
                    </div>
                    <div id="table10" style="display: none">

                        <!-- <label>图片<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label for="form-add-iname" style="margin: 1% 0;">商品:
                                <input type="text" id="form-add-iname" name="tsp" placeholder="商品" style="margin-left: 23px;"/></label> -->
                    </div>
                    <div id="table11" style="display: none">
                        <!-- <label>图片1<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label>图片2<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label>图片3<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div> -->
                    </div>
                    <div id="table12" style="display: none">
                        <!-- <label>方案图片1<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label>方案图片2<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label>方案图片3<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div> -->
                    </div>
                    <div id="table13" style="display: none">
                        <!-- <label>商品图片1<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label>商品图片2<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div>
                                <label>商品图片3<span style="color: #F00">*</span></label>
                                <div style="margin: 5px 0; position: relative;">
                                    <input type="file" name="myfiles" />
                                </div> -->
                    </div>
                    <div style="margin: 2% 0;display: none;" id="falg">
                        生效日期:
                        <input class="Wdate"
                               onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="stadate"/>
                        <label for="form-add-iname" style="margin-left: 10%;">失效日期:
                            <input class="Wdate"
                                   onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="enddate"/></label>
                        <label for="form-add-iname" style="margin-left: 10%;"><input class="sub-btn fl" type="button"
                                                                                     id="sub" name="Submit" value="提　交"></label>
                    </div>
                    <div style="margin: 2% 0;display: none;" id="falg1">
                        生效日期:
                        <input class="Wdate"
                               onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="stadate1"/>
                        <label for="form-add-iname" style="margin-left: 10%;">失效日期:
                            <input class="Wdate"
                                   onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="enddate1"/></label>
                        <button type="button" class="btn btn-primary btn-xs show-add-form sub-btn fl"
                                data-toggle="modal" data-target="#exampleModal1" style="margin-left: 10%;"
                                data-html="true" id="sub1" name="Submit">提　交
                        </button>
                    </div>

                </form>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
    <%--footer部分--%>
    <%@include file="../common/footer.jsp" %>
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
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">取消
                    </button>
                    <button type="button" class="btn btn-primary save1"
                            data-dismiss="modal" onclick="sh();"> 点击推荐
                    </button>
                </div>

            </div>
        </div>
    </div>
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- 基本脚本 -->
<%@include file="../common/basic-scripts.jsp" %>

<script type="text/javascript">
    /* 查询广告id */
    function sh() {
        var objS = document.getElementById("ty");
        var grade = objS.options[objS.selectedIndex].value;
        if (grade == 5 || grade == 8 || grade == 11) {
            $.ajax({
                type: "POST",
                dataType: "json",
                async: false,
                url: "${path}/promotion/inquire",
                data: {
                    id: grade,
                },
                success: function (id) {
                    shop(id); //商户推荐
                },
            });
        } else if (grade == 7 || grade == 10 || grade == 13) {
            $.ajax({
                type: "POST",
                dataType: "json",
                async: false,
                url: "${path}/promotion/inquire",
                data: {
                    id: grade,
                },
                success: function (id) {
                    product(id); //商品推荐
                },
            });
        } else {
            $.ajax({
                type: "POST",
                dataType: "json",
                async: false,
                url: "${path}/promotion/inquire",
                data: {
                    id: grade,
                },
                success: function (id) {
                    scheme(id); //方案推荐
                },
            });
        }

    }

    function shop(id) {
        $.ajax({
            type: "post",
            dataType: "text",
            data: {
                id: id,
            },
            url: '${path}/shop/list',//目标地址
            success: function (data) {
                location.href = "${path}/shop/list?id=" + id;
            },
        })
    }

    function product(id) {

        location.href = "${path}/product/selectProduct?id=" + id;
    }

    function scheme(id) {
                location.href = "${path}/scheme/list?scid=" + id;
    }
</script>
<!-- 页面特殊插件脚本 -->
<script src="${path}/assets/js/jquery-form.js"></script>
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

<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
<script src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>
<!-- 与此页相关的内联脚本 -->
<script src="${path}/assets/custom-js/promotion/pro.js"></script>
<script type="text/javascript">
    function gradeChange() {
        var objS = document.getElementById("ty");
        var grade = objS.options[objS.selectedIndex].value;
        if (grade == 1) {
            document.getElementById("table1").style.display = "block";
            document.getElementById("table2").style.display = "none";
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
            document.getElementById("falg").style.display = "block";
            document.getElementById("falg1").style.display = "none";
        } else if (grade == 2) {
            document.getElementById("table2").style.display = "block";
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
            document.getElementById("falg").style.display = "block";
            document.getElementById("falg1").style.display = "none";
        } else if (grade == 0) {
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
        } else if (grade == 3) {
            document.getElementById("table3").style.display = "block";
            document.getElementById("table2").style.display = "none";
            document.getElementById("table1").style.display = "none";
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
            document.getElementById("falg").style.display = "block";
            document.getElementById("falg1").style.display = "none";
        } else if (grade == 4) {
            document.getElementById("table4").style.display = "block";
            document.getElementById("table2").style.display = "none";
            document.getElementById("table1").style.display = "none";
            document.getElementById("table3").style.display = "none";
            document.getElementById("table5").style.display = "none";
            document.getElementById("table6").style.display = "none";
            document.getElementById("table7").style.display = "none";
            document.getElementById("table8").style.display = "none";
            document.getElementById("table9").style.display = "none";
            document.getElementById("table10").style.display = "none";
            document.getElementById("table11").style.display = "none";
            document.getElementById("table12").style.display = "none";
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg").style.display = "block";
            document.getElementById("falg1").style.display = "none";
        } else if (grade == 5) {
            document.getElementById("table5").style.display = "block";
            document.getElementById("table2").style.display = "none";
            document.getElementById("table1").style.display = "none";
            document.getElementById("table3").style.display = "none";
            document.getElementById("table4").style.display = "none";
            document.getElementById("table6").style.display = "none";
            document.getElementById("table7").style.display = "none";
            document.getElementById("table8").style.display = "none";
            document.getElementById("table9").style.display = "none";
            document.getElementById("table10").style.display = "none";
            document.getElementById("table11").style.display = "none";
            document.getElementById("table12").style.display = "none";
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        } else if (grade == 6) {
            document.getElementById("table6").style.display = "block";
            document.getElementById("table2").style.display = "none";
            document.getElementById("table1").style.display = "none";
            document.getElementById("table3").style.display = "none";
            document.getElementById("table4").style.display = "none";
            document.getElementById("table5").style.display = "none";
            document.getElementById("table7").style.display = "none";
            document.getElementById("table8").style.display = "none";
            document.getElementById("table9").style.display = "none";
            document.getElementById("table10").style.display = "none";
            document.getElementById("table11").style.display = "none";
            document.getElementById("table12").style.display = "none";
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        } else if (grade == 7) {
            document.getElementById("table7").style.display = "block";
            document.getElementById("table2").style.display = "none";
            document.getElementById("table1").style.display = "none";
            document.getElementById("table3").style.display = "none";
            document.getElementById("table4").style.display = "none";
            document.getElementById("table5").style.display = "none";
            document.getElementById("table6").style.display = "none";
            document.getElementById("table8").style.display = "none";
            document.getElementById("table9").style.display = "none";
            document.getElementById("table10").style.display = "none";
            document.getElementById("table11").style.display = "none";
            document.getElementById("table12").style.display = "none";
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        }
        else if (grade == 8) {
            document.getElementById("table8").style.display = "block";
            document.getElementById("table2").style.display = "none";
            document.getElementById("table1").style.display = "none";
            document.getElementById("table3").style.display = "none";
            document.getElementById("table4").style.display = "none";
            document.getElementById("table5").style.display = "none";
            document.getElementById("table6").style.display = "none";
            document.getElementById("table7").style.display = "none";
            document.getElementById("table9").style.display = "none";
            document.getElementById("table10").style.display = "none";
            document.getElementById("table11").style.display = "none";
            document.getElementById("table12").style.display = "none";
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        } else if (grade == 9) {
            document.getElementById("table9").style.display = "block";
            document.getElementById("table2").style.display = "none";
            document.getElementById("table1").style.display = "none";
            document.getElementById("table3").style.display = "none";
            document.getElementById("table4").style.display = "none";
            document.getElementById("table5").style.display = "none";
            document.getElementById("table6").style.display = "none";
            document.getElementById("table7").style.display = "none";
            document.getElementById("table8").style.display = "none";
            document.getElementById("table10").style.display = "none";
            document.getElementById("table11").style.display = "none";
            document.getElementById("table12").style.display = "none";
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        } else if (grade == 10) {
            document.getElementById("table10").style.display = "block";
            document.getElementById("table2").style.display = "none";
            document.getElementById("table1").style.display = "none";
            document.getElementById("table3").style.display = "none";
            document.getElementById("table4").style.display = "none";
            document.getElementById("table5").style.display = "none";
            document.getElementById("table6").style.display = "none";
            document.getElementById("table7").style.display = "none";
            document.getElementById("table8").style.display = "none";
            document.getElementById("table9").style.display = "none";
            document.getElementById("table11").style.display = "none";
            document.getElementById("table12").style.display = "none";
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        } else if (grade == 11) {
            document.getElementById("table11").style.display = "block";
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
            document.getElementById("table12").style.display = "none";
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        } else if (grade == 12) {
            document.getElementById("table12").style.display = "block";
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
            document.getElementById("table13").style.display = "none";
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        } else {
            document.getElementById("table13").style.display = "block";
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
            document.getElementById("falg1").style.display = "block";
            document.getElementById("falg").style.display = "none";
        }

    }


    $("#sub").click(function () {
        $("#xiangmu").ajaxSubmit(function (data) {
            if (data == 1) {
                alert("失败-请填写正确数据");
                window.location.href = "${path}/promotion/addp";
            } else {
                alert("成功");
                window.location.href = "${path}/promotion/list";
            }
        });
    });

    $("#sub1").click(function () {
        $("#xiangmu").ajaxSubmit(function (data) {
            if (data == 1) {
                alert("失败-请填写正确数据");
                window.location.href = "${path}/promotion/addp";
            }
            /* else{
                    alert("成功");
                    window.location.href = "
            ${path}/promotion/list";
    	} */
        });
    });


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

    function showImage1() {
        var docObj = document.getElementById("doc2");
        var imgObjPreview = document.getElementById("preview1");
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
</script>
</body>
</html>
