import framework.Manager;
import framework.Produce;

public class Main {

	public static void main(String[] args) {

		// 準備
		// Managerのインスタンスを作成する
		// UnderlinePenのインスタンスとMessageBoxのインスタンスを名前付きで登録
		Manager manager = new Manager();
		UnderlinePen upen = new UnderlinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("strong message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);


		// 生成
		Produce p1 = manager.create("strong message");
		p1.use("Hello, world.");
		Produce p2 = manager.create("warning box");
		p2.use("Hello, world");
		Produce p3 = manager.create("slash box");
		p3.use("Hello, world");

	}

}
