// 展示提示框
function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}
//重置用户表单
function resetUserForm(title,button){
    $(".user-form input[type='text']").val("");
    $(".user-form input[type='file']").val("");
    $(".user-form-title").html(title);
    $(".user-submit").html('<i class="ace-icon fa fa-check"></i>'+button);
}

//添加用户框体
$(".show-add-form").click(function(){
    resetUserForm("添加分类","添加");
});

// 更新用户框体
$(".user-list").on("click",".show-update-form",function(){
    resetUserForm("更新分类信息","更新");
    var aid=$(this).parents("tr").find(".aid").html();
    $("input[name='aid']").val(aid);
    $.ajax({
        url:"getalbum.html",
        data:{aid:aid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	$("input[name='aname']").val(data.aname);
//        	$("input[name='ainfo']").val(data.ainfo);
        	$("#ainfo").val(data.ainfo);
        	$("#pic").attr("src", data.aimg  );
        	$("input[name='adate']").val(data.adate);
        }
    });
});

//添加、更新动作
$(".user-submit").click(function(){
	
//	$(".user-list").on(function(){
//		var sid = $(this).parents("tr").find(".sid").html();
//	})
	 if($(this).html().indexOf("添加")>0){
        //添加新用户
        $.ajax({
            url:"addalbum.html",
            type:"POST",
            secureuri:false,
//            data:{
//            	sid:sid
//            },
            data:$(".user-form").serialize(),
            
            dataType:"json",
            success:function(data){
                $("#user-form-div").modal("hide");
                showTips("添加成功！");
                $(".close-tip").click(function () {
                        setTimeout(function(){window.location.reload()},220);
                    }
                )
                },
            error:function(){
                showTips("添加失败！");
            }
        });
    }else{
        //更新用户信息
        $.ajax({
            url:"updatealbum.html",
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
    }
});



//删除单个相册
$(".user-list").on("click", ".delete-this-user", function () {
    var userTr = $(this).parents("tr");
    var aid = userTr.find(".aid").html();
    var aname = userTr.find(".aname").html();
    if (confirm('确认删除用户[' + aname + ']吗？')) {
        $.ajax({
            url: "deletealbum.html",
            data: {aid: aid},
            type: "POST",
            success: function () {
                userTr.remove();
                showTips("删除成功！");
            },
            error: function () {
                showTips("删除失败！");
            }
        });
    }
});
