
// 「飾り枠」を表す抽象クラス
// displayの中身がStringDisplayのインスタンスとは限らない。なにしろ、BorderもDisplayのサブクラスなので、
// displayフィールドの中身はさらに別の飾り枠（Borderクラスのサブクラスのインスタンス）かもしれない。
// そして、その飾り枠もまたさらにdisplayフィールドを持っていて....っとなっている。
public abstract class Border extends Display {

	// これは、飾り枠が包んでいる「中身」を指すもの
	protected Display display;

	protected Border(Display display) {
		this.display = display;
	}

}
