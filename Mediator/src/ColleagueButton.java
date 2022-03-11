import java.awt.Button;

// java.awt.Buttonのサブクラス
// LoginFrameクラスと強調動作を行う
public class ColleagueButton extends Button implements Colleague {

	// setMediatorで渡されてくるMediatorオブジェクトを保持
	private Mediator mediator;

	public ColleagueButton(String caption) {
		super(caption);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	// javaのGUIで定義されているsetEnabledメソッドを呼び出して、有効・無効を設定する
	// trueではボタンを押せるが、falseじゃ押せない
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}

}
