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

// 下拉选择
function inputSelect() {
	var operating = $("#operating").val();
	var arr = operating.split("[");
	arr = arr[0]
	$("input[name='igetinfo']").val(arr);

}

// 根据时间段查询
$(".integral-user-filter").on("click", ".user-filter", function() {

	var starttime = $("#starttime").val();
	var endtime = $("#endtime").val();
	var urid = $("#urid").val();
	var username = $("#username").val();
	$.ajax({
		url : "../integral/list.html",
		dataType : "html",// 特别重要
		data : {
			starttime : starttime,
			endtime : endtime,
			urid : urid,
			username : username
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
$(".integral-user-filter").on("change", "#selectintegral", function() {

	var goinfo = $("#selectintegral").val();
	var urid = $("#urid").val();
	var username = $("#username").val();
	$.ajax({
		url : "../integral/list.html",
		dataType : "html",// 特别重要
		data : {
			goinfo : goinfo,
			urid : urid,
			username : username
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
		$("#addintegrations").css("display", ""); // 满足显示
	}
});

// 添加动作
$(".user-submit").click(
		function() {

			var urid = $("#urid").val();
			var operating = $("#operating").val();
			var arr = operating.split("[");
			arr = arr[1].split("]");
			var igetnum = arr[0];
			var igetinfo = $("#igetinfo").val();
			var urid = $("#urid").val();
			var username = $("#username").val();

			$.ajax({
				url : "../integral/add.html",
				type : "POST",
				data : {
					urid : urid,
					igetinfo : igetinfo,
					igetnum : igetnum
				},
				dataType : "json",
				success : function(data) {
					$("#user-form-div").modal("hide");
					showTips("添加成功！");
					$(".close").click(
							function() {
								setTimeout(function() {
									var url = "../integral/list?urid="
											+ data.urid + "&username="
											+ username;
									window.location.href = url;
								}, 220);
							})
				},
				error : function() {
					showTips("添加失败！");
				}
			});
		});