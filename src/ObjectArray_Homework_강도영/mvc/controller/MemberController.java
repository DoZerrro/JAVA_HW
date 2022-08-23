package ObjectArray_Homework_강도영.mvc.controller;

import ObjectArray_Homework_강도영.mvc.model.vo.Member;

import java.util.Arrays;
import java.util.Collections;

public class MemberController {

    public static final int SIZE = 10;          //최대 회원 수 = 10
    private int memberCount;                    //현재 회원 수
    private Member[] mem = new Member[SIZE];        //회원 객체 배열

    //아래의 {} 부분을 초기화 블럭이라고 한다.
    {
        mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
        mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
        mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@hanmail.net");
        mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@gamil.com");
        mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com");
        memberCount = 5;
    }


    public int getMemberCount() {
        //현재 회원수를 나타내는 memberCount 변수값을 반환해주는 메소드

        return memberCount;
    }
    
    
    public Member[] getMem() {
        //현재 회원 객체 배열의 주소 값을 반환해주는 메소드

        return mem;
    }


    public Member checkId(String userId) {
        //전달 받은 아이디가 mem 배열에 존재하는 경우 해당 아이디의 회원 정보를 반환해주는 메소드
        //(없을 경우 null 반환)

        Member m = null;    //아이디로 검색된 결과를 담을 변수 초기화

        for (int index = 0; index < mem.length; index++) {
            if(mem[index].getUserId().equals(userId)) {
                m = mem[index];
            }
        }

        return m;
    }


    public void insertMember(Member m) {
        //전달 받은 회원 전보를 mem 배열에 추가해주는 메소드로
        //회원 등록 시 memberCount 1 증가

        mem[memberCount++] = m;
    }
    
    
    public Member searchMember(int menu, String search) {
        //매개변수로 전달받은 menu에 따라 1인 경우 전달받은 search 문자열을 아이디로 검색
        //2인 경우 이름으로 검색, 3인 경우 이메일로 검색하고
        //그 결과인 회원 객체 주소 값을 반환

        Member searchMember = null;     //검색된 회원 정보를 담을 변수 초기화

        if(menu == 1) {
            for(int index = 0; index < mem.length; index++) {
                if(mem[index].getUserId().equals(search)) {
                    searchMember = mem[index];
                }
            }
        }
        if(menu == 2) {
            for(int index = 0; index < mem.length; index++) {
                if(mem[index].getName().equals(search)) {
                    searchMember = mem[index];
                }
            }
        }
        if(menu == 3) {
            for(int index = 0; index < mem.length; index++) {
                if(mem[index].getEmail().equals(search)) {
                    searchMember = mem[index];
                }
            }
        }

        return searchMember;
    }


    public void updateMember(Member m, int menu, String update) {
        //전달받은 menu에 따라 전달받은 회원 m을 setter 메소드를 이용하여
        //menu가 1인 경우 비밀번호 수정, 2인 경우 이름 수정, 3인 경우 이메일을 수정하는 메소드

        if(menu == 1) {
            m.setUserPwd(update);
        }
        if(menu == 2) {
            m.setName(update);
        }
        if(menu == 3) {
            m.setEmail(update);
        }
    }


    public void deleteMember(String userId) {
        //전달받은 아이디를 이용하여 검색 후 존재하는 경우 삭제해주는 메소드로
        //삭제 후 다음 인덱스 객체들의 정보를 한 칸씩 앞으로 이동시킴(memberCount 1 감소)

        for(int index = 0; index < mem.length; index++) {
            if(mem[index].getUserId().equals(userId)) {
                if(index == memberCount-1) {
                       // mem[index] = nulll;
                }
                else {
                    for(int index2 = index; index2 < memberCount-1; index2++){
                        mem[index2] = mem[index2+1];
                    }
                    mem[memberCount-1] = null;
                }
                memberCount--;
                break;
            }
        }
    }


    public Member[] sortIdAsc() {
        //객체배열을 아이디별 오름차순 정렬한 후 주소 값 반환

        //기존의 회원 객체 배열(mem)을 변경하지 않고 단지 정렬된 결과만을 보여주기 위해
        //기존의 배열 복사해서 사용(clone(), System.arraycopy() 둘 중 하나 사용해서 복사)

        Member copy[] = new Member[memberCount];
        System.arraycopy(mem, 0, copy, 0, memberCount);

        for(int index = 0; index < copy.length; index++) {
            for(int index2 = 0; index2 < index; index2++){
                if(copy[index].getUserId().compareTo(copy[index2].getUserId()) > 0) {
                    Member temp = copy[index2];
                    copy[index2] = copy[index];
                    copy[index] = temp;
                }
            }
        }
        return copy;
    }


    public Member[] sortIdDesc() {
        //객체배열을 아이디별 내림차순 정렬한 후 주소 값 반환

        Member copy[] = new Member[memberCount];
        System.arraycopy(mem, 0, copy, 0, memberCount);

        for(int index = 0; index < copy.length; index++) {
            for(int index2 = 0; index2 < index; index2++){
                if(copy[index].getUserId().compareTo(copy[index2].getUserId()) < 0) {
                    Member temp = copy[index2];
                    copy[index2] = copy[index];
                    copy[index] = temp;
                }
            }
        }
        return copy;
    }


    public Member[] sortAgeAsc() {
        //객체배열을 나이별 오름차순 정렬한 후 주소 값 반환

        Member[] copy = new Member[memberCount].clone();

        for(int index = 0; index < copy.length; index++) {
            for(int index2 = 0; index2 < index; index2++){
                if(copy[index].getAge() - copy[index2].getAge() > 0) {
                    Member temp = copy[index2];
                    copy[index2] = copy[index];
                    copy[index] = temp;
                }
            }
        }
        return copy;
    }


    public Member[] sortAgeDesc() {
        //객체배열을 나이별 내림차순 정렬한 후 주소 값 반환

        Member[] copy = new Member[memberCount].clone();

        for(int index = 0; index < copy.length; index++) {
            for(int index2 = 0; index2 < index; index2++){
                if(copy[index].getAge() - copy[index2].getAge() < 0) {
                    Member temp = copy[index2];
                    copy[index2] = copy[index];
                    copy[index] = temp;
                }
            }
        }
        return copy;
    }


    public Member[] sortGenderDesc() {
        //객체배열을 성별로 내림차순 정렬(남여순)한 후 주소 값 반환

        Member[] copy = new Member[memberCount].clone();

        for(int index = 0; index < copy.length; index++) {
            for(int index2 = 0; index2 < index; index2++){
                if(copy[index].getGender() == 'M' && copy[index2].getGender() == 'F') {
                    Member temp = copy[index2];
                    copy[index2] = copy[index];
                    copy[index] = temp;
                }
            }
        }
        return copy;
    }
}
