import framework.Produce;


// MessageBoxとほぼ同じ動きをする
public class UnderlinePen implements Produce {

	// この文字が文字列の下線になって表示される
	private char ulchar;

	public UnderlinePen(char ulchar) {
		this.ulchar = ulchar;
	}

	public void use(String s) {
		int length = s.getBytes().length;

		System.out.println("¥" + s + "¥");

		System.out.print(" ");

		for (int i = 0; i < length; i++) {
			System.out.print(ulchar);
		}

		System.out.println(" ");
	}

	public Produce createClone() {
		Produce p = null;

		try {
			p =(Produce)clone();
		} catch (CloneNotSupportedException  e) {
			e.printStackTrace();
		}

		return p;
	}



}
