// 버튼 클릭 //
const bt = document.getElementById("bt");

bt.addEventListener('click', function () {
    alert('버튼을 눌렀다.');
})

document.getElementById("bt").onclick = function () {
    alert("버튼을 눌렀다고.");
}

// 인풋값 //
let value = document.getElementById("ip").value;
document.addEventListener('submit', function ipvalue() {
    alert(ipvalue.value + '라고 적음');
})

