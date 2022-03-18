
// 代理人の役割を果たすもの
// setPrinterNameやgetPrinterNameを何回呼び出しても、Printerのインスタンスは生成されない。
// Printerのインスタンスが生成されるのは、「本人」が本当に必要になったとき。
// PrinterクラスはPrinterProxyの存在を知らない。
// 自分がPrinterProxy経由で呼ばれているのか、それとも直接呼ばれているのかPrinterクラスは知らない。
// でもPrinterProxyはPrinterを知っている。
public class PrinterProxy implements Printable {

	// 名前を保持
	private String name;

	// 本人を保持
	private Printer real;

	public PrinterProxy() {

	}

	public PrinterProxy(String name) {
		this.name = name;
	}

	public synchronized void setPrinterName(String name) {

		// 本人がすでに作られていたら、本人にも設定する
		if (real != null) {
			real.setPrinterName(name);
		}
		this.name = name;
	}

	public String getPrinterName() {
		return name;
	}

	public void print(String string) {
		// realizeというのは「具現化する」という意味
		// realフィールドには本人が保持されているので、printを呼び出す。これは「委譲」
		realize();
		real.print(string);
	}

	private synchronized void realize() {
		if (real == null) {
			real = new Printer(name);
		}
	}

}
