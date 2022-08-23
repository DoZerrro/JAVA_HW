package com.hw3;

import com.hw3.controller.SetDate;

public class Run {

    //SetDate 객체를 이용하여 todayPrint(), setDay() 실행
    public static void main(String[] args) {
        SetDate setDate = new SetDate();

        System.out.println(setDate.todayPrint());
        System.out.println(setDate.setDay());
    }
}
