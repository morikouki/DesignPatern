package tablefactory;

import java.util.Iterator;

import factory.Item;
import factory.Page;

// 具体的な製品
// Pageクラスのサブクラス
public class TablePage extends Page {

	public TablePage(String title, String author) {
		super(title, author);
	}

	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><head><title>" + title + "</title></head>¥n");
		buffer.append("<body>¥n");
		buffer.append("<h1>" + title + "</h1>¥n");
		buffer.append("<table width=¥80%¥ border=¥3¥>¥n");

		// IteratorはIteratorパターンで学んだものに似ている
		// Javaのライブラリとしてあるものを使用している
		Iterator it = content.iterator();
		while (it.hasNext()) {
			Item item = (Item)it.next();

			// 個々のItemたちが、ListLinkなのか、ListTrayなのかを気にかける必要はない
			// ここで変数itemの中身が実際になんなのかを調べて、条件式を使うようなプログラムを書いてはいけない
			// それではとても非オブジェクト指向的なプログラムになってしまう
			buffer.append(item.makeHTML());
		}
		buffer.append("</table>¥n");
		buffer.append("<hr><address>" + author + "</address>");
		buffer.append("</body></html>¥n");

		return buffer.toString();
	}



}
