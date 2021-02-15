package Classes;

/**
 *
 * @author Tugrul
 */
public class University extends Thread {

    private final BankAccount bankAccount;
    private final String uniName;

    public University(ThreadGroup Institution, String name, BankAccount bankaccount, String uniName) {
        super(Institution, name);
        this.bankAccount = bankaccount;
        this.uniName = uniName;
    }

    public void SleepRandom() {
        try {
            sleep((int) (Math.random() * 40));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println(" \nUni begins to withdraw funds...");
        //Withdraws funds then sleeps for a random amount of time between each transaction
        //First Transaction
        SleepRandom();
        Transaction u1 = new Transaction(getName(), 9000);
        bankAccount.withdrawal(u1);

        System.out.println("\nWestminster University withdraws £9000");
        System.out.println(u1.toString());

        //Second Transaction
        SleepRandom();
        Transaction u2 = new Transaction(getName(), 9000);
        bankAccount.withdrawal(u2);

        System.out.println("\nWestminster University withdraws £9000");
        System.out.println(u2.toString());

        //Third Transaction
        SleepRandom();
        Transaction u3 = new Transaction(getName(), 9000);
        bankAccount.withdrawal(u3);

        System.out.println("\nWestminster University withdraws £9000");
        System.out.println(u3.toString());

        SleepRandom();

        System.out.println("Westminster University transactions complete....");
    }
}
