package gb.ru.HW10;

import gb.ru.HW10.model.Car;
import gb.ru.HW10.repository.CarRepository;
import gb.ru.HW10.service.CarService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@RunWith(SpringRunner.class)
@SpringBootTest
public class integrationTest {
    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;
    @Before
    public void setUp() {
        carRepository.deleteAll();
    }
    @Test
    public void getAllNotesIntegrationTest() {
        Car car = new Car();
        car.setModel("Integration Test model");
        carRepository.save(car);
        List<Car> cars = carService.getAllCars();
        assertTrue(cars.size() > 0);
        assertEquals(car.getModel(), cars.get(0).getModel());
    }
}