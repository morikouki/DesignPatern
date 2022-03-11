package pagemaker;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// データベース名を指定して、それに対応したPropertiesを作成するクラス
// このクラスではインスタンスを作らず、getPropertiesというstaticメソッドを介してPropertiesのインスタンスを取得する
public class Database {

	// new でインスタンスを生成させないようにprivateにしている
	private Database() {

	}

	public static Properties getProperties(String dbname) {
		String filename = dbname + ".txt";
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("Warning: " + filename + " is not found.");
		}
		return properties;
	}

}
