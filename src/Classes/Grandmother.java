package Classes;

/**
 *
 * @author Tugrul
 */
public class Grandmother extends Thread {

    private final BankAccount bankAccount;
    private final String grandmotherName;

    public Grandmother(ThreadGroup Human, String name, BankAccount bankaccount, String grandmothername) {
        super(Human, name);
        this.bankAccount = bankaccount;
        this.grandmotherName = grandmothername;
    }

    private void SleepRandom() {
        try {
            sleep((long) (Math.random() * 40));
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        System.out.println("\nGrandmother begins to deposit...");

        //First Transaction (deposit)
        SleepRandom();
        Transaction g1 = new Transaction(getName(), 500);
        System.out.println("\nGrandmother deposits £500");

        bankAccount.deposit(g1);
        System.out.println(g1.toString());

        //Second Transaction (deposit)
        SleepRandom();
        Transaction g2 = new Transaction(getName(), 500);
        bankAccount.deposit(g2);

        System.out.println("\nGrandmother deposits £500");
        System.out.println(g2.toString());

        System.out.println("\nGrandmother transactions complete....");
    }
}
