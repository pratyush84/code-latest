package com.learn.hackerrank;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSorting {

    public static void main(String[] args) {
        Player[] players = new Player[5];
        players[0] = new Player("amy",100);
        players[1] = new Player("david",100);
        players[2] = new Player("heraldo",50);
        players[3] = new Player("aakanksha",75);
        players[4] = new Player("aleksa",150);


        Checker checker = new Checker();
        Arrays.sort(players,checker);
        System.out.println(Arrays.toString(players));
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    static class Checker implements Comparator<Player> {
        // complete this method
        public int compare(Player a, Player b) {
            int compInt = 0;
            if(a.score < b.score){
                compInt = 1;
            } else if(a.score > b.score){
                compInt = -1;
            } else {
                compInt = a.name.compareToIgnoreCase(b.name);
            }

            return compInt;
        }


    }
}
