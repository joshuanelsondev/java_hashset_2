package org.example; // Make sure this matches your package

import java.util.HashSet;
import java.util.Set;

public class CarService {
    HashSet<Car> cars = new HashSet<Car>();

    public void addCar(Car car) {
        if (car == null) throw new IllegalArgumentException();
        cars.add(car);
    }

    public boolean removeCar(Car car) {
        if (car == null) throw new IllegalArgumentException();
        return cars.remove(car);
    }

    public int getCarCount() {
        return cars.size();
    }

    public Set<Car> getCarsByMake(String make) {
        if (make == null || make.isEmpty()) throw new IllegalArgumentException();

        HashSet<Car> filteredCars = new HashSet<Car>();

        for (Car car : cars) {
            if (car.getMake() != null && car.getMake().equalsIgnoreCase(make)) {
                filteredCars.add(car);
            }
        }

        return filteredCars;
    }
}