// 2018. 08. 07 공세준
// 데이터베이스에 연결하고 tbl_stock 테이블을 접근하여 쿼리를 실행하고 테이블 수정,입력,삭제 또는 결과값을 조회하는 DAO 입니다.

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDao {
	
	// 설명 : 드라이버 로딩 및 데이터베이스 연결 하는 메서드 입니다.
	// 매개변수 : 없습니다.
	// 리턴 : Connection 클래스 타입으로 연결후 정보를 담은 객체의 참조값을 리턴합니다.
	public Connection getConnection() throws Exception {
		
        Class.forName("com.mysql.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost:3306/sql_m2?useUnicode=true&characterEncoding=UTF-8";
        String dbUser = "root";
        String dbPw = "java0000";
        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        return connection;
        
    }
	
	// 설명 : shipment열의 평균값보다 작은 arrival열이 있는 code열을 가져오는 메서드 입니다.
	// 매개변수 : 매개변수 없습니다.
	// 리턴 : 결과값이 담긴 List<Stock> 클래스 타입 객체 참조값을 받아 리턴합니다.
	public List<Stock> selectStockListLowShipmentAvg(){
		
		List<Stock> list = new ArrayList<Stock>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = this.getConnection();
			// tbl_stoce 테이블내에 전체 shipment의 평균값을 조회하고 
			// code 열을 기준으로 그룹화하여 arrival 열의 최저값이  평균값(shipment의 평균값)보다 작은 테이터 열(code,arrival)을 조회합니다. 
			statement = connection.prepareStatement("SELECT code, MIN(arrival) As arrival FROM tbl_stock GROUP BY code HAVING MIN(arrival) < (SELECT AVG(shipment) FROM tbl_stock)");
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Stock stock = new Stock();
				stock.setCode(resultSet.getInt("code"));
				stock.setArrival(resultSet.getInt("arrival"));
				
				list.add(stock);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				try { 
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(connection != null) {
	            try {
	            	connection.close();
	            }catch(SQLException e){
	            	e.printStackTrace();
	            }
			}
		}
		return list;
	}
}
