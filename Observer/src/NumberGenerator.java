import java.util.ArrayList;
import java.util.Iterator;

// 数を生成する抽象クラス
public abstract class NumberGenerator {

	// Observerたちを保持
	private ArrayList observers = new ArrayList();

	// Observerを追加
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	// Observerを削除
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	// Observerへ通知
	public void notifyObservers() {
		Iterator iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer object = (Observer) iterator.next();
			object.update(this);
		}
	}

	// 数を取得する
	public abstract int getNumber();

	// 数を生成する
	public abstract void execute();

}
