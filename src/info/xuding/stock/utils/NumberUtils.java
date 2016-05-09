package info.xuding.stock.utils;

public class NumberUtils {

	public static double doubleValue(String str) {
		try {
			return Double.valueOf(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
