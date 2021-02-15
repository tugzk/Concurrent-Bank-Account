package Classes;

/**
 *
 * @author Tugrul
 */
public class CurrentBankAccount implements BankAccount {

    private int balance = 5000;
    private final int accountNumber;
    private final String accountHolder;
    private final Statement statement;

    public CurrentBankAccount(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.statement = new Statement(accountHolder, accountNumber);
    }

    //Getters
    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolder() {

        System.out.println("Account name is " + accountHolder);
        return accountHolder;
    }

    //Deposit Method
    @Override
    public synchronized void deposit(Transaction t) {
        if (this.isOverdrawn()) {
            System.out.println("Bank account is overdrawn");
        }
        balance += t.getAmount();
        statement.addTransaction(t.getCID(), t.getAmount(), balance);

        notifyAll();
    }

    //Withdrawal Method
    @Override
    public synchronized void withdrawal(Transaction t) {
        if (t.getAmount() > 0) {

            //If bank account is overdrawn, program terminates
            if (this.isOverdrawn()) {
                System.out.println("Cannot withdraw when bank account is overdrawn");
                System.exit(0);
            }
            int amount = t.getAmount();
            while (this.balance < amount) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            balance -= t.getAmount();
            statement.addTransaction(t.getCID(), -t.getAmount(), balance);
        }
    }

    //Overdrawn Method
    @Override
    public boolean isOverdrawn() {
        if (balance < 0) {
            return true;
        }
        return false;
    }

    //Print Statement Method
    @Override
    public void printStatement() {
        statement.print();
    }
}
