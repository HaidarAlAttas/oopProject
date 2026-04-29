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
        this.customer = c;
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
    Vehicle addVehicle(Vehicle[] v) {

        int isAva = 1;
        int helmInc = 1;

            try {
                // this is the question part for different type of vehicle
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

                // should add exception handling here
                System.out.print("Please enter the vehicle availability = press 1 if available and 2 if not available: ");
                isAva = ans.nextInt();


                System.out.print("Please enter engine capacity: ");
                engineCapacity = ans.nextDouble();

                // should add exception handling here
                System.out.print("Please enter if helmet is included =  press 1 if included and 2 if not: ");
                helmInc = ans.nextInt();


            } catch (Exception e) {
                System.out.println("Invalid input, Please enter a valid number.");

                ans.nextLine();
            }



        // DO NOT assign customer here
        Customer tempCust = null;
        custLoc = -1;

        // to indicate if available (Vehicle)
        isAvailable = isAva != 2;

        // to indicate if helmet is included (Motorcycle)
        helmetIncluded = helmInc != 2;

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

            // should add exception handling here
            System.out.print("Please update the vehicle availability = press 1 if available and 2 if not available: ");
            isAva = ans.nextInt();


            System.out.print("Please update engine capacity: ");
            engineCapacity = ans.nextDouble();

            // should add exception handling here
            System.out.print("Please update if helmet is included = press 1 if included and 2 if not: ");
            helmInc = ans.nextInt();

            // to indicate if available (Vehicle)
            isAvailable = isAva != 2;

            // to indicate if helmet is included (Motorcycle)
            helmetIncluded = helmInc != 2;

        } catch (Exception e) {
            System.out.println("Invalid input, Please enter a valid number.");
            ans.nextLine();
        }


    }
}
