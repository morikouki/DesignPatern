package framework;

import java.util.HashMap;

// Produceインタフェースを使用してインスタンスの複製を行うクラス
public class Manager {

	// インスタンスの名前とインスタンスの対応関係を表現したもの
	private HashMap showcase = new HashMap();

	// 製品の名前とProduceインタフェースが渡されるとその1組をshowcaseに登録する。
	// ここで渡されるprotoはその実際のクラスはわからないが、useやcreateCloneメソッドを使用できる
	// Produceインタフェースを実装したクラスになっている。
	public void register(String name, Produce proto) {
		showcase.put(name, proto);
	}

	public Produce create(String protoname) {
		Produce p = (Produce)showcase.get(protoname);
		return p.createClone();
	}

}
