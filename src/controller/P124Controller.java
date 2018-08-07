// 2018. 08. 07. 공세준
// '/P124Controller' 경로를 요청받아서 처리하는 Controller 입니다.

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Stock;
import service.StockDao;


@WebServlet("/P124Controller")
public class P124Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/*
   		설명 : index 에서 링크로 경로를 받게 되면 Get 방식이므로 doGet 메서드가 호출되고
			StockDao 객체를 생성한후 객체내에 selectStockListLowShipmentAvg() 메서드를 호출하면 DB연결 및 쿼리가 실행되고
			그 결과값이 List<Stock> 클래스타입으로 list 객체 참조변수에 대입됩니다.
 			대입된 결과값이 담긴 list 참조값을 request.setAttribute 메서드에 대입하여 셋팅하고
			request.getRequestDispatcher 메서드에 경로를 대입하고 셋팅된 값을 포워드 시키고
 		 	/WEB-INF/views/p124.jsp 로 이동 됩니다.
	 */
	
	private StockDao stockDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stockDao = new StockDao();
		List<Stock> list = stockDao.selectStockListLowShipmentAvg();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/p124.jsp").forward(request, response);
	}
}
