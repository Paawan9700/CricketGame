
import java.util.ArrayList;

public class GameController {
    private final int teamToTossedTheCoin;
    Team team1, team2;

    int whoPlay = 0;
    CricketGame game;
    int playersInATeam;
    ArrayList<Player> teamplayers1;
    ArrayList<Player> teamplayers2;

    public GameController(int teamToTossedTheCoin, Team team1, Team team2, CricketGame game){
        this.teamToTossedTheCoin = teamToTossedTheCoin;
        this.team1 = team1;
        this.team2 = team2;
        this.game = game;
        this.playersInATeam = game.players;
        this.teamplayers1 = team1.playersOfTheTeam;
        this.teamplayers2 = team2.playersOfTheTeam;
    }

    private void AddPlayers(ArrayList<Player> team, String[] players){
        int isBatsman = 0;
        for(int ind = 0; ind < playersInATeam; ++ind){
            if(ind < playersInATeam / 2) isBatsman = 1;
            team.add(new Player(players[ind], 0, 0, isBatsman));
        }
    }

    public void doTheToss(){
        if(teamToTossedTheCoin == 1){
            int outcomeOnCoin = team1.tossTheCoin();
            int callByOpponent = team2.callForHeadOrTail();

            if(outcomeOnCoin == callByOpponent){
                team1.statusOfTheTeam = "Bowl";
                team2.statusOfTheTeam = "Bat";
            } else {
                team1.statusOfTheTeam = "Bat";
                team2.statusOfTheTeam = "Bowl";
            }

        } else {
            int outcomeOnCoin = team2.tossTheCoin();
            int callByOpponent = team1.callForHeadOrTail();

            if(outcomeOnCoin == callByOpponent){
                team2.statusOfTheTeam = "Bowl";
                team1.statusOfTheTeam = "Bat";
            } else {
                team2.statusOfTheTeam = "Bat";
                team1.statusOfTheTeam = "Bowl";
            }
        }
    }

    public void decideTheTeam(){

        String[] players1 = {"Virat Kohli", "Rohit Sharma", "Hardik Pandya", "KL Rahul", "Rishab Pant", "MS Dhoni", "Dinesh Kartik", "Jasprit Bumrah", "Bhuvneshwar Kumar", "Mohammed Shami", "Ravindra Jadega"};
        String[] players2 = {"azam", "shadab", "afridi", "shoaib", "Asif ali", "Amir", "hassan", "wasim", "sohail", "afeez", "usama"};

        AddPlayers(teamplayers1, players1);
        AddPlayers(teamplayers2, players2);
    }


    public void firstInnings(){
        whoPlay = team1.statusOfTheTeam.equals("Bat") ? 1 : 2;
        Playing matchStarted = new Playing(team1, team2, game.overs, game.players, whoPlay);
        matchStarted.play();
    }

    public void secondInnings(){
        whoPlay = team1.statusOfTheTeam.equals("Bowl") ? 1 : 2;
        Playing matchStarted = new Playing(team1, team2, game.overs, game.players, whoPlay);
        matchStarted.play();
    }

}
