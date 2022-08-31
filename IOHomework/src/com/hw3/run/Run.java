package com.hw3.run;

import com.hw3.controller.BookManager;

import java.io.Serializable;

public class Run implements Serializable {

    //BookManager 클래스 객체 생성 후 메소드를 순차적으로 실행
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();

        bookManager.fileSave();
        bookManager.fileRead();
    }
}
