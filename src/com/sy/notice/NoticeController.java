package com.sy.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sy.member.MemberDTO;


/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private NoticeService noticeService;
	
    public NoticeController() {
        super();
        this.noticeService = new NoticeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글 Encoding 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//pathInfo (어떤요청인지 > command)
		String command = request.getPathInfo();
		
		//Method 형식 (어떤방식을 사용할건지> method)
		String method = request.getMethod();
		
		//Forward(true), redirect(false) 선택
		boolean check = true;
		
		//path를 담을 변수 (어디로보낼건지 > path)
		String path = "";
		System.out.println(path);
		try {
		if(command.equals("/noticeList")) {
			ArrayList<NoticeDTO> ar = noticeService.noticeList();
			
			request.setAttribute("list", ar); //key값을 본인이 잘 기억할 이름으로 지정 //Object(value)는 arraylist(kor,eng,math,..정보들어있는것)인 ar
	
			//check는 false일때만 써주면 된다.
			path = "../WEB-INF/views/notice/noticeList.jsp";
			
		}else if(command.equals("/noticeAdd")) {
			
			if(method.equals("POST")) {
				NoticeDTO noticeDTO = new NoticeDTO();
				HttpSession session = request.getSession();
				MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
				noticeDTO.setId(memberDTO.getId());
				String text = request.getParameter("text");
				String subject = request.getParameter("subject");
				noticeDTO.setSubject(subject);
				noticeDTO.setText(text);
				
				int result = noticeService.noticeAdd(noticeDTO);
				if(result>0) {
					path="../WEB-INF/views/common/result.jsp";
					request.setAttribute("path", "../");
					request.setAttribute("result", "게시물 추가 완료");
				}
				
			}else {
				path="../WEB-INF/views/notice/noticeAdd.jsp";
			}
			
		}else if(command.equals("/noticeDelete")) {
			
			String num = request.getParameter("num");
			int result = noticeService.noticeDelete(num);
			
			if(result>0) {
				path="../WEB-INF/views/common/result.jsp";
				request.setAttribute("result", "삭제성공");
				request.setAttribute("path", "../");
			}
			
		}else if(command.equals("/noticeMod")) {
			
			request.setAttribute("subject",request.getParameter("subject"));
			request.setAttribute("text",request.getParameter("text"));
			request.setAttribute("num", request.getParameter("num"));
			NoticeDTO noticeDTO = new NoticeDTO();
			
			if(method.equals("POST")) {
				noticeDTO.setNum(Integer.parseInt(request.getParameter("num")));
				noticeDTO.setSubject(request.getParameter("subject"));
				noticeDTO.setText(request.getParameter("text"));
				
				HttpSession session = request.getSession();
				MemberDTO memberDTO= (MemberDTO)session.getAttribute("member");
				noticeDTO.setId(memberDTO.getId());
				
				int result = noticeService.noticeMod(noticeDTO);
				System.out.println(result);
				
				if(result >0) {
					path="../WEB-INF/views/common/result.jsp";
					request.setAttribute("path", "../");
					request.setAttribute("result", "게시물 수정 완료");
				}
				
			}else {
				path="../WEB-INF/views/notice/noticeMod.jsp";
			}
			
		}else if(command.equals("/noticeSelect")) {
			int num = Integer.parseInt(request.getParameter("num"));
			NoticeDTO noticeDTO = noticeService.noticeSelect(num);
			
			request.setAttribute("dto", noticeDTO);
			
			path = "../WEB-INF/views/notice/noticeSelect.jsp";
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(check) {//forward
			
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {//redirect
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
