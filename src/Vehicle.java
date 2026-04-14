public class Vehicle {

    protected int vehicleId;
    protected String brand;
    protected double rentalRate;
    protected boolean isAvailable;
    protected Customer cust;

    public Vehicle() {
    }

    // fill in or delete
    void viewVehicle(){
        System.out.println("Vehicle ID: " + vehicleId +
                "\nBrand: " +
                "\nRental Rate: " +
                "\nAvailability: " +
                "\nCustomer details: ");
    }

}


