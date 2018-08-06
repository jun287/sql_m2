// 2018. 08. 06 공세준

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CakeDao {
	
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
	
	// 설명 : 케이크의 평균값보다 높은 케이크의 이름과 가격을 가져오는 메서드 입니다.
	// 매개변수 : 매개변수 없습니다.
	// 리턴 : 결과값이 담긴 List<Cake> 클래스 타입 객체 참조값을 받아 리턴합니다.
	public List<Cake> selectCakeListOverAvg(){
		
		List<Cake> list = new ArrayList<Cake>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement("SELECT * FROM tbl_cake WHERE price >= (SELECT AVG(price) FROM tbl_cake)");
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Cake cake = new Cake();
				cake.setName(resultSet.getString("name"));
				cake.setPrice(resultSet.getInt("price"));
				
				list.add(cake);
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
