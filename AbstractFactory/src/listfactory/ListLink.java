package listfactory;

import factory.Link;

// 具体的な部品
// Linkクラスのサブクラス
public class ListLink extends Link {

	// Javaではコンストラクタは継承されないので定義しないといけない
	public ListLink(String caption, String url) {
		super(caption, url);
	}

	public String makeHTML() {
		return "  <li><a href=¥" + url + "¥>" + caption + "</a></li>¥n";
	}

}
