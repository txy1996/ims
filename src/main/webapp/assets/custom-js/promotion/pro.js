// 展示提示框
function showTips(content) {
	$("#op-tips-content").html(content);
	$("#op-tips-dialog").modal("show");
}
// 重置用户表单
function resetUserForm(title, button) {
	$(".user-form input[type='text']").val("");
	$(".user-form input[name='scid']").prop("disabled", false);
	$(".user-form-title").html(title);
	$(".user-submit").html('<i class="ace-icon fa fa-check"></i>' + button);
}

// 添加用户框体
$(".show-add-form").click(function() {
	resetUserForm("添加详情", "添加");   
});



$('#exampleModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget) // 触发事件的按钮
	var recipient = button.data('whatever') // 解析出data-whatever内容
	var modal = $(this)
	modal.find('.modal-body input').val(recipient)
})


$('.main-content').on('hidden.bs.modal', function() {
	document.getElementsByTagName('body')[0].className = 'modal-open';
});
