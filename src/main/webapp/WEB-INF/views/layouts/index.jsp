<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../library/taglib.jsp" %>
<html lang="vi">
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <%@include file="../../library/library_css.jsp" %>
    <script src="/resources/js/plugin/jquery-3.2.1.min.js"></script>
    <script src="/resources/js/demo.js"></script>
    <script src="/resources/js/common.js"></script>


</head>
<body class="goto-here">

<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="menu"/>

<tiles:insertAttribute name="body"/>

<tiles:insertAttribute name="foot-nav"/>

<tiles:insertAttribute name="footer"/>
<!----------------------Script------------------------------------ -->
<%@include file="../../library/libraby_js.jsp" %>
</body>
</html>
