import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of teams to be played:");
        int teamsToBePlayed = sc.nextInt();

        System.out.println("Enter the number of players in one team:");
        int noOfPlayers = sc.nextInt();


        Scanner forTeams = new Scanner(System.in);

        System.out.println("Enter the name of both the teams:");
        String firstTeam = forTeams.nextLine();
        String secondTeam = forTeams.nextLine();

        System.out.println("Enter the number of overs in a inning:");
        int noOfOvers = sc.nextInt();

        CricketGame game = new CricketGame(teamsToBePlayed, noOfPlayers, noOfOvers);
        Team team1 = new Team(firstTeam);
        Team team2 = new Team(secondTeam);

        System.out.println("Enter the team number to toss the Coin:");
        int teamToTossedTheCoin = sc.nextInt();

        GameController gameDecider = new GameController(teamToTossedTheCoin, team1, team2, game);
        gameDecider.decideTheTeam();

        System.out.println("The Toss is happening...");
        Thread.sleep(3000);
        gameDecider.doTheToss();

        // status of the team is decided
        System.out.println(team1.teamName + " has decided to " + team1.statusOfTheTeam + " first");
        System.out.println(team2.teamName + " will have to " + team2.statusOfTheTeam + " first");

        System.out.println("---- Match Started ----");
        Thread.sleep(5000);

        gameDecider.firstInnings();
        gameDecider.secondInnings();


        int scoreByTeam1 = team1.TotalScore;
        int scoreByTeam2 = team2.TotalScore;

        System.out.println(team1.teamName + " has Scored " + team1.TotalScore + " after losing " + team1.wicketsDown + " wickets in " + team1.overPlayed + " overs.");
        System.out.println();
        for(int i = 0; i < team1.playersOfTheTeam.size(); ++i){
            System.out.println(team1.playersOfTheTeam.get(i).name + " has scored " + team1.playersOfTheTeam.get(i).myScore + " and Taken " + team1.playersOfTheTeam.get(i).wicketsTaken + " wickets.");
        }

        System.out.println();
        System.out.println(team2.teamName + " has Scored " + team2.TotalScore + " after losing " + team2.wicketsDown + " wickets in " + team2.overPlayed + " overs.");
        System.out.println();

        for(int i = 0; i < team2.playersOfTheTeam.size(); ++i){
            System.out.println(team2.playersOfTheTeam.get(i).name + " has scored " + team2.playersOfTheTeam.get(i).myScore + " and Taken " + team2.playersOfTheTeam.get(i).wicketsTaken + " wickets.");
        }

        System.out.println("---- Match Ended ----");
        if (scoreByTeam1 > scoreByTeam2) {
            System.out.println(team1.teamName + " WINS.");
        } else if (scoreByTeam1 < scoreByTeam2) {
            System.out.println(team2.teamName + " WINS.");
        } else {
            System.out.println("Match Tied");
        }

    }
}
