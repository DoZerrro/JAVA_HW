package com.hw1.controller;


import com.hw1.model.vo.Guests;
import com.hw1.model.vo.RollerCoaster;

public class RideController {

    public RideController() {}

    public void cutGuests() {

        //4명의 탑승 대기자를 생성자를 통한 Guest객체 배열 초기화
        Guests[] gs = new Guests[4];
        gs[0] = new Guests("홍길동", 17, 'M', 120.2);
        gs[1] = new Guests("유관순", 20, 'F', 102.3);
        gs[2] =  new Guests("김유신", 23, 'M', 110.4);
        gs[3] =  new Guests("김흥부", 21, 'M', 112.5);


        //RollerCoaster 클래스의 허용인원 상수값 크기의 또 다른 객체 배열 생성
        Guests[] onBoard = new Guests[RollerCoaster.PERMITNUMBER];

        try {
            //for문과 if문을 통해 RollerCoaster 클래스의 허용키 상수값 크기
            //이상인 사람을 Guests객체 배열 onBoard에 담는다.
            for(int index = 0; index < gs.length; index++){
                if(gs[index].getHeight() >= RollerCoaster.CUTHEIGHT){
                    onBoard[index] = gs[index];
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            //문제가 발생한 해당 배열의 인덱스 번호가 몇번에서 발생하는지
            //Throwable 클래스의 getMessage()메소드를 통해 출력

            System.out.print("문제가 발생한 해당 배열의 인덱스 번호 : ");
            System.out.println(e.getMessage());
        }finally {
            System.out.println("인원이 가득 찼습니다. 다음 차례를 기다리세요.");
            System.out.println("이번 차례 탑승 명단");
            for(int i = 0; i < onBoard.length; i++){
                System.out.print("이름 : " + onBoard[i].getName());
                System.out.println(", 키 : " + onBoard[i].getHeight());;
            }
        }
    }
}
