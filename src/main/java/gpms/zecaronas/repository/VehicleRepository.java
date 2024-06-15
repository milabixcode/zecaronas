package gpms.zecaronas.repository;

import org.springframework.data.repository.CrudRepository;

import gpms.zecaronas.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
