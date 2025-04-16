<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/game/game_label.js' />"></script>
<html>
    <head>
        <title>TRPG</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/label.css">
    </head>
    <body>
		<div class="game-label">
		    <div class="game-label-Player-toggle">角色</div>
		    <div class="game-label-Player-content">
		    	<img src="\icon\Player Character\A.png" width="210px" hight="300px"/>
		        <div class="game-label-Player-title">角色屬性</div>
		        <ul>
		            <li>力量：10</li>
		            <li>敏捷：8</li>
		            <li>智力：7</li>
		            <li>體力：12</li>
		        </ul>
			    <div class="game-label-Item-toggle">背包</div>
			    <div class="game-label-Item-content">
			        <div class="game-label-Item-title">持有道具</div>
			        <ul>
			            <li>名稱：10</li>
			            <li>圖示：<img /></li>
			            <li>描述：...</li>
			        </ul>
			    </div>
		    </div>
		</div>
    </body>
</html>
