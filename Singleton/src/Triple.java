
// 練習問題
// インスタンスの個数が3個に限定されているクラス Tripleクラスを作成してください
// インスタンスには0, 1, 2という番号がついており、getInstanct(int id)でid番のインスタンスを取得できるものとする
public class Triple {

	private static Triple[] triples = new Triple[] {
			new Triple(0),
			new Triple(1),
			new Triple(2)
	};

	private int id;

	private Triple(int id) {
		this.id = id;
	}

	public static Triple getInstance(int id) {
		return triples[id];
	}

	public String toString() {
		return "Triple インスタンスのidは" + id + "です";
	}

}
