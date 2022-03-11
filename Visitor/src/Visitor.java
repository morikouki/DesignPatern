

// 「訪問者」を表す抽象クラス
// この訪問者は、訪問先のデータ構造（すなわちFileとDirectory）に依存している。
public abstract class Visitor {

	// Fileを訪問した時にFileクラスが呼び出すメソッド
	public abstract void visit(File file);

	// Directoryを訪問した時にDirectoryクラスが呼び出すメソッド
	public abstract void visit(Directory directory);

}
