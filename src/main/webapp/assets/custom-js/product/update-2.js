var jsonDataTree = [];

var ue = UE.getEditor('myEditor');

$('input[id=lefile]').change(function() {
	$('#photoCover').val($(this).val());
});

ue.addListener("ready", function() {
	var id = $("#id").val()
	$.ajax({
		type : "post",
		data : {
			id : id
		},
		url : "../product/updateProductInfo.html",
		dataType : "json",// 特别重要
		success : function(data) {
			ue.setContent(data.info);
			$("#state").val(data.state);
			$("#txt_departmentname").val(data.cname);
			showProperty();

		},
		error : function() {
			toastr.error('Error');
		},
	});
});

$(function() {
	$.ajax({
		type : "post",
		url : "../productclass/selectAll.html",
		dataType : "json",// 特别重要
		success : function(data) {

			jsonDataTree = transData(data, 'id', 'cid', 'nodes');

		},
		error : function() {
			toastr.error('Error');
		},
	});
});

function transData(a, idStr, pidStr, chindrenStr) {
	var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;
	for (; i < len; i++) {
		hash[a[i][id]] = a[i];

	}
	for (; j < len; j++) {
		var aVal = a[j], hashVP = hash[aVal[pid]];
		if (hashVP) {
			!hashVP[children] && (hashVP[children] = []);
			hashVP[children].push(aVal);
		} else {
			r.push(aVal);
		}
	}
	return r;
}

$("#txt_departmentname").click(function() {
	var options = {
		bootstrap2 : false,
		showTags : true,
		levels : 1,
		highlightSelected : true,
		showCheckbox : false,
		backColor : "#FCFCFC",// 背景色
		onhoverColor : "#00868B",// 鼠标悬浮颜色
		selectedColor : "yellow",// 选中颜色
		checkedIcon : "glyphicon glyphicon-check",
		data : jsonDataTree,
		emptyIcon : "glyphicon",
		collapsed : true,
		onNodeSelected : function(event, data) {
			$("#txt_departmentname").val(data.text);
			QueryAttribute(data.id)
			$("#treeview").hide();
		}

	};
	$('#treeview').treeview(options);

});

// 属性刷新
function showProperty() {
	var tem = ""
	var property = $("#property").val()
	property = property.substring(property.indexOf('[') + 1, property
			.indexOf(']'));
	var arr = property.split(",");
	var pcid = $("#pcid").val()
	$
			.ajax({
				url : "../property/selectBypcid.html",
				dataType : "json",// 特别重要
				data : {
					pcid : pcid
				},
				type : "POST",
				success : function(data) {
					var flag = true;
					var book = "";
					var tem = "<h5>商品属性:</h5>";
					for (var i = 0; i < data.length; i++) {
						for (var z = 0; z < arr.length; z++) {
							var p = arr[z].split(':');
							if (p[0] == data[i].id) {
								flag = false;
								book = p[1];
							}
						}
						var propertyvalue = data[i].propertyvalue.split('|')
						tem += "<div class=' input-group input-group-sm col-xs-3 property-div '"
								+ "style='float: left; margin: 20px 20px 0 0;'> "
								+ "<span class='input-group-addon ' >"
								+ data[i].name
								+ "</span> "
								+ "<select class='property-select'  style='width: 100%;'> ";
						if (propertyvalue.length > 0) {
							tem += "<option  propertyid=" + data[i].id
									+ "'>请选择</option>"
							for (var z = 0; z < propertyvalue.length; z++) {
								if (propertyvalue[z] == book) {
									tem += "<option value='" + propertyvalue[z]
											+ "' propertyid='" + data[i].id
											+ "' selected>" + propertyvalue[z]
											+ "  </option> ";
								} else {

									tem += "<option value='" + propertyvalue[z]
											+ "' propertyid='" + data[i].id
											+ "'>" + propertyvalue[z]
											+ "</option> ";
								}

							}
						}
						tem += "</select> " + "</div>";

					}

					$("#selectproperty").html(tem)

				},
				error : function() {

				}
			});
}

function updateProduct() {

	$.ajax({
		url : "../product/updateProductAddRequest.html",
		type : "POST",
		data : new FormData($('.product-update-from')[0]),
		processData : false,
		contentType : false,
		dataType : "json",// 特别重要
		success : function(data) {
			var sid = $("#sid").val()
			console.log(sid)
			var url = encodeURI("../product/selectProduct?sid=" + sid + "")
			window.location.href = url;
		},
		error : function() {
			alert("异常！");
		}
	});
}

// 刷新属性
function QueryAttribute(pcid) {

	 $("#pcid").val(pcid)
	$
			.ajax({
				url : "../property/selectBypcid.html",
				dataType : "json",// 特别重要
				data : {
					pcid : pcid
				},
				type : "POST",
				success : function(data) {
					var tem = "<h5>商品属性:</h5>";
					for (var i = 0; i < data.length; i++) {
						var propertyvalue = data[i].propertyvalue.split('|')
						tem += "<div class=' input-group input-group-sm col-xs-3 property-div '"
								+ "style='float: left; margin: 20px 20px 0 0;'> "
								+ "<span class='input-group-addon ' >"
								+ data[i].name
								+ "</span> "
								+ "<select class='property-select'  style='width: 100%;'> ";
						if (propertyvalue.length > 0) {
							tem += "<option  propertyid=" + data[i].id
									+ "'>请选择</option>"
							for (var z = 0; z < propertyvalue.length; z++) {
								tem += "<option value='" + propertyvalue[z]
										+ "' propertyid='" + data[i].id + "'>"
										+ propertyvalue[z] + "</option> ";

							}
						}
						tem += "</select> " + "</div>";

					}

					$("#selectproperty").html(tem)

				},
				error : function() {

				}
			});

}

// 属性下拉选择
$(".property").on(
		"change",
		" .property-div .property-select",
		function() {
			var propertyvalue = $(this).val();
			var id = $(this).find("option:selected").attr("propertyid");
			var tem = id + ":" + propertyvalue;
			var flag = true;
			var property = $("#property").val();
			if (property != "") {
				property = property.substring(property.indexOf('[') + 1,
						property.indexOf(']'));
				var arr = property.split(',');
				if (arr.length > 0) {
					for (var i = 0; i < arr.length; i++) {
						var p = arr[i].split(':');
						if (p[0] == id) {
							arr[i] = tem;
							flag = false;
						}
					}
				}
				property = arr;
				if (flag) {
					property += "," + tem;
				}
			} else {
				property += tem;
			}
			$("#property").val("[" + property + "]");
		});

// 焦点失去事件,隐藏下拉树形列表
// $("#txt_departmentname").blur(function(){
// $("#treeview").hide();
// });

// 点击下拉框以外的元素, 隐藏下拉树形列表
// $(function() {
// $(document).bind("click", function(e) {
// if ($(e.target).closest(".container").length == 0 &&
// $(e.target).closest("#treeview").length==0) {
// // 点击container之外则触发
// $("#treeview").hide();
// }
// })
// })
