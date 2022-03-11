
// トラブルを解決する連鎖を作るための抽象クラス。
// nextフィールドは、たらい回しする先を指す。
// setNextメソッドはたらい回しする先を設定する。
public abstract class Support {

	// このトラブル解決者の名前
	private String name;

	// たらい回しの先
	private Support next;

	// トラブル解決者の生成
	public Support(String name) {
		this.name = name;
	}

	// たらい回しの先を設定
	public Support setNext(Support next) {
		this.next = next;
		return next;
	}

	// トラブル解決の手順
	public final void support(Trouble trouble) {

		// falseなら「次の人」にたらい回しする。
		// 「次の人」がいない場合には、自分が連鎖の最後であり、誰も処理できなかったことになるので、そのことを表示する
		if (resolve(trouble)) {
			done(trouble);
		} else if (next != null) {
			next.support(trouble);
		} else {
			fail(trouble);
		}
	}

	// 文字表現
	public String toString() {
		return "[" + name + "]";
	}

	// 解決用メソッド
	protected abstract boolean resolve(Trouble trouble);

	// 解決
	protected void done(Trouble trouble){
		System.out.println(trouble + " is resolved by " + this + ".");
	}

	// 未解決
	protected void fail(Trouble trouble) {
		System.out.println(trouble + " cannnot be resolved.");
	}

}
