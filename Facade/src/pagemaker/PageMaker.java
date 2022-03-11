package pagemaker;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// DatabaseクラスとHtmlWriterクラスを組み合わせて、指定したユーザのWebページを作成するためのクラス
public class PageMaker {

	private PageMaker() {

	}

	// このメソッドを呼ぶだけでWebページが作成される。
	// HtmlWriterクラスのメソッドをごちゃごちゃ呼ぶところは、このクラスが一手に引き受け
	// 外部に対してはたった1つのmakeWelcomePageメソッドだけを見せている。
	// これがシンプルな窓口
	public static void makeWelcomePage(String mailaddr, String filename) {
		try {
			Properties mailProperties = Database.getProperties("maildata");
			String username = mailProperties.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("Welcome to " + username + "'s page!");
			writer.paragraph(username + "のページへようこそ。");
			writer.paragraph("メール待っていますね");
			writer.mailto(mailaddr, username);
			writer.close();
			System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
