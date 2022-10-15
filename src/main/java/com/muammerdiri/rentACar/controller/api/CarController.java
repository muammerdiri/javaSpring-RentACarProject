package com.muammerdiri.rentACar.controller.api;


import com.muammerdiri.rentACar.business.abstracts.CarService;
import com.muammerdiri.rentACar.core.utilities.result.*;
import com.muammerdiri.rentACar.entities.concrete.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getall")
    public DataResult<List<Car>> getAll(){
        return new SuccessDataResult<List<Car>>(carService.getAll(),"Car listed.");
    }


    @PostMapping("/add")
    public Result add(@RequestBody Car car) {
        if (this.carService.add(car).isSuccess()){
            this.carService.add(car);
            return new SuccessResult("Car is added.");
        }

        return new ErrorResult("Throw Exception.");
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Car car) {
        carService.delete(car);
        return new SuccessResult("Car is deleted");
    }

    @GetMapping("/find-car-by-model-year")
    public List<Car> findCarByModelYearNamedParams(@RequestParam Integer status) {
        return carService.findCarByModelYearNamedParams(status);
    }

    @GetMapping("/find-car-by-id-named-params")
    public DataResult<Car> findCarByIdNamedParams(@RequestParam int id) {
        return new SuccessDataResult(carService.findCarByIdNamedParams(id),"Data getting");
    }

//    @GetMapping("/car-dto-details")
//    public List<CarDto> carDtoDetails() {
//        return carService.carDtoDetails();
//    }


}
