package com.sy.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sy.point.PointDTO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        this.memberService = new MemberService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getPathInfo();
		
		String method = request.getMethod();
		//System.out.println(method);
		boolean check = true;
		
		String path = "";
		
		try {
			if(command.equals("/memberJoin")) {
				if(method.equals("POST")) {
					
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					memberDTO.setName(request.getParameter("name"));
					memberDTO.setPhone(request.getParameter("phone"));
					memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
					memberDTO.setEmail(request.getParameter("email"));
					
					int result=memberService.memberJoin(memberDTO);
					check=false;
					path="../";
				
					
				}else {
					path="../WEB-INF/views/member/memberJoin.jsp";
				}
				
				
			}else if(command.equals("/memberLogin")) {
				if(method.equals("POST")) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					//id,pw꺼내서 memberService의 memberLogin으로 보내기
					
					memberDTO = memberService.memberLogin(memberDTO);
					
					if(memberDTO != null) {
						//로그인하면 페이지를 로그아웃버튼으로 바꾸기 위해 session을 사용한다. 
						//request.setAttribute("m", memberDTO);
						
						HttpSession session =request.getSession();
						session.setAttribute("member", memberDTO);
						//session에 로그인한 사람의 정보가 들어있다.(memberDTO)
						check=false;
						path="../";
					}else {
						request.setAttribute("result", "Login Fail");
						request.setAttribute("path", "./memberLogin");//jsp로 보내기
						path="../WEB-INF/views/common/result.jsp";
						
					}
					
				}else {
					path="../WEB-INF/views/member/memberLogin.jsp";
				}
				
			}else if(command.equals("/memberLogOut")){
				HttpSession session = request.getSession();
				//session.removeAttribute("member");
				
				check=false;
				path="../";
				
			}else if(command.equals("/memberMyPage")) {
				
				path="../WEB-INF/views/member/memberMyPage.jsp";
				
				
			}else if(command.equals("/memberDelete")) {
				
				MemberDTO memberDTO =new MemberDTO();
				
				HttpSession session = request.getSession();
				//login에서 가져옴
				memberDTO = (MemberDTO) session.getAttribute("member");
				int result = memberService.memberDelete(memberDTO);
				
				
				if(result>0) {
					session.invalidate(); //세션 강제종료
				}
				
				check=false;
				
				path="../";
				
				
			}else if(command.equals("/memberUpdate")) {
				
				if(method.equals("POST")) {//2번
					HttpSession session = request.getSession();
					
					MemberDTO memberDTO = new MemberDTO();
					
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setName(request.getParameter("name"));
					memberDTO.setPhone(request.getParameter("phone"));
					memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
					memberDTO.setEmail(request.getParameter("email"));
					
					//memberDAO,memberService이동해서 작성
					
					int result = memberService.memberUpdate(memberDTO);
					
					if(result>0) {
						session.setAttribute("member", memberDTO); //수정하겠다는 의미
					}
					
					check = false;
					path = "../";
					
				}else {//1번 먼저 주소로 이동(get)
					
					path="../WEB-INF/views/member/memberUpdate.jsp";
					
				}
				
				
			}
			
		} catch (Exception e) {
			// e.printStackTrace()/ 에러 메세지를 출력해준다는 내용
			e.printStackTrace();
		}
		
		///
				if(check) {
					RequestDispatcher view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}else {
					response.sendRedirect(path);
				}
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
