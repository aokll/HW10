package gb.ru.HW10.service;

import gb.ru.HW10.model.Car;
import gb.ru.HW10.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }
    public Car saveOrUpdate(Car car) {
        return carRepository.save(car);
    }
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
