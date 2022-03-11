package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// ゲームを行う主人公を表現しているクラス
// 所持金とフルーツと乱数発声器を持っている
public class Gamer {

	private int money;

	private List fruits = new ArrayList();

	private Random random = new Random();

	private static String[] fruitsname = {
			"りんご", "ぶどう", "バナナ", "みかん"
	};

	public Gamer(int money) {
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}

	// ゲームの中心となるメソッドで、もしも主人公が破産していなかったら、
	// サイコロを振り、その目に従って所持金やフルーツの個数を変化させる。
	public void bet() {
		int dice = random.nextInt(6) + 1;
		if (dice == 1) {
			money += 100;
			System.out.println("所持金が増えました。");
		} else if (dice == 2) {
			money /= 2;
			System.out.println("所持金が半分になりました。");
		} else if (dice == 6) {
			String f = getFruit();
			System.out.println("フルーツ(" + f + ")をもらいました。");
			fruits.add(f);
		} else {
			System.out.println("何も起こりませんでした。");
		}
	}

	// 現在の状態を保存するメソッド
	// Mementoの作成を行なっている
	// ここでは、現時点での所持金とフルーツをもとに、Mementoのインスタンスを1つ作成している
	// このように作られたMementoのインスタンスは、「現在のGamerインスタンスの状態」を表現している。
	// 写真を撮るように現在の状態をインスタンスに閉じ込めているイメージ。
	// フルーツについては、「おいしい」ものだけを保存している
	public Memento createMemento() {
		Memento memento = new Memento(money);
		Iterator iterator = fruits.iterator();
		while (iterator.hasNext()) {
			String s = (String) iterator.next();
			if (s.startsWith("おいしい")) {
				memento.addFruit(s);
			}
		}
		return memento;
	}

	// createMementoの逆で、アンドゥを行うメソッド
	// 与えられたMementoインスタンスをもとに、自分の状態を復元している。
	// ゲームで「復活の呪文」を唱えるようなもの
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}

	public String tosString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}

	private String getFruit() {
		String prefix = "";
		if (random.nextBoolean()) {
			prefix = "おいしい";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}

}
