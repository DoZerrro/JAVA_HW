package Polymorphism_Homework_강도영.practice2.model.vo;

public interface CellPhone extends Phone, Camera{

    //휴대폰 유형에 따라 충전방식을 출력하기 위한 추상 메소드
    public void charge();
}
