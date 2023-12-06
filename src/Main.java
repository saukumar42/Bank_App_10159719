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
    public static void main(String[] args) {

        Main obj = new Main();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank);
        System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

        try {
            obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedOperation);
        RBI o=new RBI();
        switch(obj.selectedOperation)
        {
            case 1:o.depositMoney();
            break;
            case 2:o.withdrawMoney();
            break;
            case 3:
             float amount,roi;
             int years;
            System.out.println("Enter the amount, rate of interest in percent and total period in years for which you want to open your FD");
            try {
                    amount = Float.parseFloat(obj.buff.readLine());
                    roi=Float.parseFloat(obj.buff.readLine());
                    years=Integer.parseInt(obj.buff.readLine());
                    o.openFD(amount,roi,years);

                }
            catch (IOException e) {
                    e.printStackTrace();
                }
            break;
            case 4:
            String loanType="";
            float loanAmount,loanRoi;
            int loanYears;
            System.out.println("Enter the amount, rate of interest in percent and total period in years for which you want to apply for loan");
                try {
                    loanAmount = Float.parseFloat(obj.buff.readLine());
                    loanRoi=Float.parseFloat(obj.buff.readLine());
                    loanYears=Integer.parseInt(obj.buff.readLine());
                    o.applyLoan(loanType,loanAmount,loanRoi,loanYears);
                 }
                catch (IOException e) {
                    e.printStackTrace();
                }
            break;
        }

    }
}