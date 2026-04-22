import java.util.Scanner;

public class Vehicle {

    protected int vehicleId;
    protected String brand;
    protected double rentalRate;
    protected boolean isAvailable;
    protected Customer customer;
    protected int custLoc;
    Scanner ans = new Scanner(System.in);

    public Vehicle() {
    }

    // to get the is available variable
    boolean getAvailable() {
        return isAvailable;
    }

    // for overriding purpose
    void viewVehicleFormatter(Customer[] c) {
        System.out.println("Vehicle ID: " + vehicleId +
                "\nBrand: " +
                "\nRental Rate: " +
                "\nAvailability: " +
                "\nCustomer details: ");
    }

    // to set the is available variable
    void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    boolean listAllVehicle(Vehicle[] v, Customer[] c) {

        boolean hasVehicle = false;
        System.out.println("\n====== Vehicle details: ======");

        // FIX: check if array itself is null
        if (v != null) {
            for (Vehicle vehicleView : v) {
                if (vehicleView != null) {
                    vehicleView.viewVehicleFormatter(c);
                    hasVehicle = true;
                }
            }
        }

        // ending formatting
        if (hasVehicle) {
            System.out.println("==============================\n");
            return true;
        } else {
            System.out.println("No vehicle to be viewed");
            System.out.println("==============================\n");
            return false;
        }
    }

    void rentVehicle(Vehicle[] v, Customer[] c, Vehicle vehicleList, Customer menuList) {
        int case3Repeater = 1;
        int carToRent;

        //*
        while (case3Repeater == 1) {
            boolean hasVehicle;

            hasVehicle = vehicleList.listAllVehicle(v, c);

            // ending formatting
            if (hasVehicle) {
                System.out.println("==============================\n");

                menuList.listAllCustomer(c);

                System.out.println("\n====== Rent Vehicle ======");
                System.out.print("\nEnter id of vehicle to be rented: ");
                carToRent = ans.nextInt();

                // find the vehicle with the same id
                for (int j = 0; j < v.length; j++) {
                    if (carToRent == v[j].vehicleId) {

                        // access getavailable getter (to access if boolean isAvailable is true)
                        if (v[j].isAvailable) {

                            int case3Repeater2 = 1;

                            while (case3Repeater2 == 1) {
                                // object to display the customer on output
                                Customer displayCust = new Customer();


                                // question for Customer id
                                System.out.print("\nEnter id of Customer to be assigned: ");
                                int custID = ans.nextInt();

                                boolean hasCustomer = false;

                                for (Customer custList : c) {
                                    if (custList != null) {
                                        hasCustomer = true;
                                    }
                                }

                                if (hasCustomer) {

                                    hasCustomer = false;

                                    // find customer with the same id
                                    for (int i = 0; i < c.length; i++) {

                                        // find customer
                                        if (custID == c[i].getCustomerId()) {
                                            // assign the customer to this vehicle
                                            v[j].customer = c[i];
                                            v[j].customer = displayCust;
                                            // set to false as it will be rented to
                                            v[j].setAvailable(false);
                                            hasCustomer = true;
                                            break;
                                        }

                                    }

                                    // display the assigned customer
                                    if (hasCustomer) {
                                        // to print statement that car has been rented
                                        System.out.println("Car id : " + v[j].vehicleId + " has been rented");

                                        // to print the customer's information
                                        System.out.println("Customer that has been assigned:");
                                        displayCust.viewCustomerFormatter();
                                        case3Repeater2 = 2;
                                    }
                                    // exception handler if customer doesnt exist
                                    else {

                                        try {
                                            System.out.println("Sorry, customer is not available for rent, do you want to find another customer?");
                                            System.out.println("Press 1 if you do, press 2 if you want to exit");
                                            case3Repeater2 = ans.nextInt();

                                        } catch (Exception e) {
                                            System.out.println("Please enter a valid number");
                                            ans.nextLine();
                                        }

                                    }
                                } else {
                                    System.out.println("No customer available, please insert a customer first\n");
                                    case3Repeater2 = 2;
                                }


                            }

                            // get out of the loop
                            case3Repeater = 2;
                            break;
                        }
                        // if not available for rent
                        else {

                            try {
                                System.out.println("Sorry, vehicle is not available for rent, do you want to find another vehicle?");
                                System.out.println("Press 1 if you do, press 2 if you want to exit");
                                case3Repeater = ans.nextInt();
                            } catch (Exception e) {
                                System.out.println("Please enter a valid number");
                                ans.nextLine();
                            }

                        }
                    }


                }
            }

            // if takde vehicle object dalam array, it will display this
            else if (!hasVehicle) {
                case3Repeater = 2;
            }


        }
    }

