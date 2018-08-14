package com.packt.reactsample.web;

import com.packt.reactsample.domain.Car;
import com.packt.reactsample.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping(value = "/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }

    @DeleteMapping(value = "/cars/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable long id){
        carRepository.deleteById(id);
    }
}
