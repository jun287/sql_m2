// 2018. 08. 07. 공세준
// Stock 테이블의 데이터를 저장하는 VO(DTO) 입니다.

package service;

public class Stock {
	
	private int code;
	private int arrival;
	private int shipment;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getArrival() {
		return arrival;
	}
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	public int getShipment() {
		return shipment;
	}
	public void setShipment(int shipment) {
		this.shipment = shipment;
	}
	
}
