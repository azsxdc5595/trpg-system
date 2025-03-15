<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/game/game_status.js' />"></script>
<html>
    <head>
        <title>TRPG</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/game_status.css">
    </head>
    <body>
		<div class="game-status">
		    <div class="game-status-content">
		    	<input type="hidden" name="roundCountInput" value="1">
		        <p id="roundNumber">回合數: 現在是第 <span id="roundCount"></span> 回合</p>
		        <input type="hidden" name="gameHintInput" value="請抽板塊">
		        <p id="gameHint"></p>
		
		        <!-- 抽板塊按鈕 -->
		        <button id="drawTileButton">抽</button>
		
		        <!-- 抽出的板塊預覽 -->
		        <div class="tile-preview">
		        	<!-- 抽出新板塊 -->
		        </div>
		    </div>
		</div>
    </body>
</html>
