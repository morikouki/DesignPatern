
// <command> ::= <repeat command> | <primitive command>
public class CommandNode extends Node {
	
	// <repeat command>に対応するRepeatCommandNodeクラスのインスタンス　または
	// <primitive command>に対応するPrimitiveCommandNodeクラスのインスタンスを格納する
	private Node node;
	
	public void parse(Context context) throws ParseException {
		if (context.currentToken().equals("repeat")) {
			node = new RepeatCommandNode();
			node.parse(context);
		} else {
			node = new PrimitiveCommandNode();
			node.parse(context);
		}
	}
	
	public String toString() {
		return node.toString();
	}

}
