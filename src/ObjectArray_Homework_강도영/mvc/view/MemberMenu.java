package ObjectArray_Homework_강도영.mvc.view;

import ObjectArray_Homework_강도영.mvc.controller.MemberController;
import ObjectArray_Homework_강도영.mvc.model.vo.Member;

import java.util.Scanner;

import static ObjectArray_Homework_강도영.mvc.controller.MemberController.SIZE;

public class MemberMenu {

    private MemberController mc = new MemberController();   //객체 생성
    private Scanner sc = new Scanner(System.in);            //객체 생성


    public void mainMenu() {
        //반복문을 이용하여 메인 메뉴를 반복적으로 실행(각 메뉴 별 서브메뉴 호출)

        //메뉴 출력 → 반복 실행 처리함
        while(true){
            System.out.println("====== 회원 관리 메뉴 ======");
            System.out.println("1. 신규 회원 등록");  //→ insetrMember() 실행
            System.out.println("2. 회원 정보 검색");  //→ searchMember() 실행
            System.out.println("3. 회원 정보 수정");  //→ updateMember() 실행
            System.out.println("4. 회원 정보 삭제");  //→ deleteMember() 실행
            System.out.println("5. 회원 정보 출력");  //→ printAllMember() 실행
            System.out.println("6. 회원 정보 정렬");  //→ sortMember() 실행
            System.out.println("9. 프로그램 종료");

            System.out.print("메뉴를 입력하세요 : ");
            int selectMenu = sc.nextInt();

            if(selectMenu == 1) {
                insertMember();
            }
            if(selectMenu == 2) {
                searchMember();
            }
            if(selectMenu == 3) {
                updateMember();
            }
            if(selectMenu == 4) {
                deleteMember();
            }
            if(selectMenu == 5) {
                printAllMember();
            }
            if(selectMenu == 6) {
                sortMember();
            }
            if(selectMenu == 9) {
                break;
            }
        }
    }


    public void insertMember() {
        //메인 메뉴에서 1번 선택 시 실행되는 메소드이며 등록할 회원에 대한 정보를 입력 받고
        //동일한 아이디가 없는 경우 MemberController의 insertMember 메소드 실행

        MemberController memberController = new MemberController();

        if(memberController.getMemberCount() > SIZE) {
            return;
        }

        System.out.print("아이드를 입력하세요 : ");
        String insertId = sc.nextLine();

        //아이디 중복체크하는 과정
        if(memberController.checkId(insertId) != null) {
            System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
        }
        if(memberController.checkId(insertId) == null) {
            System.out.print("비밀번호를 입력하세요 : ");
            String insertPwd = sc.nextLine();

            System.out.print("이름을 입력하세요 : ");
            String insertName = sc.nextLine();

            System.out.print("나이를 입력하세요 : ");
            int insertAge = sc.nextInt();

            System.out.print("성별을 입력하세요 : ");
            char insertGender = sc.next().charAt(0);

            System.out.print("이메일을 입력하세요 : ");
            String insertEmail = sc.nextLine();

            Member member = new Member(insertId, insertPwd, insertName, insertAge, insertGender, insertEmail);

            memberController.insertMember(member);

            System.out.println("성공적으로 회원 등록이 되었습니다.");
        }

    }


    public void searchMember() {
        //메인 메뉴에서 2번 선택 시 실행되는 서브메뉴 → 반복실행
        //각 서브메뉴에 해당하는 검색 내용을 입력 받고 MemberController의 searchMenu 메소드 실행
        
        //메뉴 출력 → 반복 실행 처리함
        while(true) {
            System.out.println("===== 회원 정보 검색 =====");
            System.out.println("1. 아이디로 검색하기");
            System.out.println("2. 이름으로 검색하기");
            System.out.println("3. 이메일로 검색하기");
            System.out.println("9. 이전 메뉴로");

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            System.out.print("검색 내용 : ");
            String search = sc.nextLine();


            MemberController memberController = new MemberController();
            if(menu == 1 || menu == 2) {
                if(memberController.searchMember(menu, search) == null) {
                    System.out.println("검색된 결과가 없습니다.");
                }
                if(memberController.searchMember(menu, search) != null) {
                    System.out.println("아이디 : " + memberController.searchMember(menu, search).getUserId());
                    System.out.println("비밀번후 : " + memberController.searchMember(menu, search).getUserPwd());
                    System.out.println("이름 : " + memberController.searchMember(menu, search).getName());
                    System.out.println("나이 : " + memberController.searchMember(menu, search).getAge());
                    System.out.println("성별 : " + memberController.searchMember(menu, search).getGender());
                    System.out.println("이메일 : " + memberController.searchMember(menu, search).getEmail());
                }
            }
            if(menu == 9) {
                break;
            }
        }
    }


