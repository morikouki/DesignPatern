// 練習問題
// このクラスは、getNextTicketNumberメソッドを呼ぶたびに1000, 1001, 1002、、という数を順に返すためのもの
// チケットの番号やシリアルナンバーを生成するのに使う。
// このクラスは現在のままではインスタンスを幾つでも作れてしますのでSingletonパターンに修正しなさい。
//public class TicketMaker {
//
//	private int ticket = 1000;
//
//	public int getNextTicketNumber() {
//		return ticket++;
//	}
//
//}

public class TicketMaker {

	private static TicketMaker ticketMaker = new TicketMaker();

	private int ticket = 1000;

	public int getNextTicketNumber() {
		return ticket++;
	}

	public static TicketMaker getInstance() {
		return ticketMaker;
	}

}