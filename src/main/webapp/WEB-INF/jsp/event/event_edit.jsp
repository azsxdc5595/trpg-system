<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/event/event_edit.js' />"></script>

<html>
    <head>
        <title>編輯事件</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">編輯事件</h2>
        <form id="eventForm" class="form-center">
            <input type="hidden" name="uid" value="<c:out value='${event.uid}'/>">
            事件名稱：<input type="text" name="name" value="<c:out value='${event.name}'/>"><br/>
            事件描述：<input type="text" name="description" value="<c:out value='${event.description}'/>"><br/>
            事件類別：<input type="text" name="category" value="<c:out value='${event.category}'/>"><br/>
            事件主題分組：<input type="number" name="eventGroup" value="<c:out value='${event.eventGroup}'/>"><br/>
            事件等級：<input type="number" name="level" value="<c:out value='${event.level}'/>"><br/>
            是否啟用：<input type="number" name="enabled" value="<c:out value='${event.enabled}'/>"><br/>
            <h3 class="margin-Btn"></h3>
            <button type="button" id="editBtn" class="submit-btn">保存</button>
        </form>
        <div class="center-link link">
            <a href="/event/">返回列表</a>
        </div>
    </body>
</html>
