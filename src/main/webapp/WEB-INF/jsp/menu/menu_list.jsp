<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>TRPG歡迎您</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
    </head>
    <body>
        <h2 class="center">TRPG歡迎您</h2>
        <h3 class="margin-Btn"></h3>
        <div class="form-center">
            <form action="/game/newGame" method="GET" class="center">
                <button type="submit" class="submit-btn">新的遊戲</button>
            </form>
            <form action="/game/newGame2" method="GET" class="center">
                <button type="submit" class="submit-btn">存檔繼承</button>
            </form>
            <form action="/setting/" method="GET" class="center">
                <button type="submit" class="submit-btn">設定</button>
            </form>
        </div>
    </body>
</html>
