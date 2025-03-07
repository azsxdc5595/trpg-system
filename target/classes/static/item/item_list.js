$(function() {
   $(document).on("click", ".delete-btn", deleteItem); // 綁定所有刪除按鈕
   console.log('11');
});

function deleteItem() { // 這裡改名為 deleteItem
    let formData = $(this).closest("form").serialize();

    $.ajax({
        url: "/item/delete",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("道具刪除成功！");
            window.location.href = "/item/"; // 跳轉到道具列表頁
        },
        error: function(error) {
            alert("刪除失敗，請重試！");
            console.error(error);
        }
    });
}