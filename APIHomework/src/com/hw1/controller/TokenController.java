package com.hw1.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TokenController {

    //공백을 토큰으로 처리 한 글자 반환
    public String afterToken(String str){
        String resultStr;
        resultStr = str.replaceAll(" ", "");
        return resultStr;
    }

    //매개변수로 받은 문자열의 첫 번째 글자를 대문자로 바꾼 문자열 반환
    public String firstCap(String input){
        String resultStr;
        resultStr = input.substring(0, 1).toUpperCase()+input.substring(1);
        return resultStr;
    }

    //매개변수로 받은 문자열 중에서 매개변수로 들어온 문자가 몇 개 존재하는지 개수를 반환
    public int findChar(String input, char one){
        int count = 0;

        for(int index = 0; index < input.length(); index++){
            if(input.charAt(index) == one) {
                count++;
            }
        }
        return count;
    }
}
