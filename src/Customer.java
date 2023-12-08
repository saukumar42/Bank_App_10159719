import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customer {
    String customerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone,customerAccountNumber;

    int withDrawCount=0;

    double balance;

    BufferedReader buff;
    InputStreamReader isr;
    public Customer(String bankName) {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
        System.out.println("Enter customer name, customer email, customer address, customer gender, customer aadhar, customer phone");

        try {
            customerName = buff.readLine();
            customerEmail=buff.readLine();
            customerAddress=buff.readLine();
            customerGender=buff.readLine();
            customerAadhar=buff.readLine();
            customerPhone=buff.readLine();
            this.customerAccountNumber=bankName+"_"+customerAadhar;
        }catch(IOException e) {
            e.printStackTrace();
        }
//        customerAccountNumber=bankName+"_"+customerAadhar;


    }

    public Customer(String customerName, String customerEmail, String customerAddress, String customerGender, String customerAadhar, String customerPhone, float balance) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerGender = customerGender;
        this.customerAadhar = customerAadhar;
        this.customerPhone = customerPhone;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAadhar() {
        return customerAadhar;
    }

    public void setCustomerAadhar(String customerAadhar) {
        this.customerAadhar = customerAadhar;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        balance=amount;


    }
    public String getAccountNumber()
    {
        return this.customerAccountNumber;
    }

}