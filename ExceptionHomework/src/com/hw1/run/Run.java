package com.hw1.run;

import com.hw1.controller.RideController;

public class Run {

    //RideController 클래스 객체 생성 후 cutGuests() 메소드 실행
    public static void main(String[] args) {
        RideController rideController = new RideController();

        rideController.cutGuests();
    }
}
