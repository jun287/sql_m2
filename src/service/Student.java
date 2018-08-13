// 2018. 08. 08 공세준
// tbl_namelist 테이블과 tbl_grades 테이블 에서 받은 값들을 모아서 저장하는 VO(DTO) 입니다. 

package service;

public class Student {
	
	private NameList nameList;
	private Grades grades;
	
	public NameList getNameList() {
		return nameList;
	}
	public void setNameList(NameList nameList) {
		this.nameList = nameList;
	}
	public Grades getGrades() {
		return grades;
	}
	public void setGrades(Grades grades) {
		this.grades = grades;
	}
	
	
}
