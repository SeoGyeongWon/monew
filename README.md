# Monew
세상의 모든 뉴스

---

### 팀원 구성  
- 서경원 ([Github](https://github.com/SeoGyeongWon))  
- 정진혁 (개인 Github 링크)  
- 이치호 (개인 Github 링크)  
- 박지훈 (개인 Github 링크)  
- 이현욱 (개인 Github 링크)

---

### 프로젝트 소개  
코드잇 스프린트 백엔드 과정 중급 프로젝트  
프로젝트 기간: 2025.11.21 ~ 2025.12.12

---

## 기술 스택  
- **Backend**: Spring Boot, Spring Data JPA  
- **Database**: Postgresql  
- **공통 Tool**: Git & Github, Discord, Notion

---

### 팀원별 구현 기능 상세  

**서경원**
- 소셜 로그인 API  
  - Google OAuth 2.0 기반 로그인  
  - 로그인 후 추가 정보 입력 API  
- 회원 추가 정보 입력 API  
  - 관리자/학생 조건부 입력 처리  

**정진혁**  
- 회원별 권한 관리 (Spring Security)  
- 관리자/사용자 구분 라우팅  
- 반응형 레이아웃 API 개발  

**이치호** 
- 수강생 정보 관리 API  
  - 학생 정보 CRUD  
  - 수강 정보 조회 API  
- 공용 Button API  

**박지훈**  
- 관리자 API  
  - @PathVariable 기반 동적 라우팅  
  - 학생 정보 수정(PATCH), 삭제(DELETE)  
- 학생 정보 CRUD  
- 회원 관리 슬라이더(Carousel) API  

**이현욱**
- 학생 시간 정보 관리 API  
- 실시간 접속 현황 API  
- 개인정보 수정/탈퇴 API  
- 공용 Modal API  

---

## 파일 구조  
```
src
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┣ com
 ┃ ┃ ┃ ┣ team03
 ┃ ┃ ┃ ┃ ┣ controller
 ┃ ┃ ┃ ┃ ┃ ┣ AuthController.java
 ┃ ┃ ┃ ┃ ┃ ┣ UserController.java
 ┃ ┃ ┃ ┃ ┃ ┗ AdminController.java
 ┃ ┃ ┃ ┃ ┣ model
 ┃ ┃ ┃ ┃ ┃ ┣ User.java
 ┃ ┃ ┃ ┃ ┃ ┗ Course.java
 ┃ ┃ ┃ ┃ ┣ repository
 ┃ ┃ ┃ ┃ ┃ ┣ UserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ CourseRepository.java
 ┃ ┃ ┃ ┃ ┣ service
 ┃ ┃ ┃ ┃ ┃ ┣ AuthService.java
 ┃ ┃ ┃ ┃ ┃ ┣ UserService.java
 ┃ ┃ ┃ ┃ ┃ ┗ AdminService.java
 ┃ ┃ ┃ ┃ ┣ security
 ┃ ┃ ┃ ┃ ┃ ┣ SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┗ JwtAuthenticationEntryPoint.java
 ┃ ┃ ┃ ┃ ┣ dto
 ┃ ┃ ┃ ┃ ┃ ┣ LoginRequest.java
 ┃ ┃ ┃ ┃ ┃ ┗ UserResponse.java
 ┃ ┃ ┃ ┃ ┣ exception
 ┃ ┃ ┃ ┃ ┃ ┣ GlobalExceptionHandler.java
 ┃ ┃ ┃ ┃ ┃ ┗ ResourceNotFoundException.java
 ┃ ┃ ┃ ┃ ┣ utils
 ┃ ┃ ┃ ┃ ┃ ┣ JwtUtils.java
 ┃ ┃ ┃ ┃ ┃ ┗ UserMapper.java
 ┃ ┃ ┃ ┣ resources
 ┃ ┃ ┃ ┃ ┣ application.properties
 ┃ ┃ ┃ ┃ ┗ static
 ┃ ┃ ┃ ┃ ┃ ┣ css
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ style.css
 ┃ ┃ ┃ ┃ ┃ ┣ js
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ script.js
 ┃ ┃ ┃ ┣ webapp
 ┃ ┃ ┃ ┃ ┣ WEB-INF
 ┃ ┃ ┃ ┃ ┃ ┗ web.xml
 ┃ ┃ ┃ ┣ test
 ┃ ┃ ┃ ┃ ┣ java
 ┃ ┃ ┃ ┃ ┃ ┣ com
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ example
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ AuthServiceTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ UserControllerTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ ApplicationTests.java
 ┃ ┃ ┃ ┣ resources
 ┃ ┃ ┃ ┃ ┣ application.properties
 ┃ ┃ ┃ ┃ ┗ static
 ┃ ┃ ┃ ┃ ┃ ┣ css
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ style.css
 ┃ ┃ ┃ ┃ ┃ ┣ js
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ script.js
 ┣ Application.java
 ┣ .gitignore
 ┗ README.md

```
---

### 구현 홈페이지  
[https://www.codeit.kr/](http://15.164.173.253/)

---

### 프로젝트 발표 자료  

- [(3팀_모뉴 개별 발표 자료)](https://file.notion.so/f/f/a29b669d-e680-438e-b18c-08888fc54a21/18602c25-53b5-4534-8135-4c8c065dd6b8/3%E1%84%90%E1%85%B5%E1%86%B7_%E1%84%86%E1%85%A9%E1%84%82%E1%85%B2_%E1%84%80%E1%85%A2%E1%84%87%E1%85%A7%E1%86%AF_%E1%84%87%E1%85%A1%E1%86%AF%E1%84%91%E1%85%AD%E1%84%8C%E1%85%A1%E1%84%85%E1%85%AD.pdf?table=block&id=2c36fd22-8e8d-808e-87bc-f34e3c806b3f&spaceId=a29b669d-e680-438e-b18c-08888fc54a21&expirationTimestamp=1765555200000&signature=2ZogsVN3Gd3I42eoNwIrCQlE27sbDOHUbt8WVSHSA1M&downloadName=3%E1%84%90%E1%85%B5%E1%86%B7_%E1%84%86%E1%85%A9%E1%84%82%E1%85%B2_%E1%84%80%E1%85%A2%E1%84%87%E1%85%A7%E1%86%AF+%E1%84%87%E1%85%A1%E1%86%AF%E1%84%91%E1%85%AD%E1%84%8C%E1%85%A1%E1%84%85%E1%85%AD.pdf)

- [(3팀_모뉴_통합 발표 자료)](https://file.notion.so/f/f/a29b669d-e680-438e-b18c-08888fc54a21/e558f562-4293-4c2c-83aa-77ae0f11565b/3%E1%84%90%E1%85%B5%E1%86%B7_%E1%84%86%E1%85%A9%E1%84%82%E1%85%B2_%E1%84%90%E1%85%A9%E1%86%BC%E1%84%92%E1%85%A1%E1%86%B8_%E1%84%87%E1%85%A1%E1%86%AF%E1%84%91%E1%85%AD_%E1%84%8C%E1%85%A1%E1%84%85%E1%85%AD.pdf?table=block&id=2c36fd22-8e8d-808e-87bc-f34e3c806b3f&spaceId=a29b669d-e680-438e-b18c-08888fc54a21&expirationTimestamp=1765555200000&signature=Mb_RwovmqaYPXLr3XnTzm9zd2zdX6qKoL26XqvT-otM&downloadName=3%E1%84%90%E1%85%B5%E1%86%B7_%E1%84%86%E1%85%A9%E1%84%82%E1%85%B2_%E1%84%90%E1%85%A9%E1%86%BC%E1%84%92%E1%85%A1%E1%86%B8+%E1%84%87%E1%85%A1%E1%86%AF%E1%84%91%E1%85%AD+%E1%84%8C%E1%85%A1%E1%84%85%E1%85%AD.pdf)

- [(3팀_모뉴_시연 영상)](https://drive.google.com/file/d/1wUmaIYFbRFfkYX4RzdGT0XubJW7aSWac/view)
