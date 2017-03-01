$(document).ready(function(){
console.log("okay");
		var uid=sessionStorage.getItem("UserData");
		dataObject = {
				'userId':uid
	  };
		console.log(dataObject);
		console.log("hello");
		$.ajax({
		    url: '/Edutube/user/viewUserContact?userId='+uid,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(userContact) {
		    	console.log("hello");
		    	console.log(userContact);
		    	var cntAdd=userContact.contactAddress;
		    	var al1=userContact.addressLine1;
		    	var al2=userContact.addressLine2;
		    	var al3=userContact.addressLine3;
		    	var useraddress=cntAdd+","+"<br/>"+al1+","+"<br/>"+al2+","+"<br/>"+al3;
		       $("#UserCountry").append(userContact.country);
		       $("#UserEmail").append(userContact.email);
		       $("#UserAddress").append(useraddress);
		       $("#UserMobile").append(userContact.mobileNumber);
		       $("#UserTelephone").append(userContact.telephoneNumber);
		       $("#UserCity").append(userContact.city);
		       $("#UserState").append(userContact.state);
		       $("#UserPin").append(userContact.pinCode);
		        var test = {
		    		name:"swetak"
		    };
		    console.log(test);
		
		}
		});
	
		

});