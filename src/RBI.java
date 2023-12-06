import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RBI {
    double balance=0.0d;
    int withDrawCount=0;

    BufferedReader buff;
    InputStreamReader isr;

    public RBI()
    {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }
    public void depositMoney() {
        System.out.println("Enter the amount to be deposited");
        double amount;
        try {
            amount = Double.parseDouble(buff.readLine());
            if(amount<1000.0)
            {
                System.out.println("Please enter the deposit amount as atleast 1000 ");
                return;
            }
            balance=balance+amount;
            System.out.println("Your current balance is "+balance);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void withdrawMoney(){
        System.out.println("Enter the amount to be withdrawn");
        double amount;
        try{
            amount=Double.parseDouble(buff.readLine());

            if(amount<1000.0)
            {
                System.out.println("Please enter the withdrawal amount as atleast 1000");
                return;
            }
            else if(balance<amount)
            {
                System.out.println("You cannot withdraw money as your current balance is less than amount you are withdrawing");
            }
            balance=balance-amount;
            if(withDrawCount>=3)
            balance=balance-0.01*balance;
            withDrawCount++;

            System.out.println("Your current balance is "+balance);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openFD(float amount, float ROI, int years) {
        System.out.println("Your amount for "+years+" consecutive years is as follows");
        float newAmount=amount;
        for(int i=1;i<=years;i++)
        {
            newAmount=newAmount+(float)(ROI/100.0)*newAmount;
            System.out.println("Your amount at the end of year "+i+" is "+newAmount);
        }
        System.out.println("Total profit for the given FD is "+(newAmount-amount));
    }
    public void applyLoan(String loanType, float amount, float ROI, int years) {
        float newAmount=amount;
        for(int i=1;i<=years;i++)
        {
            newAmount=newAmount+(float)(ROI/100.0)*newAmount;
            System.out.println("Your amount at the end of year "+i+" is "+newAmount);
        }
        System.out.println("Total loan amount outstanding at the end of "+years+" years is "+newAmount);
    }
    public void applyCreditCard() {}
    public float getBalance() {
        return 0.0f;
    }
}