package factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

// HTMLページ全体を抽象的に表現したクラス
// LinkやTrayが抽象的な「部品」だとすると、Pageクラスは抽象的な「製品」という感じ
public abstract class Page {

	// ページのタイトル
	protected String title;

	// ページの作者
	protected String author;
	protected ArrayList content = new ArrayList();

	// 作者名はコンストラクタで渡す
	public Page(String title, String author) {
		this.title = title;
		this.author = author;
	}

	// ページにaddメソッドを使用してItem（すなわちLinkかTray）を追加する
	// 追加したものがこのページで表示される
	public void add(Item item) {
		content.add(item);
	}

	public void output() {
		try {

			// タイトルを元にファイル名を決定
			String filename = title + ".html";
			Writer writer = new FileWriter(filename);

			// 自分自身のHTMLの内容をファイルに書き込んでいる
			// 自分のmakeHTMLメソッドを使用している
			writer.write(this.makeHTML());
			writer.close();
			System.out.println(filename + " を作成しました。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract String makeHTML();

}
