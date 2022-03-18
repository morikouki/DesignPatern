import java.util.ArrayList;


// <command list> ::= <command>* end
// <command>が0回以上繰り返して、最後にendがくる
// 0回以上繰り返す<command>を保持するため、CommandListNodeクラスはjava.utill.ArrayList型のフィールドlsitを持っている
public class CommandListNode extends Node {

	private ArrayList list = new ArrayList();

	public void parse(Context context) throws ParseException {
		while (true) {
			// 現在注目しているトークン、context.currentToken()の値がnullなら、もう残りのトークンがない
			//（つまり、ミニ・プログラムを最後まで読んだ）ということになり、「endがない("Missing 'end'")」というメッセージをつけて、例外を投げる
			if (context.currentToken() == null) {
				throw new ParseException("Missing 'end'");

			// 現在注目しているトークンがendなら、<command list>の終わりまできたことになり、
			// endを読み飛ばしてからwhile文をbreakする
			} else if (context.currentToken().equals("end")) {
				context.skipToken("end");
				break;

			// 現在注目しているトークンがendじゃなかったら、それは<command>ということになるので、
			// CommandNodeインスタンスを作ってparseをする。そしてlistにaddする
			} else {
				Node commandNode = new CommandNode();
				commandNode.parse(context);
				list.add(commandNode);
			}
		}
	}

	public String toString() {
		return list.toString();
	}

}
