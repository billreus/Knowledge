<%--
  Created by IntelliJ IDEA.
  User: billdog
  Date: 2018/11/7
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>hp</td>
        <td>damage</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st">
        <tr>
            <td>${hero.id}</td>
            <td>${hero.name}</td>
            <td>${hero.hp}</td>
            <td>${hero.damage}</td>
            <td><a href="editHero?id=${hero.id}">edit</a></td>
            <td><a href="deleteHero?id=${hero.id}">delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" align="center">
            <a href="listHero?start=0">首页</a>
            <a href="listHero?start=${next}">[下一页]</a>
            <a href="listHero?start=${pre}">[上一页]</a>
            <a href="listHero?start=${last}">[末页]</a>
        </td>
    </tr>
</table>

