package com.hw1.view;

import com.hw1.controller.TokenController;

import java.util.Scanner;

public class TokenMenu {

    private Scanner scanner = new Scanner(System.in);
    private TokenController tokenController = new TokenController();

    
    //메인 메뉴 출력
    public void mainMenu() {
        while(true){
            System.out.println("1. 지정 문자열");
            System.out.println("2. 입력 문자열");
            System.out.println("9. 프로그램 끝내기");

            System.out.print("메뉴 번호 : ");
            int selectNum = scanner.nextInt();

            if (selectNum == 1) {
                tokenMenu();
            }
            if(selectNum == 2) {
                inputMenu();
            }
            if (selectNum == 9) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if(selectNum != 1 && selectNum != 2 && selectNum != 9) {
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
            }
        }
    }

    //토큰 결과 출력
    public void tokenMenu() {
        String str = "J a v a P r o g r a m";

        //Token 처리 전 글자와 글자 개수를 출력하고
        System.out.println("토큰 처리 전 글자 : " + str);
        System.out.println("토큰 처리 전 개수 : " + str.length());

        //위 str을 TokenController의 afterToken() 메소드의 인자로 보내 반환 값 출력
        //그 반환 값을 이용해 Token 처리 후 글자 개수와 대문자 변환한 것을 출력
        System.out.println("토큰 처리 후 글자 : " + tokenController.afterToken(str));
        System.out.println("토큰 처리 후 개수 : " + tokenController.afterToken(str).length());
        System.out.println("모두 대문자로 변환 : " + tokenController.afterToken(str).toUpperCase());
    }

    //첫 글자 대문자, 문자 개수 결과 출력
    public void inputMenu() {
        //입력 받은 문자열을 TokenController의 firstCap()의 인자로 보내 반환 값 출력
        System.out.print("문자열을 입력하세요 : ");
        String inputStr = scanner.next();

        String resultStr = tokenController.firstCap(inputStr);
        System.out.println("첫 글자 대문자 : " + resultStr);

        //찾을 문자 입력 받아 TokenController의 findChar()의 매개변수로 아까 입력 받은
        //문자열과 문자 하나를 매개변수로 보내 반환 값 출력
        System.out.print("찾을 문자 하나를 입력하세요 : ");
        char selectChar = scanner.next().charAt(0);
        System.out.println(selectChar + " 문자가 들어간 개수 : " + tokenController.findChar(inputStr, selectChar));
    }
}
