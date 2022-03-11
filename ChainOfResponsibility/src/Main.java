
// Alice~Fredの6人おトラブル解決者を作成する
// ここでは全てSupportクラス型の変数を使っているが、実際に代入されているのは、
// NoSupport, LimitSupport, SpecialSupport, OddSupportの各クラスのインスタンス。
public class Main {

	public static void main(String[] args) {

		Support alice = new NoSupport("Alice");
		Support bob = new LimitSupport("Bob", 100);
		Support charlie = new SpecialSupport("Charlie", 429);
		Support diana = new LimitSupport("Diana", 200);
		Support elmo = new OddSupport("Elmo");
		Support fred = new LimitSupport("Fred", 300);

		// 連鎖の形成
		// 次にsetNextメソッドを使ってAlice~Fredを一列に並べる。
		alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

		// さまざまなトラブル発生
		// それから、トラブルを1個ずつ作成して順次aliceに渡し、誰がそのトラブルを解決するかを表示している。
		for (int i = 0; i < 500; i += 33) {
			alice.support(new Trouble(i));
		}


	}

}
