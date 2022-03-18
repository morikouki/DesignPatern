

// 引数で与えられた文字列をもとにBigStringのインスタンスを作り、それを表示する
public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java Main digits");
			System.out.println("Example: java Main 1212123");
			System.exit(0);
		}

		BigString bigString = new BigString(args[0]);
		bigString.print();
	}

}
