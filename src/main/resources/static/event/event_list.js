$(function() {
   $(document).on("click", ".delete-btn", deleteEvent); // 綁定所有刪除按鈕
   console.log('11');
});

function deleteEvent() { // 這裡改名為 deleteEvent
    let formData = $(this).closest("form").serialize();

    $.ajax({
        url: "/event/delete",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("事件刪除成功！");
            window.location.href = "/event/"; // 跳轉到事件列表頁
        },
        error: function(error) {
            alert("刪除失敗，請重試！");
            console.error(error);
        }
    });
}