public class International extends NonResident{
    boolean studyingAbroad;

    public International(String name, String major, int credits, boolean studyingAbroad){
        super(name, major, credits);
        this.studyingAbroad = studyingAbroad;
    }

    public void tuitionDue() {
        double tuition = 29737;
        double fee = 3268;
        double extraFee = 2650;
        if (studyingAbroad == true){ // student is studying abroad
            tuition = fee + 2650;
        }
        else{ // full-time tuition regular
            if (this.getCreditHours() > 16){
                tuition += fee + extraFee + 966 * this.getCreditHours();
            }
            else{
                tuition += fee + extraFee;
            }
        }
        this.setTotalCost(tuition);
    }

    @Override
    public boolean equals(Object obj) {
        International input = International.class.cast(obj);
        if (input.studyingAbroad == this.studyingAbroad
                && this.getProfile().getName().equals(input.getProfile().getName())
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