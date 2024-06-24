package car;

import java.util.ArrayList;
import java.util.List;

// 1. Factory Method Pattern

// Vehicle interface
interface Vehicle {
    void start();

    DrivingStrategy getDrivingStrategy();

	void stop();

    void accelerate();

    void setDrivingStrategy(DrivingStrategy drivingStrategy);
}

// Concrete vehicle classes
class Car implements Vehicle {
    private DrivingStrategy drivingStrategy;

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Car accelerating");
    }

    @Override
    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
        executeStrategy();
    }

    private void executeStrategy() {
        if (drivingStrategy != null) {
            drivingStrategy.applyBrakes();
            drivingStrategy.turnLeft();
            drivingStrategy.turnRight();
        }
    }

	@Override
	public DrivingStrategy getDrivingStrategy() {
		 return drivingStrategy;
	}
}

class Motorcycle implements Vehicle {
    private DrivingStrategy drivingStrategy;

    @Override
    public void start() {
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Motorcycle accelerating");
    }

    @Override
    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
        executeStrategy();
    }

    private void executeStrategy() {
        if (drivingStrategy != null) {
            drivingStrategy.applyBrakes();
            drivingStrategy.turnLeft();
            drivingStrategy.turnRight();
        }
    }

	@Override
	public DrivingStrategy getDrivingStrategy() {
		 return drivingStrategy;
	}
}

class Bicycle implements Vehicle {
    private DrivingStrategy drivingStrategy;

    @Override
    public void start() {
        System.out.println("Bicycle started");
    }

    @Override
    public void stop() {
        System.out.println("Bicycle stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Bicycle accelerating");
    }

    @Override
    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
        executeStrategy();
    }

    private void executeStrategy() {
        if (drivingStrategy != null) {
            drivingStrategy.applyBrakes();
            drivingStrategy.turnLeft();
            drivingStrategy.turnRight();
        }
    }

	@Override
	public DrivingStrategy getDrivingStrategy() {
		 return drivingStrategy;
	}
}

class Bus implements Vehicle {
    private DrivingStrategy drivingStrategy;

    @Override
    public void start() {
        System.out.println("Bus started");
    }

    @Override
    public void stop() {
        System.out.println("Bus stopped");
    }

    @Override
    public void accelerate() {
        System.out.println("Bus accelerating");
    }

    @Override
    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
        executeStrategy();
    }

    private void executeStrategy() {
        if (drivingStrategy != null) {
            drivingStrategy.applyBrakes();
            drivingStrategy.turnLeft();
            drivingStrategy.turnRight();
        }
    }

    public DrivingStrategy getDrivingStrategy() {
        return drivingStrategy;
    }
}

// VehicleFactory interface
interface VehicleFactory {
    Vehicle createVehicle();
}

// Concrete vehicle factories
class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class MotorcycleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}

class BicycleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bicycle();
    }
}

class BusFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bus();
    }
}

// 2. Decorator Pattern

// Decorator interface
interface VehicleDecorator extends Vehicle {
    // Additional methods or properties for decorated vehicles
}

class GPSDecorator implements VehicleDecorator {
    private final Vehicle decoratedVehicle;

    public GPSDecorator(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public void start() {
        decoratedVehicle.start();
        System.out.println("GPS activated");
    }

    @Override
    public void stop() {
        decoratedVehicle.stop();
    }

    @Override
    public void accelerate() {
        decoratedVehicle.accelerate();
    }

    @Override
    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        decoratedVehicle.setDrivingStrategy(drivingStrategy);
        executeStrategy();
    }

    @Override
    public DrivingStrategy getDrivingStrategy() {
        return decoratedVehicle.getDrivingStrategy();
    }

    private void executeStrategy() {
        if (decoratedVehicle instanceof ObservableVehicle) {
            ObservableVehicle observableVehicle = (ObservableVehicle) decoratedVehicle;
            observableVehicle.setDrivingStrategy(decoratedVehicle.getDrivingStrategy());
        }
    }
}

class CameraDecorator implements VehicleDecorator {
    private final Vehicle decoratedVehicle;

