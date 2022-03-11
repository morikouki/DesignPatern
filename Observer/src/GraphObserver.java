
// このクラスは、観察した数を****のような「簡易グラフ」で表示する
public class GraphObserver implements Observer {

	public void update(NumberGenerator numberGenerator) {
		System.out.print("GraphObserver:");
		int count = numberGenerator.getNumber();
		for (int i = 0; i < count; i++) {
			System.out.print("*");
		}
		System.out.println("");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}

}
