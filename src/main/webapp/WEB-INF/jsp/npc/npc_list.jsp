<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/npc/npc_list.js' />"></script>
<html>
    <head>
        <title>NPC列表</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">NPC列表</h2>
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
                <th>關聯事件</th>
                <th>是否啟用</th>
                <th>操作</th>
            </tr>
            <c:forEach var="npc" items="${npcs}">
                <tr>
                    <td>${npc.uid}</td>
                    <td>${npc.name}</td>
                    <td>${npc.race}</td>
                    <td>${npc.profession}</td>
                    <td>${npc.strength}</td>
                    <td>${npc.dexterity}</td>
                    <td>${npc.intelligence}</td>
                    <td>${npc.luck}</td>
                    <td>${npc.health}</td>
                    <td>${npc.relatedEvents}</td>
                    <td>${npc.enabled}</td>
                    <td>
                        <form action="/npc/toEdit" method="POST">
                            <input type="hidden" name="uid" value="<c:out value='${npc.uid}'/>">
                            <button type="submit" class="edit-btn">編輯NPC</button>
                        </form>
                        <form class="action-form">
                            <input type="hidden" name="uid" value="<c:out value='${npc.uid}'/>"/>
                            <button type="button" class="delete-btn">刪除NPC</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- 分頁控制 -->
        <div class="link center">
            <c:if test="${currentPage > 1}">
                <a href="/npc/query?page=${currentPage - 1}">上一頁</a>
            </c:if>
            
            <c:forEach var="i" begin="1" end="${totalPages}">
                <a href="/npc/query?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a>
            </c:forEach>
            
            <c:if test="${currentPage < totalPages}">
                <a href="/npc/query?page=${currentPage + 1}">下一頁</a>
            </c:if>
        </div>
        <h3 class="margin-Btn"></h3>
        <div class="form-center">
            <form action="/npc/new" method="POST" class="center">
                <button type="submit" class="submit-btn">新增NPC</button>
            </form>
            <div class="center-link link">
                <a href="/manage/">返回管理列表</a>
            </div>
        </div>
    </body>
</html>
