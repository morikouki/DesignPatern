
// 具体的な飾り枠の一種
// Borderクラスのサブクラス、SideBorderクラスは、文字列の左右に決まった文字（borderChar）で飾りをつけるもの
// 例えば、borderCharフィールドの値が'|'だとすると
// |中身|
public class SideBorder extends Border {

	private char borderChar;

	public SideBorder(Display display, char ch) {
		super(display);
		this.borderChar = ch;
	}

	// 表示文字の横の文字数を得るメソッド
	// 「中身」の文字数に、左右の飾りも自分を加えて表示する文字数の横幅を得る
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}

	public int getRows() {
		return display.getRows();
	}

	// 引数で指定した行の文字列を得るもの
	// まさにこれがSideBorderの「飾り付け」
	public String getRowText(int row) {
		return borderChar + display.getRowText(row) + borderChar;
	}

}
