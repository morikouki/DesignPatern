
// Builderクラスのサブクラス
// プレーンテキストを使用して文書を構築する
// 結果はStringとして返す
public class TextBuilder implements Builder {

	// このフィールドに文書を構築していく
	private StringBuffer buffer = new StringBuffer();

	// プレーンテキストのタイトル
	public void makeTitle(String title) {

		// 飾り線
		buffer.append("=====================¥n");

		// 『』つきのタイトル
		buffer.append("『" + title + "』¥n");

		// 空行
		buffer.append("¥n");
	}

	// プレーンテキストでの文字列
	public void makeString(String str) {

		// ■つきの文字列
		buffer.append('■' + str + "¥n");

		// 空行
		buffer.append("¥n");
	}

	// プレーンテキストでの文字列
	public void makeItems(String[] items) {
		for (int i = 0; i < items.length; i++) {

			// ・つきの項目
			buffer.append("  ・" + items[i] + "¥n");
		}
		buffer.append("¥n");
	}

	// 文書の完成
	public void close() {

		// 飾り線
		buffer.append("=====================¥n");
	}

	// 完成した文書を返す
	public String getResult() {

		// StringBufferをStringに変換
		return buffer.toString();
	}



}
