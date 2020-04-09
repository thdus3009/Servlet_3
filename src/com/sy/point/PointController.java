package com.sy.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private PointService pointService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        this.pointService = new PointService();
        // TODO Auto-generated constructor stub
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
		
		//forward인지 redirect인지 
		try {
		if(command.equals("/pointList")) {
			ArrayList<PointDTO> ar = pointService.pointList();
			request.setAttribute("list", ar); //key값을 본인이 잘 기억할 이름으로 지정 //Object(value)는 arraylist(kor,eng,math,..정보들어있는것)인 ar
	
			//check는 false일때만 써주면 된다.
			path = "../WEB-INF/views/point/PointList.jsp";
			
		}else if(command.equals("/pointAdd")){
			if(method.equals("POST")) {
				//db쪽으로 보내기
				PointDTO pointDTO = new PointDTO();
				pointDTO.setName(request.getParameter("name"));//파라미터이름,db컬럼명, dto변수명일치
				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
				pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
				pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
				pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
				
				//총점평균은 service
				int result = pointService.pointAdd(pointDTO);
				
				String msg="점수등록실패";
				if(result>0) {
					msg="점수등록성공";
				}
				
				request.setAttribute("result", msg);
				request.setAttribute("pass", "./pointList");
				
				path="../WEB-INF/views/common/result.jsp";//result파일경로
				
				
			}else {
				path="../WEB-INF/views/point/PointAdd.jsp";
			}
			
			
		}else if(command.equals("/pointMod")) {
			if(method.equals("POST")) {
			PointDTO pointDTO = new PointDTO();
			pointDTO.setName(request.getParameter("name"));
			pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
			pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
			pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
			pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
		
			int result = pointService.pointMod(pointDTO);
			
			String msg= "수정실패";
			if(result>0) {
				msg = "수정성공";
				request.setAttribute("path", "./pointSelect?num="+pointDTO.getNum());
				
			}else {
				//실패하면 list로 보내기
				request.setAttribute("path", "./pointList");
			}
			
			request.setAttribute("result", msg);
			
			path = "../WEB-INF/views/common/result.jsp";
				
			}else {
	            int num = Integer.parseInt(request.getParameter("num")); //select정보를 dto에 보내서 mod로 보냄
	            PointDTO pointDTO = pointService.pointSelect(num);
	            request.setAttribute("dto", pointDTO);
	            path = "../WEB-INF/views/point/PointMod.jsp";
			}
			
		}else if(command.equals("/pointSelect")) {
			
			int num= Integer.parseInt(request.getParameter("num"));
			PointDTO pointDTO = pointService.pointSelect(num);
			
			request.setAttribute("dto", pointDTO);
			
			path = "../WEB-INF/views/point/PointSelect.jsp";
			
			
		}else if(command.equals("/pointDelete")) {
			int num = Integer.parseInt(request.getParameter("num"));

			int result = pointService.pointDelete(num);
			
			check=false;
			path="./pointList";			
			
		}else {
			System.out.println("etc");
		}
		} catch (Exception e) {
			// e.printStackTrace()/ 에러 메세지를 출력해준다는 내용
			e.printStackTrace();
		}
		
		
		//url주소는 path에 담고있다.//check가 true면 Forward,false면 redirect 선택
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
