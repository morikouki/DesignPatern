
// BookShelfクラスのスキャンを行うクラス
public class BookShelfIterator implements Iterator {

	// BookShelfIteratorがスキャンする本棚
	private BookShelf bookShelf;
	
	// 現在注目している本を指す添字
	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	// 次の本があるか無いかを調べる
	public boolean hasNext() {
		if (index < bookShelf.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	// 現在注目している本を返し、さらに次に進めている
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}


}
