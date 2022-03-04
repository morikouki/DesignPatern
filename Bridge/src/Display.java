
// 抽象的な「何かを表示するもの」
// このクラスは「機能のクラス階層」の最上位にあるクラス
// open,print,closeの3つのメソッドは、このクラスが提供している
// インタフェースで、表示を行う手順を表現している。
public class Display {

	// implフィールドは、このDisplayクラスの「実装」を表すインスタンス
	private DisplayImpl impl;

	public Display(DisplayImpl impl) {

		// 実装を表すクラスのインスタンスを渡す。
		// 引数で渡されたインスタンスは、implフィールドに保持され今後の処理で使われる
		// このフィールドが2つのクラスの「橋」になる
		this.impl = impl;
	}

	// openは表示の前処理
	public void open() {

		// implフィールドの実装のメソッドを用いている
		// ここでDisplayインタフェースがDisplayImplのインタフェースへ変換されていることになる
		impl.rawOpen();
	}

	// printは表示そのもの
	public void print() {
		impl.rawPrint();
	}

	// closeは表示の後処理
	public void close() {
		impl.rawClose();
	}

	// ここでは「表示する」という処理を実現している。
	public final void display() {
		open();
		print();
		close();
	}

}
