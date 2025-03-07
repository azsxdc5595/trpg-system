<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/event/event_list.js' />"></script>
<html>
    <head>
        <title>事件列表</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">事件列表</h2>
        <table class="center-table">
            <tr>
                <th>UID</th>
                <th>事件名稱</th>
                <th>事件描述</th>
                <th>事件類別</th>
                <th>事件主題分組</th>
                <th>事件等級</th>
                <th>是否啟用</th>
                <th>操作</th>
            </tr>
            <c:forEach var="event" items="${events}">
                <tr>
                    <td>${event.uid}</td>
                    <td>${event.name}</td>
                    <td>${event.description}</td>
                    <td>${event.category}</td>
                    <td>${event.eventGroup}</td>
                    <td>${event.level}</td>
                    <td>${event.enabled}</td>
                    <td>
                        <form action="/event/toEdit" method="POST">
                            <input type="hidden" name="uid" value="<c:out value='${event.uid}'/>">
                            <button type="submit" class="edit-btn">編輯事件</button>
                        </form>
                        <form class="action-form">
                            <input type="hidden" name="uid" value="<c:out value='${event.uid}'/>"/>
                            <button type="button" class="delete-btn">刪除事件</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- 分頁控制 -->
        <div class="link center">
            <c:if test="${currentPage > 1}">
                <a href="/event/query?page=${currentPage - 1}">上一頁</a>
            </c:if>
            
            <c:forEach var="i" begin="1" end="${totalPages}">
                <a href="/event/query?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a>
            </c:forEach>
            
            <c:if test="${currentPage < totalPages}">
                <a href="/event/query?page=${currentPage + 1}">下一頁</a>
            </c:if>
        </div>
        <h3 class="margin-Btn"></h3>
        <div class="form-center">
            <form action="/event/new" method="POST" class="center">
                <button type="submit" class="submit-btn">新增事件</button>
            </form>
            <div class="center-link link">
                <a href="/manage/">返回管理列表</a>
            </div>
        </div>
    </body>
</html>
