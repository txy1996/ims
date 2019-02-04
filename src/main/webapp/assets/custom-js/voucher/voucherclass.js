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
    resetUserForm("添加分类","添加");
});
//更新查询
$(".user-list").on("click",".show-update-form",function(){
    resetUserForm("更新分类信息","更新");
    var vcid=$(this).parents("tr").find(".vcid").html();
    $("input[name='vcid']").val(vcid);
    $.ajax({
        url:"getvoucherclass.html",
        data:{vcid:vcid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	$("input[name='vcname']").val(data.vcname);
        	$("input[name='vcinfo']").val(data.vcinfo);
         
        }
    });
});
//添加、更新动作
$(".user-submit").click(function(){
	 if($(this).html().indexOf("添加")>0){
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
    var vcid = userTr.find(".vcid").html();
    var vcname = userTr.find(".vcname").html();
    if (confirm('确认删除用户[' + vcname + ']吗？')) {
        $.ajax({
            url: "delete.html",
            data: {vcid: vcid},
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
