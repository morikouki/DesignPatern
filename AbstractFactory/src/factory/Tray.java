package factory;

import java.util.ArrayList;

// 抽象的な部品
// 複数のLinkやTrayを集めてひとまとまりにしたものを表すクラス
// tray（トレイ）はお盆のことで、お盆の上に箇条書きの1つ1つの項目を載せる、イメージ
// LinkやTrayはaddメソッドを使って集める。「LinkやTray」という部分を表現するために、
// addメソッドではLinkとTrayのスーパークラスであるItemを引数にとる。
// TrayクラスもItemクラスの抽象メソッドmakeHTMLを継承しているが、実装はしていない。
// なので、Trayクラスも抽象クラスになる
public abstract class Tray extends Item {

	protected ArrayList tray = new ArrayList();

	public Tray(String caption) {
		super(caption);
	}

	public void add(Item item) {
		tray.add(item);
	}



}
