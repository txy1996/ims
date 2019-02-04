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
$(".integral-user-filter").on("click", ".user-filter", function() {

	var starttime = $("#starttime").val();
	var endtime = $("#endtime").val();
	var sname = $("#sname").val();
	$.ajax({
		url : "../slintegration/list.html",
		dataType : "html",// 特别重要
		data : {
			starttime : starttime,
			endtime : endtime,
			sname : sname

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

	var urid = $("#sid").val();
	var username = $("#sname").val();
	if (urid !== "" && username !== "") {
		$("#addslintegration").css("display", ""); // 满足显示
	}
});

// 添加动作
$(".user-submit").click(function() {

	var sid = $("#sid").val();
	var operating = $("#operating").val();
	var arr = operating.split("[");
	arr = arr[1].split("]");
	var igetnum = arr[0];
	var goinfo = $("#goinfo").val();
	$.ajax({
		url : "../slintegration/add.html",
		type : "POST",
		data : {
			sid : sid,
			sgetinfo : goinfo,
			sgetnum : igetnum
		},
		dataType : "json",
		success : function(data) {
			$("#user-form-div").modal("hide");
			showTips("添加成功！");
			$(".close").click(function() {
				setTimeout(function() {
					var url = "../slintegration/list?sid" + data.sid;
					window.location.href = url;
				}, 220);
			})
		},
		error : function() {
			showTips("添加失败！");
		}
	});
});



// 根据操作项查询
$(".integral-user-filter").on("change", "#shopintegralitem", function() {

	var goinfo = $("#shopintegralitem").val();
	var sid = $("#sid").val();
	var sname = $("#sname").val();
	$.ajax({
		url : "../slintegration/list.html",
		dataType : "html",// 特别重要
		data : {
			goinfo : goinfo,
			sid : sid,
			sname : sname
		},
		type : "POST",
		success : function(data) {
			$(document.body).html(data)
		},
		error : function() {

		}
	});
});


// 下拉选择
function inputSelect() {
	var operating = $("#operating").val();
	var arr = operating.split("[");
	arr = arr[0]
	$("input[name='goinfo']").val(arr);

}
