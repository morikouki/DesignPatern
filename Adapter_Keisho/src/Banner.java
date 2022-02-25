
// 家電を使用するときのコンセントのようなもの。
// すでに提供されているものというイメージ
public class Banner {

	private String string;

	public Banner(String string) {
		this.string = string;
	}

	// 文字列を括弧で表示するメソッド　例：(Hello)
	public void showWithParen() {
		System.out.println("(" + string + ")");
	}

	// 文字列の前後に*をつけるメソッド　例：*Hello*
	public void showWithAster() {
		System.out.println("*" + string + "*");
	}
}
