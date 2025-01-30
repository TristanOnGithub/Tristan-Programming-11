import java.util.ArrayList;

public class AccountManager {
    private final ArrayList<Integer> accountNumbers = new ArrayList<>();

    // Requires: int accountNumber > 0
    // Modifies: this
    // Effects: Adds an account number to the accountNumbers ArrayList
    public void addAccountNumber(int accountNumber) {
        accountNumbers.add(accountNumber);
    }

    public ArrayList<Integer> getAccountNumbers() {
        return accountNumbers;
    }
}
