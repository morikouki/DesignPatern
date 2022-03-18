

// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {

	private String name;

	public void parse(Context context) throws ParseException {
		name = context.currentToken();
		context.skipToken(name);
		if (!name.contentEquals("go") && !name.contentEquals("right") && !name.equals("left")) {
			throw new ParseException(name + " is undefined");
		}
	}

	public String tosString() {
		return name;
	}

}
