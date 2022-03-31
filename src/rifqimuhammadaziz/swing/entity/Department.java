package rifqimuhammadaziz.swing.entity;

public class Department {

    private int id;
    private String name;
    private int establishedYear;

    public Department() {
    }

    public Department(int id, String name, int establishedYear) {
        this.id = id;
        this.name = name;
        this.establishedYear = establishedYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
