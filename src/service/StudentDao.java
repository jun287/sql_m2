// 2018. 08. 08 공세준
// 데이터베이스에 연결하여 tbl_namelist 테이블과 tbl_grades 테이블에 접근하여 쿼리를 실행하고 테이블 수정,입력,삭제 또는 결과값을 조회하는 DAO 입니다.

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
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
	
	// 설명 : 테이블 두개를 INNER 조인해서 일치하는 번호의 데이터를 가져오는 메서드 입니다. 
	// 매개변수 : 없습니다.	
	// 리턴 : List<Student> 클래스 타입으로 쿼리 결과값을 담은 객체의 참조값을 리턴합니다. 
	public List<Student> selectStudent(){
		
		List<Student> list = new ArrayList<Student>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = this.getConnection();
			// tbl_namelist 에 tbl_grades 테이블을 INNER JOIN 하여 tbl_namelist.no 컬럼과 tbl_grades.no 컬럼이 일치하는 데이터를 조회합니다.
			statement = connection.prepareStatement("SELECT * FROM tbl_namelist INNER JOIN tbl_grades ON tbl_namelist.no = tbl_grades.no");
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				NameList nameList = new NameList();
				nameList.setNo(resultSet.getInt("tbl_namelist.no"));
				nameList.setName(resultSet.getString("tbl_namelist.name"));
				
				Grades grades = new Grades();
				grades.setNo(resultSet.getInt("tbl_grades.no"));
				grades.setHistory(resultSet.getInt("tbl_grades.history"));
				grades.setScience(resultSet.getInt("tbl_grades.science"));
				
				Student student = new Student();
				student.setNameList(nameList);
				student.setGrades(grades);
				
				list.add(student);
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
