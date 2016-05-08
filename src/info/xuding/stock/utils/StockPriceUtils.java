package info.xuding.stock.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class StockPriceUtils {

	static Map<String, Double> map = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static double getStockPrice(String stockCode) {
		try {
			if (map.containsKey(stockCode)) {
				return map.get(stockCode);
			} else {
				String data = SimpleHttpLoader
						.get("http://qd.10jqka.com.cn/quote.php?return=json&cate=real&type=stock&code=" + stockCode);
				data = data.substring(data.indexOf('(') + 1, data.lastIndexOf(')'));
				Map<String, Object> result = JSON.parseObject(data, Map.class);
				Map<String, Object> mData = (Map<String, Object>) result.get("data");
				Map<String, Object> mStock = (Map<String, Object>) mData.get(stockCode);
				String sPrice = (String) mStock.get("10");
				Double price = Double.valueOf(sPrice);
				map.put(stockCode, price);
				return price;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0f;
		}
	}

	public static void main(String[] args) {
		System.out.println(getStockPrice("603028"));
		System.out.println(getStockPrice("603028"));
	}
}
