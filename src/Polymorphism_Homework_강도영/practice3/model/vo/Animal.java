package Polymorphism_Homework_강도영.practice3.model.vo;

public abstract class Animal {

    private String name;
    private String kinds;

    protected Animal() {}

    protected Animal(String name, String kinds) {
        this.name = name;
        this.kinds = kinds;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    //getter
    public String getName() {
        return name;
    }

    public String getKinds() {
        return kinds;
    }


    @Override
    public String toString() {
        return "저의 이름은 " + name + "이고, 종류는 " + kinds + "입니다.";
    }

    //추상메소드로 구현
    public abstract void speak();
}
