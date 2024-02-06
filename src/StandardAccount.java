public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.creditLimit = (creditLimit < 0) ? creditLimit : 0;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double allowedWithdrawal = balance + creditLimit;

        if (amount <= allowedWithdrawal) {
            balance -= amount;
            return amount;
        } else {
            // Not enough funds, withdraw what's available
            balance = 0.0;
            return allowedWithdrawal;
        }
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Standard Account #" + accountNumber + " - Balance: " + balance;
    }
}
