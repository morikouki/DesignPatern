package framework;


// ここでは、TemplateMethodパターンが使われている。
// 抽象メソッドcreateProductで「製品を作り」、作った製品を抽象メソッドregisterProductで「登録」する。
// 「製品を作る」と「登録」の実装はサブクラスで行う。
// このフレームワークでは、工場とは「createメソッドでProductのインスタンスを生成するもの」と規定している。
// そして、createメソッドは「createProductで製品を作って、registerProductで登録する」という手順として実装されている。
// 具体的な実装内容は、FactoryMethodパターンを適用したプログラムによって異なる、しかし、FactoryMethodパターンであれば、
// インスタンス生成にTemplateMethodパターンが使われることになる
public abstract class Factory {

	public final Product create(String owner) {
		Product product = createProduct(owner);
		registerProduct(product);
		return product;
	}

	// 抽象メソッドにすると、サブクラスは必ずこのメソッドを実装しないといけないので、
	// 実装していない場合には、コンパイル時に検出される。
	protected abstract Product createProduct(String owner);
	protected abstract void registerProduct(Product product);


}
