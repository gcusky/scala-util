package refactor;

/**
 * 租赁
 * Created by lizhy on 2018/4/24.
 */
class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    /**
     * 运用多态取代与价格相关的条件逻辑
     */
    // 常客积分计算
    int getFrequentRenterPoints() {
//        double result = 0;
//        switch (getMovie().getPriceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if (getDaysRented() > 2)
//                    result += (getDaysRented() - 2) * 1.5;
//                break;
//            case Movie.NEW_RELEASE:
//                result += getDaysRented() * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (getDaysRented() > 3)
//                    result += (getDaysRented() - 3) * 1.5;
//                break;
//        }
//        return result;
        return _movie.getFrequentRenterPoints(_daysRented);
    }
    // 金额计算 ---> switch 应该在对象自己的数据上使用，而不是在别人的数据上使用
    double getCharge() {
//        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
//            return 2;
//        else
//            return 1;
        return _movie.getCharge(_daysRented);
    }
}
