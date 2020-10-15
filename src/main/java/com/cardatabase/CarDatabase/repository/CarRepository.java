package com.cardatabase.CarDatabase.repository;

import com.cardatabase.CarDatabase.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    //f Fetch cars by each of the fields in the model
    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByModel(String model);
    List<Car> findByRegisterNumber(String registerNumber);
    List<Car> findByYear(int year);
    List<Car> findByPrice(int price);

    // Fetch cars by brand and model
    List<Car> findByBrandAndModel(String brand, String model);
    // Fetch cars by brand or color
    List<Car> findByBrandOrColor(String brand, String color);

    // Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByYearAsc(String brand);

    // Fetch cars by brand using SQL
//    @Query("select c from Car c where c.brand = ?1")
//    List<Car> findByBrand(String brand);
}

