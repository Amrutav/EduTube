<!-- <!DOCTYPE html> -->
<!-- <html ng-app="app"> -->
<!-- <head> -->
<!-- <meta charset="utf-8" /> -->
<!-- <title>edutube</title> -->
<!-- <link href="dist/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- <!-- <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" /> --> -->
<!-- <link href="dist/css/style.css" rel="stylesheet"> -->
<!-- <link href="dist/css/font-awesome.css" rel="stylesheet"> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<div id="wrapper"> -->
<!-- 		<!--Header !--> -->
<!-- 		<div class="header_bg clearfix3333"> -->
<!-- 			<div class="container top_logo_area"> -->
<!-- 				<div class="col-xs-4 col-sm-7 col-md-9"> -->
<!-- 					<a href="/Edutube"><img src="img/top_text_logo.png" alt="Logo" -->
<!-- 						title="Edutube" /></a> -->
<!-- 				</div> -->
<!-- 				<div class="col-xs-8 col-sm-4 col-md-3"> -->
<!-- 					<ul ng-controller="LogoutController"> -->
<!-- 						<li ng-show="logintab"><a href="#/" ng-click="launchLoginModal()" class="logintab">Login</a></li> -->
<!-- 						<li ng-show="logouttab"><a href="#/logout" -->
<!-- 							ng-click="logout()" class="logouttab">Logout</a></li> -->

<!-- 						<li ng-show="registertab"><a href="#/" ng-click="launchRegisterModal()" -->
<!-- 							class="registertab">Sign up</a></li> -->
<!-- 					</ul> -->
<!-- 					<ul> -->
<!-- 						<li ng-show="myaccounttab"><a href="#/myaccount" -->
<!-- 							class="registertab">my account</a></li> -->
<!-- 					</ul> -->
<!-- 					<div class="modal fade" id="login" role="dialog">
<!-- 						<div class="modal-dialog modal-lg"> -->
<!-- 							<div class="modal-content"> -->
<!-- 								<div class="modal-header"> -->
<!-- 									<button type="button" class="close close_btn" -->
<!-- 										data-dismiss="modal"> -->
<!-- 										<img src="img/close_icon.png"> -->
<!-- 									</button> -->
<!-- 								</div> -->
<!-- 								<div class="modal-body"></div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> --> -->
					
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<div -->
<!-- 				ng-class="{ 'alert': flash, 'alert-success': flash.type === 'success', 'alert-danger': flash.type === 'error' }" -->
<!-- 				ng-if="flash" ng-bind="flash.message"></div> -->
<!-- 			<div ng-view></div> -->
<!-- 		</div> -->
<!-- 		<!-- Footer --> -->
<!-- 		<footer id="footer"> -->
<!-- 			<div class="container"> -->
<!-- 				<div class="row"> -->
<!-- 					<div class="col-xs-6 col-sm-6 col-md-3 mt10"> -->
<!-- 						<h3>Quick Links</h3> -->
<!-- 						<ul> -->
<!-- 							<li>Home</li> -->
<!-- 							<li>About Us</li> -->
<!-- 							<li>Courses</li> -->
<!-- 							<li>Offers</li> -->
<!-- 							<li>Faq</li> -->
<!-- 							<li>Blog</li> -->
<!-- 							<li>Contact Us</li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 					<div class="col-xs-6 col-sm-6 col-md-3 mt10"> -->
<!-- 						<h3>Information</h3> -->
<!-- 						<ul> -->
<!-- 							<li>Tutors</li> -->
<!-- 							<li>Students</li> -->
<!-- 							<li>Parents</li> -->
<!-- 							<li>How it works</li> -->
<!-- 							<li>View demo</li> -->
<!-- 							<li>Pricing</li> -->
<!-- 							<li>Dashboard</li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 					<div class="col-xs-12 col-sm-6 col-md-3 mt15"> -->
<!-- 						<h3>Exams</h3> -->
<!-- 						<ul> -->
<!-- 							<li>CBSE</li> -->
<!-- 							<li>ICSE</li> -->
<!-- 							<li>IIT-JEE Foundation</li> -->
<!-- 							<li>NTSE</li> -->
<!-- 							<li>PSA</li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 					<div class="col-xs-12 col-sm-6 col-md-3"> -->
<!-- 						<div class="footer_social"> -->
<!-- 							<h3>Follow Us</h3> -->
<!-- 							<p class="mt15">Just select your favorite social network to -->
<!-- 								get started</p> -->
<!-- 							<ul class="mt20"> -->
<!-- 								<li><a href="#" class="icon icon-mono facebook">facebook</a></li> -->
<!-- 								<li><a href="#" class="icon icon-mono twitter">twitter</a></li> -->
<!-- 								<li><a href="#" class="icon icon-mono googleplus">google+</a></li> -->
<!-- 								<li><a href="#" class="icon icon-mono linkdin">google+</a></li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="clearfix"></div> -->
<!-- 		</footer> -->
<!-- 		<div class="footer_copyright"> -->
<!-- 			<div class="container">&copy; Edutube 2015. All Right Reserved</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> -->
<!-- 	<!-- Include all compiled plugins (below), or include individual files as needed --> -->
<!-- 	<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> -->

