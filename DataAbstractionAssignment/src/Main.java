import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        String exit = "e";
        String deposit = "1";
        String withdraw = "2";
        String displayDeposits = "3";
        String displayWithdrawals = "4";
        String checking = "1";
        String saving = "2";

        Customer John = new Customer("John", 1, 500.00, 400, accountManager);


        while (true) {
            System.out.println("""
                    Enter the corresponding letter or number to interact with the ATM.
                    1. Deposit
                    2. Withdraw
                    3. Display Deposits
                    4. Display Withdrawals
                    e. Exit""");

            Scanner userInput = new Scanner(System.in);
            String nextLine = userInput.nextLine();

            if (nextLine.equals(deposit)) {
                depositloop:
                while (true) {
                    System.out.println("""
                          Which account would you like to deposit in?
                          1. Checking
                          2. Saving
                          e. Exit""");

                    nextLine = userInput.nextLine();

                    if (nextLine.equals(checking) || nextLine.equals(saving)) {
                        while (true) {
                            System.out.println("How much would you like to deposit?");

                            if (userInput.hasNextDouble()) {
                                double nextDouble = userInput.nextDouble();

                                if (nextDouble <= 0) {
                                    System.out.println("Sorry, please enter an amount to deposit that's greater than " +
                                            "$0 next time.");
                                    userInput.nextLine();
                                    break;
                                }
                                else if (BigDecimal.valueOf(nextDouble).scale() > 2) {
                                    System.out.println("Sorry, please enter an amount to deposit that's 2 decimal " +
                                            "spaces or less next time.");
                                    userInput.nextLine();
                                    break;
                                }
                                else if (nextLine.equals(checking)) {
                                    John.deposit(nextDouble, new Date(), Customer.CHECKING);
                                    John.displayDeposits();
                                    break depositloop;
                                }
                                else {
                                    John.deposit(nextDouble, new Date(), Customer.SAVING);
                                    John.displayDeposits();
                                    break depositloop;
                                }
                            }

                            else {
                                System.out.println("Sorry, please enter a sufficient amount next time.");
                                userInput.nextLine();
                                break;
                            }
                        }
                    }

                    else if (nextLine.equals(exit)) {
                        System.out.println("Returning to the main menu...");
                        break;
                    }

                    else {
                        System.out.println("Sorry, please enter a valid letter or number.");
                    }
                }
            }

            else if (nextLine.equals(withdraw)) {
                withdrawloop:
                while (true) {
                    System.out.println("""
                          Which account would you like to withdraw from?
                          1. Checking
                          2. Saving
                          e. Exit""");

                    nextLine = userInput.nextLine();

                    if (nextLine.equals(checking) || nextLine.equals(saving)) {
                        while (true) {
                            System.out.println("How much would you like to withdraw?");

                            if (userInput.hasNextDouble()) {
                                double nextDouble = userInput.nextDouble();

                                if (nextDouble <= 0) {
                                    System.out.println("Sorry, please enter an amount to withdraw that's greater " +
                                            "than $0 next time.");
                                    userInput.nextLine();
                                    break;
                                }
                                else if (BigDecimal.valueOf(nextDouble).scale() > 2) {
                                    System.out.println("Sorry, please enter an amount to withdraw that's 2 decimal " +
                                            "spaces or less next time.");
                                    userInput.nextLine();
                                    break;
                                }
                                else if (nextLine.equals(checking)) {
                                    John.withdraw(nextDouble, new Date(), Customer.CHECKING);
                                    John.displayWithdraws();
                                    break withdrawloop;
                                }
                                else {
                                    John.withdraw(nextDouble, new Date(), Customer.SAVING);
                                    John.displayWithdraws();
                                    break withdrawloop;
                                }
                            }

                            else {
                                System.out.println("Sorry, please enter a sufficient amount next time.");
                                userInput.nextLine();
                                break;
                            }
                        }
                    }

                    else if (nextLine.equals(exit)) {
                        System.out.println("Returning to the main menu...");
                        break;
                    }

                    else {
                        System.out.println("Sorry, please enter a valid letter or number.");
                    }
                }
            }

            else if (nextLine.equals(displayDeposits)) {
                System.out.println("Displaying deposits...");
                John.displayDeposits();
            }

            else if (nextLine.equals(displayWithdrawals)) {
                System.out.println("Displaying withdrawals...");
                John.displayWithdraws();
            }

            else if (nextLine.equals(exit)) {
                System.out.println("Thank you for using the ATM.");
                break;
            }

            else {
                System.out.println("Sorry, please enter a valid number or letter.");
            }
        }
    }
}
