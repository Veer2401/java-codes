package Gym_App;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATA_FILE = "gym_data.ser";

    private List<Member> members = new ArrayList<>();
    private List<Trainer> trainers = new ArrayList<>();

    private static DataStore instance;

    private DataStore() {}

    public static DataStore load() {
        File f = new File(DATA_FILE);
        if (!f.exists()) {
            instance = new DataStore();
            return instance;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            instance = (DataStore) ois.readObject();
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            instance = new DataStore();
            return instance;
        }
    }

    public static void save() {
        if (instance == null) return;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Member> getMembers() { return members; }
    public List<Trainer> getTrainers() { return trainers; }

    public void addMember(Member m) { members.add(m); }
    public void removeMember(Member m) { members.remove(m); }
}
