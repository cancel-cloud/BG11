package cloud.coffeesystems.lsn5unittesting.test;

import org.jetbrains.annotations.TestOnly;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.java.demos.lsn5unittesting.main.Car;

import static org.junit.Assert.assertEquals;

public class CarTest {

    private Car test_car;

    @Before
    public void setUp() {
        test_car = new Car("Toyota", "Prius", 10, 50);
    }

    @TestOnly
    public void testGasTankAfterDriving() {
        test_car.drive(50);
        assertEquals(9, test_car.getGasTankLevel(), .001);
    }

    @Test
    public void testGasTankAfterExceedingTankRange() {
        double maxDistance = test_car.getGasTankLevel() * test_car.getMilesPerGallon();
        test_car.drive(maxDistance + 1);
        assertEquals(0, test_car.getGasTankLevel(), .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGasOverfillException() {
        test_car.addGas(100);
        fail("Shouldn't get here, car cannot have more gas in tank than the size of the tank");
        if (gasTankLevel > this.getGasTankSize()) {
            throw new IllegalArgumentException("Can't exceed tank size");
        }
    }

    //TODO: add emptyTest so we can configure our runtime environment (remove this test before pushing to your personal GitLab account)
    //TODO: constructor sets gasTankLevel properly
    //TODO: gasTankLevel is accurate after driving within tank range
    //TODO: gasTankLevel is accurate after attempting to drive past tank range
    //TODO: can't have more gas than tank size, expect an exception

}
