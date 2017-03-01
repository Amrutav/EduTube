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
    <article class="pad70">
<!--         <div class="container search_area"> -->
<!--         <div style="margin-left: 550px;"> -->
<!--         </div> -->
<!-- <!--         <div class="col-md-offset-4 mt15"> --> 
<!-- <!--         <div class="col-xs-12 col-sm-6 col-md-3 mt10"> --> 
<!-- <!--         <a href="#" class="btn btn-warning message_btn">SEND MASSEGE</a> --> 
<!-- <!--         </div> --> 
<!-- <!--         <div class="col-xs-12 col-sm-6 col-md-3 mt10"> --> 
<!-- <!--         <a href="#" class="btn btn-warning message_btn">HIRE ME</a> -->
<!-- <!--         </div> --> 
<!--         </div> -->
        </div>
    </article>
    <!--Main Body Section!-->
    <section class="teacher_mod">
        <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-4 col-md-4 mt20">
                <div class="profile_left">
                <figure class="profile_img">
                <div class="overlay-wrap">
                    <img class="img-responsive" src="img/nali.jpg" alt="">
                    <div class="overlay">
                    <div class="overlay-wrap-inner">
                    <center><a class="preview overlay-wrap-inner-btn3" href="#" title="" data-toggle="modal" data-target="#profile_image"><i class="fa fa-camera"></i> Upload</a></center>
                    </div> 
                    </div>
                </div>
                <div class="modal fade" id="profile_image" role="dialog">
                    <div class="modal-dialog modal-md">
                      <div class="modal-content np">
                        <div class="modal-header">
                          <button type="button" class="close close_btn" data-dismiss="modal"><img src="img/close_icon.png"></button>
                        </div>
                            <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">
                                <h2>Change your profile picture</h2>
                                <div class="col-md-12 np">
                                <p class="text-center mt15">Upload a photo from your computer</p>
                                <div class="input-group">
        <span class="input-group-btn">
            <span class="btn btn-primary btn-file">
                Browse&hellip; <input type="file">
            </span>
        </span>
        <input type="text" class="form-control" placeholder="No file selectd" readonly>
    </div>
                                <p class="small text-center smallgray mt15">(Please upload a JPG, GIF or PNG file with 2MB maximize in size)
