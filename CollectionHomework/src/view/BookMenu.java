package view;

import controller.BookManager;
import model.vo.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {

    //기본생성자
    public BookMenu() {}

    private Scanner scanner = new Scanner(System.in);
    private BookManager bookManager = new BookManager();
    
    //도서 관리 프로그램에 해당하는 메인 메뉴 출력,
    //각 메뉴에 해당하는 메소드 실행 → 반복 출력되게 함
    public void mainMenu() {
        while(true){
            System.out.println("*** 도서 관리 프로그램 ***");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("3. 도서 검색 출력");
            System.out.println("4. 전체 출력");
            System.out.println("0. 끝내기");
            System.out.print("메뉴 번호 선택 : ");
            int selectNum = scanner.nextInt();

            if (selectNum == 1) insertBook();
            if (selectNum == 2) deleteBook();
            if (selectNum == 3) searchBook();
            if (selectNum == 4) selectList();
            if (selectNum == 0) {
                System.out.println("프로그램 종료");
                break;
            }
            if (selectNum != 1 && selectNum != 2 && selectNum != 3 && selectNum != 4 && selectNum != 0)
                System.out.println("메뉴를 잘못 입력하였습니다. 다시 입력하세요.");
        }
    }
    
    //제목, 카테고리, 저자명을 키보드로 입력받고 입력받은 값을 가지고 Book객체 생성
    //생성한 Book객체를 BookManager의 insertBook 메소드로 전달
    public void insertBook() {

        scanner.nextLine();

        System.out.print("도서 제목 : ");
        String title = scanner.nextLine();

        System.out.print("도서 장르(1:인문/2:자연과학/3:의료/4:기타) : ");
        int category = scanner.nextInt();

        scanner.nextLine();

        System.out.print("도서 저자 : ");
        String author = scanner.nextLine();

        Book book = new Book(title, category, author);

        bookManager.insertBook(book);
    }
    
    //삭제할 도서번호를 키보드로 입력받아 BookManager의 deleteBook 메소드로 전달
    //→ 리턴받은 결과값을 가지고 성공, 실패 여부 출력
    public void deleteBook() {
        System.out.print("도서 번호 : ");
        int bNo = scanner.nextInt();

        int result = bookManager.deleteBook(bNo);
        if (result == 1) {
            System.out.println("성공적으로 삭제");
        }
        if(result == 0) {
            System.out.println("삭제할 도서가 존재하지 않습니다.");
        }
    }
    
    //검색할 도서명을 키보드로 입력받아 BookManager의 searchBook 메소드로 전달
    //리턴 받은 리스트가 비어있을 경우 "검색 결과 없음" 출력
    //리턴 받은 리스트가 비어있지 않을 경우 검색 결과 목록 출력
    public void searchBook() {
        scanner.nextLine();

        System.out.print("도서 제목 : ");
        String title = scanner.nextLine();

        ArrayList<Book> searchList = bookManager.searchBook(title);
        if (searchList.isEmpty()) {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        if(!searchList.isEmpty()) {
            for (int index = 0; index < searchList.size(); index++){
                System.out.println(searchList.get(index));
            }
        }
    }

    //BookManager의 selectList 메소드 호출하여
    //리턴 받은 리스트가 비어있는 경우 "도서가 없습니다." 출력
    //비어있지 않은 경우 전체 리스트 목록 출력
    public void selectList() {
        ArrayList<Book> bookList = bookManager.selectList();
        if (bookList.isEmpty()) {
            System.out.println("도서 목록이 존재하지 않습니다.");
        }
        if(!bookList.isEmpty()) {
            for (Book book:bookList) {
                System.out.println(book);
            }
        }
    }
}
