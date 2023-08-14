<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 상대경로 사용, [현재 URL의 경로 + /save] -->
<form action="save" method="post">
  유저이름: <input type="text" name="username" />
  나이: <input type="text" name="age" />
  <button type="submit">전송</button>
</form>
</body>
</html>
