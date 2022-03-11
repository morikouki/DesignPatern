
//次のようなディレクトリ階層を作っている。
//まず初めに、root, bin, tmp, usrというディレクトリを作り、binの下にviというファイルとlatexというファイルを入れる。
//それから、usrディレクトリの下に、yuki, hanako, tomuraというディレクトリを作り、各人のファイルをその下に作る。
// 実行結果では、rootディレクトリのサイズがちゃんと大きくなっている
public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("Making root entries...");
			Directory rootDirectory = new Directory("root");
			Directory binDirectory = new Directory("bin");
			Directory tmpDirectory = new Directory("tmp");
			Directory usrDirectory = new Directory("usr");
			rootDirectory.add(binDirectory);
			rootDirectory.add(tmpDirectory);
			rootDirectory.add(usrDirectory);

			binDirectory.add(new File("vi", 10000));
			binDirectory.add(new File("latex", 20000));
			rootDirectory.printList();

			System.out.println("");
			System.out.println("Making user entries...");
			Directory yukiDirectory = new Directory("yuki");
			Directory hanakoDirectory = new Directory("hanako");
			Directory tomuraDirectory = new Directory("tomura");
			usrDirectory.add(yukiDirectory);
			usrDirectory.add(hanakoDirectory);
			usrDirectory.add(tomuraDirectory);

			yukiDirectory.add(new File("diary.html", 100));
			yukiDirectory.add(new File("Composite.java", 200));
			hanakoDirectory.add(new File("memo.tex", 300));
			tomuraDirectory.add(new File("game.doc", 400));
			tomuraDirectory.add(new File("junk.mail", 500));
			rootDirectory.printList();

		} catch (FileTreatmentException e) {
			e.printStackTrace();
		}
	}

}
