<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="component/all.jsp"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- ===== CSS ===== -->
<link rel="stylesheet" href="assets/css/styles.css">

<!-- ===== BOX ICONS ===== -->
<link
	href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css'
	rel='stylesheet'>

<title>Responsive Login Form Sign In Sign Up</title>
</head>
<body>
	<div class="login">
		<div class="login__content">
			<div class="login__img">
				<img src="assets/img/img-login.svg" alt="">
			</div>

			<div class="login__forms">
				<form action="login" class="login__registre" id="login-in"
					method="post">
					<h1 class="login__title">Sign In</h1>

					<div class="login__box">
						<i class='bx bx-user login__icon'></i> <input type="text"
							placeholder="Username" name="username" class="login__input">
					</div>

					<div class="login__box">
						<i class='bx bx-lock-alt login__icon'></i> <input type="password"
							placeholder="Password" name="password" class="login__input">
					</div>

					<a href="#" class="login__forgot">Forgot password?</a> <input
						type="submit" class="login__button" value="Sign In">
					
					
					
				
					
					
					<%
					String msg = (String) session.getAttribute("msg");
					if (msg != null) {
					%>
					<div class="alert alert-success" role="alert">
						<%=msg%>
					</div>
					<%
					session.removeAttribute("msg");
					}
					%>

					<%
					String fail = (String) session.getAttribute("fail");
					if (fail != null) {
					%>
					<div class="alert alert-danger" role="alert">
						<%=fail%>
					</div>
					<%
					session.removeAttribute("fail");
					}
					%>

					<div>
						<span class="login__account">Don't have an Account ?</span> <span
							class="login__signin" id="sign-up">Sign Up</span>
					</div>
				</form>

				<form action="register" class="login__create none" method="post"
					id="login-up">
					<h1 class="login__title">Create Account</h1>

					<div class="login__box">
						<i class='bx bx-user login__icon'></i> <input type="text"
							placeholder="Username" name="username" class="login__input">
					</div>

					<div class="login__box">
						<i class='bx bx-at login__icon'></i> <input type="text"
							placeholder="Email" name="email" class="login__input">
					</div>

					<div class="login__box">
						<i class='bx bx-lock-alt login__icon'></i> <input type="password"
							placeholder="Password" name="password" class="login__input">
					</div>

					<input type="submit" class="login__button" value="Sign Up">


					<div>
						<span class="login__account">Already have an Account ?</span> <span
							class="login__signup" id="sign-in">Sign In</span>
					</div>

					<div class="login__social">
						<a href="#" class="login__social-icon"><i
							class='bx bxl-facebook'></i></a> <a href="#"
							class="login__social-icon"><i class='bx bxl-twitter'></i></a> <a
							href="#" class="login__social-icon"><i class='bx bxl-google'></i></a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!--===== MAIN JS =====-->
	<script src="assets/js/main.js"></script>
</body>
</html>