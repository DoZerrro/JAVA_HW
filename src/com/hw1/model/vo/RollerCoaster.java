package com.hw1.model.vo;

public class RollerCoaster {
    public static final double CUTHEIGHT = 110.0;    //제한 키
    public int PRICE;           //가격
    public static final int PERMITNUMBER = 2;    //수용인원

    public RollerCoaster() {}

    @Override
    public String toString() {
        return "RideController{" +
                "CUTHEIGHT=" + CUTHEIGHT +
                ", PRICE=" + PRICE +
                ", PERMITNUMBER=" + PERMITNUMBER +
                '}';
    }
}
