

// 家電で例えるとパソコンのようなもの
public interface Print {

	// 文字列を弱く（括弧付きで）表示するためのメソッド
	public abstract void printWeak();

	// 文字列を強く（*で挟んで強調して）表示するためのメソッド
	public abstract void printStrong();

}
