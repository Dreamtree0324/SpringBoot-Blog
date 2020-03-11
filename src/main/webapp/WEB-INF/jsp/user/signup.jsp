<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: makestar
  Date: 20. 3. 11.
  Time: 오후 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 가입</h1>
<hr>

<form action="/user/signup" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="text" name="email" placeholder="이메일 입력해주세요">
    <input type="password" name="password" placeholder="비밀번호">
    <input type="text" name="nickname" placeholder="닉네임">
    <button type="submit">가입하기</button>
</form>
</body>
</html>
