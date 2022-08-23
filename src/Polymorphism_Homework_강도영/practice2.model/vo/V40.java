package Polymorphism_Homework_강도영.practice2.model.vo;

public class V40 extends SmartPhone{

    //기본 생성자
    public V40() {}


    @Override
    public void makeACall() {
        System.out.println("번호를 누르고 통화버튼을 누름");
    }

    @Override
    public void takeACall() {
        System.out.println("전화받기 버튼을 누름");
    }

    @Override
    public void picture() {
        System.out.println("1200, 1600만 화소 트리플 카메라");
    }

    @Override
    public void charge() {
        System.out.println("고속충전");
    }

    @Override
    public void touch() {
        System.out.println("정전식");
    }

    @Override
    public void printMaker() {
        System.out.println("V40는 LG에서 만들어 졌다.");
    }
}
