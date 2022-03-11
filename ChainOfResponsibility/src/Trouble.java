

// 発生したトラブルを表現するクラス
public class Trouble {

	// トラブル番号
	private int number;

	// トラブルの生成
	public Trouble(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	// トラブルの文字列表現
	public String toString() {
		return "[Trouble " + this.number + "]";
	}

}
