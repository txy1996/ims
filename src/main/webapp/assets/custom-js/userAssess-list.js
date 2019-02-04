//根据评分显示星星的函数,但是没用上
function showStar(n, v) {
	var con_wid = 120;
	var del_star;
	var del_move = (n * con_wid) / 5;
	var tem = "<div id='star_con${list.uaid}' class='star-vote'> "
			+ "<span class='add-star'></span>"
			+ "<span class='del-star' style='backgroundPosition:" + -del_move
			+ "px 0px;left:" + del_move + "px;'></span>" + "</div>"
	console.log(tem)
	$("#" + v).html(tem)
}

// 根据分数筛选
$(".user-search").on("change", "#queryRating", function() {
	var uanum = $("#queryRating").val()
	var uaoid = $("#uaoid").val()
	var uaotype = $("#uaotype").val()

	$.ajax({
		url : "../userAssess/list.html",
		dataType : "html",// 特别重要
		data : {
			uanum : uanum,
			uaoid : uaoid,
			uaotype : uaotype
		},
		type : "POST",
		success : function(data) {
			$("#Refreshbody").html(data)
		},
		error : function() {

		}
	});
});

// 根据条件筛选
$(".user-search").on("click", ".search-query", function() {
	var searchfor = $("#searchfor").val()
	var commentinfo = $("#commentinfo").val()
	var uaoid = $("#uaoid").val()
	var uaotype = $("#uaotype").val()
	$.ajax({
		url : "../userAssess/list.html",
		dataType : "html",// 特别重要
		data : {
			uaotype : searchfor,
			commentinfo : commentinfo,
			uaoid : uaoid,
			

		},
		type : "POST",
		success : function(data) {
			$("#Refreshbody").html(data)
		},
		error : function() {
			alert("异常！");
		}
	});
});
