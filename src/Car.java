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
            System.out.println("No customer assigned.");
        }
    }

    // addMethod
    Vehicle addVehicle(Customer[] c) {
        int isAva = 1;

        int f = -1;
        boolean option1 = true;

        while (option1) {
            try {
                System.out.print("Please enter the vehicle id: ");
                vehicleId = ans.nextInt();

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

                option1 = false;

            } catch (Exception e) {
                System.out.println("Invalid input, Please enter a valid number.");
                ans.nextLine();
            }
        }

        // Customer is not assigned here yet
        Customer tempCust = null;
        custLoc = -1;

        boolean isAva2 = true;
        if (isAva == 2) {
            isAva2 = false;
        }

        return new Car(vehicleId, brand, rentalRate, isAva2, tempCust, custLoc, numberOfDoors, fuelType);
    }
}