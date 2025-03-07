<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/item/item_form.js' />"></script>

<html>
	<head>
	    <title>新增道具</title>
	    <!-- 引入外部 CSS -->
	    <link rel="stylesheet" type="text/css" href="/css/table.css">
	    <link rel="stylesheet" type="text/css" href="/css/form.css">
	    <link rel="stylesheet" type="text/css" href="/css/button.css">
	    <link rel="stylesheet" type="text/css" href="/css/link.css">
	</head>
    <body>
        <h2 class="center">新增道具</h2>
        <form id="itemForm" class="form-center">
            名稱：<input type="text" name="name"/><br/>
            描述：<input type="text" name="description"/><br/>
            類別：<input type="text" name="category"/><br/>
            道具關聯事件：<input type="text" name="relatedActivities"><br/>
            是否啟用：<input type="number" name="enabled"/><br/>
            <h3 class="margin-Btn"></h3>
            <button type="button" id="saveBtn" class="submit-btn">保存</button>
        </form>
        <div class="center-link link">
		    <a href="/item/">返回列表</a>
		</div>
    </body>
</html>
