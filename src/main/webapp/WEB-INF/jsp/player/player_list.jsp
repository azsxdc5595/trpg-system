<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/player/player_list.js' />"></script>
<html>
    <head>
        <title>角色列表</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">角色列表</h2>
        <table class="center-table">
            <tr>
                <th>UID</th>
                <th>名稱</th>
                <th>種族</th>
                <th>職業</th>
                <th>力量</th>
                <th>敏捷</th>
                <th>智力</th>
                <th>幸運</th>
                <th>生命</th>
                <th>操作</th>
            </tr>
            <c:forEach var="player" items="${players}">
                <tr>
                    <td>${player.uid}</td>
                    <td>${player.name}</td>
                    <td>${player.race}</td>
                    <td>${player.profession}</td>
                    <td>${player.strength}</td>
                    <td>${player.dexterity}</td>
                    <td>${player.intelligence}</td>
                    <td>${player.luck}</td>
                    <td>${player.health}</td>
                    <td>
                        <form action="/player/toEdit" method="POST">
                            <input type="hidden" name="uid" value="<c:out value='${player.uid}'/>">
                            <button type="submit" class="edit-btn">編輯角色</button>
                        </form>
                        <form class="action-form">
                            <input type="hidden" name="uid" value="<c:out value='${player.uid}'/>"/>
                            <button type="button" class="delete-btn">刪除角色</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- 分頁控制 -->
        <div class="link center">
            <c:if test="${currentPage > 1}">
                <a href="/player/query?page=${currentPage - 1}">上一頁</a>
            </c:if>
            
            <c:forEach var="i" begin="1" end="${totalPages}">
                <a href="/player/query?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a>
            </c:forEach>
            
            <c:if test="${currentPage < totalPages}">
                <a href="/player/query?page=${currentPage + 1}">下一頁</a>
            </c:if>
        </div>
        <h3 class="margin-Btn"></h3>
        <div class="form-center">
            <form action="/player/new" method="POST" class="center">
                <button type="submit" class="submit-btn">新增角色</button>
            </form>
            <div class="center-link link">
                <a href="/manage/">返回管理列表</a>
            </div>
        </div>
    </body>
</html>
