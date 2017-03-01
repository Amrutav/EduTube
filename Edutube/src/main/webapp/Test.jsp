<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<input type="text" name="name" id="name" onkeypress="showData(this.value);">


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
function showData(value){ 
$.ajax({
    url : "/Edutube/utils/subjectList,
    type : "POST",
    async : false,
    success : function(data) {
//Do something with the data here
    }
});
}
</script>







</body>
</html>