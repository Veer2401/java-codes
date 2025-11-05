package Gym_App;

import java.io.Serializable;
import java.util.UUID;

public class Trainer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String bio;

    public Trainer() { this.id = UUID.randomUUID().toString(); }
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    @Override
    public String toString() { return name; }
}
