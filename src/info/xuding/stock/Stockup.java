package info.xuding.stock;

import org.hibernate.classic.Session;

import info.xuding.stock.model.BillPairing;
import info.xuding.stock.utils.HibernateUtils;

public class Stockup {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();
        BillPairing billPairing = new BillPairing();

        billPairing.setBuyAmount(3432);
        billPairing.setBuyDate("2016-05-12");

        session.save(billPairing);
        session.getTransaction().commit();

    }
}
