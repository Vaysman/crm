<%-- 
    Document   : segment
    Created on : Jul 31, 2018, 11:12:20 AM
    Author     : antoxa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/resources/css/groundwork/css/groundwork.css" />" />
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
        <title>Сегмент</title>
    </head>
    <body>
        <header class="centered">
            <h3 class="centered" style="width: 80%">Анализ текущих условий сегментации и комиссионного вознаграждения по ОСАГО от разных страховых компаний.</h3>
        </header>
        <c:choose>
            <c:when test="${target == 'inputForm'}">
                <%@include file="modules/segment/inputForm.jspf" %>
            </c:when>
            <c:when test="${target == 'result'}">
                <%@include file="modules/segment/result.jspf" %>
            </c:when>
            <c:when test="${target == 'admins'}">
                <%@include file="modules/segment/admins.jspf" %>
            </c:when>
            <c:otherwise>
                <h3>Неверные параметры запроса!</h3>
            </c:otherwise>
        </c:choose>
    </body>
    <script type="text/javascript" src="<c:url value='/resources/scripts/jquery-2.1.4.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/scripts/segment.js'/>"></script>
</html>
