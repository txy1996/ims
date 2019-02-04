var jsonDataTree = [];

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
			load(data.id)
			// $("#property").modal("show");
			$("#treeview").hide();
		}

	};
	$('#treeview').treeview(options);

});


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
				property = property.substring(property.indexOf('[')+1, property
						.indexOf(']'));
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
				property +=tem;
			}
			$("#property").val("["+property+"]");
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
