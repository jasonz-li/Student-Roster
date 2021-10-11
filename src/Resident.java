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


    @Override
    public String toString() {  //John Doe:EE:18 credit hours:tuition due:0.00:total payment:0.00:last payment date: --/--/--:resident
        String pattern = "###,##0.00";
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
                + dateString + ":" + "resident";
        System.out.println("**COST!:" + this.getTotalCost());
        return string;
    }

    public void setFinancialAidPaid(boolean bool) {this.financialAidPaid = bool;}

    public boolean getFinancialAidPaid() {return this.financialAidPaid;}
}