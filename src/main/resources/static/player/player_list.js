$(function() {
   $(document).on("click", ".delete-btn", deletePlayer); // 綁定所有刪除按鈕
   console.log('11');
});

function deletePlayer() { // 這裡改名為 deletePlayer
    let formData = $(this).closest("form").serialize();

    $.ajax({
        url: "/player/delete",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("角色刪除成功！");
            window.location.href = "/player/"; // 跳轉到角色列表頁
        },
        error: function(error) {
            alert("刪除失敗，請重試！");
            console.error(error);
        }
    });
}