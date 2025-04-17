package org.example; // Make sure this matches your package

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Set;

public class CarServiceTest {

    private CarService carService;
    private Car ford1 = new Car("Focus", "Ford");
    private Car toyota1 = new Car("Camry", "Toyota");
    private Car ford2 = new Car("Mustang", "Ford");
    private Car honda1 = new Car("Civic", "Honda");

    @Before
    public void setUp() {
        carService = new CarService();
        carService.addCar(ford1);
        carService.addCar(toyota1);
        carService.addCar(ford2);
        carService.addCar(honda1);
    }

    @Test
    public void testAddCar_Success() {
        Car newCar = new Car("Corolla", "Toyota");
        carService.addCar(newCar);
        assertTrue(carService.removeCar(newCar));
        assertEquals(4, carService.getCarCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCar_Null() {
        carService.addCar(null);
    }

    @Test
    public void testRemoveCar_Success() {
        assertTrue(carService.removeCar(ford1));
        assertFalse(carService.removeCar(ford1));
        assertEquals(3, carService.getCarCount());
    }

    @Test
    public void testRemoveCar_NotFound() {
        Car nonexistentCar = new Car("Unknown", "Unknown");
        assertFalse(carService.removeCar(nonexistentCar));
        assertEquals(4, carService.getCarCount());
    }

    @Test
    public void testGetCarsByMake_Found() {
        Set<Car> fordCars = carService.getCarsByMake("Ford"); // Call the method with a loop
        assertEquals(2, fordCars.size());
        assertTrue(fordCars.contains(ford1));
        assertTrue(fordCars.contains(ford2));
    }

    @Test
    public void testGetCarsByMake_NotFound() {
        Set<Car> mazdaCars = carService.getCarsByMake("Mazda"); // Call the method with a loop
        assertTrue(mazdaCars.isEmpty());
    }

    @Test
    public void testGetCarsByMake_CaseInsensitive() {
        Set<Car> fordCars = carService.getCarsByMake("ford"); // Call the method with a loop
        assertEquals(2, fordCars.size());
        assertTrue(fordCars.contains(ford1));
        assertTrue(fordCars.contains(ford2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCarsByMake_NullMake() {
        carService.getCarsByMake(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCarsByMake_EmptyMake() {
        carService.getCarsByMake("");
    }

    @Test
    public void testGetCarCount() {
        assertEquals(4, carService.getCarCount());
    }
}