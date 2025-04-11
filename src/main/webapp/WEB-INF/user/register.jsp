<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 회원가입</title>
</head>
<body>
  <c:if test="${!empty msg}">
    <script>
      alert("${msg}");
    </script>
  </c:if>
  <form action="user" method="POST">
    <input type="hidden" name="act" value="register">
    <input type="text" name="id" placeholder="아이디를 입력하세요">
    <input type="password" name="password" placeholder="비밀번호를 입력하세요">
    <input type="submit" value="회원가입">
  </form>
</body>
</html>
