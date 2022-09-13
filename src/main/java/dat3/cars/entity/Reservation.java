package dat3.cars.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

//------------- LOMBOK ----------
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//------------- LOMBOK ----------
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    Member member;
    @ManyToOne
    Car car;
    @CreationTimestamp
    LocalDateTime reservationDate;

    LocalDate rentalDate;



    public Reservation(LocalDateTime reservationDate, LocalDate rentalDate) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
    }

    public Reservation (Member member, Car car, LocalDate rentalDate){
        this.member = member;
        this.car = car;
        this.rentalDate = rentalDate;
    }


}
