
// 抽象クラス
// スーパークラス
// 処理の骨組みを実装しないといけない。
// インタフェースでは全てのメソッドが抽象メソッドでなければならない。
// なので、TemplateMethodパターンでは、抽象クラスの代わりにインタフェースを使用することはできない
public abstract class AbstractDisplay {

	// サブクラスに実装を任せる抽象メソッド
	public abstract void open();
	public abstract void print();
	public abstract void close();

	// この抽象クラスで実装しているメソッド
	// 抽象メソッドを使用しているテンプレートメソッドになっている
	// finalをつけて、オーバーライドを禁止している。
	public final void display() {

		// オープンして
		open();

		// 5回繰り返して
		for (int i = 0; i < 5; i++) {
			print();
		}

		// 最後にクローズ
		close();
	}

}
