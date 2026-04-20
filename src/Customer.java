import java.util.Scanner;

public class Customer {
    private int customerId;
    private String name;
    private int licenseNumber;

    Scanner ans = new Scanner(System.in);

    Customer(int customerId, String name, int licenseNumber){
        this.customerId = customerId;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    // default constructor
    Customer(){
        this.customerId = 0;
        this.name = "John Pork";
        this.licenseNumber = 2000;
    }

    // formatly print all the customer
    void viewCustomerFormatter(){
        System.out.println(
                "\nCustomer details: " +
                "\nCustomer id: " + customerId +
                "\nCustomer name: " + name +
                "\nLicense number: " + licenseNumber);
    }

    // to list down all customer
    void listAllCustomer(Customer[] c){
        boolean hasVehicle = false;
        System.out.println("\n====== Customer details: ======");

        // FIX: check if array itself is null
        if (c != null) {
            for (Customer customerView : c) {
                if (customerView != null) {
                    customerView.viewCustomerFormatter();
                    hasVehicle = true;
                }
            }
        }

        // ending formatting
        if (hasVehicle) {
            System.out.println("==============================\n");
        } else {
            System.out.println("No customer was registered");
        }
    }

    // case 9
    Customer updateCustomer(){
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
}
