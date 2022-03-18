

// 状態を管理したり、警備センターの呼び出しをおこなったりするもの
public interface Context {

	// 時刻の設定
	public abstract void setClock(int hour);

	// 状態変化
	public abstract void changeState(State state);

	// 警備センター呼び出し
	public abstract void callSecurityCenter(String msg);

	// 警備センター記録
	public abstract void recordLog(String msg);

}
