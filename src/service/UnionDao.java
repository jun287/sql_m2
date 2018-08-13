// 2018. 08. 13. 공세준
// 데이터베이스 연결후 tbl_club_a 테이블과 tbl_club_b 테이블에 접근하여 조회 및 결과를 가져오는 DAO 입니다.

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnionDao {
	
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
		
	
	// 설명 : 두개의 SELECT문의 결과에 대한 합집합(Union)을 구하고 결과값을 리턴하는 메서드 입니다.
	// 매개변수 : 없습니다.
	// 리턴 : tbl_club_a와 tbl_club_b를 Union 한 결과값이 담긴 List<Union> 클래스 객체의 참조값을 리턴합니다.
	public List<Union> selectClubToUnion(){
		
		List<Union> list = new ArrayList<Union>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = this.getConnection();
			// tbl_club_a 테이블과 tbl_club_b 테이블을 합집합 하여 중복된 데이터를 하나로 정리하고 합쳐진 결과를 조회합니다.
			statement = connection.prepareStatement("SELECT lname, fname FROM tbl_club_a UNION SELECT sung, irum FROM tbl_club_b");
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Union union = new Union();
				union.setFirstName(resultSet.getString("fname"));
				union.setLastName(resultSet.getString("lname"));
				
				list.add(union);

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
