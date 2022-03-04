import java.util.Random;

// 練習問題で作成したクラス
public class RandomDisplay extends CountDisplay {

	public RandomDisplay(DisplayImpl impl) {
		super(impl);
	}

	public void randomDispay(int times) {
		multiDisplay(new Random().nextInt(times));
	}

}
