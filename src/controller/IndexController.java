// 2018. 08. 06 공세준
// '/IndexController' 경로를 요청받아서 처리하는 Controller 입니다.

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/*
	 	설명 : http://localhost:8080/sql_m2/IndexController 경로를 받으면 Get방식 이므로 doGet 메서드가 호출되고
	 		 request.getRequestDispatcher 로 경로를 설정하고 forward 시켜줍니다.  
	 		 /WEB-INF/views/index.jsp 로 페이지 이동합니다.
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Controller -> View forward
		String view = "/WEB-INF/views/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
