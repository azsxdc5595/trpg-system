<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/mapTitle/mapTitle_list.js' />"></script>
<html>
    <head>
        <title>板塊列表</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">板塊列表</h2>
        <table class="center-table">
            <tr>
                <th>ID</th>
                <th>板塊是否為陷阱</th>
                <th>板塊樓層</th>
                <th>板塊方向</th>
                <th>板塊關聯事件</th>
                <th>是否啟用</th>
                <th>操作</th>
            </tr>
            <c:forEach var="mapTitle" items="${mapTitles}">
                <tr>
                    <td>${mapTitle.id}</td>
                    <td>${mapTitle.trapFlag}</td>
                    <td>${mapTitle.floor}</td>
                    <td>${mapTitle.pattern}</td>
                    <td>${mapTitle.relatedEvents}</td>
                    <td>${mapTitle.enabled}</td>
                    <td>
                        <form action="/mapTitle/toEdit" method="POST">
                            <input type="hidden" name="id" value="<c:out value='${mapTitle.id}'/>">
                            <button type="submit" class="edit-btn">編輯板塊</button>
                        </form>
                        <form class="action-form">
                            <input type="hidden" name="id" value="<c:out value='${mapTitle.id}'/>"/>
                            <button type="button" class="delete-btn">刪除板塊</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- 分頁控制 -->
        <div class="link center">
            <c:if test="${currentPage > 1}">
                <a href="/mapTitle/query?page=${currentPage - 1}">上一頁</a>
            </c:if>
            
            <c:forEach var="i" begin="1" end="${totalPages}">
                <a href="/mapTitle/query?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a>
            </c:forEach>
            
            <c:if test="${currentPage < totalPages}">
                <a href="/mapTitle/query?page=${currentPage + 1}">下一頁</a>
            </c:if>
        </div>
        <h3 class="margin-Btn"></h3>
        <div class="form-center">
            <form action="/mapTitle/new" method="POST" class="center">
                <button type="submit" class="submit-btn">新增板塊</button>
            </form>
            <div class="center-link link">
                <a href="/manage/">返回管理列表</a>
            </div>
        </div>
    </body>
</html>
