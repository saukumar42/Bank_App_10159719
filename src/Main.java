import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank, selectedOperation;

    static void utilBankOperation(int bankOperation,int selectedBank,Main obj,Customer c)
    {
        RBII mRBI = null;
        if(selectedBank == 1) {
            mRBI = new ICICI();
        }
        else if(selectedBank == 2 ) {
            mRBI = new HDFC();
        }else if(selectedBank == 3 ) {
            mRBI = new SBI();
        }else if(selectedBank == 4 ) {
            mRBI = new AXIS();
        }
        else if(selectedBank == 5 ) {
            mRBI = new IDFC();
        }
        switch(bankOperation)
        {
            case 1:
                mRBI.depositMoney(c);
                break;
            case 2:
                mRBI.withdrawMoney(c);
                break;
            case 3:
                float amount, roi;
                int years;
                System.out.println("Enter the amount and total period in years for which you want to open your FD");
                try {
                    amount = Float.parseFloat(obj.buff.readLine());
                    years = Integer.parseInt(obj.buff.readLine());
                    mRBI.openFD(amount, years);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:

                float loanAmount;
                int loanYears;
                System.out.println("Enter the amount and total period in years for which you want to apply for loan");
                try {
                    loanAmount = Float.parseFloat(obj.buff.readLine());
                    loanYears = Integer.parseInt(obj.buff.readLine());
                    mRBI.applyLoan( c,loanAmount, loanYears);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                mRBI.applyCreditCard(c);
            break;
        }
    }
    public static void main(String[] args) {

        Main obj = new Main();
        Customer cust=new Customer();
        String [] bankNames={"ICICI","HDFC","SBI","AXIS","IDFC"};
        String [] bankOperations={"Deposit","Withdrawal","OpenFD","Apply Loan","Apply Credit Card"};

        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Welcome to " + bankNames[obj.selectedBank-1]+" bank!");
        while(true) {


        int selectedBank=obj.selectedBank;

        System.out.println("Select your choice\n1. Deposit\n2. Withdraw\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

            try {
                obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Customer Selected " + bankOperations[obj.selectedOperation-1]+" operation.");

            switch (obj.selectedOperation) {
                case 1:
                    utilBankOperation(1,obj.selectedBank,obj,cust);

                    break;
                case 2:
                    utilBankOperation(2,obj.selectedBank,obj,cust);
                    break;
                case 3:
                    utilBankOperation(3,obj.selectedBank,obj,cust);
                    break;
                case 4:
                    utilBankOperation(4,obj.selectedBank,obj,cust);
                    break;
                case 5:
                    utilBankOperation(5,obj.selectedBank,obj,cust);
                    break;
                default:System.out.println("Please enter valid bank operation!");
            }
            System.out.println("Do you want to continue? Press Yes or No");
            try {
                String str = obj.buff.readLine();
                if(str.equalsIgnoreCase("No")) break;
            }catch(IOException e) {
                e.printStackTrace();
            }
        }

    }
}