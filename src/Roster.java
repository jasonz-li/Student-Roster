public class Roster {
    private Student[] roster;
    private int size; // keep track of the number of students in the roster

    public Roster(){
        roster = new Student[4];
        size = 0;
    }

    private int find(Student student){
        for (int i = 0; i < this.size; i++) {
            if (this.roster[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    private void grow(){
        Student[] newRoster = new Student[this.size + 4];
        for (int i = 0; i < this.size; i++){
            newRoster[i] = this.roster[i];
        }
        this.roster = newRoster;
    }

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

    public boolean remove(Student student){
        Student[] temp = new Student[size];
        int j = 0;
        boolean check = false;
        for (int i = 0; i < size; i++){
            if (check == false && student.equals(roster[i])) {    // if the removed student == roster student, skip them
                if(++j < roster.length){  // if the next j is in bounds, continue
                    check = true;
                    j++;
                    temp[i] = roster[j];
                }
            }else{
                if(j < roster.length){   // if j is in bounds, set temp array.
                    temp[i] = roster[j];
                    ++j;
                }
            }
        }
        roster = temp;
        this.size--;
        return true;
    }

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

    public void print() {
        System.out.println("* list of students in the roster **");
        this.printCurrentOrder();
        System.out.println("* end of roster **");
    }

    public void printByPaymentDate() {
        int albumsLength = this.size;

        for (int i = 0; i < albumsLength-1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < albumsLength; j++)
                if (roster[min_idx].getDate().compareTo(roster[j].getDate()) == 1){
                    min_idx = j;
                }

            Student tempVar = roster[min_idx];
            roster[min_idx] = roster[i];
            roster[i] = tempVar;
        }
        System.out.println("* list of students made payments ordered by payment date **");
        this.printCurrentOrder();
        System.out.println("* end of roster **");
    }

    public void printByName() {
        int albumsLength = this.size;

        for (int i = 0; i < albumsLength-1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < albumsLength; j++)
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

    public int getSize(){
        return size;
    }

    public Student[] getRoster(){
        return roster;
    }
}
