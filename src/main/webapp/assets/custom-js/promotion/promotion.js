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
//	var a = $("#ptype").val();
//	if(a=="0"){
//		resetUserForm("更新图片广告的状态","确定");
//    } if(a=="1"){
//    	resetUserForm("更新文字广告的状态","确定");
//    } if(a=="2"){
//    	resetUserForm("更新视频广告的状态","确定");
//    }if(a=="3"){
//    	resetUserForm("更新纯文字列表的状态","确定");
//    } if(a=="4"){
//    	resetUserForm("更新图文列表的状态","确定");
//    }
//    	
	resetUserForm("修改状态","确定")
    var id=$(this).parents("tr").find(".id").html();
    $("input[name='id']").val(id);
    $.ajax({
        url:"getPromotion.html",
        data:{id:id},
        type:"POST",
        dataType:"json",
        success:function(data){
        	if(data.ptype===0){
        		resetUserForm("更新图片广告的状态","确定");
            }else if(data.ptype===1){
            }else if(data.ptype===2){
            }else if(data.ptype===3){
            }else if(data.ptype===4){
            }else{
            	
            }
        	if(data.state===0){
                $(" input[type='radio'][name='state']").prop("checked",false);
                $(" input[type='radio'][name='state'][value='0']").prop("checked",true);
            }else if(data.state===1){
                $(" input[type='radio'][name='state']").prop("checked",false);
                $(" input[type='radio'][name='state'][value='1']").prop("checked",true);
            }else if(data.state===2){
                $(" input[type='radio'][name='state']").prop("checked",false);
                $(" input[type='radio'][name='state'][value='2']").prop("checked",true);
            }
        	
        }
    });
	/*var a = $("#ptype").val();
	if(a==0){
		resetUserForm("更新图片广告的状态","确定");
    }else if(a==1){
    	resetUserForm("更新文字广告的状态","确定");
    }else if(a==2){
    	resetUserForm("更新视频广告的状态","确定");
    }else if(a==3){
    	resetUserForm("更新纯文字列表的状态","确定");
    }else if(a==4){
    	resetUserForm("更新图文列表的状态","确定");
    }else{
    	resetUserForm("更新xx的状态","确定");
    }*/
});

//添加、更新动作
$(".user-submit").click(function(){
	
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
});




