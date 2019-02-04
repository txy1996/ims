<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/global.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <title>方案详情</title>
    <%@include file="../common/meta.jsp" %>
    <%@include file="../common/assets-css.jsp" %>

    <!-- 页面特殊插件样式 -->
    <link rel="stylesheet"
          href="${path}/assets/css/jquery-ui.custom.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/chosen.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/bootstrap-datepicker3.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/bootstrap-timepicker.min.css"/>
    <link rel="stylesheet" href="${path}/assets/css/daterangepicker.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/bootstrap-colorpicker.min.css"/>
    <link rel="stylesheet"
          href="${path}/assets/css/paging.css"/>


    <link rel="stylesheet" type="text/css"
          href="../assets/css/bootstrap-tagsinput.css"/>
    <!-- 这里是本页内联样式结束 -->
    <%@include file="../common/assets-js.jsp" %>
</head>
<style>
    .schemeinfo {
        font-size: 15px;
        display: block;
        float: left;
        margin: 0 30px 0 0;
    }

    .info {
        display: block;
        height: 50px
    }

    .imageDiv {
        width: 140px;
        height: auto;
        text-align: center;
        float: left;
        margin: 0 30px 0 0;
    }

    .schemeNamediv {
        width: auto;
        height: auto;
        float: left;
    }

    .stagediv {
        width: auto;
        height: auto;
        float: left;
    }

    .newbutton {
        background-color: rgb(92, 184, 92);
        color: rgb(255, 255, 255);
    }

    .labelinput {
        width: 550px;
        height: 100px;
        border: 1px solid blue;
    }

    .sapnwidth {
        width: 100%;
    }

    .addandupdatediv {
        width: 550px;
        height: 500px;
    }

    .shoplabel {
        display: block;
        width: 100%;
    }

    .alternativeshop {
        width: 40%;
        margin: 0 0 0 5%;
    }

    .img {
        width: 140px;
        height: 140px;
    }

    .container {
        height: auto;
        position: relative;
        margin: 0 auto;
        width: 100%;
        padding-right: 0px;
        padding-left: 0px;
    }

    .nav {
        position: absolute;
        width: 83%;
        top: 100%;
        z-index: 9999;
        overflow-y: auto;
        overflow-x: auto;
        height: 150px;
    }

    .num-css {
        /*width: 10%;*/
    }

    /* * {
        font-family: "sta cartman", "开心软件黑体简体", "开心软件二黑简体", sans-serif
    } */


