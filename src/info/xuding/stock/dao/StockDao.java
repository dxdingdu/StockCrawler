package info.xuding.stock.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import info.xuding.stock.model.BillPairing;
import info.xuding.stock.model.TopBill;

/**
 * @author xuding
 *
 */
public interface StockDao {

    @Insert("INSERT INTO `topbill` (`stockName`, `stockCode`, `date`, `closingPrice`, `openingPrice`, `change`, `organization`, `buyAmount`, `buyPercent`, `sellAmount`, `sellPercent`, `netAmount`, `turnover`)"
            + " VALUES (#{stockName}, #{stockCode}, #{date}, #{closingPrice}, #{openingPrice}, #{change}, #{organization}, #{buyAmount}, #{buyPercent}, #{sellAmount}, #{sellPercent}, #{netAmount}, #{turnover});")
    public int add(TopBill topBill);

    @Select("select ts from ts_version where id=1")
    public Date getTs();

    @Update("update ts_version set ts=#{date} where id=1")
    public void setTs(Date date);

    @Select("select * from topbill where buyAmount>100 and organization!='机构专用' group by stockCode, date, organization")
    public List<TopBill> getPayBillList();

    @Select("select * from topbill where sellAmount>100 and organization!='机构专用' group by stockCode, date, organization")
    public List<TopBill> getSellOrderList();

    @Select("select * from bill_pairing where sellDate is not null and sellDate > #{topBill.date} order by sellDate asc LIMIT 1")
    public BillPairing getBillPairOnSell(TopBill topBill);
}
