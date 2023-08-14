<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    성공
<ul> <!-- JSP는 모델자료형을 Object형으로 받기때문에 다운캐스팅 해주어야 함 -->
    <li>PK ID: <%=((Member)request.getAttribute("member")).getId()%></li>
    <li>유저이름: <%=((Member)request.getAttribute("member")).getUsername()%></li>
    <!-- 그러나 아래 표현식을 사용하면 편리하게 사용가능-->
    <li>나이: ${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
