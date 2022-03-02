
public class Main {
	public static void main(String[] args) {
		System.out.println("Start.");

		// 2回インスタンスを取得
		// ここのインスタンス取得のメソッドで初めてSingletonクラスのインスタンスは作成される
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		// 取得したインスタンスが同じかを判定している。
		// Singletonクラスでは必ずここでtrueになる
		if (s1 == s2) {
			System.out.println("同じインスタンスです");
		} else {
			System.out.println("違うインスタンスです");
		}

		System.out.println("End.");


		// 練習問題　TicketMakerの呼び出し
		// getNextTicketNumberメソッドを呼ぶとチケット番号がカウントアップする
		System.out.println("ここからTicketMakerクラスの呼び出し");

		TicketMaker ticketMaker = TicketMaker.getInstance();
		System.out.println(ticketMaker.getNextTicketNumber());
		System.out.println(ticketMaker.getNextTicketNumber());

		// 同じインスタンスが作成されるので、上記のメソッドを呼んだ続きから始まる
		TicketMaker ticketMaker2 = TicketMaker.getInstance();
		System.out.println(ticketMaker2.getNextTicketNumber());


		// 練習問題　Tripleの呼び出し
		Triple triple = Triple.getInstance(0);
		Triple triple2 = Triple.getInstance(1);
		System.out.println(triple.toString());
		System.out.println(triple2.toString());

	}

}
