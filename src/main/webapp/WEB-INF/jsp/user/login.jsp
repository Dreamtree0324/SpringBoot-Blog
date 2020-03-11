<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: makestar
  Date: 20. 3. 11.
  Time: 오후 4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/login" method="post">
    <input type="text" name="username" placeholder="이메일">
    <input type="password" name="password" placeholder="비밀번호">
    <button type="submit">로그인</button>
</form>
</body>
</html>
