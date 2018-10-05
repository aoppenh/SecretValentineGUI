/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/04/2018
 */
public class Person {
    private String name;
    private boolean assigned;
    private boolean valen;
    private int sex;
    private Preference pref;

    public Person(String name, boolean assigned, boolean valen, int sex, Preference pref) {
        this.name = name;
        this.assigned = assigned;
        this.valen = valen;
        this.sex = sex;
        this.pref = pref;
    }

    public String getName() {
        return name;
    }
    public boolean getAssigned() {
        return assigned;
    }
    public boolean getSanta() {
        return valen;
    }
    public int getSex() {
        return sex;
    }
    public Preference getPref() {
        return pref;
    }

    public void set(String name, boolean assigned, boolean santa) {
        this.name = name;
        this.assigned = assigned;
        this.valen = santa;
    }
}
