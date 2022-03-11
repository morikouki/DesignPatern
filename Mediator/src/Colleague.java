
// 相談役に相談を持ちかけるメンバーを表すインタフェース
// このインタフェースを実装して、具体的なメンバーを作成する
// なおColleagueインタフェースにどのようなメソッドを持たせるかは作成するアプリによって変わる
public interface Colleague {

	// これは「相談役は私なんだから、覚えておいてくださいね」というメソッド
	//　引数で渡されてインスタンスは、後で相談が必要になったとき使う。
	public abstract void setMediator(Mediator mediator);

	// 相談役からやってくる「指示」に相当する。
	// 引数がtrueなら自分自身を「有効状態」にし、
	// falseなら「無効状態」にする
	// このメソッドは自分が「有効状態」になるべきか、「無効状態」になるべきかを
	// 自分で判断するのではなく、相談役の判断に従って決めるということを表している。
	public abstract void setColleagueEnabled(boolean enabled);

}
