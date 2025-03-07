$(function() {
   $(document).on("click", ".delete-btn", deleteMapTitle); // 綁定所有刪除按鈕
   console.log('11');
});

function deleteMapTitle() { // 這裡改名為 deleteMapTitle
    let formData = $(this).closest("form").serialize();

    $.ajax({
        url: "/mapTitle/delete",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("板塊刪除成功！");
            window.location.href = "/mapTitle/"; // 跳轉到板塊列表頁
        },
        error: function(error) {
            alert("刪除失敗，請重試！");
            console.error(error);
        }
    });
}