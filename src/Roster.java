public class Roster {
    private Student[] roster;
    private int size; // keep track of the number of students in the roster

    public Roster(){
        roster = new Student[4];
        size = 0;
    }

    private int find(Student student){
        for (int i = 0; i < this.size; i++) {
            if (this.roster[i] == student) {
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


    }

    public boolean remove(Student student){


    }
}
