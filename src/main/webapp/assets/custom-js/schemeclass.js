// 展示提示框
function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}
//重置用户表单
function resetUserForm(title,button){
    $(".user-form input[type='text']").val("");
    $(".user-form input[name='scid']").prop("disabled",false);
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
    var scid=$(this).parents("tr").find(".scid").html();
    $("input[name='scid']").val(scid);
    $.ajax({
        url:"list.html",
        data:{scid:scid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	$("select[name='scscid']").val(data.scscid);
        	$("select[name='scname']").val(data.scname);
        	$("input[name='scinfo']").val(data.scinfo);
         
        }
    });
});

//添加、更新动作
$(".user-submit").click(function(){
	 if($(this).html().indexOf("添加")>0){
        //添加新用户
        $.ajax({
            url:"addClass.html",
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
            url:"updateClass.html",
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
    var scid = userTr.find(".scid").html();
    var scname = userTr.find(".scname").html();
    if (confirm('确认删除用户[' + scname + ']吗？')) {
        $.ajax({
            url: "deleteClass.html",
            data: {scid: scid},
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
        url:"addClass.html",
        type:"POST",
        data:$(".for").serialize(),
        dataType:"json",
        success:function(data){
        	$(".exampleModal").modal("hide");
        	showTips("添加成功");
        	$(".close-tip").click(function () {
        		setTimeout(function(){window.location.reload()},220);
        	})                                	
        },
        error:function(){
        	$(".exampleModal").modal("hide");
            showTips("更新失败！");
        }
})
})

function dele(id){
	console.log(id);
	$.ajax({
		url : "deleteClass.html",
		type : "POST",
		ansyc : 'true',
		data : {
			'scid' : id,
		},
		//traditional:true,
		success : function() {
			//setTimeout(function(){window.location.reload()},220);
			$(".exampleModal").modal("hide");
			showTips("删除成功")
			$(".close-tip").click(function () {
        		setTimeout(function(){window.location.reload()},220);
        	})
			},error:function(){
				$(".exampleModal").modal("hide");
				showTips("删除失败")
				
			}
		})
}
