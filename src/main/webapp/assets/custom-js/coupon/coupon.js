// 展示提示框
function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}
//重置用户表单
function resetUserForm(title,button){
    $(" input[type='text']").val("");
    $("-title").html(title);
    $(".user-submit").html('<i class="ace-icon fa fa-check"></i>'+button);
}

//添加用户框体
$(".show-add-form").click(function(){
    resetUserForm("添加分类","添加");
});
//更新权限框体
$(".user-list").on("click",".show-update-form",function(){
	resetUserForm("更新权限信息","更新");
    var cid=$(this).parents("tr").find(".cid").html();
    $("input[name='cid']").val(cid);
    $.ajax({
        url:"getUpdate.html",
        data:{id:cid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	var obj = $("#ccid");
        	for(var i=0;i<obj[0].length;i++){  
        	    if(obj[0][i].value==data.ccid){  
        	    	obj[0][i].selected=true;  //相等则选中  
        	    }  
        	} 
        	$(" input[name='csum']").val(data.csum);
        	$(" input[name='cmoney']").val(data.cmoney);
        	 $(" input[name='cprice']").val(data.cprice);
             $(" input[name='csdate']").val(data.csdate);
             $(" input[name='codate']").val(data.codate);
             $(" input[name='cgoods']").val(data.cgoods);
             $(" input[name='cintegration']").val(data.cintegration);
             $(".input input[name='vimg']").val(data.vimg);
             $(" input[name='ctitle']").val(data.ctitle);
             $(" input[name='cinfo']").val(data.cinfo);
             if(data.crange==='all'){
                 $(" input[type='radio'][name='crange']").prop("checked",false);
                 $(" input[type='radio'][name='crange'][value='all']").prop("checked",true);
             }else if(data.crange==='p:1'){
                 $(" input[type='radio'][name='crange']").prop("checked",false);
                 $(" input[type='radio'][name='crange'][value='p:1']").prop("checked",true);
             }else if(data.crange==='s:1'){
                 $(" input[type='radio'][name='crange']").prop("checked",false);
                 $(" input[type='radio'][name='crange'][value='s:1']").prop("checked",true);
             }/*else{
                 $(" input[type='radio'][name='crange']").prop("checked",false);
             }*/
             
             if(data.cisood===0 || data.cisood===null){
                 $(" input[type='radio'][name='cisood']").prop("checked",false);
                 $(" input[type='radio'][name='cisood'][value='0']").prop("checked",true);
             }else if(data.cisood===1){
            	 $(" input[type='radio'][name='cisood']").prop("checked",false);
                 $(" input[type='radio'][name='cisood'][value='1']").prop("checked",true);
             }else{
                 $(" input[type='radio'][name='cisood'][value='1']").prop("checked",true);
             }
             $(" input[name='cisrepeat']").val(data.cisrepeat);
             $(" input[name='uaid']").val(data.uaid);
        }
    });
});
//添加、更新动作
$(".user-submit").click(function(){
	 if($(this).html().indexOf("添加")>0){
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
    var cid = userTr.find(".cid").html();
    var ctitle = userTr.find(".ctitle").html();
    if (confirm('确认删除用户[' + ctitle + ']吗？')) {
        $.ajax({
            url: "delete.html",
            data: {cid: cid},
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
