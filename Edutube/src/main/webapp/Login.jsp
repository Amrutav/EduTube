<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="google-signin-client_id" content="594374593997-o43u02nh92q0gv8dmqem9mfs8qmu0de3.apps.googleusercontent.com">
<title>Insert title here</title>
<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
</head>
<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
	FB.getLoginStatus(function(response) {
    	statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '954579674564443',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.4' // use version 2.2
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.
  
  // Load the SDK asynchronously
  
  
//   window.fbAsyncInit = function() {
// 	    FB.init({
// 	      appId      : '954579674564443',
// 	      xfbml      : true,
// 	      version    : 'v2.4'
// 	    });
// 	  };

// 	  (function(d, s, id){
// 	     var js, fjs = d.getElementsByTagName(s)[0];
// 	     if (d.getElementById(id)) {return;}
// 	     js = d.createElement(s); js.id = id;
// 	     js.src = "//connect.facebook.net/en_US/sdk.js";
// 	     fjs.parentNode.insertBefore(js, fjs);
// 	   }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.

  FB.getLoginStatus(function(response) {
	  alert(JSON.stringify(response));
	  alert(response.authResponse.accessToken);
    statusChangeCallback(response);
  });

  };
  
  (function(d, s, id) {
	  alert(s);
	  alert(d);
	  alert(id);
	    var js, fjs = d.getElementsByTagName(s)[0];
	    alert(fjs);
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "//connect.facebook.net/en_US/sdk.js";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));

 
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
    	alert(JSON.stringify(response));
    	alert("name"+response.name);
    	alert("email"+response.email);
    	alert("first_name"+response.first_name);
    	alert("last_name"+response.last_name);
    	alert("id"+response.id);
    	alert("country"+response.country);
    	//alert("first_name"+response.first_name);
    	//alert("last_name"+response.last_name);
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
  
//   function onSignIn(googleUser) {
// 	  var profile = googleUser.getBasicProfile();
// 	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
// 	  console.log('Name: ' + profile.getName());
// 	  console.log('Image URL: ' + profile.getImageUrl());
// 	  console.log('Email: ' + profile.getEmail());
// 	}
  function onSuccess(googleUser) {
      console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
    }
    function onFailure(error) {
      console.log(error);
    }
  function renderButton() {
      gapi.signin2.render('my-signin2', {
        'scope': 'https://www.googleapis.com/auth/plus.login',
        'width': 200,
        'height': 50,
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure
      });
    }
</script>

<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->
<body>
<!-- <a href="javascript:checkLoginState();"><img src="img/Facebook.png" style="max-width:183px; margin-bottom:20px"></a> -->

<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>

<div id="status">
</div>
<br/><br/><br/><br/><br/><br/><br/>
<!-- <div class="g-signin2" data-onsuccess="onSignIn"></div> -->
<!-- <div class="g-signin2" data-width="300" data-height="200" data-longtitle="true"> -->
<div id="my-signin2"></div>
</body>
</html>