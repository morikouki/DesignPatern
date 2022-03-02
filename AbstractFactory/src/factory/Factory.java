package factory;

// 抽象的な工場
public abstract class Factory {

	// クラス名を指定して具体的な工場のインスタンスを作成するもの
	// 例えば「"listfactory.ListFactory"」のように、
	// 作成する具体的な工場のクラス名を文字列で指定する。
	// このメソッドでは具体的な工場のインスタンスを作るが、戻り値は抽象的な工場であることに注意
	public static Factory getFactory(String classname) {
		Factory factory = null;

		try {
			// fornameメソッドを使用して、そのクラスを動的に読み込む
			// そしてnewInstanctメソッドを使用して、そのクラスのインスタンスを1個作成する
			factory = (Factory)Class.forName(classname).getDeclaredConstructor().newInstance();;
		} catch (ClassNotFoundException e) {
			System.out.println("クラス" + classname + " が見つかりません。");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 作成したインスタンスを返す
		return factory;
	}

	// 下記の抽象メソッドはこの抽象的な工場で部品や製品を作成するときに用いるメソッド
	// これらはどれも抽象メソッドになっていて、実際の具体的な部品や製品の作成はFactoryサブクラスに任せている。
	public abstract Link createLink(String caption, String url);
	public abstract Tray createTray(String caption);
	public abstract Page createPage(String title, String author);

}
