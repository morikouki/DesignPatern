

// 「相談役」を表現するインタフェース
// このインタフェースを実装するクラスが具体的な相談役になる
// なおMediatorインタフェースにどのようなメソッドを持たせるかは作成するアプリによって変わる
public interface Mediator {

	// このMediatorが管理するメンバーを生成するメソッド
	// サンプルプログラムでは、このメソッドで必要なボタンや、テキストフィールドを作成する
	public abstract void createColleagues();

	// 各メンバーであるColleagueたちから呼び出されるメソッド
	// ラジオボタンやテキストフィールドの状態が変化したときに、このメソッドが呼ばれる
	public abstract void colleagueChanged();

}
