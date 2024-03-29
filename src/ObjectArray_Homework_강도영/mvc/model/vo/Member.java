package ObjectArray_Homework_강도영.mvc.model.vo;

public class Member{

    private String userId;          //아이디
    private String userPwd;         //비밀번호
    private String name;            //이름
    private int age;                //나이
    private char gender;            //성별
    private String email;           //이메일

    public Member() {}

    public Member(String userId, String userPwd, String name, int age, char gender, String email) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }


    //getter
    public String getUserId() {
        return userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }


    //setter

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
