$(function() {
   $(document).on("click", ".delete-btn", deleteSystemCode); // 綁定所有刪除按鈕
   console.log('11');
});

function deleteSystemCode() { // 這裡改名為 deletesystemCode
    let formData = $(this).closest("form").serialize();

    $.ajax({
        url: "/systemCode/delete",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("參數刪除成功！");
            window.location.href = "/systemCode/"; // 跳轉到參數列表頁
        },
        error: function(error) {
            alert("刪除失敗，請重試！");
            console.error(error);
        }
    });
}