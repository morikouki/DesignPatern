package factory;

// 抽象的な部品
// HTMLのハイパーリンクを抽象的に表現したクラス
// Linkクラスでは抽象メソッドが1つも登場しないように見えるが、Linkクラスでは、スーパークラス（Item）の抽象メソッド（makeHTML）が
// 実装されていない。なのでLinkクラスも抽象クラスになる
public abstract class Link extends Item {

	// リンクの飛び先のURLを保持するためのもの
	protected String url;

	public Link(String caption, String url) {
		super(caption);
		this.url = url;
	}

}
