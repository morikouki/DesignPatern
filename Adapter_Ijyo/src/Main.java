

// Mainクラスのソース上からはすっかりBannerクラスやshowWithParen、showWithAsterメソッドは隠れている
// これはすなわち、パソコンは直流12ボルトさえ提供して貰えば正しく動作し、それを支えているのが（アダプターの向こう側にいるのが）交流ボルト100ボルトだなんてことは知らない
// PrintBannerクラスがどういうふうに実現されているかをMainクラスは知らない。ということは、Mainクラスを全く変更せずに
// PrintBannerクラスの実装を変えられるということでもある
public class Main {
	public static void main(String[] args) {
		Print p = new PrintBanner("Hello");
		p.printWeak();
		p.printStrong();
	}

}
