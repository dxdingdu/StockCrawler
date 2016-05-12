package info.xuding.stock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import info.xuding.stock.dao.StockDao;
import info.xuding.stock.processor.StockPageProcessor;
import us.codecraft.webmagic.Spider;

/**
 * @author xuding
 *
 */
public class MainCrawler {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext*.xml");
		StockPageProcessor stockPageProcessor = applicationContext.getBean(StockPageProcessor.class);
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<String> urls = new ArrayList<String>();
		StockDao stockDao = applicationContext.getBean(StockDao.class);
		Date ts = stockDao.getTs();
		if (DateUtils.isSameDay(ts, calendar.getTime())) {
			return;
		}
		stockDao.setTs(calendar.getTime());
		do {
			if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				String dateStr = df.format(calendar.getTime());
				urls.add("http://data.10jqka.com.cn/market/longhu/date/" + dateStr
						+ "/cate/ALL/field/REMARK/page/1/order/desc/ajax/1");
				urls.add("http://data.10jqka.com.cn/market/longhu/date/" + dateStr
						+ "/cate/ALL/field/REMARK/page/2/order/desc/ajax/1");
			}
			calendar.add(Calendar.DAY_OF_YEAR, -1);
		} while (!DateUtils.isSameDay(calendar.getTime(), ts));
		Spider.create(stockPageProcessor).addUrl(urls.toArray(new String[] {})).thread(5).run();
	}
}
