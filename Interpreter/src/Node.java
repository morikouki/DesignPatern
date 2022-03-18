

// 構文木の各部分（ノード）を構成する最上位のクラス
// 具体的な処理はサブクラスに任せる
public abstract class Node {

	// 「構文解析という処理を行う」ためのメソッド
	// Contextは構文解析を行なっている「状況」を表すクラス
	// 構文解析中にエラーが起きたら例外を投げる
	public abstract void parse(Context context) throws ParseException;

}
