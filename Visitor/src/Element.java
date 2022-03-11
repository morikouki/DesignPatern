

// 「訪問者」を受け入れるインタフェース
public interface Element {

	// acceptは「受け入れる」という意味
	// 訪問者であるVisitorクラスを受け入れている
	public abstract void accept(Visitor visitor);

}