<!-- 	<script> -->
// 		$(function() {
// 			$('.tmenu a[href*=#]:not([href=#])')
// 					.click(
// 							function() {
// 								if (location.pathname.replace(/^\//, '') == this.pathname
// 										.replace(/^\//, '')
// 										&& location.hostname == this.hostname) {

// 									var target = $(this.hash);

// 									target = target.length ? target
// 											: $('[name=' + this.hash.slice(1)
// 													+ ']');
// 									if (target.length) {
// 										$('html,body').animate({
// 											scrollTop : target.offset().top
// 										}, 1000);
// 										return false;
// 									}
// 								}
// 							});
// 			if (window.location.hash === "#/login") {
// 				$("a[href*='#/login']").click();
// 			}
// 			if (window.location.hash === "#/register") {
// 				$("a[href*='#/register']").click();
// 			}
// 		});
<!-- 	</script> -->

<!-- 	<script> -->
// 		$(window).scroll(function() {
// 			if ($(window).scrollTop() >= 660) {
// 				$('.home_header').addClass('fixed-header');
// 			} else {
// 				$('.home_header').removeClass('fixed-header');
// 			}
// 		});
<!-- 	</script> -->

<!-- 	<script src="dist/js/bootstrap.min.js" type="text/javascript"></script> -->
<!-- 	<script src="dist/js/jquery.scrollto.js" type="text/javascript"></script> -->
<!-- 	<!-- <script src="dist/js/coretheme.min.js" type="text/javascript"></script> --> -->

<!-- 	<!-- <script src="dist/js/angular/angular.js"></script> --> -->
<!-- 	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script> -->
<!-- 	<script src="dist/js/angular/angular-route.js"></script> -->
<!-- 	<!-- <script src="dist/js/angular//angular-cookies.js"></script> -->
<!-- 	<script src="dist/js/angular/angular-resource.js"></script> --> -->
<!-- 	<script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-cookies.min.js"></script> -->
<!-- 	<script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular-resource.min.js"></script> -->
<!-- 	<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.14.3.js"></script> -->
	
<!-- 	<script src="dist/js/app.js"></script> -->
<!-- 	<script src="dist/js/angular/services/authentication.service.js"></script> -->
<!-- 	<script src="dist/js/angular/services/flash.service.js"></script> -->

<!-- 	<!-- Real user service that uses an api --> -->
<!-- 	<!-- <script src="app-services/user.service.js"></script> --> -->

<!-- 	<!-- Fake user service for demo that uses local storage --> -->
<!-- 	<script src="dist/js/angular/services/user.service.local-storage.js"></script> -->

<!-- 	<script src="dist/js/angular/controllers/home.controller.js"></script> -->
<!-- 	<script src="dist/js/angular/controllers/login.controller.js"></script> -->
<!-- 	<script src="dist/js/angular/controllers/logout.controller.js"></script> -->
<!-- 	<script src="dist/js/angular/controllers/account.controller.js"></script> -->
<!-- 	<script src="dist/js/angular/controllers/register.controller.js"></script> -->
<!-- </body> -->
<!-- </html> -->