import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/05/2018
 */
public class Model {
    static Hashtable<Person, Person> peopleAndAssignments;
    static ArrayList<Person> people = new ArrayList<>();
    static int counter = 0;
    static int counterAdded;
    static boolean falseImportCheck = false;
    static int counterAssign;
    static int i;
    static Random r = new Random();
    static String path = "C:\\Users\\Andyo\\Desktop";
    static String fileName;
    static String importFileName;
    static String list;
    static File f;
    static File newFile;
    static File desktop = new File(System.getProperty("user.home") + "\\Desktop");
    static PrintWriter writer;
    static Scanner reader;
    static StringBuilder readBuilder;
    static StringBuilder saveBuilder;
    static String importDisplayString;
    static String tempDisplayString = "";
    static String saveString;

    public static void setPeopleAndAssignments() {
        peopleAndAssignments = new Hashtable<>();
        counterAssign = 0;
        i = 0;
        long newTime;
        long startTime = System.currentTimeMillis();
        while (counterAssign < people.size()) {
            int ran = r.nextInt(people.size());
            newTime = System.currentTimeMillis() - startTime;
            if (newTime > 5000) {
                for (Person p : people) {
                    p.set(p.getName(), false, false, p.getPref());
                }
                i = 0;
                counterAssign = 0;
                peopleAndAssignments = new Hashtable<>();
                startTime = System.currentTimeMillis();
//                System.out.println("TIMEOUT : RE-RANDOMIZING : " + newTime);
            }
            if (newTime > 5000) {
                i = 0;
                for (Person p : people) {
                    p.set(p.getName(), false, false, Preference.BISEXUAL);
                }
            }
            if (!(people.get(ran).equals(people.get(i))) && !people.get(ran).getAssigned() && !people.get(i).getValen() && checkCompatible(people.get(i), people.get(ran)) && newTime <= 5000) {
                peopleAndAssignments.put(people.get(ran), people.get(i));
                people.get(ran).set(people.get(ran).getName(), true, people.get(ran).getValen());
                people.get(i).set(people.get(i).getName(), people.get(i).getAssigned(), true);
                counterAssign++;
                i++;
            } else if (!(people.get(ran).equals(people.get(i))) && !people.get(ran).getAssigned() && !people.get(i).getValen()) {
                peopleAndAssignments.put(people.get(ran), people.get(i));
                people.get(ran).set(people.get(ran).getName(), true, people.get(ran).getValen());
                people.get(i).set(people.get(i).getName(), people.get(i).getAssigned(), true);
                counterAssign++;
                i++;
            }
        }
    }

    public static boolean checkCompatible(Person a, Person b) {
        if (a.getPref() == Preference.GAY || a.getPref() == Preference.LESBIAN) {
            if (a == b) {
                return true;
            } else {
                return false;
            }
        } else if (a.getPref() == Preference.STRAIGHT_MALE || a.getPref() == Preference.STRAIGHT_FEMALE) {
            if (a == b) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static void save() throws FileNotFoundException {
        saveString = saveBuilder.toString();
        writer = new PrintWriter(newFile);
        writer.println(saveString);
        writer.close();
    }

    public static void importFile() throws FileNotFoundException {
        reader = new Scanner(new FileReader(desktop + "\\" + importFileName));
        importDisplayString = "";
        readBuilder = new StringBuilder();
        while (reader.hasNext()) {
            readBuilder.append(reader.nextLine() + "\n");
        }
        reader.close();
        importDisplayString = readBuilder.toString();
        falseImportCheck = false;
    }
}
