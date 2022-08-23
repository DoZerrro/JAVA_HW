package Polymorphism_Homework_강도영.mvc.controller;

import Polymorphism_Homework_강도영.mvc.model.vo.AniBook;
import Polymorphism_Homework_강도영.mvc.model.vo.Book;
import Polymorphism_Homework_강도영.mvc.model.vo.CookBook;
import Polymorphism_Homework_강도영.mvc.model.vo.Member;
import Polymorphism_Homework_강도영.mvc.view.LibraryMenu;

public class LibraryManager {

    private Member member;
    private Book[] bList = new Book[5];

    {
        bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
        bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
        bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
        bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
        bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);

    }

    public LibraryManager() {}

    public void insertMember(Member member) {
        //전달받은 member를 LibraryManager의 member에 대입
        this.member = member;
    }

    public Member myInfo() {
        //회원 레퍼런스(member) 리턴
        return member;
    }

    public Book[] selectAll() {
        //도서 전체 목록(bList) 주소 값 리턴
        return bList;
    }

    public Book[] searchBook(String keyword) {
        //전달받은 키워드가 포함된 도서가 여러개가 존재할 수 있으니 검색된 도서를 담아줄
        //Book 객체 배열을 새로이 생성하고 for문을 통해 bList 안의 도서들과 전달받은
        //키워드를 비교하여 포함하고 있는 경우 새로운 배열에 차곡차곡 담기
        //→ 그 배열 주소 값 리턴

        Book[] books = new Book[5];
        int count = 0;

        for (int index = 0; index < bList.length; index++) {
            if(bList[index].getTitle().contains(keyword)) {
                books[count] = bList[index];
                count++;
            }
        }
        return books;
    }

    public int rentBook(int index) {
        //result를 0으로 초기화 한 후 전달받은 인덱스의 도서가
        //만화책인 경우 회원의 나이와 해당 만화책의 제한 나이를 비교하여
        //회원 나이가 더 적은 경우 result를 1로 초기화
        //아니면 전달받은 인덱스의 도서가 요리책이면 해당 요리책의 쿠폰 유무가 true일 경우
        //회원의 couponCount를 1증가 시킨후 result 2로 초기화
        //→ result 리턴

        int result = 0;

        if(bList[index] instanceof AniBook) {
            if(((AniBook) bList[index]).getAccessAge() > member.getAge()) {
                result = 1;
            }
        }
        if(bList[index] instanceof CookBook) {
            if(((CookBook) bList[index]).isCoupon() == true) {
                member.setCouponCount(member.getCouponCount()+1);
                result = 2;
            }
        }
        return result;
    }

}