</style>


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
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">方案详情</a>
                    </li>
                    <li class="active">方案详情</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <table id=""
                           class="table  table-bordered  ">
                        <tbody class="user-tbody">
                        <tr>
                            <td>
                                <h1 style="display: block; float: left; margin: 10px 0 0 20px;">
                                    方案名:${schemeResponse.sname }</h1>
                                <input type="hidden" value="${schemeResponse.sid}" id="sid"
                                       class="sid">
                                <button class="btn  btn-success show-add-form" type="submit"
                                        data-toggle="modal" data-target="#user-form-div"
                                        style="margin: 0 0 0 20px;">添加阶段
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class=" schemeinfo">所属分类:${schemeResponse.scname }</span>
                                <c:if test="${empty schemeResponse.sstate}">
                                    <span class="label label-sm label-primary schemeinfo">状态:-</span>
                                </c:if> <c:if test="${schemeResponse.sstate==0}">
                                <span class="label label-sm label-warning schemeinfo">状态:预览</span>
                            </c:if> <c:if test="${schemeResponse.sstate==1}">
                                <span class="label label-sm label-success schemeinfo">状态:预审</span>
                            </c:if> <c:if test="${schemeResponse.sstate==2}">
                                <span class="label label-sm label-inverse schemeinfo">状态:公开</span>
                            </c:if> <c:if test="${schemeResponse.sstate==3}">
                                <span class="label label-sm label-inverse schemeinfo">状态:过期</span>
                            </c:if> <span class="schemeinfo">创建时间:${schemeResponse.sdate }</span> <span
                                    class="schemeinfo">创建人:${schemeResponse.username }</span> <span
                                    class="label label-success schemeinfo">赞:${schemeResponse.spraise }</span>
                                <span class="label label-danger schemeinfo">踩:${schemeResponse.soppose }</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class="label  schemeinfo">适合人数:${schemeResponse.spnum }</span>
                                <span class="label  schemeinfo">方案时长:${schemeResponse.sduration }</span>
                                <span class="label  schemeinfo">场地位置:${schemeResponse.srange }</span>
                                <span class="label  schemeinfo">方案预算:${schemeResponse.sprice }</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class="label label-info">方案介绍:</span>${schemeResponse.sinfo }
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="imageDiv">
                                    <img src="${schemeResponse.simg}" alt="..."
                                         class="img-rounded img-responsive center-block"
                                         style="width: 140px; height: 140px;">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <c:set
                                        value="${schemeResponse.lsnum}" var="lsnum"/> <c:set
                                    value="${fn:split(fn:replace(fn:replace(lsnum,']',''),'[',''),',')}"
                                    var="lsnums"/> <c:set var="ualabels"
                                                          value="${schemeResponse.labels}"/> <c:if
                                    test="${ not empty ualabels}">
                                <c:forEach var="label"
                                           items="${fn:split(fn:replace(fn:replace(ualabels,']',''),'[',''),',')}"
                                           varStatus="loop">
                                    <button type="button"
                                            class=" btn btn-default btn-xs btn-primary disabled"
                                            style="margin: 0 0 0 0;">
                                            ${label}<span class="badge">${lsnums[loop.count-1]}</span>
                                    </button>
                                </c:forEach>
                            </c:if>
                            </td>
                        </tr>
                        </tbody>
                    </table>


                </div>
                <!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12" id="add1">
                                <table id="simple-table"
                                       class="table  table-bordered  user-list">
                                    <tbody class="user-tbody">
                                    <c:forEach items="${responses}" var="stage">
                                        <tr>
                                            <td class="ssname"><input type="hidden"
                                                                      value="${stage.ssname}" class="stagessname">
                                                <input
                                                        type="hidden" value="${stage.ssid}" class="ssid">
                                                <input type="hidden" value="${stage.ssinfo}"
                                                       class="ssinfo"> <input type="hidden"
                                                                              value="${stage.sname}" class="sname">
                                                <input
                                                        type="hidden" value="${stage.shopid}" class="shopid">
                                                <input type="hidden" value="${stage.slogo}" class="slogo">
                                                <input type="hidden" value="${stage.lssid}" class="lssid">
                                                <input type="hidden" value="${stage.sssid}" class="sssid">

                                                <h3 style="display: block; float: left;">${stage.ssname}</h3>
                                                <button class="btn btn-success show-update-form"
                                                        data-toggle="modal" data-target="#user-form-div"
                                                        style="margin: 10px 0 0 20px;">编辑阶段
                                                </button>
                                                <button class="btn btn-danger delete-schemestage"
                                                        style="margin: 10px 0 0 20px;">删除阶段
                                                </button>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td class="ssinfo"><span class="label label-info">阶段介绍:</span>&nbsp;&nbsp;&nbsp;&nbsp;${stage.ssinfo}
                                            </td>
                                        </tr>
                                        <tr>
                                            <c:if test="${ not empty stage.labels}">
                                                <td colspan='10'><c:set value="${stage.lsnum}"
                                                                        var="lsnum"/> <c:set
                                                        value="${fn:split(fn:replace(fn:replace(lsnum,']',''),'[',''),',')}"
                                                        var="lsnums"/> <c:set var="ualabels"
                                                                              value="${stage.labels}"/> <c:forEach
                                                        var="label"
                                                        items="${fn:split(fn:replace(fn:replace(ualabels,']',''),'[',''),',')}"
                                                        varStatus="loop">
                                                    <button type="button"
                                                            class="btn btn-default btn-xs btn-primary disabled">
                                                            ${label}<span class="badge">${lsnums[loop.count-1]}</span>
                                                    </button>
                                                </c:forEach></td>
                                            </c:if>
                                        </tr>


                                        <c:forEach items="${shopGoods}" var="shopGoods">
                                            <c:set var="ssid" value="${stage.ssid }"/>
                                            <c:if test="${shopGoods.ssid ==ssid}">
                                                <c:if test="${not empty shopGoods.sname}">
                                                    <tr>
                                                        <td><h4>商家名称: ${shopGoods.sname}</h4> <h4>
                                                            联系方式: ${shopGoods.stel}</h4></td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <div class="row">
                                                                <c:forEach items="${shopGoods.stageGoodsResponses}"
                                                                           var="Goods">
                                                                    <div class="col-sm-6 col-md-2 Refresh">
                                                                        <div class="thumbnail">
                                                                            <div><span
                                                                                    class="label label-primary shoplabel">${Goods.pname}</span>
                                                                            </div>
                                                                            <img src="${Goods.url}" alt="正在加载..."
                                                                                 class="img-rounded img-responsive center-block"
                                                                                 style="width: 140px; height: 140px; ">
                                                                            <span class="label label-danger shoplabel"><s>原价:${Goods.price}</s></span>
                                                                            <span class="label label-success shoplabel">优惠价:${Goods.yprice}</span>
                                                                            <span class="label label-info shoplabel">数量:${Goods.num}</span>
                                                                        </div>
                                                                    </div>
                                                                </c:forEach>
                                                            </div>
                                                        </td>

                                                    </tr>

                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                    </tbody>
                                </table>


                            </div>
                            <!-- /.span -->

                        </div>
                        <!-- /.row -->


                        <!--添加、更新用户表单（二合一）-->
                        <div class="modal fade" id="user-form-div" tabindex="-1"
                             role="dialog" aria-labelledby="mySmallModalLabel">
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
                                                    <input type="hidden" name="id" class="form-control">
                                                    <div class="form-group addandupdatediv">
                                                        <div class="input-group">
                                                            <span class="input-group-addon">阶段名称</span> <input
                                                                type="text" class="form-control" id="stagename"
                                                                name="ssname" placeholder="请输入阶段名称..."
                                                                aria-describedby="basic-addon1">
                                                        </div>

                                                        <div class=" input-group  container"
                                                             style="margin: 25px 0 0 0;">
                                                            <span class="input-group-addon "
                                                                  id="biq">标签分类:</span>
                                                            <input type="hidden" id="pids" name="pids">
                                                            <input type="hidden" id="goodsId" name="goods">
                                                            <input type="hidden" id="goodsNum" name="goods">
                                                            <input type="hidden" id="pnumber" name="pnumber">
                                                            <input type="hidden" id="stageId" name="ssid">
                                                            <%--<input type="hidden" id="goodsId" name="goodsId">--%>
                                                            <%--<input type="hidden" id="goodsNum" name="goodsNum">--%>
                                                            <input type="hidden" class="form-control" id="labellid"
                                                                   name="labellid"> <input type="hidden"
                                                                                           class="form-control"
                                                                                           id="lssids" name="lssids">
                                                            <input type="hidden" class="form-control" id="sssid"
                                                                   name="sssid"> <input type="hidden"
                                                                                        class="form-control"
                                                                                        id="schemesid" name="sid">
                                                            <input type="hidden" class="form-control" id="sreplace"
                                                                   name="sreplace"> <input type="hidden" value=""
                                                                                           class="newLabelids"
                                                                                           name="newLabelids"
                                                        >
                                                            <input type="hidden" value="" class="oldLabelids"
                                                                   name="oldLabelids"> <input
                                                                type="text" id="txt_departmentname"
                                                                class="form-control" value="" style="width: 100%"
                                                                aria-describedby="basic-addon1"
                                                                onclick="$('#treeview').show()" placeholder="选择分类...">
                                                            <div class="nav" id="treeview" style="display: none;"></div>
                                                        </div>

                                                        <div class="input-group tagsinput-primary form-group"
                                                             style="margin: 25px 0 0 0;">
                                                            <input type="hidden" value="" id="newLabelids"
                                                                   name="newLabelids" class="labelids"> <input
                                                                type="hidden" value="" id="oldLabelids"
                                                                name="oldLabelids" class="labelids"> <span
                                                                class="input-group-addon ">标签列表</span>
                                                            <input id="tagsinputval" class="tagsinput" value=""
                                                                   placeholder="" style="width: 100%">

                                                        </div>


                                                        <input type="hidden" class="form-control" id="sad"
                                                               name="sad">
                                                        <div class="input-group" style="margin: 25px 0 0 0;">
                                                            <span class="input-group-addon "
                                                            >阶段介绍</span>
                                                            <textarea class="form-control" rows="3" id="stagessinfo" maxlength="200"
                                                                      placeholder="请输入..." name="ssinfo"></textarea>
                                                        </div>

                                                        <div class="input-group" style="margin: 25px 0 0 0;">
                                                            <span class="input-group-addon ">商品分类</span>
                                                            <input type="text" id="txt_commodity"
                                                                   name="txt_commodity" class="form-control" value=""
                                                                   onclick="$('#commoditytreeview').show()"
                                                                   placeholder="选择商品分类...">
                                                            <div class="nav" id="commoditytreeview"
                                                                 style="display: none;"></div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6 col-md-4 Refresh" id="showGoods">

                                                            </div>

                                                        </div>
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


                        <!-- Modal 根据分类显示商品 -->
                        <div class="modal fade" id="mygoodsModal" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="mygoodsModalLabel">商品</h4>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" id="cid">
                                        <input type="hidden" id="ResetProductId">
                                        <input type="hidden" id="ResetProductNum">
                                        <div id="QueryProduct">
                                            <input type="text" name="goodsname" id="goodsname"
                                                   placeholder="请输入商品名称..."/>
                                            <input type="text" name="shopsname" id="shopsname"
                                                   placeholder="请输入商户名称..."/>

                                            <button style="height: 35px; margin: 0 0 5px 0"
                                                    class="btn btn-success btn-xs  search-query">查询
                                            </button>
                                        </div>
                                        <table id="goods-table"
                                               class="table  table-bordered table-hover user-list">
                                            <thead>
                                            <tr>
                                                <th class="center"><label class="pos-rel"> <input
                                                        type="checkbox" class="ace select-all-btn"/> <span
                                                        class="lbl"></span>
                                                </label></th>
                                                <th><i class="fa fa-id-card bigger-110 hidden-480"></i>ID</th>
                                                <th><i class="fa fa-user bigger-110 hidden-480"></i>分类</th>
                                                <th><i
                                                        class="fa fa-user-circle-o bigger-110 hidden-480"></i>商户名称
                                                </th>
                                                <th><i
                                                        class="fa fa-user-circle-o bigger-110 hidden-480"></i>商品名字
                                                </th>
                                                <th><i
                                                        class="fa fa-user-circle-o bigger-110 hidden-480"></i>数量
                                                </th>
                                            </tr>
                                            </thead>

                                            <tbody class="user-tbody" id="goodsinfo">


                                            </tbody>
                                        </table>
                                    </div>
                                    <div id="paging"></div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal"
                                                onclick="ReloadData()">取消
                                        </button>
                                        <button type="button" class="btn btn-primary" onclick="GetTheProductId()">确认
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


                        <!-- 模态框（Modal） -->
                        <div class="modal fade" id="property" tabindex="-1" role="dialog"
                             aria-labelledby="myproperty" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;
                                        </button>
                                        <h4 class="modal-title" id="myproperty">标签选择</h4>
                                    </div>
                                    <div class="modal-body" id="selectproperty"></div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                data-dismiss="modal" onclick="show()">提交
                                        </button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal -->
                        </div>


                        <!-- 模态框（Modal）修改商家 -->
                        <div class="modal fade" id="myshop" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">商家选择</h4>

                                    </div>
                                    <div class="modal-body" id="selectshop">
                                        <div>
												<span class="input-group-addon label-success"
                                                >商家选择</span> <input id="merchantlist"
                                                                    style="width: 100%; height: 30px;"
                                                                    list="shopname"
                                                                    placeholder="请输入商家名称..."
                                                                    class="merchantlist"/>
                                            <datalist id="shopname">

                                            </datalist>
                                        </div>


                                        <div id="Merchant-album-selection">
                                            <span class="label label-primary shoplabel">商家相册选择</span>
                                        </div>
                                        <div class="row album-list" id="featuredshopimg"></div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                data-dismiss="modal" onclick="schemeandshoplist()">提交
                                        </button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal -->
                        </div>

                        <!-- 模态框（Modal）刷新相片 -->
                        <div class="modal fade" id="myalbum" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;
                                        </button>
                                        <h4 class="modal-title" id="myalbumname">.....</h4>
                                    </div>
                                    <div class="modal-body" id="selectimages">
                                        <div class="row " id="selectshopimgages"></div>
                                    </div>
                                    <div class="modal-footer images-list">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭
                                        </button>
                                        <button type="button" class="btn btn-primary chooseimages"
                                                data-dismiss="modal">提交
                                        </button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal -->
                        </div>


                        <!--备选商家  -->
                        <div class="modal fade" id="exampleModal" tabindex="-1"
                             role="dialog" aria-labelledby="exampleModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title" id="exampleModalLabel">选择备选商家</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="form-group">
													<span class="input-group-addon label-success"
                                                          id="basic-addon1">商家选择</span> <input id="merchantlisttwo"
                                                                                               style="width: 100%; height: 30px;"
                                                                                               list="shopnametwo"
                                                                                               class="merchantlist"/>
                                                <datalist id="shopnametwo">

                                                </datalist>
                                            </div>
                                            <input type="hidden" id="numzero" value=""></input>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭
                                        </button>
                                        <button type="button"
                                                class="btn btn-primary  Replace-an-alternate-merchant"
                                                data-dismiss="modal">提交
                                        </button>
                                    </div>
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
    <%@include file="../common/footer.jsp" %>

    <a href="#" id="btn-scroll-up"
       class="btn-scroll-up btn btn-sm btn-inverse"> <i
            class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>
<!-- /.main-container -->

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
<%--分页--%>
<%--<script src="${path}/assets/js/bootstrap-paginator.js"></script>--%>
<script src="${path}/assets/js/paging.js"></script>
<script
        src="${path}/assets/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
<script src="${path}/resource/static/distpicker/dist/distpicker.js"></script>
<!-- ace脚本 -->
<%@include file="../common/ace-scripts.jsp" %>
<!-- 与此页相关的内联脚本 -->

<script src="${path}/assets/js/bootstrap-treeview.js"></script>
<script src="../assets/js/bootstrap-tagsinput.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.11.1/typeahead.bundle.min.js"></script>

<script src="../assets/js/bootstrap-tagsinput.min.js"></script>
<script src="../assets/js/bootstrap-tagsinput-angular.min.js"></script>

<script src="${path}/assets/custom-js/scheme/schemeDetails.js"></script>
</body>

</html>
