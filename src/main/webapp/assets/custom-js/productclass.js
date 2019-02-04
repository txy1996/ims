// 展示提示框
function showTips(content) {
	$("#op-tips-content").html(content);
	$("#op-tips-dialog").modal("show");
}
// 重置用户表单
function resetUserForm(title, button) {
	$(".user-form input[type='text']").val("");
	$(".user-form input[name='scid']").prop("disabled", false);
	$(".user-form-title").html(title);
	$(".user-submit").html('<i class="ace-icon fa fa-check"></i>' + button);
}

// 添加用户框体
$(".show-add-form").click(function() {
	resetUserForm("添加分类", "添加");
});

// 更新用户框体
$(".user-list").on("click", ".show-update-form", function() {
	resetUserForm("更新分类信息", "更新");
	var scid = $(this).parents("tr").find(".scid").html();
	$("input[name='scid']").val(scid);
	$.ajax({
		url : "getUser.html",
		data : {
			scid : scid
		},
		type : "POST",
		dataType : "json",
		success : function(data) {
			$("select[name='scscid']").val(data.scscid);
			$("select[name='scname']").val(data.scname);
			$("input[name='scinfo']").val(data.scinfo);

		}
	});
});

// 添加、更新动作
$(".user-submit").click(function() {
	if ($(this).html().indexOf("添加") > 0) {
		// 添加新用户
		$.ajax({
			url : "add.html",
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
			},
			error : function() {
				showTips("添加失败！");
			}
		});
	} else {
		// 更新用户信息
		$.ajax({
			url : "update.html",
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

// 删除单个用户
$(".user-list").on("click", ".delete-this-user", function() {
	var userTr = $(this).parents("tr");
	var scid = userTr.find(".scid").html();
	var scname = userTr.find(".scname").html();
	if (confirm('确认删除用户[' + scname + ']吗？')) {
		$.ajax({
			url : "delete.html",
			data : {
				scid : scid
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

$(".save").click(function() {
	$.ajax({
		url : "add.html",
		type : "POST",
		data : $(".for").serialize(),
		dataType : "json",
		success : function(data) {
			$(".exampleModal").modal("hide");
			showTips("添加成功");
			$(".close-tip").click(function() {
				setTimeout(function() {
					window.location.reload()
				}, 220);
			})
		},
		error : function() {
			$(".exampleModal").modal("hide");
			showTips("更新失败！");
		}
	})
})

/*
 * $(".save1").click(function() { $.ajax({ url : "select.html", type : "POST",
 * data : $(".for1").serialize(), dataType : "json", success : function(data) {
 * 
 * $(".exampleModal").modal("hide"); showTips("添加成功");
 * $(".close-tip").click(function () {
 * setTimeout(function(){window.location.reload()},220); })
 *  }, error : function() {
 * 
 * $(".exampleModal").modal("hide"); showTips("更新失败！");
 *  } }) })
 */

$('#exampleModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget) // 触发事件的按钮
	var recipient = button.data('whatever') // 解析出data-whatever内容
	var modal = $(this)
	modal.find('.modal-body input').val(recipient)
	$.ajax({
			url : "selectname.html",
			type : "POST",
			dataType : "json",
			data : {
			'id' : recipient
			},
			success : function(data) {
				console.log(data)
			$("#ccname1").val(data)
			
			$.ajax({
			url : "selecttemplet.html",
			type : "POST",
			dataType : "json",
			success : function(data) {		
				$("#templet_list option").remove();
				var aaa = '';
				console.log("===========")
				console.log(data)
				console.log("===========")
				$.each(data, function(a, b) {
					aaa = "模板" + b["templet_list"];
					var option = $("<option value='" + b["templet_list"] + "'>"
							+ aaa + "</option>");				
					$('#templet_list').append(option)
				})
		}
})
		}
})
})

var recipient1 = '';
var qwer = '';
var lala = '';
$('#exampleModal1')
		.on(
				'show.bs.modal',
				function(event) {
					var button = $(event.relatedTarget) // 触发事件的按钮
					recipient1 = button.data('whatever') // 解析出data-whatever内容
					var modal = $(this)
					modal.find('.modal-body input #inp').val(recipient1)
							$.ajax({
								url : "selectproperty.html",
								type : "POST",
								ansyc : 'true',
								dataType : "JSON",
								data : {
									'id' : recipient1
								},
								// traditional:true,
								success : function(data) {
									$('#table tr:gt(0)').remove();
									$.each(data,function(i, n) {
														qwer = "delete.html?id="
																+ n['id']
														lala = n['id']
														var ref = "<a href=javascript:void(0);onclick="+'delproduct('+lala+')'+">从本类中删除</a>"
														item = "<tr><td>"
																+ n['name']
																+ "</td><td>"
																+ n['propertyvalue']
																+ "</td><td>"
																+ ref
																+ "</td></tr>";
														$('#table')
																.append(item);

													});
								},
								error : function() {
									console.log("error")
								}
							})
					$.ajax({
						url : "selectall.html",
						type : "POST",
						ansyc : 'true',
						dataType : "JSON",
						success : function(data1) {
							$("#wlmslist option").remove();
							var aaa = '';
							$.each(data1, function(a, b) {
								aaa = "[" + b["name"] + "]" + "["
										+ b["propertyvalue"] + "]";
								var ccc = b["id"];
								var option = $("<option value='" + aaa + "'>"
										+ aaa + "</option>");
								$('#wlmslist').append(option)

							})
						},
						error : function() {
							console.log("error")
						}
					})

					$.ajax({
						url : "selectbyid.html",
						type : "POST",
						ansyc : 'true',
						dataType : "JSON",
						data : {
							'id' : recipient1
						},
						success : function(data2) {
							$('h4').html("给" + data2 + "分类增加属性")
						},
						error : function() {
							console.log("error")
						}
					})
				})

function delproduct(la) {
	$.ajax({
				url : "delete.html",
				type : "POST",
				ansyc : 'true',
				dataType : "html",
				data : {
					'id' : la,
					'id1' : recipient1
				},
				// traditional:true,
				success : function(data) {
					showTips("删除成功");
					$(".close-tip")
							.click(
									function() {
										$('#table tr:gt(0)').remove();
										var obj = JSON.parse(data);
										$.each(obj,function(i, n) {
															qwer = "delete.html?id="
																	+ n['id']
															lala = n['id']
															var ref = "<a href=javascript:void(0);onclick="+'delproduct('+lala+')'+">从本类中删除</a>"
															item = "<tr><td>"
																	+ n['name']
																	+ "</td><td>"
																	+ n['propertyvalue']
																	+ "</td><td>"
																	+ ref
																	+ "</td></tr>";
															$('#table').append(
																	item);

														});
									})
				},
				error : function() {
					showTips("删除失败");
				}
			})
}

function getCategory() {
	$.ajax({
				url : "addproperty.html",
				type : "POST",
				ansyc : 'true',
				dataType : "html",
				data : {
					'sorpname' : $("#sorpname").val(),
					'id' : recipient1
				},
				// traditional:true,
				success : function(data) {
					showTips("新增成功");
					var obj = JSON.parse(data);
					$(".close-tip")
							.click(
									function() {
										$('#table tr:gt(0)').remove();
										$.each(obj,function(i, n) {
															qwer = "delete.html?id="
																	+ n['id']
															lala = n['id']
															var ref = "<a href=javascript:void(0);onclick="+'delproduct('+lala+')'+">从本类中删除</a>"
															item = "<tr><td>"
																	+ n['name']
																	+ "</td><td>"
																	+ n['propertyvalue']
																	+ "</td><td>"
																	+ ref
																	+ "</td></tr>";
															$('#table').append(
																	item);

														});
										$('#sorpname').val("")
									})
				},
				error : function() {
					showTips("新增失败");
				}
			})
}

function showRegist() {
	$
			.ajax({
				url : "addpropertyplus.html",
				type : "POST",
				ansyc : 'true',
				dataType : "html",
				data : {
					'fname' : $("#fname").val(),
					'fpropertyvalue' : $("#fpropertyvalue").val(),
					'id' : recipient1
				},
				// traditional:true,
				success : function(data) {
					showTips("新增成功");
					var obj = JSON.parse(data);
					$(".close-tip")
							.click(
									function() {
										$('#table tr:gt(0)').remove();
										$.each(obj,function(i, n) {
															qwer = "delete.html?id="
																	+ n['id']
															lala = n['id']
															var ref = "<a href=javascript:void(0);onclick="+'delproduct('+lala+')'+">从本类中删除</a>"
															item = "<tr><td>"
																	+ n['name']
																	+ "</td><td>"
																	+ n['propertyvalue']
																	+ "</td><td>"
																	+ ref
																	+ "</td></tr>";
															$('#table').append(
																	item);

														});

										$.ajax({
													url : "selectall.html",
													type : "POST",
													ansyc : 'true',
													dataType : "JSON",
													success : function(data1) {
														$("#wlmslist option")
																.remove();
														var aaa = '';
														$.each(data1,
																		function(
																				a,
																				b) {
																			aaa = "["
																					+ b["name"]
																					+ "]"
																					+ "["
																					+ b["propertyvalue"]
																					+ "]";
																			var ccc = b["id"];
																			var option = $("<option value='"
																					+ aaa
																					+ "'>"
																					+ aaa
																					+ "</option>");
																			$(
																					'#wlmslist')
																					.append(
																							option)

																		})
													},
													error : function() {
														console.log("error")
													}
												})

										/*setTimeout(function() {
											window.location.reload()
										}, 220);*/
									})
				},
				error : function() {
					showTips("新增失败");
				}
			})
}

function dele(id) {
	if (confirm("确定删除吗？")) {
		$.ajax({
			url : "delete1.html",
			type : "POST",
			ansyc : 'true',
			data : {
				'id' : id,
			},
			// traditional:true,
			success : function() {
				showTips("删除成功");
				$(".close-tip").click(function() {
					setTimeout(function() {
						window.location.reload()
					}, 220);
				})
			},
			error : function() {
				showTips("删除失败");
			}
		})
	}
	
}

$('.main-content').on('hidden.bs.modal', function() {
	document.getElementsByTagName('body')[0].className = 'modal-open';
});
