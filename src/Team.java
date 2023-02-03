import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Team implements Toss{
    public String statusOfTheTeam = "";
    public String teamName;
    public ArrayList<Player> playersOfTheTeam = new ArrayList<Player>();
    public int TotalScore = 0;
    public double overPlayed;
    public int wicketsDown = 0;

    public Team(String teamName){
        this.teamName = teamName;
    }

    public int tossTheCoin(){
        return ThreadLocalRandom.current().nextInt(1, 3);
    }

    public int callForHeadOrTail(){
        return ThreadLocalRandom.current().nextInt(1, 3);
    }
}
