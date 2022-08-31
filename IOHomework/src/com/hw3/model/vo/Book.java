package com.hw3.model.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book implements Serializable {
    
    private String title;       //도서명
    private String author;      //저자
    private int price;          //가격
    private Calendar dates;     //출판날짜
    private double discount;    //할인율


    //기본 생성자
    public Book() {}

    //5개의 초기값을 받는 매개변수 생성자
    public Book(String title, String author, int price, Calendar dates, double discount) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.dates = dates;
        this.discount = discount;
    }


    //setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDates(Calendar dates) {
        this.dates = dates;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    //getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public Calendar getDates() {
        return dates;
    }

    public double getDiscount() {
        return discount;
    }


    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 출간");
        String dateStr = simpleDateFormat.format(dates.getTime());
        return  title + ' ' + author + ' ' + price + ' ' +  dateStr + ' ' + discount;
    }
}
