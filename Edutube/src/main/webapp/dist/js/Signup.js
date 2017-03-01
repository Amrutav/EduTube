$(document).ready(function(){
	
	$("#txtEmaill").blur(function(){
		dataObject = {
				'email':$('#txtEmaill').val()
		};
		console.log(dataObject);
		var email=$('#txtEmaill').val();
		$.ajax({
		    url: 'http://localhost:8080/Edutube/user/validateEmail?email='+email,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		        console.log(result); 
		if(result.status=="NOT EXIST"){
			//alert("ok");
		    }else if (result.status=="EXIST"){	
		    	alert("This Email is taken. Choose Anathor please");
		}
		}
		});
	});
	
	
	$("#txtUserName").blur(function(){
		dataObject = {
		'username':$('#txtUserName').val()
		};
		console.log(dataObject);
		var uname=$('#txtUserName').val();
		$.ajax({
		    url: 'http://localhost:8080/Edutube/user/validateUsername?username='+uname,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(result) {
		        console.log(result);
		        if(result.status=="NOT EXIST"){
					//alert("ok");
				    }else if(result.status=="EXIST"){	
//				    	var result1=result.status;
//				    	console.log(result1);
				    	alert("This Username is taken. Choose Anathor please");
				    }
		
		}
		});
	});
	
	
	

$('#defaultForm').formValidation({
        message: 'This value is not valid',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            firstName: {
                
                validators: {
                    notEmpty: {
                        message: 'The first name is required'
                    },
        stringLength: {
            max: 20,
            message: 'The firstname can not be more than 20'
        },
                    regexp: {
                        regexp: /^[a-zA-Z]+$/,
                        message: 'Firstname can only consist of alphabets'
                    }
                }
            },
            lastName: {
                
                validators: {
                    notEmpty: {
                        message: 'The last name is required'
                    },
                    stringLength: {
                        max: 20,
                        message: 'The firstname can not be more than 20'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z]+$/,
                        message: 'Lastname can only consist of alphabets'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            },
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
                  },
                  regexp: {
                      regexp: /^[a-zA-Z0-9_\.]+$/,
                      message: 'The username can only consist of alphabetical, number, dot and underscore'
                  }
              }
          },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    },

                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    },
                    identical: {
                        field: 'password',
                        message: 'The password and its confirm are not the same'
                    }
                   
                }
            }
            
	}
	});










$( "#signup" ).click(function( event ) {
	var aFname=$("#txtFName").val();
	var aLname=$('#txtLName').val();
	var aEmail=$('#txtEmaill').val();
	var aUname=$('#txtUserName').val();
	var apwd=$('#txtPasswordd').val();
	var aCpwd=$('#txtCPassword').val()
	if(aFname==""){
		$("#txtFName").focus();
		return false;
	}
	if(aLname==""){
		$("#txtLName").focus();
		return false;
	}
	if(aEmail==""){
		$("#txtEmaill").focus();
		return false;
	}
	if(aUname==""){
		$("#txtUserName").focus();
		return false;
	}
	if(apwd==""){
		$("#txtPasswordd").focus();
		return false;
	}
	if(aCpwd==""){
		$("#txtCPassword").focus();
		return false;
	}
	else{
	dataObject = {
  'userFirstName':$('#txtFName').val(),
  'userLastName':$('#txtLName').val(),
  'email':$('#txtEmaill').val(),
  'username':$('#txtUserName').val(),
  'password':$('#txtPasswordd').val()
  };
	}
console.log(dataObject);
$(this).prop('disabled',true);
$.ajax({
    url: '/Edutube/user/register',
    type: 'post',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:JSON.stringify(dataObject),
    success: function(result) {
        console.log(result); 
if(result.status=="SUCCESS"){
	window.location="/Edutube/RegisterSuccessfully.jsp";
	alert("ok");
	
	//sendEmail();
//$.msgbox({type: 'success',content: 'Registration is Successful ,Thanks for registering in Edutube',	title:'User Registration'});
//window.locate="UserLogin.jsp"
    }else if (result.status=="ERROR"){	
//	$.msgbox({	type: 'error',	content: 'Server error',	title: 'Submission error'});
}else{
	alert("Not ok");
//$.msgbox({type: 'warning',content: 'Unfortunately we are unable to process your request Inconvenience regretted',title: 'System Warning'});
}
}
});

});

$( "#qwerty" ).click(function( event ) {
	dataObject = {
  'username':$('#txtUName').val(),
  'password':$('#txtPwd').val()
  };
console.log(dataObject);
	
$.ajax({
    url: '/Edutube/user/login',
    type: 'post',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:JSON.stringify(dataObject),
    success: function(result) {
    	console.log(result);
    	console.log(result.user.userId); 
        console.log(result.user.userTermsCondn);
        console.log(result);
        	if(result.status=="SUCCESS"){
        		//alert("ok");
        		var userData=result.user.userId;
        		var session = sessionStorage.setItem("UserData",userData);
        		console.log(session);
        		dataObject = {
        				'userId':result.user.userId
        			};
        			console.log(dataObject);
        			$.ajax({
        				url: '/Edutube/user/updateLoginDetails',
        				type: 'post',
        				contentType: "application/json; charset=utf-8",
        				dataType:'json',
        				data:JSON.stringify(dataObject),
        				success: function(response) {
        					console.log(response); 
        					console.log(result);
        					console.log(result.user.userTermsCondn);
        						if(response.status=="SUCCESS"){
        							//alert("ok");
        							if(result.user.userTermsCondn==1){
        							
        										if(result.user.userType=="TUTOR"){
        											var uid=sessionStorage.getItem("UserData");	
        									    	console.log(uid);
        									    	window.location="/Edutube/TutorProfile.jsp";
        										}else if (result.user.userType=="STUDENT") {
        											window.location="/Edutube/StudentProfile.jsp";
												}else if (result.user.userType=="PARENT") {
													window.location="/Edutube/index.jsp";
												}else {
													window.location="/Edutube/AsignUser.jsp";
												}
        								}
        							else {
        								window.location="/Edutube/EdutubeInner.jsp";
									}
        						}
        						else {
        								alert("Not Ok")
        								}
        					}
        					});
	
	
	
	
	
	
	//window.location="http://localhost:8080/Edutube/index.jsp";
//$.msgbox({type: 'success',content: 'Registration is Successful ,Thanks for registering in Edutube',	title:'User Registration'});
    }else if (result.status=="ERROR"){	
//	$.msgbox({	type: 'error',	content: 'Server error',	title: 'Submission error'});
}else{
	alert("Not ok");
//$.msgbox({type: 'warning',content: 'Unfortunately we are unable to process your request Inconvenience regretted',title: 'System Warning'});
}
}
});

});

//$("#tknReg").click(function(event) {
//	dataObject = {
//  'token':$('#txtToken').val()
//  };
//var token=$('#txtToken').val();
//console.log(dataObject);
//$(this).prop('disabled',true);
//$.ajax({
//    url: '/Edutube/user/activateAccount?token='+token,
//    type: 'get',
//	contentType: "application/json; charset=utf-8",
//	dataType:'json',
//	data:JSON.stringify(dataObject),
//    success: function(result) {
//        console.log(result); 
//if(result.status=="ACTIVATED"){
//	window.location="/Edutube";
//	alert("ok");
//    }else if (result.status=="NOT ACTIVATED"){	
//alert("Not Ok")
//}else{
//	alert("Not ok");
////$.msgbox({type: 'warning',content: 'Unfortunately we are unable to process your request Inconvenience regretted',title: 'System Warning'});
//}
//}
//});
//
//});



});