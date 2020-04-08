package com.sy.point;

import java.io.IOException;
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
		
		if(command.equals("/pointList")) {
			System.out.println("list");
		}else if(command.equals("/pointAdd")){
			System.out.println("add");
		}else if(command.equals("/pointMod")) {
			System.out.println("mod");
		}else if(command.equals("/pointSelect")) {
			System.out.println("select");
		}else if(command.equals("/pointDelete")) {
			System.out.println("delete");
		}else {
			System.out.println("etc");
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
