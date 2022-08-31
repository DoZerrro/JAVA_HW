package com.hw1.model.dao;

import java.io.*;
import java.util.Scanner;

public class FileDao {

    Scanner scanner = new Scanner(System.in);

    
    //기본 생성자
    public FileDao() {}

    //어떤 파일에 어떤 내용을 저장할 지 입력 받아 파일 출력을 실행하는 메소드
    public void fileSave() {
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("파일에 저장할 내용을 반복해서 입력하시오('exit'을 입력하면 내용 입력 끝) : ");
        String inputStr = null;
        while(true) {
            inputStr = scanner.nextLine();
            if(inputStr.equals("exit")) {
                System.out.println("내용 입력을 종료합니다.");
                break;
            }
            else{
                stringBuilder.append(inputStr);
                stringBuilder.append("\n");
            }
        }

        System.out.print("저장하시겠습니까?(y/n) : ");
        char inputYN = scanner.next().charAt(0);
        scanner.nextLine();

        if(inputYN == 'Y' || inputYN == 'y') {
            System.out.print("저장할 파일명을 입력하세요 : ");
            String inputFileName = scanner.nextLine();
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(inputFileName + ".txt"));
                bufferedWriter.write(stringBuilder.toString());
                System.out.println(inputFileName + ".txt 파일에 성공적으로 저장하였습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(inputYN == 'N' || inputYN == 'n') {
            System.out.println("다시 메뉴로 돌아갑니다.");
        }
    }

    //원하는 파일을 파일 입력 후 콘솔 화면에 출력하는 메소드
    public void fileOpen() {
        System.out.print("열기 할 파일명 : ");
        String openFileName = scanner.nextLine();

        BufferedReader bufferedReader = null;
        String fileStr = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(openFileName + ".txt"));
            while((fileStr = bufferedReader.readLine()) != null) {
                System.out.println(fileStr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("존재하는 파일이 없습니다.");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //기존 파일을 입출력을 통해 내용을 추가해 수정하는 메소드
    public void fileEdit() {
        System.out.print("수정 할 파일명 : ");
        String editFileName = scanner.nextLine();

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        StringBuilder stringBuilder = new StringBuilder();
        String fileStr = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(editFileName + ".txt"));
            bufferedWriter = new BufferedWriter(new FileWriter(editFileName + ".txt", true));   //기존 파일 내용 그대로 두고 추가

            while((fileStr = bufferedReader.readLine()) != null) {
                System.out.println(fileStr);
            }

            System.out.println
                    ("파일에 추가할 내용을 입력하세요 : ");
            while(true) {
                fileStr = scanner.nextLine();
                if (fileStr.equals("exit")) {
                    System.out.println("파일에 내용을 추가하는 것을 종료합니다.");
                    break;
                }
                else {
                    stringBuilder.append(fileStr);
                    stringBuilder.append("\n");
                }
            }

            System.out.print("변경된 내용을 파일에 추가하시겠습니까?(y/n) : ");
            char addYN = scanner.next().charAt(0);

            if(addYN == 'Y' || addYN == 'y') {
                bufferedWriter.write(stringBuilder.toString());
                System.out.println(editFileName + ".txt 파일의 내용이 변경되었습니다.");
            }
            if(addYN == 'N' || addYN == 'n') {
                System.out.println("다시 메뉴로 돌아갑니다.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
