
// Compositeパターンで出てきたものとほぼ同じ
// こっちは、Entryを継承してacceptを実装している
public class File extends Entry {

	private String name;
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

	public void accept(Visitor visitor) {

		// ここで呼び出されるvisitメソッドはvisit(File)の方
		visitor.visit(this);
	}

}
