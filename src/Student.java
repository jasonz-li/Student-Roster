public class Student {
    private Profile profile;
    private int creditHours;
    private double totalCost = 0;
    private Date date = null;

    //Constructors
    public Student(){
    }

    public Student (String name, String major, int creditHours){
        this.profile = new Profile(name, major);
        this.creditHours = creditHours;
    }

    //Treat like an abstract class
    public void tuitionDue() {
    }

    public boolean payTuition(double payment, Date date){

        if(this.totalCost > payment){
            this.date = date;
            this.totalCost = this.totalCost - payment;
            return true;
        }else{
            return false; //total cost is < than payment
        }
    }

    //to string and maybe equals

    @Override
    public String toString() {
        String string = this.profile.toString() + ", " + this.creditHours;
        return string;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if(o instanceof Student){
            Student newStudent = (Student) o;
            if(this.profile.equals(newStudent.profile) && this.creditHours == newStudent.creditHours){
                return true;
            }
        }
        return false;
    }

    public Profile getProfile() {return this.profile;}

    public int getCreditHours() {return this.creditHours;}

    public void setCreditHours(int credits) {this.creditHours = credits;}

    public double getTotalCost() {return this.totalCost;}

    public void setTotalCost(double totalCost) {this.totalCost = totalCost;}

    public Date getDate() {return this.date;}

    public void setDate(Date date){this.date = date;}
}

