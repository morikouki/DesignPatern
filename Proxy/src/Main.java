
// PrinterProxy経由でPrinterを利用するクラス
// 最初にPrinterProxyを生成し、getPrinterNameを利用して名前を表示する
// それからsetPrinterNameで名前を設定する。
// 名前の設定や表示の間はPrinterのインスタンスは生成されず、printメソッドを呼び出してから生成される。
public class Main {
	public static void main(String[] args) {
		Printable printable = new PrinterProxy("Alice");
		System.out.println("名前は現在" + printable.getPrinterName() + "です");
		printable.setPrinterName("Bob");
		System.out.println("名前は現在" + printable.getPrinterName() + "です");
		printable.print("Hello, world");
	}

}
