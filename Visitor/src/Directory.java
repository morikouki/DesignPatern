import java.util.ArrayList;
import java.util.Iterator;

// ディレクトリを表すクラス
// Compositeパターンの時とほとんど同じ
public class Directory extends Entry {

	// ディレクトリの名前
	private String name;

	// ディレクトリエントリの集合
	private ArrayList directory = new ArrayList();

	public Directory(String name) {
		this.name = name;
	}

	// 名前を得る
	public String getName() {
		return name;
	}

	// サイズを得る
	public int getSize() {
		int size = 0;
		Iterator iterator = directory.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry)iterator.next();
			size += entry.getSize();
		}
		return size;
	}

	// エントリの追加
	public Entry add(Entry entry) {
		directory.add(entry);
		return this;
	}

	// ディレクトリに含まれているディレクトリエントリ（ファイルやディレクトリ）の一覧を得るためのIteratorを返す
	public Iterator iterator() {
		return directory.iterator();
	}

	// 訪問者の受け入れ
	public void accept(Visitor visitor) {

		// ここでは、visit(Director)が呼ばれる。
		// 訪問者に「あなたが訪問したのは、このDirectoryのインスタンスですよ」と伝えていることになる
		visitor.visit(this);
	}
}