import java.util.Random;

// もう1つの具体的な「戦略」
// 次の手は乱数で決めるが、過去の勝ち負けの履歴を使って、それぞれの手を出す確率を変えている
public class ProbStrategy implements Strategy {

	private Random random;

	private int prevHandValue = 0;
	private int currentHandValue = 0;

	// history[前回に出した手][今回出す手]
	// この式の値が大きければ大きいほど、過去の確率が高いということになる。
	// history[0][0]　グー、グーと自分だ出した時の過去の勝ち数
	// history[0][1]　グー、チョキと自分が出した時の過去の勝ち数
	// history[0][2]　グー、パーと自分が出した時の過去の勝ち数
	// 前回自分がグーを出したとする、その時次に自分が何を出すかを、
	// 上記のhistory[0][0]、history[0][1]の値から確率で計算しようというわけ
	// 要するにこの3つの式の値を足し（getSumメソッド）、0からその数までの乱数を計算し、そしてそれをもとに次の手を決める。
	// 例えば、
	// history[0][0]の値が3
	// history[0][1]の値が5
	// history[0][2]の値が7　　だとする
	// この時、グー、チョキ、パーを出す割合を3:5:7として次の手を決める
	// 0以上15未満（15は3+5+7の値）の乱数値を得て、
	//  0以上3未満ならグー
	//  3以上8（＝3＋5）未満ならチョキ
	//  8以上15（=3+5+7）未満ならパー　　　とする
	private int[][] history = {
			{1,1,1},
			{1,1,1},
			{1,1,1}
	};

	public ProbStrategy(int seed) {
		random = new Random(seed);
	}

	public Hand nextHand() {
		int bet = random.nextInt(getSum(currentHandValue));
		int handvalue = 0;

		if (bet < history[currentHandValue][0]) {
			handvalue = 0;
		} else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
			handvalue = 1;
		} else {
			handvalue = 2;
		}

		prevHandValue = currentHandValue;
		currentHandValue = handvalue;
		return Hand.getHand(handvalue);

	}

	private int getSum(int hv) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += history[hv][i];
		}
		return sum;
	}


	// nextHandメソッドで返した手の勝敗をもとに、historyフィールドの内容を更新する
	public void study(boolean win) {
		if (win) {
			history[prevHandValue][currentHandValue]++;
		} else {
			history[prevHandValue][(currentHandValue + 1) % 3]++;
			history[prevHandValue][(currentHandValue + 2) % 3]++;
		}
	}

}
