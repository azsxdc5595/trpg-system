let mapData = [];

$(document).ready(function() {
    // 取得 `<input name="startMapTitle">` 的值
    let startMapTitleInput = $("input[name='startMapTitle']").val();
    let startMapTitle = null;

    if (startMapTitleInput) {
        try {
            // **將 JSON 字串轉換為 JavaScript 物件**
            startMapTitle = JSON.parse(startMapTitleInput);
            console.log("解析後的 startMapTitle:", startMapTitle);
        } catch (e) {
            console.error("解析 startMapTitle 失敗:", e);
        }
    }

    if (!startMapTitle) {
        console.error("找不到 startMapTitle");
        return;
    }

    // **地圖大小 11x11**
    const gridSize = 11; 
    const centerX = Math.floor(gridSize / 2); // 計算中心點 X
    const centerY = Math.floor(gridSize / 2); // 計算中心點 Y

    mapData.push({
        x: centerX,  // **確保初始板塊出現在 (5,5)**
        y: centerY,
        name: startMapTitle.name,
        icon: startMapTitle.icon
    });

    console.log("地圖資料:", mapData);

    function renderMap() {
        let gridContainer = $("#mapGrid");
        gridContainer.empty(); // 清空舊內容

        for (let y = 0; y < gridSize; y++) {
            for (let x = 0; x < gridSize; x++) {
                let tileData = mapData.find(t => t.x === x && t.y === y);
                let tileDiv = $("<div>").addClass("tile");

                if (tileData) {
                    let img = $("<img>").attr("src", tileData.icon).attr("alt", tileData.name);
                    tileDiv.append(img);
                }

                gridContainer.append(tileDiv);
            }
        }
    }

    renderMap();
});