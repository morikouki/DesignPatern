import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 「相談役」のクラス

public class LoginFrame extends Frame implements ActionListener, Mediator {

	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleatueTextField textUser;
	private ColleatueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	// Colleagueたちを生成し、配置した後に表示を行う
	// 主に以下の仕事をしている
	//	・背景色の設定
	//	・レイアウトマネージャーの設定（子ウィンドウを縦4個*横2個に配置する）
	//	・createColleaguesメソッドでColleagueの生成
	//	・Colleagueの配置
	//	・初期状態の設定
	//	・表示
	public LoginFrame(String title) {
		super(title);
		setBackground(Color.lightGray);

		// レイアウトマネージャを使って4*2のグリッドを作る
		setLayout(new GridLayout(4, 2));

		// Colleagueたちの生成
		// 各Colleagueに対してsetMediatorを呼び出し、
		// 「あなたの相談役は私だからね、何かあったら知らせるんだよ」と言っておく。
		// 各Listenerの設定も行なっている。これは、各ListenerがAWTのフレームワークから適切に呼び出されるようにするため。
		createColleagues();

		// 配置
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);

		// 有効・無効の初期設定
		// 最も大事なメソッドで、「表示の有効・無効を設定する複雑な処理」を行なっている
		// 全ての Colleagueの相談が、ここのcolleatueChangedメソッドに集結している
		colleagueChanged();

		// 表示
		pack();
		show();
	}

	// Colleagueたちを生成する
	public void createColleagues() {
		// 生成
		CheckboxGroup group = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", group, true);
		checkLogin = new ColleagueCheckbox("Login", group, false);
		textUser = new ColleatueTextField("", 10);
		textPass = new ColleatueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");

		// Mediatorのセット
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);

		// Listenerのセット
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// Colleagueからの通知で各Colleagueの有効・無効を判定する
	public void colleagueChanged() {
		if (checkGuest.getState()) {
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		} else {
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}

	// textUserまたはtextPassの変更があった
	// 各Colleagueの有効・無効を判定する
	private void userpassChanged() {
		if (textUser.getText().length() > 0) {
			textPass.setColleagueEnabled(true);
			if (textPass.getText().length() > 0) {
				buttonOk.setColleagueEnabled(true);
			} else {
				buttonOk.setColleagueEnabled(false);
			}
		} else {
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
	}

}