    void updateAvailability(Vehicle[] v, Customer[] c, Vehicle vehicleList) {


        boolean hasVehicle;
        int case4Repeater = 1;

        // list down all vehicle and assign the boolean for listAllVehicle
        // to check if there's a vehicle
        hasVehicle = vehicleList.listAllVehicle(v, c);

        // if there are vehicles inside the array
        if (hasVehicle) {

            while (case4Repeater == 1) {

                System.out.print("Please Enter vehicle id: ");
                int vID = ans.nextInt();

                boolean hasItem = false;
                Vehicle foundVehicle = null;

                for (Vehicle vehicle : v) {
                    if (vehicle != null && vehicle.vehicleId == vID) {
                        hasItem = true;
                        foundVehicle = vehicle;
                        break;
                    }
                }

                if (hasItem) {

                    boolean item = foundVehicle.getAvailable();

                    if (item) {
                        foundVehicle.setAvailable(false);
                    } else {
                        foundVehicle.setAvailable(true);
                    }

                    foundVehicle.viewVehicleFormatter(c);

                    case4Repeater = 2;

                } else {
                    System.out.println("ID is not accessible, please insert id again");
                }
            }

        } else {

            System.out.println("No vehicle available, please insert new vehicles");
        }
    }

    void returnVehicle(Vehicle[] v, Customer[] c, Vehicle vehicleList) {

        // initialize the array checker
        boolean hasVehicle;

        /*
        return boolean to hasVehicle to check if the list is empty or not
         */
        hasVehicle = vehicleList.listAllVehicle(v, c);

        if (hasVehicle) {

            // while loop
            int case5Repeater = 1;

            while (case5Repeater == 1) {

                boolean hasVehicle2 = false;

                System.out.print("Choose Vehicle to return: ");
                int vehicleID = ans.nextInt();

                // find the vehicle
                for (Vehicle vehicle : v) {
                    if (vehicleID == vehicle.vehicleId) {

                        // set boolean hasVehicle to true to indicate we found the vehicle
                        hasVehicle2 = true;

                        // get out of the for loop
                        break;
                    }
                }

                // check if vehicle was found or not
                // if vehicle was found
                if (hasVehicle2) {

                    // make customer go null
                    v[vehicleID].customer = null;

                    // set vehicle.isAvailable = true
                    v[vehicleID].isAvailable = true;

                    // get out of the while-loop
                    case5Repeater = 2;
                }

                // if vehicle was not found
                else {
                    try {
                        System.out.println("Sorry, vehicle was not found, do you want to find another vehicle?");
                        System.out.println("Press 1 if you do, press 2 if you want to exit");
                        case5Repeater = ans.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number");
                        ans.nextLine();
                    }
                }
            }

        } else {
            // error message and auto leave
            System.out.println("No vehicle available, please insert new vehicles");

        }


    }

    void markAvailable(Vehicle[] v, Customer[] c, Vehicle vehicleList) {
        boolean hasVehicle;
        int case6Repeater = 1;

        hasVehicle = vehicleList.listAllVehicle(v, c);

        if (hasVehicle) {

            while (case6Repeater == 1) {

                System.out.print("Please Enter vehicle id: ");
                int vID = ans.nextInt();

                boolean hasItem = false;
                Vehicle foundVehicle = null;

                for (Vehicle vehicle : v) {
                    if (vehicle != null && vehicle.vehicleId == vID) {
                        hasItem = true;
                        foundVehicle = vehicle;
                        break;
                    }
                }

                if (hasItem) {

                    foundVehicle.setAvailable(true);

                    foundVehicle.viewVehicleFormatter(c);

                    case6Repeater = 2;

                } else {
                    System.out.println("ID is not accessible, please insert id again");
                }
            }

        } else {

            // error message and get out of the method
            System.out.println("No vehicle available, please insert new vehicles");
        }
    }

    // display menu
    int menu() {
        int a;

        System.out.println("===== Welcome to the Vehicle Rental Management System =====");
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
        a = ans.nextInt();

        return a;
    }


}


