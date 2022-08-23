package com.hw2.controller;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SpaceUpper {

    //기본 생성자
    public SpaceUpper() {}
    
    //입력 받은 영문을 StringTokenizer와 StringBuilder를 사용해 띄워쓰기를 기준으로
    //띄워쓰기 이후 첫 영문을 대문자로 출력하는 메소드
    public void spaceToUpper() {
        
        //영문을 입력받는다.
        Scanner scanner = new Scanner(System.in);

        System.out.println("영어를 입력하시오(띄워쓰기 포함) : ");
        String inputStr = scanner.nextLine();

        //StringTokenizer를 통해 띄워쓰기를 기준으로 토큰 단위로 나온 것을 연산하는 메소드를 구성
        //띄워쓰기 이후 첫 글자는 대문자로 되게 하고 그 외에 나머진 소문자로 해서 StringBuilder에 담아 출력
        StringTokenizer stringTokenizer = new StringTokenizer(inputStr, " ");
        StringBuilder stringBuilder = new StringBuilder();

        while(stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            stringBuilder.append(token.substring(0, 1).toUpperCase()+token.substring(1)+" ");
        }

        String resultStr = stringBuilder.toString();
        System.out.println(resultStr);
    }
}
