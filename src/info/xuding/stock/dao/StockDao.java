package info.xuding.stock.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import info.xuding.stock.model.StockTransaction;
import info.xuding.stock.model.TopBill;

/**
 * @author xuding
 *
 */
public interface StockDao {

    @Insert("INSERT INTO `topbill_price` (`stockName`, `stockCode`, `date`, `closingPrice`, `openingPrice`, `change`, `organization`, `buyAmount`, `buyPercent`, `sellAmount`, `sellPercent`, `netAmount`, `turnover`)"
            + " VALUES (#{stockName}, #{stockCode}, #{date}, #{closingPrice}, #{openingPrice}, #{change}, #{organization}, #{buyAmount}, #{buyPercent}, #{sellAmount}, #{sellPercent}, #{netAmount}, #{turnover});")
    public int add(TopBill topBill);

    @Select("select ts from ts_version where id=1")
    public Date getTs();

    @Update("update ts_version set ts=#{date} where id=1")
    public void setTs(Date date);

    @Select("select * from topbill_price")
    public List<TopBill> getTopBillList();

    @Select("select * from StockTransaction where sellDate")
    public StockTransaction getStockSell(String stockCode, String organization, Date buyDate);
}
