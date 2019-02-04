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
    var sid=$(this).parents("tr").find(".sid").html();
    $("input[name='sid']").val(sid);
    $.ajax({
        url:"getUser.html",
        data:{sid:sid},
        type:"POST",
        dataType:"json",
        success:function(data){
          	/*$("input[name='scid']").prop("disabled",true);*/
        	$("input[name='sid']").val(data.sid);
        	$("select[name='zid']").val(data.zid);
        	
        	$("select[name='bid']").val(data.bid);
        	$("select[name='scid']").val(data.scid);
        	/*$("input[name='scid']").val(data.scid);*/
        	$("input[name='sname']").val(data.sname);
        	$("input[name='saddress']").val(data.saddress);
        	$("input[name='stel']").val(data.stel);
        	$("input[name='scoordinate']").val(data.scoordinate);
        	$("button[name='jingweidu']").val(data.scoordinate);
        	$("input[name='scommerce']").val(data.scommerce);
        	
        	if(data.sstate===0){
                $(" input[type='radio'][name='sstate']").prop("checked",false);
                $(" input[type='radio'][name='sstate'][value='0']").prop("checked",true);
            }else if(data.sstate===1){
                $(" input[type='radio'][name='sstate']").prop("checked",false);
                $(" input[type='radio'][name='sstate'][value='1']").prop("checked",true);
            }else if(data.sstate===2){
                $(" input[type='radio'][name='sstate']").prop("checked",false);
                $(" input[type='radio'][name='sstate'][value='2']").prop("checked",true);
            }
        	/*$("input[name='syear']").val(data.syear);
        	$("input[name='sstyle']").val(data.sstyle);
        	$("select[name='slevel']").val(data.slevel);
        	$("input[name='scompartmentnum']").val(data.scompartmentnum);
        	$("input[name='stcompartment']").val(data.stcompartment);
        	$("input[name='scompartmentinfo']").val(data.scompartmentinfo);
        	$("input[name='scompartmentmin']").val(data.scompartmentmin);*/
        	//$("input[name='smax']").val(data.smax);
        	
        	
        	
        	
        	/*$("textarea[name='smeetingplace']").val(data.smeetingplace);*/
//        	$("#editor").html(data.smeetingplace); 
//        	$("#editor").val(data.smeetingplace);
//        	$("#editor").text(data.smeetingplace);
//        	$("#editor").attr("",data.smeetingplace);
        	
        	$("textarea[name='sad']").val(data.sad);
//        	$("#editor2").val(data.sad)
        	$("textarea[name='sinfo']").val(data.sinfo);
        	//$("input[name='ssmeetingplacemin']").val(data.ssmeetingplacemin);
        	$("input[name='ssort']").val(data.ssort);
        	
        	if(data.sbalancetype===1){
                $(" input[type='radio'][name='sbalancetype']").prop("checked",false);
                $(" input[type='radio'][name='sbalancetype'][value='1']").prop("checked",true);
            }else if(data.sbalancetype===2){
                $(" input[type='radio'][name='sbalancetype']").prop("checked",false);
                $(" input[type='radio'][name='sbalancetype'][value='2']").prop("checked",true);
            }else if(data.sbalancetype===3){
                $(" input[type='radio'][name='sbalancetype']").prop("checked",false);
                $(" input[type='radio'][name='sbalancetype'][value='3']").prop("checked",true);
            }else{
            	$(" input[type='radio'][name='sbalancetype']").prop("checked",false);
                $(" input[type='radio'][name='sbalancetype'][value='4']").prop("checked",true);
            }
        	
        	$("input[name='sbwx']").val(data.sbwx);
        	$("input[name='sbzfb']").val(data.sbzfb);
        	$("input[name='sbyhk']").val(data.sbyhk);
        	$("input[name='slogo']").val(data.slogo);
        	$("input[name='styleimg']").val(data.styleimg);
         
        }
    });
});

