# 📖 SSACCER - SSAFY 9기 1학기 최종 관통 프로젝트

</br>

## 📌 주제

</br>

### ✅ 영상 플랫폼, 각종 운동 API와 데이터를 활용한 종합 풋살/축구 서비스
 
 
</br>
 

- 영상 플랫폼 API를 활용한 풋살 / 축구 영상 제공

- 같이 풋살을 할 팀원을 모집하는 게시판 / 팀원 관리

- 해외 축구 기록 API를 활용한 해외 축구 기록 및 소식 제공

- 날씨 API를 활용하여 전국 풋살장의 날씨 예보 제공

</br></br>

<hr>

</br></br>

## 📌 개요

</br>

### ✅ 수상 내역

</br>

- SSAFY 9기 1학기 프로젝트 우수상

</br></br>

<hr>

</br></br>



### ✅ 프로젝트 진행 기간

</br>

- 2023.05.18(목) ~ 2023.05.26(금) 
	
    - 9일간 진행

</br></br>

<hr>

</br></br>

### ✅ 프로젝트 팀

- 박세윤 / 김현중 (2인)

- 기능 별 역할 분담

</br></br>

<hr>

</br></br>

### ✅ 기술 스택

</br>

#### DataBase

- MySQL

</br>

#### BackEnd

- Java 11
	
    - 최초 8버전을 사용했으나, Football-Data.org 라이브러리를 활용하기 위해 11버전으로 업그레이드

- SpringBoot 2.7.11

- MyBatis

- IDE : IntelliJ

- Build Tool : MVN

- Dependencies
	
    - Spring Web
    - Spring Boot Dev Tools
    - Spring Configuration Processor
    - MyBatis FrameWork
    - MySQL Driver
    - Lombok

</br>

#### FrontEnd

- Vue 2
	
    - router
    - axios
    - vuex

- css
	
    - bootstrap 5

- emailjs
	
    - 사용자가 관리자에게 문의 이메일을 남기게 해주는 라이브러리
    
- sweetalert
	
    - alert를 아름답게 만들어주는 라이브러리

- 눈누
	
    - 외부 font 사이트

</br>

#### API

- Youtube API
	
    - https://developers.google.com/youtube/v3/getting-started?hl=ko

- Google Maps API
	
    - https://developers.google.com/maps/gmp-get-started?hl=ko
    
- 기상청 단기예보 API / 중기예보 API
	
    - https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15084084
    - https://www.data.go.kr/data/15059468/openapi.do
    
- Football-Data.org API
	
    - https://www.football-data.org/

</br>

#### Data

- 전국 풋살장(축구장) 좌표 데이터

- 전국 축구장 위도 경도 데이터

- 전국 x,y 좌표 (기상청 제공)

</br>

#### Version Control

- github

</br>

#### CoOperation Tool

- Notion

- Discord

</br></br>

<hr>

</br></br>


### ✅ ERD

