package gpms.zecaronas.ui;

import gpms.zecaronas.entity.Ride;
import gpms.zecaronas.entity.User;
import gpms.zecaronas.policy.RidePolicy;

public class RideUI {
    public Ride ride;
    public User currentUser;
    public RidePolicy policy;

    public static RideUI from(Ride ride, User currentUser) {
        var ui = new RideUI();
        ui.ride = ride;
        ui.currentUser = currentUser;
        ui.policy = new RidePolicy(currentUser, ride);

        return ui;
    }

    public String roleInTheRide() {
        if (ride.getIdMotorista().equals(currentUser.getId())) {
            return "motorista";
        }

        if (ride.getUsers().stream().anyMatch(userRide -> userRide.getUser().getId().equals(currentUser.getId()))) {
            return "passageiro";
        }

        return null;
    }
}
