
public interface Builder {

	// タイトルを作成するメソッド
	public abstract void makeTitle(String title);

	// 文字列を作成するメソッド
	public abstract void makeString(String str);

	// 箇条書きの文字列を作成するメソッド
	public abstract void makeItems(String[] items);
	public abstract void close();

}
