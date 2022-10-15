package com.muammerdiri.rentACar.business.abstracts;

import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.entities.concrete.Car;

import java.util.List;

public interface CarService {

    Result add(Car car);
    Result delete(Car car);
    List<Car> getAll();

    List<Car> findCarByModelYearNamedParams(Integer status);
    Car findCarByIdNamedParams(int id);

//    List<CarDto> carDtoDetails();




}
