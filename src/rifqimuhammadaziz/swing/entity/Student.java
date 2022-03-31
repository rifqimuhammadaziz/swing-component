package rifqimuhammadaziz.swing.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String id;
    private String name;
    private boolean male;
    private List<String> hobbies;
    private Department department;
    private int programmingSkill;

    public Student() {
        hobbies = new ArrayList<>();
    }

    public Student(String id, String name, boolean male, Department department, int programmingSkill) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.department = department;
        this.programmingSkill = programmingSkill;
        hobbies = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getProgrammingSkill() {
        return programmingSkill;
    }

    public void setProgrammingSkill(int programmingSkill) {
        this.programmingSkill = programmingSkill;
    }
}
