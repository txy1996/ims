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
    var lcid=$(this).parents("tr").find(".lcid").html();
    $("input[name='lcid']").val(lcid);
    $.ajax({
        url:"getByLclcid.html",
        data:{lcid:lcid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	$("input[name='lcid']").val(data.lcid);
        	$("input[name='lcname']").val(data.lcname);
        	$("input[name='lclcid']").val(data.lclcid);
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
/*$(".user-list").on("click", ".delete-this-user", function () {
    var userTr = $(this).parents("tr");
    var lcid = userTr.find(".lcid").html();
//    var sname = userTr.find(".sname").html();
//    if (confirm('确认删除用户[' + sname + ']吗？')) {
    	if (confirm('确认删除用户此标签吗？')) {
        $.ajax({
            url: "delete.html",
            data: {lcid: lcid},
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
});*/


$(".save").click(function(){
	$.ajax({
        url:"add.html",
        type:"POST",
        data:$(".for").serialize(),
        dataType:"json",
        success:function(data){          
        	$(".exampleModal").modal("hide");
        	 showTips("新增成功！");
             $(".close-tip").click(function () {
                 setTimeout(function(){window.location.reload()},220);
                 }
             )                          	
        },
        error:function(){
        	$(".exampleModal").modal("hide");
            showTips("新增失败！");
        }
})
})


function dele(id){
	console.log(id);
	if (confirm('确认删除吗？')) {
	$.ajax({
		url : "delete.html",
		type : "POST",
		ansyc : 'true',
		data : {
			'lcid' : id,
		},
		//traditional:true,
		success : function() {
			
			$(".exampleModal").modal("hide");
			showTips("删除成功！");
			 $(".close-tip").click(function () {
                 setTimeout(function(){window.location.reload()},220);
                 })
			},error:function(){
				$(".exampleModal").modal("hide");
				showTips("删除失败")
			}
		})
	}
}