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
        NonResident input = NonResident.class.cast(obj);
        if (input.fullTime == this.fullTime && this.getProfile().getName().equals(input.getProfile().getName())
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
//nonres, tristate, international, roster we do our own methods