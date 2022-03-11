package game;
import java.util.ArrayList;
import java.util.List;

// 主人公（Gamer）の状態を表すクラス
// このクラスは同じパッケージないのGamerクラスから自由にアクセスできるように修飾子をつけていない。
public class Memento {

	int money;

	ArrayList fruits;

	// 現在の所持金をえる
	public int getMoney() {
		return money;
	}

	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList();
	}

	void addFruit(String fruit) {
		fruits.add(fruit);
	}

	List getFruits() {
		return (List)fruits.clone();
	}

}
