import java.util.Scanner;

public class Motorcycle extends Vehicle {

    protected double engineCapacity;
    protected boolean helmetIncluded;
    Scanner ans = new Scanner(System.in);

    Motorcycle() {

    }


    Motorcycle(int vehicleId, String brand, double rentalRate, boolean isAvailable, Customer c,int custLoc,double engineCapacity, boolean helmetIncluded) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.rentalRate = rentalRate;
        this.isAvailable = isAvailable;
        this.custLoc = custLoc;
        this.engineCapacity = engineCapacity;
        this.helmetIncluded = helmetIncluded;
    }



    // overrides all view vehicle methods
    void viewVehicleFormatter(Customer[] c) {
        System.out.println(
                "\nVehicle ID: " + vehicleId +
                        "\nBrand: " + brand +
                        "\nRental Rate: " + rentalRate +
                        "\nAvailability: " + isAvailable +
                        "\nEngine Capacity: " + engineCapacity +
                        "\nHelmet inclusion: " + helmetIncluded);

        // NullPointerException
        if (c != null && custLoc >= 0 && custLoc < c.length && c[custLoc] != null) {
            c[custLoc].viewCustomerFormatter();
        } else {
            System.out.println("No customer assigned.\n");
        }
    }

    // case 1: addMethod
    // make exception handling
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
                System.out.print("Please enter the vehicle availability = press 1 if available and 2 if not available: ");
                isAva = ans.nextInt();


                System.out.print("Please enter engine capacity: ");
                engineCapacity = ans.nextDouble();

                // should add exception handling here
                System.out.print("Please enter if helmet is included =  press 1 if included and 2 if not: ");
                helmInc = ans.nextInt();


                option1 = false; // exit the loop


            } catch (Exception e) {
                System.out.println("Invalid input, Please enter a valid number.");

                ans.nextLine();
            }
        }


        // DO NOT assign customer here
        Customer tempCust = null;
        custLoc = -1;

        // to indicate if available (Vehicle)
        if (isAva == 2) {
            isAvailable = false;
        }
        else{
            isAvailable = true;
        }

        // to indicate if helmet is included (Motorcycle)
        if (helmInc == 2) {
            helmetIncluded = false;
        }
        else{
            helmetIncluded = true;
        }

        return new Motorcycle(this.vehicleId, this.brand, this.rentalRate, isAvailable, tempCust, custLoc, this.engineCapacity, this.helmetIncluded);

    }

    // case 8 cont.
    void updateVehicleDetails(Vehicle[] v, Customer[] c){
        int isAva;
        int helmInc;
        // can copy from addVehicle and alter
        try {
            // this is the question part for different type of vehicle
            System.out.print("Please update the vehicle id: ");
            vehicleId = ans.nextInt();

            System.out.print("Please update the vehicle brand: ");
            ans.nextLine();
            brand = ans.nextLine();

            System.out.print("Please update the vehicle rate/day: ");
            rentalRate = ans.nextFloat();

            // should add exception handling here
            System.out.print("Please update the vehicle availability = press 1 if available and 2 if not available: ");
            isAva = ans.nextInt();


            System.out.print("Please update engine capacity: ");
            engineCapacity = ans.nextDouble();

            // should add exception handling here
            System.out.print("Please update if helmet is included = press 1 if included and 2 if not: ");
            helmInc = ans.nextInt();

            // to indicate if available (Vehicle)
            if (isAva == 2) {
                isAvailable = false;
            }
            else{
                isAvailable = true;
            }

            // to indicate if helmet is included (Motorcycle)
            if (helmInc == 2) {
                helmetIncluded = false;
            }
            else{
                helmetIncluded = true;
            }

        } catch (Exception e) {
            System.out.println("Invalid input, Please enter a valid number.");
            ans.nextLine();
        }


    }
}
