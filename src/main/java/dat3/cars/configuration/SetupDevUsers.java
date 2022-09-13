package dat3.cars.configuration;

import dat3.cars.dto.ReservationRequest;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repository.CarRepository;
import dat3.cars.repository.MemberRepository;
import dat3.cars.repository.ReservationRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class SetupDevUsers implements ApplicationRunner {

  UserWithRolesRepository userWithRolesRepository;
  MemberRepository memberRepository;
  ReservationRepository reservationRepository;
  CarRepository carRepository;
  String passwordUsedByAll;

  public SetupDevUsers(UserWithRolesRepository userWithRolesRepository,
                       ReservationRepository reservationRepository,
                       MemberRepository memberRepository,
                       CarRepository carRepository) {
    this.userWithRolesRepository = userWithRolesRepository;
    this.memberRepository = memberRepository;
    this.carRepository = carRepository;
    this.reservationRepository = reservationRepository;
    passwordUsedByAll = "test12";
  }

  @Override
  public void run(ApplicationArguments args) {
    Member m1 = new Member("member1", passwordUsedByAll, "memb1@a.dk", "Kurt", "Wonnegut", "Lyngbyvej 2", "Lynbby", "2800");
    memberRepository.save(m1);

    Car car1 = Car.builder()
            .brand("Volvo")
            .model("V70")
            .pricePrDay(700)
            .bestDiscount(30.0)
            .build();

    carRepository.save(car1);

    Car car2 = new Car("Testbil", "Testbil", 200, 30);
    carRepository.save(car2);

    Reservation reservation1 = new Reservation(m1, car1, LocalDate.of(2020,2,1));
    Reservation reservation2 = new Reservation(m1, car2, LocalDate.of(2022,04,03));


    m1.addReservation(reservation2);
    reservationRepository.save(reservation1);
    reservationRepository.save(reservation2);
    memberRepository.save(m1);





    setupUserWithRoleUsers();



  }













  /*****************************************************************************************
   NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
   iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
   *****************************************************************************************/
  private void setupUserWithRoleUsers() {
    System.out.println("******************************************************************************");
    System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
    System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
    System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
    System.out.println("******************************************************************************");
    UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
    UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
    UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
    user1.addRole(Role.USER);
    user1.addRole(Role.ADMIN);
    user2.addRole(Role.USER);
    user3.addRole(Role.ADMIN);
    userWithRolesRepository.save(user1);
    userWithRolesRepository.save(user2);
    userWithRolesRepository.save(user3);
  }
}
