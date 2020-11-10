package com.company;

import java.util.*;

public class Main {

    public static int countMatches(ArrayList<String> arrList, String teamName) {
        int amountOfMatches = 0;
        for (Object o : arrList) {
            if (o.equals(teamName)) {
                amountOfMatches++;
            }
        }
        return amountOfMatches;
    }

    public static void main(String[] args) {

        System.out.println("Enter amount of games: ");
        Scanner in = new Scanner(System.in);
        int amountOfGames = in.nextInt();
        String[][] gameResults = new String[amountOfGames][];
        int[] firstTeamGoals = new int[amountOfGames];
        int[] secondTeamGoals = new int[amountOfGames];

        ArrayList<String> winTeamNames = new ArrayList<>();
        ArrayList<String> loseTeamNames = new ArrayList<>();
        ArrayList<String> drawTeamNames = new ArrayList<>();
        HashSet<String> teamNames = new HashSet<>();
        int pointsForWin = 3;
        int pointsForDraw = 1;
        System.out.println("Enter game results in format: team1;goals_by_team1;team2;goals_by_team2");

        for (int i = 0; i < gameResults.length; i++) {
            in = new Scanner(System.in);
            gameResults[i] = in.nextLine().split(";");
        }
        for (int i = 0; i < gameResults.length; i++) {
            teamNames.add(gameResults[i][0]);
            teamNames.add(gameResults[i][2]);
            firstTeamGoals[i] = Integer.parseInt(gameResults[i][1]);
            secondTeamGoals[i] = Integer.parseInt(gameResults[i][3]);
        }
        String[] teamNamesArr = teamNames.toArray(new String[0]);
        for (int i = 0; i < gameResults.length; i++) {
            if (firstTeamGoals[i] > secondTeamGoals[i]) {
                winTeamNames.add(gameResults[i][0]);
                loseTeamNames.add(gameResults[i][2]);
            } else if (firstTeamGoals[i] == secondTeamGoals[i]) {
                drawTeamNames.add(gameResults[i][0]);
                drawTeamNames.add(gameResults[i][2]);
            } else if (firstTeamGoals[i] < secondTeamGoals[i]) {
                winTeamNames.add(gameResults[i][2]);
                loseTeamNames.add(gameResults[i][0]);
            }
        }
        for (String s : teamNamesArr) {
            int allMatches = countMatches(winTeamNames, s) + countMatches(loseTeamNames, s)
                    + countMatches(drawTeamNames, s);
            int points = countMatches(winTeamNames, s) * pointsForWin + countMatches(drawTeamNames, s) * pointsForDraw;
            System.out.println(s + ": " + allMatches + " " + countMatches(winTeamNames, s) +
                    " " + countMatches(drawTeamNames, s) + " " + countMatches(loseTeamNames, s) + " " + points);
        }
    }
}