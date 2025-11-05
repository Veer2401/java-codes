package Gym_App;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int age;
    private double weightKg;
    private double heightCm;
    private MembershipPlan plan;
    private LocalDate membershipExpiry;

    public Member() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }
    public double getHeightCm() { return heightCm; }
    public void setHeightCm(double heightCm) { this.heightCm = heightCm; }
    public MembershipPlan getPlan() { return plan; }
    public void setPlan(MembershipPlan plan) { this.plan = plan; }
    public LocalDate getMembershipExpiry() { return membershipExpiry; }
    public void setMembershipExpiry(LocalDate membershipExpiry) { this.membershipExpiry = membershipExpiry; }

    public double getBmi() {
        if (heightCm <= 0) return 0;
        double m = heightCm/100.0;
        return weightKg / (m*m);
    }

    @Override
    public String toString() {
        return name + " (" + id.substring(0,6) + ")";
    }
}
