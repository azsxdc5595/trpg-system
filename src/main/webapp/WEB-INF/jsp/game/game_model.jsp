<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/game/game_model.js' />"></script>
<html>
    <head>
        <title>TRPG</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
        <link rel="stylesheet" type="text/css" href="/css/grid_startNight.css">
    </head>
    <body>
        <h2 class="trpg-title">TRPG 板塊地圖</h2>
        <form id="queryForm">
        	<input type="hidden" value='<c:out value="${snowNo}"/>' name="snowNo">
        </form>
        <div class="grid-wrapper">
            <div class="grid-container" id="mapGrid"></div>
        </div>
        <jsp:include page="/WEB-INF/jsp/game/game_status.jsp" />
        <form id="checkForm">
        	<input type="hidden" value='<c:out value="${snowNo}"/>' name="snowNo">
        	<input type="hidden" name="id">
        	<input type="hidden" name="x">
        	<input type="hidden" name="y">
        	<input type="hidden" name="floor">
        	<input type="hidden" name="icon">
        </form>
    </body>
</html>
