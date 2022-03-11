
public class NoSupport extends Support {

	public NoSupport(String name) {
		super(name);
	}

	// 解決用メソッド
	protected boolean resolve(Trouble trouble) {
		return false;
	}

}
