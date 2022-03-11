
// ディレクトリエントリを表現するクラス
// このサブクラスとして、FileクラスやDirectoryクラスが作成される
public abstract class Entry {

	// ディレクトリエントリは名前を持っているので名前を取得
	public abstract String getName();

	// ディレクトリエントリはサイズを持っているのでサイズを取得
	public abstract int getSize();

	// ディレクトリの中にファイルやディレクトリ（すなわちディレクトリエントリ）を入れるメソッド
	// addを実装するのは、ディレクトリを表すDirectoryクラスの階層になる。
	// Entryクラスの階層では、例外を投げてエラーにすることにしているが、
	// addの実装方法にはさまざまなバリエーションがある。
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}

	// 一覧を表示する
	// 引数ありと引数なしのprintListメソッドを用意している。
	// これを　オーバーロード（多重定義）という。
	public void printList() {
		printList("");
	}

	// prefixを前につけて
	// 一覧を表示する
	// こっちは、protectedとしてEntryのサブクラスでのみ使われるようになっている。
	protected abstract void printList(String prefix);

	// 文字列表現
	// インスタンスの標準的な文字列表現を定義する。
	// ここではファイル名とサイズを並べて表現している。
	public String toString() {
		return getName() + " (" + getSize() + ") ";
	}

}
