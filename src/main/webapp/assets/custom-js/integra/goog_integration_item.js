var path = $("#sysPath").val();

// 展示提示框
function showTips(content) {
	$("#op-tips-content").html(content);
	$("#op-tips-dialog").modal("show");
}

// 重置用户表单
function resetUserForm(title, button) {
	$(".user-form-title").html(title);
	$(".user-submit").html('<i class="ace-icon fa fa-check"></i>' + button);
}

// 添加用户框体
$(".show-add-form").click(
		function() {
			resetUserForm("添加操作项", "添加");
			$(".user-form input[type='radio'][name='state'][value='1']").prop(
					"checked", true);

		});

$(".user-list").on(
		"click",
		".show-update-form",
		function() {
			resetUserForm("更新操作项", "更新");
			$(".user-form input[type='radio'][name='state'][value='1']").prop(
					"checked", true);
			var itemTr = $(this).parents("tr");
			var id = itemTr.find(".id").html();
			var iname = itemTr.find(".iname").html();
			var inum = itemTr.find(".inum").html();
			var igori = itemTr.find(".igori").find("input").val();
			$("#id").val(id)
			$("#iname").val(iname)
			$("#inum").val(inum)
			$(".igori").val(igori)

		});

// 添加、更新动作
$(".user-submit").click(function() {

	if ($(this).html().indexOf("添加") > 0) {
		console.log($(".user-form").serialize())
		$.ajax({
			url : "../giitem/add.html",
			type : "POST",
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
				var url = encodeURI("../giitem/list")
				window.location.href = url;
			},
			error : function() {
				showTips("添加失败!");
			}
		});
	} else {
		$.ajax({
			url : "../giitem/update.html",
			data : $(".user-form").serialize(),
			dataType : "json",
			type : "POST",
			success : function(data) {
				$("#user-form-div").modal("hide");
				showTips("更新成功!");
				$(".close-tip").click(function() {
					setTimeout(function() {
						window.location.reload()
					}, 220);
				})
				var url = encodeURI("../giitem/list")
				window.location.href = url;
			},
			error : function() {
				showTips("更新失败!");
			}
		});
	}
});

// 删除操作项
$(".user-list").on("click", ".show-delete-form", function() {
	var itemTr = $(this).parents("tr");
	var id = itemTr.find(".id").html();
	if (confirm('确认删除所选操作项吗？')) {
		$.ajax({
			url : "../giitem/delete.html",
			dataType : "json",// 特别重要
			data : {
				id : id,

			},
			type : "POST",
			success : function(data) {
				showTips("删除成功！");
				var url = encodeURI("../giitem/list")
				window.location.href = url;
			},
			error : function() {
				showTips("删除失败！");
			}
		});
	}

});

// 搜索
$(".user-search").on("click", ".search-query", function() {
	var igori = $("#igori").val();
	var iname = $("#inameinput").val();
	$.ajax({
		url : "../giitem/list.html",
		dataType : "html",// 特别重要
		data : {
			igori : igori,
			iname : iname
		},
		type : "POST",
		success : function(data) {
			$("#Refreshbody").html(data)

		},
		error : function() {
			showTips("对不起操作失败!");
		}
	});

});
// 更新
$(".page-header").on("click", ".update-item", function() {
	$.ajax({
		url : "../giitem/selectItemXML.html",
		dataType : "json",// 特别重要
		data : {
			
		},
		type : "POST",
		success : function(data) {
			showTips("操作成功!");
			
		},
		error : function() {
			showTips("对不起操作失败!");
		}
	});
	
});