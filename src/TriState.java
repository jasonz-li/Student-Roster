import java.util.Locale;

public class TriState extends NonResident{
    boolean livesInCT;
    boolean livesInNY;

    public TriState(Profile profile, int credits, String state){
        super(profile);
        if (state.toUpperCase().equals("NY")){
            this.livesInCT = false;
            this.livesInNY = true;
        }
        else{
            this.livesInCT = true;
            this.livesInNY = false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        TriState input = TriState.class.cast(obj);
        if (input.livesInNY == this.livesInNY && input.livesInCT == this.livesInCT){ // add this.profile.equals???
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
