package controller;

import model.vo.Book;

import java.util.ArrayList;

public class BookManager {

    //기본생성자
    public BookManager() {}

    private ArrayList<Book> bookList = new ArrayList<>();

    //전달받은 Book객체의 도서번호를 setter메소드를 통해 설정한 후에 bookList에 추가
    public void insertBook(Book book) {
        //전달받은 book은 현재 도서번호가 0인채 들어오는데
        //새로운 도서가 추가될 때마다 추가되는 도서의 도서번호는
        //리스트 마지막 도서번호의 다음 번호로 부여해야됨
        int lastNo = 0;     //우선 변수 생성 및 초기화

        //하지만 리스트에 도서가 없는 경우, 즉 첫 도서 등록일 경우 위의 문장에서 예외발생
        try {
            lastNo = bookList.get(bookList.size()-1).getbNo() + 1;  //마지막 도서번호 + 1
        } catch (IndexOutOfBoundsException e) {
            lastNo = 1;
        }
        book.setbNo(lastNo);
        bookList.add(book);
    }

    //bookList의 도서들 중 전달 받은 bNo값이 일치하는 도서가 있을 경우 도서 삭제
    //→ 성공하면 1리턴
    //→ 실패하면 0리턴
    public int deleteBook(int bNo) {
        //for문을 이용하여 전달받은 도서번호가존재하는도서 삭제
        //성공적으로 삭제할 경우 1리턴
        //삭제되지 않은 경우 즉, 존재하는 도서번호가 없는 경우 0리턴

        int result = 0;
        for(int index = 0; index < bookList.size(); index++) {
            if(bookList.get(index).getbNo() == bNo) {
                bookList.remove(index);
                result = 1;
            }
        }
        return result;
    }

    //bookList의 도서들 중 전달 받은 title값을 포함(contains)한 도서들 searchList에 추가
    //→ searchList 리턴
    public ArrayList<Book> searchBook(String title) {
        ArrayList<Book> searchList = new ArrayList<Book>();     //검색 결과값들을 보관할 리스트

        //for문을 이용하여 전달받은 제목을 포함한 도서를 searchList에 추가
        //searchList 리턴
        for(int index = 0; index < bookList.size(); index++) {
            if(bookList.get(index).getTitle().contains(title)) {
                searchList.add(bookList.get(index));
            }
        }
        return searchList;
    }

    //bookList리턴
    public ArrayList<Book> selectList() {
        return bookList;
    }
}

