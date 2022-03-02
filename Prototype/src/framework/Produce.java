package framework;

// Produceインタフェースは複製を可能にするためのもの
// java.lang.Cloneableインタフェースを継承している。
// このインタフェースを実装しているクラスのインスタンスは、cloneメソッドを使って自動的に複製を行うことができるようになる。
// Cloneableインタフェースは、単なる印付として用いられているだけであり、このインタフェースが宣言しているメソッドはない。
public interface Produce extends Cloneable {

	// useメソッドは、「使う」ためのもので、「使う」が何を意味しているかはサブクラスに任せている。
	public abstract void use(String s);

	// このメソッドはインスタンスの複製を行うためのもの
	public abstract Produce createClone();

}
