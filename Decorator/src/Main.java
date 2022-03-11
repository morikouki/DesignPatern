
public class Main {

	public static void main(String[] args) {

		// "Hello, world."を飾りなしで表示する
		Display b1 = new StringDisplay("Hello, world.");

		// b1に対して、'#'の文字で左右に飾り付けをしたもの
		Display b2 = new SideBorder(b1, '#');

		// b2に対して全体の飾り枠をつけたもの
		Display b3 = new FullBorder(b2);

		b1.show();
		b2.show();
		b3.show();

		// "こんにちは。"に何重にも飾り枠をつけたもの
		Display b4 =
				new SideBorder(
					new FullBorder(
						new FullBorder(
								new SideBorder(
									new FullBorder(
										new StringDisplay("こんにちは。")
									),
									'*'
								)
						)
					),
					'/'
				);
		b4.show();
	}

}
