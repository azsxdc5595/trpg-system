$(function() {
  $(".tile").each(function () {
    let x = parseInt($(this).attr("data-x"));
    let y = parseInt($(this).attr("data-y"));
    let offsetX = -x * 48;
    let offsetY = -y * 48;
    $(this).css("background-position", `${offsetX}px ${offsetY}px`);
    let playerX = 5;
    let playerY = 5;

    $(document).keydown(function (e) {
      if (e.key === "w") playerY--;
      else if (e.key === "s") playerY++;
      else if (e.key === "a") playerX--;
      else if (e.key === "d") playerX++;

      // 防止超出地圖邊界
      playerX = Math.max(0, Math.min(16, playerX));
      playerY = Math.max(0, Math.min(12, playerY));

      moveTo(playerX, playerY);
    });

  });

  // 玩家角色初始放置
  moveTo(5, 5);
});

function moveTo(x, y) {
  let tile = $(`.tile[data-x=${x}][data-y=${y}]`);
  $("#player").appendTo(tile);
}
