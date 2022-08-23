package Polymorphism_Homework_강도영.mvc.model.vo;

public class Member {

    private String name;        //회원명
    private int age;            //회원나이
    private char gender;        //성별
    private int couponCount;    //요리학원쿠폰개수 = 0


    public void Member() {}

    public Member(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setCouponCount(int couponCount) {
        this.couponCount = couponCount;
    }

    //getter

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public int getCouponCount() {
        return couponCount;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", couponCount=" + couponCount +
                '}';
    }

}
