import org.junit.Test;

import static org.junit.Assert.*;

public class RosterTest {

    @Test
    public void add() {
        Roster roster = new Roster();
        Student student = new Student("john", "CS",12);
        assertTrue(roster.add(student));

        Roster roster1 = new Roster();
        Student student1 = new Student("john", "CS",12);
        Student student2 = new Student("mike", "IT",14);
        Student student3 = new Student("joe", "BA",18);
        Student student4 = new Student("jill", "CS",20);
        Student student5 = new Student("grill", "EE",20);
        roster.add(student1);
        roster.add(student2);
        roster.add(student3);
        roster.add(student4);
        assertTrue(roster1.add(student5));

        Roster roster2 = new Roster();
        International student6 = new International("john", "CS",12, false);
        Resident student7 = new Resident("mike", "IT",14);
        Student student8 = new Student("joe", "BA",18);
        NonResident student9 = new NonResident("jill", "CS",20);
        TriState student10 = new TriState("grill", "EE", 20, "CT");
        roster.add(student6);
        roster.add(student7);
        roster.add(student8);
        roster.add(student9);
        assertTrue(roster2.add(student10));


    }

    @Test
    public void remove() {
        Roster roster = new Roster();
        Student student = new Student("john", "CS",12);
        roster.add(student);
        assertTrue(roster.remove(student));

        Roster roster1 = new Roster();
        Student student1 = new Student("john", "CS",12);
        assertFalse(roster1.remove(student1));

        Roster roster2 = new Roster();
        International student2 = new International("john", "CS",12, false);
        Resident student3 = new Resident("mike", "IT",14);
        Student student4 = new Student("joe", "BA",18);
        NonResident student5 = new NonResident("jill", "CS",20);
        TriState student6 = new TriState("grill", "EE", 20, "CT");
        roster2.add(student2);
        roster2.add(student3);
        roster2.add(student4);
        roster2.add(student5);
        roster2.add(student6);
        assertTrue(roster2.remove(student2));
        assertTrue(roster2.remove(student3));
        assertTrue(roster2.remove(student4));
        assertTrue(roster2.remove(student5));
        assertTrue(roster2.remove(student6));
    }
}