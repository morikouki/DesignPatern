
// Dislayクラスに機能を追加したものがCountDisplayクラス
// Displayクラスには「表示する」という機能しかないが、CountDisplayクラスでは
// 「指定回数だけ表示する」という機能を追加してみた。
// それがmultiDisplayメソッド
// open,print,closeというDisplayクラスから継承しているメソッドを使って、新しいメソッドを追加している。
// ここまでが「機能のクラス階層」
public class CountDisplay extends Display {

	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}

	public void multiDisplay(int times) {
		open();

		// times回繰り返して表示する
		for (int i = 0; i < times; i++) {
			print();
		}
		close();
	}

}
