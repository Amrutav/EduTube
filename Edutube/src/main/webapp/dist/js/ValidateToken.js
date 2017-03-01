$(document).ready(function(){
	
	
	$("#tknSubmit").click(function(event) {
		dataObject = {
	  'token':$('#txtToken').val()
	  };
	var token=$('#txtToken').val();
	console.log(dataObject);
	$(this).prop('disabled',true);
	$.ajax({
	    url: '/Edutube/user/activateAccount?token='+token,
	    type: 'get',
		contentType: "application/json; charset=utf-8",
		dataType:'json',
		data:JSON.stringify(dataObject),
	    success: function(result) {
	        console.log(result); 
	if(result.status=="ACTIVATED"){
		window.location="/Edutube";
		alert("ok");
	    }else if (result.status=="NOT ACTIVATED"){	
	alert("Not Ok")
	}else{
		alert("Not ok");
	//$.msgbox({type: 'warning',content: 'Unfortunately we are unable to process your request Inconvenience regretted',title: 'System Warning'});
	}
	}
	});

	});
	
	
});