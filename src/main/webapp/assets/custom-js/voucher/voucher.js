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
    resetPermForm("更新权限信息","更新");
    var vid=$(this).parents("tr").find(".vid").html();
   
    $.ajax({
        url:"getVoucher.html",
        data:{id:vid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	 $(".perm-form input[name='vid']").val(vid);
        	 $(".perm-form input[name='vmoney']").val(data.vmoney);
             $(".perm-form input[name='vcost']").val(data.vcost);
             $(".perm-form input[name='vprice']").val(data.vprice);
             $(".perm-form input[name='vsdate']").val(data.vsdate);
             $(".perm-form input[name='vodate']").val(data.vodate);
             $(".perm-form input[name='vgoods']").val(data.vgoods);
             $(".perm-form input[name='vintegration']").val(data.vintegration);
             $(".perm-form input[name='vtitle']").val(data.vtitle);
             $(".perm-form input[name='vinfo']").val(data.vinfo);
             $(".perm-form input[name='vimg']").val(data.vimg);
             if(data.vrange==='all'){
                 $(".perm-form input[type='radio'][name='vrange']").prop("checked",false);
                 $(".perm-form input[type='radio'][name='vrange'][value='all']").prop("checked",true);
             }else if(data.vrange==='p:1'){
                 $(".perm-form input[type='radio'][name='vrange']").prop("checked",false);
                 $(".perm-form input[type='radio'][name='vrange'][value='p:1']").prop("checked",true);
             }else if(data.vrange==='s:1'){
                 $(".perm-form input[type='radio'][name='vrange']").prop("checked",false);
                 $(".perm-form input[type='radio'][name='vrange'][value='s:1']").prop("checked",true);
             }else{
                 $(".perm-form input[type='radio'][name='vrange']").prop("checked",false);
             }
             
             if(data.visood===1){
                 $(".perm-form input[type='checkbox'][name='visood']").prop("checked",true);
             }
             if(data.vrefund===1){
                 $(".perm-form input[type='checkbox'][name='vrefund']").prop("checked",true);
             }

        }
    });
});

//添加、更新动作
$(".perm-submit").click(function(){
	debugger;
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
    var vid=permTr.find(".vid").html();
   /* var name=permTr.find(".name").html();*/
    if(confirm('确认删除该条数据吗？')){
        //请求删除该权限
        $.ajax({
            url:"delete.html",
            data:{id:vid},
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

