package listfactory;

import java.util.Iterator;

import factory.Item;
import factory.Tray;

// 具体的な部品
// Trayクラスのサブクラス
// trayフィールドの中にはHTMLとして出力すべきItemたちが集められている
// それらをHTMLのタグとして豹変するのがmakeHTMLの使命
public class ListTray extends Tray {

	// Javaではコンストラクタは継承されないので定義しないといけない
	public ListTray(String caption) {
		super(caption);
	}

	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<li>¥n");
		buffer.append(caption + "¥n");
		buffer.append("<ul>¥n");

		// IteratorはIteratorパターンで学んだものに似ている
		// Javaのライブラリとしてあるものを使用している
		Iterator it = tray.iterator();
		while (it.hasNext()) {
			Item item = (Item)it.next();

			// 個々のItemたちが、ListLinkなのか、ListTrayなのかを気にかける必要はない
			// ここで変数itemの中身が実際になんなのかを調べて、条件式を使うようなプログラムを書いてはいけない
			// それではとても非オブジェクト指向的なプログラムになってしまう
			buffer.append(item.makeHTML());
		}
		buffer.append("</ul>¥n");
		buffer.append("</li>¥n");

		return buffer.toString();
	}

}
