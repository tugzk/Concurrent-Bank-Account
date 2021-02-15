package Main;

import Classes.CurrentBankAccount;
import Classes.Grandmother;
import Classes.LoanCompany;
import Classes.Student;
import Classes.University;

/**
 *
 * @author Tugrul
 */
public class BankingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Concurrent Banking System Begins...\n");

        //Creates Thread Groups
        ThreadGroup Institutions = new ThreadGroup("Institution");
        System.out.println("Thread Group Inistitution Created");

        ThreadGroup Humans = new ThreadGroup("Human");
        System.out.println("Thread Group Human Created\n");

        CurrentBankAccount bankaccount = new CurrentBankAccount("Tugrul Kara", 444);
        System.out.println("Current Account created\n");

        //Humans
        Student student = new Student(Humans, "Student", bankaccount);
        System.out.println("Student created\n");

        Grandmother grandmother = new Grandmother(Humans, "Grandmother", bankaccount, "Nanna");
        System.out.println("Grandmother created\n");

        //Institutions
        LoanCompany loanCompany = new LoanCompany(Institutions, "SFE", bankaccount, "Student Finance England");
        System.out.println("Loan company (SFE) created\n");

        University university = new University(Institutions, "Westminster", bankaccount, "Westminster");
        System.out.println("University created\n");

        //Starts all threads
        student.start();
        grandmother.start();
        loanCompany.start();
        university.start();

        System.out.println("\n All threads Activated. \n");

        try {
            student.join();
            grandmother.join();
            loanCompany.join();
            university.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        System.out.println("\nAll threads terminated.");

        bankaccount.printStatement();

        System.out.println("Concurrent bank account terminated!");
        System.out.print("Balance: " + "£" + bankaccount.getBalance() + "\n");

    }
}
