<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session = "true" %>

   <div id="header">
      <h1>My Homepage</h1>
      <p>authUser: ${authUser }</p>
      <c:choose>
      
      
	      <c:when test="${not empty authUser }">
		      <ul>
		      	<li><a href="<%=request.getContextPath() %>/users?a=logout">로그아웃</a>
		      	<li><a href="<c:url value="/users?a=logout" />">로그아웃</a>
		      	<li>${authUser.name }님 환영합니다.</li>
		    <!-- 로그인 한 사용자 -->
		    <!-- Welcome massage, logout link -->
		      </ul>
	      </c:when>

      	  <c:otherwise>
		      <ul>
		        <li><a href="<c:url value="/users?a=joinform" />">회원가입</a></li>
		      	<li><a href="<c:url value="/users?a=loginform" />">로그인</a></li>
		      </ul>
		  </c:otherwise> 
      </c:choose>

      <!-- h3>Params</h3>
      <ul>
      	<li>Param1:${param.param1}</li>
      	<li>Param2:${param.param2}</li>
      </ul -->
      
      
    </div> 
