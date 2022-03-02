package tablefactory;

import factory.Link;

// 具体的な部品
// Linkのサブクラス
public class TableLink extends Link {

	public TableLink(String caption, String url) {
		super(caption, url);
	}

	public String makeHTML() {
		return "<td><a href=¥" + url + "¥>" + caption + "</a></td>¥n";
	}

}
