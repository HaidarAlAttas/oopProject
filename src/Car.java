import java.util.Scanner;

public class Car extends Vehicle {

    protected int numberOfDoors;
    protected String fuelType;
    Scanner ans = new Scanner(System.in);

    Car() {

    }

    Car(int vehicleID, String brand, double rentalRate, boolean isAvailable, Customer c, int custloc, int numberOfDoors, String fuelType) {
        this.vehicleId = vehicleID;
        this.brand = brand;
        this.rentalRate = rentalRate;
        this.isAvailable = isAvailable;
        this.custLoc = custloc;
        this.customer = c;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    // this overrides the viewVehicle method on the Vehicle class
    void viewVehicleFormatter(Customer[] c) {

        System.out.println(
                "\nVehicle ID: " + vehicleId +
                        "\nBrand: " + brand +
                        "\nRental Rate: " + rentalRate +
                        "\nAvailability: " + isAvailable +
                        "\nNumber of doors: " + numberOfDoors +
                        "\nFuel Type: " + fuelType);

        // NullPointerException
        if (c != null && custLoc >= 0 && custLoc < c.length && c[custLoc] != null) {
            c[custLoc].viewCustomerFormatter();
        } else {
            System.out.println("No customer assigned.\n");
        }
    }

    // case 1: addMethod
    // make exception handling
    Vehicle addVehicle(Vehicle[] v) {
        int isAva = 1;

            try {
                System.out.print("Please enter the vehicle id: ");
                vehicleId = ans.nextInt();

                boolean has;
                has = vehicleIdChecker(v,vehicleId);

                if(has){
                    System.out.println("Vehicle ID already used");
                    return null;
                }

                System.out.print("Please enter the vehicle brand: ");
                ans.nextLine();
                brand = ans.nextLine();

                System.out.print("Please enter the vehicle rate/day: ");
                rentalRate = ans.nextFloat();

                System.out.print("Please enter the vehicle availability: press 1 if available and 2 if not available: ");
                isAva = ans.nextInt();

                System.out.print("Please enter the vehicle number of doors: ");
                numberOfDoors = ans.nextInt();

                System.out.print("Please enter the vehicle fuel type: ");
                ans.nextLine();
                fuelType = ans.nextLine();

            } catch (Exception e) {
                System.out.println("Invalid input, Please enter a valid number.");
                ans.nextLine();
            }

        // Customer is not assigned here yet so just put null
        Customer tempCust = null;
        custLoc = -1;

        // to alter the is available method
        // simplified if else,
        isAvailable = isAva != 2;

        return new Car(vehicleId, brand, rentalRate, isAvailable, tempCust, custLoc, numberOfDoors, fuelType);
    }

    // case 8 cont.
    // make exception handling
    void updateVehicleDetails(Vehicle[] v, Customer[] c) {
        int isAva;

        // can copy from addVehicle and alter
        try {
            System.out.print("Please update the vehicle id: ");
            vehicleId = ans.nextInt();

            boolean has;
            has = vehicleIdChecker(v,vehicleId);

            if(has){
                System.out.println("Vehicle ID already used");
                return;
            }

            System.out.print("Please update the vehicle brand: ");
            ans.nextLine();
            brand = ans.nextLine();

            System.out.print("Please update the vehicle rate/day: ");
            rentalRate = ans.nextFloat();

            System.out.print("Please update the vehicle availability: press 1 if available and 2 if not available: ");
            isAva = ans.nextInt();

            System.out.print("Please update the vehicle number of doors: ");
            numberOfDoors = ans.nextInt();

            System.out.print("Please update the vehicle fuel type: ");
            ans.nextLine();
            fuelType = ans.nextLine();

            isAvailable = isAva != 2;

        } catch (Exception e) {
            System.out.println("Invalid input, Please enter a valid number.");
            ans.nextLine();
        }
    }
}