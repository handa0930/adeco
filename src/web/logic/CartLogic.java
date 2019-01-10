package web.logic;

import java.util.ArrayList;

public class CartLogic {
	private ArrayList<CartItemBean> itemList = new ArrayList<CartItemBean>();

	public CartLogic(ArrayList<CartItemBean> itemList) {
		this.itemList = itemList;
	}

	public void addCart(String name, int price, int order) {
		Boolean isExistence = false;// カートにアイテムが存在するか
		// カートの中身があるか
		if (itemList.size() > 0) {
			// カートの中身を参照し同じ品物があれば注文個数のみ増やす
			for (CartItemBean item : itemList) {
				if (item.getName().equals(name)) {
					int temp = item.getNum() + order;
					item.setNum(temp);
					isExistence = true;
				}
			}
		}
		if (!isExistence) {
			// 引数で渡されたパラメータでカートアイテムを作成しカートに追加する
			CartItemBean cartItem = new CartItemBean();
			cartItem.setName(name);
			cartItem.setPrice(price);
			cartItem.setNum(order);
			// カートにカートアイテムを追加する
			itemList.add(cartItem);
		}
	}

	// カート内のアイテムの合計金額計算
	public long sumCalc() {
		long sum = 0;
		for (CartItemBean list : itemList) {
			sum += (long)list.getPrice() * list.getNum();
		}
		return sum;
	}

	// 消費税計算
	public long taxCalc() {
		return (long) ((long)sumCalc() * 0.08);
	}

}