    public void updateMember() {
        //메인 메뉴에서 3번 선택 시 실행되는 서브메뉴 → 반복실행
        //각 서브메뉴에 해당하는 수정할 내용을 입력 받고 MemberController의 updateMember 메소드 실행

        //메뉴 출력 → 반복 실행 처리함
        while(true) {
            System.out.println("===== 회원 정보 수정 =====");
            System.out.println("1. 비밀번호 수정");
            System.out.println("2. 이름 수정");
            System.out.println("3. 이메일 수정");
            System.out.println("9. 이전 메뉴로");

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            System.out.print("변경할 회원 아이디 : ");
            String userId = sc.nextLine();

            MemberController memberController = new MemberController();
            if(menu == 1 || menu == 2 || menu == 3) {
                Member m = memberController.checkId(userId);
                if(m == null) {
                    System.out.println("변경할 회원이 존재하지 않습니다.");
                }
                if(m != null) {
                    System.out.println("기존 회원 정보\n아이디 : " + m.getUserId() + "\n비밀번호 : " + m.getUserPwd()
                                        + "\n이름 : " + m.getName() + "\n나이 : " + m.getAge()
                                       + "\n성별 : " + m.getGender() + "\n이메일 : " + m.getEmail());
                    System.out.print("\n변경할 내용을 입력하세요 : ");
                    String update = sc.nextLine();
                    memberController.updateMember(m, menu, update);
                    System.out.println("회원의 정보가 변경되었습니다.");
                }
            }
        }
    }


    public void deleteMember() {
        //메인 메뉴에서 4번 선택 시 실행되는 메소드이며 삭제할 회원 아이드를 입력받고
        //MemberController의 deleteMember 메소드 실행

        System.out.print("삭제할 회원 아이디 : ");
        String userId = sc.nextLine();

        MemberController memberController = new MemberController();
        Member m = memberController.checkId(userId);

        if(m == null) {
            System.out.println("삭제할 회원이 존재하지 않습니다.");
        }
        if(m != null) {
            System.out.print("정말 삭제하시겠습니까?(y/n) : ");
            String selectYN = sc.next();

            if(selectYN == "Y" || selectYN == "y") {
                memberController.deleteMember(userId);
                System.out.println("회원의 정보가 삭제되었습니다.");
            }
        }
    }


    public void printAllMember() {
        //메인 메뉴에서 5번 선택 시 실행되는 메소드이며 MemberController의 getMem 메소드
        //실행의 결과 값을 반복문을 통해 출력

        MemberController memberController = new MemberController();
        Member[] mem = memberController.getMem();

        for (Member printMem: mem) {
            System.out.println(printMem);
        }
    }
    
    
    public void sortMember() {
        //메인 메뉴에서 6번 선택 시 실행되는 서브메뉴 → 반복실행
        //각 서브메뉴에 해당하는 MemberController의 정렬 메소드들을 실행함으로써
        //그 결과 값으로 반복문을 통해 출력

        Member[] sortMem = null;        //정렬 결과를 받아 줄 객체배열 초기화

        //메뉴 출력 → 반복 실행 처리함
        while(true) {
            System.out.println("===== 회원 정보 정렬 =====");
            System.out.println("1. 아이디 오름차순 정렬");
            System.out.println("2. 아이디 내림차순 정렬");
            System.out.println("3. 나이 오름차순 정렬");
            System.out.println("4. 나이 내림차순 정렬");
            System.out.println("5. 성별 내림차순 정렬(남여순)");
            System.out.println("9. 이전 메뉴로");

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            MemberController memberController = new MemberController();
            if(menu == 1) {
                sortMem = memberController.sortIdAsc();
                for (Member printMem:sortMem) {
                    System.out.println(printMem);
                }
            }
            if(menu == 2) {
                sortMem = memberController.sortIdDesc();
                for (Member printMem:sortMem) {
                    System.out.println(printMem);
                }
            }
            if(menu == 3) {
                sortMem = memberController.sortAgeAsc();
                for (Member printMem:sortMem) {
                    System.out.println(printMem);
                }
            }
            if(menu == 4) {
                sortMem = memberController.sortAgeDesc();
                for (Member printMem:sortMem) {
                    System.out.println(printMem);
                }
            }
            if(menu == 5) {
                sortMem = memberController.sortGenderDesc();
                for (Member printMem:sortMem) {
                    System.out.println(printMem);
                }
            }
            if(menu == 9) {
                break;
            }
        }
    }
}
