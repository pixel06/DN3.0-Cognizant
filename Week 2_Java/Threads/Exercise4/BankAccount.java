package Exercise4;

public class BankAccount {

    int balance = 0;

    public synchronized void deposit(int amount)
    {
        balance += amount;
        System.out.println(amount + " deposited." + " New Balance: "+ balance);
    }

    public synchronized void withdrawl(int amount)
    {
        if(balance >= amount)
        {
            balance -= amount;
        }
        else{
            System.out.println("Insufficient funds.");
        }
        System.out.println(amount + " withdrawl successfull. New Balance: " + balance);
    }

    public static void main(String[] args) {
        
        BankAccount acc = new BankAccount();

        Transaction t1 = new Transaction(acc, true, 200);
        Transaction t2 = new Transaction(acc, false, 150);
        Transaction t3 = new Transaction(acc, true, 100);
        Transaction t4 = new Transaction(acc, false, 50);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
class Transaction extends Thread
{
    BankAccount acc;
    boolean isDeposit;
    int amount;

    public Transaction(BankAccount acc, boolean isDeposit, int amount)
    {
        this.acc = acc;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override

    public void run()
    {
        if(isDeposit)
        {
            acc.deposit(amount);
        }
        else{
            acc.withdrawl(amount);
        }
    }
}
