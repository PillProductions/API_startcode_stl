package dat3.cars.api;


import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

   // @Autowired
CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponse> getCars (){

        return carService.getCars();
    }

    @GetMapping(path = "/{id}")
    public CarResponse getCarById(@PathVariable int id) throws Exception {
    CarResponse response = carService.findCarById(id);
    return response;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public CarResponse addCar(@RequestBody CarRequest body) {
        return carService.addCar(body);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_HTML_VALUE)
    public String addCar2(@RequestBody CarRequest body) {
        carService.addCar(body);
        return  body.getId() + " was created";
    }

    @DeleteMapping(path = "/{id}")
    public void deteleCarById(@PathVariable int id){
        carService.deleteCarById(id);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Boolean> editCar (@RequestBody CarRequest body, @PathVariable int id){
        carService.editCar(body, id);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @PatchMapping("/pricePrDay/{id}/{value}")
    public void setpricePrDayForCar(@PathVariable int id, @PathVariable int value){
        carService.setPricePrDay(id,value);
    }
    @PatchMapping("/bestDiscount/{id}/{value}")
    public void setbestDiscountForCar(@PathVariable int id, @PathVariable int value){
        carService.setBestDiscount(id,value);
    }

}
