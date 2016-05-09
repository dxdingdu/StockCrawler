package info.xuding.stock.processor;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import info.xuding.stock.dao.StockDao;
import info.xuding.stock.model.TopBill;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * @author xuding
 *
 */
@Component
public class StockPageProcessor implements PageProcessor {

	@Resource
	private StockDao stockDao;

	@Override
	public void process(Page page) {
		String jsonStr = page.getRawText();
		if (jsonStr.startsWith("var ")) {
			jsonStr = page.getRawText().substring(jsonStr.indexOf('=') + 1);
			JSONObject jsonObject = JSON.parseObject(jsonStr);
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject stockObject = (JSONObject) jsonArray.get(i);
				page.addTargetRequest("http://data.eastmoney.com/stock/lhb," + stockObject.getString("Tdate") + ","
						+ stockObject.getString("SCode") + ".html");
			}
		}
		String stockInfo = page.getHtml().$("div.tit a").xpath("tidyText()").toString();
		if (stockInfo == null) {
			return;
		}
		String stockName = stockInfo.substring(0, stockInfo.indexOf('('));
		String stockCode = stockInfo.substring(stockInfo.indexOf('(') + 1, stockInfo.lastIndexOf(')'));
		String stockDate = page.getHtml().$("div.left.con-br").xpath("tidyText()").toString().substring(0, 10);
		String closingPrice = page.getHtml().$("div.data-tips:nth-child(1) div.right > span:nth-child(1)")
				.xpath("tidyText()").toString();
		String priceChange = page.getHtml().$("div.data-tips:nth-child(1) div.right > span:nth-child(2)")
				.xpath("tidyText()").toString();
		priceChange = priceChange.substring(0, priceChange.length() - 2);
		{
			Selectable table = page.getHtml().$("#tab-2");
			List<Selectable> list = table.$("tbody > tr").nodes();
			for (int i = 0; i < list.size(); i++) {
				Selectable selectable = list.get(i);
				TopBill topBill = new TopBill(stockDate, stockName, stockCode, Double.valueOf(closingPrice), 0,
						Double.valueOf(priceChange));
				topBill.setOrganization(selectable.xpath("tr/td[2]/div[1]/a[2]/text()").toString());
				topBill.setBuyAmount(Double.valueOf(selectable.xpath("tr/td[3]/text()").toString()));
				topBill.setBuyPercent(selectable.xpath("tr/td[4]/text()").toString());
				topBill.setSellAmount(Double.valueOf(selectable.xpath("tr/td[5]/text()").toString()));
				topBill.setSellPercent(selectable.xpath("tr/td[6]/text()").toString());
				topBill.setNetAmount(Double.valueOf(selectable.xpath("tr/td[7]/text()").toString()));
				stockDao.add(topBill);
			}
		}
		{
			Selectable table = page.getHtml().$("#tab-4");
			List<Selectable> list = table.$("tbody > tr").nodes();
			for (int i = 0; i < list.size(); i++) {
				Selectable selectable = list.get(i);
				TopBill topBill = new TopBill(stockDate, stockName, stockCode, Double.valueOf(closingPrice), 0,
						Double.valueOf(priceChange));
				topBill.setOrganization(selectable.xpath("tr/td[2]/div[1]/a[2]/text()").toString());
				topBill.setBuyAmount(Double.valueOf(selectable.xpath("tr/td[3]/text()").toString()));
				topBill.setBuyPercent(selectable.xpath("tr/td[4]/text()").toString());
				topBill.setSellAmount(Double.valueOf(selectable.xpath("tr/td[5]/text()").toString()));
				topBill.setSellPercent(selectable.xpath("tr/td[6]/text()").toString());
				topBill.setNetAmount(Double.valueOf(selectable.xpath("tr/td[7]/text()").toString()));
				stockDao.add(topBill);
			}
		}
	}

	@Override
	public Site getSite() {
		return Site.me().setRetryTimes(3).setSleepTime(0);
	}

	// public static void main(String[] args) {
	// ApplicationContext applicationContext = new
	// ClassPathXmlApplicationContext(
	// "classpath:/spring/applicationContext*.xml");
	// StockPageProcessor stockPageProcessor =
	// applicationContext.getBean(StockPageProcessor.class);
	// Spider.create(stockPageProcessor).addUrl("http://data.10jqka.com.cn/market/lhbcjmx/code/000780/date/2016-04-26/ajax/").thread(5)
	// .run();
	// }

}
