
// 昼間の状態を表すクラス
// 状態を表すクラスは、1つずつしかインスタンスを作らないことにしている。
public class DayState implements State {

	private static DayState singleton = new DayState();

	private DayState() {

	}

	public static State getInstance() {
		return singleton;
	}

	// 時刻を設定するメソッド
	// 引数の時刻が夜間の時刻であれば、夜間の状態へシステムを移行する
	// ここで状態の変化（状態遷移）が起こる
	public void doClock(Context context, int hour) {
		if (hour < 9 || 17 <= hour) {

			// changeStateで状態の変化を表現している。
			// NightStateは夜間の状態を表す
			context.changeState(NightState.getInstance());
		}
	}

	// 金庫使用
	public void doUse(Context context) {
		context.recordLog("金庫使用（昼間）");
	}

	// 非常ベル
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル（昼間");
	}

	// 通常通話
	public void doPhone(Context context) {
		context.callSecurityCenter("通常の通話（昼間）");
	}

	public String toString() {
		return "[昼間]";
	}

}
