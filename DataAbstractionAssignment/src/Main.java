import java.util.Date;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();

        Customer John = new Customer("John", 1, 500.00, 400, accountManager);
        Customer Bill = new Customer("Bill", 2, 500.001, 400, accountManager);
        Customer Mike = new Customer("Mike", 1, 500.001, 400, accountManager);
        //Customer Sam = new Customer("Sam", 3, 500.00, 400.001);
        //Customer Tim = new Customer("Tim", 2, 250, 800);
        //B.deposit(200, new Date(), Customer.CHECKING);

        John.deposit(200, new Date(), Customer.CHECKING);
        John.deposit(200, new Date(), Customer.CHECKING);
        //John.deposit(246.2213, new Date(106, 2, 12, 6, 0), Customer.SAVING);
        //John.deposit(0, new Date(), Customer.CHECKING);
        //John.deposit(-1, new Date(), Customer.CHECKING);
        //John.deposit(0.001, new Date(), Customer.CHECKING);
        //John.deposit(2, new Date(), "a");
        //Bill.deposit(1, new Date(), Customer.CHECKING);
        //Mike.deposit(1, new Date(), Customer.CHECKING);
        //Sam.deposit(1, new Date(), Customer.CHECKING);

        John.withdraw(1000.500, new Date(), Customer.CHECKING);
        //John.withdraw(1001.500, new Date(), Customer.CHECKING);
        //John.withdraw(135.33, new Date(106, 2, 12, 6, 0), Customer.SAVING);
        //John.withdraw(0, new Date(), Customer.CHECKING);
        //John.withdraw(-1, new Date(), Customer.CHECKING);
        //John.withdraw(0.001, new Date(), Customer.CHECKING);
        //John.withdraw(2, new Date(), "a");
        //Bill.withdraw(1, new Date(), Customer.CHECKING);
        //Mike.withdraw(1, new Date(), Customer.CHECKING);
        //Sam.withdraw(1, new Date(), Customer.CHECKING);

        John.displayDeposits();
        John.displayWithdraws();

        /*
        Tim.deposit(400, new Date(), Customer.CHECKING);
        Tim.withdraw(200.41, new Date(), Customer.CHECKING);

        Tim.displayDeposits();
        Tim.displayWithdraws();
         */
    }
}
