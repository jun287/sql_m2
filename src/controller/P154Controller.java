// 2018. 08. 13. 공세준
// '/P154Controller' 경로를 요청 받아서 처리하는 Controller(servlet) 입니다.

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Union;
import service.UnionDao;

@WebServlet("/P154Controller")
public class P154Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
		설명 : P154Controller 로 경로를 요청받게 되면 get 방식이므로 doGet메서드가 호출되고
			UnionDao 객체를 생성하고 참조하여 selectClubToUnion()메서드를 호출하여
			tbl_club_a 와 tbl_club_b를 합집합하여 조회환 결과값이 담긴 배열객체의 참조값을 리턴하고
			그 참조값이 unionList 객체참조변수에 대입됩니다.
			대입된 변수의 값을 request 객체를 참조하여 setAttribute 메서드에 대입하여
			경로를 재설정("/WEB-INF/views/p154.jsp")후 forward 메서드에 요청 결과를 대입후 페이지 이동합니다.
	 */
	
	private UnionDao unionDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		unionDao = new UnionDao();
		List<Union> unionlist = unionDao.selectClubToUnion();
		request.setAttribute("union", unionlist);
		request.getRequestDispatcher("/WEB-INF/views/p154.jsp").forward(request, response);
	}
}
