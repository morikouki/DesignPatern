
// <repeat command>に対応している
// <repeat command> ::= repeat <number> <command list>
// <number>の部分はint型のnumberフィールド
// <command list>の部分はNode型のcommandListNodeフィールドに格納される
public class RepeatCommandNode extends Node {

	private int number;

	private Node commandListNode;

	// CommandListNodeのインスタンスを作り、parseメソッドを呼び出し、
	// CommandListNodeのparseメソッドの中では、
	// CommandNodeのインスタンスを作り、parseメソッドを呼び出し、
	// CommandNodeのparseメソッドの中では、
	// RepeatCommandNodeのインスタンスを作り、parseメソッドを呼び出し、
	// åRepeatCommandNodeのparseメソッドの中では・・・と再帰的になっている
	// CommandNodeのparseメソッドの中のif文により、いつかはRepeatCommandNodeではなく
	// PrimitiveCommandNodeを作る方に進む。
	// PrimitiveCommandoNodeのparseメソッドからは、他のparseメソッドを呼ばない
	public void parse(Context context) throws ParseException {
		context.skipToken("repeat");
		number = context.currentNumber();
		context.nextToken();
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	}

	public String tosString() {
		return "[repeat " + number + " " + commandListNode + "]";
	}

}
