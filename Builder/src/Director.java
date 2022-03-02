
public class Director {

	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public void construct() {
		// タイトル
		builder.makeTitle("Greeting");

		// 文字列
		builder.makeString("朝から昼にかけて");

		// 箇条書き
		builder.makeItems(new String[] {
				"おはようございます。",
				"こんにちは。",
		});

		// 別の文字列
		builder.makeString("夜に");

		// 別の箇条書き
		builder.makeItems(new String[] {
				"こんばんは。",
				"おやすみなさい。",
				"さようなら。",
		});

		// 文書を完成させる
		builder.close();
	}

}
