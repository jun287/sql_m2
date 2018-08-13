// 2018. 08. 08 공세준
// '/P143Controller' 경로를 요청 받아서 처리하는 Controller 입니다.

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Student;
import service.StudentDao;

@WebServlet("/P143Controller")
public class P143Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/*
	 	설명 : Index 페이지에서 요청한 경로를 받게 되면 get 방식이므로 doget 메서드가 호출되고
	 		studentDao 객체를 생성하고 studentDao 객체참조값을 참조하여 selectStudent() 메서드를 호출하면
	 		데이터베이스 연결하여 쿼리가 실행되고 결과값이 담긴 참조값이 List<Student> 클래스타입으로 list 객체참조변수에 대입됩니다.
	 		대입된 값을 request.setAttribute 메서드에 대입하고 getRequestDispatcher 메서드로 이동 경로를 설정하고 
	 		포워딩 하면 p143.jsp 페이지로 이동 됩니다.
	 	
	 */
	
	private StudentDao studentDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentDao = new StudentDao();
		List<Student> list = studentDao.selectStudent();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/p143.jsp").forward(request, response);
	}
}
