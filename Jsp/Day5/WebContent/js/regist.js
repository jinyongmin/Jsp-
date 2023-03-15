function sendit() {
	const userid = document.getElementById('userid');
	const isIdCheck = document.getElementById('isIdCheck');
	const userpw = document.getElementById('userpw');
	const userpw_re = document.getElementById('userpw_re')
	const name = document.getElementById('name');
	const hp = document.getElementById('hp');
	const email = document.getElementById('email');
	const hobby = document.getElementsByName('hobby');
	// 정규 표현식
	const expIdText = /^[A-Za-z]{4,20}$/;
	const expPwText = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
	const expNameText = /^[가-힣]+$/;
	const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;
	const expEmailText = /^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/;
	if (userid.value == '') {
		alert('아이디를 입력하세요');
		userid.focus();
		return false;
	}
	if (!expIdText.test(userid.value)) {
		alert('아이디는 4자 이상 20자 이하의 대소문자로 시작하는 조합입니다');
		userid.focus();
		return false;
	}
	if(isIdCheck.value == 'n'){
		alert('아이디를 중복체크 버튼을 눌러주세요');
		return false;
	}
	
	if (userpw.value == '') {
		alert('비밀번호를 입력하세요');
		userpw.focus();
		return false;
	}
	if (!expPwText.test(userpw.value)) {
		alert('비밀번호 형식을 확인하세요\n소문자,대문자,숫자,특수문자 1개씩 꼭 입력해야합니다');
		userpw.focus();
		return false;
	}
	if (userpw.value != userpw_re.value) {
		alert('비밀번호와 비밀번호 확인의 값이 다릅니다');
		userpw_re.focus;
		return false;
	}
	if (!expNameText.test(name.value)) {
		alert('이름은 한글로 입력하세요');
		name.focus();
		return false;
	}
	if (!expHpText.test(hp.value)) {
		alert('휴대폰번호 형식을 확인하세요\n하이픈(-)을 포함해야 합니다');
		hp.focus();
		return false;
	}
	if (!expEmailText.test(email.value)) {
		alert('틀림');
		email.focus();
		return false;
	}
	let count = 0;
	for ( let i in hobby) {
		if (hobby[i].checked) {
			count++;
		}
	}
	if (count == 0) {
		alert('취미는 적어도 한개이상 선택하세요');
		return false;
	}
	return true;
}

function clickBtn() {
	const isIdCheck = document.getElementById('isIdCheck');
	
	const xhr = new XMLHttpRequest();
	const userid = document.getElementById('userid').value;
	xhr.open('get', 'idcheck.jsp?userid=' + userid, true);
	xhr.send();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
			const result = xhr.responseText;
			if (result.trim() == "ok") {
				document.getElementById('checkmsg').innerHTML = "<b style = 'color :deepskyblue; font-size : 30px;'>사용할 수 있는 아이디</b>";
				isIdCheck.value ='y';
			} else {
				document.getElementById('checkmsg').innerHTML = "<b style = 'color :red; font-size : 30px;'>사용할 수 없는 아이디</b>";
			}
		}
	}

}

function idModify() {
	const isIdCheck = document.getElementById('isIdCheck');
	isIdCheck.value ='n';
	document.getElementById('checkmsg').innerHTML ="";
}

function sample6_execDaumPostcode() {
	new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수
					// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을
															// 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}
					// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					if (data.userSelectedType === 'R') {
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraAddr += (extraAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraAddr !== '') {
							extraAddr = ' (' + extraAddr + ')';
						}
						// 조합된 참고항목을 해당 필드에 넣는다.
						document.getElementById("sample6_extraAddress").value = extraAddr;
					} else {
						document.getElementById("sample6_extraAddress").value = '';
					}
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample6_postcode').value = data.zonecode;
					document.getElementById("sample6_address").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("sample6_detailAddress").focus();
				}
			}).open();
}
