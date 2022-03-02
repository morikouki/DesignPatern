import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Builderクラスのサブクラス
// HTMLファイルとして文書を構築する
// 構築した結果はHTMLファイルのファイル名として返す
public class HTMLBuilder implements Builder {

	// 作成するファイル名
	private String filename;

	// ファイルに書き込むPrintWriter
	private PrintWriter writer;

	// HTMLファイルでのタイトル
	public void makeTitle(String title) {

		// タイトルを元にファイル名を決定
		filename = title + ".html";

		try {

			// PrintWriteを作成する
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}

		writer.println("<html><head><title>" + title + "</title></head><body>");

		// タイトルを出力する
		writer.println("<h1>" + title + "</h1>");
	}

	// HTMLファイルでの文字列
	public void makeString(String str) {

		// pタグで出力
		writer.println("<p>" + str + "</p>");
	}

	// HTMLファイルでの箇条書き
	public void makeItems(String[] items) {

		// ulで出力
		writer.println("<ul>");

		for (int i = 0; i < items.length; i++) {

			// liで出力
			writer.println("<li>" + items[i] + "</li>");
		}

		writer.println("</ul>");
	}

	// 文書の完成
	public void close() {

		// タグを閉じる
		writer.println("</body></html>");

		// ファイルをクローズ
		writer.close();
	}

	// 完成した文書を返す
	public String getResult() {
		return filename;
	}

}
