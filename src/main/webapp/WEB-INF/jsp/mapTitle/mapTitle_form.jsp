<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/mapTitle/mapTitle_form.js' />"></script>

<html>
    <head>
        <title>新增板塊</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">新增板塊</h2>
        <form id="mapTitleForm" class="form-center">
            板塊名稱:<input type="text" name="name"><br/>
            板塊是否為陷阱：<input type="number" name="trapFlag"><br/>
            板塊方向：<input type="number" name="pattern"><br/>
            是否啟用：<input type="number" name="enabled"/><br/>
            板塊圖示:<input type="text" name="icon"/><br/>
            <h3 class="margin-Btn"></h3>
            <button type="button" id="saveBtn" class="submit-btn">保存</button>
        </form>
        <div class="center-link link">
            <a href="/mapTitle/">返回列表</a>
        </div>
    </body>
</html>
