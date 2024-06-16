package gpms.zecaronas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gpms.zecaronas.entity.Ride;

public interface RideRepository extends CrudRepository<Ride, Long> {
    @Query("SELECT r FROM Ride r ORDER BY r.inicioCarona DESC limit 10")
    List<Ride> findLastRides();

    @Query("SELECT r from Ride r left join r.users u where u.user.id = :userId or r.idMotorista = :userId")
    List<Ride> ridesWithUser(@Param("userId") Long userId);
}
