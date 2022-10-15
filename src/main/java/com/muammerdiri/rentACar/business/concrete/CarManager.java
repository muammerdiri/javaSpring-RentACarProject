package com.muammerdiri.rentACar.business.concrete;

import com.muammerdiri.rentACar.business.abstracts.CarService;
import com.muammerdiri.rentACar.core.utilities.result.*;
import com.muammerdiri.rentACar.dataAccess.abstracts.CarDao;
import com.muammerdiri.rentACar.entities.concrete.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarManager implements CarService {

    private CarDao carDao;

    @Autowired
    public CarManager(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Result add(Car car) {

        if(car.getTitle().length() >=2 && car.getDailyPrice()>0){
            carDao.save(car);
            return new SuccessResult("Car is added.");
        }

        return new ErrorResult("Car cannot be added!!");
    }

    @Override
    public Result delete(Car car) {
        carDao.deleteById(car.getId());
        return new SuccessResult("Car is deleted");
    }

    @Override
    public List<Car> getAll() {
        return carDao.findAll(Sort.by(Sort.Direction.ASC,"title"));
    }

    @Override
    public List<Car> findCarByModelYearNamedParams(Integer status) {
        return carDao.findCarByModelYearNamedParams(status);
    }

    @Override
    public Car findCarByIdNamedParams(int id) {
        return carDao.findCarByIdNamedParams(id);
    }

//    @Override
//    public List<CarDto> carDtoDetails() {
//        return carDao.carDtoDetails();
//    }


}
