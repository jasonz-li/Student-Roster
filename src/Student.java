import java.text.DecimalFormat;

public class Student {
    private Profile profile;
    private int creditHours;
    private double totalCost = 0;
    private double totalPayment = 0;
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
        if(payment <= 0){
            System.out.println("Invalid amount.");
            return false;
        }else{
            if(this.totalCost > payment){
                this.totalPayment = this.totalPayment + payment;
                this.date = date;
                this.totalCost = this.totalCost - payment;
                System.out.println("Payment applied.");
                return true;
            }else{                  //payment > cost
                System.out.println("Amount is greater than amount due.");
                return false;
            }
        }
    }


    //@Override
    //public String toString() {  //John Doe:EE:18 credit hours:tuition due:0.00:total payment:0.00:last payment date: --/--/--:resident
    //    String pattern = "####,####.##";
    //    DecimalFormat numberFormat = new DecimalFormat(pattern);
    //    String dateString = date.getDate();
    //    if(this.date == null){
    //       dateString = "--/--/--";
    //    }
    //    String string = this.profile.getName() + ":" + this.profile.getMajor() + ":" + this.creditHours
    //            + " credit hours:" + "tuition due:" + numberFormat.format(this.totalCost) + ":" +
    //            "total payment:" + numberFormat.format(this.totalPayment) + ":" + "last payment date: "
    //            + dateString + ":" + "resident";

    //    return string;
    //}

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

    public double getTotalPayment() {return this.totalPayment;}

    public void setTotalPayment(double payment) {this.totalPayment = payment;}
}

