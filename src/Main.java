public class Main {
    public static void main(String[] args) {
        // Create a Bank
        IBank bank = new Bank();

        // Open StandardAccount
        IAccount standardAccount = new StandardAccount(1, -100);
        bank.OpenAccount(standardAccount);
        standardAccount.Deposit(200); // Deposit money into the account

        // Open BasicAccount
        IAccount basicAccount = new BasicAccount(2, 100);
        bank.OpenAccount(basicAccount);
        basicAccount.Deposit(50); // Deposit money into the account

        // Open PremiumAccount
        IAccount premiumAccount = new PremiumAccount(3);
        bank.OpenAccount(premiumAccount);
        premiumAccount.Deposit(1000); // Deposit money into the account

        // Perform transactions
        standardAccount.Withdraw(1010);
        basicAccount.Withdraw(10);
        premiumAccount.Withdraw(1010);

        // Display all accounts
        System.out.println("All accounts: " + bank.GetAllAccounts());

        // Display accounts in debt
        System.out.println("Accounts in debt: " + bank.GetAllAccountsInDebt());

        // Display accounts with balance above a certain amount
        System.out.println("Accounts with balance above 100: " + bank.GetAllAccountsWithBalance(100));

        // Display updated balances after transactions
        System.out.println("Updated balances after transactions:");
        System.out.println("StandardAccount: " + standardAccount.GetCurrentBalance());
        System.out.println("BasicAccount: " + basicAccount.GetCurrentBalance());
        System.out.println("PremiumAccount: " + premiumAccount.GetCurrentBalance());
    }
}
