package com.hw6.controller;

import java.util.Calendar;

public class DateCalculator {

    //기본 생성자
    public DateCalculator() {}

    
    //1년 1월 1일부터 오늘까지의 총 날 수를 계산
    //1년부터 현재 연도까지 각 연도가 윤년이면 총 날 수에 366일을, 평년이면 365일을 더함
    //해당 현재 연도가 윤년이면 2월 29일로 평년이면 28일로 더함
    //월의 날짜 수를 더함(31일 : 1, 3, 5, 7, 8, 10,12월 / 30일 : 4, 6, 9, 11월)
    public long leapDate() {

        Calendar calendar = Calendar.getInstance();

        long sumDay = 0L;

        for (int year = 1; year <= calendar.get(Calendar.YEAR); year++) {
            if (year == calendar.get(Calendar.YEAR)) {
                for (int month = 1; month <= (calendar.get(Calendar.MONTH) + 1); month++) {
                    if (month == calendar.get(Calendar.MONTH) + 1) {
                        for (int date = 1; date <= calendar.get(Calendar.DATE); date++) {
                            sumDay += 1;
                        }
                    } else if (month == 2) {
                        if (isLeapYear(year)) sumDay += 29;
                        else sumDay += 28;
                    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                        sumDay += 30;
                    } else sumDay += 31;
                }
            } else {
                if (isLeapYear(year)) sumDay += 366;
                else sumDay += 365;
            }
        }
        return sumDay;
    }

    
    //연도가 윤년이면 true, 평년이면 false 리턴
    //(윤년 : 연도가 4의 배수이면서, 100의 배수가 아니거나 200의 배수가 되는 해)
    public boolean isLeapYear(int year) {

        boolean isLeap = false;

        if(year % 4 == 0) {
            if(year % 100 != 0 || year % 200 == 0) {
                isLeap = true;
            }
        }

        return isLeap;
    }
}
