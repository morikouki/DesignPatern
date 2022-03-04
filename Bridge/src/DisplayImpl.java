
// DisplayImplクラスは、「実装のクラス階層」の最上位に位置する
// DispalyImplクラスは抽象クラスで、rawOpen,rawPrint,rawCloseという3つのメソッドを持っている
// これはDisplayクラスのopen,print,closeにそれぞれ対応していて前処理、表示、後処理をおこなっている
public abstract class DisplayImpl {
	public abstract void rawOpen();
	public abstract void rawPrint();
	public abstract void rawClose();

}
