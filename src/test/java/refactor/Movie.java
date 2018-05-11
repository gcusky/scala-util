package refactor;

/**
 * 影片
 * Created by lizhy on 2018/4/24.
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        this._title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    private Price _price;

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    /**
     * 利用继承的方式，可以解耦switch，在子类中各自实现getCharge方法
     * @param daysRented
     * @return
     */
    double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
//        double result = 0;
//        switch (getPriceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if (daysRented > 2)
//                    result += (daysRented - 2) * 1.5;
//                break;
//            case Movie.NEW_RELEASE:
//                result += daysRented * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (daysRented > 3)
//                    result += (daysRented - 3) * 1.5;
//                break;
//        }
//        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
//        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
//            return 2;
//        else
//            return 1;
    }
}
