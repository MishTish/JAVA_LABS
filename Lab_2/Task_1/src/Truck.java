public class Truck extends Vehicle implements Refuelable {
public int maxCargoWeightT;
public int currentCargoWeightT;
    public Truck(String maker, String model, int year, int maxCargoWeightT) {
        super(maker, model, year);
        this.maxCargoWeightT = maxCargoWeightT;
    }

    public void start() {
        System.out.printf("Truck %s has started", this.model);
    }
    public void stop() {
        System.out.printf("Truck %s has stopped", this.model);
    }
    public  void refuel() {
        System.out.printf("Truck %s has been refueled", this.model);
    }
    public void LoadCargo(String cargo, int cargoWeightT) {
        if (cargoWeightT + currentCargoWeightT < maxCargoWeightT) {
            System.out.printf("\nLoaded %s\n", cargo);
            currentCargoWeightT += cargoWeightT;
        }
        else {
            System.out.printf("\n%s is too heavy\n", cargo);
        }

    }

}
