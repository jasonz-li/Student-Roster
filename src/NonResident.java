public class NonResident extends Student{
    boolean fullTime;
    int credits;
    double total;



    public NonResident(String name, String major, int credits){
        super(name, major);
        this.fullTime = credits >= 12;
        this.credits = credits;
    }

    public void tuitionDue() {
        double tuition = 29737;
        double fee = 3268;
        if (fullTime == true){ // full-time
            if (this.credits > 16){ // over 16 credit fees
                tuition += fee + 966 * (this.credits - 16);
            }
            else{ // 12-16 credits
                tuition += fee;
            }
        }
        else if (fullTime == false){// part-time
            tuition = 966 * this.credits + 3268 * 0.8;
        }
        this.total = tuition;
    }


    @Override
    public boolean equals(Object obj) {
        NonResident input = NonResident.class.cast(obj);
        if (input.fullTime == this.fullTime && this.profile.getName().equals(profile.getName())
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
//nonres, tristate, international, roster we do our own methods
