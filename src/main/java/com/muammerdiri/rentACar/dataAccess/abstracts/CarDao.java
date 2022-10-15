package com.muammerdiri.rentACar.dataAccess.abstracts;

import com.muammerdiri.rentACar.entities.concrete.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarDao extends JpaRepository<Car,Integer> {

    @Query("SELECT u FROM Car u WHERE u.modelYear = :modelYear" )
    List<Car> findCarByModelYearNamedParams(@Param("modelYear") Integer status);

    @Query("Select c from Car c WHERE c.id = :id")
    Car findCarByIdNamedParams(@Param("id") int id);





//    @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
//            + "(p.id, p.productName, c.categoryName) "
//            + "From Category c Inner Join c.products p")
}
