package web.logic;

import java.io.Serializable;

/* 作成者　上田*/
public class ItemBean implements Serializable {
	static final long serialVersionUID = 2L;
	private String name;//商品名
	private int stock;//在庫数
	private int price;//単価
	private String img;//画像
	private String msg;//商品説明
	private String category;//カテゴリ名

	// デフォルトコンストラクタ
	public ItemBean() {
	}

	// 初期化コンストラクタ
	public ItemBean(String name,int stock,int price,
			String img,String msg,String category) {
		setName(name);
		setStock(stock);
		setPrice(price);
		setImg(img);
		setMsg(msg);
		setCategory(category);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = "C:\\tools\\pleiades\\workspace\\ECSite\\WebContent\\img\\"+img;
//		this.img = "../img/"+img;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
