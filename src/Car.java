import java.util.Scanner;

public class Car extends Vehicle {

    protected int numberOfDoors;
    protected String fuelType;
    Scanner ans = new Scanner(System.in);

    Car(int vehicleId, String brand, double rentalRate, boolean isAvailable, Customer cust, int numberOfDoors, String fuelType) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.rentalRate = rentalRate;
        this.isAvailable = isAvailable;
        this.cust = cust;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    Car() {

    }

    // this overrides the viewVehicle method on the Vehicle class
    void viewVehicle() {


        System.out.println(
                "\nVehicle ID: " + vehicleId +
                        "\nBrand: " + brand +
                        "\nRental Rate: " + rentalRate +
                        "\nAvailability: " + isAvailable +
                        "\nNumber of doors: " + numberOfDoors +
                        "\nFuel Type: " + fuelType);

        cust.displayCust();
    }

    // addMethod
    Vehicle addVehicle(Customer[] c) {
        // ===== General Vehicle =====
        int isAva = 1;

        // ===== System / Control Variables =====
        int f = -1;
        boolean option1 = true;

        while (option1) {
            try {
                // this is the question part for different type of vehicle
                System.out.print("Please enter the vehicle id: ");
                vehicleId = ans.nextInt();

                System.out.print("Please enter the vehicle brand: ");
                ans.nextLine();
                brand = ans.nextLine();

                System.out.print("Please enter the vehicle rate/day: ");
                rentalRate = ans.nextFloat();

                // should add exception handling here
                System.out.print("Please enter the vehicle availability: press 1 if available and 2 if not available: ");
                isAva = ans.nextInt();

                // car questions
                System.out.print("Please enter the vehicle number of doors: ");
                numberOfDoors = ans.nextInt();

                System.out.print("Please enter the vehicle fuel type: ");
                ans.nextLine();
                fuelType = ans.nextLine();

                option1 = false; // exit the loop

            } catch (Exception e) {
                System.out.println("Invalid input, Please enter a valid number.");

                ans.nextLine();
            }
        }


        // automate default customer
        for (int j = 0; j < c.length; j++) {
            if (c[j] == null) {
                f = j;
                break;
            }
        }
        if (f == -1) {
            System.out.println("Array of customer is already full");
        } else {
            c[f] = new Customer(-1, "default", -1);

        }

        // to indicate if available (Vehicle)
        boolean isAva2 = true;
        if (isAva == 2) {
            isAva2 = false;
        }

        // for cars
        return new Car(this.vehicleId, this.brand, this.rentalRate, isAva2, c[f], this.numberOfDoors, this.fuelType);


    }
}
