$(function() {
    $("#saveBtn").click(save); // 正確綁定點擊事件
});

function save() {
    let formData = $("#itemForm").serialize(); // 將表單數據序列化

    $.ajax({
        url: "/item/save",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("道具保存成功！");
            window.location.href = "/item/"; // 跳轉到道具列表頁
        },
        error: function(error) {
            alert("保存失敗，請重試！");
            console.error(error);
        }
    });
}