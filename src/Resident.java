public class Resident extends Student {
    //john
    int creditHours;
    double financialAid = 0;
    double totalCost = 0;
    double payment = 0;

    public Resident (String name, String major, int creditHours){
        super(name, major);
        this.creditHours = creditHours;

    }
    public void tuitionDue() {
        double tuition = 12536;
        double partTimeCreditRate = 404;
        double universityFee = 3268;
        int creditsOver16 = 0;
        if(this.creditHours < 12 && this.creditHours >= 3) {     //part-time
            totalCost = this.creditHours * partTimeCreditRate + (universityFee * 0.8);
        }else if(this.creditHours >= 12 && this.creditHours <= 24 ){              //full time
            if(creditHours > 16){
                creditsOver16 = creditHours - 16;
            }
            totalCost = tuition + creditsOver16 * partTimeCreditRate + universityFee;
        }else{
            //improper hours
        }
    }

    public boolean setFinancialAid(double aid) {
        if (aid < 10000 && aid >= 0) {
            this.financialAid = aid;
            return true;
        } else {
            return false;
        }
    }

}
