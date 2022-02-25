
// アダプターの役目を果たすクラス
// 家電のパソコン（Print）とコンセント（Banner）をつなぐ充電器のようなもの
// 用意されているBannerクラスを拡張（extends）して、showWithParenとshowWithAsterを継承している
// また、要求されているPrintインタフェースを実装（implements）してprintWeakとprintStrongを実装している
public class PrintBanner extends Banner implements Print {

	public PrintBanner(String string) {
		super(string);
	}

	public void printWeak() {
		showWithParen();
	}

	public void printStrong() {
		showWithAster();
	}

}
