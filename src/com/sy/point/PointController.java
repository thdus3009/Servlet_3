package com.sy.point;

import java.io.IOException;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
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
		if(command.equals("/pointList")) {
			
			
			check = true;//check는 false일때만 써주면 된다.
			path = "../WEB-INF/views/point/pointList.jsp";
			
		}else if(command.equals("/pointAdd")){
			if(method.equals("POST")) {
				
			}else {
				path="../WEB-INF/views/point/pointAdd.jsp";
			}
			
			
		}else if(command.equals("/pointMod")) {
			if(method.equals("POST")) {
				
			}else {
				path="../WEB-INF/views/point/pointMod.jsp";
			}
			
		}else if(command.equals("/pointSelect")) {
			
			path = "../WEB-INF/views/point/pointSelect.jsp";
			
		}else if(command.equals("/pointDelete")) {

			path = "../WEB-INF/views/point/pointDelete.jsp";
		}else {
			System.out.println("etc");
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
