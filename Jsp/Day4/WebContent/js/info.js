function sendit(){      //한번만 써줘도 가능!

    const userid= document.getElementById('userid');
    const isIdCheck = document.getElementById('isIdCheck');
    const userpw= document.getElementById('userpw');
    const userpw_re = document.getElementById('userpw_re');
    const name = document.getElementById('name');
    const hp = document.getElementById('hp');
    const email = document.getElementById('email');
    const hobby = document.getElementsByName('hobby');
    
    // 정규 표현식
    const expIdText = /^[A-Za-z]{4,20}$/;
    const expPwText =  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}/;
    const expNameText = /[가-힣]+$/;
    const expHpText= /^\d{3}-\d{3,4}-\d{4}$/;
    const expEmailText = /^[A-Za-z0-9\-\.]+@[A-Za-z0-9\-\.]+\.[A-Za-z0-9]+$/;
  
//정규표현식

    if(userpw.value == ''){
        alert('비밀번호를 입력하세요');
        userpw.focus();
        return false;
    }
    if(!expPwText.test(userpw.value)){
        alert('비밀번호 형식을 확인하세요\n소문자,대문자,숫자,특수문자 1개씩 꼭 입력해야합니다.');
        userpw.focus();
        return false;
    }
    

    if(userpw.value != userpw_re.value){
        alert('비밀번호와 형식이 다릅니다.');
    }
//정규표현식
    if(!expNameText.test(name.value)){
        alert('이름은 한글로 입력하세요');
        name.focus();
        return false;
    }
    if(!expHpText.test(hp.value)){
        alert('휴대폰번호 형식을 확인하세요 \n하이픈(-)을 포함해야 합니다');
        hp.focus();
        return false;
    }
    if(!expEmailText.test(email.value)){
        alert('이메일 형식을 확인하세요');
        email.focus();
        return false;
    }
    let count = 0;
    for(let i in hobby){
        if(hobby[i].checked){
            count++;
        }
    }
    if(count == 0){
        alert('취미는 적어도 한개이상 선택하세요');
        return false;
    }



    return true;
}










