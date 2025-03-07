$(function() {
    $("#editBtn").click(edit); // 正確綁定點擊事件
});

function edit() {
    let formData = $("#systemCodeForm").serialize(); // 將表單數據序列化

    $.ajax({
        url: "/systemCode/edit",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("參數保存成功！");
            window.location.href = "/systemCode/"; // 跳轉到參數列表頁
        },
        error: function(error) {
            alert("保存失敗，請重試！");
            console.error(error);
        }
    });
}
