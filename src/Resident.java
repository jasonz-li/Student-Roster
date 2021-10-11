import java.text.DecimalFormat;

public class Resident extends Student {
    //john
    private double financialAid = 0;
    private boolean financialAidPaid = false;


    public Resident (String name, String major, int creditHours){
        super(name, major, creditHours);

    }
    public void tuitionDue() {
        double tuition = 12536;
        double partTimeCreditRate = 404;
        double universityFee = 3268;
        int creditsOver16 = 0;
        if(super.getCreditHours() < 12 && super.getCreditHours() >= 3) {     //part-time
            setTotalCost(super.getCreditHours() * partTimeCreditRate + (universityFee * 0.8));
        }else if(super.getCreditHours() >= 12 && super.getCreditHours() <= 24 ){              //full time
            if(super.getCreditHours() > 16){
                creditsOver16 = super.getCreditHours() - 16;
            }
            setTotalCost(tuition + creditsOver16 * partTimeCreditRate + universityFee);
        }else{
            //improper hours
        }
    }

    public boolean setFinancialAid(double aid) {
        if (aid < 10000 && aid >= 0) {
            this.financialAid = aid;
            if(super.getTotalCost() < financialAid){
                setTotalCost(0);
            }else{
                setTotalCost(super.getTotalCost() - financialAid);
            }
            return true;
        } else {
            return false;
        }
    }

    //equals?


    @Override
    public String toString() {  //John Doe:EE:18 credit hours:tuition due:0.00:total payment:0.00:last payment date: --/--/--:resident
        String pattern = "####,####.##";
        DecimalFormat numberFormat = new DecimalFormat(pattern);
        String dateString = super.getDate().getDate(); // gets the student date and calls the Date file getDate()
        if(this.getDate() == null){
            dateString = "--/--/--";
        }
        String string = this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHours()
                + " credit hours:" + "tuition due:" + numberFormat.format(this.getTotalCost()) + ":" +
                "total payment:" + numberFormat.format(this.getTotalPayment()) + ":" + "last payment date: "
                + dateString + ":" + "resident";

        return string;
    }

    public void setFinancialAidPaid(Boolean bool) {this.financialAidPaid = bool;}

    public Boolean getFinancialAidPaid() {return this.financialAidPaid;}
}