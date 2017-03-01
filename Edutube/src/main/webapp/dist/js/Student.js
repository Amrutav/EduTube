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
				window.location="http://localhost:8080/FwdSample/user/userHome?userId="+result.user.userId;
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


$('.form_datetime').datetimepicker({
    //language:  'fr',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	forceParse: 0,
    showMeridian: 1,
	format: 'dd/mm/yyyy'
});
$('.form_date').datetimepicker({
    language:  'fr',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: 0,
	format: 'dd/mm/yyyy'
});
$('.form_time').datetimepicker({
    language:  'fr',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 1,
	minView: 0,
	maxView: 1,
	forceParse: 0,
	format: 'dd/mm/yyyy'
});







$( "#edit" ).click(function( event ) {
	dataObject = {
  'student_id':$('#student_id').val(),
  'student_first_name':$('#firstname').val(),
  'student_last_name':$('#lastname').val(),
  'student_age':$('#age').val(),
  'dob':$('#dateInput').val(),
  'student_gender':$('#gender1').val()
  };	
console.log(dataObject);

	
	$.ajax({
		url: 'http://localhost:8080/Edutube/student/editPersonal',
		type: 'post',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
		success: function(result) {
			
			console.log(result); 
			if(result.status=="SUCCESS"){
				$.msgbox({type: 'success',content: 'edit is Successful',	title:'Edit Profile'});
				//$.load();
				//window.location="http://localhost:8080/FwdSample/user/userHome?userId="+result.user.userId;
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


