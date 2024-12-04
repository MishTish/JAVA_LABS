
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("=== Vehicle manager ===");
            System.out.println("1. Add vehicle");
            System.out.println("2. Show all vehicles");
            System.out.println("3. Manage vehicles");
            System.out.println("4. Exit");
            String selector = scanner.next();
            switch (selector) {
                case "1": {


                    System.out.println("Enter vehicle maker: ");
                    String newMaker = scanner.next();

                    System.out.println("Enter vehicle model: ");
                    String newModel = scanner.next();

                    System.out.println("Enter vehicle year: ");
                    int newYear = scanner.nextInt();

                    System.out.println("New vehicle type:");
                    System.out.println("1. Car");
                    System.out.println("2. Truck");
                    System.out.println("3. Bike");
                    String newType = scanner.next();

                    switch (newType) {
                        case "1": {
                            System.out.println("Enter max passenger count: ");
                            int newCarMaxPassengers = scanner.nextInt();
                            Car newCar = new Car(newMaker, newModel, newYear, newCarMaxPassengers);
                            vehicles.add(newCar);
                            System.out.printf("\nNew " + newCar + ", Max passengers: " + newCar.maxPassengers + ", added\n");
                            break;
                        }
                        case "2": {
                            System.out.println("Enter max cargo weight (t): ");
                            int newTruckMaxCargoWeightT = scanner.nextInt();
                            Truck newTruck = new Truck(newMaker, newModel, newYear, newTruckMaxCargoWeightT);
                            vehicles.add(newTruck);
                            System.out.printf("\nNew " + newTruck + ", Max cargo weight: " + newTruck.maxCargoWeightT + "t, added\n");
                            break;
                        }

                        case "3": {
                            boolean newBikeCanDoTricks;
                            while (true) {
                                System.out.println("Is it a trick bike?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                int selection = scanner.nextInt();
                                if (selection == 1) {
                                    newBikeCanDoTricks = true;
                                    break;
                                } else if (selection == 2) {
                                    newBikeCanDoTricks = false;
                                    break;
                                } else {
                                    System.out.println("Invalid input");

                                }
                            }
                            Bike newBike = new Bike(newMaker, newModel, newYear, newBikeCanDoTricks);
                            vehicles.add(newBike);
                            System.out.printf("\nNew " + (newBikeCanDoTricks ? "trick " : "") + newBike + " added\n");
                            break;
                        }
                        default: {
                            System.out.println("Invalid input");
                            break;
                        }
                    }
                    break;
                }
                case "2": {
                    System.out.println("Vehicle list:");
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle);
                    }
                    break;
                }
                case "3": {
                    System.out.println("Current Vehicles:");
                    if (vehicles.size() <= 0)
                    {
                        System.out.println("Empty");
                        break;
                    }
                    else {
                        for (int i = 0; i < vehicles.size(); i++) {
                            System.out.println((i + 1) + ". " + vehicles.get(i));
                        }

                        System.out.print("Choose a vehicle by number: ");
                        int vehicleChoice = scanner.nextInt();

                        if (vehicleChoice < 1 || vehicleChoice > vehicles.size()) {
                            System.out.println("Invalid choice.");
                            break;
                        }
                        Vehicle vehicle = vehicles.get(vehicleChoice - 1);
                        while (true) {
                            System.out.println();
                            System.out.print("Choose action: 1. Start, 2. Stop, ");
                            switch (vehicle.getClass().getName()) {
                                case "Car": {
                                    System.out.println("3. Refuel, 4. Add passenger, 5. Exit");
                                    break;
                                }
                                case "Truck": {
                                    System.out.println("3. Refuel, 4. Add cargo, 5. Exit");
                                    break;
                                }
                                case "Bike": {
                                    System.out.println("3. Do tricks, 5. Exit");
                                    break;
                                }
                            }
                            int actionChoice = scanner.nextInt();
                            switch (actionChoice) {
                                case 1: {
                                    vehicle.start();
                                    continue;
                                }
                                case 2: {
                                    vehicle.stop();
                                    continue;
                                }
                                case 3: {
                                    if (vehicle instanceof Car || vehicle instanceof Truck) {
                                        ((Refuelable) vehicle).refuel();
                                    } else if (vehicle instanceof Bike) {
                                        ((Bike) vehicle).trick();
                                    }
                                    continue;
                                }
                                case 4: {
                                    switch (vehicle) {
                                        case Car car -> {

                                            System.out.println("Passenger name: ");
                                            String passenger = scanner.next();
                                            car.addPassenger(passenger);
                                        }
                                        case Truck truck -> {

                                            System.out.println("Cargo type: ");
                                            String cargo = scanner.next();
                                            System.out.println("Cargo weight: ");
                                            int cargoWeight = scanner.nextInt();
                                            truck.LoadCargo(cargo, cargoWeight);
                                        }
                                        case Bike bike -> System.out.println("Invalid Choice");
                                        default -> {
                                        }
                                    }
                                    continue;
                                }
                                case 5: {
                                    break;
                                }
                                default: {
                                    System.out.println("Invalid choice");
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                case "4": {
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                }
                default: {
                    System.out.println("Invalid input");
                    break;
                }
            }
        }
    }
}
