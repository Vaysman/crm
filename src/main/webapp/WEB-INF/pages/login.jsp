<%-- 
    Document   : login
    Created on : Mar 16, 2018, 12:05:26 PM
    Author     : antoxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <form:form commandName="user" action="login" method="POST">
                    <fieldset>
                        <span><b>Введите учетный данные:</b></span>
                        <label>Имя пользователя: </label> <form:input path="login" name="login" class="gap-bottom" />
                        <label>Пароль: </label> <form:password path="password" name="password" class="gap-bottom" />
                        <c:if test="${error != null}" >
                            <span class="message error gap-bottom">
                                ${error}
                            </span>
                        </c:if> 
                        <footer class="gap-top">
                            <a href="<c:url value="/" />">На главную</a>
                            <button class="success button pull-right">Вход</button>
                        </footer>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </body>
</html>
