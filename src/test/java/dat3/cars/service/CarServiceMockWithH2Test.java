package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.dto.MemberRequest;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repository.CarRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarServiceMockWithH2Test {

    public CarService carService;

    public static CarRepository carRepository;

    @BeforeAll
    public static void setupData (@Autowired CarRepository car_Repository){
        carRepository = car_Repository;

        List<Car> cars = List.of(
                new Car(1,"testBrand1", "testModel1", 400, 50),
                new Car(2,"testBrand2", "testModel2", 300, 120)
        );
        carRepository.saveAll(cars);
    }

    @BeforeEach
    public void setCarService (){
        carService = new CarService(carRepository);


    }

    @Test
    void testHowManyCars (){
        assertEquals(2, carRepository.count());

    }

    @Test
    void addCar() {
        Car car = new Car(3,"testBrand3", "testModel3", 200, 40);
        CarRequest carRequest = new CarRequest(car);
        carService.addCar(carRequest);

        assertEquals(3, carRepository.count());
    }


    @Test
    void getCars() {
    }

  /*  @Test
    void findCarById() throws Exception {
        CarResponse response = carService.findCarById(2);
        assertEquals("testModel2", response.getModel());

    }*/
}