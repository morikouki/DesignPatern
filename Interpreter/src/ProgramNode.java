

// プログラムを表すクラス
// <program> ::= program <command list>
public class ProgramNode extends Node {

	// 自分の後に続く<command list>に対応する構造（ノード）を保持するためのもの
	private Node commandListNode;

	public void parse(Context context) throws ParseException {

		// programという単語を読み飛ばしている
		context.skipToken("program");

		// ミニ・プログラムでは、2個目の文で<command list>がある
		// skipTokenで1つ目の文をスキップし、ここで<command list>に対応したCommandListNodeのインスタンスを生成
		// そのインスタンスのparseメソッドを呼び出している。
		// <command list>がどういう内容になっているかは、ProgramNodeクラスのメソッドには記述されていないことに注意
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}

	public String toString() {
		return "[program " + commandListNode + "]";
	}

}
