function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}

// 更新用户框体
$(".perm-list").on("click",".show-update-form",function(){
	//debugger;
    //resetUserForm("修改代金券","更新");
    $(".user-form-title").val("修改代金券")
    var vid=$(this).parents("tr").find(".vid").html();
    $("input[name='vid']").val(vid);
    
    $.ajax({
        url:"getshopvoucher.html",
        data:{vid:vid},
        type:"POST",
        dataType:"json",
        success:function(data){        	
        	$("input[name='vtitle']").val(data.vtitle);
        	$("input[name='vmoney']").val(data.vmoney);
        	$("input[name='vprice']").val(data.vprice);
        	$("input[name='vrange']").val(data.vrange);
        	$("input[name='vnum']").val(data.vnum);
        	$("input[name='vstore']").val(data.vstore);
        	$("input[name='vsdate']").val(data.vsdate);
        	$("input[name='vodate']").val(data.vodate);
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
		url : "deleteshopvoucher.html",
		data : {
			vid : id
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