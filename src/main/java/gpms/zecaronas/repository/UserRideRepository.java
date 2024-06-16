package gpms.zecaronas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import gpms.zecaronas.entity.Ride;
import gpms.zecaronas.entity.User;
import gpms.zecaronas.entity.UserRide;

public interface UserRideRepository extends CrudRepository<UserRide, Long> {
    @Query("select ur from UserRide ur where ur.user = :user and ur.ride = :ride")
    Optional<UserRide> findByUserAndRide(@Param("user") User user, @Param("ride") Ride ride);
}
