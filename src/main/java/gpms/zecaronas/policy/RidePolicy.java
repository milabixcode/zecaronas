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
        return ride.relationWith(user).equals("");
    }
}
