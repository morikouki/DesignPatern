package tablefactory;

import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;

public class TableFactory extends Factory {

	public Link createLink(String caption, String url) {
		return new TableLink(caption, url);
	}

	public Tray createTray(String caption) {
		return new TableTray(caption);
	}

	public Page createPage(String title, String author) {
		return new TablePage(title, author);
	}

}
