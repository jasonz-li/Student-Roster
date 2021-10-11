import java.text.DecimalFormat;

public class TriState extends NonResident{
    boolean livesInCT;
    boolean livesInNY;

    public TriState(String name, String major, int credits, String state){
        super(name, major, credits);
        if (state.toUpperCase().equals("NY")){
            this.livesInCT = false;
            this.livesInNY = true;
        }
        else{
            this.livesInCT = true;
            this.livesInNY = false;
        }
    }

    public void tuitionDue() {
        double tuition = 29737;
        double fee = 3268;
        double NYDiscount = 4000;
        double CTDiscount = 5000;
        if (livesInCT == true){ // CT discount
            if (this.getCreditHours() > 16){
                tuition += fee - CTDiscount + 966 * this.getCreditHours();
            }
            else{
                tuition += fee - CTDiscount;
            }
        }
        else{ // NY discount
            if (this.getCreditHours() > 16){
                tuition += fee - NYDiscount + 966 * this.getCreditHours();
            }
            else{
                tuition += fee - NYDiscount;
            }
        }
        this.setTotalCost(tuition);
    }

    @Override
    public boolean equals(Object obj) {
        TriState input = TriState.class.cast(obj);
        if (input.livesInNY == this.livesInNY && input.livesInCT == this.livesInCT && this.getProfile().getName().equals(input.getProfile().getName())
                && this.getProfile().getMajor().equals(input.getProfile().getMajor())){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public String toString() {  //John Doe:IT:18 credit hours:tuition due:30,937.00:total payment:0.00:last payment date: --/--/--:non-resident(tri-state):NY
        String pattern = "####,####.##";
        DecimalFormat numberFormat = new DecimalFormat(pattern);
        String dateString = super.getDate().getDate(); // gets the student date and calls the Date file getDate()
        if(this.getDate() == null){
            dateString = "--/--/--";
        }
        String CTorNY = "NY";
        if (livesInCT == true) {
            CTorNY = "CT";
        }
        String string = this.getProfile().getName() + ":" + this.getProfile().getMajor() + ":" + this.getCreditHours()
                + " credit hours:" + "tuition due:" + numberFormat.format(this.getTotalCost()) + ":" +
                "total payment:" + numberFormat.format(this.getTotalPayment()) + ":" + "last payment date: "
                + dateString + ":" + "non-resident(tri-state) " + CTorNY;

        return string;
    }

}