<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="dist/css/formValidation.css"/>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.msgbox.css" />

    <script type="text/javascript" src="vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="dist/js/formValidation.js"></script>
    <script type="text/javascript" src="dist/js/framework/bootstrap.js"></script>
	<script type="text/javascript" src="vendor/jquery/jquery.msgbox.js"></script>
	<script type="text/javascript" src="vendor/jquery/jquery.msgbox.min.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="dist/js/Student.js" charset="UTF-8"></script>
	
	
<script>
  $(function() {
	  var search = [];
	  $.ajax({
		    url: 'http://localhost:8080/FwdSample/student/search',
		    type: 'get',
			contentType: "application/json; charset=utf-8",
			dataType:'json',
			success: function(result) {
				console.log(result); 
		    	alert(result);
		    	$.each(result, function(i, item) {
		    	    search.push(item.subjectname);
		    	});
		    	$( "#search" ).autocomplete({
		    	      source: search
		    	});
		        
		    }
	  });
	
  });
  </script>



</head>
<body>
<div class="container">
   <div class="form">
        <div class="row">		
		   <div class="col-md-7">
                <form id="defaultForm" method="post" class="form-horizontal">
                    
                <div class="form-group">
                  <div class="col-lg-10 ">
                 	<label for="search" class="col-lg-4 control-label">Search Tutor</label>
                 	<div class="col-lg-8">
                 	<input type="text" class="form-control" id="search" placeholder="Type your Subject">
                 	</div>
<!--                  	<br> -->
<!--                  	<label for="search">Advanced Search</label> -->
<!--                  	<input type="text" id="search" placeholder="Subject, Tutor, Courses"> -->
                  </div>
                </div>   
               	</form>
       	 </div>
      </div>
   </div>
                
          <div class="form">
        <div class="row">		
		   <div class="col-md-7">
                <form id="defaultForm" method="post" class="form-horizontal">
                    
                    <h3>Personal Information</h3>
                    <br>
                    <div class="form-group">
                      <label for="fullname" class="col-lg-4 control-label">ID</label>
                      <div class="col-lg-8">
                        <input type="hidden" class="form-control" id="student_id" name="ID" value="1">
                      </div>
                    </div>
                    
                    
                    <div class="form-group">
                      <label for="fullname" class="col-lg-4 control-label">Firstname</label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter Firstname" >
                      </div>
                    </div>
                    
                    
                    <div class="form-group">
                      <label for="fullname" class="col-lg-4 control-label">Lastname</label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter Lastname" >
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="fullname" class="col-lg-4 control-label">Age</label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="age" name="age" placeholder="Enter Age" >
                      </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="dtp_input2" class="col-lg-4 control-label">Date Of Birth</label>
                        <div class="input-group date form_date col-lg-8" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                            <input class="form-control" size="10" id="dateInput" type="text" value="" placeholder="dd/MM/yyyy">
                            
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="dtp_input2" value="" /><br/>
                    </div>                
                    
                    <div class="form-group">
                      <label for="inputEmail" class="col-lg-4 control-label">Gender</label>
                      <div class="col-lg-8">
                        <div class="radio">
                          <label>
                            <input type="radio" name="gender" id="gender1" value="F" >
                            Female
                          </label>
                        </div>
                        <div class="radio">
                          <label>
                            <input type="radio" name="gender" id="gender2" value="G" >
                            Male
                          </label>
                        </div>
                       </div>
                    </div>
                    
                <div class="form-group">
                  <div class="col-lg-10 ">
                    <button type="reset" class="btn btn-default btn-lg">Reset</button>
                    <button type="button" id="edit" name="edit" value="Edit" class="btn btn-warning btn-lg">Edit</button>
                  </div>
                </div>            
                
                    
             </form>
         </div>
    </div>
</div>
                
                
           
    <div class="form">
        <div class="row">		
		   <div class="col-md-7">
                <form id="defaultForm" method="post" class="form-horizontal">
                
                	<h3>Contact Information</h3>
                    <br>
                    
                     <div class="form-group">
                      <label for="Email" class="col-lg-4 control-label">Email</label>
                      <div class="col-lg-8">
                        <input type="email" class="form-control" id="Email" placeholder="Email" name="Enter Email"  >
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="contactaddress" class="col-lg-4 control-label">Contact Address</label>
                      <div class="col-lg-8">
                      <textarea class="form-control" rows="3" id="address" placeholder="Enter Address"></textarea>
                        
                      </div>
                    </div>
                
                <div class="form-group">
                  <div class="col-lg-10 ">
                    <button type="reset" class="btn btn-default btn-lg">Reset</button>
                    <button type="button" id="edit" name="edit" value="Edit" class="btn btn-warning btn-lg">Edit</button>
                  </div>
                </div>            
                
                    
                </form>
                
                </div>
                
			</div>
        </div>
    </div>






</body>
</html>