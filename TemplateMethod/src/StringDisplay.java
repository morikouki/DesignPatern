

// AbstractDisplayのサブクラス
public class StringDisplay extends AbstractDisplay {

	// 表示するべき文字列
	private String string;

	// バイト単位で計算した文字列の「幅」
	private int width;

	public StringDisplay(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}

	public void open() {
		printLine();
	}

	public void print() {
		System.out.println("|" + string + "|");
	}

	public void close() {
		printLine();
	}

	private void printLine() {
		System.out.print("+");

		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}

		System.out.println("+");
	}

}
