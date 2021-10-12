import org.junit.Test;

import static org.junit.Assert.*;

public class InternationalTest {

    @Test
    public void tuitionDue() {
        International student = new International("Joe", "CS", 14, true);
        student.tuitionDue();
        assertEquals(5918 , student.getTotalCost(), 0.0);

        International student1 = new International("Joe", "CS", 14, true);
        student1.tuitionDue();
        assertNotEquals(5000, student1.getTotalCost(), 0.0);

        International student2 = new International("Joe", "CS", 14, false);
        student2.tuitionDue();
        assertEquals(35655 , student2.getTotalCost(), 0.0);

        International student3 = new International("Joe", "CS", 14, false);
        student3.tuitionDue();
        assertNotEquals(3565, student3.getTotalCost(), 0.0);

        International student4 = new International("Joe", "CS", 20, false);
        student4.tuitionDue();
        assertEquals(39519, student4.getTotalCost(), 0.0);

        International student5 = new International("Joe", "CS", 20, false);
        student5.tuitionDue();
        assertNotEquals(3919, student5.getTotalCost(), 0.0);
    }
}