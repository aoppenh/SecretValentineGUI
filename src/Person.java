/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 */
public class Person {
    private String name;
    private boolean assigned;
    private boolean santa;

    public Person(String name, boolean assigned, boolean santa) {
        this.name = name;
        this.assigned = assigned;
        this.santa = santa;
    }

    public String getName() {
        return name;
    }
    public boolean getAssigned() {
        return assigned;
    }
    public boolean getSanta() {
        return santa;
    }

    public void set(String name, boolean assigned, boolean santa) {
        this.name = name;
        this.assigned = assigned;
        this.santa = santa;
    }
}
