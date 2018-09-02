# jhShop


## 개발환경
- Sptring boot
- JPA
- H2
- 그 외 dependency : lombok, devtool, jackson-mapper

## lombok
- 아주 좋은 기능인 거 같다.
  - @Getter, @Setter, @ToString, @{Constructor} 를 사용하여서 코드 길이를 매우 많이 줄일 수 있어서 좋다.


## 사용법
1. JhShopApplication.java 를 Spring Boot App으로 실행
2. localhost:8090(application.properties에 서버 포트를 8090으로 변경)으로 접속

## 로그인 기능
1. 상단 NavBar에서 회원가입 버튼 클릭 -> 회원가입 화면으로 이동
2. 회원가입 Form에 적당한 값 입력..(Id, pw 는 빈값이 되면 에러!!) 후 회원가입 버튼 클릭 -> 홈 화면으로 이동
// localhost:8080/h2-console 로 접속하여 application.properties에 저장된 값들로 접속 후 user 테이블을 확인하면 db에 저장된 것을 알 수 있다.
3. 상단 바에서 로그인 버튼 클릭 -> 로그인 화면으로 이동
4. 로그인 Form에 가입한 값 입력
5. 로그인 완료
// 로그인 시 아이디 체크 로직을 넣을려고 했는데 userRepository가 비어있으면 null exception이 발생해 import.sql로 한개의 유저아이디를 먼저 등록..


## 상품
1. 상단 바에서 상품 버튼을 클릭 -> 입력된 상품 목록들이 노출된다.
//db에 따로 저장되는 로직을 만들진 않아서 import.sql을 통해서 미리 db에 6개의 상품 등록
> 상품 가격을 클릭하면 checkout 화면으로 이동하게 만들려고 했으나, html에서 그 값을 전달하여 checkout 메소드에서
전달받은 productId의 값을 받아와 productRepository에서 값을 찾아 보여주고 밑에 checkout submit 버튼을 클릭하여 구현하려고 했으나 잘 되지 않았다.

Front-End 와 DB 연동이 벅차므로.. Back-End REST API만 테스트해보는 것으로...
3. POSTMAN 설치
4. 



## 현재상태
- 로그인과 구매와 상품 로직이 모두 따로 노는중...ㅠㅠ
