

// じゃけんを行う人を表したクラス
// このクラスは「名前」と「戦略」を与えられてインスタンスを作成する
public class Player {

	private String name;
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int gamecount;

	public Player(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
	}

	// 次の手を決めるメソッドだが、実際に次の手を決めているのは自分の「戦略」
	// 自分の行うべき処理をStrategyに委ねている、、すなわち「委譲」している
	public Hand nextHand() {
		return this.strategy.nextHand();
	}

	// 勝った
	public void win() {
		strategy.study(true);
		wincount++;
		gamecount++;
	}

	// 負けた
	public void lose() {
		strategy.study(false);
		losecount++;
		gamecount++;
	}


	// 引き分けた
	public void even() {
		gamecount++;
	}

	public String toString() {
		return "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + " lose]";
	}

}
