package Polymorphism_Homework_강도영.practice2.run;

import Polymorphism_Homework_강도영.practice2.model.vo.GalaxyNote9;
import Polymorphism_Homework_강도영.practice2.model.vo.SmartPhone;
import Polymorphism_Homework_강도영.practice2.model.vo.V40;

public class Run {

    public static void main(String[] args) {
        //GalaxyNote9과 V40카메라를 동시에 참조하기 위한 SmartPhone 타입의 배열 생성(크기 2로 지정)
        SmartPhone[] phone = new SmartPhone[2];

        //각각의 인덱스에 GalaxyNote9, V40 객체생성
        phone[0] = new GalaxyNote9();
        phone[1] = new V40();

        //for문을 이용하여 SmartPhone 객체배열에 있는 GalaxyNote9과 V40에 접근하여
        //오버라이딩 한 메소드를 모두 호출
        //(printMaker, makeACall, takeACall, touch, charge, picture)
        for (int index = 0; index < phone.length; index++) {
            phone[index].printMaker();
            phone[index].makeACall();
            phone[index].takeACall();
            phone[index].touch();
            phone[index].charge();
            phone[index].picture();
            System.out.println();
        }
    }
}
