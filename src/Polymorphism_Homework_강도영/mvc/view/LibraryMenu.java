package Polymorphism_Homework_강도영.mvc.view;

import Polymorphism_Homework_강도영.mvc.controller.LibraryManager;
import Polymorphism_Homework_강도영.mvc.model.vo.Book;
import Polymorphism_Homework_강도영.mvc.model.vo.Member;

import java.util.Scanner;

public class LibraryMenu {
    private LibraryManager libraryManager = new LibraryManager();
    private Scanner scanner = new Scanner(System.in);


    public void mainMenu() {
        //프로그램 실행 시 가장 먼저 호출되는 메소드로 회원 이름, 나이, 성별을 입력받아
        //Member 객체 생성 후 해당 객체를 LibraryManager의 insertMember 메소드로 전달
        //무한 반복 메뉴를 출력하여 각 메뉴 버튼 선택 시 해당 메소드 호출

        System.out.print("이름을 입력하세요 : ");
        String name = scanner.nextLine();
        System.out.print("나이를 입력하세요 : ");
        int age = scanner.nextInt();
        System.out.print("성별을 입력하세요 : ");
        char gender = scanner.next().charAt(0);

        Member member = new Member(name, age, gender);
        libraryManager.insertMember(member);

        LibraryMenu libraryMenu = new LibraryMenu();

       while(true) {
           System.out.println("==== 메뉴 ====");
           System.out.println("1. 마이페이지");
           System.out.println("2. 도서 전체 조회");
           System.out.println("3. 도서 검색");
           System.out.println("4. 도서 대여하기");
           System.out.println("0. 프로그램 종료");

           System.out.print("메뉴를 입력하세요 : ");
           int menu = scanner.nextInt();

           if(menu == 1) {
               System.out.println(libraryManager.myInfo());
           }
           if (menu == 2) {
               libraryMenu.selectAll();
           }
           if(menu == 3) {
               libraryMenu.searchBook();
           }
           if(menu == 4) {
               libraryMenu.rentBook();
           }
           if(menu == 0) {
               break;
           }
       }


    }

    public void selectAll() {
        //LibraryManager의 selectAll 메소드 호출
        //→ 결과 값을 Book[] 자료형으로 받아준 뒤 for문을 통해 도서 전체 목록 출력

        Book[] bList = libraryManager.selectAll();

        for(int index = 0; index < bList.length; index++) {
            System.out.println(index + "번 도서" + bList[index].toString());
        }
    }

    public void searchBook() {
        //검색할 제목 "키워드"를 입력 받고 그 키워드를 LibraryManager의 searchBook 메소드로 전달
        //→ 결과 값을 Book[] 자료형으로 받아준 뒤 향상된 for문을 이용하여 출력
        System.out.print("검색할 제목 키워드 : ");
        String keyword = scanner.nextLine();

        Book[] books = libraryManager.searchBook(keyword);

        //NullPointerException 발생 시 오류 해결
        for (Book book: books) {
            System.out.println(book);
        }
    }

    public void rentBook() {
        //대여할 도서 인덱스를 입력 받아 LibraryManager의 rentBook 메소드로 전달
        //→ 결과 값을 result로 받아 result가 0일 경우, 1일 경우, 2일 경우 각각에 해당하는 출력문 출력

        System.out.println(libraryManager.selectAll().toString());

        System.out.print("대여할 도서 번호 선택 : ");
        int num = scanner.nextInt();
        int result = libraryManager.rentBook(num);

        if(result == 0) {
            System.out.println("성공적으로 대여되었습니다.");
        }
        if(result == 1) {
            System.out.println("나이 제한으로 대여 불가능입니다.");
        }
        if(result == 2) {
            System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다. 마이페이지를 통해 확인하세요.");
        }
    }
}
