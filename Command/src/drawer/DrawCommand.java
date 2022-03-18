package drawer;

import java.awt.Point;

import command.Command;

// 点の描画命令を表現したもの
public class DrawCommand implements Command {

	// 描画を行う対象を保持します。
	protected Drawable drawable;

	// 描画を行う位置を表す
	// java.awtパッケージで定められているクラスで、X座業とY座標を持つ二次元平面上の位置を表す。
	private Point position;

	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}

	public void execute() {
		drawable.draw(position.x, position.y);
	}
}
