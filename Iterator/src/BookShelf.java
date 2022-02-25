import java.util.ArrayList;
import java.util.List;

// 本棚を表現しているクラス
// このクラスを集合体として扱うためにAggregateインタフェースを実装している。
public class BookShelf implements Aggregate {

//	【練習問題】
//	配列ではなくjava.util.ArrayListを使用し、本棚の大きさを超えても本を追加できるようにしなさい。
//  コメントアウトしている箇所は練習問題対応箇所

//	private Book[] books;
	private List<Book> books;
//	private int last = 0;

//  配列の長さを決めなくていいので不要
	public BookShelf(int maxsize) {
//		Mainクラスの実装を修正しないようにするためにここでインスタンス作成
//		正直Mainクラスでインスタンス作成時の引数を削除しても良い
//		this.books = new Book[maxsize];
		this.books = new ArrayList<Book>(maxsize);
	}

	public Book getBookAt(int index) {
//		配列からの取得をArrayListからの取得に変更
//		return books[index];
		return books.get(index);

	}

	public void appendBook(Book book) {
//		本の追加はArrayListのメソッドを使用
//		this.books[last] = book;

		this.books.add(book);

//		配列の長さをカウントする必要なし
//		last++;
	}

	public int getLength() {
//		配列のながさはArrayListのメソッドで対応
//		return last;
		return books.size();
	}

	public Iterator iterator() {
		return new BookShelfIterator(this);
	}

}
