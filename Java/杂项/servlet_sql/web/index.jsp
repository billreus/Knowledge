<%--
  Created by IntelliJ IDEA.
  User: billdog
  Date: 2018/11/2
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <form action="login" method="post"> <%-- action的动作和xml中的url绑定 --%>
        用户名：<input type="text" name="name"> <br>
        密码：  <input type="password" name="password"> <br>
                <input type="submit" value="确定">
    </form>
</body>
</html>
