function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}

// 更新用户框体
$(".perm-list").on("click",".show-update-form",function(){
	//debugger;
    //resetUserForm("修改代金券","更新");
    $(".user-form-title").val("修改优惠券")
    var cid=$(this).parents("tr").find(".vid").html();
    $("input[name='cid']").val(cid);
    
    $.ajax({
        url:"getshopcoupon.html",
        data:{cid:cid},
        type:"POST",
        dataType:"json",
        success:function(data){        	
        	$("input[name='ctitle']").val(data.ctitle);
        	$("input[name='cmoney']").val(data.cmoney);
        	$("input[name='cprice']").val(data.cprice);
        	$("input[name='crange']").val(data.crange);
        	$("input[name='cnum']").val(data.cnum);
        	$("input[name='cstore']").val(data.cstore);
        	$("input[name='csdate']").val(data.csdate);
        	$("input[name='codate']").val(data.codate);
        }
    });
});



//修改
$(".user-submit").click(function(){
	$.ajax({
        url:"update.html",
        data:$(".user-form").serialize(),
        type:"POST",
        success:function(){
            $("#user-form-div").modal("hide");
            showTips("更新成功！");
            $(".close-tip").click(function () {
                setTimeout(function(){window.location.reload()},220);
                }
            )
        },
        error:function(){
            showTips("更新失败！");
        }
    });
})

function zuofei(id){
	console.log(id)
	$.ajax({
		url : "deleteshopcoupon.html",
		data : {
			cid : id
		},
		type : "POST",
		success : function() {
			showTips("作废成功！");
            $(".close-tip").click(function () {
                setTimeout(function(){window.location.reload()},220);
                }
            )
		},
		error : function() {
			showTips("作废失败！");
		}
	});
}