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

// 删除单个用户
$(".user-list").on("click", ".delete-this-user", function() {
	var userTr = $(this).parents("tr");
	var gid = userTr.find(".gid").html();
	// var vtitle = userTr.find(".vtitle").html();
	// if (confirm('确认删除积分[' + vtitle + ']吗？')) {
	if (confirm('确认删除此商户吗？')) {
		$.ajax({
			url : "delete.html",
			data : {
				gid : gid
			},
			type : "POST",
			success : function() {
				userTr.remove();
				showTips("删除成功！");
			},
			error : function() {
				showTips("删除失败！");
			}
		});
	}
});
// 添加、更新动作
$(".user-submit").click(function() {
	if ($(this).html().indexOf("添加") > 0) {

		// 添加新用户
		$.ajax({
			url : "../goods_shop/add.html",
			type : "POST",
			secureuri : false,
			data : $(".user-form").serialize(),
			dataType : "json",
			success : function(data) {
				$("#user-form-div").modal("hide");
				showTips("添加成功！");
				$(".close-tip").click(function() {
					setTimeout(function() {
						window.location.reload()
					}, 220);
				})
			},
			error : function() {
				showTips("添加失败！");
			}
		});
	} else {
		// 更新用户信息
		$.ajax({
			url : "updatealbum.html",
			data : $(".user-form").serialize(),
			type : "POST",
			success : function() {
				$("#user-form-div").modal("hide");
				showTips("更新成功！");
				$(".close-tip").click(function() {
					setTimeout(function() {
						window.location.reload()
					}, 220);
				})
			},
			error : function() {
				showTips("更新失败！");
			}
		});
	}
});

//$(function() {
//	var igori = 1;
//	$.ajax({
//		type : "post",
//		url : "../giitem/select.html",
//		data : {
//			igori : igori
//		},
//		dataType : "json",// 特别重要
//		success : function(data) {
//			var tem = ""
//			var teml = ""
//			for (var i = 0; i < data.length; i++) {
//				tem += "<option value='" + data[i].iname + "[" + data[i].inum+ "]' />"
//				teml += "<option value='" + data[i].iname + "'>"
//						+ data[i].iname + " </option>"
//			}
//			$("#ide").html(tem)
//			$("#shopgooditem").html(teml)
//		},
//		error : function() {
//			toastr.error('Error');
//		},
//	});
//});

//根据操作项查询
$(".goods-user-filter").on("change", "#shopgooditem", function() {
	
	var goinfo = $("#shopgooditem").val();
	var sid =$("#sid").val();
	var sname =$("#sname").val();
	$.ajax({
		url : "../goods_shop/list.html",
		dataType : "html",// 特别重要
		data : {
			goinfo : goinfo,
			sid:sid,
			sname:sname
		},
		type : "POST",
		success : function(data) {
			$(document.body).html(data)
		},
		error : function() {
			
		}
	});
});

//根据时间段查询
$(".goods-user-filter").on("click", ".user-filter", function() {

	var starttime = $("#starttime").val();
	var endtime = $("#endtime").val();
	var sid =$("#sid").val();
	var sname =$("#sname").val();
	$.ajax({
		url : "../goods_shop/list.html",
		dataType : "html",// 特别重要
		data : {
			starttime : starttime,
			endtime : endtime,
			sid:sid,
			sname:sname
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

	var sid = $("#sid").val();
	var sname = $("#sname").val();
	if (sid !== "" && sname !== "") {
		$("#addgoodsshop").css("display", ""); // 满足显示
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

	var sid = $("#sid").val();
	var operating = $("#operating").val();
	var arr = operating.split("[");
	arr = arr[1].split("]");
	var gonum = arr[0];
	var goinfo = $("#goinfo").val();

	$.ajax({
		url : "../goods_shop/add.html",
		type : "POST",
		data : {
			sid : sid,
			goinfo : goinfo,
			gonum : gonum
		},
		dataType : "json",
		success : function(data) {
			$("#user-form-div").modal("hide");
            showTips("添加成功！");
            $(".close").click(function () {
            	setTimeout(function(){
                	var url="../goods_shop/list?sid="+data.sid;
                	window.location.href = url;},220);
            }
            )
            },
		error : function() {
			showTips("添加失败！");
		}
	});
});