package command;

// 「命令」を表現するためのもの
public interface Command {

	// 実行するというメソッド
	public abstract void execute();
}
