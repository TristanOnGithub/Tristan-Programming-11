import java.util.Date;
import java.text.DecimalFormat;
public class Withdraw {

    private final double amount;
    private final Date date;
    private final String account;
    private final double balance;

    private static final DecimalFormat rounder = new DecimalFormat("0.00");

    // Requires: double amount > 0 with up to 2 decimal places with optional trailing zeroes, Date date, String account
    // = CHECKING || SAVING, double balance with up to 2 decimal places with optional trailing zeroes
    // Modifies: this
    // Effects: Constructs a Withdraw containing an amount greater than 0 with up to 2 decimal places with optional
    // trailing zeroes; a Date date; a CHECKING or SAVING account; and a balance with up to 2 decimal places with
    // optional trailing zeroes
    Withdraw(double amount, Date date, String account, double balance){
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.balance = balance;
    }

    // Requires: double amount > 0 with up to 2 decimal places with optional trailing zeroes, Date date, String account
    // = CHECKING || SAVING, double balance with up to 2 decimal places with optional trailing zeroes
    // Modifies: this
    // Effects: Converts a Withdraw to a String, rounds all decimal places to 2, and sends it to the console. If balance
    // is less than 0, adds a negative sign in front of the dollar sign
    public String toString() {
        String negativeSign = "";
        String typedBalance;
        if (balance > 0) {
            typedBalance = rounder.format(balance);
        }
        else {
            typedBalance = rounder.format(balance * -1);
            negativeSign = "-";
        }
        return "Withdrawal of: $" + rounder.format(amount) +
               " Date: " + date +
               " into account: " + account +
               " Current Balance in " + account + " is " + negativeSign + "$" + typedBalance;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}
