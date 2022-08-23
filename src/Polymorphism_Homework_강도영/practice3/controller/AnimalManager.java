package Polymorphism_Homework_강도영.practice3.controller;

import Polymorphism_Homework_강도영.practice3.model.vo.Animal;
import Polymorphism_Homework_강도영.practice3.model.vo.Cat;
import Polymorphism_Homework_강도영.practice3.model.vo.Dog;

public class AnimalManager {

    public static void main(String[] args) {
        //Animal 타입의 객체배열 크기 5로 생성
        Animal[] animals = new Animal[5];

        //각 인덱스에 무작위로 Dog객체 또는 Cat객체로 생성
        //(이때, 매개변수 생성자를 이용하여 생성)
        //String name, String kinds, String location, String color
        //String name, String kinds, int weight
        animals[0] = new Cat("월이", "스코티시폴드", "월이네", "브라운");
        animals[1] = new Dog("태양이", "치와와", 4);
        animals[2] = new Cat("겨울이", "스코티시폴드", "겨울이네", "화이트+그레이");
        animals[3] = new Dog("콩이", "포메라니안", 3);
        animals[4] = new Cat("담이", "스코티시폴드", "담이네", "화이트+그레이");

        //반복문을 통해서 해당 배열의 0번 인텍스부터 마지막 인덱스까지의
        //객체의 speak() 메소드 호출
        for (int index = 0; index < animals.length; index++) {
            animals[index].speak();
        }
    }
}
