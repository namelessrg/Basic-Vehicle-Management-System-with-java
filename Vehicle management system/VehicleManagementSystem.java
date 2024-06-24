package car;

import java.util.Scanner;

public class VehicleManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User selects a vehicle type
        System.out.println("Choose a vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Bicycle");
        System.out.println("4. Bus");

        int vehicleChoice = scanner.nextInt();
        VehicleFactory vehicleFactory = createVehicleFactory(vehicleChoice);

        // User decorates the vehicle
        System.out.println("Do you want to add decorations? (y/n)");
        String decorateChoice = scanner.next();
        Vehicle configuredVehicle = decorateVehicle(vehicleFactory.createVehicle(), decorateChoice);

        // User selects a driving strategy
        System.out.println("Choose a driving strategy:");
        System.out.println("1. City Driving");
        System.out.println("2. Highway Driving");

        int strategyChoice = scanner.nextInt();
        setDrivingStrategy(configuredVehicle, strategyChoice);

        // User adds an observer
        System.out.println("Do you want to add a monitoring system as an observer? (y/n)");
        String observerChoice = scanner.next();
        addObserver(configuredVehicle, observerChoice);

        // Perform actions on the configured vehicle
        configuredVehicle.start();
        configuredVehicle.accelerate();
        configuredVehicle.stop();

        // Close the scanner
        scanner.close();
    }

    private static VehicleFactory createVehicleFactory(int choice) {
        switch (choice) {
            case 1:
                return new CarFactory();
            case 2:
                return new MotorcycleFactory();
            case 3:
                return new BicycleFactory();
            case 4:
                return new BusFactory();
            default:
                throw new IllegalArgumentException("Invalid choice for vehicle type");
        }
    }

    private static Vehicle decorateVehicle(Vehicle vehicle, String choice) {
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Choose decorations:");
            System.out.println("1. GPS");
            System.out.println("2. Camera");
            System.out.println("3. Ambient Lighting");

            int decorationChoice = new Scanner(System.in).nextInt();
            switch (decorationChoice) {
                case 1:
                    return new GPSDecorator(vehicle);
                case 2:
                    return new CameraDecorator(vehicle);
                case 3:
                    return new AmbientLightingDecorator(vehicle);
                default:
                    throw new IllegalArgumentException("Invalid choice for decoration");
            }
        }
        return vehicle;
    }

    private static void setDrivingStrategy(Vehicle vehicle, int choice) {
        switch (choice) {
            case 1:
                vehicle.setDrivingStrategy(new CityDrivingStrategy());
                break;
            case 2:
                vehicle.setDrivingStrategy(new HighwayDrivingStrategy());
                break;
            default:
                throw new IllegalArgumentException("Invalid choice for driving strategy");
        }
    }

    private static void addObserver(Vehicle vehicle, String choice) {
        if (choice.equalsIgnoreCase("y")) {
            VehicleObserver monitoringSystem = new MonitoringSystem();
            if (vehicle instanceof ObservableVehicle) {
                ObservableVehicle observableVehicle = (ObservableVehicle) vehicle;
                observableVehicle.addObserver(monitoringSystem);
            }
        }
    }
}