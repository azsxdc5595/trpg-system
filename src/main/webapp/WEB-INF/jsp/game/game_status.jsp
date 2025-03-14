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
            <p id="roundNumber">第 1 回合</p>
            <p id="gameHint">Hi</p>
            <button id="drawTileButton" type="button">抽</button>
            <div class="tile-preview">

            </div>
        </div>
    </body>
</html>
