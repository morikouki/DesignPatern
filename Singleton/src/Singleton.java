
public class Singleton {

	// singletonを定義し、Singletonクラスをnewしている
	// この初期化はSingletonクラスのロード時に一度だけ行われる。
	private static Singleton singleton = new Singleton();

	// privateにしているのは、Singletonクラス外からnewするのを防ぐため
	private Singleton() {
		System.out.println("インスタンスを生成しました。");
	}

	// インスタンスを取得するメソッドが必ず必要になる
	public static Singleton getInstance() {
		return singleton;
	}

}
