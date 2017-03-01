<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edutube</title>

    <!-- Bootstrap -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/bootstrap-tokenfield.css" type="text/css" rel="stylesheet">
    <link href="css/prettify-1.0.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    
</style>
</head>
<body>
<div class="modal fade in" id="AsignUser" role="dialog" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="false" style="display: block;background-color: rgba(0, 0, 0, 0.41);z-index:1051;">
    <div class="vertical-alignment-helper">
        <div class="modal-dialog vertical-align-center">
            <div class="modal-content" style="padding-bottom:10px;">
                <div class="modal-header" style="padding: 15px 7px 7px 15px;">
                      <h4 class="modal-title" id="myModalLabel" style="color:#E2574C;">Welcome to Edutube!</h4>
			</div>
                <div class="modal-body" style="padding-top: 3px;">
                <div class="row">
                	<p class="text-center">I am here to...</p>
                </div>
                	<div class="row">
                    	<div class="col-md-4 text-center UserAsign_box" id="ShowDivOne" onclick="show(id)">
                        	<div class="row">
            					<div class="col-xs-12 col-sm-12 col-md-12 np mt10">
                				<div class="UserAsign_box clearfix">
                  					<div class="col-xs-12 col-sm-12 col-md-12">
                  					<img src="img/register_icon1.png" alt="" title=""/>
               			   			</div>
                  				</div>
        					</div>
        					 </div>
                             <div class="row text-center" >
                             	Teach
                             </div>
        				</div>
            <div class="col-md-4 text-center UserAsign_box"  id="ShowDivTwo"  onclick="show(id)">
                        	<div class="row">
            					<div class="col-xs-12 col-sm-12 col-md-12 np mt10">
                				<div class="UserAsign_box clearfix">
                  					<div class="col-xs-12 col-sm-12 col-md-12">
                  					<img src="img/register_icon2.png" alt="a" title="b"/>
               			   			</div>
                  				</div>
        					</div>
        					 </div>
                             <div class="row text-center" >
                             	Learn
                             </div>
        				</div>
            <div class="col-md-4 text-center UserAsign_box" id="ShowDivThree"  onclick="show(id)">
                        	<div class="row">
            					<div class="col-xs-12 col-sm-12 col-md-12 np mt10">
                				<div class="UserAsign_box clearfix">
                  					<div class="col-xs-12 col-sm-12 col-md-12">
                  					<img src="img/register_icon3.png" alt="" title=""/>
               			   			</div>
                  				</div>
        					</div>
        					 </div>
                             <div class="row text-center" >
                             	Learn & Teach
                             </div>
        				</div>
        </div>
                </div>
                
            </div>
        </div>
    </div>
</div>
<div class="row" id="BgImage" style=" margin-right: 0px;margin-left: 0px;">
<img src="img/Background.jpg" class="img-responsive" />
</div>

<script type="text/javascript">
function show(id)
{	var a;
	var uid=sessionStorage.getItem("UserData");	
	console.log(uid);
	if(id=="ShowDivOne"){
			var a="TUTOR";
		}
		else if(id=="ShowDivTwo"){
			var a="STUDENT";
		}
		else if(id=="ShowDivThree"){
			var a="PARENT";
		}
		dataObject={
			'userType': a,	
			'userId':uid
		};
console.log(dataObject);
$.ajax({
    url: '/Edutube/user/updateUserType',
    type: 'post',
	contentType: "application/json; charset=utf-8",
	dataType:'json',
	data:JSON.stringify(dataObject),
    success: function(result) {
        console.log(result); 
        console.log(result.userType);
if(result.status=="SUCCESS"){
	if(a=="TUTOR"){
	alert("Tutor");
	var uid=sessionStorage.getItem("UserData");	
	console.log(uid);
	window.location="/Edutube/Profile.jsp";
	}else if(a=="STUDENT"){
		alert("Student");
		var uid=sessionStorage.getItem("UserData");	
		console.log(uid);
		window.location="/Edutube/StudentProfile.jsp";
	}else if(a=="PARENT"){
		alert("Parent");
		var uid=sessionStorage.getItem("UserData");	
		console.log(uid);
		window.location="/Edutube/Profile.jsp";
	}
	
    }else if (result.status=="ERROR"){	
//	$.msgbox({	type: 'error',	content: 'Server error',	title: 'Submission error'});
}else{
	alert("Not ok");
//$.msgbox({type: 'warning',content: 'Unfortunately we are unable to process your request Inconvenience regretted',title: 'System Warning'});
}
}
});
};
</script>




    
    <!-- Modal HTML -->
    

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="dist/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="dist/js/bootstrap.min.js"></script>
<!-- 	<script src="dist/js/coretheme.min.js" type="text/javascript"></script> -->
    <script type="text/javascript" src="dist/js/jquery-1.9.1.js"></script>
	<script src="dist/js/bootstrap-tokenfield.js" type="text/javascript"></script>
    <script type="text/javascript" src="dist/js/scrollspy.js" charset="UTF-8"></script>
<!--     <script type="text/javascript" src="dist/js/docs.min.js" charset="UTF-8"></script> -->
	<script type="text/javascript" src="dist/js/jquery-2.1.1.min.js"></script>
	<script src="dist/js/moment-with-locales.js"></script>
    <script src="dist/js/bootstrap-datetimepicker.js"></script>
    
    <script type="text/javascript" src="dist/js/Signup.js" charset="UTF-8"></script>
</body>
</html>