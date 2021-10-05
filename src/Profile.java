public class Profile {
    private String name;
    private Major major; // 5 majors and 2 characters each: CS, IT, BA, EE, ME



    @Override
    public boolean equals(Object obj) {
        Profile input = Profile.class.cast(obj);
        if ((this.name.equals(input.name)) && (this.major == input.major)){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public String toString() {
        return this.name + ":" + this.major; // ????? not sure if this is correct return
    }

    //profile, tution manger, roster
}
