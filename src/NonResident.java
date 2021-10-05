public class NonResident extends Student{
    boolean fullTime;

    public NonResident(){
        super("NonResident");
    }


    public NonResident(Profile profile, int credits){
        //super(profile, credits);
        this.fullTime = credits >= 12;
    }

    @Override
    public boolean equals(Object obj) { // waiting for super to work
    }


    @Override
    public String toString() {
        return Profile.
    }

}
//nonres, tristate, international, roster we do our own methods
