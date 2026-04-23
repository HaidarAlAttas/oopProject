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
                    boolean case1Repeater = true;
                    while (case1Repeater) {

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
                            case1Repeater = false;
                        } else {

                            // exception handling
                            if (ans2 == 1) {
                                v[k] = new Car().addVehicle(c);
                                case1Repeater = false;
                            } else if (ans2 == 2) {
                                v[k] = new Motorcycle().addVehicle(c);
                                case1Repeater = false;
                            } else {
                                System.out.println("Please insert a correct number");
                            }
                        }
                    }
                    break;


                // to view all vehicle available
                case 2:

                    // display all vehicle
                    vehicleList.listAllVehicle(v, c);
                    break;

                // this case is mainly using set and get method
                case 3:

                    //rent the car (have to receive the customer chosen to rent)
                    vehicleList.rentVehicle(v, c, vehicleList, custList);
                    break;

                // update vehicle's availability
                case 4:
                    vehicleList.updateAvailability(v, c, vehicleList);
                    break;

                // return vehicle
                case 5:
                    vehicleList.returnVehicle(v, c, vehicleList);
                    break;

                // mark vehicle available
                case 6:
                    vehicleList.markAvailable(v, c, vehicleList);
                    break;

                // search vehicles
                case 7:
                    vehicleList.searchVehicle(v, c);
                    break;

                // update vehicle details
                case 8:
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

                // view customers
                case 10:
                    custList.listAllCustomer(c);
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
