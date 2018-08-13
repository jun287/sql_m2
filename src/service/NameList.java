// 2018. 08. 08 공세준
// tbl_namelist 에서 받은 값을 저장하는 VO(DTO) 입니다.
/*
	CREATE TABLE `tbl_namelist` (
		`no` INT(10) NOT NULL,
		`name` VARCHAR(50) NOT NULL
	)
*/

package service;

public class NameList {
	
	private int no;
	private String name;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
