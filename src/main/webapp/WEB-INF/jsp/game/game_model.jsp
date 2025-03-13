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
        <link rel="stylesheet" type="text/css" href="/css/grid.css">
    </head>
    <body>
    	<input type="hidden" id="startMapTitle" name="startMapTitle"
    value='{"id": ${startMapTitle.id}, "trapFlag": ${startMapTitle.trapFlag}, "pattern": "${startMapTitle.pattern}", "enabled": ${startMapTitle.enabled}, "icon": "${startMapTitle.icon}", "name": "${startMapTitle.name}"}'>
    	<h2 class="trpg-title">TRPG 板塊地圖</h2>
	    
	    <div class="grid-wrapper">
	        <div class="grid-container" id="mapGrid"></div>
	    </div>
    </body>
</html>
