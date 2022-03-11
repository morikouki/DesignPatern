package pagemaker;
import java.io.IOException;
import java.io.Writer;

// 簡単なWebページを作成するもの
// インスタンス作成時にWriterを与えておき、そのWriterに対してHTMLを出力する
// このクラスには、titleメソッドを一番最初に呼ばないといけないという制約が隠れている
// そして窓口となるPageMakerクラスはその制約を守るように書かれている。
public class HtmlWriter {

	private Writer writer;

	public HtmlWriter(Writer writer) {
		this.writer = writer;
	}

	// タイトルを出力するもの
	public void title(String title) throws IOException {
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>" + title + "</title>");
		writer.write("</head>");
		writer.write("<body>¥n");
		writer.write("<h1>" + title + "</h1>¥n");
	}

	// paragraphメソッドは段落を出力するもの
	public void paragraph(String msg) throws IOException {
		writer.write("<p>" + msg + "</p>¥n");
	}

	// linkメソッドはリンクを出力するもの
	public void link(String href, String caption) throws IOException {
		paragraph("<a href=¥" + href + "¥>" + caption + "</a>");
	}

	// mailtoメソッドはメールアドレスのリンクを出力するもの
	public void mailto(String mailaddr, String username) throws IOException {
		link("mailto: " + mailaddr, username);
	}

	// closeメソッドはHTMLの出力を終了するもの
	public void close() throws IOException {
		writer.write("</body>");
		writer.write("</html>¥n");
		writer.close();
	}

}
