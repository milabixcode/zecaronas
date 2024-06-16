package gpms.zecaronas.policy;

import gpms.zecaronas.entity.Ride;
import gpms.zecaronas.entity.User;

public class RidePolicy {
    private User user;
    private Ride ride;

    public RidePolicy(User user, Ride ride) {
        this.user = user;
        this.ride = ride;
    }

    public boolean canApply() {
        var isPassenger = ride.getUsers().stream().anyMatch(userRide -> userRide.getUser().getId().equals(user.getId()));
        var notTheDriver = !user.getId().equals(ride.getIdMotorista());

        return notTheDriver && !isPassenger;
    }
}
