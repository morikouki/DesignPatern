import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUIを使って金庫警備システムを実現するもの
public class SafeFrame extends Frame implements ActionListener, Context {

	// 画面上に表示される部品
	private TextField textClcok = new TextField(60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonUse = new Button("金庫使用");
	private Button buttonAlarm = new Button("非常ベル");
	private Button buttonPhone = new Button("通常通話");
	private Button buttonExit = new Button("終了");

	// 金庫の現在の状態を表すためのもの
	private State state = DayState.getInstance();

	// ・背景色の設定
	// ・レイアウトマネージャの設定
	// ・部品の配置
	// ・リスナーの設定
	// を行なっている
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());

		// textClockを配置
		add(textClcok, BorderLayout.NORTH);
		textClcok.setEditable(false);

		// textScreenを配置
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);

		// パネルにボタンを格納
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);

		// そのパネルを配置
		add(panel, BorderLayout.SOUTH);

		// 表示
		pack();
		show();

		// リスナーの設定
		// 引数には「ボタンが押されたときに呼び出されるインスタンス」を指定している。
		// これは、ActionListenerインタフェースを実装している必要がある。
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}

	// ボタンが押されたときに呼び出されるメソッド
	// どのボタンが押されているかを調査し、それに合わせた処理をしている
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		if (e.getSource() == buttonUse) {
			state.doUse(this);
		} else if (e.getSource() == buttonAlarm) {
			state.doAlarm(this);
		} else if (e.getSource() == buttonPhone) {
			state.doPhone(this);
		} else if (e.getSource() == buttonExit) {
			System.exit(0);
		} else {
			System.out.println("?");
		}
	}

	// 現在時刻を指定した時刻に設定する
	public void setClock(int hour) {
		String clockString = "現在時刻は";
		if (hour < 10) {
			clockString += "0" + hour + ":00";
		} else {
			clockString += hour + ":00";
		}
		System.out.println(clockString);
		textClcok.setText(clockString);
		state.doClock(this, hour);
	}

	// 状態の遷移が起こるときに呼び出されるメソッド
	// 現在の状態を表しているフィールドに、状態を表すクラスのインスタンスを代入することが、状態遷移に相当する
	public void changeState(State state) {
		System.out.println(this.state + "から" + state + "へ状態が変化しました。");
		this.state = state;
	}

	// 警備センターの呼び出しを表現したもの
	public void callSecurityCenter(String msg) {
		textScreen.append("call!" + msg + "¥n");
	}

	// 警備センターの記録を表現したもの
	public void recordLog(String msg) {
		textScreen.append("record ..." + msg + "¥n");
	}
}
