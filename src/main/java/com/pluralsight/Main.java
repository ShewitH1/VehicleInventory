package com.pluralsight;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //put the Vehicle object as a "field" to allow any method to access it
    private static Vehicle[] vehicles = new Vehicle[20];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        String command = " ";

        while(!command.equals("6")){
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Find Vehicles by price");
            System.out.println(" 3 - Search by make/model");
            System.out.println(" 4 - Search by price range");
            System.out.println(" 5 - Search by color");
            System.out.println(" 6 - Add a vehicle");
            System.out.println(" 7 - Quit");
            System.out.println("Enter your command: ");

            command = scanner.nextLine();

            switch(command){
                case "1":
                    listAllVehicles();
                    break;
                case "2":
                    findVehiclesByPrice(scanner);
                    break;
                case "3":
                    searchModel(scanner);
                    break;
                case "4":
                    searchPriceRange(scanner);
                    break;
                case "5":
                    searchColor(scanner);
                    break;
                case "6":
                    addVehicle(scanner);
                    break;
            }
        }
   }

    public static void listAllVehicles(){
        System.out.println("Here are all your vehicles: ");
        //loops through array/object
        for (Vehicle vehicle : vehicles){
            if (vehicle == null){ //if the loop loops through and find null, it will stop
                break;
            }
            //print results
            System.out.println("Vehicle [ID: " + vehicle.getVehicleId());
            System.out.println("    Model: " + vehicle.getMakeModel());
            System.out.println("    Color: " + vehicle.getColor());
            System.out.println("    Odometer Reading: " +  vehicle.getOdometerReading());
            System.out.println("    Price: " +  vehicle.getPrice());
        }
    }

    public static void findVehiclesByPrice(Scanner scanner){
        System.out.println("What is your Max price range: ");
        double max_price = scanner.nextDouble();

        for(Vehicle vehicle : vehicles){
            if(vehicle == null){   //if the loop loops through and find null, it will stop
                break;
            }

            if (vehicle.getPrice() <= max_price){   //gets all vehicle prices, compares with user input
                System.out.println("Find Vehicles by Price:");
                System.out.println("    Model: " + vehicle.getMakeModel());
                System.out.println("    Price: " + vehicle.getPrice());
                System.out.println();
            }
        }
    }

    public static void searchModel(Scanner model){
        System.out.println("What is your ideal model: ");
        String find_model = model.nextLine();

        for(Vehicle model_vehicle : vehicles){
            if (model_vehicle == null){  //if the loop loops through and find null, it will stop
                break;
            }
            //loops through array - gets model and checks if color is found by "equals"
            if(model_vehicle.getMakeModel().equalsIgnoreCase(find_model)){
                System.out.println("Find Vehicles by Model:");
                System.out.println("    Vehicle [ID: " + model_vehicle.getVehicleId());
                System.out.println("    Model: " + model_vehicle.getMakeModel());
            }
        }
    }

    public static void searchPriceRange(Scanner price_range){
        System.out.println("What is your price range: ");
        float priceRange = price_range.nextFloat();

        for(Vehicle price : vehicles){
            if(price == null){ //if the loop loops through and find null, it will stop
                break;
            }
            if(price.getPrice() <= priceRange){
                System.out.println("Find Vehicles by Price Range:");
                System.out.println("    Vehicle [ID: " + price.getVehicleId());
                System.out.println("    Model: " + price.getMakeModel());
                System.out.println("    Price: " + price.getPrice());
            }
        }
    }

    public static void searchColor(Scanner color){
        System.out.println("What is your ideal color: ");
        String ideal_color = color.nextLine();

        //loops throughout vehicle array/object selects color
        for(int i = 0; i<vehicles.length; i++){
            if(vehicles[i] == null){
                break;
            }
            if (vehicles[i].getColor().equalsIgnoreCase(ideal_color)){
                System.out.println("Find Vehicles by Color:");
                System.out.println("    Vehicle [ID: " + vehicles[i].getVehicleId());
                System.out.println("    Model: " + vehicles[i].getMakeModel());
                System.out.println("    Color: " + vehicles[i].getColor());
            }
        }
    }


    public static void addVehicle(Scanner scanner){
        //random number for ID
        int vehicle_id = (int)(Math.random() * 100000) + 10000;

        System.out.println("What model is your car: ");
        String model = scanner.nextLine();

        System.out.println("What color is your car: ");
        String color = scanner.nextLine();

        System.out.println("What is the Odometer Reading: ");
        int odo_reading = scanner.nextInt();

        System.out.println("What is your official price range: ");
        float price_range = scanner.nextFloat();

        //create vehicle and add variables in the respectable areas
        Vehicle add_vehicle = new Vehicle(vehicle_id, model, color, odo_reading, price_range);

        //create for loop to loop throw object/array and add if null is found
        boolean vehicle_added = false; //default false until proven otherwise

        for(int i = 0; i < vehicles.length; i++){
            if (vehicles[i] == null){
                vehicles[i] = add_vehicle;
                vehicle_added = true;  //changes into true when vehicle is added - verification
                break;
            }
        }
    }
}