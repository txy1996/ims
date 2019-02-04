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

/*//添加用户框体
$(".show-add-form").click(function(){
    resetUserForm("添加分类","添加");
});*/


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
    var lid = userTr.find(".lid").html();
    console.log(lid)
    var urid = $("#urid11").val();
//    var sname = userTr.find(".sname").html();
//    if (confirm('确认删除用户[' + sname + ']吗？')) {
    	if (confirm('确认删除用户此标签吗？')) {
        $.ajax({
            url: "delete.html",
            data: {lid: lid,
            		urid:urid
            },
            type: "POST",
            success: function () {
            	$(".exampleModal").modal("hide");
                showTips("删除成功！");
                $(".close-tip").click(function () {
                    setTimeout(function(){window.location.reload()},220);
                    })
            },
            error: function () {
            	$(".exampleModal").modal("hide");
                showTips("删除失败！");
            }
        });
    }
});


//更新查询
$(".user-list").on("click",".show-update-form",function(){
    //resetUserForm("更新分类信息","更新");
    var lid=$(this).parents("tr").find(".lid").text();
    var text=$(this).parents("tr").find(".text").text();
    var lcinfo=$(this).parents("tr").find(".lcinfo").text();
    //$("input[name='lid']").val(lid);
    //$("#sel1").val(text)
    //$("input[name='lcinfo']").val(lcinfo);
    $.ajax({
        url:"getLabel.html",
        data:{lid:lid,
        },
        type:"POST",
        dataType:"json",
        success:function(data){
        	console.log("-----------")
        	console.log(data.labelclass.text)
        	console.log("-----------")        	
        	$("input[name='lid000']").val(data.lid);
        	/* $("select[name='sel11']").val(data.labelclass.text); */
        	$("input[name='lcinfo']").val(data.lcinfo);
        	$("select[name='sel11']").val(data.labelclass.lcid);
        	/* $("#sel11").val(data.labelclass.text); */
        	console.log($("#sel11").val())
        }
    });
});

function update(){
	 var lid=$("#form-add-lid1").val();
	 var lcid=$("#sel11").val();
	 var lcinfo=$("#lcinfo12").val();
	 console.log(lid)
	 console.log(lcid)
	 console.log(lcinfo)
	 
	 $.ajax({
	        type:"POST",
	        url:"update.html",
	        data: {
	        	lid:lid,
	        	lcid:lcid,
	   		 lcinfo:lcinfo
	        },//必要
	        success:function(){
	        	$(".exampleModal").modal("hide");
				showTips("更新成功！");
				 $(".close-tip").click(function () {
	                 setTimeout(function(){window.location.reload()},220);
	                 })
	        	
	        },error:function(){
	        	$(".exampleModal").modal("hide");
				showTips("更新失败")
	        }
	    }); 
} 