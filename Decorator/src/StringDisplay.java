
// 1行の文字列を表示するクラス
// ケーキに例えると、バースデーケーキの中心にあるスポンジケーキになる
public class StringDisplay extends Display {

	// 表示する文字列を保持する
	private String string;

	public StringDisplay(String string) {
		this.string = string;
	}

	// 文字数
	public int getColumns() {
		return string.getBytes().length;
	}

	// 行数
	public int getRows() {

		// 表示するのが1行だけなので1を返す
		return 1;
	}

	// 0行目の値をとるときのみstringフィールドを返す
	public String getRowText(int row) {
		if (row == 0) {
			return string;
		} else {
			return null;
		}
	}

}
