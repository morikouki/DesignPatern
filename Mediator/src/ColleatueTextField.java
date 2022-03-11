import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

// java.awt.TextFieldのサブクラスでColleagueインタフェースを実装している。
// またこのクラスは、java.awt.event.TextListenerインタフェースも実装している。
// こうするのは、テキストの内容が変化したことをtextValueChangedメソッドでキャッチしたいから。
public class ColleatueTextField extends TextField implements TextListener, Colleague {

	private Mediator mediator;

	public ColleatueTextField(String text, int columns) {
		super(text, columns);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);

		// 有効時に背景色を「白」、無効時に背景色を「明るい灰色」にしている
		setBackground(enabled ? Color.white : Color.lightGray);
	}

	// TextListenerインタフェースのためのメソッド
	// テキストの内容に変更があった場合にAWTのフレームワーク側から呼び出される。
	public void textValueChanged(TextEvent e) {

		// 相談役に「ちょっとすみません。私の文字列内容が変化したことを報告します。どうぞよろしくお願いします。」と伝えている
		mediator.colleagueChanged();
	}

}
