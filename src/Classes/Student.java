package Classes;

/**
 *
 * @author Tugrul
 */
public class Student extends Thread {

    private final BankAccount bankAccount;

    public Student(ThreadGroup Human, String name, BankAccount bankaccount) {
        super(Human, name);
        this.bankAccount = bankaccount;
    }

    private void SleepRandom() {
        try {
            sleep((long) (Math.random() * 40));
        } catch (InterruptedException e) {
        }
    }

    //Student does transaction on account then sleeps between each transaction
    @Override
    public void run() {

        System.out.println("Student begins to withdraw/deposit...");

        //First Transaction (deposit)
        Transaction s1 = new Transaction(getName(), 1000);
        System.out.println("\nStudent deposits £1000");

        SleepRandom();

        bankAccount.deposit(s1);
        System.out.println(s1.toString());

        //Second Transaction (deposit)
        SleepRandom();

        Transaction s2 = new Transaction(getName(), 1500);
        bankAccount.deposit(s2);

        System.out.println("\nStudent deposits £1500");
        System.out.println(s2.toString());

        //Third Transaction (withdrawal)
        SleepRandom();

        Transaction s3 = new Transaction(getName(), 2000);
        bankAccount.deposit(s3);

        System.out.println("\nStudent deposits £2000");
        System.out.println(s3.toString());

        //Fourth Transaction (withdrawal)
        Transaction s4 = new Transaction(getName(), 500);
        bankAccount.withdrawal(s4);

        System.out.println("\nStudent withdraws £500");
        System.out.println(s4.toString());

        SleepRandom();

        //Fifth Transaction (withdrawal)
        Transaction s5 = new Transaction(getName(), 550);
        bankAccount.withdrawal(s5);

        System.out.println("\nStudent withdraws £550");
        System.out.println(s5.toString());

        SleepRandom();

        //Sixth Transaction (withdrawal)
        Transaction s6 = new Transaction(getName(), 600);
        bankAccount.withdrawal(s6);

        System.out.println("\nStudent withdraws £600");
        System.out.println(s6.toString());

        SleepRandom();

        System.out.println("Student transactions complete....");
    }
}
