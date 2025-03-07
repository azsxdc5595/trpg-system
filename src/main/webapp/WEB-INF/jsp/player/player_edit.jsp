<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/player/player_edit.js' />"></script>

<html>
    <head>
        <title>編輯角色</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">編輯角色</h2>
        <form id="playerForm" class="form-center">
            <input type="hidden" name="uid" value="<c:out value='${player.uid}'/>">
            名稱：<input type="text" name="name" value="<c:out value='${player.name}'/>"><br/>
            種族：<input type="text" name="race" value="<c:out value='${player.race}'/>"><br/>
            職業：<input type="text" name="profession" value="<c:out value='${player.profession}'/>"><br/>
            力量：<input type="number" name="strength" value="<c:out value='${player.strength}'/>"><br/>
            敏捷：<input type="number" name="dexterity" value="<c:out value='${player.dexterity}'/>"><br/>
            智力：<input type="number" name="intelligence" value="<c:out value='${player.intelligence}'/>"><br/>
            幸運：<input type="number" name="luck" value="<c:out value='${player.luck}'/>"><br/>
            生命：<input type="number" name="health" value="<c:out value='${player.health}'/>"><br/>
            <h3 class="margin-Btn"></h3>
            <button type="button" id="editBtn" class="submit-btn">保存</button>
        </form>
        <div class="center-link link">
            <a href="/player/">返回列表</a>
        </div>
    </body>
</html>
