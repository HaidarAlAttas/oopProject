import java.sql.SQLOutput;
import java.util.Scanner;

public class Customer {
    private int customerId;
    private String name;
    private int licenseNumber;

    Scanner ans = new Scanner(System.in);

    // default constructor
    Customer(){
        this.customerId = 0;
        this.name = "John Pork";
        this.licenseNumber = 2000;
    }

    Customer(int customerId, String name, int licenseNumber){
        this.customerId = customerId;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    int getCustomerId(){
        return this.customerId;
    }

    // formatly print all the customer
    void viewCustomerFormatter(){
        System.out.println(
                "\nCustomer details: " +
                "\nCustomer id: " + customerId +
                "\nCustomer name: " + name +
                "\nLicense number: " + licenseNumber + "\n");
    }

    // case 10
    void listAllCustomer(Customer[] c){
        boolean hasCust = false;
        System.out.println("\n====== Customer details: ======");

        // FIX: check if array itself is null
        if (c != null) {
            for (Customer customerView : c) {
                if (customerView != null) {
                    customerView.viewCustomerFormatter();
                    hasCust = true;
                }
            }
        }

        // ending formatting
        if (hasCust) {
            System.out.println("==============================\n");
        } else {
            System.out.println("No customer was registered");
            System.out.println("==============================\n");
        }
    }

    // case 9
    Customer addCustomer(){
        try {
            System.out.print("Please enter customer id: ");
            this.customerId = ans.nextInt();
            ans.nextLine();

            System.out.print("Please enter customer name: ");
            this.name = ans.nextLine();

            System.out.print("Please enter customer license number: ");
            this.licenseNumber = ans.nextInt();

        } catch (Exception e) {
            System.out.println("Invalid input");
            ans.nextLine();
        }

        return new Customer(this.customerId,this.name, this.licenseNumber);
    }

    // case 11
    void assignCustToVehicle(Customer[] c, Vehicle[] v){
        Vehicle vehicleChosen = null;
        Customer customerChosen = null;

        // tanya customer list and vehicle list
        System.out.print("Enter Customer ID:");
        int custID = ans.nextInt();
        System.out.print("Enter Customer vehicle:");
        int vehicleID = ans.nextInt();

        // check for cust and vehicle (do for loop statement for both)
        for (Customer customerList: c){
            if(customerList != null && customerList.customerId == custID){
                customerChosen = customerList;
                break;
            }
        }

        for (Vehicle vehicleList: v){
            if(vehicleList != null && vehicleList.vehicleId == vehicleID ){
                vehicleChosen = vehicleList;
                break;
            }
        }

        // if found both
        if(customerChosen != null && vehicleChosen != null){
            vehicleChosen.setCustomer(customerChosen);
        }

        // else (return)
        else{
            return;
        }

    }
}
