/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/05/2018
 */
public class Person {
    private String name;
    private boolean assigned;
    private boolean valen;
    private Preference pref;

    public Person(String name, boolean assigned, boolean valen, Preference pref) {
        this.name = name;
        this.assigned = assigned;
        this.valen = valen;
        this.pref = pref;
    }

    public String getName() {
        return name;
    }
    public boolean getAssigned() {
        return assigned;
    }
    public boolean getValen() {
        return valen;
    }
    public Preference getPref() {
        return pref;
    }

    public void set(String name, boolean assigned, boolean valen, Preference pref) {
        this.name = name;
        this.assigned = assigned;
        this.valen = valen;
        this.pref = pref;
    }

    public void set(String name, boolean assigned, boolean valen) {
        this.name = name;
        this.assigned = assigned;
        this.valen = valen;
    }
}
