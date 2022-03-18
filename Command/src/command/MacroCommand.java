package command;

import java.util.Iterator;
import java.util.Stack;

// 「複数の命令をまとめた命令」を表現している。
// macroの「大きな」という意味で、プログラミングでは、一般に複数の命令をまとめたものを意味する。
public class MacroCommand {

	// 命令の集合
	private Stack commands = new Stack();

	// 実行
	public void execute() {
		Iterator iterator = commands.iterator();
		while (iterator.hasNext()) {
			((Command)iterator.next()).execute();
		}
	}

	// 追加
	// MacroCommandクラスに新たなCommandを追加するメソッド
	public void append(Command command) {

		// これは自分自身を誤ってaddしないように判定している。
		if (command != this) {
			commands.push(command);
		}
	}

	// 最後の命令を削除
	// commandの最後の命令を削除する
	public void undo() {
		if (!commands.empty()) {
			// popメソッドは、pushメソッドで追加した最後の要素を取り出すもの
			commands.pop();
		}
	}

	// 全部削除
	public void clear() {
		commands.clear();
	}


}
