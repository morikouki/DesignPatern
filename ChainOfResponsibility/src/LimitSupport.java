
// limitで指定した番号未満のトラブルを解決するクラス
public class LimitSupport extends Support {

	private int limit;

	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}

	// この番号未満なら解決できる
	// 解決用メソッド
	protected boolean resolve(Trouble trouble) {

		// 判断の後、単にtrueを返しているだけだが、本来ならここでトラブルを「解決してやる」必要がある。
		if (trouble.getNumber() < limit) {
			return true;
		} else {
			return false;
		}
	}

}
