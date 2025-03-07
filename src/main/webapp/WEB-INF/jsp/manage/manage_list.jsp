<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>管理列表</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">管理列表</h2>
        <h3 class="margin-Btn"></h3>
        <div class="form-center">
            <form action="/player/" method="GET" class="center">
                <button type="submit" class="submit-btn">管理角色</button>
            </form>
            <form action="/item/" method="GET" class="center">
                <button type="submit" class="submit-btn">管理道具</button>
            </form>
            <form action="/mapTitle/" method="GET" class="center">
                <button type="submit" class="submit-btn">管理板塊</button>
            </form>
            <form action="/event/" method="GET" class="center">
                <button type="submit" class="submit-btn">管理事件</button>
            </form>
            <form action="/npc/" method="GET" class="center">
                <button type="submit" class="submit-btn">管理NPC</button>
            </form>
        </div>
        <div class="center-link link">
            <a href="/setting/">返回管理列表</a>
        </div>
    </body>
</html>
