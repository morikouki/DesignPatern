
// アダプターの役目を果たすクラス
// 家電のパソコン（Print）とコンセント（Banner）をつなぐ充電器のようなもの
public class PrintBanner extends Print {

	private Banner banner;

	public PrintBanner(String string) {
		this.banner = new Banner(string);
	}

	public void printWeak() {
		banner.showWithParen();
	}

	public void printStrong() {
		banner.showWithAster();
	}

}
