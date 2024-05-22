package gb.ru.HW10;

import gb.ru.HW10.model.Car;
import gb.ru.HW10.repository.CarRepository;
import gb.ru.HW10.service.CarService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
	@InjectMocks
	private CarService carService;
	@Mock
	private CarRepository carRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void getAllCarsTest() {
		Car car = new Car();
		car.setModel("model");
		List<Car> expectedCars = Collections.singletonList(car);
		when(carRepository.findAll()).thenReturn(expectedCars);
		List<Car> actualCars = carService.getAllCars();
		assertEquals(expectedCars, actualCars);
	}
}
