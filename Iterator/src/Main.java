
public class Main {

	public static void main(String[] args) {

		// 本が4つ入る本棚の作成
		BookShelf bookShelf = new BookShelf(4);

		// 本の作成
		bookShelf.appendBook(new Book("白雪姫"));
		bookShelf.appendBook(new Book("赤ずきん"));
		bookShelf.appendBook(new Book("三匹のこぶた"));
		bookShelf.appendBook(new Book("みにくいアヒルの子"));

		// 本棚をスキャンするためのIteratorインスタンス
		Iterator it = bookShelf.iterator();

		// 本がある限りループを繰り返す
		while (it.hasNext()) {

			// 本を1冊1冊調べている
			// (Book)でObject型からBookへ変換している
			Book book = (Book)it.next();
			System.out.println(book.getName());
		}

	}

}
