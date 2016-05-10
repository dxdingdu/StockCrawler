package info.xuding.stock.model;

/**
 * @author xuding
 *
 */
public class TopBill {

	String organization; // 营业部名称
	double buyAmount; // 买入金额/万
	String buyPercent; // 占总成交比例
	double sellAmount; // 卖出金额/万
	String sellPercent; // 占总成交比例
	double netAmount; // 净额/万
	double turnover; // 成交量/手

	String date; // 日期
	String stockName; // 股票
	String stockCode; // 股票
	double closingPrice; // 收盘价
	double openingPrice; // 开盘价
	double change; // 涨跌

	public TopBill(String date, String stockName, String stockCode, double closingPrice, double openingPrice,
			double change) {
		super();
		this.date = date;
		this.stockName = stockName;
		this.stockCode = stockCode;
		this.closingPrice = closingPrice;
		this.openingPrice = openingPrice;
		this.change = change;
	}

	public TopBill(String stockName, StockInfo stockInfo) {
		super();
		this.date = stockInfo.stockDate;
		this.stockName = stockName;
		this.stockCode = stockInfo.stockCode;
		this.closingPrice = stockInfo.closingPrice;
		this.openingPrice = stockInfo.openingPrice;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public double getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(double buyAmount) {
		this.buyAmount = buyAmount;
	}

	public String getBuyPercent() {
		return buyPercent;
	}

	public void setBuyPercent(String buyPercent) {
		this.buyPercent = buyPercent;
	}

	public double getSellAmount() {
		return sellAmount;
	}

	public void setSellAmount(double sellAmount) {
		this.sellAmount = sellAmount;
	}

	public String getSellPercent() {
		return sellPercent;
	}

	public void setSellPercent(String sellPercent) {
		this.sellPercent = sellPercent;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}

	public double getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

}
