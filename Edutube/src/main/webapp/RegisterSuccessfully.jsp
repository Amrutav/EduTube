<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edutube</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
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
    
       <script type="text/javascript" src="dist/js/jquery.min.js"></script>
    
    
</head>
<body>
<div id="wrapper">
    <!--Header !-->
    <header id="header">
    	<nav class="navbar navbar-inverse navbar-static-top">
                <div class="container">
                    <!--<div class="row">-->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.html"><img src="img/logo.png" alt="Logo" title="Edutube"/></a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Courses</a></li>
                            <li><a href="#">Offers</a></li>
                            <li><a href="#">Faq</a></li>
                            <li><a href="#">Blog</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#" class="login_btn">Login</a></li>
                            <li><a href="#" class="login_btn">Sign up</a></li>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                    <!--</div>-->
                </div>
            </nav>
    </header>
    <div class="clearfix"></div>
   
    <!--Main Body Section!-->
    
       <header class="page-header primary bg-colored">
       <div class="container" style="padding-top:120px;">
    
        <h1>Successfully registered!</h1>
   
    
    
</div>
</header>

<div >
    
    <div class="container">
        <div class="span8 main" role="main">
            <p class="margin-bottom-20">Your account has been successfully registered. A token is being sent to your registered mailbox. Submit the token to activate your account.</p>
            <input type="text" placeholder="Enter token here" id="txtToken"  name="token" class="form-control" style="width: 30%;">
            <a class="btn btn-danger" id="tknSubmit" style="margin-top: 10px;">Submit</a>
            <a class="btn btn-danger" id="tknReg" style="margin-top: 10px; margin-left: 10px;">Regenerate Token</a>
        </div>
    </div>
</div>

    
    <div class="clearfix"></div>
   
   
    
    <!-- Footer -->
	<footer id="Fixedfooter" class="navbar-fixed-bottom">
    <div class="container">
    <div class="row">
        	<div class="col-xs-6 col-sm-6 col-md-3 mt10">
                <h3>Quick Links</h3>
                <ul>
                	<li>Home</li>
                    <li>About Us</li>
                    <li>Courses</li>
                    <li>Offers</li>
                    <li>Faq</li>
                    <li>Blog</li>
                    <li>Contact Us</li>
                </ul>
            </div>
        	<div class="col-xs-6 col-sm-6 col-md-3 mt10">
                <h3>Information</h3>
                <ul>
                	<li>Tutors</li>
                    <li>Students</li>
                    <li>Parents</li>
                    <li>How it works</li>
                    <li>View demo</li>
                    <li>Pricing</li>
                    <li>Dashboard</li>
                </ul>
            </div>
        	<div class="col-xs-12 col-sm-6 col-md-3 mt15">
                <h3>Exams</h3>
                <ul>
                	<li>CBSE</li>
                    <li>ICSE</li>
                    <li>IIT-JEE Foundation</li>
                    <li>NTSE</li>
                    <li>PSA</li>
                </ul>
            </div>
        	<div class="col-xs-12 col-sm-6 col-md-3">
            	<div class="footer_social">
                    <h3>Follow Us</h3>
                    <p class="mt15">Just select your favorite social network to get started</p>
                    <ul class="mt20">
                        <li><a href="#" class="icon icon-mono facebook">facebook</a></li>
                        <li><a href="#" class="icon icon-mono twitter">twitter</a></li>
                        <li><a href="#" class="icon icon-mono googleplus">google+</a></li>
                        <li><a href="#" class="icon icon-mono linkdin">google+</a></li>
                    </ul>
                </div>
            </div>
    </div>            
    </div>
    <div class="clearfix"></div>
     <div class="footer_copyright">
        <div class="container">&copy; Edutube 2015. All Right Reserved</div>
    </div>
    </footer>
   
    
</div>
<script type="text/javascript" src="dist/js/ValidateToken.js"></script>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
 
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="dist/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="dist/js/scrollspy.js" charset="UTF-8"></script>
	<script type="text/javascript" src="dist/js/jquery-2.1.1.min.js"></script>
	
   
</body>
</html>