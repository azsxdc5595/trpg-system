<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/systemCode/systemCode_edit.js' />"></script>

<html>
    <head>
        <title>編輯參數</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">編輯參數</h2>
        <form id="systemCodeForm" class="form-center">
        	<input type="hidden" name="id" value="<c:out value='${systemCode.id}'/>">
            名稱：<input type="text" name="name" value="<c:out value='${systemCode.cname}'/>"/><br/>
            是否啟用：<input type="number" name="enabled" value="<c:out value='${systemCode.enabled}'/>"/><br/>
            <h3 class="margin-Btn"></h3>
            <button type="button" id="editBtn" class="submit-btn">保存</button>
        </form>
        <div class="center-link link">
            <a href="/systemCode/">返回列表</a>
        </div>
    </body>
</html>