//添加、更新动作
$(".user-submit").click(function(){
	
	 if($(this).html().indexOf("添加")>0){
        //添加新商户
        $.ajax({
            url:"add.html",
            type:"POST",
            processData: false,
    	    contentType: false,
            data:new FormData($('.user-form')[0]),
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
    	console.log("更新啦")
        $.ajax({
            url:"update.html",
            data:new FormData($('.user-form')[0]),
            type:"POST",
            processData: false,
    	    contentType: false,
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
    var sid = userTr.find(".sid").html();
    var sname = userTr.find(".sname").html();
    if (confirm('确认删除用户[' + sname + ']吗？')) {
        $.ajax({
            url: "delete.html",
            data: {sid: sid},
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

//跳转用户评论记录界面
$(".user-list").on("click", ".jump-comment", function() {
	var userTr = $(this).parents("tr");
	var sid = userTr.find(".sid").html();
	console.log(sid)
	$.ajax({
		url : "../userAssess/list.html",
		dataType : "html",// 特别重要
		data : {
            uaoid : sid,

		},
		type : "POST",
		success : function(data) {
			$("#shopbody").html(data)
		},
		error : function() {

		}
	});

});

//跳转商品管理界面
$(".user-list").on("click", ".jump-comment111", function() {
	var userTr = $(this).parents("tr");
	var sid = userTr.find(".sid").html();
	console.log(sid)
	$.ajax({
		url : "../product/selectProduct.html",
		dataType : "html",// 特别重要
		data : {
			sid : sid

		},
		type : "POST",
		success : function(data) {
			$("#shopbody").html(data)
		},
		error : function() {

		}
	});

});

//跳转积分管理界面
$(".user-list").on("click", ".jifen", function() {
	var userTr = $(this).parents("tr");
	var sid = userTr.find(".sid").html();
	console.log(sid)
	$.ajax({
		url : "../slintegration/list.html",
		dataType : "html",// 特别重要
		data : {
			sid : sid
		},
		type : "POST",
		success : function(data) {
			$("#shopbody").html(data)
		},
		error : function() {

		}
	});

});

//跳转金币管理界面
$(".user-list").on("click", ".jinbi", function() {
	var userTr = $(this).parents("tr");
	var sid = userTr.find(".sid").html();
	console.log(sid)
	$.ajax({
		url : "../goods_shop/list.html",
		dataType : "html",// 特别重要
		data : {
			sid : sid
		},
		type : "POST",
		success : function(data) {
			$("#shopbody").html(data)
		},
		error : function() {

		}
	});

});


//跳转相册界面
$(".user-list").on("click", ".xiangce", function() {
	var userTr = $(this).parents("tr");
	var sid = userTr.find(".sid").html();
	console.log(sid)
	$.ajax({
		url : "../photo/list.html",
		dataType : "html",// 特别重要
		data : {
			sid : sid,

		},
		type : "POST",
		success : function(data) {
			$("shopbody").html(data)
		},
		error : function() {

		}
	});

});

var recipient1='';
$('#exampleModal1').on('show.bs.modal',function(event) {
	var idd = $('#wlmslist option').filter(function() {
        return this.value == $("#guanggao").val();;
    }).data('xyz');
	var bcdd = $("#guanggao").val();
	var ggid=$('#ggid').val();
	if(bcdd==null){
		$.ajax({
			url : "findpromlist.html",
			type : "POST",
			ansyc : 'true',
			dataType : "JSON",
			data : {
				'id' : idd
			},
			success : function(data4) {
			console.log(data4)
			var obj = JSON.parse(data4);
			console.log(obj)
			$("#wlmslist option").remove();
			var aaa = '';
			$.each(obj,function(a,b) {
						aaa = "["
								+ b["pzone"]
								+ "]"
								+ "["
								+ b["psource"]
								+ "]"
						var ccc = b["id"];
						var option = $("<option data-xyz='"
								+ b["id"]
								+ "'>"
								+ aaa
								+ "</option>");
						$('#wlmslist').append(option)
					})
					ggid = $('#wlmslist option').filter(function() {
				        return this.value == $("#guanggao").val();;
				    }).data('xyz');
			console.log("wori")
			console.log(ggid)
			},
			
		})
		
	}
	
	
	
	
	var button = $(event.relatedTarget) // 触发事件的按钮
	recipient1 = button.data('whatever') // 解析出data-whatever内容
	var modal = $(this)
	modal.find('.modal-body input #inp').val(recipient1) 
//	var aa = $('#ggfl option:selected') .val();
	console.log("-0-0-0-0-0-")
	console.log(recipient1)
//	console.log(aa)
	console.log("-0-0-0-0-0-")
	$.ajax({
						url : "findshopname.html",
						type : "POST",
						ansyc : 'true',
						dataType : "JSON",
						data : {
							'id' : recipient1
						},
						success : function(data2) {
							$('h4').html("推荐" + data2 + "到")
						},
						error : function() {
							console.log("error")
						}
					})
	console.log("3-3-3--3")
	console.log(ggid)
	console.log("3-3-3--3")
	//debugger
			if(ggid!=""){
				$.ajax({
					url : "findprombyid.html",
					type : "POST",
					ansyc : 'true',
					dataType : "html",
					data : {
						'id' : ggid
					},
					success : function(data2) {
						console.log("2-2-2-2-2-2")
						var obj = JSON.parse(data2);
						console.log(obj.ptype)
						console.log("2-2-2-2-2-2")
						if(obj.ptype==5){
							var select=document.getElementById("ggfl");
						    var arr=select.getElementsByTagName("option");
						    arr[1].selected="selected";
						    console.log($('#ggfl option:selected').text())
						}else if(obj.ptype==11){
							var select=document.getElementById("ggfl");
						    var arr=select.getElementsByTagName("option");
						    arr[2].selected="selected";
						}else if(obj.ptype==8){
							var select=document.getElementById("ggfl");
						    var arr=select.getElementsByTagName("option");
						    arr[3].selected="selected";
						}						
						getCategory();
						$("#guanggao").val("["+obj.pzone+"]"+"["+obj.psource+"]")
					},
					error : function() {
						console.log("error")
					}
				})
			}
//	 if(ggid!=null){
//		 
//	 }
})

function getCategory() {
	var aa = $('#ggfl option:selected').val();
	console.log("-0-0-0-0-0-")
	console.log(recipient1)
	console.log(aa)
	console.log("-0-0-0-0-0-")
	$.ajax({
		url : "ShopRecommend.html",
		type : "POST",
		ansyc : 'true',
		dataType : "html",
		data : {
			'ptype' : aa
		},
		success : function(data) {
			var obj = JSON.parse(data);
			console.log(obj)
			$("#wlmslist option").remove();
			var aaa = '';
			$.each(obj,function(a,b) {
//				"["
//				+ b["id"]
//				+ "]"
//				+ "["
//				+ b["ptype"]
//				+ "]"
						aaa = "["
								+ b["pzone"]
								+ "]"
								+ "["
								+ b["psource"]
								+ "]"
						var ccc = b["id"];
						var option = $("<option data-xyz='"
								+ b["id"]
								+ "'>"
								+ aaa
								+ "</option>");
						$('#wlmslist').append(option)

					})
		},error :function(){
			
		}
	})
	
	$(".save111").click(function() {
		var id = $('#wlmslist option').filter(function() {
	        return this.value == $("#guanggao").val();;
	    }).data('xyz');
		var abc = $("#ggfl").find("option:selected").text();
		var bcd = $("#guanggao").val();
		console.log("1-1-1-1-1")
		console.log(abc)
		console.log(bcd)
		console.log(id)
		console.log(recipient1)
		console.log("1-1-1-1-1")
		$.ajax({
			url : "../promotion/Recommend.html",
			type : "POST",
			ansyc : 'true',
			data : {
				'id' : id,
				'sid' : recipient1
			},
			success : function(){
				$("#ggfl").find("option:selected").text(abc);
				$("#guanggao").val(bcd);
				$("#user-form-div").modal("hide");
				showTips("推荐成功！");
				$(".close-tip").click(function() {
					setTimeout(function() {
						window.location.reload()
					}, 220);
				})
			}
		})
	})
}
