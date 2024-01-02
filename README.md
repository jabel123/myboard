
https://www.h2database.com/html/download.html 사이트에 접속한다.
Platform-Independent Zip 파일을 다운받는다.  

아래의 명령어로 zip파일을 압축해제한다.
```agsl
tar -xvf h2-2023-09-17.zip
```
h2 실행 커맨드 권한설정 
```agsl
chmod 755 [h2설치경로]/bin/nh2.sh
```
h2 실행
```agsl
[h2설치경로]/bin/h2.sh
```
h2 접속
```agsl
localhost:8082
```
위의 주소로 접속후 h2에서 연결 버튼을 누르면 된다.

데이터베이스 만들기 팁과 접속 팁에대한 url
https://www.h2database.com/html/cheatSheet.html
# myboard

--------------
### 231208 까지의 수정사항
+ Post 엔티티를 이용하여 1 Cycle(xml - Mapper - Service - Controller)을 돕니다. 
+ 위 사이클은 guest.html을 위한 동작입니다.
+ 게시글 수정 기능 -> 12. 15 일까지 추가 예정입니다.
+ sample.html은 현재로서는 이용하지 않습니다.
+ ddl 추가

### 231210 까지의 수정사항
+ update 기능 추가하였습니다.
+ (update는 delete와 다르게 '사용자가 수정한 내용'을 매개변수로 받으므로 type에서 hidden을 쓰면 안됨)
+ 위의 기능을 update 페이지를 만들어서 따로 뺄 예정입니다.

### 240102
+ 로그인 페이지 자바스크립트로 구현 중
+ 컨트롤러에 등록할 방법 찾기