package Polymorphism_Homework_강도영.practice2.model.vo;

public abstract class SmartPhone implements CellPhone, TouchDisplay {

    public SmartPhone() {}

    //스마트폰 종류에 따라 브랜드 명을 출력하기 위한 추상 메소드
    public void printMaker() {}
}
