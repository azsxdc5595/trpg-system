$(function() {
    $("#saveBtn").click(save); // 正確綁定點擊事件
});

function save() {
    let formData = $("#npcForm").serialize(); // 將表單數據序列化

    $.ajax({
        url: "/npc/save",
        type: "POST",
        data: formData, // x-www-form-urlencoded 格式
        success: function(response) {
            alert("NPC保存成功！");
            window.location.href = "/npc/"; // 跳轉到NPC列表頁
        },
        error: function(error) {
            alert("保存失敗，請重試！");
            console.error(error);
        }
    });
}