public class Profile {

    //John
    private String name;
    private Major major; //5 majors and 2-characters each: CS, IT, BA, EE, ME

    public Profile(String name, String major){
        this.name = name;
        String majorUpperCase = major.toUpperCase();
        this.major = Major.valueOf(majorUpperCase);
    }
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if(o instanceof Profile){
            Profile newProf = (Profile) o;
            if(this.getName().equals(newProf.getName()) && this.getMajor().equals(newProf.getMajor())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return this.name + ", " + this.major.toString();
    }



    public String getName(){
        return this.name;
    }

    public String getMajor(){
        return this.major.toString();
    }
}