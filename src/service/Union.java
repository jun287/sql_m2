// 2018. 08. 13. 공세준
// tbl_club_a 와 tbl_club_b 테이블을 Union 한 결과값을 저장하는 VO(DTO) 입니다.

package service;

public class Union {
	
	private String lastName;
	private String firstName;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
