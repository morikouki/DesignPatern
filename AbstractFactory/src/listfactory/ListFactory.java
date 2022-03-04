package listfactory;

import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;


// 具体的な工場
public class ListFactory extends Factory {

	// Javaではコンストラクタは継承されないので定義しないといけない
	public Link createLink(String caption, String url) {
		return new ListLink(caption, url);
	}

	public Tray createTray(String caption) {
		return new ListTray(caption);
	}

	public Page createPage(String title, String author) {
		return new ListPage(title, author);
	}

}
