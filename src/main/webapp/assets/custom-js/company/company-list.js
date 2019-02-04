
// 展示提示框
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
	debugger;
    resetPermForm("更新权限信息","更新");
    var companyId=$(this).parents("tr").find(".companyId").html();
    $.ajax({
        url:"getMessage.html",
        data:{id:companyId},
        type:"POST",
        dataType:"json",
        success:function(data){
        	console.log(data);
            $(".perm-form input[name='cid']").val(data.cid);
            $(".perm-form input[name='cname']").val(data.cname);
        	$(".perm-form input[name='cidentify']").val(data.cidentify);
        	$(".perm-form input[name='ccode']").val(data.ccode);
        	$(".perm-form input[name='ctel']").val(data.ctel);
        	$(".perm-form input[name='caddress']").val(data.caddress);
        	$(".perm-form input[name='cbank']").val(data.cbank);
        	$(".perm-form input[name='caccount']").val(data.caccount);
        	$(".perm-form input[name='cinfo']").val(data.cinfo);
            if(data.cgeneral_taxpayer==1){
                $(".perm-form input[type='checkbox'][name='cgeneral_taxpayer']").prop("checked",true);
            }


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
                $("#perm-form-div").modal("hide");
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
        //请求更新权限
        $.ajax({
            url:"update.html",
            data:$(".perm-form").serialize(),
            type:"POST",
            success:function(){
                $("#perm-form-div").modal("hide");
                showTips("更新成功！");
               /* $(".close-tip").click(function () {
                     setTimeout(function(){window.location.reload()},220);
                	
                    }
                )*/
                window.location.href='company/list';
            },
            error:function(){
                showTips("更新失败！");
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
    var permTr=$(this).parents("tr");
    var companyId=permTr.find(".companyId").html();
  /*  var name=permTr.find(".name").html();*/
    if(confirm('确认删除该条数据吗？')){
        //请求删除该权限
        $.ajax({
            url:"delete.html",
            data:{id:companyId},
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

