<%-- 
    Document   : main
    Created on : Mar 19, 2018, 12:05:20 PM
    Author     : antoxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/groundwork/css/groundwork.css" />" />
        <title>CRM Страховой брокер</title>
    </head>
    <body>
        <div class="center silver" style="width:80%">
            <h2>Главная страница системы CRM Страховой брокер</h2>
            <h3>Выберите вид оформляемого полиса:</h3>
            <a href="greencard?p=1" class="green button">Зеленая карта</a>
            <a class="green button disabled">ОСАГО</a>
            <a class="green button disabled">КАСКО</a>
            <a class="green button disabled">Имущество</a>
            <br /> <br />
            <h3>Дополнительные модули:</h3>
            <form action="modules/segment">
                <input type="hidden" name="user" value="${user.login}" />
                <button class="blue button">Сегмент</button>
            </form>
        </div>
    </body>
</html>
