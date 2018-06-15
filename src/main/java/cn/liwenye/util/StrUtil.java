package cn.liwenye.util;

/**
 * @author liwenye on 2018/01/02
 */
public class StrUtil {
	public static String LEFT_MARK = "《";

	public static String RIGHT_MARK = "》";

	public static String getBookName(String book) {
		String bookName = "";
		if (book.contains(LEFT_MARK) && book.contains(RIGHT_MARK)) {
			int begin = book.indexOf(LEFT_MARK);
			int end = book.indexOf(RIGHT_MARK);
			bookName = book.substring(begin, end + 1).trim();
		}
		return bookName;
	}
}
