import java.util.Iterator;

// Visitorクラスのサブクラスで、データ構造を渡り歩きながら一覧を表示するためのクラス
public class ListVisitor extends Visitor {

	// 現在注目しているディレクトリ名を保持している
	private String currentdir = "";

	// ファイルを訪問したときにFileクラスのacceptメソッドの中から呼ばれる
	// Fileのインスタンスに対しての処理を行うところ
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}

	// ディレクトリを訪問したときにDirectoryクラスのacceptメソッドの中から呼ばれる
	// Directoryのインスタンスに対しての処理を行うところ
	// ディレクトリの中にはたくさんのディレクトリエントリがあるので、その1つ1つを訪問していくことになる
	// acceptメソッドはvisitメソッドを呼び、visitメソッドはacceptメソッドを呼んでいる
	// 随分複雑的な再帰をしている。あるメソッドが自分自身を呼び出すというのが通常の再帰的な呼び出しだが、
	// Visitorパターンでは、visitメソッドとacceptメソッドが互いに相手を呼び出している。
	public void visit(Directory directory) {
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;
		currentdir = currentdir + "/" + directory.getName();
		Iterator iterator = directory.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry)iterator.next();
			entry.accept(this);
		}
		currentdir = savedir;
	}

}
