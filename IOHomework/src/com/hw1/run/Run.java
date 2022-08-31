package com.hw1.run;

import com.hw1.model.dao.FileDao;

import java.util.Scanner;

public class Run {

    //FileDao 클래스 객체 생성 후 각 메소드를 메뉴 선택에 따라 실행
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileDao fileDao = new FileDao();

        while(true) {
            System.out.println("****** MyNote ******");
            System.out.println("1. 노트 새로 만들기");
            System.out.println("2. 노트 열기");
            System.out.println("3. 노트 열어서 수정하기");
            System.out.println("4. 끝내기");
            System.out.print("번호를 입력하세요 : ");
            int selectNum = scanner.nextInt();
            
            if(selectNum == 1) fileDao.fileSave();
            if(selectNum == 2) fileDao.fileOpen();
            if(selectNum == 3) fileDao.fileEdit();;
            if(selectNum == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if(selectNum != 1 && selectNum != 2 && selectNum != 3 && selectNum != 4) {
                System.out.println("번호를 잘못 입력하였습니다. 다시 입력하세요");
            }
        }

    }
}
