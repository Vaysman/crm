<%-- 
    Document   : greencard
    Created on : Mar 19, 2018, 12:04:36 PM
    Author     : antoxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/groundwork/css/groundwork.css" />" />
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
        <script type="text/javascript" src="<c:url value="/resources/scripts/jquery-2.1.4.min.js"/>"></script>
        <title>Оформление Зеленой карты</title>
    </head>
    <body>
        <div style="margin: 0 auto; width: 80%">
            <h1>Страница оформления полиса "Зеленая карта"</h1>
            <c:choose>
                <c:when test="${param.p=='1'}">
                    <%@include file="/WEB-INF/pages/greencard/polis.jspf" %>
                </c:when>
                <c:when test="${param.p=='2'}">
                    <%@include file="/WEB-INF/pages/greencard/client.jspf" %>
                </c:when>
                <c:when test="${param.p=='3'}">
                    <%@include file="/WEB-INF/pages/greencard/auto.jspf" %>
                </c:when>
                <c:when test="${param.p=='end'}">
                    <h3>Проверьте данные перед отправкой</h3>
                    <form action="order" method="POST">
                        <span class="">№ полиса: </span> <span>${polis.number}</span> <br />
                        <span>Дата продажи: </span> <span>${polis.date_sale}</span> <br />
                        <span>Фамилия клиента: </span> <span>${client.lastName}</span> <br />
                        <span>Имя клиента: </span> <span>${client.name}</span> <br />
                        <span>Модель авто: </span> <span>${auto.model}</span> <br />
                        <span>Марка авто: </span> <span>${auto.brand}</span> <br />
                        <button class="green button">Оформить</button>
                    </form>
                </c:when>
            </c:choose>
        </div>
    </body>
</html>
