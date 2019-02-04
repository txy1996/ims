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
    var iid=$(this).parents("tr").find(".iid").html();
    $("input[name='iid']").val(iid);
    $.ajax({
        url:"getimages.html",
        data:{iid:iid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	$("input[name='iname']").val(data.iname);
        	$("#pic").attr("src", "/ims/upload/images/" + data.iurl  );
        	$("#pic1").attr("src", "/ims/upload/images/" + data.iimgurl  );
        	$("input[name='idate']").val(data.idate);
        }
    });
});

//添加、更新动作
$(".user-submit").click(function(){
	 if($(this).html().indexOf("添加")>0){
		 
        //添加新用户
        $.ajax({
            url:"addscimages.html",
            type:"POST",
            secureuri:false,
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
            url:"updateimages.html",
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
    var iid = userTr.find(".iid").html();
    var iname = userTr.find(".iname").html();
    if (confirm('确认删除用户[' + iname + ']吗？')) {
        $.ajax({
            url: "deleteimages.html",
            data: {iid: iid},
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
