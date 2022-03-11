

// 指定した番号のトラブルに限って処理するクラス
public class SpecialSupport extends Support {

	// この番号だけ解決できる
	private int number;

	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
	}

	// 解決用メソッド
	protected boolean resolve(Trouble trouble) {
		if (trouble.getNumber() == number) {
			return true;
		} else {
			return false;
		}
	}

}
