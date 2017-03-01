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
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.css"/>
    
    <link rel="stylesheet" href="dist/css/formValidation.css"/>
<!--     <link href="css/bootstrap.min.css" rel="stylesheet"> -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- 		<script src="dist/js/jquery.min.js"></script> -->
		
		 <script type="text/javascript" src="vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="dist/js/formValidation.js"></script>
    <script type="text/javascript" src="dist/js/framework/bootstrap.js"></script>
		
        <script>
        $(function() {
          $('.tmenu a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
    
              var target = $(this.hash);
			 
              target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
              if (target.length) {
                $('html,body').animate({
                  scrollTop: target.offset().top
                }, 1000);
                return false;
              }
            }
          });
        });
        </script>

        <script>
        
		$(window).scroll(function(){
		if ($(window).scrollTop() >= 660) {
		   $('.home_header').addClass('fixed-header');
		}
		else {
		   $('.home_header').removeClass('fixed-header');
		}
		});
        </script>
</head>
<body>
<div id="wrapper">
    <!--Header !-->
    <div class="header_bg clearfix">
    <div class="container top_logo_area">
    	<div class="col-xs-4 col-sm-8 col-md-10">
        <a href="index.html"><img src="img/top_text_logo.png" alt="Logo" title="Edutube"/></a>
        </div>
    	<div class="col-xs-8 col-sm-4 col-md-2">
        <ul>
        	<li><a href="#" data-toggle="modal" data-target="#login">Login</a></li>
        	<li><a href="#" data-toggle="modal" data-target="#login">Sign up</a></li>
        	<li class="hidden-sm visible-xs tmenu"><a href="#slide1"><i class="fa fa-bars"></i></a></li>
        </ul>
        <form id="defaultForm" method="post">
        <div class="modal fade" id="login" role="dialog">
                <div class="modal-dialog modal-lg">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close close_btn" data-dismiss="modal"><img src="img/close_icon.png"></button>
                    </div>
                        <div class="modal-body">
                        <div class="row">
                        	<div class="col-xs-12 col-sm-4 col-md-4 col-sm-offset-1">
                            <h2>Login</h2>
                            <div class="form-group">
                            <p>${message}</p>
                                <input type="text" placeholder="Username" id="txtUName"  name="uname" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <input type="password" placeholder="Password" id="txtPwd" name="passworda" class="form-control" required>
                            </div>
                            <p class="small"><a href="#">Forgot Password?</a></p>
                            <button type="button" href="#" class="btn home_red_btn wid100 mt15" id="qwerty">Login</button>
                            <div class="clearfix"></div>
                                <div class="popup_social">
                                    <button type="button" href="#" class="btn fb_btn mt15"><i class="fa fa-facebook"></i> Login with Facebook</button>
                                    <button type="button" href="#" class="btn twit_btn mt15"><i class="fa fa-twitter"></i> Login with Twitter</button>
                                    <button type="button" href="#" class="btn googleplus_btn mt15"><i class="fa fa-google-plus"></i> Login with Google+</button>
                                </div>
                            </div>
                        	<div class="col-xs-12 col-sm-2 col-md-2">
                            <div class="login_separator">
                            	<div class="login_separator_line"></div>
                                <div class="login_separator_text">OR</div>
                            </div>
                            </div>
                        	<div class="col-xs-12 col-sm-4 col-md-4">
                            <h2>Sign Up</h2>
                            <div class="form-group">
                                <input type="text" placeholder="First Name" id="txtFName" name="firstName" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="text" placeholder="Last Name" id="txtLName"  name="lastName" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="text" placeholder="Email ID" id="txtEmaill" name="email"class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="text" id="txtUserName" name="username" class="form-control" placeholder="User Name">
                            </div>
                            <div class="form-group">
                                <input type="password" placeholder="Password" id="txtPasswordd" name="password" class="form-control">
                            </div>
                            <div class="form-group" style="margin-bottom: 10px;">
                                <input type="password" placeholder="Confirm Password" id="txtCPassword" name="confirmPassword"class="form-control">
                            </div>
                            <button type="button" id="signup" class="btn home_red_btn wid100 mt15">Sign Up</button>
                            </div>
                        </div>
                        </div>
                  </div>
                </div>
              </div>
              </form>
        </div>
    </div>
    <article class="pad70">
        <div class="container search_area">
        <center><img src="img/tube_logo.png" alt="Logo" title=""/></center>
        <form id="" method="GET">
        <div class="search_panel">
        <div class="col-xs-12 col-sm-2 col-md-1 graytxt">
        Search
        </div>
        <div class="col-xs-12 col-sm-8 col-md-10"> 
            <div class="form-group">
                <input type="text" placeholder="" id="name" class="form-control search_field">
            </div>
        </div>
        <div class="col-xs-12 col-sm-2 col-md-1">
        <a href="#" class="btn search_btn"><span class="glyphicon glyphicon-search"></span></a>
        </div>
        <div class="clearfix"></div>
        <p class="smallgray text-center"><a href="#" data-toggle="collapse" data-target="#advance_search">Advanced Search <span class="glyphicon glyphicon-chevron-down"></span></a></p>
        <div id="advance_search" class="row collapse">
            <div class="col-xs-12 col-sm-6 col-md-3"> 
                <div class="form-group">
                    <input type="text" placeholder="Board" id="name" class="form-control search_field">
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3">
                <div class="form-group">
                    <select class="form-control search_field select-down-new" id="">
                        <option>Cbse/Icse</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                    </select>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3">
                <div class="form-group">
                    <select class="form-control search_field select-down-new" id="">
                        <option>Choose Subject</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                    </select>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3"> 
                <div class="form-group">
                    <input type="text" placeholder="Class" id="name" class="form-control search_field">
                </div>
            </div>
        </div>
        </div>
        <div class="col-md-offset-4 mt15">
        <div class="col-xs-12 col-sm-6 col-md-3 mt10">
        <a href="#" class="btn home_blue_btn">How It Works</a>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3 mt10">
        <a href="#" class="btn home_red_btn">View Demo</a>
        </div>
        </div>
        </form>
        </div>
    </article>
    <div class="clearfix"></div>
    <header class="home_header sticky">
    	<nav class="navbar navbar-inverse navbar-static-top" id="slide1">
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
    </div>
    
    <!--Register Section!-->
    <section class="register_area">
        <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-4 np mt10">
                <div class="register_box clearfix">
                  <div class="col-xs-5 col-sm-4 col-md-4">
                  <img src="img/register_icon1.png" alt="" title=""/>
                </div>
                  <div class="col-xs-7 col-sm-8 col-md-8">
                  <h1>I'm a tutor</h1>
                  <p>Discover a simpler way  
                    to connect with students</p>
                  <button href="#" class="register_btn">Register</button>
                </div>
            </div>
        </div>
            <div class="col-xs-12 col-sm-6 col-md-4 np mt10">
                <div class="register_box clearfix">
                  <div class="col-xs-5 col-sm-4 col-md-4">
                  <img src="img/register_icon2.png" alt="" title=""/>
                </div>
                  <div class="col-xs-7 col-sm-8 col-md-8">
                  <h1>I'm a student</h1>
                  <p>Find an online tutor   
                    that can help you best</p>
                  <button href="#" class="register_btn">Register</button>
                </div>
            </div>
        </div>
            <div class="col-xs-12 col-sm-6 col-md-4 np mt10">
                <div class="register_box clearfix">
                  <div class="col-xs-5 col-sm-4 col-md-4">
                  <img src="img/register_icon3.png" alt="" title=""/>
                </div>
                  <div class="col-xs-7 col-sm-8 col-md-8">
                  <h1>I'm a parent</h1>
                  <p>Set up an accountfor your child  
                    and find the best online tutors.</p>
                  <button href="#" class="register_btn">Register</button>
                </div>
            </div>
        </div>
        </div>
        </div>
    
    <div class="clearfix"></div>
    </section>
    <!--Offering Section!-->
    <section class="offer_area">
        <div class="container">
        <div class="row">
            <div class="tutor_sec">
            <h1>Our offerings</h1>
            <p>We believe in a diverse range of personel to bring creative skills, thoughts, and ideas to the table. Be cool, we awesome, be with us today, really ok?</p>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mt20">
                <div class="offer_bg">
                  <img src="img/offer_icon1.png" alt="" title=""/>  
                </div>
                <div class="offer_txtbg1">
                <h3>Exam Courses</h3>
                <p>IIT-JEE, GMAT etc..</p>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mt20">
                <div class="offer_bg">
                  <img src="img/offer_icon2.png" alt="" title=""/>  
                </div>
                <div class="offer_txtbg2">
                <h3>One to One Lessions</h3>
                <p>Any Subject</p>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mt20">
                <div class="offer_bg">
                  <img src="img/offer_icon3.png" alt="" title=""/>  
                </div>
                <div class="offer_txtbg3">
                <h3>Monthly Tutions</h3>
                <p>Class 1-10 CBSE, ICSE</p>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mt20">
                <div class="offer_bg">
                  <img src="img/offer_icon4.png" alt="" title=""/>  
                </div>
                <div class="offer_txtbg4">
                <h3>Career Advice</h3>
                <p>Talk to our advisors</p>
                </div>
            </div>
        </div>
        </div>
    
    <div class="clearfix"></div>
    </section>
    <!--Courses Section!-->
    <section class="course_area">
        <div class="container">
        <div class="row">
            <div class="tutor_sec">
            <h1>Our Courses</h1>
            <p>Monthly Tuitions and Exam preparation courses</p>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mt20">
                <div class="overlay-wrap">
                    <div class="course_mod">
                    <div class="course_mod_img"><img class="img-responsive" src="img/course_img.jpg" alt="" title=""/></div> 
                        <div class="course_mod_text">
                        <h3>CBSE 6th Physics Tuitions</h3>
                        <p><i class="fa fa-pencil"></i> 6th Grade<br>
                        <span>Physics</span></p>
                        </div>
                    <div class="course_rate offer_txtbg1"><i class="fa fa-tag"></i> Starts from 600 INR/Month</div>
                    </div>
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <center><a class="preview overlay-wrap-inner-btn2" href="#" title=""><i class="fa fa-link"></i></a></center>
                    </div> 
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mt20">
                <div class="overlay-wrap">
                    <div class="course_mod">
                    <div class="course_mod_img"><img class="img-responsive" src="img/course_img.jpg" alt="" title=""/></div> 
                        <div class="course_mod_text">
                        <h3>CBSE 6th Physics Tuitions</h3>
                        <p><i class="fa fa-pencil"></i> 6th Grade<br>
                        <span>Physics</span></p>
                        </div>
                    <div class="course_rate offer_txtbg2"><i class="fa fa-tag"></i> Starts from 600 INR/Month</div>
                    </div>
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <center><a class="preview overlay-wrap-inner-btn2" href="#" title=""><i class="fa fa-link"></i></a></center>
                    </div> 
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mt20">
                <div class="overlay-wrap">
                    <div class="course_mod">
                    <div class="course_mod_img"><img class="img-responsive" src="img/course_img.jpg" alt="" title=""/></div> 
                        <div class="course_mod_text">
                        <h3>CBSE 6th Physics Tuitions</h3>
                        <p><i class="fa fa-pencil"></i> 6th Grade<br>
                        <span>Physics</span></p>
                        </div>
                    <div class="course_rate offer_txtbg3"><i class="fa fa-tag"></i> Starts from 600 INR/Month</div>
                    </div>
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <center><a class="preview overlay-wrap-inner-btn2" href="#" title=""><i class="fa fa-link"></i></a></center>
                    </div> 
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 mt20">
                <div class="overlay-wrap">
                    <div class="course_mod">
                    <div class="course_mod_img"><img class="img-responsive" src="img/course_img.jpg" alt="" title=""/></div> 
                        <div class="course_mod_text">
                        <h3>CBSE 6th Physics Tuitions</h3>
                        <p><i class="fa fa-pencil"></i> 6th Grade<br>
                        <span>Physics</span></p>
                        </div>
                    <div class="course_rate offer_txtbg4"><i class="fa fa-tag"></i> Starts from 600 INR/Month</div>
                    </div>
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <center><a class="preview overlay-wrap-inner-btn2" href="#" title=""><i class="fa fa-link"></i></a></center>
                    </div> 
                    </div>
                </div>
            </div>
        </div>
        </div>
    
    <div class="clearfix"></div>
    </section>
    <!--Teacher Section!-->
    <section class="teacher_mod border_none">
        <div class="container">
        <div class="row">
            <div class="tutor_sec">
            <h1>Our awesome tutor</h1>
            <p>We believe in a diverse range of personel to bring creative skills, thoughts, and ideas to the table. Be cool, we awesome, be with us today, really ok?</p>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-2 mt20">
                <div class="overlay-wrap">
                    <img class="img-responsive" src="img/teacher1.jpg" alt="">
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <p>첥ew greate way to create open
space in your city house.�</p>
                    <center><a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-facebook"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-twitter"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-instagram"></i></a></center>
                    </div> 
                    </div>
                </div>
            <h1><a href="profile.html">Gregory Lapin</a><br>
            <span>Physics Teacher</span></h1>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-2 mt20">
                <div class="overlay-wrap">
                    <img class="img-responsive" src="img/teacher1.jpg" alt="">
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <p>첥ew greate way to create open
space in your city house.�</p>
                    <center><a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-facebook"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-twitter"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-instagram"></i></a></center>
                    </div> 
                    </div>
                </div>
            <h1><a href="profile.html">Gregory Lapin</a><br>
            <span>Physics Teacher</span></h1>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-2 mt20">
                <div class="overlay-wrap">
                    <img class="img-responsive" src="img/teacher1.jpg" alt="">
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <p>첥ew greate way to create open
space in your city house.�</p>
                    <center><a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-facebook"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-twitter"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-instagram"></i></a></center>
                    </div> 
                    </div>
                </div>
            <h1><a href="profile.html">Gregory Lapin</a><br>
            <span>Physics Teacher</span></h1>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-2 mt20">
                <div class="overlay-wrap">
                    <img class="img-responsive" src="img/teacher1.jpg" alt="">
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <p>첥ew greate way to create open
space in your city house.�</p>
                    <center><a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-facebook"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-twitter"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-instagram"></i></a></center>
                    </div> 
                    </div>
                </div>
            <h1><a href="profile.html">Gregory Lapin</a><br>
            <span>Physics Teacher</span></h1>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-2 mt20">
                <div class="overlay-wrap">
                    <img class="img-responsive" src="img/teacher1.jpg" alt="">
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <p>첥ew greate way to create open
space in your city house.�</p>
                    <center><a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-facebook"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-twitter"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-instagram"></i></a></center>
                    </div> 
                    </div>
                </div>
            <h1><a href="profile.html">Gregory Lapin</a><br>
            <span>Physics Teacher</span></h1>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-2 mt20">
                <div class="overlay-wrap">
                    <img class="img-responsive" src="img/teacher1.jpg" alt="">
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <p>첥ew greate way to create open
space in your city house.�</p>
                    <center><a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-facebook"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-twitter"></i></a>
                    <a class="preview overlay-wrap-inner-btn" href="#" title=""><i class="fa fa-instagram"></i></a></center>
                    </div> 
                    </div>
                </div>
            <h1><a href="profile.html">Gregory Lapin</a><br>
            <span>Physics Teacher</span></h1>
            </div>
        </div>
        </div>
    
    <div class="clearfix"></div>
    </section>
    <!-- Testimonial Section -->
    <section class="testimonial">
    <div class="container">
        <div class="testi_mod">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators testimonial_indicator">
              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
        
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
        
              <div class="item active">
                  <p>I recommend Vedantu to all parents in search of online tuition. My son loves the sessions and I can already see the change.</p>
                  <div class="testi_name mt25">-Alisha Roy <span>6 days ago</span></div>
              </div>
        
              <div class="item">
                  <p>I recommend Vedantu to all parents in search of online tuition. My son loves the sessions and I can already see the change.</p>
                  <div class="testi_name mt25">-Alisha Roy <span>6 days ago</span></div>
              </div>
            
              <div class="item">
                  <p>I recommend Vedantu to all parents in search of online tuition. My son loves the sessions and I can already see the change.</p>
                  <div class="testi_name mt25">-Alisha Roy <span>6 days ago</span></div>
              </div>
          
            </div>
        
          </div>
        </div>
    </div>
    <div class="clearfix"></div>
    </section>
    <!-- Counter section -->
    <section>
    <div class="container">
    	<div class="row list_icon_sec">
        	<div class="col-xs-12 col-sm-6 col-md-3 mt20">
            	<center><img src="img/list_icon1.jpg"></center>
                <h1>23325</h1>
                <div class="list_icon_separator"></div>
                <p>Teachers Registered</p>
            </div>
        	<div class="col-xs-12 col-sm-6 col-md-3 mt20">
            	<center><img src="img/list_icon2.jpg"></center>
                <h1>23325</h1>
                <div class="list_icon_separator"></div>
                <p>Online CLasses Running</p>
            </div>
        	<div class="col-xs-12 col-sm-6 col-md-3 mt20">
            	<center><img src="img/list_icon3.jpg"></center>
                <h1>23325</h1>
                <div class="list_icon_separator"></div>
                <p>Courses Aailable</p>
            </div>
        	<div class="col-xs-12 col-sm-6 col-md-3 mt20">
            	<center><img src="img/list_icon4.jpg"></center>
                <h1>23325</h1>
                <div class="list_icon_separator"></div>
                <p>Students Registered</p>
            </div>
        </div>
    </div>	
    </section>
    
    <!-- Footer -->
	<footer id="footer">
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
    </footer>
    <div class="footer_copyright">
        <div class="container">&copy; Edutube 2015. All Right Reserved</div>
    </div>
    
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
<!--     <script src="dist/js/bootstrap.min.js"></script> -->
    <script type="text/javascript" src="dist/js/Signup.js" charset="UTF-8"></script>
<!--     <script type="text/javascript" src="dist/js/Login.js" charset="UTF-8"></script> -->
<!-- 	<script type="text/javascript" src="js/jquery.scrollto.js"></script> -->
<!-- 	<script src="dist/js/coretheme.min.js" type="text/javascript"></script> -->
	 
	
</body>
</html>