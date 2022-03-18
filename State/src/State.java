

// 金庫の状態を表すもの
// ・時刻が設定されたとき
// ・金庫が使用されたとき
// ・非常ベルが押されたとき
// ・通常通話を行うとき　　　という出来事に対して呼び出されるインタフェースを規定している
// 「金庫使用時に呼ばれるメソッド」を表現している
// ここで規定しているメソッドは全て状態に応じて処理が変化するものになる。
// すなわち、Stateインタフェースは状態依存のメソッドの集まり。
// Contextは、状態の管理を行なっているインタフェース
public interface State {

	// 時刻設定
	public abstract void doClock(Context context, int hour);

	// 金庫使用
	public abstract void doUse(Context context);

	// 非常ベル
	public abstract void doAlarm(Context context);

	// 通常通話
	public abstract void doPhone(Context context);

}
