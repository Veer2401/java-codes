package Gym_App;

import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String memberId;
    private double amount;
    private LocalDate date;
    private String method; // online/offline/note

    public Payment(String id, double amount, LocalDate date, String method) {
        this.memberId = id;
        this.amount = amount;
        this.date = date;
        this.method = method;
    }

    public String getMemberId() { return memberId; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getMethod() { return method; }
}
