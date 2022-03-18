import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import command.Command;
import command.MacroCommand;
import drawer.DrawCanvas;
import drawer.DrawCommand;

// サンプルプログラムでは動作させるためのもの
public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

	// 描画履歴を保持する
	// これは、後でDrawCanvasのインスタンスに渡すものと同じ
	// つまり、描画履歴はMainのインスタンスとDrawCanvasのインスタンスで共有されている
	private MacroCommand history = new MacroCommand();

	// 描画領域
	// 初期サイズとして、400×400を与えている
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);

	// 描画した点を消す消去ボタン
	private JButton clearButton = new JButton("clear");

	public Main(String title) {
		super(title);

		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);

		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);

		pack();
		show();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
		}
	}

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {
		Command command = new DrawCommand(canvas, e.getPoint());
		history.append(command);
		command.execute();
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}

	public static void main(String[] args) {
		new Main("Command Pattern Sample");
	}

}
