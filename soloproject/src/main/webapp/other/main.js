window.onload = function () {
  const signUpBtn = document.getElementById("signUp");
  const signInBtn = document.getElementById("signIn");
  const container = document.querySelector(".container");
}

//에러메세지
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

//로그인
var loginAttempts = 3;

function loginCheck() {

  var id = document.getElementById('user_id').value;
  var password = document.getElementById('password').value;
  var logErrMsg = document.getElementById('logErrMsg');
  
  if(id.trim() === '' && password.trim() != ''){
	  logErrMsg.innerText = '아이디를 입력해주세요';
      logErrMsg.style.display = 'block';
  }else if(id.trim() != '' && password.trim() === ''){
	  logErrMsg.innerText = '비밀번호를 입력해주세요';
      logErrMsg.style.display = 'block';
  }else if(id.trim() === '' || password.trim() === ''){
	  logErrMsg.innerText = '아이디와 비밀번호를 입력해주세요';
      logErrMsg.style.display = 'block';
  }else if (id.trim() != '' || password.trim() != '') {
    var xml = new XMLHttpRequest();
    var data = "user_id=" + encodeURIComponent(id) + "&password=" + encodeURIComponent(password);
    xml.open("POST", "login.do?" + data, true);
    xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xml.onreadystatechange = function () {
      if (xml.readyState == 4 && xml.status == 200) {
        var response = xml.responseText;
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
    xml.send();
  } else {
    logErrMsg.style.display = 'none';
  }
}


//회원가입
function sign() {
            var userId = document.getElementById("userid").value;
            var password = document.getElementById("password").value;
            var name = document.getElementById("name").value;
            var signErrMsg = document.getElementById("signErrMsg");
            
            var xml = new XMLHttpRequest();
            xml.open("POST", "/soloproject/jsp/sign.do", true);
            xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xml.onreadystatechange = function() {
                if (xml.readyState === XMLHttpRequest.DONE) {
                    if (xml.status === 200) {
                        var response = xml.responseText;
                        if (response === "success") {
                            alert("회원가입이 완료되었습니다.");
                            window.location.href = "/soloproject/jsp/login.do";
                        } else {
                            signErrMsg.innerText = "이미 존재하는 사용자입니다. 다른 아이디를 입력하세요.";
                            signErrMsg.style.display= 'block';
                        }
                    } else {
                        console.error(xml.status);
                    }
                }
            };
            xml.send("userid=" + encodeURIComponent(userId) + "&password=" + encodeURIComponent(password) + "&name=" + encodeURIComponent(name));
        }

function statErrMsg() {
  var device_id = document.getElementById('device_id').value;
  var status = document.getElementById('status').value;
  var statErrMsg = document.getElementById('statErrMsg');

  if (device_id.trim() === '' || status.trim() === '') {
    statErrMsg.innerText = '기기명과 상태값을 모두 입력해주세요';
    statErrMsg.style.display = 'block';
  } else if (status.trim() !== 'On' && status.trim() !== 'Off') {
    statErrMsg.innerText = '올바른 상태값을 입력하세요 (On 또는 Off)';
    statErrMsg.style.display = 'block';
  } else {
    var xml = new XMLHttpRequest();
    var url = "/soloproject/jsp/status.do";
    var params = "device_id=" + device_id + "&status=" + status;
    xml.open("POST", url, true);
    xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    console.log(xml.status)
    xml.onreadystatechange = function () {
      if (xml.readyState == 4 && xml.status == 200) {
        if (xml.responseText.trim() === 'true') {
          statErrMsg.style.display = 'none';
          alert('변경성공');
        } else {
          statErrMsg.innerText = '입력된 기기명이 존재하지 않습니다';
          statErrMsg.style.display = 'block';
        }
      }
    }
    xml.send(params);
  }
}

//예약
function reserve() {
            var deviceId = document.getElementById("deviceId").value;
            var startTime = document.getElementById("startTime").value;
            var endTime = document.getElementById("endTime").value;

            var xml = new XMLHttpRequest();
            xml.onreadystatechange = function() {
                if (xml.readyState == 4 && xml.status == 200) {
                    alert(xml.responseText);
                }
            };
            xml.open("POST", "/soloproject/jsp/res.do", true);
            xml.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xml.send("device_id=" + deviceId + "&start_time=" + startTime + "&end_time=" + endTime);
        }

//예약삭제
function cancelReservation() {
    var resid = document.getElementById('residInput').value;
    if (resid.trim() === "") {
        alert("예약번호를 입력하세요.");
        return;
    }
    var xml = new XMLHttpRequest();
    xml.onreadystatechange = function() {
        if (xml.readyState === XMLHttpRequest.DONE) {
            if (xml.status === 200) {
                alert(xml.responseText);
            } else {
                alert("예약 취소 중 오류가 발생했습니다.");
            }
        }
    };
    xml.open("GET", "/soloproject/jsp/resCancel.do?resid=" + resid, true);
    xml.send();
}


