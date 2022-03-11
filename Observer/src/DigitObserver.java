
// Observerインタフェースを実装しているクラスで、観察した数を「数字」で表示するためのもの
public class DigitObserver implements Observer {

	// 引数として与えられたNumberGeneratorのgetNumberメソッドを使用して数を取得し、それを表示する。
	public void update(NumberGenerator numberGenerator) {
		System.out.println("DigitObserver:" + numberGenerator.getNumber());
		try {
			// 表示の様子がよくわからるように速度を遅くしている。
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}

}
