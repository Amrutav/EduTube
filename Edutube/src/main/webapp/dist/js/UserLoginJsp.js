$(document).ready(function() {
    // Generate a simple captcha
//    function randomNumber(min, max) {
//        return Math.floor(Math.random() * (max - min + 1) + min);
//    };
//    $('#captchaOperation').html([randomNumber(1, 100), '+', randomNumber(1, 200), '='].join(' '));

    $('#loginForm').formValidation({
        message: 'This value is not valid',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
//                    },
//                    regexp: {
//                        regexp: /^[a-zA-Z0-9_\.]+$/,
//                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    },
                    different: {
                        field: 'username',
                        message: 'The password cannot be the same as username'
                    }
                }
            }
            
            
        }
    });
});
   
    

$( "#signin" ).click(function( event ) {
	dataObject = {
  'username':$('#username').val(),
  'password':$('#password').val()
};

console.log(dataObject);
	
$.ajax({
    url: 'http://localhost:8080/FwdSample/user/login',
    type: 'post',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:JSON.stringify(dataObject),
    success: function(result) {
        console.log(result); 
if(result.status=="SUCCESS"){
	$.msgbox({type: 'success',content: 'Login is Successful',	title:'User Login'});
	//$.load();
	
//	if(student){
//		window.location="http://localhost:8080/FwdSample/user/studentHome?userId="+result.user.userId;
//	}
//	else{
//		window.location="http://localhost:8080/FwdSample/user/teacherHome?userId="+result.user.userId;
//	}
	
	window.location="http://localhost:8080/FwdSample/user/userHome?userId="+result.user.userId;
//	$.ajax({
//		url: 'http://localhost:8080/FwdSample/user/userHome',
//	    type: 'get',
//		contentType: "application/json; charset=utf-8",
//		dataType:'json',
//		data:dataObject,
//	    success: function(result) {
//	    	
//	    }
//	});
}else if (result.status=="FAILED"){	
	$.msgbox({	type: 'error',	content: 'Login error',	title: 'Login Failed'});
}else if (result.status=="ERROR"){	
	$.msgbox({	type: 'error',	content: 'Server error',	title: 'Submission error'});
}else{
$.msgbox({type: 'warning',content: 'Unfortunately we are unable to process your request Inconvenience regretted',title: 'System Warning'});
}
}
});

});