let mapData = [];
const gridSize = 11; 
const centerX = Math.floor(gridSize / 2); // 計算中心點 X
const centerY = Math.floor(gridSize / 2); // 計算中心點 Y
let snowNo = $("input[name='snowNo']").val();
$(function() {
	query();
});

function query () {
	let formData = $("#queryForm").serialize(); // 將表單數據序列化
	$.ajax({
	    url: "/game/query",
	    type: "POST",
		data: formData,
	    success: function(data) {
			console.log(data);
	        if (data && data.tempGameMapTitle) {
	            data.tempGameMapTitle.forEach(tile => {
	                mapData.push({
	                    x: tile.x + centerX, // **偏移中心**
	                    y: tile.y + centerY,
	                    relatedEvents: tile.relatedEvents,
	                    icon: tile.icon
	                });
	            });
	            renderMap();
	        } else {
	            console.warn("後端返回的地圖數據為空");
	        }
	    },
	    error: function(err) {
	        console.error("獲取地圖數據失敗:", err);
	    }
	});
}

function renderMap() {
    let gridContainer = $("#mapGrid");
    gridContainer.empty(); // 清空舊內容

    for (let y = 0; y < gridSize; y++) {
        for (let x = 0; x < gridSize; x++) {
            let tileData = mapData.find(t => t.x === x && t.y === y);
			// 使用 attr 存儲 x, y
			let dbX = parseInt(x) - 5;
			let dbY = parseInt(y) - 5;
            let tileDiv = $("<div>").addClass("tile")
						.attr("data-x", dbX) 
						.attr("data-y", dbY)
						.attr("data-z", 1); 

            if (tileData) {
                let img = $("<img>").attr("src", tileData.icon).attr("alt", tileData.relatedEvents);
                tileDiv.append(img);
				tileDiv.addClass("temp");
            } else {
				tileDiv.addClass("noTemp");
			}

            gridContainer.append(tileDiv);
        }
    }
}