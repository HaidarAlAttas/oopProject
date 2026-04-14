import java.util.Scanner;

public class Motorcycle extends Vehicle {

    protected double engineCapacity;
    protected boolean helmetIncluded;

    Motorcycle(int vehicleId, String brand, double rentalRate, boolean isAvailable, Customer cust, double engineCapacity, boolean helmetIncluded) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.rentalRate = rentalRate;
        this.isAvailable = isAvailable;
        this.cust = cust;
        this.engineCapacity = engineCapacity;
        this.helmetIncluded = helmetIncluded;
    }

    Motorcycle() {

    }

    // overrides all view vehicle methods
    void viewVehicle() {
        System.out.println(
                "\nVehicle ID: " + vehicleId +
                        "\nBrand: " + brand +
                        "\nRental Rate: " + rentalRate +
                        "\nAvailability: " + isAvailable +
                        "\nEngine Capacity: " + engineCapacity +
                        "\nHelmet inclusion: " + helmetIncluded + "\n");

        cust.displayCust();
    }

    Scanner ans = new Scanner(System.in);


    Vehicle addVehicle(Customer[] c) {

        // ===== General Vehicle =====

        int isAva = 1;

        // ===== Motorcycle Variable =====
        int helmInc = 1;

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


                System.out.print("Please enter engine capacity: ");
                engineCapacity = ans.nextDouble();

                // should add exception handling here
                System.out.print("Please enter if helmet is included: press 1 if included and 2 if not: ");
                helmInc = ans.nextInt();


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
            c[f] = new Customer(-1, "Default", -1);

        }

        // to indicate if available (Vehicle)
        boolean isAva2 = true;
        if (isAva == 2) {
            isAva2 = false;
        }

        // to indicate if helmet is included (Motorcycle)
        if (helmInc == 2) {
            helmetIncluded = false;
        }

        return new Motorcycle(this.vehicleId, this.brand, this.rentalRate, isAva2, c[f], this.engineCapacity, this.helmetIncluded);

    }
}
