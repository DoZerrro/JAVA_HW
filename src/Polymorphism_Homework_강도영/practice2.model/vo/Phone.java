package Polymorphism_Homework_강도영.practice2.model.vo;

public interface Phone {

    //일반전화기, 공중전화기, 휴대전화기에 따라 다른 전화걸기 방식을 가지므로
    //각 전화 유형에 대해 전화걸기 방식을 출력하기 위한 추상메소드
    public void makeACall();

    //일반전화기, 공중전화기, 휴대전화기에 따라 다른 전화받는 방식을 가지므로
    //각 전화 유형에 대해 전화 받는 방식을 출력하기 위한 추상메소드
    public void takeACall();
}
