$(function() {
	$("#roundCount").text($("input[name='roundCountInput']").val()); // 預設回合數
	$("#gameHint").text($("input[name='gameHintInput']").val()); // 預設提示語
	// 初次綁定事件
	$("#drawTileButton").off("click").on("click", draw);
});

function draw() {
    $.ajax({
        type: "POST",
        url: "/game/drawTile",
        dataType: "json",
        success: function (data) {
            console.log("後端回傳:", data);
			// 更新提示語邏輯未寫
			$("#gameHint").text("請放置板塊!");
			$("#drawTileButton").hide();  // 隱藏按鈕
            if (data.icon) {
                let imgContainer = $(".tile-preview");
                imgContainer.empty(); //
                let img = $("<img>").attr("src", data.icon).attr("alt", data.id).addClass("newMapTitle");
                imgContainer.append(img);
				$(".grid-wrapper .tile.noTemp").off("click").on("click", function () {
					let x = $(this).attr("data-x"); // 正確讀取 x 座標
					let y = $(this).attr("data-y"); // 正確讀取 y 座標
					let z = $(this).attr("data-z"); // 正確讀取 z 座標
				    check(data.icon, data.id, x, y, z);
				});
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

function check(icon, id, x, y, z) {
	console.log(`檢查板塊: ID=${id}, Icon=${icon}, x=${x}, y=${y}, z=${z}`);
	$("input[name='id']").val(id);
	$("input[name='icon']").val(icon);
	$("input[name='x']").val(x);
	$("input[name='y']").val(y);
	$("input[name='floor']").val(z);
	let formData = $("#checkForm").serialize(); // 將表單數據序列化
	$.ajax({
	    type: "POST",
	    url: "/game/check",
	    data: formData,
	    success: function (data) {
	        if (data === "") {
	            // 跳出確認框
	            if (confirm("確認放置此板塊？")) {
	                // 使用 AJAX 再次發送請求，將數據存入資料庫
	                $.ajax({
	                    type: "POST",
	                    url: "/game/confirm", 
	                    data: formData,
	                    success: function (saveResponse) {
	                        alert(saveResponse);
	                        query();
							$("#gameHint").text("");
							$(".newMapTitle").remove();
							$("#drawTileButton").show();  // 顯示按鈕
							$("#drawTileButton").text("結束這回合").prop("disabled", false);
							$("#drawTileButton").off("click").on("click", function () {
								// 更新回合數
								let currentRound = parseInt($("input[name='roundCountInput']").val(), 10);
								let newRound = currentRound + 1;
								$("#roundCount").text(newRound);
								$("input[name='roundCountInput']").val(newRound);
								$("#roundCount").text(newRound);
								$("#drawTileButton").text("抽").prop("disabled", false);
								// **重新綁定 draw 事件**
								$("#drawTileButton").off("click").on("click", draw);
							});
	                    },
	                    error: function (xhr, status, error) {
	                        console.error("存入失敗:", xhr.status, error);
	                        alert("存入失敗，請稍後再試！狀態碼：" + xhr.status);
	                    }
	                });
	            }
	        } else {
	            console.error("後端返回錯誤:", data);
	            alert("無法放置該板塊：" + data);
	        }
	    },
	    error: function (xhr, status, error) {
	        console.error("AJAX 失敗:", xhr.status, error);
	        alert("失敗，請稍後再試！狀態碼：" + xhr.status);
	    }
	});
}