package framework;

// 「製品」を表現したクラス
// このフレームワークでは、製品とは「何はともあれ、use（使用）できるもの」と規定していることになる
public abstract class Product {

	// 抽象的なuseメソッドを宣言しておき、具体的なuseの実装は全てProductのサブクラスに任せる
	public abstract void use();

}
