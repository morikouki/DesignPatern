package factory;

// 抽象的な部品
// LinkとTrayのスーパークラスになっていて、LinkとTrayを同一視するためのクラス
public abstract class Item {

	// 見出しを表す
	protected String caption;

	public Item(String caption) {
		this.caption = caption;
	}

	// 抽象メソッドでサブクラスで実装されることが期待されている。
	// これを呼ぶとHTMLの文字列が戻り値となる。
	public abstract String makeHTML();

}
