<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/login.css" />
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />


<meta charset="UTF-8">
<title>로그인페이지</title>

</head>
<body>
	<div id="container">
	
		<!-- Heading -->
		<h1>
			<img src="img/shopimg.png">
		</h1>
		
		<!-- Form -->
		<form name="loginform" action="/login" method="post">
			<!-- 아이디 입력란 -->
			<div class="first-input input__block first-input__block">
				<input type="text" placeholder="ID를 입력하세요." class="input" id="memberID" name="memberID" oninput="removeWhitespace(this)" />
			</div>

			<!-- 비밀번호 입력란 -->
			<div class="input__block">
				<input type="password" placeholder="비밀번호를 입력하세요." class="input" id="memberPW" name="memberPW" oninput="removeWhitespace(this)" />
			</div>
			<button class="signin__btn" loginform.submit>로그인</button>
		</form>
		<button class="join__btn" onclick="location.href='joinTermsOfUse.do'">회원가입</button>
	</div>
	
</body>
<!-- jQuery Plugin -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/join.js"></script>
<script src="js/login.js"></script>

</html>
