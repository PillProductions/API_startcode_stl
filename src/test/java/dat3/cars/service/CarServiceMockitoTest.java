package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Car;
import dat3.cars.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CarServiceMockitoTest {

    @Autowired
    @Mock
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @BeforeEach
    public void setup (){
        carService = new CarService(carRepository);
    }

    @Test
    void getCars() {
        Mockito.when(carRepository.findAll()).thenReturn(List.of(
                new Car("Testbil1", "Testbil1", 300, 20 ),
                new Car("Testbil2", "testbil2", 500, 90),
                new Car("Testbil3", "Testbil3", 200, 140)));
        List<CarResponse> cars = carService.getCars();
        assertEquals(3, cars.size());

    }

    @Test
    void findCarByModel() throws Exception {
        Car car = new Car("brand1", "model1", 300, 130);
        Mockito.when(carRepository.findById(1)).thenReturn(Optional.of(car));

        CarResponse response = carService.findCarById(1);
        assertEquals("model1", response.getModel());



    }

    @Test
    void addCar() throws Exception {
        Car car1 = new Car(1,"testBrand1", "testModel1", 900, 500 );
        Car car2 = new Car(2, "testBrand2", "testModel2", 400, 70);

        //Mockito.when(carRepository.save(any(Car.class))).thenReturn(car1);
        Mockito.when(carRepository.save(any(Car.class))).thenReturn(car2);

        CarRequest carRequest1 = new CarRequest(car1);
        CarRequest carRequest2 = new CarRequest(car2);

        CarResponse found = carService.addCar(carRequest2);
        assertEquals(2, found.getId());

    }

    /*@Test
    void deleteCarById() throws Exception {
        Car car1 = new Car(1,"testBrand1", "testModel1", 900, 500 );
        Car car2 = new Car(2, "testBrand2", "testModel2", 400, 70);

        Mockito.when(carRepository.save(any(Car.class))).thenReturn(car1);
        Mockito.when(carRepository.save(any(Car.class))).thenReturn(car2);

        CarRequest carRequest1 = new CarRequest(car1);
        CarRequest carRequest2 = new CarRequest(car2);

        carService.deleteCarById(car2.getId());

    }*/

}