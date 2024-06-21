<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Home: Join Form</title>
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/users.css" />
</head>
<body>
<div id="container">
	<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
	<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
	
<div id="wrapper">
	<div id = "content"	>

	<h1>Join Form</h1>
	
	<form method="POST" action="<%= request.getContextPath() %>/users">
		<input type="hidden" name="a" value="join" />
		<label for="name">이름</label>
		<input type="text" name="name" placeholder="이름을 입력하세요"/><br/>
		<label for="password">비밀번호</label>
		<input type="password" name="password" placeholder="비밀번호를 입력하세요"/><br/>
		<label for="email">이메일</label>
		<input type="text" name="email" placeholder="이메일을 입력하세요"/><br/>
		<label for="gender">성별</label>
		<input type="radio" name="gender" value="M" checked>남성
		<input type="radio" name="gender" value="F">여성
		<input type="submit" value="가입" />
		
	</form>
	<!-- form 검증 -->
	
	</div>
	</div>
	<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	

	</div>	
</body>
</html>