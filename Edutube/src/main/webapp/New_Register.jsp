<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration form</title>
	<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="dist/css/formValidation.css"/>
    <link rel="stylesheet" href="css/style.css">

    <script type="text/javascript" src="vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="dist/js/formValidation.js"></script>
    <script type="text/javascript" src="dist/js/framework/bootstrap.js"></script>
	<script type="text/javascript" src="vendor/jquery/jquery.msgbox.js"></script>
	<script type="text/javascript" src="vendor/jquery/jquery.msgbox.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/jquery.msgbox.css" />
</head>
<body>
<div class="container">
   <div class="form">
        <div class="row">		
		   <div class="col-md-7">
                <form id="defaultForm" method="put" class="form-horizontal">
                    
                    <div class="form-group">
                      <label for="fullname" class="col-lg-4 control-label">Fullname</label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Enter Fullname" >
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="Email" class="col-lg-4 control-label">Email</label>
                      <div class="col-lg-8">
                        <input type="email" class="form-control" id="Email" placeholder="Email" name="Enter Email"  >
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="lastname" class="col-lg-4 control-label">Password</label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" >
                      </div>
                    </div>
                
                <div class="form-group">
                  <div class="col-lg-10 ">
                    <button type="reset" class="btn btn-default btn-lg">Reset</button>
                    <button type="button" id="signup" name="signup" value="Sign Up" class="btn btn-warning btn-lg">Signup</button>
                  </div>
                </div>
                
                
                    
                </form>
                
                </div>
                
			</div>
        </div>
        Already have account? Click <a href="UserLogin.jsp">here</a> to Login.
    </div>


<script type="text/javascript" src="dist/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="dist/js/UserLoginJsp.js" charset="UTF-8"></script>
<script type="text/javascript" src="dist/js/Utilsjsp.js" charset="UTF-8"></script>



</body>
</html>