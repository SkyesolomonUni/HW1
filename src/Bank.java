import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0) {
                    accounts.remove(account);
                    return; // Account found and removed, exit the method
                } else {
                    System.out.println("Account not closed due to debt.");
                    return; // Account found but not removed, exit the method
                }
            }
        }
        // If account not found, the method ends without any action
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(accounts); // Return a copy of the accounts list
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> inDebtAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                inDebtAccounts.add(account);
            }
        }
        return inDebtAccounts;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    }
}