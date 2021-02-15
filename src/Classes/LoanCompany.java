package Classes;

/**
 *
 * @author Tugrul
 */
public class LoanCompany extends Thread {

    private final BankAccount bankAccount;
    private final String companyName;

    public LoanCompany(ThreadGroup Institution, String name, BankAccount bankaccount, String companyName) {
        super(Institution, name);
        this.bankAccount = bankaccount;
        this.companyName = companyName;
    }

    public void SleepRandom() {
        try {
            sleep((long) (Math.random() * 40));
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        System.out.println("\nStudent Finance England begins to deposit funds");
        SleepRandom();
        Transaction lc1 = new Transaction(getName(), 9000);
        bankAccount.deposit(lc1);

        System.out.println("\nStudent Finance England deposits £9000");
        System.out.println(lc1.toString());

        //Second Transaction
        SleepRandom();
        Transaction lc2 = new Transaction(getName(), 9000);
        bankAccount.deposit(lc2);

        System.out.println("\nStudent Finance England £9000");
        System.out.println(lc2.toString());

        //Third Transaction
        SleepRandom();
        Transaction lc3 = new Transaction(getName(), 9000);
        bankAccount.deposit(lc3);

        System.out.println("\nStudent Finance England £9000");
        System.out.println(lc3.toString());

        System.out.println("\nStudent Finance England transactions complete....");
    }
}
