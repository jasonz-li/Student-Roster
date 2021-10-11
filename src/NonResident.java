import java.text.DecimalFormat;

public class NonResident extends Student{
    boolean fullTime;



    public NonResident(String name, String major, int credits){
        super(name, major, credits);
        this.fullTime = credits >= 12;
    }

    public void tuitionDue() {
        double tuition = 29737;
        double fee = 3268;
        if (fullTime == true){ // full-time
            if (this.getCreditHours() > 16){ // over 16 credit fees
                tuition += fee + 966 * (this.getCreditHours() - 16);
            }
            else{ // 12-16 credits
                tuition += fee;
            }
        }
        else if (fullTime == false){// part-time
            tuition = 966 * this.getCreditHours() + 3268 * 0.8;
        }
        this.setTotalCost(tuition);
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NonResident){
            NonResident input = NonResident.class.cast(obj);
            if (input.fullTime == this.fullTime && this.getProfile().getName().equals(input.getProfile().getName())
                    && this.getProfile().getMajor().equals(input.getProfile().getMajor())){
                return true;
            }
            else{
                return false;
            }
        } return false;
    }

    //Rob Harrison:BA:12 credit hours:tuition due:0.00:total payment:0.00:last payment date: --/--/--:non-resident
    @Override
    public String toString() {
        String pattern = "####,####.##";
        DecimalFormat numberFormat = new DecimalFormat(pattern);
        Date studentDateCheck = super.getDate(); // gets the student date
        String dateString = "";
        if(studentDateCheck == null){
            dateString = "--/--/--";
        }else{
            dateString = this.getDate().getDate();
        }
        String string = this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHours()
                + " credit hours:" + "tuition due:" + numberFormat.format(this.getTotalCost()) + ":" +
                "total payment:" + numberFormat.format(this.getTotalPayment()) + ":" + "last payment date: "
                + dateString + ":" + "non-resident";

        return string;
    }

}