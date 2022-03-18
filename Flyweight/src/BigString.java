

// BigCharを集めた「大きな文字列」クラス
public class BigString {

	// BigCharのインスタンスを保持する
	private BigChar[] bigChars;

	public BigString(String string) {
		bigChars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for (int i = 0; i < bigChars.length; i++) {
			// ここでnew BigCharとすると共有されない
			bigChars[i] = factory.getBigChar(string.charAt(i));
		}
	}

	public void print() {
		for (int i = 0; i < bigChars.length; i++) {
			bigChars[i].print();
		}
	}

}
