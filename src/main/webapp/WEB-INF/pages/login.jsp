<%-- 
    Document   : login
    Created on : Mar 16, 2018, 12:05:26 PM
    Author     : antoxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
        <link href="<c:url value="/resources/css/groundwork/css/groundwork.css" />" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <div>
            <h2 align="center">Авторизация в CRM "Страховой брокер"</h1>
            <div style="width: 20em;" class="centered padded">
                <form action="<c:url value="/j_spring_security_check" />" method="POST">
                    <fieldset>
                        <sec:authorize access="isAuthenticated()">
                            <p>Привет <sec:authentication property="principal.username" /></p>
                        </sec:authorize>
                        <span><b>Введите учетный данные:</b></span>
                        <label>Имя пользователя: </label> <input type="text" name="username" class="gap-bottom" />
                        <label>Пароль: </label> <input type="password" name="password" class="gap-bottom" />
                        <footer class="gap-top">
                            <a href="/">На главную</a>
                            <button class="success button pull-right">Вход</button>
                        </footer>
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
