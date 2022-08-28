package com.hw1.controller;

import com.hw1.model.vo.Guests;
import com.hw1.model.vo.RollerCoaster;

public class RideController {

    //기본 생성자
    public RideController() {}

    //예외처리를 통해 인원을 제한하고 탑승자와 관련된 정보 출력
    public void cutGuests() {
        //4명의 탑승 대기자를 생성자를 통한 Guests객체 배열 초기화(Guests[] guests)
        Guests[] guests = new Guests[4];
        guests[0] = new Guests("홍길동", 17, 'M', 120.2);
        guests[1] = new Guests("유관순", 20, 'F', 102.3);
        guests[2] = new Guests("김유신", 23, 'M', 110.4);
        guests[3] = new Guests("김흥부", 21, 'M', 112.5);

        //RollerCoaster 클래스의 허용인원 상수값 크기의 또 다른 객체 배열 생성(Guests[] onBoard)
        Guests[] onBoard= new Guests[RollerCoaster.PERMITNUMBER];
        int indexOnBoard = 0;   //탑승자 인원 인덱스 번호
        int sumPrice = 0;       //탑승자 요금

        try{
            //for문과 if문을 통해 RollerCoaster 클래스의 허용키 상수값 크기 이상인 사람을 Guests객체 배열 onBoard에 담는다.
            for (int index = 0; index < guests.length; index++) {
                if(guests[index].getHeight() >= RollerCoaster.CUTHEIGHT) {
                    onBoard[indexOnBoard] = guests[index];
                    indexOnBoard++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {    //배열 크기를 넘어가면 발생되는 예외클래스 참조형 변수 e를 받는 매개변수 자리
            //문제가 발생한 해당 배열의 인덱스 번호가 몇번에서 발생하는지
            //Throwable클래스의 getMessage()메소드를 통해 출력
            System.out.println("문제가 발생한 해당 배열의 인덱스 번호 : " + e.getMessage());

        }finally {
            //"인원이 가득 찼습니다. 다음 차례를 기다리세요"
            System.out.println("인원이 가득 찼습니다. 다음 차례를 기다리세요");

            //"이번 차례 탑승 명단"
            System.out.println("이번 차례 탑승 명단");

            //탑승자 각가의 이름, 키를 출력하고 두 탑승자의 요금합계를 출력하시오.
            for (int index = 0; index < onBoard.length; index++) {
                System.out.println("이름 : " + onBoard[index].getName() + ", 키 : " + onBoard[index].getHeight());
            }
            System.out.println("탑승자 요금 : " + indexOnBoard * RollerCoaster.PRICE);

        }
    }
}
