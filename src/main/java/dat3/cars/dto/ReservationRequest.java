package dat3.cars.dto;


import dat3.cars.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class ReservationRequest {


    int carId;
    String userName;
    LocalDate rentalDate;

    public ReservationRequest ( int carId, String username, LocalDate rentalDate){
        this.carId = carId;
        this.userName = username;
        this.rentalDate = rentalDate;
    }

   /* public static Reservation getReservationEntity (ReservationRequest r){

        return new Reservation(r.getUserName(), r.getCarId(), r.getRentalDate());
    }*/
}
