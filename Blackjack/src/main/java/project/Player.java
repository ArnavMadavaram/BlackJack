//package project;
//
//import java.util.ArrayList;
//
//public class Player {
//    public static Deck deck = new Deck();
//    ArrayList<Card> hand = new ArrayList<>();
//    private int currency;
//
//    int wins;
//    public Player(){
//        hand = new ArrayList<>();
//        wins = 0;
//        currency = 100;
//
//    }
//    public ArrayList<Card> getHand(){
//        return hand;
//
//    }
//    int valueOfHand(){
//        int total = 0;
//        int noOfAces = 0;
//        for (Card card: hand){
//            total += card.valueOf();
//            if(card.getFaces().equals("A")){
//                noOfAces++;
//            }
//        }
//        while(total > 21 && noOfAces > 0){
//            total -= 10;
//            noOfAces--;
//        }
//        return total;
//    }
//    void clearHand(){
//        hand.clear();
//    }
//
//    boolean stand (int otherPlayerValue){
//        int playerValue = valueOfHand();
//
//        if(playerValue > otherPlayerValue){
//            return true;
//        } else if (playerValue == otherPlayerValue && playerValue >= 16) {
//            return Math.random() < 0.5;
//        } else {
//            return false;
//        }
//    }
//    boolean busted(){
//        return valueOfHand() > 21;
//    }
//    public void hit(){
//        hand.add(deck.dealCard());
//    }
//    int getWins(){
//        wins++;
//        return wins;
//    }
//    public int getCurrency() {
//       return currency;
//    }
//
//    public void adjustCurrency(int amount) {
//        currency += amount;
//    }
//    public void setWins(int wins) {
//        this.wins = wins;
//    }
//
//}
//package project;
//import java.util.ArrayList;
//
//public class Player {
//    private static final Deck deck = new Deck();
//    private final ArrayList<Card> hand = new ArrayList<>();
//    private int wins = 0;
//    private int currency = 100; // Default currency
//
//    public Player() {}
//
//    public ArrayList<Card> getHand() {
//        return hand;
//    }
//
//    public int valueOfHand() {
//        int total = 0, aces = 0;
//        for (Card card : hand) {
//            int value = card.valueOf();
//            if (value == 11) aces++;
//            total += value;
//        }
//        while (total > 21 && aces > 0) {
//            total -= 10;
//            aces--;
//        }
//        return total;
//    }
//
//    public void clearHand() {
//        hand.clear();
//    }
//
//    public void hit() {
//        hand.add(deck.dealCard());
//    }
//
//    public boolean busted() {
//        return valueOfHand() > 21;
//    }
//
//    public boolean stand(int otherPlayerValue) {
//        int value = valueOfHand();
//        if (value > otherPlayerValue) return true;
//        return value >= 16 && Math.random() < 0.5;
//    }
//
//    public void addWin(int i) {
//        wins++;
//    }
//
//    public int getWins() {
//        return wins;
//    }
//
//    public int getCurrency() {
//        return currency;
//    }
//
//    public void adjustCurrency(int amount) {
//        currency += amount;
//    }
//}
package project;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private int wins;
    private int currency = 100;
    private static Deck deck = new Deck();

    public Player() {
        hand = new ArrayList<>();
        wins = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int valueOfHand() {
        int total = 0;
        int noOfAces = 0;
        for (Card card : hand) {
            total += card.valueOf();
            if (card.getFaces().equals("A")) {
                noOfAces++;
            }
        }
        while (total > 21 && noOfAces > 0) {
            total -= 10;
            noOfAces--;
        }
        return total;
    }

    public void clearHand() {
        hand.clear();
    }

    public boolean busted() {
        return valueOfHand() > 21;
    }

    public void hit() {
        hand.add(deck.dealCard());
    }

    public int win() {
        wins++;
        return wins;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getCurrency() {
        return currency;
    }

    public void adjustCurrency(int amount) {
        currency += amount;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
}

