
// 複数行からなる文字列を表示するための抽象クラス
public abstract class Display {

	// 以下2つは横の文字数と縦の行数を得るためのメソッド
	// 抽象メソッドでサブクラスで実装することが期待されている
	public abstract int getColumns();
	public abstract int getRows();

	// 指定した行の文字列を得るメソッド
	// 抽象メソッドでサブクラスで実装することが期待されている
	public abstract String getRowText(int row);

	// 全ての行を表示するメソッド
	// getRowsで行数を取得し、getRowTextで表示すべき文字列を取得し、forで表示する
	public final void show() {
		for (int i = 0; i < getRows(); i++) {
			System.out.println(getRowText(i));
		}
	}

}
