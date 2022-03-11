import java.util.Random;

// NumberGeneratorのサブクラスで、乱数を生成するもの
public class RandomNumberGenerator extends NumberGenerator {

	private Random random = new Random();

	private int number;

	public int getNumber() {
		return number;
	}

	// 乱数（0~49の範囲の整数）を20個生成し、その都度notifyObserversを使って、観察者に通知する。
	public void execute() {
		for (int i = 0; i < 20; i++) {
			number = random.nextInt(50);
			notifyObservers();
		}
	}

}
