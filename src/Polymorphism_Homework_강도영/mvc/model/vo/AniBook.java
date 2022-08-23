package Polymorphism_Homework_강도영.mvc.model.vo;

public class AniBook extends Book{

    private int accessAge;      //제한 나이


    public void AniBook() {}

    public AniBook(String title, String author, String publisher, int accessAge) {
        super(title, author, publisher);
        this.accessAge = accessAge;
    }

    //setter
    public void setAccessAge(int accessAge) {
        this.accessAge = accessAge;
    }

    //getter
    public int getAccessAge() {
        return accessAge;
    }

    @Override
    public String toString() {
        return super.toString() + "AniBook{" +
                "accessAge=" + accessAge +
                '}';
    }
}
