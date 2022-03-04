
// 文字列を表示するクラス
// ただ表示するのではなく、DisplayImplクラスのサブクラスとして、rawOpen,rawPrint,rawCloseを使用して表示する
public class StringDisplayImpl extends DisplayImpl {

	// 表示するべき文字列
	private String string;

	// バイト単位で計算した文字列の幅
	private int width;

	public StringDisplayImpl(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}

	public void rawOpen() {
		printLine();
	}

	public void rawPrint() {
		System.out.println("|" + string + "|");
	}

	public void rawClose() {
		printLine();
	}

	public void printLine() {
		System.out.print("+");
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}

}
