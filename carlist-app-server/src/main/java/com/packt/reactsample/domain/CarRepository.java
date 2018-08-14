package com.packt.reactsample.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// The repository for the Car entity class and
// the type of the ID field is long.
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

    // Fetch cars by brand
    List<Car> findByBrand(@Param("brand") String brand);

    // Fetch cars by color
    List<Car> findByColor(@Param("color") String color);

//    // Fetch cars by brand
//    List<Car> findByBrand(String brand);
//
//    // Fetch cars by color
//    List<Car> findByColor(String color);
//
//    // Fetch cars by year
//    List<Car> findByYear(int year);
//
//    // Fetch cars by brand and model
//    List<Car> findByBrandAndModel(String brand, String model);
//
//    // Fetch cars by brand or color
//    List<Car> findByBrandOrColor(String brand, String color);
//
//    // Fetch cars by brand and sort by year
//    List<Car> findByBrandOrderByYearAsc(String brand);
//
//    // Fetch cars by model using SQL
//    @Query("select c from Car c where c.model = ?1")
//    List<Car> findByModel(String model);
//
//    // Fetch cars by brand using SQL
//    @Query("select c from Car c where c.brand like %?1")
//    List<Car> findByBrandEndsWith(String brand);
}