    public CameraDecorator(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public void start() {
        decoratedVehicle.start();
        System.out.println("Camera activated");
    }

    @Override
    public void stop() {
        decoratedVehicle.stop();
    }

    @Override
   
    public void accelerate() {
        decoratedVehicle.accelerate();
    }

    @Override
    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        decoratedVehicle.setDrivingStrategy(drivingStrategy);
        executeStrategy();
    }

    @Override
    public DrivingStrategy getDrivingStrategy() {
        return decoratedVehicle.getDrivingStrategy();
    }

    private void executeStrategy() {
        if (decoratedVehicle instanceof ObservableVehicle) {
            ObservableVehicle observableVehicle = (ObservableVehicle) decoratedVehicle;
            observableVehicle.setDrivingStrategy(decoratedVehicle.getDrivingStrategy());
        }
    }
}

class AmbientLightingDecorator implements VehicleDecorator {
    private final Vehicle decoratedVehicle;

    public AmbientLightingDecorator(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public void start() {
        decoratedVehicle.start();
        System.out.println("Ambient Lighting activated");
    }

    @Override
    public void stop() {
        decoratedVehicle.stop();
    }

    @Override
    public void accelerate() {
        decoratedVehicle.accelerate();
    }

    @Override
    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        decoratedVehicle.setDrivingStrategy(drivingStrategy);
        executeStrategy();
    }

    @Override
    public DrivingStrategy getDrivingStrategy() {
        return decoratedVehicle.getDrivingStrategy();
    }

    private void executeStrategy() {
        if (decoratedVehicle instanceof ObservableVehicle) {
            ObservableVehicle observableVehicle = (ObservableVehicle) decoratedVehicle;
            observableVehicle.setDrivingStrategy(decoratedVehicle.getDrivingStrategy());
        }
    }
}


// 3. Strategy Pattern

// DrivingStrategy interface
interface DrivingStrategy {
    void applyBrakes();

    void turnLeft();

    void turnRight();
}

// Concrete strategies
class CityDrivingStrategy implements DrivingStrategy {
    @Override
    public void applyBrakes() {
        System.out.println("Applying city driving brakes");
    }

    @Override
    public void turnLeft() {
        System.out.println("Turning left in the city");
    }

    @Override
    public void turnRight() {
        System.out.println("Turning right in the city");
    }
}

class HighwayDrivingStrategy implements DrivingStrategy {
    @Override
    public void applyBrakes() {
        System.out.println("Applying highway driving brakes");
    }

    @Override
    public void turnLeft() {
        System.out.println("Turning left on the highway");
    }

    @Override
    public void turnRight() {
        System.out.println("Turning right on the highway");
    }
}

// 4. Observer Pattern

// VehicleObserver interface
interface VehicleObserver {
    void updateStatus(String status);
}

// Concrete observers
class MonitoringSystem implements VehicleObserver {
    @Override
    public void updateStatus(String status) {
        System.out.println("Monitoring System: " + status);
    }
}

// Vehicle class with Observer pattern implementation
class ObservableVehicle implements Vehicle {
    private final List<VehicleObserver> observers = new ArrayList<>();
    private DrivingStrategy drivingStrategy;

    @Override
    public void start() {
        // Vehicle start logic
        notifyObservers("Vehicle started");
    }

    @Override
    public void stop() {
        // Vehicle stop logic
        notifyObservers("Vehicle stopped");
    }

    @Override
    public void accelerate() {
        // Vehicle acceleration logic
        notifyObservers("Vehicle accelerating");
    }

    @Override
    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        // Set the strategy for the concrete vehicle
        this.drivingStrategy = drivingStrategy;
        executeStrategy();
    }

    public void addObserver(VehicleObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(VehicleObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String status) {
        for (VehicleObserver observer : observers) {
            observer.updateStatus(status);
        }

        // Execute the strategy methods after notifying observers
        executeStrategy();
    }

    private void executeStrategy() {
        if (drivingStrategy != null) {
            drivingStrategy.applyBrakes();
            drivingStrategy.turnLeft();
            drivingStrategy.turnRight();
        }
    }

	@Override
	public DrivingStrategy getDrivingStrategy() {
		 return drivingStrategy;
	}
}