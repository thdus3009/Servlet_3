# Servlet_3

#### 게시판 만들기 숙제
- 공지사항 (Notice) 게시판
- 글쓰기, 수정, 삭제 id가 admin만 가능
- fnc홈페이지 게시판기준으로 작성
- 글리스트 페이지 최신순으로 출력
- 글리스트 페이지에서 글쓰기 버튼을 누르면 글쓰기로 이동(admin만 가능)
- 글리스트 페이지에서 글제목을 누르면 글상세보기 이동
- 글상세보기에서 글수정, 글삭제 버튼 존재
- 글삭제 버튼을 누르면 확인, 취소창을 띄우고 확인을 누르면 삭제, 
- 글수정 누르면 글수정 이동

- (옵션)조회수표시하기, 글상세보기하면 조회수 1증간(DB user01파일 참고)

 
## 기능
- point list 출력
- point 등록
- point 상세 정보 출력
- point 수정
- point 삭제

###멤버
- 회원가입 (insert)
- 로그인(select One)
- 회원수정(Update)
- 회원탈퇴(Delete)
- myPage

##jsp
- /WEB-INF/views/member/...

##URL
- /member/memberJoin		memberJoin.jsp		GET
- /member/memberJoin							POST
- /member/memberLogin		memberLogin.jsp		GET
- /member/memberLogin							POST
- /member/memberPage 		memberPage.jsp		GET
- /member/memberUpdate 		memberUpdate.jsp	GET
- /member/memberUpdate 							POST
- /member/memberDelete							GET

## jsp 
- pointList.jsp		: List출력
- pointAdd.jsp		: 입력폼
- pointSelect.jsp	: point 상세정보 출력
- pointMod.jsp		: point 수정

## URL 주소			/	JSP				/ Method
### /WEB-INF/views/point/**
(가상의 주소, 폴더명으로 만든다)
- /point/pointList	/	pointList.jsp	/ GET
- /point/pointAdd	/	pointAdd.jsp	/ GET
- /point/pointAdd	/					/ POST
- /point/pointSelect/	pointSelect.jsp	/ GET
- /point/pointMod	/	pointMod.jsp	/ GET
- /point/pointMod	/					/ POST
- /point/pointDelete/					/ GET
 

