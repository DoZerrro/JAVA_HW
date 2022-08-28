package com.hw5.controller;

import java.util.Scanner;

public class NumberOk {

    private int ran;

    //기본 생성자
    public NumberOk() {}

    //사용자에게 숫자를 입력 받고 입력 받은 숫자가 임의의 난수와 비교했을 때
    //작은지 큰지, 몇 번만에 맞추는지, 맞추면 계속 할지 끝낼지 묻는 메소드
    public void numGame(){

        Scanner scanner = new Scanner(System.in);

        int randomNum = (int)(Math.random()*100)+1;
        int count = 0;

        //랜던숫자 확인 문구
        //System.out.print("랜덤숫자 : " + randomNum + "\n");
        while (true){
            System.out.print("1부터 100 사이의 정수를 하나 입력하세요 : ");
            int num = scanner.nextInt();
            count++;

            if(num != randomNum) {
                if(randomNum > num) {
                    System.out.println(num + "보다 큽니다. " + count + "번째 실패!!");
                }

                if(randomNum < num) {
                    System.out.println(num + "보다 작습니다. " + count + "번째 실패!!");
                }
            }

            if(randomNum == num) {
                System.out.println(count + "번 만에 맞췄습니다!");
                break;
            }
        }
    }
}
