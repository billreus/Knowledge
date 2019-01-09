<%--
  Created by IntelliJ IDEA.
  User: billdog
  Date: 2018/11/6
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,bean.*,java.sql.*"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action='updateHero' method='post'>
    名字 ： <input type='text' name='name' value='${hero.name}'> <br>
    血量 ：<input type='text' name='hp' value='${hero.hp}'> <br>
    伤害： <input type='text' name='damage' value='${hero.damage}'> <br>
    <input type='hidden' name='id' value='${hero.id}'>
    <input type='submit' value='更新'>
</form>
</body>
</html>
