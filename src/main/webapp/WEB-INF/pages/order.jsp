<%-- 
    Document   : order
    Created on : Mar 27, 2018, 11:26:24 AM
    Author     : antoxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/groundwork/css/groundwork.css" />" />
        <title>Страница подтверждения заказа</title>
    </head>
    <body>
        <h1>Страница подтверждения заказа:</h1>
        <form method="post">
            <span>Марка авто: </span> <span>${greencard.auto.model}</span> <br />
            <span>Владелец: </span> <span>${greencard.client.name}</span> <br/>
            <span>Владелец по английски: </span> <span>${greencard.client.name_ENG}</span> <br/>
            <span>Номер полиса: </span> <span>${greencard.polis.number}</span><br/>
            <button class="green button left">Печать</button>
        </form>
    </body>
</html>
