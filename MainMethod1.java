import java.util.Scanner;

class BankAccountDetail {
    private double Balance;

    public BankAccountDetail(double Balance) {
        this.Balance = Balance;
    }

    public boolean deposit(double Amount) {
        if (Amount > 0) {
            this.Balance += Amount;
            return true;
        } else {
            System.out.println("Invalid amount for deposit.");
            return false;
        }
    }

    public boolean withdraw(double Amount) {
        if (Amount > 0 && Amount <= Balance) {
            this.Balance -= Amount;
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal.");
            return false;
        }
    }

    public double checkBalance() {
        return Balance;
    }
}

class ATM {
    private BankAccountDetail bankAccount;

    public ATM(BankAccountDetail bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw(double Amount) {
        if (bankAccount.withdraw(Amount)) {
            System.out.println("Withdrawal successful. Current balance: " + bankAccount.checkBalance());
        }
    }

    public void deposit(double Amount) {
        if (bankAccount.deposit(Amount)) {
            System.out.println("Deposit successful. Current balance: " + bankAccount.checkBalance());
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + bankAccount.checkBalance());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    withdraw(withdrawAmount);
                    break;
                case "2":
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    deposit(depositAmount);
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class MainMethod1 {
    public static void main(String[] args) {
        BankAccountDetail bankAccount = new BankAccountDetail(1000);
        ATM atm = new ATM(bankAccount);
        atm.run();
    }
}
