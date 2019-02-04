//展示提示框
function showTips(content){
    $("#op-tips-content").html(content);
    $("#op-tips-dialog").modal("show");
}

// 重置权限表单
function resetPermForm(title,button){
    $(".perm-form input[type='text']").val("");
    $(".perm-form input[type='checkbox']").prop("checked",false);

    $(".perm-form-title").html(title);
    $(".perm-submit").html('<i class="ace-icon fa fa-check"></i>'+button);
}

//添加权限框体
$(".show-add-form").click(function(){
    resetPermForm("添加新权限","添加");
});


// 更新权限框体
$(".perm-list").on("click",".show-update-form",function(){
    resetPermForm("更新权限信息","更新");
    var sssid=$(this).parents("tr").find(".sssid").html();
    $.ajax({
        url:"getStaShop.html",
        data:{id:sssid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	console.log(data);
        	var obj = $("#shopid"); 
        	for(var i=0;i<obj[0].length;i++){  
        	    if(obj[0][i].value==data.shopid){  
        	    	obj[0][i].selected=true;  //相等则选中  
        	    }  
        	} 
        	debugger;
        	var obj = $("#ssid"); 
        	for(var i=0;i<obj[0].length;i++){  
        	    if(obj[0][i].value==data.ssid){  
        	    	obj[0][i].selected=true;  //相等则选中  
        	    }  
        	} 
            $(".perm-form input[name='sssid']").val(sssid);
            $(".perm-form input[name='ssad']").val(data.ssad);
            $(".perm-form input[name='ssimgs']").val(data.ssimgs);
            $(".perm-form input[name='ssinfo']").val(data.stage.ssinfo);
        }
    });
});

//添加、更新动作
$(".perm-submit").click(function(){
    if($(this).html().indexOf("添加")>0){
        //请求添加新权限
        $.ajax({
            url:"add.html",
            type:"POST",
            data:$(".perm-form").serialize(),
            dataType:"json",
            success:function(data){
            	if(confirm("是否添加该条信息")){
            	  window.location.href='${path}/stage/list';  
        	           }
            }
        });
    }else{
        //请求更新权限
        $.ajax({
            url:"update.html",
            data:$(".perm-form").serialize(),
            type:"POST",
            success:function(){
            	if(confirm("是否更新该条信息")){
              	  window.location.href='${path}/stage/list';  
          	   }
            }
        });
    }
});

//全选/取消全选出现的active阴影
var active_class = 'active';
$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
    var th_checked = this.checked;//checkbox inside "TH" table header

    $(this).closest('table').find('tbody > tr').each(function(){
        var row = this;
        if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
        else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
    });
});

//单行选中出现active阴影
$('#simple-table').on('click', 'td input[type=checkbox]' , function(){
    var $row = $(this).closest('tr');
    if($row.is('.detail-row ')) return;
    if(this.checked) $row.addClass(active_class);
    else $row.removeClass(active_class);
});

//删除单个角色
$(".perm-list").on("click",".delete-this-perm",function(){
	debugger;
    var permTr=$(this).parents("tr");
    var ssid=permTr.find(".ssid").html();
    if(confirm('确认删除该条信息吗？')){
        //请求删除该权限
        $.ajax({
            url:"delete.html",
            data:{id:ssid},
            type:"POST",
            success:function(){
                permTr.remove();
                showTips("删除成功！"); 
            	
            },
          error:function(){
                showTips("删除失败！");
            } 
        });
    }
});