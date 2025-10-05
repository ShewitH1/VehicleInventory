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
                case "5":
                    addVehicle();
                    break;
            }
        }
   }

    public static void listAllVehicles(){
        System.out.println("Here are all your vehicles: ");
        for (Vehicle vehicle : vehicles){
            if (vehicle == null){
                break;
            }
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
            if(vehicle == null){
                break;
            }

            if (vehicle.getPrice() <= max_price){
                System.out.println("Find Vehicles by Price:");
                System.out.println("    Model: " + vehicle.getMakeModel());
                System.out.println("    Price: " + vehicle.getPrice());
                System.out.println();
            }

        }

    }

    public static void addVehicle(){

    }


}