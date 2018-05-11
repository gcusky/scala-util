package refactor;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 * Created by lizhy on 2018/4/24.
 */
public class CustomerRefator {
    private String _name;
    private Vector _rentals = new Vector();

    public CustomerRefator(String name) {
        this._name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }


    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    /**
     * 逻辑泥团 switch 语句，把它提炼到独立函数中似乎比较好
     * 函数内的局部变量和参数：each 和 thisAmount，前者并未被修改，后者会被修改
     * 不会被修改的可作为参数传入，但会被修改的需格外小心
     */
//    private double amountFor(Rental aRental) {
//        // 使用了来自Rental类的信息，却没有使用来自Customer类的信息 ---> 放错了位置
//        // 绝大多数情况下，函数应该放在它所使用的数据的所属对象内，所以amountFor()应该移到Rental类去
//        return aRental.getCharge();
//    }

    // 取代totalAmount
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    // 分解并重组statement()
    public String statement() {
        // double totalAmount = 0;
        // int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            // double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            // thisAmount 如今变得多余了。它接受 each.getCharge() 的执行结果，然后就不再有任何改变
            // thisAmount = each.getCharge();

            // 本例中，frequentRenterPoints 在被使用之前已经先有初值，但提炼出来的函数并没有读取该值
            // ---> 所以我们不需要将它当作参数传进去，只需把新函数的返回值累加上去就行了。
            // frequentRenterPoints++;
            // if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
            //     frequentRenterPoints++;
            // frequentRenterPoints += each.getFrequentRenterPoints();

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            // totalAmount += each.getCharge();
        }

        result += "Amount owed is" + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned" + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for each rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        // add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }
}

