<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
  <script defer src="./js/regist.js"></script><!-- defer 속성? 페이지가 모두 로드된 후 해당 외부 스크립트가 실행됨을 명시 defer속성은 명시하면 true 명시하지 않으면 false regist.js안에는 정규 표현식 조건이 들어있다 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script><!-- 다음 주소URL 예제코드를 복사하여 가져왔다 -->
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
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

    </script>
</head>
<body>
<h2>회원가입</h2><!-- 페이지에 나올 내용 <input>은 받아롤 변수에 맞게 코드 작성해주었다 어디서받아옴? member.ok에서 받아옴! -->
    <form action="./4_member_ok.jsp" name="regform" id="regform" method="post" onsubmit="return sendit()">	<!-- function sendit()은 regist.js에 있음(정규표현식이 sendit()에 묶여있음)
    action="./4_member_ok.jsp  여기에 쓰인 값을 member_ok에서 사용 하게 할 수 있음	--> 																																							
        <p>아이디:<input type="text" name="userid" id="userid" maxlength="20"></p>
        <p>비밀번호:<input type="password" name="userpw" id="userpw" maxlength="20"></p>
        <p>비밀번호 확인:<input type="password" name="userpw_re" id="userpw_re" maxlength="20"></p>
        <p>이름:<input type="text" name="name" id="name"></p>
        <p>휴대폰번호: <input type="text" name="hp" id="hp"></p>
        <p>이메일: <input type="text" name="email" id="email"></p>
        <p>성별: <label>남자 <input type="radio" name="gender" value="남자" checked></label>
        <label>여자 <input type="radio" name="gender" value="여자"></label></p>	<!-- label: 간격을 좀 벌려줌? -->
        <p>
            (하나만 선택안하면 추가요금 10000원!)<br>
            취미: <label>등산<input type="checkbox" name="hobby" value="등산"></label>
            <label>게임<input type="checkbox" name="hobby" value="게임"></label>
            <label>영화감상<input type="checkbox" name="hobby" value="영화감상"></label>
            <label>드라이브<input type="checkbox" name="hobby" value="드라이브"></label>
            <label>운동<input type="checkbox" name="hobby" value="운동"></label>
        </p>
      
            <p>우편번호: <input type="text" name="zipcode" maxlength="5" id="sample6_postcode">
            <button type="button" onclick="sample6_execDaumPostcode()">검색</button></p>	<!-- 클릭버튼 누르면function sample6_execDaumPostcode() 위에 주소검색 가능 -->
            
            <p>주소: <input type="text" name="address1" id="sample6_address"></p>
            
            <p>상세주소: <input type="text" name="address2" id="sample6_detailAddress"></p>
            
            <p>참고항목: <input type="text" name="address3" ></p>
        <p><button>!!가입완료!!</button><input type="reset" name="join" id="sample6_extraAddress"></p>  
        
    </form>
</body>
</html>
<!-- 홈페이지에서 연결이 안되는 이유? -->