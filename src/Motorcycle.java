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
        System.out.println("\n----------------------------------------------");
        System.out.println("Vehicle ID     : " + vehicleId);
        System.out.println("Brand          : " + brand);
        System.out.println("Rental Rate / Day   : RM " + rentalRate);
        System.out.println("Availability   : " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Engine Capacity: " + engineCapacity);
        System.out.println("Helmet         : " + (helmetIncluded ? "Included" : "Not Included"));

        // NullPointerException
        if (customer != null) {
    System.out.println("\n--- Assigned Customer ---");
    customer.viewCustomerFormatter();
    } else {
    System.out.println("\nNo customer assigned.");
    }
    System.out.println("----------------------------------------------");
    }

    // case 1: addMethod
    // make exception handling
    Vehicle addVehicle(Vehicle[] v) {

        int isAva = 0;
        int helmInc = 0;

            try {
                // this is the question part for different type of vehicle
                System.out.print("Enter the vehicle id: ");
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

                if (isAva != 1 && isAva != 2){
                    System.out.println("Invalid input, Please enter a valid number.");
                    return null;
                }

                System.out.print("Engine CC : ");
                engineCapacity = ans.nextDouble();

                System.out.print("Enter if helmet is included =  press 1 if included and 2 if not: ");
                helmInc = ans.nextInt();

                if (helmInc != 1 && helmInc != 2){
                    System.out.println("Invalid input, Please enter a valid number.");
                    return null;
                }


            } catch (Exception e) {
                System.out.println("Invalid input, Please enter a valid number.");
                return null;
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

            if(isAva != 1 && isAva != 2){
                System.out.println("Invalid input, Please enter a valid number.");
                return;
            }

            System.out.print("Please update engine capacity: ");
            engineCapacity = ans.nextDouble();

            // should add exception handling here
            System.out.print("Please update if helmet is included = press 1 if included and 2 if not: ");
            helmInc = ans.nextInt();

            if (helmInc != 1 && helmInc != 2){
                System.out.println("Invalid input, Please enter a valid number.");
                return;
            }

            // to indicate if available (Vehicle)
            isAvailable = isAva != 2;

            // to indicate if helmet is included (Motorcycle)
            helmetIncluded = helmInc != 2;

        } catch (Exception e) {
            System.out.println("Invalid input, Please enter a valid number.");
        }


    }
}
