$( "#btnDisagree" ).click(function( event ) {
    	var uid=sessionStorage.getItem("UserData");	
    	console.log(uid);
    	dataObject = {
    			'userId':uid
      };
    console.log(dataObject);
    	
    $.ajax({
        url: 'http://localhost:8080/Edutube/user/logout',
        type: 'post',
    	contentType: "application/json; charset=utf-8",
    	dataType:'json',
    	data:JSON.stringify(dataObject),
        success: function(result) {
            console.log(result); 
    if(result.status=="SUCCESS"){
    	sessionStorage.clear();
    	window.location="http://localhost:8080/Edutube/EdutubeHome.jsp";
    	alert("ok");
    	
    	//sendEmail();
    //$.msgbox({type: 'success',content: 'Registration is Successful ,Thanks for registering in Edutube',	title:'User Registration'});
    //window.locate="UserLogin.jsp"
        }else if (result.status=="ERROR"){	
//    	$.msgbox({	type: 'error',	content: 'Server error',	title: 'Submission error'});
    }else{
    	alert("Not ok");
    //$.msgbox({type: 'warning',content: 'Unfortunately we are unable to process your request Inconvenience regretted',title: 'System Warning'});
    }
    }
    });

    });