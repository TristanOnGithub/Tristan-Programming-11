import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class Customer {

    private final ArrayList<Deposit> deposits = new ArrayList<>();
    private final ArrayList<Withdraw> withdraws = new ArrayList<>();
    private final String name;
    private double checkingBalance;
    private double savingBalance;
    //private double savingRate;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private int overdraftCounter = 0;
    //private final int overdraft = -100;
    private static final DecimalFormat rounder = new DecimalFormat("0.00");
    private boolean invalidAccountNumber = false;
    private boolean invalidCheckingBalance = false;
    private boolean invalidSavingBalance = false;


    // Requires: ArrayList<Integer> array, int value
    // Modifies: nothing
    // Effects: Returns true if a value is found in an array
    public boolean intArrayListContains(ArrayList<Integer> arrayList, int value) {

        for (int currentArrayValue : arrayList) {

            if (currentArrayValue == value) {
                return true;
            }
        }
        return false;
    }

    // Requires: String name, unique int accountNumber > 0, double checkingBalance and savingBalance up to 2 decimal
    // places with optional trailing zeroes
    // Modifies: this
    // Effects: Constructs a Customer with a name; unique account number greater than 0; checking and saving balances
    // that have 2 decimal places or less with optional trailing zeroes; and adds the account number to
    // ArrayList<Integer> accountNumbers. If the account number is less than 1, used by another account, or if the
    // checkingBalance or savingBalance contains a non-zero number beyond the hundredths place, the Customer's
    // future deposit or withdrawal will be declined and a reason will be sent to the console
    Customer(String name, int accountNumber, double checkingBalance, double savingBalance, AccountManager accountManager) {

        this.name = name;

        if (accountNumber <= 0) {
            System.out.println("Sorry " + name + ", please enter an account number that's greater than 0.");
            this.invalidAccountNumber = true;
        }

        else if (intArrayListContains(accountManager.getAccountNumbers(), accountNumber)) {
            System.out.println("Sorry " + name + ", please enter a different account number as the account number " +
                    "you've chosen is already being used.");
            this.invalidAccountNumber = true;
        }

        else if (BigDecimal.valueOf(checkingBalance).scale() > 2) {
            System.out.println("Sorry " + name + ", please enter a checking balance that's 2 decimal spaces or less.");
            this.invalidCheckingBalance = true;
        }

        else if (BigDecimal.valueOf(savingBalance).scale() > 2) {
            System.out.println("Sorry " + name + ", please enter a saving balance that's 2 decimal spaces or less.");
            this.invalidSavingBalance = true;
        }

        else {
            this.checkingBalance = checkingBalance;
            this.savingBalance = savingBalance;

            accountManager.addAccountNumber(accountNumber);
        }
    }

    // Requires: double amount > 0 with up to 2 decimal places with optional trailing zeroes, Date date, String account
    // = CHECKING || SAVING
    // Modifies: this, deposits
    // Effects: Deposits an amount greater than 0 with up to 2 decimal places with optional trailing zeroes into a
    // Customer's CHECKING or SAVING account and adds it and a date to ArrayList<Deposit> deposits. If the Customer's
    // account is invalid from its Construction, the deposit will not go through and a message will be sent to the
    // console with the relevant reason
    public void deposit(double amount, Date date, String account) {

        if (this.invalidAccountNumber) {
            System.out.println("Sorry " + this.name + ", the amount could not be deposited because the account " +
                    "number of this account is invalid.");
        }

        else if (this.invalidCheckingBalance) {
            System.out.println("Sorry " + this.name + ", the amount could not be deposited because the checking " +
                    "balance of this account is invalid.");
        }

        else if (this.invalidSavingBalance) {
            System.out.println("Sorry " + this.name + ", the amount could not be deposited because the saving " +
                    "balance of this account is invalid.");
        }

        else if (amount <= 0) {
            System.out.println("Sorry " + this.name + ", please enter an amount to deposit that's greater than $0.");
        }

        else if (BigDecimal.valueOf(amount).scale() > 2) {
            System.out.println("Sorry " + this.name + ", please enter an amount to deposit that's 2 decimal spaces " +
                    "or less.");
        }

        else {

            if (account.equals(CHECKING)) {
                this.checkingBalance = Math.round((this.checkingBalance + amount) * 100.00) / 100.00;
                deposits.add(new Deposit(amount, date, CHECKING, this.checkingBalance));
            }

            else if (account.equals(SAVING)) {
                this.savingBalance = Math.round((this.savingBalance + amount) * 100.00) / 100.00;
                deposits.add(new Deposit(amount, date, SAVING, this.savingBalance));
            }

            else {
                System.out.println("Sorry " + this.name + ", please enter a valid account.");
            }
        }

    }

    // Requires: double amount > 0 with up to 2 decimal places with optional trailing zeroes, Date date, String account
    // = CHECKING || SAVING
    // Modifies: this, withdraws
    // Effects: Withdraws an amount greater than 0 with up to 2 decimal places with optional trailing zeroes from a
    // Customer's CHECKING or SAVING account and adds it and a date to ArrayList<Withdraw> withdraws. If the Customer's
    // account is invalid from its Construction, the withdrawal will not go through and a message will be sent to the
    // console with the relevant reason. If the amount withdrawn is greater than the account's balance, a message is
    // sent to the console and the withdrawal will go through.
    public void withdraw(double amount, Date date, String account) {

        if (this.invalidAccountNumber) {
            System.out.println("Sorry " + this.name + ", the amount could not be withdrawn because the account " +
                    "number of this account is invalid.");
        }

        else if (this.invalidCheckingBalance) {
            System.out.println("Sorry " + this.name + ", the amount could not be withdrawn because the checking " +
                    "balance of this account is invalid.");
        }

        else if (this.invalidSavingBalance) {
            System.out.println("Sorry " + this.name + ", the amount could not be withdrawn because the saving " +
                    "balance of this account is invalid.");
        }

        else if (amount <= 0) {
            System.out.println("Sorry " + this.name + ", please enter an amount to withdraw that's greater than $0.");
        }

        else if (BigDecimal.valueOf(amount).scale() > 2) {
            System.out.println("Sorry " + this.name + ", please enter an amount to withdraw that's 2 decimal spaces " +
                    "or less.");
        }

        else {

            while (true) {

                double balance;
                if (account.equals(CHECKING)) {
                    balance = this.checkingBalance;
                }

                else if (account.equals(SAVING)) {
                    balance = this.savingBalance;
                }

                else {
                    System.out.println("Sorry " + this.name + ", please enter a valid account.");
                    break;
                }

                if (amount > balance) {
                    String exceedBalance = rounder.format(amount - balance);
                    System.out.println(this.name + ", your withdrawal amount for your " + account + " account " +
                            "exceeds your current balance by $" + exceedBalance + ". The money has been withdrawn " +
                            "and your balance is in the red.");
                    this.overdraftCounter++;
                }

                balance = Math.round((balance - amount) * 100.00) / 100.00;

                withdraws.add(new Withdraw(amount, date, account, balance));

                if (account.equals(CHECKING)) {
                    this.checkingBalance = balance;
                }

                else {
                    this.savingBalance = balance;
                }

                break;
            }
        }
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public int getOverdraftCounter() {
        return overdraftCounter;
    }

    /*
    private boolean checkOverdraft(double amt, String account){
        //your code here
        return false;
    }
    */

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }
}
