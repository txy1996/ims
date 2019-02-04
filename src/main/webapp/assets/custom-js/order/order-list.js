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

var format = function(time, format){
    var t = new Date(time);
    var tf = function(i){return (i < 10 ? '0' : '') + i};
    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
        switch(a){
            case 'yyyy':
                return tf(t.getFullYear());
                break;
            case 'MM':
                return tf(t.getMonth() + 1);
                break;
            case 'mm':
                return tf(t.getMinutes());
                break;
            case 'dd':
                return tf(t.getDate());
                break;
            case 'HH':
                return tf(t.getHours());
                break;
            case 'ss':
                return tf(t.getSeconds());
                break;
        }
    })
}
// 更新权限框体
$(".perm-list").on("click",".show-update-form",function(){
    resetPermForm("更新权限信息","更新");
    var oid=$(this).parents("tr").find(".oid").html();
    console.log(oid)
    $.ajax({
        url:"../order/getOrder.html",
        data:{id:oid},
        type:"POST",
        dataType:"json",
        success:function(data){
        	var dataOdate = format(data.odate, 'yyyy-MM-dd');
        	/*console.log(dataOdate);*/
        	  $(".perm-form input[name='oid']").val(oid);
        	  $(".perm-form input[name='odate']").val(dataOdate);
              $(".perm-form input[name='onum']").val(data.onum);
              $(".perm-form input[name='omoney']").val(data.omoney);
              $(".perm-form input[name='ogoods']").val(data.ogoods);
              $(".perm-form input[name='ogetintegration']").val(data.ogetintegration);
              $(".perm-form input[name='onoinfo']").val(data.onoinfo);
              $(".perm-form input[name='oshname']").val(data.oshname);
              $(".perm-form input[name='oshtel']").val(data.oshtel);
              $(".perm-form input[name='oshaddress']").val(data.oshaddress);
              $(".perm-form input[name='oexpress']").val(data.oexpress);
              $(".perm-form input[name='oexpresssn']").val(data.oexpresssn); 
              if(data.opaytype===1){
                  $(".perm-form input[type='checkbox'][name='opaytype']").prop("checked",true);
              }
              if(data.oisinvoice===1){
                  $(".perm-form input[type='checkbox'][name='oisinvoice']").prop("checked",true);
              }
              if(data.opaymodel===0){
                  $(".perm-form input[type='radio'][name='opaymodel']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='opaymodel'][value='0']").prop("checked",true);
              }else if(data.opaymodel===1){
                  $(".perm-form input[type='radio'][name='opaymodel']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='opaymodel'][value='1']").prop("checked",true);
              }else if(data.opaymodel===2){
                  $(".perm-form input[type='radio'][name='opaymodel']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='opaymodel'][value='2']").prop("checked",true);
              }else{
                  $(".perm-form input[type='radio'][name='opaymodel']").prop("checked",false);
              }
              
              if(data.oshfs===0){
                  $(".perm-form input[type='radio'][name='oshfs']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='oshfs'][value='0']").prop("checked",true);
              }else if(data.oshfs===1){
                  $(".perm-form input[type='radio'][name='oshfs']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='oshfs'][value='1']").prop("checked",true);
              }else if(data.oshfs===2){
                  $(".perm-form input[type='radio'][name='oshfs']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='oshfs'][value='2']").prop("checked",true);
              }else{
                  $(".perm-form input[type='radio'][name='oshfs']").prop("checked",false);
              }
              
              if(data.ostae===0){
                  $(".perm-form input[type='radio'][name='ostae']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='ostae'][value='0']").prop("checked",true);
              }else if(data.ostae===1){
                  $(".perm-form input[type='radio'][name='ostae']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='ostae'][value='1']").prop("checked",true);
              }else if(data.ostae===2){
                  $(".perm-form input[type='radio'][name='ostae']").prop("checked",false);
                  $(".perm-form input[type='radio'][name='ostae'][value='2']").prop("checked",true);
              }else if(data.ostae===3){
              	  $(".perm-form input[type='radio'][name='ostae']").prop("checked",false);
                    $(".perm-form input[type='radio'][name='ostae'][value='3']").prop("checked",true);
              }else{
                  $(".perm-form input[type='radio'][name='ostae']").prop("checked",false);
              }
              
              if(data.oispay===0){
                    $(".perm-form input[type='radio'][name='oispay']").prop("checked",false);
                    $(".perm-form input[type='radio'][name='oispay'][value='0']").prop("checked",true);
              }else if(data.oispay===1){
                    $(".perm-form input[type='radio'][name='oispay']").prop("checked",false);
                    $(".perm-form input[type='radio'][name='oispay'][value='1']").prop("checked",true);
              }else if(data.oispay===2){
                    $(".perm-form input[type='radio'][name='oispay']").prop("checked",false);
                    $(".perm-form input[type='radio'][name='oispay'][value='2']").prop("checked",true);
              }else if(data.oispay===3){
              	  $(".perm-form input[type='radio'][name='oispay']").prop("checked",false);
                    $(".perm-form input[type='radio'][name='oispay'][value='3']").prop("checked",true);
              }else if(data.oispay===4){
              	  $(".perm-form input[type='radio'][name='oispay']").prop("checked",false);
                    $(".perm-form input[type='radio'][name='oispay'][value='4']").prop("checked",true);
              }else if(data.oispay===5){
            	  	  $(".perm-form input[type='radio'][name='oispay']").prop("checked",false);
                    $(".perm-form input[type='radio'][name='oispay'][value='5']").prop("checked",true);
              }else if(data.oispay===6){
                    $(".perm-form input[type='radio'][name='oispay']").prop("checked",false);
                    $(".perm-form input[type='radio'][name='oispay'][value='6']").prop("checked",true);
              }else{
                    $(".perm-form input[type='radio'][name='oispay']").prop("checked",false);
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
    	var Order=$(".perm-form").serializeArray()
    	var serializeObj={};
    	$(Order).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value; 
            }
        });
    	console.log(serializeObj)
        $.ajax({
            url:"../order/update1.html",
            data:{order:JSON.stringify(serializeObj)},
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
    var oid=permTr.find(".oid").html();
    if(confirm('确认删除该条记录吗？')){
        //请求删除该权限
        $.ajax({
            url:"delete.html",
            data:{id:oid},
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

