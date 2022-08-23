package Polymorphism_Homework_강도영.mvc.model.vo;

public class CookBook extends Book{

    private boolean coupon;         //요리학원쿠폰유무


    public void CookBook() {}

    public CookBook(String title, String author, String publisher, boolean coupon) {
        super(title, author, publisher);
        this.coupon = coupon;
    }

    //setter
    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }

    //getter
    public boolean isCoupon() {
        return coupon;
    }

    @Override
    public String toString() {
        return super.toString() + "CookBook{" +
                "coupon=" + coupon +
                '}';
    }
}
