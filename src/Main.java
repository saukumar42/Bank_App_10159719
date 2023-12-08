import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;



    SBI sbiRBI=new SBI();

    static String [] bankNames={"ICICI","HDFC","SBI","AXIS","IDFC"};
    static String [] bankOperations={"Deposit","Withdrawal","OpenFD","Apply Loan","Apply Credit Card","Create Bank Account"};
    static List<RBII> bankList;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
        if(bankList == null){
            bankList = new ArrayList<RBII>();
            bankList.add(new ICICI());
            bankList.add(new HDFC());
            bankList.add(new SBI());
            bankList.add(new AXIS());
            bankList.add(new IDFC());
        }

    }

    int selectedBank, selectedOperation;

      static Customer bankAuthenticationUtil(Main obj)
    {

        Customer cust=null;

        System.out.println("Please enter your "+bankNames[obj.selectedBank-1]+" bank account number!");
        String acc_no="";
        try {
             acc_no = obj.buff.readLine();
              RBII mRBI = bankList.get(obj.selectedBank-1);
              if(mRBI.getAccountsMap().get(acc_no)!=null)
                  return cust=mRBI.getAccountsMap().get(acc_no);
              return cust;
        }catch (IOException e) {
            e.printStackTrace();
        }
       return cust;


    }

     static void utilBankOperation(int bankOperation,int selectedBank,Main obj,Customer c,Object []banksObjectArray)
    {
        RBII mRBI = bankList.get(selectedBank-1);
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
            case 6:mRBI.createBankAccount();
            break;
        }
    }
    public static  void main(String[] args) {

        Main obj = new Main();
        Object[] banksObjectArray={new ICICI(),new HDFC(),new SBI(),new AXIS(),new IDFC()};



        while(true) {
            System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

            try {
                obj.selectedBank = Integer.parseInt(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Customer selected " + bankNames[obj.selectedBank-1]+" bank!");
            Customer cust=bankAuthenticationUtil(obj);
            if(cust==null)
            {
                System.out.println("Either the given acc_no does not exist or is incorrect.");
                System.out.println("Please enter 6 to create your new bank account no in case you have not created in it!");
                int choice=-1;
                try {
                    choice = Integer.parseInt(obj.buff.readLine());

                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(choice==6)
                utilBankOperation(6,obj.selectedBank,obj,cust,banksObjectArray);
                else
                System.out.println("Invalid choice entered!");

                continue;
            }

            while (true) {


                int selectedBank = obj.selectedBank;

                System.out.println("Select your choice\n1. Deposit\n2. Withdraw\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6. Create Bank Account");

                try {
                    obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Customer Selected " + bankOperations[obj.selectedOperation - 1] + " operation.");

                switch (obj.selectedOperation) {
                    case 1:
                        utilBankOperation(1, obj.selectedBank, obj, cust,banksObjectArray);

                        break;
                    case 2:
                        utilBankOperation(2, obj.selectedBank, obj, cust,banksObjectArray);
                        break;
                    case 3:
                        utilBankOperation(3, obj.selectedBank, obj, cust,banksObjectArray);
                        break;
                    case 4:
                        utilBankOperation(4, obj.selectedBank, obj, cust,banksObjectArray);
                        break;
                    case 5:
                        utilBankOperation(5, obj.selectedBank, obj, cust,banksObjectArray);
                        break;
                    case 6:
                        utilBankOperation(6,obj.selectedBank,obj,cust,banksObjectArray);
                    default:
                        System.out.println("Please enter valid bank operation!");
                }
                System.out.println("Do you want to continue? Press Yes or No");
                try {
                    String str = obj.buff.readLine();
                    if (str.equalsIgnoreCase("No")) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}