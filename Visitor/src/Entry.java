import java.util.Iterator;

// Compositeパターンのプログラムで出たものと本質的には同じだが、ここではElementインタフェースを実装している
public abstract class Entry implements Element {

	// 名前を得る
	public abstract String getName();

	// サイズを得る
	public abstract int getSize();

	// エントリを追加する
	public Entry add(Entry entry) throws FileTreatmentExeption {
		throw new FileTreatmentExeption();
	}

	// Iteratorの生成
	public Iterator iterator() throws FileTreatmentExeption {
		throw new FileTreatmentExeption();
	}

	// 文字列表現
	public String toString() {
		return getName() + " (" + getSize() + ") ";
	}

}
