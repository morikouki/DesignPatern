
// じゃんけんの「戦略」のための抽象メソッドを集めたもの
public interface Strategy {

	// 次に出す手を得る　ためのメソッド
	public abstract Hand nextHand();

	// さっき出した手によって勝ったかどうか　を学習するためのメソッド
	// 直前のnextHandメソッド呼び出しで勝った場合には、study(true)として呼び出す。
	// 負けた場合には、study(false)として呼び出す。
	// これにより、Strategyインタフェースを実装するクラスは、自分の内部状態を変化させ、次回以降のnextHandメソッドの戻り値を決定する材料とする
	public abstract void study(boolean win);

}
