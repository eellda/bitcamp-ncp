// 버튼 클릭 //
const bt = document.getElementById("bt");

bt.addEventListener('click', function () {
    alert('버튼을 눌렀다.');
})

document.getElementById("bt").onclick = function () {
    alert("버튼을 눌렀다고.");
}

// 인풋 //
// var ipprint = document.getElementById('ip').value;
// function enterkey() { 
// 	if (window.event.keyCode == 13) { 
//         console.log(ipprint.value);
//     } 
// }

//입력한 값을 div에 출력
const ip = document.getElementById('ip');

ip.addEventListener('keyup', function printName() {
    const name = document.getElementById('ip').value;
    document.getElementById('ip-result').innerText = name;
})
// function printName() {
//     const name = document.getElementById('ip').value;
//     document.getElementById('ip-result').innerText = name;
// }
// html - onkeyup="printName()"

// document.getElementById('ip').focus();
// let reset = document.getElementById('ip-reset');
// reset.value = null;
// reset.focus;

