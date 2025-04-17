package org.example; // Make sure this matches your package

import java.util.Objects; // For equals() and hashCode()

public class Car {
    private final String make;
    private final String model;

    public Car (String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}