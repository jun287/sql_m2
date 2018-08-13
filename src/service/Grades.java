// 2018. 08. 08 공세준
// tbl_grades 에서 받은 값을 저장하는 VO(DTO) 입니다.
/* 
	CREATE TABLE `tbl_grades` (
		`no` INT(11) NOT NULL,
		`history` INT(11) NOT NULL,
		`science` INT(11) NOT NULL
	)
*/

package service;

public class Grades {
	
	private int no;
	private int history;
	private int science;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}

}
