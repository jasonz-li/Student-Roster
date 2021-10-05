public class Student {
    Profile profile;

    //Constructors
    public Student(){
    }

    public Student (String name, String major){
        this.profile = new Profile(name, major);
    }

    //Treat like an abstract class
    public void tuitionDue() {
    }

}