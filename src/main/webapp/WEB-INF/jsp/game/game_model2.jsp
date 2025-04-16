<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script nonce="${nonce}" type="text/javascript" src="<c:url value='/game/game_model2.js' />"></script>
<html>
    <head>
        <title>TRPG</title>
        <!-- 引入外部 CSS -->
        <link rel="stylesheet" type="text/css" href="/css/table.css">
        <link rel="stylesheet" type="text/css" href="/css/form.css">
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/link.css">
        <link rel="stylesheet" type="text/css" href="/css/grid2.css">
    </head>
    <body>
        <h2 class="trpg-title">TRPG 板塊地圖</h2>
        <jsp:include page="/WEB-INF/jsp/game/game_label.jsp" />
        <div class="grid-wrapper">
            <div class="grid-container" id="mapGrid">
                <table id="gameMap" >
                  <c:forEach var="row" items="${map}">
                    <tr>
                      <c:forEach var="tile" items="${row}">
                        <td class="tile "
                            data-x="${tile.x}" 
                            data-y="${tile.y}" 
                            data-passable="true">
                        </td>
                      </c:forEach>
                    </tr>
                  </c:forEach>
                </table>
            </div>
            <img id="player" src="\icon\Player Character\A.png" width="27px" hight="40px">
        </div>
    </body>
</html>
