public class TriState extends NonResident{
    boolean livesInCT;
    boolean livesInNY;
    int credits;
    double total;

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
            if (this.credits > 16){
                tuition += fee - CTDiscount + 966 * this.credits;
            }
            else{
                tuition += fee - CTDiscount;
            }
        }
        else{ // NY discount
            if (this.credits > 16){
                tuition += fee - NYDiscount + 966 * this.credits;
            }
            else{
                tuition += fee - NYDiscount;
            }
        }
        this.total = tuition;
    }

    @Override
    public boolean equals(Object obj) {
        TriState input = TriState.class.cast(obj);
        if (input.livesInNY == this.livesInNY && input.livesInCT == this.livesInCT && this.profile.getName().equals(profile.getName())
        && this.profile.getMajor().equals(input.profile.getMajor())){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public String toString() {
    }
}
