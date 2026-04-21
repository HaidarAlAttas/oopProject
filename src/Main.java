import java.util.Scanner;

public class Main {

    static void main() {
        Scanner ans = new Scanner(System.in);
        int answer;
        int option = 0;
        Vehicle[] v = new Vehicle[20];
        Customer[] c = new Customer[40];
        Vehicle vehicleList = new Vehicle();
        Customer custList = new Customer();

        while (option != 67) {

            // display menu from vehicle class
            answer = vehicleList.menu();

            // process the answer
            switch (answer) {

                // to add new vehicle
                case 1:
                    int ans2;

                    System.out.print("1 = add new car\n2 = add new motorcycle\nChoose your input:");
                    ans2 = ans.nextInt();

                    int k = -1;

                    for (int i = 0; i < v.length; i++) {
                        if (v[i] == null) {
                            k = i;
                            break;
                        }
                    }

                    if (k == -1) {
                        System.out.println("Vehicle is full");
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

                    // display all vehicle
                    vehicleList.listAllVehicle(v,c);
                    break;

                // this case is mainly using set and get method
                case 3:

                    //rent the car (have to receive the customer chosen to rent)
                    vehicleList.rentVehicle(v,c,custList);
                    break;

                    // case 4
                case 4:

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
