// 2018. 08. 06 공세준

/*
 * CREATE TABLE `tbl_cake` (
	`name` VARCHAR(50) NULL DEFAULT NULL,
	`price` INT(10) NULL DEFAULT NULL
	)
 */

package service;

public class Cake {
	
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
