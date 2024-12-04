import java.util.ArrayList;

public class Car extends Vehicle implements Refuelable{
    public ArrayList<String> Passengers = new ArrayList<>();
    public int maxPassengers;
    public Car(String maker, String model, int year, int maxPassengers) {
        super(maker, model, year);
        this.maxPassengers = maxPassengers;

    }

    public void start() {
        System.out.printf("Car %s has started", this.model);
    }
    public void stop() {
        System.out.printf("\nCar %s has stopped\n", this.model);
    }
    public void refuel() {
        System.out.printf("\nCar %s has been refueled\n", this.model);
    }

    public void addPassenger(String passenger) {
        if (this.Passengers.size() < this.maxPassengers) {
            this.Passengers.add(passenger);
            System.out.printf("Passenger %s has been added\n", passenger);
        }
        else {
            System.out.println("Can't add passenger, no room");
        }
    }

}

