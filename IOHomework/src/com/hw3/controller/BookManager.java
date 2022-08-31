package com.hw3.controller;

import com.hw3.model.vo.Book;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class BookManager {

    Scanner scanner = new Scanner(System.in);


    //기본 생성자
    public BookManager() {}

    //5가지 도서에 대한 정보를 객체배열과 Object스트림을 통해 파일에 저장하는 메소드
    public void fileSave() {
        Book[] books = new Book[5];

        books[0] = new Book("C언어", "김씨", 10000, setCalendar(2012,2,2), 0.1);
        books[1] = new Book("자바", "이씨", 20000, setCalendar(2013,3,3), 0.2);
        books[2] = new Book("C++", "박씨", 30000, setCalendar(2014,4,4), 0.3);
        books[3] = new Book("넛지", "서씨", 40000, setCalendar(2015,5,5), 0.4);
        books[4] = new Book("개미", "최씨", 50000, setCalendar(2016,6,6), 0.5);

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("book.dat"))) {
            for(int index = 0; index < books.length; index++) {
                objectOutputStream.writeObject(books[index]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //지정된 날짜 Calendar형 반환 메소드
    public Calendar setCalendar(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, date);

        return calendar;
    }

    //파일로부터 도서에 대한 정보를 불러와서 콘솔에 출력하는 메소드
    public void fileRead() {

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("book.dat"))) {
            while(true) {
                System.out.println((Book)objectInputStream.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(EOFException e) {
            System.out.println("books.dat 읽기 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
