package info.xuding.stock.utils;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import info.xuding.stock.model.StockInfo;

public class StockInfoUtils {

	static Map<String, StockInfo> map = new HashMap<>();

	public static StockInfo getStockInfo(String stockCode, String date) {
		String key = stockCode +"_"+ date;
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			String newStockCode;
			if (stockCode.startsWith("60") || stockCode.startsWith("58")) {
				newStockCode = "sh" + stockCode;
			} else {
				newStockCode = "sz" + stockCode;
			}
			String newDate = date.replace("-", "");
			String data = SimpleHttpLoader.get("http://biz.finance.sina.com.cn/stock/flash_hq/kline_data.php?&symbol="
					+ newStockCode + "&end_date=" + newDate + "&begin_date=" + newDate);
			Document document = Jsoup.parse(data);
			Elements contents = document.select("content");
			for (Element element : contents) {
				if (date.equals(element.attr("d"))) {
					StockInfo stockInfo = new StockInfo();
					stockInfo.setStockCode(stockCode);
					stockInfo.setStockDate(date);
					stockInfo.setOpeningPrice(NumberUtils.doubleValue(element.attr("o")));
					stockInfo.setClosingPrice(NumberUtils.doubleValue(element.attr("c")));
					stockInfo.setHighPrice(NumberUtils.doubleValue(element.attr("h")));
					stockInfo.setLowPrice(NumberUtils.doubleValue(element.attr("l")));
					stockInfo.setTurnover(NumberUtils.doubleValue(element.attr("v")));
					map.put(key, stockInfo);
					return stockInfo;
				}
			}
			System.err.println("获取股票基本信息出错！【URL】http://biz.finance.sina.com.cn/stock/flash_hq/kline_data.php?&symbol="
					+ newStockCode + "&end_date=" + newDate + "&begin_date=" + newDate);
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(getStockInfo("603028", "2016-05-09"));
		System.out.println(getStockInfo("603028", "2016-05-10"));
		System.out.println(getStockInfo("603028", "2016-05-09"));
	}
}
