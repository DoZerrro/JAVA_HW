package com.hw6.run;

import com.hw6.controller.NumberOk;

import java.util.Scanner;

public class Run {

    //NumberOk 객체를 이용하여 메소드 실행
    public static void main(String[] args) {
        NumberOk numberOk = new NumberOk();
        Scanner scanner = new Scanner(System.in);

        //NumberOk 객체를 이용하여 메소드 실행
        numberOk.numGame();

        //String의 equalsIgnoreCase() 메소드로 계속하는지 판단하는 y, n 입력 값 판단하기
        while (true) {
            System.out.print("\n계속 하시겠습니까?(y/n) : ");
            String selectYN = scanner.next();

            if(selectYN.equalsIgnoreCase("y") || selectYN.equalsIgnoreCase("Y")){
                System.out.println("\n새로운 게임을 시작합니다!!\n");
                numberOk.numGame();
            }
            if (selectYN.equalsIgnoreCase("n") || selectYN.equalsIgnoreCase("N")) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            if(!selectYN.equalsIgnoreCase("y") && !selectYN.equalsIgnoreCase("Y") && !selectYN.equalsIgnoreCase("n") && !selectYN.equalsIgnoreCase("N")) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
