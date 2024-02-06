public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.withdrawalLimit = (withdrawalLimit > 0) ? withdrawalLimit : 0;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double allowedWithdrawal = Math.min(balance, withdrawalLimit);

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
        return "Basic Account #" + accountNumber + " - Balance: " + balance;
    }
}
