import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AXIS implements RBII{
    final double minBalance=9000;

    HashMap<String,Customer>accountsMap=new HashMap<String,Customer>();

     double[] loanRois =new double[]{5,7,9,11};
     double fdRoi=8.5;



    BufferedReader buff;
    InputStreamReader isr;

    public AXIS()
    {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }
    public void createBankAccount(HashSet<Customer>customersAuthenticated)
    {

        Customer cust=new Customer("AXIS");

        if(accountsMap.get(cust.getAccountNumber())!=null)
        {
            System.out.println("There already exists one account number with this aadhar number!");
            cust=null;
            return;
        }

        accountsMap.put(cust.getAccountNumber(),cust);
        System.out.println("Your Axis bank account has been successfull created");
        customersAuthenticated.add(cust);
    }
    public void depositMoney(Customer c) {
        System.out.println("Enter the amount to be deposited");
        double amount;
        try {
            amount = Double.parseDouble(buff.readLine());
            if(amount<1000.0)
            {
                System.out.println("Please enter the deposit amount as atleast 1000 ");
                return;
            }
            c.setBalance(c.getBalance()+amount);
            System.out.println("Your current balance in the axis bank is "+c.getBalance());

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void withdrawMoney(Customer c){
        System.out.println("Enter the amount to be withdrawn");
        double amount;
        try{
            amount=Double.parseDouble(buff.readLine());

            if(amount<1000.0)
            {
                System.out.println("Please enter the withdrawal amount as atleast 1000");
                return;
            }
            else if(c.getBalance()<amount)
            {
                System.out.println("You cannot withdraw money as your current balance is less than amount you are withdrawing");
                return;
            }
            c.setBalance(c.getBalance()-amount);
            if(c.withDrawCount>=3)
                c.setBalance(c.getBalance()-0.01*c.getBalance());
            c.withDrawCount++;

            System.out.println("Your current balance in the axis bank is "+c.getBalance());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openFD(float amount, int years) {
        System.out.println("Your amount for "+years+" consecutive years is as follows");
        float newAmount=amount;
        for(int i=1;i<=years;i++)
        {
            newAmount=newAmount+(float)(fdRoi/100.0)*newAmount;
            System.out.println("Your amount at the end of year "+i+" is "+newAmount);
        }
        System.out.println("Total profit for the given FD is "+(newAmount-amount));
    }
    public void applyLoan( Customer c,float amount, int years) {
         if(c.getBalance()<2*minBalance) {
             System.out.println("You are not eligible for applying loan as your balance is less than twice of minimum balance!");
             return;
         }
        double roi=0.0d;
        System.out.println("Enter the type of loan\n1. Home Loan\n2. Education Loan\n3. Personal Loan\n 4. Car Loan");

        try {
            int loanType = Integer.parseInt(buff.readLine());
            roi=loanRois[loanType-1];
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        float newAmount=amount;
        for(int i=1;i<=years;i++)
        {
            newAmount=newAmount+(float)(roi/100.0)*newAmount;
            System.out.println("Your amount at the end of year "+i+" is "+newAmount);
        }
        System.out.println("Total loan amount outstanding at the end of "+years+" years is "+newAmount);
    }
    public void applyCreditCard(Customer c) {
        if(c.getBalance()>=2*minBalance)
        {
            System.out.println("Congratulations! You have successfully created credit card.");
        }
        else
        {
            System.out.println("You are not eligible for creating credit card as your balance is less than twice the minimum balance.");
        }
    }
    public double getBalance() {
        return 0.0d;
    }

    public  HashMap<String,Customer> getAccountsMap()
    {
        return accountsMap;
    }
}
