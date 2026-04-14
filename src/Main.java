import java.util.Scanner;

public class Main {

    static void main() {
        Scanner ans = new Scanner(System.in);
        int answer = 0;
        int option = 0;
        Vehicle[] v = new Vehicle[20];
        Customer[] c = new Customer[40];

        while (option != 67) {
            System.out.println("Welcome to the Vehicle Rental Management System");
            System.out.println("Vehicle:");
            System.out.println("1. Add new Vehicle" +
                    "\n2. View Vehicle" +
                    "\n3. Rent Vehicle" +
                    "\n4. Update Vehicle's Availability" +
                    "\n5. Return Vehicle" +
                    "\n6. Mark Vehicle available" +
                    "\n7. Search Vehicle" +
                    "\n8. Update Vehicle details" + //by brand or type
                    "\nCustomer:" +
                    "\n9. Add new Customer" +
                    "\n10. View Customers" +
                    "\n11. Assign Customer to Vehicle" +
                    "\n12. Remove Customer reference" +
                    "\n13. Search Customer" + //by name or id
                    "\n14. Update Customer details" +
                    "\n67. Leave program");
            System.out.print("Enter your choice:");
            answer = ans.nextInt();


            switch (answer) {

                // to add new vehicle
                case 1:
                    int ans2 = 1;

                    System.out.println("1 = add new car\n2 = add new motorcycle\nChoose your input:");
                    ans2 = ans.nextInt();

                    int k = -1;

                    for (int i = 0; i < v.length; i++) {
                        if (v[i] == null) {
                            k = i;
                            break;
                        }
                    }

                    if (k == -1) {
                        System.out.println("Vehicle is already full");
                    } else {

                        if (ans2 == 1) {
                            v[k] = new Car().addVehicle(c);
                        } else {
                            v[k] = new Motorcycle().addVehicle(c);
                        }
                    }

                    break;


                // to view all vehicle available
                case 2:

                    System.out.println("Vehicle details:");
                    boolean hasVehicle = false;

                    // ni create object of v, nanti dia go through v1[0],v1[1],...
                    for (Vehicle vC : v) {
                        if (vC != null) {
                            vC.viewVehicle();
                            hasVehicle = true;
                        }
                    }

                    // if takde vehicle object dalam array, it will display this
                    if (!hasVehicle) {
                        System.out.println("No vehicle to be viewed");
                    }
                    break;

                // to add new customer
                case 9:
                    int g = -1;

                    for (int i = 0; i < c.length; i++) {
                        if (c[i] == null) {
                            g = i;
                            break;
                        }
                    }

                    if (g == -1) {
                        System.out.println("Array of customer is already full");
                    } else {

                        c[g] = new Customer().updateCustomer();
                    }
                    break;

                // to quit the program
                case 67:
                    option = 67;
                    break;

                // exception handling
                default:
                    System.out.println("Please enter a valid number of option");
                    break;

            }
        }


    }
}