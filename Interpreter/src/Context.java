import java.util.StringTokenizer;

// 構文解析に必要なメソッドを提供しているクラス
// java.util.StringTokenizerは、与えられた文字列をトークンに分割してくれる。
// 分割するときの区切り文字は、スペース(' ')、タブ('¥t')、ニューライン('¥n')、キャリッジリターン('¥r')、
// フォームフィールド('¥f')になる
public class Context {

	private StringTokenizer tokenizer;

	private String currentToken;

	public Context(String text) {
		tokenizer = new StringTokenizer(text);
		nextToken();
	}

	public String nextToken() {
		if (tokenizer.hasMoreTokens()) {
			currentToken = tokenizer.nextToken();
		} else {
			currentToken = null;
		}
		return currentToken;
	}

	public String currentToken() {
		return currentToken;
	}

	public void skipToken(String token) throws ParseException {
		if (!token.contentEquals(currentToken)) {
			throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " id found.");
		}
		nextToken();
	}

	public int currentNumber() throws ParseException {
		int number = 0;
		try {
			number = Integer.parseInt(currentToken);
		} catch (NumberFormatException e) {
			throw new ParseException("Warnign: " + e);
		}
		return number;
	}

}
