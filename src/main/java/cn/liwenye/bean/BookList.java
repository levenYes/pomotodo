package cn.liwenye.bean;

import java.util.Date;

/**
 * @author liwenye on 2018/01/08
 */
public class BookList {
    String book;

    Date lastDay;

    int totalPomos;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Date getLastDay() {
        return lastDay;
    }

    public void setLastDay(Date lastDay) {
        this.lastDay = lastDay;
    }

    public int getTotalPomos() {
        return totalPomos;
    }

    public void setTotalPomos(int totalPomos) {
        this.totalPomos = totalPomos;
    }

}
