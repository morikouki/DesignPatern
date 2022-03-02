import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;


// 抽象的な工場を使用して抽象的な部品を製造し、
// 抽象的な製品を組み立てている。
// importされているのがfactoryだけであることから分かるように、
// このクラスでは、具体的な部品・製品・工場を一切利用していない。
// 具体的な工場のクラス名は、コマンドラインから指定する。
// 例えば、listfactoryパッケージのListFactoryクラスを使うなら、コマンドラインから
// java Main listfactory.ListFactory　と入力する
public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Main class.name.of.ConcreateFactory");
			System.out.println("Example 1: java Main listfactory.ListFactory");
			System.out.println("Example 2: java Main tablefactory.TableFactory");
			System.exit(0);
		}

		// 引数args[0]をもとにgetFactoryで工場を作り、変数factoryにいれる
		Factory factory = Factory.getFactory(args[0]);

		Link asahi = factory.createLink("朝日新聞", "http://www.asahi.com/");
		Link yomiuri = factory.createLink("読売新聞", "http://www.yomiuri.co.jp/");
		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "http://www.google.com/");

		Tray traynews = factory.createTray("新聞");
		traynews.add(asahi);
		traynews.add(yomiuri);

		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);

		Tray traysearch = factory.createTray("サーチエンジン");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);


		Page page = factory.createPage("LinkPage", "作者");
		page.add(traynews);
		page.add(traysearch);
		page.output();

	}

}
