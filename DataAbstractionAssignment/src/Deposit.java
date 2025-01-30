import java.util.Date;
import java.text.DecimalFormat;

public class Deposit {
    private final double amount;
    private final Date date;
    private final String account;
    private final double balance;
    private static final DecimalFormat rounder = new DecimalFormat("0.00");

    // Requires: double amount > 0 with up to 2 decimal places with optimal trailing zeroes, Date date, String account =
    // CHECKING || SAVING, double balance with up to 2 decimal places with optional trailing zeroes
    // Modifies: this
    // Effects: Constructs a Deposit containing an amount greater than 0 with up to 2 decimal places with optional
    // trailing zeroes; a Date date; a CHECKING or SAVING account; and a balance with up to 2 decimal places with
    // optional trailing zeroes
    Deposit(double amount, Date date, String account, double balance){
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.balance = balance;
    }

    // Requires: double amount > 0 with up to 2 decimal places with optimal trailing zeroes, Date date, String account =
    // CHECKING || SAVING, double balance with up to 2 decimal places with optional trailing zeroes
    // Modifies: this
    // Effects: Converts a Deposit to a String, rounds all decimal places to 2, and sends it to the console
    public String toString(){
        return "Deposit of: $" + rounder.format(amount) +
               " Date: " + date +
               " into account: " + account +
               " Current Balance in " + account + " is $" + rounder.format(balance);
    }

    public double getAmount() {
        return amount;
    }
}
