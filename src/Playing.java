public class Playing {
    Team team1;
    Team team2;
    int overs;
    int playersInATeam;
    GenerateRandom throwTheBall;
    int whoPlay;

    public Playing(Team team1, Team team2, int overs, int playersInATeam, int whoPlay) {
        this.team1 = team1;
        this.team2 = team2;
        this.overs = overs;
        this.playersInATeam = playersInATeam;
        this.throwTheBall = new GenerateRandom();
        this.whoPlay = whoPlay;
    }

    private void calculateTotalScore(Team team) {

        for (int i = 0; i < playersInATeam; ++i) {
            team.TotalScore = team.TotalScore + team.playersOfTheTeam.get(i).myScore;
        }
    }

    private void gameStarted(Team team1, Team team2) {
        int overDone = 0;
        int playerNoBatting = 0;
        int playerNoBowling = playersInATeam - 1;
        int overPerHead = overs / 5;

        int ballsThrown = 0, overAlreadyDone = 0;
        while (overDone < overs && playerNoBatting < playersInATeam && playerNoBowling >= 0) {

            int ballsLeftInThisOver = 6;
            while (ballsLeftInThisOver > 0) {
                int outcome = throwTheBall.giveRandomNumber(team1.playersOfTheTeam.get(playerNoBatting).isBatsman);
                if (outcome >= 0 && outcome <= 6) {
                    team1.playersOfTheTeam.get(playerNoBatting).myScore += outcome;
                } else {
                    // this is the wicket
                    team2.playersOfTheTeam.get(playerNoBowling).wicketsTaken += 1;
                    playerNoBatting = playerNoBatting + 1;
                    team1.wicketsDown += 1;
                    if (playerNoBatting >= playersInATeam) break;
                }


                ballsLeftInThisOver = ballsLeftInThisOver - 1;
                ballsThrown = ballsThrown + 1;
            }
            overAlreadyDone += 1;
            if (overAlreadyDone == overPerHead) {
                playerNoBowling -= 1;
                overAlreadyDone = 0;
            }

            overDone = overDone + 1;
        }
        calculateTotalScore(team1);
        int leftBalls = ballsThrown - (ballsThrown / 6) * 6;
        team1.overPlayed = (double) ((ballsThrown / 6) + ((double) leftBalls / 10));
        if(team1.wicketsDown == 11) team1.wicketsDown -= 1;
    }

    public void play() {
        if (whoPlay == 1) {
            gameStarted(team1, team2);
        } else if (whoPlay == 2) {
            gameStarted(team2, team1);
        }
    }
}
