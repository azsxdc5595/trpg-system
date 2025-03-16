$(document).ready(function() {
    // 點擊角色按鈕展開角色屬性區塊
    $(".game-label-Player-toggle").click(function() {
        $(".game-label-Player-content").fadeToggle(200);
        $(".game-label-Item-content").fadeOut(200); // 收合背包區塊
    });

    // 點擊背包按鈕展開持有道具區塊
    $(".game-label-Item-toggle").click(function(e) {
        e.stopPropagation(); // 阻止冒泡到角色按鈕
        $(".game-label-Item-content").fadeToggle(200);
    });

    // 點擊其他地方自動收合全部區塊
    $(document).mouseup(function(e) {
        var container = $(".game-label");
        if (!container.is(e.target) && container.has(e.target).length === 0) {
            $(".game-label-Player-content, .game-label-Item-content").fadeOut(200);
        }
    });
});