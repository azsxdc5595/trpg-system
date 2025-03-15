$(function() {
	$("#roundCount").text($("input[name='roundCountInput']").val()); // 預設回合數
	$("#gameHint").text($("input[name='gameHintInput']").val()); // 預設提示語
    $("#drawTileButton").click(draw);
});

function draw() {
    $.ajax({
        type: "POST",
        url: "/game/drawTile",
        dataType: "json",
        success: function (data) {
            console.log("後端回傳:", data);
			
			// 更新回合數
			let currentRound = parseInt($("input[name='roundCountInput']").val(), 10);
			let newRound = currentRound + 1;
			$("#roundCount").text(newRound);
			$("input[name='roundCountInput']").val(newRound);
			$("#roundCount").text(newRound);
			
			// 更新提示語邏輯未寫
			//somethingCode
			
            if (data.icon) {
                let imgContainer = $(".tile-preview");
                imgContainer.empty(); //
                let img = $("<img>").attr("src", data.icon).attr("alt", data.name);
                imgContainer.append(img);
            } else {
                console.error("沒有收到 icon，請檢查後端回傳的 JSON 格式");
            }
        },
        error: function (xhr, status, error) {
            console.error("AJAX 失敗:", xhr.status, error);
            alert("抽板塊失敗，請稍後再試！狀態碼：" + xhr.status);
        }
    });
}