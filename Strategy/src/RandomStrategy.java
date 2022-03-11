import java.util.Random;

// 練習問題
// デタラメに手を出すクラス
public class RandomStrategy implements Strategy {

	private Random random;

	public RandomStrategy(int seed) {
		random = new Random(seed);
	}

	public Hand nextHand() {
		return Hand.getHand(random.nextInt(3));
	}

	public void study(boolean win) {

	}

}
