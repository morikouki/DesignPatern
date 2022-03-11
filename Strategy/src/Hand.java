
// じゃんけんの手を表すクラス
// クラスの内部では、グーは「0」、チョキは「1」、パーは「2」というintで表現している
public class Hand {

	// グーを表す値
	public static final int HANDVALUE_GUU = 0;

	// チョキを表す値
	public static final int HANDVALUE_CHO = 1;

	// パーを表す値
	public static final int HANDVALUE_PAA = 2;

	// じゃんけんの手を表す3つのインスタンス
	public static final Hand[] hand = {
			new Hand(HANDVALUE_GUU),
			new Hand(HANDVALUE_CHO),
			new Hand(HANDVALUE_PAA),
	};

	// じゃんけんの手の文字列表現
	private static final String[] name = {
			"グー", "チョキ", "パー",
	};

	// じゃんけんの手の値
	private int handvalue;

	private Hand(int handvalue) {
		this.handvalue = handvalue;
	}

	// 値からインスタンスを得る
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}

	// thisがhより強い時 true
	public boolean isStrongerThan(Hand h) {
		return fight(h) == 1;
	}

	// thisがhより弱い時 false
	public boolean isWeakerThan(Hand h) {
		return fight(h) == -1;
	}

	// thisの手の値に1を加えたものがhの手の値（つまりthisがグーならhはチョキ、thisがチョキならhはパー、
	// thisがパーならhはグー）になっているなら、thisはhより強いことになる
	// 演算子%を使って3の剰余（あまり）を取っているのは、パー（2）に1加えたときに、グー（0）になってほしいから。
	private int fight(Hand h) {
		if (this == h) {
			return 0;
		} else if ((this.handvalue + 1) % 3 == h.handvalue) {
			return 1;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name[handvalue];
	}


}
