

import framework.Produce;


// Produceインタフェースを実装している
public class MessageBox implements Produce {

	// 文字列を代わり枠のように囲む文字
	private char decochar;

	public MessageBox(char decochar) {
		this.decochar = decochar;
	}

	// decocharで与えられた文字列を囲み装飾している
	public void use(String s) {
		int length = s.getBytes().length;

		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}

		System.out.println(" ");
		System.out.println(decochar + " " + s + " " + decochar);

		for (int i = 0; i < length + 4; i++) {
			System.out.print(decochar);
		}

		System.out.println(" ");

	}

	// 自分自身の複製を行うメソッド
	public Produce createClone() {
		Produce p = null;

		try {
			// cloneメソッドはJava言語使用で規定されており、自分自身の複製を作成するメソッド
			// 複製を作成するとき、インスタンスが持っているフィールドの値もそのまま新しいインスタンスにコピーされる。
			// cloneメソッドでコピーを行うことができるのが、java.lang.Cloneableインタフェースを実装しているクラスだけ。
			// Java言語のcloneメソッドは、自分のクラス(およびサブクラス）からしか呼び出すことができないので、
			// 他のクラスからの要請で複製を行う場合には、createCloneのような別メソッドでcloneを包んでやる必要がある。
			p = (Produce)clone();

			// Cloneableインタフェースが実装されていない場合には、このCloneNotSupportedExceptionが例外に出てくる
		} catch (CloneNotSupportedException  e) {
			e.printStackTrace();
		}

		return p;
	}

}
