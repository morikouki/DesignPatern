import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


// 「大きな文字」を表すクラス
public class BigChar {

	private char charname;

	private String fontdata;

	// 引数で与えられた文字の「大きな文字」バージョンを作成する
	public BigChar(char charname) {
		this.charname = charname;
		try {
			// 「大きな文字」を構成しているデータ（いわば、フォントデータ）は、
			// ファイルとして用意している。
			BufferedReader reader = new BufferedReader(
					new FileReader("big" + charname + ".txt")
			);
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("¥n");
			}
			reader.close();
			this.fontdata = buffer.toString();
		} catch (IOException e) {
			this.fontdata = charname + "?";
		}
	}

	public void print() {
		System.out.println(fontdata);
	}

}
