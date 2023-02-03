public class Player {
    public String name = "";
    public int myScore;
    public int wicketsTaken;
    int isBatsman;


    Player(String name, int myScore, int wicketsTaken, int isBatsman){
        this.name = name;
        this.myScore = myScore;
        this.wicketsTaken = wicketsTaken;
        this.isBatsman = isBatsman;
    }
}
