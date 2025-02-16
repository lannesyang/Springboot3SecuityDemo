$(document).ready(function() {
	var hasConfirm = false;
	var accountConfirm = false;
	var passwordConfirm = false;
	var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    $.ajaxSetup({
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
        }
    });
	$("#cfPassword").hide();
	$("#repeatAccount").hide();
	$("#confirmPassword").keyup(function(){
		hasConfirm = true;
		comparePW();
	});
	$("#password").keyup(function() {
		if(hasConfirm == true){
			comparePW();
		}
	});
	$('#account').on('focusout', function() {
		var email = $("#account").val();
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // 簡單的 email 驗證正則表達式
        if (emailPattern.test(email)) {
	        $.ajax({
				url : "/checkAccountExist",
				type : "POST",
				data : email,
				contentType: "application/json; charset=utf-8",
	            dataType: "json",
	            success: function(response){
	            	if(response != 0){
				    	$("#repeatAccount").show();
				    	accountConfirm = false;
				    }else{
				    	$("#repeatAccount").hide();
				    	accountConfirm = true;
				    }
				},
			});
        }
	});
	function comparePW(){
		var pw = $('#password').val();
	    var cp = $('#confirmPassword').val();
	    if(cp != pw){
	    	$("#cfPassword").show();
	    	passwordConfirm = false;
	    }else{
	    	$("#cfPassword").hide();
	    	passwordConfirm = true;
	    }
	}
	$("#register").click(function() {
		if(accountConfirm  == true && passwordConfirm == true){
			var member = {
				'account' : $("#account").val(),
				'password' : $("#password").val(),
			};
		$.ajax({
			url : "/registerResult",
			type : "POST",
			data : JSON.stringify(member),
			contentType: "application/json; charset=utf-8",
            dataType: "json",
			success : function(result) {
				if(result == "0"){
					swal.fire({
                    title: "註冊成功",
                    timer: 2000,
                    type: "success",
                    showConfirmButton: false
	                }).then(() => {
					    window.location.href = "/login"; // 替換成你的目標網址
					});
				}else{
					
				}
			},
			error : function() {
				
			}
		});
		}
	});
});

