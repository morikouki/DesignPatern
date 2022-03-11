import java.util.ArrayList;
import java.util.Iterator;

// ディレクトリを表現するクラス
// Entryのサブクラスとして定義
public class Directory extends Entry {

	// ディレクトリの名前を表すフィールド
	private String name;

	// ディレクトリエントリを保持しておくためのフィールド
	private ArrayList directory = new ArrayList();

	public Directory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 動的にサイズを求めている
	// 変数sizeにentryのサイズを加えているが、このentryはFileクラスのインスタンスかもしれないし、
	// Directoryクラスのインスタンスかもしれない。
	// どちらの場合でも、同じメソッドgetSizeでサイズを得ることができている。
	// これがCompositeパターンの特徴、「容器と中身を同じものとみなす」ことの現れ。
	// FileのインスタンスでもDirectoryのインスタンスでも、entryはとにかくEntryのサブクラスのインスタンスなので
	// getSizeを安心して呼ぶことができる。Entryのサブクラスが将来的に追加されてもここの修正はしなくていい。
	// entryがDiretoryのインスタンスの場合、entry.getSize()という式を評価すると、ディレクトリの中のエントリのサイズを1個1個加える。
	// また、その中にディレクトリがあったら、さらにサブディレクトリのgetSizeを呼び出し・・と、再帰的にメソッドgetSizeが呼ばれることになる。
	// Compositeパターンの再帰的構造が、そのままgetSizeというメソッドの再帰的呼び出しに対応していることになる。
	public int getSize() {
		int size = 0;
		Iterator iterator = directory.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry)iterator.next();
			size += entry.getSize();
		}
		return size;
	}

	// 追加
	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}

	// ディレクトリの一覧を表示するもので、このメソッドも
	// getSizeと同じように再帰的に呼び出している。
	// getSizeメソッドと同様に、容器と中身が同一視されている。
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
		Iterator iterator = directory.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry)iterator.next();
			entry.printList(prefix + "/" + name);
		}
	}

}
