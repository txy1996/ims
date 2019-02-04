// 展示提示框
function showTips(content) {
	$("#op-tips-content").html(content);
	$("#op-tips-dialog").modal("show");
}
// 重置用户表单
function resetUserForm(title, button) {
	$(".user-form input[type='text']").val("");
	$(".user-form-title").html(title);
	$(".user-submit").html('<i class="ace-icon fa fa-check"></i>' + button);
}

// 添加用户框体
$(".show-add-form").click(function() {
	resetUserForm("添加分类", "添加");
});


// 根据时间段查询
$(".goods-user-filter").on("click", ".user-filter", function() {

	var starttime = $("#starttime").val();
	var endtime = $("#endtime").val();
	var urid =$("#urid").val();
	var username =$("#username").val();
	$.ajax({
		url : "../goods_user/list.html",
		dataType : "html",// 特别重要
		data : {
			starttime : starttime,
			endtime : endtime,
			urid:urid,
			username:username
		},
		type : "POST",
		success : function(data) {
			$(document.body).html(data)
		},
		error : function() {

		}
	});
});
// 根据操作项查询
$(".goods-user-filter").on("change", "#gooduseritem", function() {
	
	var goinfo = $("#gooduseritem").val();
	var urid =$("#urid").val();
	var username =$("#username").val();
	$.ajax({
		url : "../goods_user/list.html",
		dataType : "html",// 特别重要
		data : {
			goinfo : goinfo,
			urid:urid,
			username:username
		},
		type : "POST",
		success : function(data) {
			$(document.body).html(data)
		},
		error : function() {
			
		}
	});
});




$(function() {

	var urid = $("#urid").val();
	var username = $("#username").val();
	if (urid !== "" && username !== "") {
		$("#addgoodsuser").css("display", ""); // 满足显示
	}
});
//下拉选择
function inputSelect(){
	var operating = $("#operating").val();
	var arr = operating.split("[");
	arr = arr[0]
	$("input[name='goinfo']").val(arr);
	
	}

// 添加动作
$(".user-submit").click(function() {

	var urid = $("#urid").val();
	var operating = $("#operating").val();
	var arr = operating.split("[");
	arr = arr[1].split("]");
	var gonum = arr[0];
	var goinfo = $("#goinfo").val();
	var username = $("#username").val();

	$.ajax({
		url : "../goods_user/add.html",
		type : "POST",
		data : {
			urid : urid,
			goinfo : goinfo,
			gonum : gonum,
		},
		dataType : "json",
		success : function(data) {
			$("#user-form-div").modal("hide");
            showTips("添加成功！");
            $(".close").click(function () {
            	setTimeout(function(){
                	var url="../goods_user/list?urid="+data.urid;
                	window.location.href = url;},220);
            }
            )
            },
		error : function() {
			showTips("添加失败！");
		}
	});
});