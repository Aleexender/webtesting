window.onload = function () { // 스레드랑 비슷 뿌릴때까지 기달리기
    const input = document.getElementById("create_id");
    const button = document.getElementById("send_btn");

    button.onclick = function () {
        if (input.value.onload()) {
            alert("중복입니다")
        }
    }
    };


