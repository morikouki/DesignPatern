import java.util.HashMap;

// BigCharのインスタンスを作成する工場
// ここで共有の仕組みを実現している。
public class BigCharFactory {

	// これまでに作ったBigCharのインスタンスを管理している。
	private HashMap pool = new HashMap();

	private static BigCharFactory sigleton = new BigCharFactory();

	private BigCharFactory() {

	}

	public static BigCharFactory getInstance() {
		return sigleton;
	}

	// Flyweightパターンの中心となるメソッド
	// 引数で与えられた文字に対応するBigCharのインスタンスを作る。
	// ただしすでに同じ文字に対応するインスタンスが作られていたら、新しいインスタンスは作らずに、以前作ったインスタンスを戻り値とする。
	public synchronized BigChar getBigChar(char charname) {
		BigChar bigChar = (BigChar)pool.get("" + charname);
		if (bigChar == null) {
			bigChar = new BigChar(charname);
			pool.put("" + charname, bigChar);
		}
		return bigChar;
	}

}
