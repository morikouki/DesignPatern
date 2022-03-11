import java.util.Random;

// Strategyインタフェースを実装するクラス
// このクラスは前回の勝負に勝ったならば、次も同じて（グーならグー、パーならパー、チョキならチョキ）を出す、
// という愚かな戦略をとる
// もしも前回の勝負に負けたなら次の手は乱数を使用して決める
public class WinningStrategy implements Strategy {

	private Random random;

	// 前回の結果を保持するフィールド
	private boolean won = false;

	// 前回の勝負で出した手を保持するフィールド
	private Hand prevHand;

	public WinningStrategy(int seed) {
		random = new Random(seed);
	}

	public Hand nextHand() {
		if (!won) {
			prevHand = Hand.getHand(random.nextInt(3));
		}
		return prevHand;
	}

	public void study(boolean win) {
		won = win;
	}

}
