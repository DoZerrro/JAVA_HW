package com.hw1.model.vo;

public class Guests {

    private String name;
    private int age;
    private char gender;
    private double height;

    
    //기본생성자
    public Guests() {}

    //4개의 초기값을 받는 매개변수 생성자

    public Guests(String name, int age, char gender, double height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }

    //getter
    public double getHeight() {
        return height;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    //setter
    public void setHeight(double height) {
        this.height = height;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
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
