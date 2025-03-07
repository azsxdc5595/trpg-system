$(function() {
    $("#saveBtn").click(save); // 正確綁定點擊事件
});

function save() {
    let formData = $("#playerForm").serialize(); // 將表單數據序列化

    $.ajax({
        url: "/player/save",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("角色保存成功！");
            window.location.href = "/player/"; // 跳轉到角色列表頁
        },
        error: function(error) {
            alert("保存失敗，請重試！");
            console.error(error);
        }
    });
}