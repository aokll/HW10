package gb.ru.HW10.controller;

import gb.ru.HW10.model.Car;
import gb.ru.HW10.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCarById(id);
    }
    @PostMapping
    public Car createCar(@RequestBody  Car car) {
        return carService.saveOrUpdate(car);
    }
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car
            updatedCar) {
        Car car = carService.getCarById(id);
        car.setModel(updatedCar.getModel());
        return carService.saveOrUpdate(car);
    }
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}
