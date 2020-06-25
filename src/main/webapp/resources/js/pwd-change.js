$(function(){
	var form = $("#form-change-password");
	form.submit(function(){
		var user = new Object();
		var password = $("#password").val();
		var password_confirm = $("#password-confirm").val();
		if(password == ""){
			$(".form-password .form-message").text("新密码不能为空！");
			return false;
		}else if(password.length > 20 || password.length <6){
			$(".form-password .form-message").text("长度请保持在6到20之间！");
			return false;
		}else {
			$(".form-password .form-message").text("");
		}
		if(password != password_confirm){
			$(".form-password-confirm .form-message").text("两次密码不一致！");
			return false;
		}else {
			$(".form-password-confirm .form-message").text("");
		}
		user.password = password;
		$.ajax({
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			type : "POST",
			url : form.attr("action"),
			data : JSON.stringify(user),
			success : function(message, tst, jqXHR) {
				if (!util.checkSessionOut(jqXHR))
					return false;
				if (message.result == "success") {
					util.success("修改密码成功", function() {
						document.location.href = document.getElementsByTagName('base')[0].href + 'home';
					});
				} else {
					util.error("操作失败请稍后尝试");
				}

			},
			error : function(jqXHR, textStatus) {
				util.error("操作失败请稍后尝试");
			}
		});
		return false;
	});
});