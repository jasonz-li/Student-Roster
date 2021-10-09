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
    public String toString() {
        String string = this.getProfile().toString() + ", " + this.getCreditHours();
        return string;
    }

}
