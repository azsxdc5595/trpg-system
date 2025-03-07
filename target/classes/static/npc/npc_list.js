$(function() {
   $(document).on("click", ".delete-btn", deletenpc); // 綁定所有刪除按鈕
   console.log('11');
});

function deletenpc() { // 這裡改名為 deletenpc
    let formData = $(this).closest("form").serialize();

    $.ajax({
        url: "/npc/delete",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("NPC刪除成功！");
            window.location.href = "/npc/"; // 跳轉到NPC列表頁
        },
        error: function(error) {
            alert("刪除失敗，請重試！");
            console.error(error);
        }
    });
}