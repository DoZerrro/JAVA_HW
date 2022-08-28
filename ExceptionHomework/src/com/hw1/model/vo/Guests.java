package com.hw1.model.vo;

public class Guests {

    private String name;    //이름
    private int age;        //나이
    private char gender;    //성별
    private double height;  //키


    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }


    //기본 생성자
    public Guests() {}

    //4개의 초기값을 받는 매개변수 생성자
    public Guests(String name, int age, char gender, double height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Guests{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", height=" + height +
                '}';
    }
}
