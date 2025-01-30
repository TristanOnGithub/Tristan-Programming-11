import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DepositWithdrawTests {

    private final Date date = new Date();
    private Withdraw testWithdraw;
    private Withdraw finalCheckingBalance;
    private Withdraw finalSavingBalance;
    private double totalTestAmount = 0;
    private Customer testCustomer1;
    private final double checkingBalance = 500;
    private final double savingBalance = 400;
    private final AccountManager accountManager = new AccountManager();

    @Before
    public void setUp() {
        // Create a test Customer with a valid name, account number, and balances
        testCustomer1 = new Customer("Test1", 1, checkingBalance, savingBalance, accountManager);
    }

    @Test
    public void testValidAmount() {
        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer1.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Create an array of valid test amounts
        double[] testAmounts = {1, 1.1, 1.10, 1.01, 1.00, 1.000, 1.110, 1.50, .01, 00001.00, 00.01, 9999999.99};

        // Deposit money in CHECKING
        for (double testAmount : testAmounts) {
            testCustomer1.deposit(testAmount, date, Customer.CHECKING);
        }

        // Withdraw money from CHECKING
        for (double testAmount : testAmounts) {
            testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        }

        // Assert that new Deposits and Withdraws have been created
        assertEquals(testAmounts.length, deposits1.size());
        assertEquals(testAmounts.length, withdraws1.size());

        // Assert that testAmount is equal to Deposit.amounts and Withdraw.amounts
        Deposit testDeposit;
        for (int i = 0; i < testAmounts.length; i++) {
            testDeposit = deposits1.get(i);
            assertEquals(testAmounts[i], testDeposit.getAmount(), 0);
            testWithdraw = withdraws1.get(i);
            assertEquals(testAmounts[i], testWithdraw.getAmount(), 0);
        }

        // Deposit money in SAVING
        for (double testAmount : testAmounts) {
            testCustomer1.deposit(testAmount, date, Customer.SAVING);
        }

        // Withdraw money from SAVING
        for (double testAmount : testAmounts) {
            testCustomer1.withdraw(testAmount, date, Customer.SAVING);
        }

        // Assert that double the amount of Deposits and Withdraws have been created
        assertEquals(testAmounts.length * 2, deposits1.size());
        assertEquals(testAmounts.length * 2, withdraws1.size());

        // Assert that testAmount is equal to Deposit.amounts and Withdraw.amounts for SAVING
        for (int i = 0; i < testAmounts.length; i++) {
            testDeposit = deposits1.get(i + testAmounts.length);
            assertEquals(testAmounts[i], testDeposit.getAmount(), 0);
            testWithdraw = withdraws1.get(i + testAmounts.length);
            assertEquals(testAmounts[i], testWithdraw.getAmount(), 0);
        }

        // Assert that current balance in CHECKING and SAVING are equivalent to initial balance
        finalCheckingBalance = withdraws1.get(withdraws1.size() / 2 - 1);
        assertEquals(checkingBalance, finalCheckingBalance.getBalance(), 0);
        finalSavingBalance = withdraws1.get(withdraws1.size() - 1);
        assertEquals(savingBalance, finalSavingBalance.getBalance(), 0);

        // Display deposits and withdraws
        testCustomer1.displayDeposits();
        testCustomer1.displayWithdraws();
    }

    @Test
    public void testInvalidAmount() {
        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer1.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Create an array of invalid test amounts
        double[] testAmounts = {0, -1, 0.001, .00, 0.00, 0.0, 0.000, 1.1101, 1.124, -.0, -.01, 0.00000000001, 100.001};

        // Deposit and withdraw money with regard to CHECKING
        for (double testAmount : testAmounts) {
            testCustomer1.deposit(testAmount, date, Customer.CHECKING);
            testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        }

        // Assert that deposits and withdraws are empty
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Deposit and withdraw money with regard to SAVING
        for (double testAmount : testAmounts) {
            testCustomer1.deposit(testAmount, date, Customer.SAVING);
            testCustomer1.withdraw(testAmount, date, Customer.SAVING);
        }

        // Assert that deposits and withdraws are empty
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Try to display deposits and withdraws
        testCustomer1.displayDeposits();
        testCustomer1.displayWithdraws();
    }

    @Test
    public void testInvalidAccount() {
        // Create a test Customer with a valid name, an invalid repeat account number, and valid balances
        Customer testCustomer2 = new Customer("Test2", 1, 500, 400, accountManager);

        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer2.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer2.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Create an array of valid test amounts
        double[] testAmounts = {1, 1.1, 1.10, 1.01, 1.00, 1.000, 1.110, 1.50, .01, 00001.00, 00.01, 9999999.99};

        // Deposit and withdraw money with regard to an invalid account
        for (double testAmount : testAmounts) {
            testCustomer2.deposit(testAmount, date, "a");
            testCustomer2.withdraw(testAmount, date, "CHECKING");
        }

        // Assert that deposits and withdraws are empty
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Try to display deposits and withdraws
        testCustomer2.displayDeposits();
        testCustomer2.displayWithdraws();
    }

    @Test
    public void testOverdraft() {
        // Get withdraws
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();

        // Assert that there are 0 withdraws
        assertEquals(0, withdraws1.size());

        // Create an array of valid test amounts that will cause overdrafts
        double[] testAmounts = {checkingBalance + 1, savingBalance + 1, checkingBalance * 5, savingBalance * 5};

        // Withdraw money from CHECKING
        for (double testAmount : testAmounts) {
            testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        }

        // Assert that new Withdraws have been created
        assertEquals(testAmounts.length, withdraws1.size());

        // Assert that testAmount is equal to Withdraw.amounts
        for (int i = 0; i < testAmounts.length; i++) {
            testWithdraw = withdraws1.get(i);
            assertEquals(testAmounts[i], testWithdraw.getAmount(), 0);
        }

        // Withdraw money from SAVING
        for (double testAmount : testAmounts) {
            testCustomer1.withdraw(testAmount, date, Customer.SAVING);
        }

        // Assert that double the amount of Withdraws have been created
        assertEquals(testAmounts.length * 2, withdraws1.size());

        // Assert that testAmount is equal to Deposit.amounts and Withdraw.amounts for SAVING
        for (int i = 0; i < testAmounts.length; i++) {
            testWithdraw = withdraws1.get(i + testAmounts.length);
            assertEquals(testAmounts[i], testWithdraw.getAmount(), 0);
        }

        // Assert that current balance in CHECKING and SAVING are equivalent to initial balance - testAmounts
        for (double testAmount : testAmounts) {
            totalTestAmount += testAmount;
        }
        finalCheckingBalance = withdraws1.get(withdraws1.size() / 2 - 1);
        assertEquals(checkingBalance - totalTestAmount, finalCheckingBalance.getBalance(), 0);
        finalSavingBalance = withdraws1.get(withdraws1.size() - 1);
        assertEquals(savingBalance - totalTestAmount, finalSavingBalance.getBalance(), 0);

        // Assert that overdraft messages have been sent
        assertEquals(withdraws1.size(), testCustomer1.getOverdraftCounter());

        // Display deposits and withdraws
        testCustomer1.displayWithdraws();
    }
}
