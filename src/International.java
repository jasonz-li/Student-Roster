public class International extends NonResident{
    boolean studyingAbroad;
    int credits;
    double total;

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
            if (this.credits > 16){
                tuition += fee + extraFee + 966 * this.credits;
            }
            else{
                tuition += fee + extraFee;
            }
        }
        this.total = tuition;
    }

    @Override
    public boolean equals(Object obj) {

    }


    @Override
    public String toString() {

    }



}
