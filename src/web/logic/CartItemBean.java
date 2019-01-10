package web.logic;

import java.io.Serializable;

public class CartItemBean implements Serializable  {
	static final long serialVersionUID = 3L;
	private String name;//商品名
	private int price;// 単価
	private int num; //個数
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
