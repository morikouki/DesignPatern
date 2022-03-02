
// AbstractDisplayのサブクラス
public class CharDisplay extends AbstractDisplay {

	// 表示すべき文字
	private char ch;

	public CharDisplay(char ch) {
		this.ch = ch;
	}

	// 開始文字として"<<"を表示
	public void open() {
		System.out.print("<<");
	}

	public void print() {
		System.out.print(ch);
	}

	// 終了文字として">>"を表示
	public void close() {
		System.out.println(">>");
	}

}
