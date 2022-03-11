
// 「観察者」を表現するインタフェース
// 具体的な観察者は、このインタフェースを実装する

public interface Observer {

	// NumberGeneratorは数を生成する
	// 「私の内容が更新されました。表示の方も更新してください」とObserverに伝えるためのメソッド
	public abstract void update(NumberGenerator generator);

}
