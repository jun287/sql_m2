// 2018. 08. 06 공세준

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Cake;
import service.CakeDao;

@WebServlet("/P122Controller")
public class P122Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/*
	   	설명 : index 에서 링크 또는 http://localhost:8080/sql_m2/P122Controller 로 경로를 받게 되면
	   	   	 Get 방식이므로 doGet 메서드가 호출되고
	   	   	 cakeDao 객체를 생성한후 객체내에 selectCakeListOverAvg() 메서드를 호출하면 DB연결 및 쿼리가 실행되고
	    	  그 결과값이 List<Cake> 클래스타입으로 list 객체 참조변수에 대입됩니다.
	 		  대입된 결과값이 담긴 list 참조값을 request.setAttribute 메서드에 대입하여 셋팅하고
	 		 request.getRequestDispatcher 메서드에 경로를 대입하고 셋팅된 값을 포워드 시키고
	 		 /WEB-INF/views/p122.jsp 로 이동 됩니다.
	 */
	
    private CakeDao cakeDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cakeDao = new CakeDao();
		List<Cake> list = cakeDao.selectCakeListOverAvg();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/p122.jsp").forward(request, response);
	}
}
