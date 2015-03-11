<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hospital Plus</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery-1.10.2.js"></script>
<script src="js/BootstrapValidatorModified.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrapValidator.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript">
	$(function() {
		/*
		$("#submitForm1").click(function() {
			$("#adminForm").submit();
		});

		$("#loginBtn").click(function() {
			$("#loginForm").submit();
		});
		 */
		/******This is default setting for bootstrap validator - used for all forms************/
		$.fn.bootstrapValidator.DEFAULT_OPTIONS = $.extend( {},
				$.fn.bootstrapValidator.DEFAULT_OPTIONS, {
					feedbackIcons : {
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					}
				});

		$('#loginForm')
				.bootstrapValidator( {
						container : 'popover',
						fields : {
							userName : {
								validators : {
									notEmpty : {
										message : 'The username is required'
									},
									stringLength : {
										min : 6,
										max : 20,
										message : 'Username length must between 6 to 20 characters.'
									}
								}
							},
							password : {
								validators : {
									notEmpty : {
										message : 'The password is required'
									},
									stringLength : {
										max : 20,
										message : 'Maximum password length is 20 characters.'
									}
								}
							}
						}
					});

	});
</script>
</head>
<body background="img/health_background.jpg">
<%	String msg = "";
	msg = request.getParameter("err");
	if (msg != null) {
		if (msg.equals("usr")) {
			msg = "<div class='alert alert-sm alert-danger' style='margin:0px 0px 5px 0px;'> <button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button><i class='fa fa-exclamation-triangle'></i> Invalid username-password combination.</div>";
		} else if (msg.equals("loginAuth")) {
			msg = "<div class='alert alert-sm alert-danger' style='margin:0px 0px 5px 0px;'> <button type='button' class='close' data-dismiss='alert'><span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span></button><i class='fa fa-exclamation-triangle'></i> Session expired, Please login.</div>";
		} else {
			msg = "";
		}
	} else {
		msg = "";
	}
%>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4" style="margin-top: 150px;">
			<center>
				<h1 class="text-primary bs-danger">Hospital Plus</h1>
			</center>
			<div class="login-panel panel panel-default">
			<div class="panel-heading">
			<h3 class="panel-title">Sign In</h3>
		</div>

<div class="panel-body">
<form role="form" action="UserLoginServlet" name="loginForm"
	id="loginForm" method="post">
<fieldset>
<div class="form-group"><span class="text-danger"><%=msg%></span><input
	class="form-control" placeholder="Enter Username" name="userName"
	type="text" autofocus></div>
<div class="form-group"><input class="form-control"
	placeholder="Enter Password" name="password" type="password"></div>
<div class="checkbox"><label> <input name="remember"
	type="checkbox" value="Remember Me">Remember Me </label></div>
<!-- Change this to a button or input when using this as a form -->
<button type="submit" id="loginBtn"
	class="btn btn-lg btn-success btn-block">Login</button>
</fieldset>
</form>
</div>

</div>
<div class="footer">
<p class="text-center">Designed &amp; maintained by <br />
<a href="http:/www.insightant.com" target="_blank">Insightant
Technology Solutions Pvt Ltd</a></p>
</div>

</div>
</div>
</div>




</body>
</html>