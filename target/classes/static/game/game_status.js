$(document).ready(function () {
    $("#drawTileButton").click(function () {
        $.ajax({
            type: "POST",
            url: "/game/drawTile",
            success: function (data) {
                $("#roundCount").text(data.roundCount); // 更新回合數
                $("#gameHint").text(data.gameHint); // 更新提示語
                
                if (data.drawnTileIcon) {
                    $("#drawnTileImage").attr("src", data.drawnTileIcon).show();
                }
            },
            error: function () {
                alert("抽板塊失敗，請稍後再試！");
            }
        });
    });
});