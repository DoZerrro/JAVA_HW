package com.hw6.run;

import com.hw6.controller.DateCalculator;
import java.util.Calendar;

public class ShowDate {
    //DateCalculator 객체를 이용하여 메소드 실행
    public static void main(String[] args) {
        DateCalculator dateCalculator = new DateCalculator();

        //Calendar클래스를 이용한다.
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);

        //평년인지 윤년인지 isLeapYear()를 통해서 출력한다.
        boolean isLeap = dateCalculator.isLeapYear(year);
        if(isLeap == true) {
            System.out.println("올해는 윤년입니다.");
        }
        else {
            System.out.println("올해는 평년입니다.");
        }

        //평년과 윤년을 고려해 leapDate()로 총 날짜 수를 출력한다.
        System.out.println("총 날짜 수 : " + dateCalculator.leapDate());
    }
}
