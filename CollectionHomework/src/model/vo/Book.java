package model.vo;

public class Book {

    private int bNo;            //도서번호
    private String title;       //도서제목
    private int category;       //장르분류번호
    private String author;      //도서저자

    
    //기본생성자
    public Book() {}

    //매개변수 3개짜리 생성자(도서번호는 매개변수로 받지않음)
    public Book(String title, int category, String author) {
        this.title = title;
        this.category = category;
        this.author = author;
    }


    //setter
    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //getter
    public int getbNo() {
        return bNo;
    }

    public String getTitle() {
        return title;
    }

    public int getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }


    //필드값 문자열 합친 후 리턴

    @Override
    public String toString() {
        String categoryStr = "";

        switch (category) {
            case 1: categoryStr = "인문"; break;
            case 2: categoryStr = "자연과학"; break;
            case 3: categoryStr = "의료"; break;
            case 4: categoryStr = "기타"; break;
        }

        return "Book [도서번호 : " + bNo + ", 제목 : " + title + ", 카테고리 : " + categoryStr + ", 저자 : " + author + "]";
    }
}