![](https://velog.velcdn.com/images/yun12343/post/3279feb2-d741-48ac-a777-e5eeee19f13c/image.png)

- 대부분 users 테이블을 필두로 외래키 연결이 되어있다.

- soccerfields, xypoints, regioncodes, bigregioncodes는 외부 엑셀 데이터를 테이블의 형태에 맞게 변형한 후 csv로 변환하여 db에 삽입하였다.
	
    - soccerxy 테이블은 xoccerfields와 xypoints의 join으로 생성했다.

</br></br>

<hr>

</br></br>

## 📌 기능

</br>

### ✅ 메인 페이지

![](https://velog.velcdn.com/images/yun12343/post/94635144-5d4e-478c-a609-3d9ea0654834/image.png)

- 상단 NavBar, 중앙 사진이 위치한 Carousel, 하단 ContentsBar 모두에서 주요 페이지 이동 가능

- NavBar를 통해 Login / SignUp 가능

</br></br>

<hr>

</br></br>

### ✅ 회원가입

![](https://velog.velcdn.com/images/yun12343/post/45dac9c5-39fc-49bf-bba9-c2fe9b72cf29/image.png)

- ID / PW 및 각종 정보를 입력하여 회원 가입 가능

</br></br>

<hr>

</br></br>

### ✅ 로그인 / 로그아웃

![](https://velog.velcdn.com/images/yun12343/post/9a2e91d3-43f8-49b3-afc1-cf30dbf390c1/image.png)

- 로그인 시 jwt(json-web-token) 기술을 활용한 유효성 검사 진행
	
    - jwt 유효성 검사에서 실패할 경우, 컨텐츠 사용 불가능 (에러)

</br></br>

<hr>

</br></br>

![](https://velog.velcdn.com/images/yun12343/post/9d4771ce-004d-4011-9c5f-5f77853bcd48/image.png)

- 잘못된 로그인 시 에러 표시 (sweetalert)

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/8fe0a1ab-43d3-48a7-9fed-2f68999759a4/image.png)

- 로그인 이후 NavBar의 변화

</br>

<hr>

</br>

### ✅ 풋살 팀원 모집

![](https://velog.velcdn.com/images/yun12343/post/65ddf9fb-6541-4a20-9d06-ca93bb182c1b/image.png)

- 글 등록 시 설정한 모집 인원에 따라 이미 모집이 완료된 글은 마감 표시

- 모집 글의 제목, 글 작성자, 풋살 장소, 수준, 성별, 풋살 시작시간, 조회수 표시

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/9771852b-20bf-4d16-a83c-c90d64b97800/image.png)


![](https://velog.velcdn.com/images/yun12343/post/dda1c274-99f6-4beb-b820-04ffc31473e9/image.png)

- 풋살장 장소 선택 후 위치 보기 버튼 클릭 시, 상단 구글 맵에서 대략적인 풋살장의 위치 표시

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/22c6d6f8-fa21-4a71-8754-cfe3ee2f9d17/image.png)

- 모집 글 등록 후 변화

</br>

<hr>

</br>


![](https://velog.velcdn.com/images/yun12343/post/67412ea2-2022-486a-bb01-d5999fc5e6ce/image.png)

- 모집 게시글 상세 페이지 상단 부분

- Google Map API로 모집 글의 풋살장 위치 지도 제공

- 팀 테이블에서는 매칭된 팀원 정보를 확인할 수 있다.
	
    - 이 팀에 합류한 회원들만 해당 테이블을 확인할 수 있다.
    - 이 팀에 합류하지 않은 다른 회원들은 이 테이블을 볼 수 없다.
    - 테이블에는 합류한 회원 번호(순서), 회원의 랭크(신뢰도 확인), 이름, 전화번호, 포지션, 실력, 성별을 확인할 수 있다.

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/c8fdd76a-a365-4d38-8e0b-22ce4cadee51/image.png)

- 모집 글 등록 시 설정한 것들이 사진으로 보여진다. (풋살 장비 대여 여부, 샤워 가능 여부, 주차 가능 여부, 음료 반입 가능 여부)

- 풋살 수행 시간, 풋살장 위치, 인당 비용, 상태(모집/마감), 실력, 모집 인원 현황, 성별, 조회수 표시

- 모집 글의 제목 / 내용 표시

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/be916302-9be0-4a0c-a233-21b3d15639e0/image.png)

![](https://velog.velcdn.com/images/yun12343/post/58ae6356-fdca-4173-b58e-0ad1bac7de27/image.png)

![](https://velog.velcdn.com/images/yun12343/post/bcd70dce-e72b-48d2-bf43-06c255080cb6/image.png)


- 신청 버튼 클릭 시 변화

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/9e3a81ca-11c6-4c86-98e7-ea3d9fa72798/image.png)

![](https://velog.velcdn.com/images/yun12343/post/33000bb4-e3aa-4b9a-ae8d-c6499cc75457/image.png)


- 신청 취소 시 변화
	
    - 신청하지 않은 회원은 해당 글의 팀 테이블을 볼 수 없다.

</br></br>

<hr>

</br></br>

### ✅ 풋살 / 축구 관련 유튜브 영상 제공

![](https://velog.velcdn.com/images/yun12343/post/9cf878d7-0827-4561-afaa-8f2521201a03/image.png)

![](https://velog.velcdn.com/images/yun12343/post/a18333cc-a3ce-4ab4-9f1e-2db2fd04a242/image.png)


- 국가 대표 탭을 누른 후 화면

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/efd9ebf8-d274-4185-9efa-484b671a5a2e/image.png)

- 특정 영상 클릭 시 화면

- 유튜브 영상 시청 가능

- 이 영상에 대한 리뷰 글 목록 
	
    - 리뷰 번호 / 제목 / 작성자 랭크 / 작성자 이름 / 조회수 / 작성시간
   

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/bbe1e406-70f2-4270-93cc-519bf36d4914/image.png)

![](https://velog.velcdn.com/images/yun12343/post/72caa147-9558-41bb-ac2b-9e0443d66bda/image.png)


- 영상 리뷰 작성 / 작성 후 변화

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/567579fb-6848-4a44-8636-5db071ac6810/image.png)

- 리뷰 상세 페이지
	
    - 영상 / 영상 업로드 채널 / 리뷰 제목 / 내용 / 좋아요 여부 / 조회수 / 작성일자
    
- 리뷰 수정 / 삭제 가능

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/b5b8db23-4f47-4dd5-99ba-aa4eb7dfa8a8/image.png)

- 상세 페이지에서 좋아요 누른 후 하트 변화

- 조회수도 오른 모습

</br></br>

<hr>

</br></br>

### ✅ 날씨 정보 제공

![](https://velog.velcdn.com/images/yun12343/post/b9107586-9489-487b-8db9-42ed631cf1dc/image.png)

![](https://velog.velcdn.com/images/yun12343/post/4620eb42-40d0-435e-966b-9288a47c5727/image.png)


- 기상청의 단기 예보 API / 중기 예보 API와 외부 csv 엑셀 데이터를 활용하여 해당 지역과 풋살장의 날씨, 기온 예보 및 현재 상세 날씨를 제공한다.
	
    - 외부 엑셀 데이터의 경우, csv로 변환한 후 db 테이블에 맞는 형태로 변환하고 db 테이블에 삽입한 후, join 등을 통해서 해당 서비스에 알맞는 형태의 데이터로 만들어냈다.
    
    
- 전국 중, 입력하는 값에 따라 선택할 수 있는 후보 군이 바뀐다. (유저가 입력할 때마다 후보지 변경)


</br></br>

<hr>

</br></br>

### ✅ 해외 축구 소식

![](https://velog.velcdn.com/images/yun12343/post/9b7d4056-39b2-439e-ac6b-0162bd0c812b/image.png)

- 현재는 두 가지 정보 확인 가능

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/b86d3d64-b4fc-411c-b61f-c7e6d1b7d2f5/image.png)

![](https://velog.velcdn.com/images/yun12343/post/34999974-6b15-46d9-b4a0-212aeeb04da4/image.png)


- 리그 / 라운드 입력 시 로딩

- 해당 정보 제공

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/3b30d3b4-709d-4ada-9ef7-1edfa67d1125/image.png)

- 리그별 최고 득점자도 위와 동일한 방식으로 제공

</br></br>

<hr>

</br></br>


### ✅ 문의 페이지

![](https://velog.velcdn.com/images/yun12343/post/99e985ac-241a-4676-b2fc-f900cecccbb3/image.png)


- 관리자에게 사용자가 직접 문의 메시지를 남길 수 있다.

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/c64f4273-af5f-48a8-acdb-bd2fa44307c3/image.png)

- 문의 메시지는 EmailJs 라는 라이브러리를 통해, 관리자의 이메일로 전송 된다.
	
    - 관리자는 유저의 피드백을 빠르게 수용하고 해결할 수 있다.

</br></br>

<hr>

</br></br>

### ✅ 마이 페이지

![](https://velog.velcdn.com/images/yun12343/post/7072deec-54fb-496e-8758-5008eb76236f/image.png)


- 내가 업로드한 이미지, ID, 이름, 닉네임, 등급, 포지션, 전화번호 정보가 표시되어있다.

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/5661342e-f791-4970-9538-49510b37d78d/image.png)

- 내 정보의 수정이 가능하다.

- 마찬가지로 회원 탈퇴도 가능하다.

</br>

<hr>

</br>

![](https://velog.velcdn.com/images/yun12343/post/97204cab-3fdd-4a49-944b-d3c86fed6d8a/image.png)

- 내가 좋아하는 리뷰를 클릭하면, 내가 좋아요 눌렀던 영상의 리뷰 글들이 나타나고, 클릭하면 해당 리뷰의 상세 페이지로 이동한다.

</br></br>

<hr>

</br></br>

## 📌 기타 / 배운 점 / 깨달은 점 등등 모든 기록..

</br>

### ✅ 느낀 점

> 다음이 기대되는 프로젝트

싸피 1학기를 진행하면서 어느정도 긴 기간을 가진 팀 프로젝트를 처음해봤는데, 진짜 쉽지 않았다..

프로젝트를 진행하며 만난 수많은 에러들.. ^^ 잊지 않을 겁니다..

이런 많은 위기들이 저에게 있어 많은 깨달음을 주었고, 다음 번에
는 더 재밌고, 더 잘 할수 있을 것이라는 확신으로 다가왔습니다!

또 오랜만에 이렇게 무언가에 빠져 열정적으로 임했던 것 같아, 싸
피의 긴 교육기간을 지나면서 서서히 잃어왔던 열정이나 의욕을 다
시 찾은 것 같아 좋았습니다!

</br></br>

<hr>

</br></br>

### ✅ 아쉬웠던 점

- Vue 2 버전에서 List나 배열의 변경감지 불가능 이슈를 늦게 알아, 이를 해결하는데 시간이 오래걸리고 일부는 해결하지 못해서 매끄럽지 못하다.
	
    - Vue 3 버전을 사용했으면 더 쾌적했을 것 같다.
    
- 기능에 급급하여 디자인적으로 신경을 많이 못쓴것 같다.

- 처음에 설계를 확실히 잘하고 시작해야 하는데, 그러지 못해서 중간중간에 DB부터 Back / Front 모두 수정해야 하는 일이 많아서, 효율적이지 못했다.

- 팀 모집 게시판에서 등록 시, 달력 API를 활용하여 달력에 자동으로 일정이 등록되고 이를 유저에게 보여주지 못했다.
	
    - 마이 페이지에서도 내가 가입되어있는 팀 테이블을 보여주지 못했다.
    - 풋살 경기 시간이 지난 후, 자동으로 모집 글과 팀 테이블이 삭제되는 기능을 넣지 못했다.

- 회원 끼리 친구나 팔로우 팔로워 기능을 추가하여 서로 쪽지를 나누거나 채팅을 할 수 있는 기능을 넣지 못했다.

- 다음번에는 좀 더 최신 버전의 SpringBoot, Vue를 활용하고 MyBatis 대신 JPA를 활용해보고 싶다.

</br></br>

<hr>

</br></br>

### ✅ github 협업 세팅

![](https://velog.velcdn.com/images/yun12343/post/99b2de80-a35a-4e65-829c-2e60ffffc7e1/image.png)


- github repository의 Setting 중, main에 direct로 commit하지 못하게 하는 설정을 활용
	
    - 반드시 각자 다른 branch에 commit을 한 후, pull request / merge를 통해 github의 conflict checking 기능을 적극 활용
    - 프로젝트의 손상이나 충돌 없는 안전한 프로젝트 수행

</br></br>

<hr>

</br></br>


### ✅ 중요 정보 가리기

- api를 많이 활용했는데, 여기에 사용된 api key나 오픈 공간에 가릴만한 정보를 여러가지 방법으로 가렸음
	
    - gitignore
    - vue의 .env.local 파일

</br></br>

<hr>

</br></br>

### ✅ DB에서 외래 키로 연결되어 있는 항목 삭제

- 외래 키로 다른 테이블과 연결되어 있는 테이블의 항목을 삭제 / 수정 할 때 다른 테이블의 항목과 연결이 되어있어 서로 영향을 줄 수 있다. 

- 테이블 설정 필요

> ON DELETE CASCADE
ON UPDATE CASCADE

</br></br>

<hr>

</br></br>

### ✅ MySQL에 이모티콘이 들어가지 않는 현상

- '\xf0\x9f\x93\x81' 를 db에 넣을수 없다며 에러 발생

- mysql에 이모티콘을 넣을 수 있도록 설정해야 한다.

- 데이터베이스 생성시

> CREATE SCHEMA IF NOT EXISTS ssaccer CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ;

- 테이블 생성 시 끝에 추가

> ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;

</br></br>

<hr>

</br></br>

### ✅ csv 파일을 DB 테이블에 삽입할 때 인코딩 에러

- csv 파일 내에 한글이 있으면 db 테이블에 삽입 시 에러가 나타난다.

- 엑셀 파일의 제일 위 column만 한글로 바꾼 후, csv 파일을 메모장으로 연다

- 다른 이름으로 저장에서 아래 파일 형식을 utf-8로 바꾸고, 파일 이름은은 그대로 두어서 저장한다.

</br></br>

<hr>

</br></br>

### ✅ JSON Parsing 에러

- 기상청 단기 예보 API 활용 중, 

> java: constructor JSONParser in class jdk.nashorn.internal.parser.JSONParser cannot be applied to given types;
required: java.lang.String,jdk.nashorn.internal.objects.Global,boolean
found: no arguments
reason: actual and formal argument lists differ in length

와 같은 에러 발생

</br>

- IntelliJ에서 자동 Import가 

> import jdk.nashorn.internal.parser.JSONParser

로 되는데, Import를 아래 걸로 해야 한다.

> import jdk.nashorn.internal.parser.JSONParser

</br></br>

<hr>

</br></br>

### ✅ vue 파일 이름 바꿨을 때 가끔 나오는 에러

- vue 파일 이름은 이미 포함된 파일 이름과 대/소문자만 다릅니다.
파일은 다음과 같은 이유로 프로그램에 있습니다.ts(1149) 라는 에러

- jsconfig.json 파일에 compilerOptions 안에
"forceConsistentCasingInFileNames" : false, 추가

</br></br>

<hr>

</br></br>

### ✅ DB Join 이슈

- DB 테이블 간에 Join 시 3개의 테이블을 조인하고, 조인 조건(ON)에 LIKE를 활용하여 조인을 처음 해봤다.
	
    - 별 다를건 없다. 원래 하듯이 똑같이 하면 된다.

</br></br>

<hr>

</br></br>

### ✅ DTO 활용

- DTO를 처음 활용해봤다.

- JOIN을 할 때 보통 각각 다른 테이블로부터 다른 컬럼들을 가져오기 때문에 select의 결과물의 타입을 지정할 수 없다.

- 따라서 이 때 이러한 바구니 역할을 해주는 DTO를 생성해서 이 객체를 리턴 타입으로 사용하면 된다.

- 이 때 생성하는 바구니 DTO는 단지 운반 역할만 하기에 entity가 아니므로, DB table과 연결되어 있는 것이 아니다.

</br></br>

<hr>

</br></br>