We have a Photo Cropping tool that will help you select and crop the uploaded image and have it become your profile photo.</p>    
                                </div>
                                <center>
                                <button type="button" href="#" class="btn btn-success mt15">Upload</button>
                                </center>
                                <div class="clearfix"></div>
                                </div>
                            </div>
                            </div>
                      </div>
                    </div>
                  </div>
                </figure>
                <h1 id="TutorName"></h1>
                <b><label style="margin-left: 65px">Status: </label><span id="small_txt" style="font-size: 15px; margin-left: 10px"></span></b>
              	</div>
                <div class="profile_left">
                    <div class="table-responsive mt15"> 
                    <span class="edit_icon"><a href="#" data-toggle="modal" data-target="#location"><i class="fa fa-pencil pull-right"></i></a></span>
                    <div class="modal fade" id="location" role="dialog">
                    <div class="modal-dialog modal-md">
                      <div class="modal-content np">
                        <div class="modal-header">
                          <button type="button" class="close close_btn" data-dismiss="modal"><img src="img/close_icon.png"></button>
                        </div>
                            <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">
                                <h2>Location & Details</h2>
                                  <div class="form-group">
                                  <select class="form-control" id="university">
                                    <option>Select Location</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                  </select>
                                </div>
                                <div class="col-md-12 np">
                                <p>Gender</p>
                                <div class="col-xs-6 col-sm-6 col-md-6 np">
                                <div class="form-group">
                                    <label class="radio-inline"><input type="radio" name="optradio">Male</label>
                                </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6 np">
                                <div class="form-group">
                                    <label class="radio-inline"><input type="radio" name="optradio">Female</label>
                                </div>
                                </div>
                                </div>
                                <div class="col-md-12 np">
                                <p>Date of Birth</p>
                                <div class="form-group" >
                                        <div class='input-group date' id='datetimepicker1'>
                                            <input type='text' class="form-control" />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <center>
                                <button type="button" href="#" class="btn btn-default mt5">Cancel</button>
                                <button type="button" href="#" class="btn btn-success mt5">Save</button>
                                </center>
                                <div class="clearfix"></div>
                                </div>
                            </div>
                            </div>
                      </div>
                    </div>
                  </div>
                      <table class="table">
                        <tbody>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Location</td>
                            <td width="50%" class="border_none blacktxt" id="UserCountry"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Qualification</td>
                            <td width="50%" class="border_none blacktxt" id="EduQuali"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Work Experience</td>
                            <td width="50%" class="border_none blacktxt" id="WrkExp"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Rating</td>
                            <td width="50%" class="border_none blacktxt"><img src="img/star.png"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Gender</td>
                            <td width="50%" class="border_none blacktxt" id="Gender"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">DOB</td>
                            <td width="50%" class="border_none blacktxt" id="DateOfBirth"></td>
                          </tr>
                        </tbody>
                      </table>
                      </div>
                  <div class="clearfix"></div>
                </div>
                <div class="profile_left">
                    <div class="table-responsive mt15">          
                      <table class="table">
                        <tbody>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Acount type</td>
                            <td width="50%" class="border_none blacktxt">Gold</td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Hourly Rate</td>
                            <td width="50%" class="border_none blacktxt">
                            <select class="search_price select-down-new border_none" id="">
                                <option>200</option>
                                <option>300</option>
                                <option>400</option>
                            </select>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                      </div>
                  <div class="clearfix"></div>
                </div>
                <div class="profile_left">
                    <div class="table-responsive mt15">
                    <span class="edit_icon"><a href="#" data-toggle="modal" data-target="#address"><i class="fa fa-pencil pull-right"></i></a></span>
                    <div class="modal fade" id="address" role="dialog">
                    <div class="modal-dialog modal-md">
                      <div class="modal-content np">
                        <div class="modal-header">
                          <button type="button" class="close close_btn" data-dismiss="modal"><img src="img/close_icon.png"></button>
                        </div>
                            <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12">
                                <h2>Address</h2>
                                  <div class="form-group">
                                  <input type="text" class="form-control" id="email" placeholder="Email">
                                </div>
                                  <div class="form-group">
                                  <input type="text" class="form-control" id="mobile" placeholder="Mobile">
                                </div>
                                 <div class="form-group">
                                  <textarea class="form-control" rows="3" id="comment" placeholder="Address"></textarea>
                                </div>
                                  <div class="form-group">
                                  <select class="form-control" id="university">
                                    <option>Time Zone</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                  </select>
                                </div>
                                <center>
                                <button type="button" href="#" class="btn btn-default mt5">Cancel</button>
                                <button type="button" href="#" class="btn btn-success mt5">Save</button>
                                </center>
                                <div class="clearfix"></div>
                                </div>
                            </div>
                            </div>
                      </div>
                    </div>
                  </div>
                      <table class="table">
                        <tbody>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Email</td>
                            <td width="50%" class="border_none blacktxt" id="UserEmail"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Mobile</td>
                            <td width="50%" class="border_none blacktxt" id="UserMobile"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Telephone</td>
                            <td width="50%" class="border_none blacktxt" id="UserTelephone"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Address</td>
                            <td width="50%" class="border_none blacktxt" id="UserAddress"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">City</td>
                            <td width="50%" class="border_none blacktxt" id="UserCity"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">State</td>
                            <td width="50%" class="border_none blacktxt" id="UserState"></td>
                          </tr>
                          <tr>
                            <td width="50%" class="border_none graytxt text-right">Pin Code</td>
                            <td width="50%" class="border_none blacktxt" id="UserPin"></td>
                          </tr>
                        </tbody>
                      </table>
                      </div>
                  <div class="clearfix"></div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-8 col-md-8 mt20">
                <div class="profile_right profile_graybg">
                <span class="edit_icon"><a href="#" data-toggle="modal" data-target="#about"><i class="fa fa-pencil pull-right"></i></a></span>
                <h1>About Me</h1>
                <div class="modal fade" id="about" role="dialog">
                <div class="modal-dialog modal-md">
                  <div class="modal-content np">
                    <div class="modal-header">
                      <button type="button" class="close close_btn" data-dismiss="modal"><img src="img/close_icon.png"></button>
                    </div>
                        <div class="modal-body">
                        <div class="row">
                        	<div class="col-xs-12">
                            <h2>Tell us your story</h2>
                             <div class="form-group">
                              <textarea class="form-control" rows="8" id="comment"></textarea>
                            </div>
                            <center>
                            <button type="button" href="#" class="btn btn-default mt5">Cancel</button>
                            <button type="button" href="#" class="btn btn-success mt5">Save</button>
                            </center>
                            <div class="clearfix"></div>
                            </div>
                        </div>
                        </div>
                  </div>
                </div>
              </div>
                <p id="AboutMe"></p>
                </div>
                <div class="profile_right profile_bluebg">
                <span class="edit_icon"><a href="#" data-toggle="modal" data-target="#subject"><i class="fa fa-pencil pull-right"  style="color:#FFF;"></i></a></span>
                <div class="modal fade" id="subject" role="dialog">
                <div class="modal-dialog modal-md">
                  <div class="modal-content np">
                    <div class="modal-header">
                      <button type="button" class="close close_btn" data-dismiss="modal"><img src="img/close_icon.png"></button>
                    </div>
                        <div class="modal-body">
                        <div class="row">
                        	<div class="col-xs-12">
                            <h2>Subject I Teach</h2>
                            <div class="input-group">
                              <input type="text" id="exampleInlineTags" class="form-control token-example-field" value="" placeholder="Enter Subject" />
                              <div class="input-group-btn">
                            <button type="submit" class="btn btn-default">Add</button>
                            </div>
                            </div>
                             <div class="form-group mt15">
                              <textarea class="form-control" rows="8" id="comment"></textarea>
                            </div>
                            <center>
                            <button type="button" href="#" class="btn btn-default mt5">Cancel</button>
                            <button type="button" href="#" class="btn btn-success mt5">Save</button>
                            </center>
                            <div class="clearfix"></div>
                            </div>
                        </div>
                        </div>
                  </div>
                </div>
              </div>
                <div class="col-md-12">
                <h1>Subject I Teach</h1>
                <p class="bluebg_txt">Chemistry (from Gen. Chem To Organic Chemistry Ii)</p>
                <p class="mt10">Chemistry Tests Preparation:AP-SAT-etc</p>
                <p class="bluebg_txt">High School Chemistry</p>
                <p class="mt10">Vietnamese</p>
                </div>
                <div class="clearfix"></div>
                </div>
                <div class="profile_right profile_graybg">
                <span class="edit_icon"><a href="#" data-toggle="modal" data-target="#education"><i class="fa fa-pencil pull-right"></i></a></span>
                <div class="modal fade" id="education" role="dialog">
                <div class="modal-dialog modal-md">
                  <div class="modal-content np">
                    <div class="modal-header">
                      <button type="button" class="close close_btn" data-dismiss="modal"><img src="img/close_icon.png"></button>
                    </div>
                        <div class="modal-body">
                        <div class="row">
                        	<div class="col-xs-12">
                            <h2>Your Education Experience</h2>
                            <div class="input-group">
                              <input type="text" id="exampleInlineTags" class="form-control token-example-field" value="" placeholder="Enter Subject" />
                              <div class="input-group-btn">
                            <button type="submit" class="btn btn-default">Add</button>
                            </div>
                            </div>
                             <div class="form-group mt15">
                              <textarea class="form-control" rows="2" id="comment"></textarea>
                            </div>
                              <div class="form-group">
                              <select class="form-control" id="university">
                                <option>Select University</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                              </select>
                            </div>
                            <div class="col-md-12 np">
                            <p>Employed from</p>
                            <div class="col-xs-5 col-sm-5 col-md-5 np">
                                <div class="form-group">
                                    <div class='input-group date' id='datetimepicker1'>
                                        <input type='text' class="form-control" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-2 col-sm-2 col-md-2 text-center">To</div>
                            <div class="col-xs-5 col-sm-5 col-md-5 np">
                                <div class="form-group">
                                    <div class='input-group date' id='datetimepicker2'>
                                        <input type='text' class="form-control" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            </div>
                            <center>
                            <button type="button" href="#" class="btn btn-default mt5">Cancel</button>
                            <button type="button" href="#" class="btn btn-success mt5">Save</button>
                            </center>
                            <div class="clearfix"></div>
                            </div>
                        </div>
                        </div>
                  </div>
                </div>
              </div>
                <h1>Education</h1>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6 mt10">
                    <div class="profile_left edu_txt">
                    <h4>Chemistry</h4>    
                    University Of Minnesota<br>
                    (Aug 09 - )
                    </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6 mt10">
                    <div class="profile_left edu_txt">
                    <h4>Chemistry</h4>    
                    University Of Minnesota<br>
                    (Aug 09 - )
                    </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6 mt10">
                    <div class="profile_left edu_txt">
                    <h4>Chemistry</h4>    
                    University Of Minnesota<br>
                    (Aug 09 - )
                    </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6 mt10">
                    <div class="profile_left edu_txt">
                    <h4>Chemistry</h4>    
                    University Of Minnesota<br>
                    (Aug 09 - )
                    </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                </div>
                <div class="profile_right profile_graybg">
                <span class="edit_icon"><a href="#" data-toggle="modal" data-target="#course"><i class="fa fa-pencil pull-right"></i></a></span>
                <div class="modal fade" id="course" role="dialog">
                <div class="modal-dialog modal-md">
                  <div class="modal-content np">
                    <div class="modal-header">
                      <button type="button" class="close close_btn" data-dismiss="modal"><img src="img/close_icon.png"></button>
                    </div>
                        <div class="modal-body">
                        <div class="row">
                        	<div class="col-xs-12">
                            <h2>Your Courses</h2>
                            <div class="input-group">
                              <input type="text" id="exampleInlineTags" class="form-control token-example-field" value="" placeholder="Enter Position" />
                              <div class="input-group-btn">
                            <button type="submit" class="btn btn-default">Add</button>
                            </div>
                            </div>
                             <div class="form-group mt15">
                              <textarea class="form-control" rows="2" id="comment"></textarea>
                            </div>
                              <div class="form-group">
                              <select class="form-control" id="university">
                                <option>Select University</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                              </select>
                            </div>
                            <div class="col-md-12 np">
                            <p>Employed from</p>
                            <div class="col-xs-5 col-sm-5 col-md-5 np">
                                <div class="form-group">
                                    <div class='input-group date' id='datetimepicker1'>
                                        <input type='text' class="form-control" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-2 col-sm-2 col-md-2 text-center">To</div>
                            <div class="col-xs-5 col-sm-5 col-md-5 np">
                                <div class="form-group">
                                    <div class='input-group date' id='datetimepicker2'>
                                        <input type='text' class="form-control" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            </div>
                            <center>
                            <button type="button" href="#" class="btn btn-default mt5">Cancel</button>
                            <button type="button" href="#" class="btn btn-success mt5">Save</button>
                            </center>
                            <div class="clearfix"></div>
                            </div>
                        </div>
                        </div>
                  </div>
                </div>
              </div>
                <h1>My Courses</h1>
                <p>Lecturor<br>
                Hanoi National University Of Education (May 04 - Aug 07)</p>
                <p>Research assistant<br>
                University Of Minnesota (Jan 08 - Aug 09)</p>
                <p>Lecturor<br>
                Hanoi National University Of Education (May 04 - Aug 07)</p>
                </div>
                <div class="profile_right profile_graybg">
                <h1>Comments</h1>
                <div class="row">
                    <div class="col-xs-4 col-sm-3 col-md-2">
                    <figure class="comment_img"><img src="img/comment_img1.jpg" alt=""/></figure>
                    </div>
                    <div class="col-xs-8 col-sm-9 col-md-10">
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
                    <p class="bluetxt"><span><img src="img/redbar.png" alt=""/></span>Anwesha Jha, Student</p>
                    </div>
                </div>
                <div class="row mt25">
                    <div class="col-xs-4 col-sm-3 col-md-2">
                    <figure class="comment_img"><img src="img/comment_img2.jpg" alt=""/></figure>
                    </div>
                    <div class="col-xs-8 col-sm-9 col-md-10">
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
                    <p class="bluetxt"><span><img src="img/redbar.png" alt=""/></span>Manider Singh, Parent</p>
                    </div>
                </div>
                <div class="clearfix"></div>
                </div>
            </div>
        </div>
        </div>
    
    <div class="clearfix"></div>
    </section>
    <section class="counter">
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
	<script type="text/javascript">
        $(function () {
            $('#datetimepicker1,#datetimepicker2').datetimepicker();
        });
		$(document).on('change', '.btn-file :file', function() {
		  var input = $(this),
			  numFiles = input.get(0).files ? input.get(0).files.length : 1,
			  label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
		  input.trigger('fileselect', [numFiles, label]);
		});
		
		$(document).ready( function() {
			$('.btn-file :file').on('fileselect', function(event, numFiles, label) {
				
				var input = $(this).parents('.input-group').find(':text'),
					log = numFiles > 1 ? numFiles + ' files selected' : label;
				
				if( input.length ) {
					input.val(log);
				} else {
					if( log ) alert(log);
				}
				
			});
		});
    </script>
    <script type="text/javascript" src="dist/js/UserContact.js"></script>
    <script type="text/javascript" src="dist/js/TutorProfile.js"></script>
<script type="text/javascript" src="dist/js/Signup.js"></script>




</body>

</html>