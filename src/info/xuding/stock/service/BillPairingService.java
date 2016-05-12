package info.xuding.stock.service;

import java.util.List;

import javax.annotation.Resource;

import info.xuding.stock.dao.StockDao;
import info.xuding.stock.model.BillPairing;
import info.xuding.stock.model.TopBill;

public class BillPairingService {

    @Resource
    private StockDao stockDao;

    public void start() {
        List<TopBill> topBillList = stockDao.getPayBillList();
        for(TopBill tb : topBillList){
            BillPairing sellBill = stockDao.getBillPairOnSell(tb);
            if(sellBill==null){
                sellBill = new BillPairing();
            }
        }
    }
}
