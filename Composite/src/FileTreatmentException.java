
// ファイルに対してaddメソッドを呼び出してしまった時に投げられる例外
// この例外はJavaのクラスライブラリで提供されているのではなく独自で定義している。
public class FileTreatmentException extends RuntimeException {

	public FileTreatmentException() {

	}

	public FileTreatmentException(String msg) {
		super(msg);
	}

}
