
// 練習問題のMainクラス
public class FileMain {
	public static void main(String[] args) {
		FileIO file = new FileProperties();
		try {
			file.readFromFile("file.txt");
			file.setValue("year", "2004");
			file.setValue("month", "4");
			file.setValue("day", "21");;
			file.writeToFile("newfile.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
