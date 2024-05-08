window.onload=function(){
const signUpBtn = document.getElementById("signUp");
const signInBtn = document.getElementById("signIn");
const container = document.querySelector(".container");
	}


function errMsg() {
  var device = document.getElementById('device').value;
  var status = document.getElementById('status').value;
  var errMsg = document.getElementById('errMsg');

  if (device.trim() === '' && status.trim() === '') {
    errMsg.innerText = '기기명과 상태값을 모두 입력해주세요';
    errMsg.style.display = 'block';
  } else if (device.trim() === '') {
    errMsg.innerText = '기기명을 입력해주세요';
    errMsg.style.display = 'block';
  } else if (status.trim() === '') {
    errMsg.innerText = '상태값을 입력해주세요';
    errMsg.style.display = 'block';
  } else {
    errMsg.style.display = 'none';
    alert('상태값이 성공적으로 변경되었습니다');
  }
}

var loginAttempts = 3;
	 
function loginCheck() {
	
    var id = document.getElementById('user_id').value;
    var password = document.getElementById('password').value;
    var logErrMsg = document.getElementById('logErrMsg');

    if (id.trim() != '' || password.trim() != '') {
        var xhr = new XMLHttpRequest();
        var data = "user_id=" + encodeURIComponent(id) + "&password=" + encodeURIComponent(password);
        xhr.open("POST", "login.do?"+data, true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            // 서블릿으로부터 응답을 받았을 때
            if (xhr.readyState == 4 && xhr.status == 200) {
                // 응답 내용 가져오기
                var response = xhr.responseText;
                alert(response);
                if (response === "success") {
                    window.location.href = "main.do";
                } else {
                    loginAttempts--;
                    logErrMsg.innerText = '아이디 또는 비밀번호가 틀렸습니다. 남은 로그인 시도 횟수: ' + loginAttempts;
                    logErrMsg.style.display = 'block';
                    if (loginAttempts === 0) {
                        logErrMsg.innerText = '로그인 시도 횟수를 모두 소진했습니다.';
                        document.querySelector('#user_id').disabled = true;
                        document.querySelector('#password').disabled = true;
                    }
                }
            }
        };
        
        xhr.send();
    } else {
        logErrMsg.style.display = 'none';
    }
}

