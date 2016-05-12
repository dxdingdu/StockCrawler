package info.xuding.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill_pairing")
public class BillPairing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "stockCode")
    String stockCode;

    @Column(name = "stockName")
    String stockName;

    @Column(name = "organization")
    String organization;

    @Column(name = "buyDate")
    String buyDate;

    @Column(name = "buyPrice")
    double buyPrice;

    @Column(name = "buyAmount")
    double buyAmount;

    @Column(name = "buyPiece")
    double buyPiece;

    @Column(name = "sellDate")
    String sellDate;

    @Column(name = "sellPrice")
    double sellPrice;

    @Column(name = "sellAmount")
    double sellAmount;

    @Column(name = "sellPiece")
    double sellPiece;

    @Column(name = "priceRange")
    double priceRange;

    @Column(name = "days")
    int days;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(double buyAmount) {
        this.buyAmount = buyAmount;
    }

    public double getBuyPiece() {
        return buyPiece;
    }

    public void setBuyPiece(double buyPiece) {
        this.buyPiece = buyPiece;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(double sellAmount) {
        this.sellAmount = sellAmount;
    }

    public double getSellPiece() {
        return sellPiece;
    }

    public void setSellPiece(double sellPiece) {
        this.sellPiece = sellPiece;
    }

    public double getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(double priceRange) {
        this.priceRange = priceRange;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

}
