package drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable {

	// 描画色
	private Color color = Color.red;

	// 描画する点の半径
	private int radius = 6;

	// 履歴
	// 自分が描画すべき命令の集合を保持している。
	private MacroCommand history;

	// コンストラクタ
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
	}

	// 履歴全体を再描画する
	public void paint(Graphics g) {
		history.execute();
	}

	// 描画
	public void draw(int x, int y) {
		Graphics graphics = getGraphics();
		graphics.setColor(color);
		graphics.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

}
