$(function() {
    $("#editBtn").click(edit); // 正確綁定點擊事件
});

function edit() {
    let formData = $("#eventForm").serialize(); // 將表單數據序列化

    $.ajax({
        url: "/event/edit",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("事件保存成功！");
            window.location.href = "/event/"; // 跳轉到事件列表頁
        },
        error: function(error) {
            alert("保存失敗，請重試！");
            console.error(error);
        }
    });
}
