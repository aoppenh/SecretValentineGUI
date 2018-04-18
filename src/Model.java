import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Andyo on 12/25/2016.
 * Version 4/17/2018
 */
public class Model {
    static Hashtable<Person, Person> peopleAndAssignments = new Hashtable<>();
    static ArrayList<Person> people = new ArrayList<>();
    static int counter;
    static int counterAdded;
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
    static String importDisplayString;
    static String randomDisplayString;

    public static void setPeopleAndAssignments() {
        
    }

//    public static void setPeopleAndAssignments() {
//        counterAssign = 0;
//        i = 0;
//        while (counterAssign < people.size()) {
//            int ran = r.nextInt(people.size() - 1);
//            for (Person p : people) {
//                System.out.println(p.getName() + " : " + p.getAssigned() + " : " + p.getSanta() + " : " + p.getClass());
//            }
//            if (!(people.get(ran).equals(people.get(i))) && !people.get(ran).getAssigned() && !people.get(ran).getSanta()) {
//                peopleAndAssignments.put(people.get(ran), people.get(i));
//                people.get(ran).set(people.get(ran).getName(), true, people.get(ran).getSanta());
//                people.get(i).set(people.get(i).getName(), people.get(i).getAssigned(), true);
//                counterAssign++;
//            }
//            i++;
//        }
//    }

    public static void save() throws FileNotFoundException {
        writer = new PrintWriter(newFile);
        writer.println(list);
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
    }
}
