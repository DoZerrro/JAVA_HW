package com.hw3.controller;

import java.util.Calendar;

public class SetDate {

    public SetDate() {}

    //오늘의 년, 월, 일, 시, 분, 초를 각 변수에 담은 후 오늘을 String으로 리턴
    public String todayPrint() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return year+"년 "+month+"월 "+date+"일 "+hour+"시 "+min+"분 "+second+"초";
    }

    //"2011년 3월 21일 월요일"을 세팅하여 출력
    public String setDay() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, 2011);
        calendar.set(Calendar.MONTH, 3);
        calendar.set(Calendar.DATE, 21);
        calendar.set(Calendar.DAY_OF_WEEK, 6);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.DAY_OF_WEEK);

        String weekName = "";
        switch (week) {
            case 1:
                weekName = "일요일"; break;
            case 2:
                weekName = "월요일"; break;
            case 3:
                weekName = "화요일"; break;
            case 4:
                weekName = "수요일"; break;
            case 5:
                weekName = "목요일"; break;
            case 6:
                weekName = "금요일"; break;
            case 7:
                weekName = "토요일"; break;
        }

        return year+"년 "+month+"월 "+date+"일 "+weekName;
    }
}
