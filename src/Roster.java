/**
 * Roster keeps track of all the students in an array and allows for adding, removing, finding, and printing
 * printCurrentOrder() is a helper method that prints the current order of the array.
 * printByPaymentDate() sorts students by chronological order of their last payment date and calls
 * printPaymentDays() in order to print the list.
 * findStudent() helps to find students based on their name and major.
 *
 * @author Jason Li, John Leng
 */
public class Roster {
    private Student[] roster;
    private int size; // keep track of the number of students in the roster

    /**
     * Initializes the roster with an array of size 4 and the number of students in roster to 0.
     */
    public Roster(){
        roster = new Student[4];
        size = 0;
    }

    /**
     * Finds the album index of a target student in the roster.
     *
     * @param student wanted student.
     * @return index of wanted student or returns -1 if student not in roster.
     */
    private int find(Student student){
        for (int i = 0; i < this.size; i++) {
            if (this.roster[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Increases size of roster by 4 when the roster is filled.
     */
    private void grow(){
        Student[] newRoster = new Student[this.size + 4];
        for (int i = 0; i < this.size; i++){
            newRoster[i] = this.roster[i];
        }
        this.roster = newRoster;
    }

    /**
     * Adds a student to the roster.
     * @param student input student
     * @return true if the student was successfully added, false if student is already in roster.
     */
    public boolean add(Student student){

        if (this.size < this.roster.length) {
            this.roster[size] = student;
            this.size++;
            if(size == roster.length){
                this.grow();
            }
            return true;
        } else if (size == roster.length) {
            this.grow();
            this.add(student);
        }
        return false;
    }

    /**
     * Removes target student from roster.
     * @param student target student
     * @return true if student was sucessfully removed, false if student not in roster.
     */
    public boolean remove(Student student){
        Student[] temp = new Student[roster.length];
        int j = 0;
        boolean check = false;
        for (int i = 0; i < size; i++){
            if (check == false && student.getClass().equals(roster[i].getClass())
                    && student.getProfile().getName().equals(roster[i].getProfile().getName())
                    && student.getProfile().getMajor().equals(roster[i].getProfile().getMajor())) {    // if the removed student == roster student, skip them
                if (j <= size){  // if the next j is in bounds, continue
                    check = true;
                    j++;
                    temp[i] = roster[j];
                    j++;
                    continue;
                }
            }
            else{
                temp[i] = roster[j];
            }
            j++;
        }
        if(check == false){
            return false;
        }
        else{
            roster = temp;
            this.size--;
            return true;
        }

    }

    /**
     * Prints out roster in its current order.
     */
    private void printCurrentOrder(){
        for(int i = 0; i < this.roster.length; i++){
            if(roster[i] != null){
                if(roster[i] instanceof Resident){
                    Resident student = (Resident) roster[i];
                    System.out.println(student.toString());
                }
                else if(roster[i] instanceof TriState){
                    TriState student = (TriState) roster[i];
                    System.out.println(student.toString());
                }
                else if(roster[i] instanceof International){
                    International student = (International) roster[i];
                    System.out.println(student.toString());
                }
                else if(roster[i] instanceof NonResident){
                    NonResident student = (NonResident) roster[i];
                    System.out.println(student.toString());
                }
            }
        }
    }

    /**
     * Prints out roster in its current order.
     */
    public void print() {
        System.out.println("* list of students in the roster **");
        this.printCurrentOrder();
        System.out.println("* end of roster **");
    }

    /**
     * Sorts roster by payment date.
     */
    public void printByPaymentDate() {
        int rosterSize = this.size;
        for (int i = 0; i < rosterSize-1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < rosterSize; j++)
                if (roster[min_idx].getDate() != null && roster[j].getDate() != null){
                    if (roster[min_idx].getDate().compareTo(roster[j].getDate()) == 1){
                        min_idx = j;
                    }
                }
            Student tempVar = roster[min_idx];
            roster[min_idx] = roster[i];
            roster[i] = tempVar;
        }
        System.out.println("* list of students made payments ordered by payment date **");
        this.printPaymentDays();
        System.out.println("* end of roster **");
    }

    /**
     * Prints the roster by payment date.
     */
    public void printPaymentDays() {
        for(int i = 0; i < this.roster.length; i++){
            if(roster[i] != null && roster[i].getDate() != null && roster[i].getDate().getDateCleared() == false){
                if (roster[i] instanceof Resident){
                    Resident student = (Resident) roster[i];
                    System.out.println(student.toString());
                }
                else if(roster[i] instanceof TriState){
                    TriState student = (TriState) roster[i];
                    System.out.println(student.toString());
                }
                else if(roster[i] instanceof International){
                    International student = (International) roster[i];
                    System.out.println(student.toString());
                }
                else if(roster[i] instanceof NonResident){
                    NonResident student = (NonResident) roster[i];
                    System.out.println(student.toString());
                }
            }
        }
    }

    /**
     * Prints roster in alphabetical order by name.
     */
    public void printByName() {
        int rosterSize = this.size;
        for (int i = 0; i < rosterSize-1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < rosterSize; j++)
                if (roster[min_idx].getProfile().getName().compareTo(roster[j].getProfile().getName()) >= 0){
                    min_idx = j;
                }

            Student tempVar = roster[min_idx];
            roster[min_idx] = roster[i];
            roster[i] = tempVar;
        }
        System.out.println("* list of students ordered by name **");
        this.printCurrentOrder();
        System.out.println("* end of roster **");
    }

    /**
     * Finds target student.
     * @param name student name
     * @param major student major
     * @return true if student is found, otherwise returns null.
     */
    public Student findStudent(String name, String major) {
        for (int i = 0; i < size; i++) {
            if (roster[i] != null) {
                if (roster[i].getProfile().getName().equals(name) && roster[i].getProfile().getMajor().equals(major)) {
                    return roster[i];
                }
            }
        }
        return null;
    }

    /**
     * Gets the number of students in the roster.
     * @return number of students in roster.
     */
    public int getSize(){
        return size;
    }

    /**
     * Gets the array of students in roster.
     * @return array of students in roster.
     */
    public Student[] getRoster(){
        return roster;
    }
}