package com.hw4.controller;

import com.hw4.model.vo.Employee;

import java.util.Scanner;

public class EmpTest {

    private Employee[] empArr = new Employee[6];


    //기본 생성자
    public EmpTest() {}

    //크기가 6인 Employee[]을 만들고 위의 사용데이터에 나와 있는 순으로
    //Employee[]에 저장 및 한 사원에 대한 이름, 나이, 급여, 세율을 입력 받고 저장
    public void setEmp() {

        Scanner scanner = new Scanner(System.in);

        empArr[0] = new Employee("문말똥", 24, 1500000, 1.245);
        empArr[1] = new Employee("장소똥", 40, 2500000, 1.4);
        empArr[2] = new Employee("금개똥", 22, 1780000, 1.3);
        empArr[3] = new Employee("봉쥐똥", 31, 1950000, 1.365);
        empArr[4] = new Employee("홍닭똥", 34, 1650000, 1.212);

        System.out.print("이름을 입력하세요 : ");
        String name = scanner.next();

        System.out.print("나이를 입력하세요 : ");
        int age = scanner.nextInt();

        System.out.print("급여를 입력하세요 : ");
        int salary = scanner.nextInt();

        System.out.print("세율을 입력하세요 : ");
        double taxRate = scanner.nextDouble();


        empArr[5] = new Employee(name, age, (int)(salary - (salary * (taxRate/100))), taxRate);
    }


    //Employee[] 출력
    public void printEmp() {
        for (Employee e:empArr) {
            System.out.println(e);
        }
    }


    //정렬을 이용하여 이름을 기준으로 오름차순으로 출력
    //(String에서 제공되는 compareTo() 활용)
    public void nameSortPrint() {
        Employee employee = new Employee();

        for(int i = 0; i < empArr.length; i++){
            for(int j = i+1; j < empArr.length; j++){
                if(0 < empArr[i].getName().compareTo(empArr[j].getName())){
                    employee = empArr[i];
                    empArr[i] = empArr[j];
                    empArr[j] = employee;
                }
            }
        }
    }
}
