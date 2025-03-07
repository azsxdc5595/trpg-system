<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>設定管理</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">設定管理</h2>
        <h3 class="margin-Btn"></h3>
        <div class="form-center">
            <form action="/systemCode/" method="GET" class="center">
                <button type="submit" class="submit-btn">系統參數設定</button>
            </form>
            <form action="/manage/" method="GET" class="center">
                <button type="submit" class="submit-btn">管理系統</button>
            </form>
        </div>
        <div class="center-link link">
            <a href="/">返回管理列表</a>
        </div>
    </body>
</html>
