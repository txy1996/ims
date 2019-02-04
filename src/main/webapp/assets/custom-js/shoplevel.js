// 展示提示框
function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}
//重置用户表单
function resetUserForm(title,button){
    $(".user-form input[type='text']").val("");
    $(".user-form-title").html(title);
    $(".user-submit").html('<i class="ace-icon fa fa-check"></i>'+button);
}

//添加用户框体
$(".show-add-form").click(function(){
    resetUserForm("添加新品牌","添加");
});

// 更新用户框体
$(".user-list").on("click",".show-update-form",function(){
    resetUserForm("更新品牌信息","更新");
    var slid=$(this).parents("tr").find(".slid").html();
    $("input[name='slid']").val(slid);
    $.ajax({
        url:"getLevel.html",
        data:{slid:slid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	$("input[name='slname']").val(data.slname);
        	$("input[name='slintegration']").val(data.slintegration);
        	$("input[name='slinfo']").val(data.slinfo);
         
        }
    });
});

//添加、更新动作
$(".user-submit").click(function(){
	 if($(this).html().indexOf("添加")>0){
		 debugger;
        //添加新用户
        $.ajax({
            url:"add.html",
            type:"POST",
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
    }
});



//删除单个用户
$(".user-list").on("click", ".delete-this-user", function () {
    var userTr = $(this).parents("tr");
    var slid = userTr.find(".slid").html();
    var slname = userTr.find(".slname").html();
    if (confirm('确认删除用户[' + slname + ']吗？')) {
        $.ajax({
            url: "delete.html",
            data: {slid: slid},
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
