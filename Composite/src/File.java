
// ファイルを表現するクラス
// Entryクラスのサブクラスとして宣言する
// スーパークラスのEntryクラスでabstractになっていたメソッドは全てここで実装されているので、
// Fileクラスが抽象クラスではない。
public class File extends Entry {

	// ファイルの名前を表現するフィールド
	private String name;
	
	// ファイルの大きさを表現するフィールド
	private int size;

	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	protected void printList(String prefix) {
		
		// ここの "/" + this という演算では、文字列とオブジェクトを演算しており
		// こうすることで、自動的にそのオブジェクトのtoStringメソッドが呼び出される。
		// これはJava言語の仕様
		System.out.println(prefix + "/" + this);
	}

}
