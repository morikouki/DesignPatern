import java.io.BufferedReader;
import java.io.FileReader;

// ミニ言語のインタプリンタを動かすためのクラス
public class Main {

	public static void main(String[] args) {
		try {
			// program.txtというファイルを読み込み
			// その1行1行をミニ・プログラムだと思って構文解析し、その結果を文字列として表示する。
			BufferedReader reader = new BufferedReader(new FileReader("program.txt"));
			String text;
			while ((text = reader.readLine()) != null) {

				// 表示の中で、text = で始まる部分が与えられたミニ・プログラムで、node =で始まっている部分が構文解析後の表示
				System.out.println("text = " + text);
				Node node = new ProgramNode();
				node.parse(new Context(text));
				System.out.println("node = " + node);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
