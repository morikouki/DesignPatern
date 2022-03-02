package idcard;

import framework.Product;

public class IDCard extends Product {

	private String owner;
	private int id;

	// publicをつけないことで idcardパッケージ外からnewを使って生成できないことを表している
	// これで、Mainクラスから IDCard idcard = new IDCard();がエラーになる
	IDCard(String owner, int id) {
		System.out.println(owner + "(" + id + ")" + "のカードを作ります。");
		this.owner = owner;
		this.id = id;
	}

	public void use() {
		System.out.println(owner + "(" + id + ")" + "のカードを使います。");
	}

	public String getOwner() {
		return owner;
	}

}
