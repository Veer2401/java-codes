package Gym_App;

import java.time.LocalDate;

public enum MembershipPlan {
    MONTHLY(30),
    QUARTERLY(90),
    YEARLY(365);

    private final int days;
    MembershipPlan(int days) { this.days = days; }
    public LocalDate expiryFrom(LocalDate start) { return start.plusDays(days); }
}
