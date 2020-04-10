# Servlet_3
 
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
 

