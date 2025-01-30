import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTests {

    private final double testAmount = 1;
    private final Date date = new Date();
    private Deposit testDeposit;
    private Withdraw testWithdraw;
    private final AccountManager accountManager = new AccountManager();

    @Test
    public void testValidCustomer() {
        // Create a test Customer with a valid name, account number, and balances
        Customer testCustomer1 = new Customer("Test1", 1, 500, 400, accountManager);

        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer1.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Deposit and withdraw money with regard to CHECKING and SAVING
        testCustomer1.deposit(testAmount, date, Customer.CHECKING);
        testCustomer1.deposit(testAmount, date, Customer.SAVING);
        testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer1.withdraw(testAmount, date, Customer.SAVING);

        // Assert that new Deposits and Withdraws have been created
        assertEquals(2, deposits1.size());
        assertEquals(2, withdraws1.size());

        // Assert that testAmount is equal to Deposit.amounts and Withdraw.amounts
        testDeposit = deposits1.get(0);
        assertEquals(testAmount, testDeposit.getAmount(), 0);
        testDeposit = deposits1.get(1);
        assertEquals(testAmount, testDeposit.getAmount(), 1);
        testWithdraw = withdraws1.get(0);
        assertEquals(testAmount, testWithdraw.getAmount(), 0);
        testWithdraw = withdraws1.get(1);
        assertEquals(testAmount, testWithdraw.getAmount(), 1);

        // Display deposits and withdraws
        testCustomer1.displayDeposits();
        testCustomer1.displayWithdraws();
    }

    @Test
    public void testInvalidCustomerForInvalidAccountNumberThatIs0OrLower() {
        // Create test Customers with valid names, invalid account numbers that are 0 or lower, and valid balances
        Customer testCustomer1 = new Customer("Test1", 0, 500, 400, accountManager);
        Customer testCustomer2 = new Customer("Test2", -1, 500, 400, accountManager);

        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer1.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();
        ArrayList<Deposit> deposits2 = testCustomer2.getDeposits();
        ArrayList<Withdraw> withdraws2 = testCustomer2.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());
        assertEquals(0, deposits2.size());
        assertEquals(0, withdraws2.size());

        // Try to deposit and withdraw money with regard to CHECKING and SAVING
        testCustomer1.deposit(testAmount, date, Customer.CHECKING);
        testCustomer1.deposit(testAmount, date, Customer.SAVING);
        testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer1.withdraw(testAmount, date, Customer.SAVING);
        testCustomer2.deposit(testAmount, date, Customer.CHECKING);
        testCustomer2.deposit(testAmount, date, Customer.SAVING);
        testCustomer2.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer2.withdraw(testAmount, date, Customer.SAVING);

        // Assert that deposits and withdraws are empty
        assertTrue(deposits1.isEmpty());
        assertTrue(withdraws1.isEmpty());
        assertTrue(deposits2.isEmpty());
        assertTrue(withdraws2.isEmpty());

        // Try to display deposits and withdraws
        testCustomer1.displayDeposits();
        testCustomer1.displayWithdraws();
        testCustomer2.displayDeposits();
        testCustomer2.displayWithdraws();
    }

    @Test
    public void testInvalidCustomerForInvalidRepeatAccountNumber() {
        // Create test Customers with valid names, repeating account numbers, and valid balances
        Customer testCustomer1 = new Customer("Test1", 1, 500, 400, accountManager);
        Customer testCustomer2 = new Customer("Test2", 1, 500, 400, accountManager);

        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer1.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();
        ArrayList<Deposit> deposits2 = testCustomer2.getDeposits();
        ArrayList<Withdraw> withdraws2 = testCustomer2.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());
        assertEquals(0, deposits2.size());
        assertEquals(0, withdraws2.size());

        // Try to deposit and withdraw money with regard to CHECKING and SAVING
        testCustomer1.deposit(testAmount, date, Customer.CHECKING);
        testCustomer1.deposit(testAmount, date, Customer.SAVING);
        testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer1.withdraw(testAmount, date, Customer.SAVING);
        testCustomer2.deposit(testAmount, date, Customer.CHECKING);
        testCustomer2.deposit(testAmount, date, Customer.SAVING);
        testCustomer2.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer2.withdraw(testAmount, date, Customer.SAVING);

        // Assert that deposits and withdraws have been made or are empty
        assertEquals(2, deposits1.size());
        assertEquals(2, withdraws1.size());
        assertTrue(deposits2.isEmpty());
        assertTrue(withdraws2.isEmpty());

        // Try to display deposits and withdraws
        testCustomer1.displayDeposits();
        testCustomer1.displayWithdraws();
        testCustomer2.displayDeposits();
        testCustomer2.displayWithdraws();
    }

    @Test
    public void testValidCustomerForValidBalanceThatIs0OrLower() {
        // Create a test Customer with a valid name, account number, and balances that are 0 or lower
        Customer testCustomer1 = new Customer("Test1", 1, 0, -1, accountManager);

        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer1.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Deposit and withdraw money with regard to CHECKING and SAVING
        testCustomer1.deposit(testAmount, date, Customer.CHECKING);
        testCustomer1.deposit(testAmount, date, Customer.SAVING);
        testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer1.withdraw(testAmount, date, Customer.SAVING);

        // Assert that new Deposits and Withdraws have been created
        assertEquals(2, deposits1.size());
        assertEquals(2, withdraws1.size());

        // Assert that testAmount is equal to Deposit.amounts and Withdraw.amounts
        testDeposit = deposits1.get(0);
        assertEquals(testAmount, testDeposit.getAmount(), 0);
        testDeposit = deposits1.get(1);
        assertEquals(testAmount, testDeposit.getAmount(), 1);
        testWithdraw = withdraws1.get(0);
        assertEquals(testAmount, testWithdraw.getAmount(), 0);
        testWithdraw = withdraws1.get(1);
        assertEquals(testAmount, testWithdraw.getAmount(), 1);

        // Display deposits and withdraws
        testCustomer1.displayDeposits();
        testCustomer1.displayWithdraws();
    }

    @Test
    public void testValidCustomerForValidBalanceWithMoreThan2DecimalPlaces() {
        // Create a test Customer with a valid name, account number, and balances with more than 2 decimal places
        Customer testCustomer1 = new Customer("Test1", 1, 1.000, 0.00000000, accountManager);

        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer1.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());

        // Deposit and withdraw money with regard to CHECKING and SAVING
        testCustomer1.deposit(testAmount, date, Customer.CHECKING);
        testCustomer1.deposit(testAmount, date, Customer.SAVING);
        testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer1.withdraw(testAmount, date, Customer.SAVING);

        // Assert that new Deposits and Withdraws have been created
        assertEquals(2, deposits1.size());
        assertEquals(2, withdraws1.size());

        // Assert that testAmount is equal to Deposit.amounts and Withdraw.amounts
        testDeposit = deposits1.get(0);
        assertEquals(testAmount, testDeposit.getAmount(), 0);
        testDeposit = deposits1.get(1);
        assertEquals(testAmount, testDeposit.getAmount(), 1);
        testWithdraw = withdraws1.get(0);
        assertEquals(testAmount, testWithdraw.getAmount(), 0);
        testWithdraw = withdraws1.get(1);
        assertEquals(testAmount, testWithdraw.getAmount(), 1);

        // Display deposits and withdraws
        testCustomer1.displayDeposits();
        testCustomer1.displayWithdraws();
    }

    @Test
    public void testInvalidCustomerForInvalidBalanceWithMoreThan2DecimalPlaces() {
        // Create test Customers with valid names, account numbers, and invalid balances with more than 2 decimal places
        Customer testCustomer1 = new Customer("Test1", 1, 1.001, 135.43576, accountManager);
        Customer testCustomer2 = new Customer("Test2", 2, 1.000, 135.43576, accountManager);

        // Get deposits and withdraws
        ArrayList<Deposit> deposits1 = testCustomer1.getDeposits();
        ArrayList<Withdraw> withdraws1 = testCustomer1.getWithdraws();
        ArrayList<Deposit> deposits2 = testCustomer2.getDeposits();
        ArrayList<Withdraw> withdraws2 = testCustomer2.getWithdraws();

        // Assert that there are 0 deposits or withdraws
        assertEquals(0, deposits1.size());
        assertEquals(0, withdraws1.size());
        assertEquals(0, deposits2.size());
        assertEquals(0, withdraws2.size());

        // Try to deposit and withdraw money with regard to CHECKING and SAVING
        testCustomer1.deposit(testAmount, date, Customer.CHECKING);
        testCustomer1.deposit(testAmount, date, Customer.SAVING);
        testCustomer1.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer1.withdraw(testAmount, date, Customer.SAVING);
        testCustomer2.deposit(testAmount, date, Customer.CHECKING);
        testCustomer2.deposit(testAmount, date, Customer.SAVING);
        testCustomer2.withdraw(testAmount, date, Customer.CHECKING);
        testCustomer2.withdraw(testAmount, date, Customer.SAVING);

        // Assert that deposits and withdraws are empty
        assertTrue(deposits1.isEmpty());
        assertTrue(withdraws1.isEmpty());
        assertTrue(deposits2.isEmpty());
        assertTrue(withdraws2.isEmpty());

        // Try to display deposits and withdraws
        testCustomer1.displayDeposits();
        testCustomer1.displayWithdraws();
        testCustomer2.displayDeposits();
        testCustomer2.displayWithdraws();
    }
}
