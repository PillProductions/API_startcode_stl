package dat3.cars.api;


import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.dto.ReservationRequest;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.entity.Reservation;
import dat3.cars.service.CarService;
import dat3.cars.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<ReservationResponse> getReservations (){

        return reservationService.getReservations();
    }


   /* @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationResponse addReservation(@RequestBody ReservationRequest body) {
        return reservationService.addReservation(body);
    } */

    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_HTML_VALUE)
    public String addCar2(@RequestBody CarRequest body) {
        carService.addCar(body);
        return  body.getId() + " was created";
    }*/
}
