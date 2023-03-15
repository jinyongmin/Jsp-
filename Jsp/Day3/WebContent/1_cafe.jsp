<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카페소개</title>
    <link rel="stylesheet" href="./css/cafe.css">
</head>
<body>
    <div id="container">
    <!-- header.jsp 시작 -->
    <%@ include file="./include/header.jsp"%>
    <!-- header.jsp 끝 -->
        <section id="intro">
            <div class="page-title">
                <h2>카페소개</h2>
            </div>
            <div class="content">
                <div class="photo">
                    <img src="./images/coffee.jpg" alt="커피">
                </div>
                <div class="text">
                    <p>영업 시간 : 오전 0시 ~ 밤 10시</p>
                    <p>휴무 : 매주 수요일 <i><small>(수요일이 공휴일인 경우 수요일 영업, 다음날 휴무)</small></i></p>
                </div>
            </div>
        </section>
        <section id="map">
            <div class="page-title">
                <h2>오시는길</h2>
            </div>
            <div class="content">
                <div class="photo">
                    <img src="./images/map.jpg" alt="지도">
                </div>
                <div class="text">
                    <p>서귀포시 안덕면 사계리 000-000</p>
                    <p>제주올레 10 코스 산방산 근처</p>
                </div>
            </div>
        </section>
        <section id="choice">
            <div class="page-title">
                <h2>이달의 추천</h2>
            </div>
            <div class="content">
                <div class="photo">
                    <img src="./images/ice.jpg" alt="추천">
                </div>
                <div class="text">
                    <h2>핸드드립 아이스 커피</h2>
                        <ol>
                            <li>1인분 기준으로 서버에 각 얼음 5조각 (한조각은 20cc) 넣고 추출을 시작한다.</li>
                            <li>평상시 보다 원두의 양은 2배정도 (20g) 와 추출액은 얼으므 포함 해서 200cc 까지 내린다.</li>
                            <li>아이스 잔에 얼음 6~7 개 섞어서 시원하게 마신다.</li>
                        </ol>
                </div>
            </div>
        </section>
  	<!-- footer.jsp 시작 -->
  	<%@ include file = "./inclide/footer.jsp"%>
  	<!-- footer.jsp 끝 -->
    </div>
</body>
</html>