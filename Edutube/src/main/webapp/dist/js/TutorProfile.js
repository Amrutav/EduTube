$(document).ready(function(){
console.log("okay");
		var uid=sessionStorage.getItem("UserData");
		dataObject = {
				'userId':uid
	  };
		console.log(dataObject);
		
		$.ajax({
		    url: '/Edutube/tutor/tutorProfile?userId='+uid,
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			data:JSON.stringify(dataObject),
		    success: function(resultTutor) {
		        console.log(resultTutor);
		        console.log(resultTutor.tutorId);
//		        $.each(resultTutor, function(i, item) {
//		        	alert("inside loop");
//		        	alert(i);
//		        	alert(item);
//		        	$("#display").append("<div>"+item+"</div>");
//		        });
		        var fName=resultTutor.tutorFirstName;
		        var lName=resultTutor.tutorLastName;
		        var fullName=fName+"&nbsp;"+lName;
		        
		       $("#HeaderName").append(fullName); 
		       $("#small_txt").append(resultTutor.tutorStatusUpdate);
		       $("#TutorName").append(fullName);
		       $("#EduQuali").append(resultTutor.tutorEducation);
		       $("#AboutMe").append(resultTutor.tutorAboutMe);
		       $("#Gender").append(resultTutor.tutorGender);
		       $("#DateOfBirth").append(resultTutor.tutorDateOfBirth);
		       $("#WrkExp").append(resultTutor.tutorExperience+"&nbsp;"+"years"); 
		       // $("#HeaderName").html(resultTutor.tutorFirstName+"</br> <span class='small_txt'>Physics Teacher</span>");
		        var test = {
		    		name:"swetak"
		    };
		    console.log(test);
		
		}
		});
		
});